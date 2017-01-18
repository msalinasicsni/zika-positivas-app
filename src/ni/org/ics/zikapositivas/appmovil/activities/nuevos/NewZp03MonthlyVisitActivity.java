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
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp03MonthlyVisit;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp03MonthlyVisitXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.R;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;

/**
 * Created by FIRSTICT on 10/31/2016.
 * V1.0
 */
public class NewZp03MonthlyVisitActivity extends AbstractAsyncActivity {

    protected static final String TAG = NewZp03MonthlyVisitActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPosA;
    private static Zp03MonthlyVisit mZp03 = new Zp03MonthlyVisit();

	public static final int ADD_ZP03_ODK = 1;
	public static final int EDIT_ZP03_ODK = 2;

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
        zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
        mRecordId = getIntent().getExtras().getString(Constants.RECORDID);
        event = getIntent().getExtras().getString(Constants.EVENT);
        mZp03 = (Zp03MonthlyVisit) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP03);
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
        if (mZp03!=null){
            message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_5)+"?");
        }
        else{
            message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_5)+"?");
        }

        //add some action to the buttons

        Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
        yes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogInit.dismiss();
                addZp03MonthlyVisit();
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
    	if(requestCode == ADD_ZP03_ODK||requestCode == EDIT_ZP03_ODK) {
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
                    parseZp03MonthlyVisit(idInstancia, instanceFilePath);
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

    private void addZp03MonthlyVisit() {
        try{
        	Uri formUri;
			if(mZp03==null){
	            //campos de proveedor de collect
	            String[] projection = new String[] {
	                    "_id","jrFormId","displayName"};
	            //cursor que busca el formulario
	            Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
	                    "jrFormId = 'ZPos03_Monthly_Visit' and displayName = 'Zika Positivas Visita Cuestionario Mensual'", null, null);
	            c.moveToFirst();
	          //captura el id del formulario
	            Integer id = Integer.parseInt(c.getString(0));
	            //cierra el cursor
	            if (c != null) {
	                c.close();
	            }
	            formUri = ContentUris.withAppendedId(Constants.CONTENT_URI, id);
	            accion = ADD_ZP03_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mZp03.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP03_ODK;
			}
			Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
			//Arranca la actividad proveedor de instancias de ODK Collect en busca de resultado
			startActivityForResult(odkA, accion);
        }
        catch(Exception e){
            //No existe el formulario en el equipo
            Log.e(TAG, e.getMessage(), e);
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void parseZp03MonthlyVisit(Integer idInstancia, String instanceFilePath) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp03MonthlyVisitXml zp03Xml = serializer.read(Zp03MonthlyVisitXml.class, source);
            if (accion==ADD_ZP03_ODK) mZp03 = new Zp03MonthlyVisit();
            mZp03.setRecordId(mRecordId);
            mZp03.setRedcapEventName(event);
            mZp03.setMonVisitDate(zp03Xml.getMonVisitDate());
            mZp03.setMonVisitType(zp03Xml.getMonVisitType());
            mZp03.setMonReasonMissed(zp03Xml.getMonReasonMissed());
            mZp03.setMonOtherReschedu(zp03Xml.getMonOtherReschedu());
            mZp03.setMonReasonUnscheduled(zp03Xml.getMonReasonUnscheduled());
            mZp03.setMonOtherUnscheduled(zp03Xml.getMonOtherUnscheduled());
            mZp03.setMonMotherWt(zp03Xml.getMonMotherWt());
            mZp03.setMonWtUnit(zp03Xml.getMonWtUnit());
            mZp03.setMonSystolic(zp03Xml.getMonSystolic());
            mZp03.setMonDiastolic(zp03Xml.getMonDiastolic());
            mZp03.setMonTemperature(zp03Xml.getMonTemperature());
            mZp03.setMonTempUnit(zp03Xml.getMonTempUnit());
            mZp03.setMonPregnancyLoss(zp03Xml.getMonPregnancyLoss());
            mZp03.setMonDateLoss(zp03Xml.getMonDateLoss());
            mZp03.setMonPersisHeadache(zp03Xml.getMonPersisHeadache());
            mZp03.setMonDizziness(zp03Xml.getMonDizziness());
            mZp03.setMonNausea(zp03Xml.getMonNausea());
            mZp03.setMonVomiting(zp03Xml.getMonVomiting());
            mZp03.setMonLights(zp03Xml.getMonLights());
            mZp03.setMonLightsSpecify(zp03Xml.getMonLightsSpecify());
            mZp03.setMonSwelling(zp03Xml.getMonSwelling());
            mZp03.setMonFetalMovement(zp03Xml.getMonFetalMovement());
            mZp03.setMonMoveUsual(zp03Xml.getMonMoveUsual());
            mZp03.setMonMoveDecrease(zp03Xml.getMonMoveDecrease());
            mZp03.setMonContractions(zp03Xml.getMonContractions());
            mZp03.setMonContractWeek(zp03Xml.getMonContractWeek());
            mZp03.setMonContractDay(zp03Xml.getMonContractDay());
            mZp03.setMonContractHour(zp03Xml.getMonContractHour());
            mZp03.setMonContract10min(zp03Xml.getMonContract10min());
            mZp03.setMonVaginalDischarge(zp03Xml.getMonVaginalDischarge());
            mZp03.setMonCharacDischarge(zp03Xml.getMonCharacDischarge());
            mZp03.setMonBleeding(zp03Xml.getMonBleeding());
            mZp03.setMonBleedingCharac(zp03Xml.getMonBleedingCharac());
            mZp03.setMonUtiTold(zp03Xml.getMonUtiTold());
            mZp03.setMonPrenatalDay(zp03Xml.getMonPrenatalDay());
            mZp03.setMonPrenatalMonth(zp03Xml.getMonPrenatalMonth());
            mZp03.setMonPrenatalYear(zp03Xml.getMonPrenatalYear());
            mZp03.setMonFeverSymptom(zp03Xml.getMonFeverSymptom());
            mZp03.setMonRash(zp03Xml.getMonRash());
            mZp03.setMonItch(zp03Xml.getMonItch());
            mZp03.setMonRashFirst(zp03Xml.getMonRashFirst());
            mZp03.setMonRashDay(zp03Xml.getMonRashDay());
            mZp03.setMonRashMonth(zp03Xml.getMonRashMonth());
            mZp03.setMonRashYear(zp03Xml.getMonRashYear());
            mZp03.setMonRashDuration(zp03Xml.getMonRashDuration());
            mZp03.setMonRashSpread(zp03Xml.getMonRashSpread());
            mZp03.setMonSpreadPart(zp03Xml.getMonSpreadPart());
            mZp03.setMonFeverExperience(zp03Xml.getMonFeverExperience());
            mZp03.setMonTempMeasure(zp03Xml.getMonTempMeasure());
            mZp03.setMonHighTemp(zp03Xml.getMonHighTemp());
            mZp03.setMonHightemUnit(zp03Xml.getMonHightemUnit());
            mZp03.setMonTempunknown(zp03Xml.getMonTempunknown());
            mZp03.setMonFeverDay(zp03Xml.getMonFeverDay());
            mZp03.setMonFeverMonth(zp03Xml.getMonFeverMonth());
            mZp03.setMonFeverYear(zp03Xml.getMonFeverYear());
            mZp03.setMonFeverDuration(zp03Xml.getMonFeverDuration());
            mZp03.setMonRedeyes(zp03Xml.getMonRedeyes());
            mZp03.setMonRedeyesDay(zp03Xml.getMonRedeyesDay());
            mZp03.setMonRedeyesMonth(zp03Xml.getMonRedeyesMonth());
            mZp03.setMonRedeyesYear(zp03Xml.getMonRedeyesYear());
            mZp03.setMonRedeyesDuration(zp03Xml.getMonRedeyesDuration());
            mZp03.setMonJoint(zp03Xml.getMonJoint());
            mZp03.setMonJointDay(zp03Xml.getMonJointDay());
            mZp03.setMonJointMonth(zp03Xml.getMonJointMonth());
            mZp03.setMonJointYear(zp03Xml.getMonJointYear());
            mZp03.setMonJointDuration(zp03Xml.getMonJointDuration());
            mZp03.setMonHeadache(zp03Xml.getMonHeadache());
            mZp03.setMonHeadacheDay(zp03Xml.getMonHeadacheDay());
            mZp03.setMonHeadacheMonth(zp03Xml.getMonHeadacheMonth());
            mZp03.setMonHeadacheYear(zp03Xml.getMonHeadacheYear());
            mZp03.setMonHeadacheDuration(zp03Xml.getMonHeadacheDuration());
            mZp03.setMonSymptomOther(zp03Xml.getMonSymptomOther());
            mZp03.setMonSpecifySymptom(zp03Xml.getMonSpecifySymptom());
            mZp03.setMonOtherSymptom(zp03Xml.getMonOtherSymptom());
            mZp03.setMonMedicare(zp03Xml.getMonMedicare());
            mZp03.setMonCareDay(zp03Xml.getMonCareDay());
            mZp03.setMonCareMonth(zp03Xml.getMonCareMonth());
            mZp03.setMonCareYear(zp03Xml.getMonCareYear());
            mZp03.setMonCareFacility(zp03Xml.getMonCareFacility());
            mZp03.setMonHospitalized(zp03Xml.getMonHospitalized());
            mZp03.setMonHospital(zp03Xml.getMonHospital());
            mZp03.setMonDiagRubella(zp03Xml.getMonDiagRubella());
            mZp03.setMonDiagDengue(zp03Xml.getMonDiagDengue());
            mZp03.setMonDiagChikung(zp03Xml.getMonDiagChikung());
            mZp03.setMonDiagZika(zp03Xml.getMonDiagZika());
            mZp03.setMonDiagCytome(zp03Xml.getMonDiagCytome());
            mZp03.setMonMedicine(zp03Xml.getMonMedicine());
            mZp03.setMonMedcineName(zp03Xml.getMonMedcineName());
            mZp03.setMonSymptomDiary(zp03Xml.getMonSymptomDiary());
            mZp03.setMonGuillainbarre(zp03Xml.getMonGuillainbarre());
            mZp03.setMonTingling(zp03Xml.getMonTingling());
            mZp03.setMonTinglingArm(zp03Xml.getMonTinglingArm());
            mZp03.setMonTinglingLeg(zp03Xml.getMonTinglingLeg());
            mZp03.setMonTinglingHand(zp03Xml.getMonTinglingHand());
            mZp03.setMonTinglingFoot(zp03Xml.getMonTinglingFoot());
            mZp03.setMonTinglingFace(zp03Xml.getMonTinglingFace());
            mZp03.setMonTinglingOther(zp03Xml.getMonTinglingOther());
            mZp03.setMonSensationMin(zp03Xml.getMonSensationMin());
            mZp03.setMonSensationHr(zp03Xml.getMonSensationHr());
            mZp03.setMonSenstaionDay(zp03Xml.getMonSenstaionDay());
            mZp03.setMonInjury(zp03Xml.getMonInjury());
            mZp03.setMonTinglingDay(zp03Xml.getMonTinglingDay());
            mZp03.setMonTinglingMonth(zp03Xml.getMonTinglingMonth());
            mZp03.setMonTinglingYear(zp03Xml.getMonTinglingYear());
            mZp03.setMonTinglingDuration(zp03Xml.getMonTinglingDuration());
            mZp03.setMonNumbness(zp03Xml.getMonNumbness());
            mZp03.setMonNumbArm(zp03Xml.getMonNumbArm());
            mZp03.setMonNumbLeg(zp03Xml.getMonNumbLeg());
            mZp03.setMonNumbHand(zp03Xml.getMonNumbHand());
            mZp03.setMonNumbFoot(zp03Xml.getMonNumbFoot());
            mZp03.setMonNumbFace(zp03Xml.getMonNumbFace());
            mZp03.setMonNumbOther(zp03Xml.getMonNumbOther());
            mZp03.setMonNumbDay(zp03Xml.getMonNumbDay());
            mZp03.setMonNumbMonth(zp03Xml.getMonNumbMonth());
            mZp03.setMonNumbYear(zp03Xml.getMonNumbYear());
            mZp03.setMonNumbDuration(zp03Xml.getMonNumbDuration());
            mZp03.setMonParalysis(zp03Xml.getMonParalysis());
            mZp03.setMonParaArm(zp03Xml.getMonParaArm());
            mZp03.setMonParaLeg(zp03Xml.getMonParaLeg());
            mZp03.setMonParaHand(zp03Xml.getMonParaHand());
            mZp03.setMonParaFoot(zp03Xml.getMonParaFoot());
            mZp03.setMonParaFace(zp03Xml.getMonParaFace());
            mZp03.setMonParaOther(zp03Xml.getMonParaOther());
            mZp03.setMonParaDay(zp03Xml.getMonParaDay());
            mZp03.setMonParaMonth(zp03Xml.getMonParaMonth());
            mZp03.setMonParaYear(zp03Xml.getMonParaYear());
            mZp03.setMonParaDuration(zp03Xml.getMonParaDuration());
            mZp03.setMonResultsProvided(zp03Xml.getMonResultsProvided());
            mZp03.setMonCounseling(zp03Xml.getMonCounseling());
            mZp03.setMonResultsOther(zp03Xml.getMonResultsOther());
            mZp03.setMonOneweekDate(zp03Xml.getMonOneweekDate());
            mZp03.setMonOneweekTime(zp03Xml.getMonOneweekTime());
            mZp03.setMonProvideSym(zp03Xml.getMonProvideSym());
            mZp03.setMonReminderPreg(zp03Xml.getMonReminderPreg());
            mZp03.setMonReminderProvided(zp03Xml.getMonReminderProvided());
            mZp03.setMonNextDate(zp03Xml.getMonNextDate());
            mZp03.setMonNextTime(zp03Xml.getMonNextTime());
            mZp03.setMonIdCompleting(username);
            mZp03.setMonDateCompleted(new Date());
            mZp03.setMonIdReviewer(username);
            mZp03.setMonDateReviewed(new Date());
            mZp03.setMonIdDataEntry(username);
            mZp03.setMonDateEntered(new Date());

            //Version 2
            mZp03.setMonAddtMedicines(zp03Xml.getMonAddtMedicines());
            mZp03.setMonAddtDrugsType(zp03Xml.getMonAddtDrugsType());
            mZp03.setMonAddtOthDrugsType1(zp03Xml.getMonAddtOthDrugsType1());
            mZp03.setMonAddtOthDrugsBrand1(zp03Xml.getMonAddtOthDrugsBrand1());
            mZp03.setMonAddtOthDrugsType2(zp03Xml.getMonAddtOthDrugsType2());
            mZp03.setMonAddtOthDrugsBrand2(zp03Xml.getMonAddtOthDrugsBrand2());
            mZp03.setMonAddtOthDrugsType3(zp03Xml.getMonAddtOthDrugsType3());
            mZp03.setMonAddtOthDrugsBrand3(zp03Xml.getMonAddtOthDrugsBrand3());
            mZp03.setMonAddtOthDrugsType4(zp03Xml.getMonAddtOthDrugsType4());
            mZp03.setMonAddtOthDrugsBrand4(zp03Xml.getMonAddtOthDrugsBrand4());
            mZp03.setMonAddtOthDrugsType5(zp03Xml.getMonAddtOthDrugsType5());
            mZp03.setMonAddtOthDrugsBrand5(zp03Xml.getMonAddtOthDrugsBrand5());
            // termina Version2
            
            mZp03.setRecordDate(new Date());
            mZp03.setRecordUser(username);
            mZp03.setIdInstancia(idInstancia);
            mZp03.setInstancePath(instanceFilePath);
            mZp03.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mZp03.setStart(zp03Xml.getStart());
            mZp03.setEnd(zp03Xml.getEnd());
            mZp03.setDeviceid(zp03Xml.getDeviceid());
            mZp03.setSimserial(zp03Xml.getSimserial());
            mZp03.setPhonenumber(zp03Xml.getPhonenumber());
            mZp03.setToday(zp03Xml.getToday());

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
        	accionaRealizar = values[0];
            try {
            	zikaPosA.open();
				if (accionaRealizar == ADD_ZP03_ODK){
					zikaPosA.crearZp03MonthlyVisit(mZp03);
				}
				else{
					zikaPosA.editarZp03MonthlyVisit(mZp03);
				}
				zikaPosA.close();
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
                return "error";
            }
            return "exito";
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
