package ni.org.ics.zikapositivas.appmovil.activities.nuevos;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp07InfantAssessmentVisit;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp07InfantAssessmentVisitXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;

/**
 * Created by FIRSTICT on 2/2/2017.
 * V1.0
 */
public class NewZp07InfantAssessmentVisitPsyActivity extends AbstractAsyncActivity {
    protected static final String TAG = NewZp07InfantAssessmentVisitPsyActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPos;
    private static Zp07InfantAssessmentVisit mInfantAssessment = null;

    public static final int ADD_ZP07_ODK = 1;
    public static final int EDIT_ZP07_ODK = 2;

    Dialog dialogInit;
    private SharedPreferences settings;
    private String username;
    private String mRecordId = "";
    private Integer accion = 0;
    private String event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!FileUtils.storageReady()) {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.error, R.string.storage_error), Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
        settings =
                PreferenceManager.getDefaultSharedPreferences(this);
        username =
                settings.getString(PreferencesActivity.KEY_USERNAME,
                        null);
        String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
        zikaPos = new ZikaPosAdapter(this.getApplicationContext(), mPass, false, false);
        mRecordId = getIntent().getExtras().getString(Constants.RECORDID);
        mInfantAssessment = (Zp07InfantAssessmentVisit) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP07);
        event = getIntent().getExtras().getString(Constants.EVENT);
        createInitDialog();
    }

    /**
     * Presenta dialogo inicial
     */

    private void createInitDialog() {
        dialogInit = new Dialog(this, R.style.FullHeightDialog);
        dialogInit.setContentView(R.layout.yesno);
        dialogInit.setCancelable(false);

        //to set the message
        TextView message = (TextView) dialogInit.findViewById(R.id.yesnotext);
        if (mInfantAssessment != null) {

            if (mInfantAssessment.getPart3() != null) {
                message.setText(getString(R.string.edit) + " " + getString(R.string.infant_b_4) + "?");
            } else {
                message.setText(getString(R.string.add) + " " + getString(R.string.infant_b_4) + "?");
            }
        } else {
            message.setText(getString(R.string.add) + " " + getString(R.string.infant_b_4) + "?");
        }

        //add some action to the buttons

        Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
        yes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogInit.dismiss();
                addZp07InfantAssessmentVisit();
            }
        });

        Button no = (Button) dialogInit.findViewById(R.id.yesnoNo);
        no.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Cierra
                dialogInit.dismiss();
                finish();
            }
        });
        dialogInit.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.general, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.MENU_BACK) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.MENU_HOME) {
            Intent i = new Intent(getApplicationContext(),
                    MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (requestCode == ADD_ZP07_ODK || requestCode == EDIT_ZP07_ODK) {
            if (resultCode == RESULT_OK) {
                Uri instanceUri = intent.getData();
                //Busca la instancia resultado
                String[] projection = new String[]{
                        "_id", "instanceFilePath", "status", "displaySubtext"};
                Cursor c = getContentResolver().query(instanceUri, projection,
                        null, null, null);
                c.moveToFirst();
                //Captura la id de la instancia y la ruta del archivo para agregarlo al participante
                Integer idInstancia3 = c.getInt(c.getColumnIndex("_id"));
                String instanceFilePath = c.getString(c.getColumnIndex("instanceFilePath"));
                String complete = c.getString(c.getColumnIndex("status"));
                //cierra el cursor
                if (c != null) {
                    c.close();
                }
                if (complete.matches("complete")) {
                    //Parsear el resultado obteniendo un tamizaje si esta completo
                    parseZp07InfantAssessmentVisit(idInstancia3, instanceFilePath, accion);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.err_not_completed), Toast.LENGTH_LONG).show();
                }
            } else {
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    private void addZp07InfantAssessmentVisit() {
        try {
            Uri formUri;
            if (mInfantAssessment == null) {
                //campos de proveedor de collect
                String[] projection = new String[]{
                        "_id", "jrFormId", "displayName"};
                //cursor que busca el formulario
                Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
                        "jrFormId = 'ZPos07_Infant_Assessment_Psychologist' and displayName = 'Zika Positivas Visita de evaluacion al infante'", null, null);
                c.moveToFirst();
                //captura el id del formulario
                Integer id = Integer.parseInt(c.getString(0));
                //cierra el cursor
                if (c != null) {
                    c.close();
                }
                //forma el uri para ODK Collect
                formUri = ContentUris.withAppendedId(Constants.CONTENT_URI, id);
                accion = ADD_ZP07_ODK;
            } else {
                //forma el uri para la instancia en ODK Collect
               /* Integer id = mInfantAssessment.getIdInstancia();
                formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
                accion = EDIT_ZP07_ODK;*/

                //en caso que no  exista un registro de evaluacion de tipo pcicologica
                if (mInfantAssessment.getPart3() == null) {
                    //campos de proveedor de collect
                    String[] projection = new String[]{
                            "_id", "jrFormId", "displayName"};
                    //cursor que busca el formulario
                    Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
                            "jrFormId = 'ZPos07_Infant_Assessment_Psychologist' and displayName = 'Zika Positivas Visita de evaluacion al infante'", null, null);
                    c.moveToFirst();
                    //captura el id del formulario
                    Integer id = Integer.parseInt(c.getString(0));
                    //cierra el cursor
                    if (c != null) {
                        c.close();
                    }
                    //forma el uri para ODK Collect
                    formUri = ContentUris.withAppendedId(Constants.CONTENT_URI, id);
                    accion = EDIT_ZP07_ODK;
                } else {
                    //en caso que exista un registro de evaluacion de tipo pscicologica
                    Integer id = mInfantAssessment.getIdInstancia3();
                    formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I, id);
                    accion = EDIT_ZP07_ODK;
                }

            }
            //Arranca la actividad ODK Collect en busca de resultado
            Intent odkA = new Intent(Intent.ACTION_EDIT, formUri);
            startActivityForResult(odkA, accion);
        } catch (Exception e) {
            //No existe el formulario en el equipo
            Log.e(TAG, e.getMessage(), e);
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void parseZp07InfantAssessmentVisit(Integer idInstancia3, String instanceFilePath, Integer accion) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp07InfantAssessmentVisitXml zp07Xml = serializer.read(Zp07InfantAssessmentVisitXml.class, source);
            if (accion == ADD_ZP07_ODK) mInfantAssessment = new Zp07InfantAssessmentVisit();
            mInfantAssessment.setRecordId(mRecordId);
            mInfantAssessment.setRedcapEventName(event);
            mInfantAssessment.setInfantVisitDate3(zp07Xml.getInfantVisitDate3());
            mInfantAssessment.setInfantStatus3(zp07Xml.getInfantStatus3());
            mInfantAssessment.setInfantDeathDt3(zp07Xml.getInfantDeathDt3());
            mInfantAssessment.setInfantVisit3(zp07Xml.getInfantVisit3());
         /*   mInfantAssessment.setInfantTemp(zp07Xml.getInfantTemp());
            mInfantAssessment.setInfantTmpUnit(zp07Xml.getInfantTmpUnit());
            mInfantAssessment.setInfantWt(zp07Xml.getInfantWt());
            mInfantAssessment.setInfantWtUnit(zp07Xml.getInfantWtUnit());
            mInfantAssessment.setInfantWtPercen(zp07Xml.getInfantWtPercen());
            mInfantAssessment.setInfantWtpercenNa(zp07Xml.getInfantWtpercenNa());
            mInfantAssessment.setInfantLength(zp07Xml.getInfantLength());
            mInfantAssessment.setInfantLengthPercen(zp07Xml.getInfantLengthPercen());
            mInfantAssessment.setInfantLenpercenNa(zp07Xml.getInfantLenpercenNa());
            mInfantAssessment.setInfantHeadcircu(zp07Xml.getInfantHeadcircu());
            mInfantAssessment.setInfantHeapercen(zp07Xml.getInfantHeapercen());
            mInfantAssessment.setInfantHeapercenNa(zp07Xml.getInfantHeapercenNa());
            mInfantAssessment.setInfantHeasize(zp07Xml.getInfantHeasize());
            mInfantAssessment.setInfantApgarNa(zp07Xml.getInfantApgarNa());
            mInfantAssessment.setInfantApgar1min(zp07Xml.getInfantApgar1min());
            mInfantAssessment.setInfantApgar5min(zp07Xml.getInfantApgar5min());
            mInfantAssessment.setInfantSkinEvalu(zp07Xml.getInfantSkinEvalu());
            mInfantAssessment.setInfantRash(zp07Xml.getInfantRash());
            mInfantAssessment.setInfantScarring(zp07Xml.getInfantScarring());
            mInfantAssessment.setInfantOrganEvalu(zp07Xml.getInfantOrganEvalu());
            mInfantAssessment.setInfantAbdominal(zp07Xml.getInfantAbdominal());
            mInfantAssessment.setInfantLiverSpleen(zp07Xml.getInfantLiverSpleen());
            mInfantAssessment.setInfantOphth(zp07Xml.getInfantOphth());
            mInfantAssessment.setInfantOphthType(zp07Xml.getInfantOphthType());
            mInfantAssessment.setInfantOphthAbno(zp07Xml.getInfantOphthAbno());
            mInfantAssessment.setInfantOae(zp07Xml.getInfantOae());
            mInfantAssessment.setInfantHearingTest(zp07Xml.getInfantHearingTest());
            mInfantAssessment.setInfantHearingOverall(zp07Xml.getInfantHearingOverall());
            mInfantAssessment.setInfantRoae(zp07Xml.getInfantRoae());
            mInfantAssessment.setInfantRaabr(zp07Xml.getInfantRaabr());
            mInfantAssessment.setInfantLoae(zp07Xml.getInfantLoae());
            mInfantAssessment.setInfantLaabr(zp07Xml.getInfantLaabr());
            mInfantAssessment.setInfantBreastfeeding(zp07Xml.getInfantBreastfeeding());
            mInfantAssessment.setInfantBreastReason(zp07Xml.getInfantBreastReason());
            mInfantAssessment.setInfantBreastOther(zp07Xml.getInfantBreastOther());
            mInfantAssessment.setInfantNeurodeve(zp07Xml.getInfantNeurodeve());
            mInfantAssessment.setInfantExhibited(zp07Xml.getInfantExhibited());
            mInfantAssessment.setInfantAsymType(zp07Xml.getInfantAsymType());
            mInfantAssessment.setInfantOtherMove(zp07Xml.getInfantOtherMove());
            mInfantAssessment.setInfantExhibitOther(zp07Xml.getInfantExhibitOther());
            mInfantAssessment.setInfantMicroce(zp07Xml.getInfantMicroce());
            mInfantAssessment.setInfantDefinition(zp07Xml.getInfantDefinition());
            mInfantAssessment.setInfantFurtherNeuro(zp07Xml.getInfantFurtherNeuro());*/
            mInfantAssessment.setInfantEvaluation(zp07Xml.getInfantEvaluation());
            mInfantAssessment.setInfantNeuroAsq(zp07Xml.getInfantNeuroAsq());
            mInfantAssessment.setInfantAsqCommuni(zp07Xml.getInfantAsqCommuni());
            mInfantAssessment.setInfantAsqGross(zp07Xml.getInfantAsqGross());
            mInfantAssessment.setInfantAsqFine(zp07Xml.getInfantAsqFine());
            mInfantAssessment.setInfantAsqProblem(zp07Xml.getInfantAsqProblem());
            mInfantAssessment.setInfantAsqPersonal(zp07Xml.getInfantAsqPersonal());
            mInfantAssessment.setInfantNeuroBisd(zp07Xml.getInfantNeuroBisd());
            mInfantAssessment.setInfantCgScore(zp07Xml.getInfantCgScore());
            mInfantAssessment.setInfantCgRisk(zp07Xml.getInfantCgRisk());
            mInfantAssessment.setInfantRpScore(zp07Xml.getInfantRpScore());
            mInfantAssessment.setInfantRpRisk(zp07Xml.getInfantRpRisk());
            mInfantAssessment.setInfantEpScore(zp07Xml.getInfantEpScore());
            mInfantAssessment.setInfantEpRisk(zp07Xml.getInfantEpRisk());
            mInfantAssessment.setInfantFmScore(zp07Xml.getInfantFmScore());
            mInfantAssessment.setInfantFmRisk(zp07Xml.getInfantFmRisk());
            mInfantAssessment.setInfantGmScore(zp07Xml.getInfantGmScore());
            mInfantAssessment.setInfantGmRisk(zp07Xml.getInfantGmRisk());
            mInfantAssessment.setInfantNeuroOther(zp07Xml.getInfantNeuroOther());
            mInfantAssessment.setInfantOtherName(zp07Xml.getInfantOtherName());
            mInfantAssessment.setInfantOtherScore(zp07Xml.getInfantOtherScore());
            mInfantAssessment.setInfantResultScreening(zp07Xml.getInfantResultScreening());
            mInfantAssessment.setInfantReferTesting(zp07Xml.getInfantReferTesting());
         /*   mInfantAssessment.setInfantFeverSymptom(zp07Xml.getInfantFeverSymptom());
            mInfantAssessment.setInfantRashSymptom(zp07Xml.getInfantRashSymptom());
            mInfantAssessment.setInfantItch(zp07Xml.getInfantItch());
            mInfantAssessment.setInfantRashFirst(zp07Xml.getInfantRashFirst());
            mInfantAssessment.setInfantRashDy(zp07Xml.getInfantRashDy());
            mInfantAssessment.setInfantRashMn(zp07Xml.getInfantRashMn());
            mInfantAssessment.setInfantRashYr(zp07Xml.getInfantRashYr());
            mInfantAssessment.setInfantRashDur(zp07Xml.getInfantRashDur());
            mInfantAssessment.setInfantRashSpread(zp07Xml.getInfantRashSpread());
            mInfantAssessment.setInfantSpreadPart(zp07Xml.getInfantSpreadPart());
            mInfantAssessment.setInfantFeverExperience(zp07Xml.getInfantFeverExperience());
            mInfantAssessment.setInfantTempMeasure(zp07Xml.getInfantTempMeasure());
            mInfantAssessment.setInfantHighTemp(zp07Xml.getInfantHighTemp());
            mInfantAssessment.setInfantHightemUnit(zp07Xml.getInfantHightemUnit());
            mInfantAssessment.setInfantTempunknown(zp07Xml.getInfantTempunknown());
            mInfantAssessment.setInfantFeverDy(zp07Xml.getInfantFeverDy());
            mInfantAssessment.setInfantFeverMn(zp07Xml.getInfantFeverMn());
            mInfantAssessment.setInfantFeverYr(zp07Xml.getInfantFeverYr());
            mInfantAssessment.setInfantFeverDur(zp07Xml.getInfantFeverDur());
            mInfantAssessment.setInfantRedeyes(zp07Xml.getInfantRedeyes());
            mInfantAssessment.setInfantRedeyesDy(zp07Xml.getInfantRedeyesDy());
            mInfantAssessment.setInfantRedeyesMn(zp07Xml.getInfantRedeyesMn());
            mInfantAssessment.setInfantRedeyesYr(zp07Xml.getInfantRedeyesYr());
            mInfantAssessment.setInfantRedeyesDur(zp07Xml.getInfantRedeyesDur());
            mInfantAssessment.setInfantJoint(zp07Xml.getInfantJoint());
            mInfantAssessment.setInfantJointDy(zp07Xml.getInfantJointDy());
            mInfantAssessment.setInfantJointMn(zp07Xml.getInfantJointMn());
            mInfantAssessment.setInfantJointYr(zp07Xml.getInfantJointYr());
            mInfantAssessment.setInfantJointDur(zp07Xml.getInfantJointDur());
            mInfantAssessment.setInfantHeadache(zp07Xml.getInfantHeadache());
            mInfantAssessment.setInfantHeadacheDy(zp07Xml.getInfantHeadacheDy());
            mInfantAssessment.setInfantHeadacheMn(zp07Xml.getInfantHeadacheMn());
            mInfantAssessment.setInfantHeadacheYr(zp07Xml.getInfantHeadacheYr());
            mInfantAssessment.setInfantHeadaDur(zp07Xml.getInfantHeadaDur());
            mInfantAssessment.setInfantSymptomOther(zp07Xml.getInfantSymptomOther());
            mInfantAssessment.setInfantSpecifySymptom(zp07Xml.getInfantSpecifySymptom());
            mInfantAssessment.setInfantOtherSymptom(zp07Xml.getInfantOtherSymptom());
            mInfantAssessment.setInfantMedicare(zp07Xml.getInfantMedicare());
            mInfantAssessment.setInfantCareDy(zp07Xml.getInfantCareDy());
            mInfantAssessment.setInfantCareDy(zp07Xml.getInfantCareDy());
            mInfantAssessment.setInfantCareMn(zp07Xml.getInfantCareMn());
            mInfantAssessment.setInfantCareYr(zp07Xml.getInfantCareYr());
            mInfantAssessment.setInfantCareFacility(zp07Xml.getInfantCareFacility());
            mInfantAssessment.setInfantHospitalized(zp07Xml.getInfantHospitalized());
            mInfantAssessment.setInfantHospital(zp07Xml.getInfantHospital());
            mInfantAssessment.setInfantDiagRubella(zp07Xml.getInfantDiagRubella());
            mInfantAssessment.setInfantDiagDengue(zp07Xml.getInfantDiagDengue());
            mInfantAssessment.setInfantDiagChikung(zp07Xml.getInfantDiagChikung());
            mInfantAssessment.setInfantDiagZika(zp07Xml.getInfantDiagZika());
            mInfantAssessment.setInfantDiagCytome(zp07Xml.getInfantDiagCytome());
            mInfantAssessment.setInfantMedicine(zp07Xml.getInfantMedicine());
            mInfantAssessment.setInfantMedName(zp07Xml.getInfantMedName());
            mInfantAssessment.setInfantSpDiary(zp07Xml.getInfantSpDiary());
            mInfantAssessment.setInfantPreResults(zp07Xml.getInfantPreResults());
            mInfantAssessment.setInfantReferr(zp07Xml.getInfantReferr());
            mInfantAssessment.setInfantOtherLab(zp07Xml.getInfantOtherLab());*/
            mInfantAssessment.setInfantCommentsYn3(zp07Xml.getInfantCommentsYn3());
            mInfantAssessment.setInfantComments2_3(zp07Xml.getInfantComments2_3());
            mInfantAssessment.setInfantIdCompleting3(username);
            mInfantAssessment.setInfantDtComp3(new Date());
            mInfantAssessment.setInfantIdReviewer3(username);
            mInfantAssessment.setInfantDtReview3(new Date());
            mInfantAssessment.setInfantIdDataEntry3(username);
            mInfantAssessment.setInfantDtEnter3(new Date());
            mInfantAssessment.setPart3(1);
            mInfantAssessment.setIdInstancia3(idInstancia3);


            mInfantAssessment.setRecordDate(new Date());
            mInfantAssessment.setRecordUser(username);
            mInfantAssessment.setInstancePath(instanceFilePath);
            mInfantAssessment.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mInfantAssessment.setStart(zp07Xml.getStart());
            mInfantAssessment.setEnd(zp07Xml.getEnd());
            mInfantAssessment.setDeviceid(zp07Xml.getDeviceid());
            mInfantAssessment.setSimserial(zp07Xml.getSimserial());
            mInfantAssessment.setPhonenumber(zp07Xml.getPhonenumber());
            mInfantAssessment.setToday(zp07Xml.getToday());


            new SaveDataTask().execute(accion);

        } catch (Exception e) {
            // Presenta el error al parsear el xml
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
            finish();
        }
    }

    // ***************************************
    // Private classes
    // ***************************************
    private class SaveDataTask extends AsyncTask<Integer, Void, String> {
        private Integer accionaRealizar = null;

        @Override
        protected void onPreExecute() {
            // before the request begins, show a progress indicator
            showLoadingProgressDialog();
        }

        @Override
        protected String doInBackground(Integer... values) {
            try {
                accionaRealizar = values[0];
                try {
                    zikaPos.open();
                    if (accionaRealizar == ADD_ZP07_ODK) {
                        zikaPos.crearZp07InfantAssessmentVisit(mInfantAssessment);
                    } else {
                        zikaPos.editarZp07InfantAssessmentVisit(mInfantAssessment);
                    }
                    zikaPos.close();
                } catch (Exception e) {
                    Log.e(TAG, e.getLocalizedMessage(), e);
                    return "error";
                }
                return "exito";
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
                return "error";
            }
        }

        protected void onPostExecute(String resultado) {
            // after the network request completes, hide the progress indicator
            dismissProgressDialog();
            showResult(resultado);
        }

    }

    // ***************************************
    // Private methods
    // ***************************************
    private void showResult(String resultado) {
        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        finish();
    }
}
