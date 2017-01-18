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
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionFtoH;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp04TrimesterVisitSectionFtoHXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.R;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;

/**
 * Created by ics on 31/10/2016.
 */
public class NewZp04TrimesterVisitSectionFtoHActivity extends AbstractAsyncActivity {

    protected static final String TAG = NewZp01StudyEntrySectionEActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPosA;
    private static Zp04TrimesterVisitSectionFtoH mZp04F = null;

	public static final int ADD_ZP04F_ODK = 1;
	public static final int EDIT_ZP04F_ODK = 2;

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
        mZp04F = (Zp04TrimesterVisitSectionFtoH) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP04F);
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
        if (mZp04F!=null){
            message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_8)+"?");
        }
        else{
            message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_8)+"?");
        }

        //add some action to the buttons

        Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
        yes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogInit.dismiss();
                addTrimesterVisit();
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
    	if(requestCode == ADD_ZP04F_ODK||requestCode == EDIT_ZP04F_ODK) {
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
                    parseTrimesterVisit(idInstancia,instanceFilePath,accion);
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

    /**
     *
     */
    private void addTrimesterVisit() {
        try{
        	Uri formUri;
			if(mZp04F==null){
	            //campos de proveedor de collect
	            String[] projection = new String[] {
	                    "_id","jrFormId","displayName"};
	            //cursor que busca el formulario
	            Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
	                    "jrFormId = 'ZPos04_Trimester_Visit_F_H' and displayName = 'Zika Positivas Visita Cuestionario Trimestral_F_H'", null, null);
	            c.moveToFirst();
	            //captura el id del formulario
	            Integer id = Integer.parseInt(c.getString(0));
	            //cierra el cursor
	            if (c != null) {
	                c.close();
	            }
	            //forma el uri para ODK Collect
	            formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
	            accion = ADD_ZP04F_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mZp04F.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP04F_ODK;
			}
			Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
			//Arranca la actividad proveedor de instancias de ODK Collect en busca de resultado
			startActivityForResult(odkA, accion);
        }
        catch(Exception e){
            //No existe el formulario en el equipo
            Log.e(TAG, e.getMessage(), e);
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void parseTrimesterVisit(Integer idInstancia, String instanceFilePath, Integer accion) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp04TrimesterVisitSectionFtoHXml zp04Xml = new Zp04TrimesterVisitSectionFtoHXml();
            zp04Xml = serializer.read(Zp04TrimesterVisitSectionFtoHXml.class, source);
            if (accion==ADD_ZP04F_ODK) mZp04F = new Zp04TrimesterVisitSectionFtoH();
            mZp04F.setRecordId(mRecordId);
            mZp04F.setRedcapEventName(event);
            mZp04F.setTriBugNuisInd(zp04Xml.getTriBugNuisInd());
            mZp04F.setTriPestStorHomeInd(zp04Xml.getTriPestStorHomeInd());
            mZp04F.setTriPestAppHomeInd(zp04Xml.getTriPestAppHomeInd());
            mZp04F.setTriPestAppDay(zp04Xml.getTriPestAppDay());
            mZp04F.setTriPestAppMonth(zp04Xml.getTriPestAppMonth());
            mZp04F.setTriPestAppYear(zp04Xml.getTriPestAppYear());
            mZp04F.setTriPestAppName(zp04Xml.getTriPestAppName());
            mZp04F.setTriHomeTrtdInsctInd(zp04Xml.getTriHomeTrtdInsctInd());
            mZp04F.setTriHomeTrtdLoc(zp04Xml.getTriHomeTrtdLoc());
            mZp04F.setTriHomeTrtdEntity(zp04Xml.getTriHomeTrtdEntity());
            mZp04F.setTriHomeTrtdNames(zp04Xml.getTriHomeTrtdNames());
            mZp04F.setTriTrtmntAppDay(zp04Xml.getTriTrtmntAppDay());
            mZp04F.setTriTrtmntAppMonth(zp04Xml.getTriTrtmntAppMonth());
            mZp04F.setTriTrtmntAppYear(zp04Xml.getTriTrtmntAppYear());
            mZp04F.setTriLwnTrtmntAppInd(zp04Xml.getTriLwnTrtmntAppInd());
            mZp04F.setTriLwnTrtmntAppDay(zp04Xml.getTriLwnTrtmntAppDay());
            mZp04F.setTriLwnTrtmntAppMonth(zp04Xml.getTriLwnTrtmntAppMonth());
            mZp04F.setTriLwnTrtmntAppYear(zp04Xml.getTriLwnTrtmntAppYear());
            mZp04F.setTriLwnTrtmntAppName(zp04Xml.getTriLwnTrtmntAppName());
            mZp04F.setTriMosqRepInd(zp04Xml.getTriMosqRepInd());
            mZp04F.setTriMosqRepTyp(zp04Xml.getTriMosqRepTyp());
            mZp04F.setTriMosqRepNameSpray(zp04Xml.getTriMosqRepNameSpray());
            mZp04F.setTriMosqRepDkSpray(zp04Xml.getTriMosqRepDkSpray());
            mZp04F.setTriMosqRepNameLotion(zp04Xml.getTriMosqRepNameLotion());
            mZp04F.setTriMosqRepDkLotion(zp04Xml.getTriMosqRepDkLotion());
            mZp04F.setTriMosqRepNameSpiral(zp04Xml.getTriMosqRepNameSpiral());
            mZp04F.setTriMosqRepDkSpiral(zp04Xml.getTriMosqRepDkSpiral());
            mZp04F.setTriMosqRepNamePlugin(zp04Xml.getTriMosqRepNamePlugin());
            mZp04F.setTriMosqRepDkPlugin(zp04Xml.getTriMosqRepDkPlugin());
            mZp04F.setTriMosqRepNameOther(zp04Xml.getTriMosqRepNameOther());
            mZp04F.setTriMosqRepDkOther(zp04Xml.getTriMosqRepDkOther());
            mZp04F.setTriNextVisitDat(zp04Xml.getTriNextVisitDat());
            mZp04F.setTriNextVisitTime(zp04Xml.getTriNextVisitTime());
            mZp04F.setTriCompId(username);
            mZp04F.setTriCompDat(new Date());
            mZp04F.setTriRevId(username);
            mZp04F.setTriRevDat(new Date());
            mZp04F.setTriEntId(username);
            mZp04F.setTriEntDat(new Date());
            mZp04F.setRecordDate(new Date());
            mZp04F.setRecordUser(username);
            mZp04F.setIdInstancia(idInstancia);
            mZp04F.setInstancePath(instanceFilePath);
            mZp04F.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mZp04F.setStart(zp04Xml.getStart());
            mZp04F.setEnd(zp04Xml.getEnd());
            mZp04F.setDeviceid(zp04Xml.getDeviceid());
            mZp04F.setSimserial(zp04Xml.getSimserial());
            mZp04F.setPhonenumber(zp04Xml.getPhonenumber());
            mZp04F.setToday(zp04Xml.getToday());
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
    				if (accionaRealizar == ADD_ZP04F_ODK){
    					zikaPosA.crearZp04TrimesterVisitSectionFtoH(mZp04F);
    				}
    				else{
    					zikaPosA.editarZp04TrimesterVisitSectionFtoH(mZp04F);
    				}
    				zikaPosA.close();
    			} catch (Exception e) {
    				Log.e(TAG, e.getLocalizedMessage(), e);
    				return "error";
    			}
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
