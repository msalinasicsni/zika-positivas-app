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
import ni.org.ics.zikapositivas.appmovil.domain.Zp06DeliveryAnd6weekVisit;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp06DeliveryAnd6weekVisitXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;

/**
 * Created by FIRSTICT on 10/31/2016.
 * V1.0
 */
public class NewZp06DeliveryAnd6weekVisitActivity extends AbstractAsyncActivity {

    protected static final String TAG = NewZp06DeliveryAnd6weekVisitActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPos;
    private static Zp06DeliveryAnd6weekVisit mDelivery = null;

    public static final int ADD_ZP06_ODK = 1;
	public static final int EDIT_ZP06_ODK = 2;

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
        mDelivery = (Zp06DeliveryAnd6weekVisit) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP06);
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
        if (mDelivery!=null){
            message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_10)+"?");
        }
        else{
            message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_10)+"?");
        }

        //add some action to the buttons

        Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
        yes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogInit.dismiss();
                addZp06DeliveryAnd6weekVisit();
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
    	if(requestCode == ADD_ZP06_ODK||requestCode == EDIT_ZP06_ODK) {
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
                    parseZp06DeliveryAnd6weekVisit(idInstancia, instanceFilePath);
                }
                else{
                    Toast.makeText(getApplicationContext(),	getString(R.string.err_not_completed), Toast.LENGTH_LONG).show();
                }
            }
            else{

            }
        }
        super.onActivityResult(requestCode, resultCode, intent);
    }

    private void addZp06DeliveryAnd6weekVisit() {
        try{
        	Uri formUri;
			if(mDelivery==null){
	            //campos de proveedor de collect
	            String[] projection = new String[] {
	                    "_id","jrFormId","displayName"};
	            //cursor que busca el formulario
	            Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
	                    "jrFormId = 'ZPos06_Delivery' and displayName = 'Zika Positivas Parto y Visita  de Seis Semanas (Madre)'", null, null);
	            c.moveToFirst();
	            //captura el id del formulario
	            Integer id = Integer.parseInt(c.getString(0));
	            //cierra el cursor
	            if (c != null) {
	                c.close();
	            }
	            //forma el uri para ODK Collect
	            formUri = ContentUris.withAppendedId(Constants.CONTENT_URI, id);
	            accion = ADD_ZP06_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mDelivery.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP06_ODK;
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

    private void parseZp06DeliveryAnd6weekVisit(Integer idInstancia, String instanceFilePath) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp06DeliveryAnd6weekVisitXml zp06Xml = serializer.read(Zp06DeliveryAnd6weekVisitXml.class, source);
            mDelivery.setRecordId(mRecordId);
            mDelivery.setRedcapEventName(event);

            mDelivery.setDeliVisitDate(zp06Xml.getDeliVisitDate());
            mDelivery.setDeliVisitStatus(zp06Xml.getDeliVisitStatus());
            mDelivery.setDeliVisitType(zp06Xml.getDeliVisitType());
            mDelivery.setDeliMotherWt(zp06Xml.getDeliMotherWt());
            mDelivery.setDeliWtUnit(zp06Xml.getDeliWtUnit());
            mDelivery.setDeliSystolic(zp06Xml.getDeliSystolic());
            mDelivery.setDeliDiastolic(zp06Xml.getDeliDiastolic());
            mDelivery.setDeliTemperature(zp06Xml.getDeliTemperature());
            mDelivery.setDeliTempUnit(zp06Xml.getDeliTempUnit());
            mDelivery.setDeliDeliveryDate(zp06Xml.getDeliDeliveryDate());
            mDelivery.setDeliMode(zp06Xml.getDeliMode());
            mDelivery.setDeliDeliveryWho(zp06Xml.getDeliDeliveryWho());
            mDelivery.setDeliDeliveryOccur(zp06Xml.getDeliDeliveryOccur());
            mDelivery.setDeliHospitalId(zp06Xml.getDeliHospitalId());
            mDelivery.setDeliClinicId(zp06Xml.getDeliClinicId());
            mDelivery.setDeliDeliveryOther(zp06Xml.getDeliDeliveryOther());
            mDelivery.setDeliNumBirth(zp06Xml.getDeliNumBirth());
            mDelivery.setDeliFetalOutcome1(zp06Xml.getDeliFetalOutcome1());
            mDelivery.setDeliCauseDeath1(zp06Xml.getDeliCauseDeath1());
            mDelivery.setDeliSexBaby1(zp06Xml.getDeliSexBaby1());
            mDelivery.setDeliFetalOutcome2(zp06Xml.getDeliFetalOutcome2());
            mDelivery.setDeliCauseDeath2(zp06Xml.getDeliCauseDeath2());
            mDelivery.setDeliSexBaby2(zp06Xml.getDeliSexBaby2());
            mDelivery.setDeliFetalOutcome3(zp06Xml.getDeliFetalOutcome3());
            mDelivery.setDeliCauseDeath3(zp06Xml.getDeliCauseDeath3());
            mDelivery.setDeliSexBaby3(zp06Xml.getDeliSexBaby3());
            mDelivery.setDeliConsentInfant(zp06Xml.getDeliConsentInfant());
            mDelivery.setDeliReasonNoconsent(zp06Xml.getDeliReasonNoconsent());
            mDelivery.setDeliNoconsentOther(zp06Xml.getDeliNoconsentOther());
            mDelivery.setDeliFeverSymptom(zp06Xml.getDeliFeverSymptom());
            mDelivery.setDeliRash(zp06Xml.getDeliRash());
            mDelivery.setDeliItch(zp06Xml.getDeliItch());
            mDelivery.setDeliRashFirst(zp06Xml.getDeliRashFirst());
            mDelivery.setDeliRashDay(zp06Xml.getDeliRashDay());
            mDelivery.setDeliRashMonth(zp06Xml.getDeliRashMonth());
            mDelivery.setDeliRashYear(zp06Xml.getDeliRashYear());
            mDelivery.setDeliRashDuration(zp06Xml.getDeliRashDuration());
            mDelivery.setDeliRashSpread(zp06Xml.getDeliRashSpread());
            mDelivery.setDeliSpreadPart(zp06Xml.getDeliSpreadPart());
            mDelivery.setDeliFeverExperience(zp06Xml.getDeliFeverExperience());
            mDelivery.setDeliTempMeasure(zp06Xml.getDeliTempMeasure());
            mDelivery.setDeliHighTemp(zp06Xml.getDeliHighTemp());
            mDelivery.setDeliHightemUnit(zp06Xml.getDeliHightemUnit());
            mDelivery.setDeliTempunknown(zp06Xml.getDeliTempunknown());
            mDelivery.setDeliFeverDay(zp06Xml.getDeliFeverDay());
            mDelivery.setDeliFeverMonth(zp06Xml.getDeliFeverMonth());
            mDelivery.setDeliFeverYear(zp06Xml.getDeliFeverYear());
            mDelivery.setDeliFeverDuration(zp06Xml.getDeliFeverDuration());
            mDelivery.setDeliRedeyes(zp06Xml.getDeliRedeyes());
            mDelivery.setDeliRedeyesDay(zp06Xml.getDeliRedeyesDay());
            mDelivery.setDeliRedeyesMonth(zp06Xml.getDeliRedeyesMonth());
            mDelivery.setDeliRedeyesYear(zp06Xml.getDeliRedeyesYear());
            mDelivery.setDeliRedeyesDuration(zp06Xml.getDeliRedeyesDuration());
            mDelivery.setDeliJoint(zp06Xml.getDeliJoint());
            mDelivery.setDeliJointDay(zp06Xml.getDeliJointDay());
            mDelivery.setDeliJointMonth(zp06Xml.getDeliJointMonth());
            mDelivery.setDeliJointYear(zp06Xml.getDeliJointYear());
            mDelivery.setDeliJointDuration(zp06Xml.getDeliJointDuration());
            mDelivery.setDeliHeadache(zp06Xml.getDeliHeadache());
            mDelivery.setDeliHeadacheDay(zp06Xml.getDeliHeadacheDay());
            mDelivery.setDeliHeadacheMonth(zp06Xml.getDeliHeadacheMonth());
            mDelivery.setDeliHeadacheYear(zp06Xml.getDeliHeadacheYear());
            mDelivery.setDeliHeadacheDuration(zp06Xml.getDeliHeadacheDuration());
            mDelivery.setDeliSymptomOther(zp06Xml.getDeliSymptomOther());
            mDelivery.setDeliSpecifySymptom(zp06Xml.getDeliSpecifySymptom());
            mDelivery.setDeliOtherSymptom(zp06Xml.getDeliOtherSymptom());
            mDelivery.setDeliMedicare(zp06Xml.getDeliMedicare());
            mDelivery.setDeliCareDay(zp06Xml.getDeliCareDay());
            mDelivery.setDeliCareMonth(zp06Xml.getDeliCareMonth());
            mDelivery.setDeliCareYear(zp06Xml.getDeliCareYear());
            mDelivery.setDeliCareFacility(zp06Xml.getDeliCareFacility());
            mDelivery.setDeliHospitalized(zp06Xml.getDeliHospitalized());
            mDelivery.setDeliHospital(zp06Xml.getDeliHospital());
            mDelivery.setDeliDiagRubella(zp06Xml.getDeliDiagRubella());
            mDelivery.setDeliDiagDengue(zp06Xml.getDeliDiagDengue());
            mDelivery.setDeliDiagChikung(zp06Xml.getDeliDiagChikung());
            mDelivery.setDeliDiagZika(zp06Xml.getDeliDiagZika());
            mDelivery.setDeliDiagCytome(zp06Xml.getDeliDiagCytome());
            mDelivery.setDeliMedicine(zp06Xml.getDeliMedicine());
            mDelivery.setDeliMedcineName(zp06Xml.getDeliMedcineName());
            mDelivery.setDeliSymptomDiary(zp06Xml.getDeliSymptomDiary());
            mDelivery.setDeliGuillainbarre(zp06Xml.getDeliGuillainbarre());
            mDelivery.setDeliTingling(zp06Xml.getDeliTingling());
            mDelivery.setDeliTinglingArm(zp06Xml.getDeliTinglingArm());
            mDelivery.setDeliTinglingLeg(zp06Xml.getDeliTinglingLeg());
            mDelivery.setDeliTinglingHand(zp06Xml.getDeliTinglingHand());
            mDelivery.setDeliTinglingFoot(zp06Xml.getDeliTinglingFoot());
            mDelivery.setDeliTinglingFace(zp06Xml.getDeliTinglingFace());
            mDelivery.setDeliTinglingOther(zp06Xml.getDeliTinglingOther());
            mDelivery.setDeliSensationMin(zp06Xml.getDeliSensationMin());
            mDelivery.setDeliSensationHr(zp06Xml.getDeliSensationHr());
            mDelivery.setDeliSenstaionDay(zp06Xml.getDeliSenstaionDay());
            mDelivery.setDeliInjury(zp06Xml.getDeliInjury());
            mDelivery.setDeliTinglingDay(zp06Xml.getDeliTinglingDay());
            mDelivery.setDeliTinglingMonth(zp06Xml.getDeliTinglingMonth());
            mDelivery.setDeliTinglingYear(zp06Xml.getDeliTinglingYear());
            mDelivery.setDeliTinglingDuration(zp06Xml.getDeliTinglingDuration());
            mDelivery.setDeliNumbness(zp06Xml.getDeliNumbness());
            mDelivery.setDeliNumbArm(zp06Xml.getDeliNumbArm());
            mDelivery.setDeliNumbLeg(zp06Xml.getDeliNumbLeg());
            mDelivery.setDeliNumbHand(zp06Xml.getDeliNumbHand());
            mDelivery.setDeliNumbFoot(zp06Xml.getDeliNumbFoot());
            mDelivery.setDeliNumbFace(zp06Xml.getDeliNumbFace());
            mDelivery.setDeliNumbOther(zp06Xml.getDeliNumbOther());
            mDelivery.setDeliNumbDay(zp06Xml.getDeliNumbDay());
            mDelivery.setDeliNumbMonth(zp06Xml.getDeliNumbMonth());
            mDelivery.setDeliNumbYear(zp06Xml.getDeliNumbYear());
            mDelivery.setDeliNumbDuration(zp06Xml.getDeliNumbDuration());
            mDelivery.setDeliParalysis(zp06Xml.getDeliParalysis());
            mDelivery.setDeliParaArm(zp06Xml.getDeliParaArm());
            mDelivery.setDeliParaLeg(zp06Xml.getDeliParaLeg());
            mDelivery.setDeliParaHand(zp06Xml.getDeliParaHand());
            mDelivery.setDeliParaFoot(zp06Xml.getDeliParaFoot());
            mDelivery.setDeliParaFace(zp06Xml.getDeliParaFace());
            mDelivery.setDeliParaOther(zp06Xml.getDeliParaOther());
            mDelivery.setDeliParaDay(zp06Xml.getDeliParaDay());
            mDelivery.setDeliParaMonth(zp06Xml.getDeliParaMonth());
            mDelivery.setDeliParaYear(zp06Xml.getDeliParaYear());
            mDelivery.setDeliParaDuration(zp06Xml.getDeliParaDuration());
            mDelivery.setDeliResultsProvided(zp06Xml.getDeliResultsProvided());
            mDelivery.setDeliCounseling(zp06Xml.getDeliCounseling());
            mDelivery.setDeliResultsOther(zp06Xml.getDeliResultsOther());
            mDelivery.setDeliIdCompleting(username);
            mDelivery.setDeliDateCompleted(new Date());
            mDelivery.setDeliIdReviewer(username);
            mDelivery.setDeliDateReviewed(new Date());
            mDelivery.setDeliIdDataEntry(username);
            mDelivery.setDeliDateEntered(new Date());

            mDelivery.setRecordDate(new Date());
            mDelivery.setRecordUser(username);
            mDelivery.setIdInstancia(idInstancia);
            mDelivery.setInstancePath(instanceFilePath);
            mDelivery.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mDelivery.setStart(zp06Xml.getStart());
            mDelivery.setEnd(zp06Xml.getEnd());
            mDelivery.setDeviceid(zp06Xml.getDeviceid());
            mDelivery.setSimserial(zp06Xml.getSimserial());
            mDelivery.setPhonenumber(zp06Xml.getPhonenumber());
            mDelivery.setToday(zp06Xml.getToday());

            new SaveDataTask().execute();

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
    				if (accionaRealizar == ADD_ZP06_ODK){
    					zikaPos.crearZp06DeliveryAnd6weekVisit(mDelivery);
    				}
    				else{
    					zikaPos.editarZp06DeliveryAnd6weekVisit(mDelivery);
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
