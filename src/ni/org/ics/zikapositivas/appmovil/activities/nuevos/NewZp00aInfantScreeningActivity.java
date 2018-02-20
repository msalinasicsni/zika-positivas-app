package ni.org.ics.zikapositivas.appmovil.activities.nuevos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
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
import ni.org.ics.zikapositivas.appmovil.domain.Zp00aInfantScreening;
import ni.org.ics.zikapositivas.appmovil.domain.Zp05UltrasoundExam;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp00aInfantScreeningXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;

/**
 * Created by ics on 22/1/2018.
 */
public class NewZp00aInfantScreeningActivity extends AbstractAsyncActivity {

    private ZikaPosAdapter zikaPosA;
    private static Zp00aInfantScreening iTamizaje = null;
    private static Zp00aInfantScreening infScr = null;
    private static Zp05UltrasoundExam mZp05 = null;
    private AlertDialog alertDialog;


    public static final int ADD_TAM = 1;

    Dialog dialogInit;
    private SharedPreferences settings;
    private String username;
    private String mRecordId = "";
    private String infantId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!FileUtils.storageReady()) {
            Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.error) + "," + getString(R.string.storage_error) ,Toast.LENGTH_LONG);
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
        infScr = (Zp00aInfantScreening) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP00a);
        mRecordId = getIntent().getExtras().getString(Constants.RECORDID);
        if (infScr != null){
            createDialog();
        }else{
            createInitDialog();
        }


    }

    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(this.getString(R.string.inf_tam));
        String labelHeader = "";

        labelHeader = labelHeader + "<br/><font color='black'>"+ this.getString(R.string.err_duplicated2)+"</font>";

        builder.setMessage(Html.fromHtml(labelHeader));
        builder.setPositiveButton(this.getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        alertDialog = builder.create();
        alertDialog.show();
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
            message.setText(getString(R.string.add)+ " " + getString(R.string.inf_tam));

        //add some action to the buttons

        Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
        yes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogInit.dismiss();
                addZp00aInfantScreening();
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
        if(requestCode == ADD_TAM) {
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
                    parseTamizaje(idInstancia, instanceFilePath);
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

    private void addZp00aInfantScreening() {
        try{
            //campos de proveedor de collect
            String[] projection = new String[] {
                    "_id","jrFormId","displayName"};
            //cursor que busca el formulario
            Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
                    "jrFormId = 'ZPos00a_Infant_Screening' and displayName = 'Zika Positivas Formato de Consentimiento del Infante'", null, null);
            c.moveToFirst();
            //captura el id del formulario
            Integer id = Integer.parseInt(c.getString(0));
            //cierra el cursor
            if (c != null) {
                c.close();
            }
            //forma el uri para ODK Collect
            Uri formUri = ContentUris.withAppendedId(Constants.CONTENT_URI, id);
            //Arranca la actividad ODK Collect en busca de resultado
            Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
            startActivityForResult(odkA, ADD_TAM);
        }
        catch(Exception e){
            //No existe el formulario en el equipo
            Log.e(TAG, e.getMessage(), e);
            Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }
    }


    private void parseTamizaje(Integer idInstancia, String instanceFilePath) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp00aInfantScreeningXml zp00aXml = serializer.read(Zp00aInfantScreeningXml.class, source);
            iTamizaje = new Zp00aInfantScreening();
            iTamizaje.setPregnantId(mRecordId);
            iTamizaje.setRedcapEventName(Constants.BIRTH);
            iTamizaje.setInfVisitDt(zp00aXml.getInfVisitDt());
            iTamizaje.setInfRemain(zp00aXml.getInfRemain());
            iTamizaje.setInfConsent(zp00aXml.getInfConsent());
            iTamizaje.setInfConsenta(zp00aXml.getInfConsenta());
            iTamizaje.setInfConsentb(zp00aXml.getInfConsentb());
            iTamizaje.setInfConsentc(zp00aXml.getInfConsentc());
            iTamizaje.setInfConsentd(zp00aXml.getInfConsentd());
            iTamizaje.setInfReasonno(zp00aXml.getInfReasonno());
            iTamizaje.setInfReasonOther(zp00aXml.getInfReasonOther());
            iTamizaje.setInfIdCompleting(username);
            iTamizaje.setInfDateCompleted(new Date());
            iTamizaje.setInfIdReviewer(username);
            iTamizaje.setInfDateReviewed(new Date());
            iTamizaje.setInfIdDataEntry(username);
            iTamizaje.setInfDateEntered(new Date());
            iTamizaje.setRecordDate(new Date());
            iTamizaje.setRecordUser(username);
            iTamizaje.setIdInstancia(idInstancia);
            iTamizaje.setInstancePath(instanceFilePath);
            iTamizaje.setEstado(Constants.STATUS_NOT_SUBMITTED);
            iTamizaje.setStart(zp00aXml.getStart());
            iTamizaje.setEnd(zp00aXml.getEnd());
            iTamizaje.setDeviceid(zp00aXml.getDeviceid());
            iTamizaje.setSimserial(zp00aXml.getSimserial());
            iTamizaje.setPhonenumber(zp00aXml.getPhonenumber());
            iTamizaje.setToday(zp00aXml.getToday());
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
    private class SaveDataTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            // before the request begins, show a progress indicator
            showLoadingProgressDialog();
        }

        @Override
        protected String doInBackground(String... values) {
            try {
                zikaPosA.open();

                String id =  MainDBConstants.recordId + "='" +  mRecordId + "'";
                mZp05 = zikaPosA.getZp05UltrasoundExam1(id, null);

                if (mZp05 != null){
                    int numFe = mZp05.getUltFnumFetuses();
                    int numFe1 = mZp05.getUltSnumFetuses();

                    if (numFe1 >0 || numFe > 0){
                        if (numFe1 > 0 ) {
                            for (int i = 1; i <= numFe1; i++) {
                                infantId = mRecordId.substring(0, mRecordId.length() - 1) + i;
                                iTamizaje.setRecordId(infantId);
                                iTamizaje.setInfInfid(infantId);
                                zikaPosA.crearZp00aInfantScreening(iTamizaje);
                            }
                        }else if (numFe > 0){
                            for (int i = 1; i <= numFe; i++) {
                                infantId = mRecordId.substring(0, mRecordId.length() - 1) + i;
                                iTamizaje.setRecordId(infantId);
                                iTamizaje.setInfInfid(infantId);
                                zikaPosA.crearZp00aInfantScreening(iTamizaje);
                            }
                        }
                    }else{
                        infantId = mRecordId.substring(0, mRecordId.length() - 1) + "1" ;
                        iTamizaje.setRecordId(infantId);
                        iTamizaje.setInfInfid(infantId);
                        zikaPosA.crearZp00aInfantScreening(iTamizaje);
                    }

                }else{
                    infantId = mRecordId.substring(0, mRecordId.length() - 1) + "1" ;
                    iTamizaje.setRecordId(infantId);
                    iTamizaje.setInfInfid(infantId);
                    zikaPosA.crearZp00aInfantScreening(iTamizaje);

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
