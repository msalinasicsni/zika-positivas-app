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
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionE;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp04TrimesterVisitSectionEXml;
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
public class NewZp04TrimesterVisitSectionEActivity extends AbstractAsyncActivity {

    protected static final String TAG = NewZp04TrimesterVisitSectionAtoDActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPosA;
    private static Zp04TrimesterVisitSectionE mZp04E = null;

	public static final int ADD_ZP04E_ODK = 1;
	public static final int EDIT_ZP04E_ODK = 2;

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
        mZp04E = (Zp04TrimesterVisitSectionE) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP04E);
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
        if (mZp04E!=null){
            message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_7)+"?");
        }
        else{
            message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_7)+"?");
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
    	if(requestCode == ADD_ZP04E_ODK||requestCode == EDIT_ZP04E_ODK) {
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
			if(mZp04E==null){
	            //campos de proveedor de collect
	            String[] projection = new String[] {
	                    "_id","jrFormId","displayName"};
	            //cursor que busca el formulario
	            Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
	                    "jrFormId = 'ZPos04_Trimester_Visit_E' and displayName = 'Zika Positivas Visita Cuestionario Trimestral_E'", null, null);
	            c.moveToFirst();
	            //captura el id del formulario
	            Integer id = Integer.parseInt(c.getString(0));
	            //cierra el cursor
	            if (c != null) {
	                c.close();
	            }
	            //forma el uri para ODK Collect
	            formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
	            accion = ADD_ZP04E_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mZp04E.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP04E_ODK;
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

    private void parseTrimesterVisit(Integer idInstancia, String instanceFilePath, Integer accion) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp04TrimesterVisitSectionEXml zp04Xml = new Zp04TrimesterVisitSectionEXml();
            zp04Xml = serializer.read(Zp04TrimesterVisitSectionEXml.class, source);
            if (accion==ADD_ZP04E_ODK) mZp04E = new Zp04TrimesterVisitSectionE();
            mZp04E.setRecordId(mRecordId);
            mZp04E.setRedcapEventName(event);
            mZp04E.setTri24HrsDeodorant(zp04Xml.getTri24HrsDeodorant());
            mZp04E.setTriBrandDeodorant(zp04Xml.getTriBrandDeodorant());
            mZp04E.setTriFragFreeDeodorant(zp04Xml.getTriFragFreeDeodorant());
            mZp04E.setTri24HrsHairGel(zp04Xml.getTri24HrsHairGel());
            mZp04E.setTriBrandHairGel(zp04Xml.getTriBrandHairGel());
            mZp04E.setTriFragFreeHairGel(zp04Xml.getTriFragFreeHairGel());
            mZp04E.setTri24HrsConditioner(zp04Xml.getTri24HrsConditioner());
            mZp04E.setTriBrandConditioner(zp04Xml.getTriBrandConditioner());
            mZp04E.setTriFragFreeConditioner(zp04Xml.getTriFragFreeConditioner());
            mZp04E.setTri24HrsShampoo(zp04Xml.getTri24HrsShampoo());
            mZp04E.setTriBrandShampoo(zp04Xml.getTriBrandShampoo());
            mZp04E.setTriFragFreeShampoo(zp04Xml.getTriFragFreeShampoo());
            mZp04E.setTri24HrsOtherHair(zp04Xml.getTri24HrsOtherHair());
            mZp04E.setTriBrandOtherHair(zp04Xml.getTriBrandOtherHair());
            mZp04E.setTriFragFreeOtherHair(zp04Xml.getTriFragFreeOtherHair());
            mZp04E.setTri24HrsPerfume(zp04Xml.getTri24HrsPerfume());
            mZp04E.setTriBrandPerfume(zp04Xml.getTriBrandPerfume());
            mZp04E.setTriFragFreePerfume(zp04Xml.getTriFragFreePerfume());
            mZp04E.setTri24HrsBarSoap(zp04Xml.getTri24HrsBarSoap());
            mZp04E.setTriBrandBarSoap(zp04Xml.getTriBrandBarSoap());
            mZp04E.setTriFragFreeBarSoap(zp04Xml.getTriFragFreeBarSoap());
            mZp04E.setTri24HrsLiqSoap(zp04Xml.getTri24HrsLiqSoap());
            mZp04E.setTriBrandLiqSoap(zp04Xml.getTriBrandLiqSoap());
            mZp04E.setTriFragFreeLiqSoap(zp04Xml.getTriFragFreeLiqSoap());
            mZp04E.setTri24HrsLotion(zp04Xml.getTri24HrsLotion());
            mZp04E.setTriBrandLotion(zp04Xml.getTriBrandLotion());
            mZp04E.setTriFragFreeLotion(zp04Xml.getTriFragFreeLotion());
            mZp04E.setTri24HrsShavCream(zp04Xml.getTri24HrsShavCream());
            mZp04E.setTriBrandShavCream(zp04Xml.getTriBrandShavCream());
            mZp04E.setTriFragFreeShavCream(zp04Xml.getTriFragFreeShavCream());
            mZp04E.setTri24HrsColorCos(zp04Xml.getTri24HrsColorCos());
            mZp04E.setTriBrandColorCos(zp04Xml.getTriBrandColorCos());
            mZp04E.setTriFragFreeColorCos(zp04Xml.getTriFragFreeColorCos());
            mZp04E.setTri24HrsSunscreen(zp04Xml.getTri24HrsSunscreen());
            mZp04E.setTriBrandSunscreen(zp04Xml.getTriBrandSunscreen());
            mZp04E.setTriFragFreeSunscreen(zp04Xml.getTriFragFreeSunscreen());
            mZp04E.setTri24HrsNailPol(zp04Xml.getTri24HrsNailPol());
            mZp04E.setTriBrandNailPol(zp04Xml.getTriBrandNailPol());
            mZp04E.setTriFragFreeNailPol(zp04Xml.getTriFragFreeNailPol());
            mZp04E.setTri24HrsFurnPol(zp04Xml.getTri24HrsFurnPol());
            mZp04E.setTriBrandFurnPol(zp04Xml.getTriBrandFurnPol());
            mZp04E.setTriFragFreeFurnPol(zp04Xml.getTriFragFreeFurnPol());
            mZp04E.setTri24HrsCleaners(zp04Xml.getTri24HrsCleaners());
            mZp04E.setTriBrandCleaners(zp04Xml.getTriBrandCleaners());
            mZp04E.setTriFragFreeCleaners(zp04Xml.getTriFragFreeCleaners());
            mZp04E.setTri24HrsFloorWax(zp04Xml.getTri24HrsFloorWax());
            mZp04E.setTriBrandFloorWax(zp04Xml.getTriBrandFloorWax());
            mZp04E.setTriFragFreeFloorWax(zp04Xml.getTriFragFreeFloorWax());
            mZp04E.setTri24HrsSoftnr(zp04Xml.getTri24HrsSoftnr());
            mZp04E.setTriBrandSoftnr(zp04Xml.getTriBrandSoftnr());
            mZp04E.setTriFragFreeSoftnr(zp04Xml.getTriFragFreeSoftnr());
            mZp04E.setTri24HrsLaundDet(zp04Xml.getTri24HrsLaundDet());
            mZp04E.setTriBrandLaundDet(zp04Xml.getTriBrandLaundDet());
            mZp04E.setTriFragFreeLaundDet(zp04Xml.getTriFragFreeLaundDet());
            mZp04E.setTri24HrsLaundStrch(zp04Xml.getTri24HrsLaundStrch());
            mZp04E.setTriBrandLaundStrch(zp04Xml.getTriBrandLaundStrch());
            mZp04E.setTriFragFreeLaundStrch(zp04Xml.getTriFragFreeLaundStrch());
            mZp04E.setTri24HrsPaint(zp04Xml.getTri24HrsPaint());
            mZp04E.setTriBrandPaint(zp04Xml.getTriBrandPaint());
            mZp04E.setTriFragFreePaint(zp04Xml.getTriFragFreePaint());
            mZp04E.setTri24HrsSolvents(zp04Xml.getTri24HrsSolvents());
            mZp04E.setTriBrandSolvents(zp04Xml.getTriBrandSolvents());
            mZp04E.setTriFragFreeSolvents(zp04Xml.getTriFragFreeSolvents());
            mZp04E.setTri24HrsCarWax(zp04Xml.getTri24HrsCarWax());
            mZp04E.setTriBrandCarWax(zp04Xml.getTriBrandCarWax());
            mZp04E.setTriFragFreeCarWax(zp04Xml.getTriFragFreeCarWax());
            mZp04E.setTri24HrsPest(zp04Xml.getTri24HrsPest());
            mZp04E.setTriBrandPest(zp04Xml.getTriBrandPest());
            mZp04E.setTriFragFreePest(zp04Xml.getTriFragFreePest());
            mZp04E.setTri24HrsFleaTickPrev(zp04Xml.getTri24HrsFleaTickPrev());
            mZp04E.setTriBrandFleaTickPrev(zp04Xml.getTriBrandFleaTickPrev());
            mZp04E.setTriFleaTickPrev(zp04Xml.getTriFleaTickPrev());
            mZp04E.setTri24HrsFleaTickSpry(zp04Xml.getTri24HrsFleaTickSpry());
            mZp04E.setTriBrandFleaTickSpry(zp04Xml.getTriBrandFleaTickSpry());
            mZp04E.setTriFleaTickSpry(zp04Xml.getTriFleaTickSpry());
            mZp04E.setTri24HrsCaritin(zp04Xml.getTri24HrsCaritin());
            mZp04E.setTriBrandCaritin(zp04Xml.getTriBrandCaritin());
            mZp04E.setTriFragFreeCaritin(zp04Xml.getTriFragFreeCaritin());
            mZp04E.setTri24HrsZyrtec(zp04Xml.getTri24HrsZyrtec());
            mZp04E.setTriBrandZyrtec(zp04Xml.getTriBrandZyrtec());
            mZp04E.setTriFragFreeZyrtec(zp04Xml.getTriFragFreeZyrtec());
            mZp04E.setTri24HrsVita(zp04Xml.getTri24HrsVita());
            mZp04E.setTriBrandVita(zp04Xml.getTriBrandVita());
            mZp04E.setTriFragFreeVita(zp04Xml.getTriFragFreeVita());
            mZp04E.setTri24HrsHerbal(zp04Xml.getTri24HrsHerbal());
            mZp04E.setTriBrandHerbal(zp04Xml.getTriBrandHerbal());
            mZp04E.setTriFragFreeHerbal(zp04Xml.getTriFragFreeHerbal());
            mZp04E.setTri24HrsCreatine(zp04Xml.getTri24HrsCreatine());
            mZp04E.setTriBrandCreatine(zp04Xml.getTriBrandCreatine());
            mZp04E.setTriFragFreeCreatine(zp04Xml.getTriFragFreeCreatine());
            mZp04E.setTri24HrsProtein(zp04Xml.getTri24HrsProtein());
            mZp04E.setTriBrandProtein(zp04Xml.getTriBrandProtein());
            mZp04E.setTriFragFreeProtein(zp04Xml.getTriFragFreeProtein());
            mZp04E.setTri24HrsDiuretic(zp04Xml.getTri24HrsDiuretic());
            mZp04E.setTriBrandDiuretic(zp04Xml.getTriBrandDiuretic());
            mZp04E.setTriFragFreeDiuretic(zp04Xml.getTriFragFreeDiuretic());
            mZp04E.setTri24HrsInsulin(zp04Xml.getTri24HrsInsulin());
            mZp04E.setTriBrandInsulin(zp04Xml.getTriBrandInsulin());
            mZp04E.setTriFragFreeInsulin(zp04Xml.getTriFragFreeInsulin());
            mZp04E.setTri24HrsMouthwsh(zp04Xml.getTri24HrsMouthwsh());
            mZp04E.setTriBrandMouthwsh(zp04Xml.getTriBrandMouthwsh());
            mZp04E.setTriFragFreeMouthwsh(zp04Xml.getTriFragFreeMouthwsh());
            mZp04E.setTriFragFreeOverall(zp04Xml.getTriFragFreeOverall());
            mZp04E.setTriSurgInd(zp04Xml.getTriSurgInd());
            mZp04E.setRecordDate(new Date());
            mZp04E.setRecordUser(username);
            mZp04E.setIdInstancia(idInstancia);
            mZp04E.setInstancePath(instanceFilePath);
            mZp04E.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mZp04E.setStart(zp04Xml.getStart());
            mZp04E.setEnd(zp04Xml.getEnd());
            mZp04E.setDeviceid(zp04Xml.getDeviceid());
            mZp04E.setSimserial(zp04Xml.getSimserial());
            mZp04E.setPhonenumber(zp04Xml.getPhonenumber());
            mZp04E.setToday(zp04Xml.getToday());
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
				if (accionaRealizar == ADD_ZP04E_ODK){
					zikaPosA.crearZp04TrimesterVisitSectionE(mZp04E);
				}
				else{
					zikaPosA.editarZp04TrimesterVisitSectionE(mZp04E);
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
