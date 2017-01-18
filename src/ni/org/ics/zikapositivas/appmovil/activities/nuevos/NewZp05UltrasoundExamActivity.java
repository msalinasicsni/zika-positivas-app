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
import ni.org.ics.zikapositivas.appmovil.domain.Zp05UltrasoundExam;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp05UltrasoundExamXml;
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
public class NewZp05UltrasoundExamActivity extends AbstractAsyncActivity {
    protected static final String TAG = NewZp05UltrasoundExamActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPosA;
    private static Zp05UltrasoundExam mZp05 = null;

    public static final int ADD_ZP05_ODK = 1;
	public static final int EDIT_ZP05_ODK = 2;

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
        mZp05 = (Zp05UltrasoundExam) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP05);
        mRecordId = getIntent().getExtras().getString(Constants.RECORDID);
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
        if (mZp05!=null){
            message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_9)+"?");
        }
        else{
            message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_9)+"?");
        }

        //add some action to the buttons

        Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
        yes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogInit.dismiss();
                addZp05UltrasoundExam();
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
    	if(requestCode == ADD_ZP05_ODK||requestCode == EDIT_ZP05_ODK) {
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
                    parseZp05UltrasoundExam(idInstancia, instanceFilePath,accion);
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

    private void addZp05UltrasoundExam() {
        try{
        	Uri formUri;
			if(mZp05==null){
	            //campos de proveedor de collect
	            String[] projection = new String[] {
	                    "_id","jrFormId","displayName"};
	            //cursor que busca el formulario
	            Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
	                    "jrFormId = 'ZPos05_Ultrasound' and displayName = 'Zika Positivas Examen de Ultrasonido'", null, null);
	            c.moveToFirst();
	            //captura el id del formulario
	            Integer id = Integer.parseInt(c.getString(0));
	            //cierra el cursor
	            if (c != null) {
	                c.close();
	            }
	            //forma el uri para ODK Collect
	            formUri = ContentUris.withAppendedId(Constants.CONTENT_URI, id);
	            accion = ADD_ZP05_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mZp05.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP05_ODK;
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

    private void parseZp05UltrasoundExam(Integer idInstancia, String instanceFilePath, Integer accion) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp05UltrasoundExamXml zp05Xml = serializer.read(Zp05UltrasoundExamXml.class, source);
            if (accion==ADD_ZP05_ODK) mZp05 = new Zp05UltrasoundExam();
            mZp05.setRecordId(mRecordId);
            mZp05.setRedcapEventName(event);
            mZp05.setUltDate(zp05Xml.getUltDate());
            mZp05.setUltGaWeeks(zp05Xml.getUltGaWeeks());
            mZp05.setUltGaDays(zp05Xml.getUltGaDays());
            mZp05.setUltGeDetermined(zp05Xml.getUltGeDetermined());
            mZp05.setUltReason(zp05Xml.getUltReason());
            mZp05.setUltReasonOther(zp05Xml.getUltReasonOther());
            mZp05.setUltTime(zp05Xml.getUltTime());
            mZp05.setUltNameFacility(zp05Xml.getUltNameFacility());
            mZp05.setUltFacilityid(zp05Xml.getUltFacilityid());
            mZp05.setUltIdSonographer(zp05Xml.getUltIdSonographer());
            mZp05.setUltIdNa(zp05Xml.getUltIdNa());
            mZp05.setUltFestiGaWeeks1(zp05Xml.getUltFestiGaWeeks1());
            mZp05.setUltFestiGaDays1(zp05Xml.getUltFestiGaDays1());
            mZp05.setUltFestiDelivery1(zp05Xml.getUltFestiDelivery1());
            mZp05.setUltFirstYesno1(zp05Xml.getUltFirstYesno1());
            mZp05.setUltFabnormal1(zp05Xml.getUltFabnormal1());
            mZp05.setUltFyesSpecify1(zp05Xml.getUltFyesSpecify1());
            mZp05.setUltFotherFindings1(zp05Xml.getUltFotherFindings1());
            mZp05.setUltFurtherTesting1(zp05Xml.getUltFurtherTesting1());
            mZp05.setUltFnumFetuses(zp05Xml.getUltFnumFetuses());
            mZp05.setUltFfetusViable1(zp05Xml.getUltFfetusViable1());
            mZp05.setUltFfetalCardia1(zp05Xml.getUltFfetalCardia1());
            mZp05.setUltFfetalHeart1(zp05Xml.getUltFfetalHeart1());
            mZp05.setUltFcrl1(zp05Xml.getUltFcrl1());
            mZp05.setUltFcrlNa1(zp05Xml.getUltFcrlNa1());
            mZp05.setUltFfetusViable2(zp05Xml.getUltFfetusViable2());
            mZp05.setUltFfetalCardia2(zp05Xml.getUltFfetalCardia2());
            mZp05.setUltFfetalHeart2(zp05Xml.getUltFfetalHeart2());
            mZp05.setUltFcrl2(zp05Xml.getUltFcrl2());
            mZp05.setUltFcrlNa2(zp05Xml.getUltFcrlNa2());
            mZp05.setUltFfetusViable3(zp05Xml.getUltFfetusViable3());
            mZp05.setUltFfetalCardia3(zp05Xml.getUltFfetalCardia3());
            mZp05.setUltFfetalHeart3(zp05Xml.getUltFfetalHeart3());
            mZp05.setUltFcrl3(zp05Xml.getUltFcrl3());
            mZp05.setUltFcrlNa3(zp05Xml.getUltFcrlNa3());
            mZp05.setUltSfindings1(zp05Xml.getUltSfindings1());
            mZp05.setUltSspecify1(zp05Xml.getUltSspecify1());
            mZp05.setUltSfindingsSpecify1(zp05Xml.getUltSfindingsSpecify1());
            mZp05.setUltFurtherExamination1(zp05Xml.getUltFurtherExamination1());
            mZp05.setUltSplacental1(zp05Xml.getUltSplacental1());
            mZp05.setUltSnumFetuses(zp05Xml.getUltSnumFetuses());
            mZp05.setUltSfetusViable1(zp05Xml.getUltSfetusViable1());
            mZp05.setUltSfetalCardia1(zp05Xml.getUltSfetalCardia1());
            mZp05.setUltSfetalHeart1(zp05Xml.getUltSfetalHeart1());
            mZp05.setUltSbiparietal1(zp05Xml.getUltSbiparietal1());
            mZp05.setUltShead1(zp05Xml.getUltShead1());
            mZp05.setUltMicroceph1(zp05Xml.getUltMicroceph1());
            mZp05.setUltSevMicroceph1(zp05Xml.getUltSevMicroceph1());
            mZp05.setUltSabdominal1(zp05Xml.getUltSabdominal1());
            mZp05.setUltSfemur1(zp05Xml.getUltSfemur1());
            mZp05.setUltSfetalWt1(zp05Xml.getUltSfetalWt1());
            mZp05.setUltSpresentation1(zp05Xml.getUltSpresentation1());
            mZp05.setUltSfetusViable2(zp05Xml.getUltSfetusViable2());
            mZp05.setUltSfetalCardia2(zp05Xml.getUltSfetalCardia2());
            mZp05.setUltSfetalHeart2(zp05Xml.getUltSfetalHeart2());
            mZp05.setUltSbiparietal2(zp05Xml.getUltSbiparietal2());
            mZp05.setUltShead2(zp05Xml.getUltShead2());
            mZp05.setUltMicroceph2(zp05Xml.getUltMicroceph2());
            mZp05.setUltSevMicroceph2(zp05Xml.getUltSevMicroceph2());
            mZp05.setUltSabdominal2(zp05Xml.getUltSabdominal2());
            mZp05.setUltSfemur2(zp05Xml.getUltSfemur2());
            mZp05.setUltSfetalWt2(zp05Xml.getUltSfetalWt2());
            mZp05.setUltSpresentation2(zp05Xml.getUltSpresentation2());
            mZp05.setUltSfetusViable3(zp05Xml.getUltSfetusViable3());
            mZp05.setUltSfetalCardia3(zp05Xml.getUltSfetalCardia3());
            mZp05.setUltSfetalHeart3(zp05Xml.getUltSfetalHeart3());
            mZp05.setUltSbiparietal3(zp05Xml.getUltSbiparietal3());
            mZp05.setUltShead3(zp05Xml.getUltShead3());
            mZp05.setUltMicroceph3(zp05Xml.getUltMicroceph3());
            mZp05.setUltSevMicroceph3(zp05Xml.getUltSevMicroceph3());
            mZp05.setUltSabdominal3(zp05Xml.getUltSabdominal3());
            mZp05.setUltSfemur3(zp05Xml.getUltSfemur3());
            mZp05.setUltSfetalWt3(zp05Xml.getUltSfetalWt3());
            mZp05.setUltSpresentation3(zp05Xml.getUltSpresentation3());
            mZp05.setUltIdCompleting(username);
            mZp05.setUltDateCompleted(new Date());
            mZp05.setUltIdReviewer(username);
            mZp05.setUltDateReviewed(new Date());
            mZp05.setUltIdDataEntry(username);
            mZp05.setUltDateEntered(new Date());

            mZp05.setRecordDate(new Date());
            mZp05.setRecordUser(username);
            mZp05.setIdInstancia(idInstancia);
            mZp05.setInstancePath(instanceFilePath);
            mZp05.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mZp05.setStart(zp05Xml.getStart());
            mZp05.setEnd(zp05Xml.getEnd());
            mZp05.setDeviceid(zp05Xml.getDeviceid());
            mZp05.setSimserial(zp05Xml.getSimserial());
            mZp05.setPhonenumber(zp05Xml.getPhonenumber());
            mZp05.setToday(zp05Xml.getToday());

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
    				zikaPosA.open();
    				if (accionaRealizar == ADD_ZP05_ODK){
    					zikaPosA.crearZp05UltrasoundExam(mZp05);
    				}
    				else{
    					zikaPosA.editarZp05UltrasoundExam(mZp05);
    				}
    				zikaPosA.close();
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
