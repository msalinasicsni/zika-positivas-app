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
import ni.org.ics.zikapositivas.appmovil.domain.Zp07InfantOtoacousticEmissions;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp07InfantOtoacousticEXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;

/**
 * Created by ics on 2/2/2018.
 * V1.0
 */
public class NewZp07InfantOtoacousticEmissionsActivity extends AbstractAsyncActivity {
    protected static final String TAG = NewZp07InfantOtoacousticEmissionsActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPosA;
    private static Zp07InfantOtoacousticEmissions mInfOtoE = null;

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
            Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.error ) + "," + getString(R.string.storage_error),Toast.LENGTH_LONG);
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
        mInfOtoE = (Zp07InfantOtoacousticEmissions) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP07OtoE);
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
        if (mInfOtoE != null){
                message.setText(getString(R.string.edit)+ " " + getString(R.string.infant_b_9)+"?");
            }else{
                message.setText(getString(R.string.add)+ " " + getString(R.string.infant_b_9)+"?");
            }


        //add some action to the buttons
        Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
        yes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                dialogInit.dismiss();
                addZp07InfantOtoacousticE();
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
                    parseZp07InfantOtoacousticE(idInstancia, instanceFilePath, accion);
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

    private void addZp07InfantOtoacousticE() {
        try {
            Uri formUri;
            if (mInfOtoE == null) {
                //campos de proveedor de collect
                String[] projection = new String[]{
                        "_id", "jrFormId", "displayName"};
                //cursor que busca el formulario
                Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
                        "jrFormId = 'ZPos07_Infant_Otoacoustic_Emissions' and displayName = 'Zika Positivas Formulario Emisiones Otoacusticas'", null, null);
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

                Integer id = mInfOtoE.getIdInstancia();
                formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I, id);
                accion = EDIT_ZP07_ODK;
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

    private void parseZp07InfantOtoacousticE(Integer idInstancia, String instanceFilePath, Integer accion) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp07InfantOtoacousticEXml zp07Xml = serializer.read(Zp07InfantOtoacousticEXml.class, source);
            if (accion== ADD_ZP07_ODK) mInfOtoE = new Zp07InfantOtoacousticEmissions();
            mInfOtoE.setRecordId(mRecordId);
            mInfOtoE.setRedcapEventName(event);
            mInfOtoE.setInfantVisitDate(zp07Xml.getInfantVisitDate());
            mInfOtoE.setInfantStatus(zp07Xml.getInfantStatus());
            mInfOtoE.setInfantVisit(zp07Xml.getInfantVisit());
            mInfOtoE.setInfantAgeMonths(zp07Xml.getInfantAgeMonths());
            mInfOtoE.setInfantOae(zp07Xml.getInfantOae());
            mInfOtoE.setInfantOphthType(zp07Xml.getInfantOphthType());
            mInfOtoE.setInfantHearingOverall(zp07Xml.getInfantHearingOverall());
            mInfOtoE.setInfantRoae(zp07Xml.getInfantRoae());
            mInfOtoE.setInfantRaabr(zp07Xml.getInfantRaabr());
            mInfOtoE.setInfantLoae(zp07Xml.getInfantLoae());
            mInfOtoE.setInfantLaabr(zp07Xml.getInfantLaabr());
            mInfOtoE.setInfantComments2(zp07Xml.getInfantComments2());
            mInfOtoE.setInfantIdCompleting(username);
            mInfOtoE.setInfantDtComp(new Date());
            mInfOtoE.setInfantIdReviewer(username);
            mInfOtoE.setInfantDtReview(new Date());
            mInfOtoE.setInfantIdDataEntry(username);
            mInfOtoE.setInfantDtEnter(new Date());
            mInfOtoE.setIdInstancia(idInstancia);
            mInfOtoE.setRecordDate(new Date());
            mInfOtoE.setRecordUser(username);
            mInfOtoE.setInstancePath(instanceFilePath);
            mInfOtoE.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mInfOtoE.setStart(zp07Xml.getStart());
            mInfOtoE.setEnd(zp07Xml.getEnd());
            mInfOtoE.setDeviceid(zp07Xml.getDeviceid());
            mInfOtoE.setSimserial(zp07Xml.getSimserial());
            mInfOtoE.setPhonenumber(zp07Xml.getPhonenumber());
            mInfOtoE.setToday(zp07Xml.getToday());

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
                    if (accionaRealizar == ADD_ZP07_ODK){
                        zikaPosA.crearZp07InfantOtoacousticEm(mInfOtoE);
                    }
                    else{
                        zikaPosA.editarcrearZp07InfantOtoacousticEm(mInfOtoE);
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
