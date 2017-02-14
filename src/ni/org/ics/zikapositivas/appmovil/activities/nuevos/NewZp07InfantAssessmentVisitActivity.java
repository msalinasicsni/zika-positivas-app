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
public class NewZp07InfantAssessmentVisitActivity extends AbstractAsyncActivity {
    protected static final String TAG = NewZp07InfantAssessmentVisitActivity.class.getSimpleName();

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
            Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.error, R.string.storage_error),Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
        settings =
                PreferenceManager.getDefaultSharedPreferences(this);
        username =
                settings.getString(PreferencesActivity.KEY_USERNAME,
                        null);
        String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
        zikaPos = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
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
        TextView message =(TextView) dialogInit.findViewById(R.id.yesnotext);
        if (mInfantAssessment !=null){
            message.setText(getString(R.string.edit)+ " " + getString(R.string.infant_b_1)+"?");
        }
        else{
            message.setText(getString(R.string.add)+ " " + getString(R.string.infant_b_1)+"?");
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
        if(item.getItemId()==R.id.MENU_BACK){
            finish();
            return true;
        }
        else if(item.getItemId()==R.id.MENU_HOME){
            Intent i = new Intent(getApplicationContext(),
                    MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if(requestCode == ADD_ZP07_ODK ||requestCode == EDIT_ZP07_ODK) {
            if(resultCode == RESULT_OK) {
                Uri instanceUri = intent.getData();
                //Busca la instancia resultado
                String[] projection = new String[] {
                        "_id","instanceFilePath", "status","displaySubtext"};
                Cursor c = getContentResolver().query(instanceUri, projection,
                        null, null, null);
                c.moveToFirst();
                //Captura la id de la instancia y la ruta del archivo para agregarlo al participante
                Integer idInstancia = c.getInt(c.getColumnIndex("_id"));
                String instanceFilePath = c.getString(c.getColumnIndex("instanceFilePath"));
                String complete = c.getString(c.getColumnIndex("status"));
                //cierra el cursor
                if (c != null) {
                    c.close();
                }
                if (complete.matches("complete")){
                    //Parsear el resultado obteniendo un tamizaje si esta completo
                    parseZp07InfantAssessmentVisit(idInstancia, instanceFilePath, accion);
                }
                else{
                    Toast.makeText(getApplicationContext(),	getString(R.string.err_not_completed), Toast.LENGTH_LONG).show();
                }
            }
            else{
            	finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    private void addZp07InfantAssessmentVisit() {
        try{
            Uri formUri;
            if(mInfantAssessment ==null){
                //campos de proveedor de collect
                String[] projection = new String[] {
                        "_id","jrFormId","displayName"};
                //cursor que busca el formulario
                Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
                        "jrFormId = 'ZPos07_Infant_Assessment' and displayName = 'Zika Positivas Visita de evaluacion al infante'", null, null);
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
            }
            else{
                //forma el uri para la instancia en ODK Collect
                Integer id = mInfantAssessment.getIdInstancia();
                formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
                accion = EDIT_ZP07_ODK;
            }
            //Arranca la actividad ODK Collect en busca de resultado
            Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
            startActivityForResult(odkA, accion);
        }
        catch(Exception e){
            //No existe el formulario en el equipo
            Log.e(TAG, e.getMessage(), e);
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void parseZp07InfantAssessmentVisit(Integer idInstancia, String instanceFilePath, Integer accion) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp07InfantAssessmentVisitXml zp07Xml = serializer.read(Zp07InfantAssessmentVisitXml.class, source);
            if (accion== ADD_ZP07_ODK) mInfantAssessment = new Zp07InfantAssessmentVisit();
            mInfantAssessment.setRecordId(mRecordId);
            mInfantAssessment.setRedcapEventName(event);

            mInfantAssessment.setInfantVisitDate(zp07Xml.getInfantVisitDate());
            mInfantAssessment.setInfantStatus(zp07Xml.getInfantStatus());
            mInfantAssessment.setInfantVisit(zp07Xml.getInfantVisit());
            mInfantAssessment.setInfantTemp(zp07Xml.getInfantTemp());
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
            mInfantAssessment.setInfantReferralNeuro(zp07Xml.getInfantReferralNeuro());
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
            mInfantAssessment.setInfantOphthAbno(zp07Xml.getInfantOphthAbno());
            mInfantAssessment.setInfantWhichEye(zp07Xml.getInfantWhichEye());
            mInfantAssessment.setInfantEyeCalci(zp07Xml.getInfantEyeCalci());
            mInfantAssessment.setInfantChoriore(zp07Xml.getInfantChoriore());
            mInfantAssessment.setInfantEyeOther(zp07Xml.getInfantEyeOther());
            mInfantAssessment.setInfantOtherIssue(zp07Xml.getInfantOtherIssue());
            mInfantAssessment.setInfantEyeOtherSpecify(zp07Xml.getInfantEyeOtherSpecify());
            mInfantAssessment.setInfantReferralOphth(zp07Xml.getInfantReferralOphth());
            mInfantAssessment.setInfantOae(zp07Xml.getInfantOae());
            mInfantAssessment.setInfantOaeAbnormal(zp07Xml.getInfantOaeAbnormal());
            mInfantAssessment.setInfantWhichEar(zp07Xml.getInfantWhichEar());
            mInfantAssessment.setInfantReferralAudio(zp07Xml.getInfantReferralAudio());
            mInfantAssessment.setInfantAdditionalAudio(zp07Xml.getInfantAdditionalAudio());
            mInfantAssessment.setInfatnHearLeft(zp07Xml.getInfatnHearLeft());
            mInfantAssessment.setInfantHearRight(zp07Xml.getInfantHearRight());
            mInfantAssessment.setInfantBreastfeeding(zp07Xml.getInfantBreastfeeding());
            mInfantAssessment.setInfantBreastReason(zp07Xml.getInfantBreastReason());
            mInfantAssessment.setInfantBreastOther(zp07Xml.getInfantBreastOther());
            mInfantAssessment.setInfantNeurodeve(zp07Xml.getInfantNeurodeve());
            mInfantAssessment.setInfantNeurodeveType(zp07Xml.getInfantNeurodeveType());
            mInfantAssessment.setInfantOtherSpecify(zp07Xml.getInfantOtherSpecify());
            mInfantAssessment.setInfantExhibited(zp07Xml.getInfantExhibited());
            mInfantAssessment.setInfantOtherMovement(zp07Xml.getInfantOtherMovement());
            mInfantAssessment.setInfantFurtherNeuro(zp07Xml.getInfantFurtherNeuro());
            mInfantAssessment.setInfantHeadAltra(zp07Xml.getInfantHeadAltra());
            mInfantAssessment.setInfantUltraObtained(zp07Xml.getInfantUltraObtained());
            mInfantAssessment.setInfantUltraDt(zp07Xml.getInfantUltraDt());
            mInfantAssessment.setInfantResultsUltra(zp07Xml.getInfantResultsUltra());
            mInfantAssessment.setInfantResultsSpecify(zp07Xml.getInfantResultsSpecify());
            mInfantAssessment.setInfantHeadCt(zp07Xml.getInfantHeadCt());
            mInfantAssessment.setInfantCtObtained(zp07Xml.getInfantCtObtained());
            mInfantAssessment.setInfantCtDt(zp07Xml.getInfantCtDt());
            mInfantAssessment.setInfantResultsCt(zp07Xml.getInfantResultsCt());
            mInfantAssessment.setInfantCtSpecify(zp07Xml.getInfantCtSpecify());
            mInfantAssessment.setInfantCerebrospinal(zp07Xml.getInfantCerebrospinal());
            mInfantAssessment.setInfantCerebroStored(zp07Xml.getInfantCerebroStored());
            mInfantAssessment.setInfantCerebroDt(zp07Xml.getInfantCerebroDt());
            mInfantAssessment.setInfantCerebroAmount(zp07Xml.getInfantCerebroAmount());
            mInfantAssessment.setInfantResultsCerebro(zp07Xml.getInfantResultsCerebro());
            mInfantAssessment.setInfantCerebroSpecify(zp07Xml.getInfantCerebroSpecify());
            mInfantAssessment.setInfantMri(zp07Xml.getInfantMri());
            mInfantAssessment.setInfantMriObtained(zp07Xml.getInfantMriObtained());
            mInfantAssessment.setInfantMriDt(zp07Xml.getInfantMriDt());
            mInfantAssessment.setInfantResultsMri(zp07Xml.getInfantResultsMri());
            mInfantAssessment.setInfantMriSpecify(zp07Xml.getInfantMriSpecify());
            mInfantAssessment.setInfantPreviousResults(zp07Xml.getInfantPreviousResults());
            mInfantAssessment.setInfantReferrCounselling(zp07Xml.getInfantReferrCounselling());
            mInfantAssessment.setInfantOtherLabCollect(zp07Xml.getInfantOtherLabCollect());
            mInfantAssessment.setInfantIdCompleting(zp07Xml.getInfantIdCompleting());
            mInfantAssessment.setInfantDateCompleted(zp07Xml.getInfantDateCompleted());
            mInfantAssessment.setInfantIdReviewer(zp07Xml.getInfantIdReviewer());
            mInfantAssessment.setInfantDateReviewed(zp07Xml.getInfantDateReviewed());
            mInfantAssessment.setInfantIdDataEntry(zp07Xml.getInfantIdDataEntry());
            mInfantAssessment.setInfantDateEntered(zp07Xml.getInfantDateEntered());

            mInfantAssessment.setRecordDate(new Date());
            mInfantAssessment.setRecordUser(username);
            mInfantAssessment.setIdInstancia(idInstancia);
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
                    if (accionaRealizar == ADD_ZP07_ODK){
                        zikaPos.crearZp07InfantAssessmentVisit(mInfantAssessment);
                    }
                    else{
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
        Toast.makeText(getApplicationContext(),	resultado, Toast.LENGTH_LONG).show();
        finish();
    }
}
