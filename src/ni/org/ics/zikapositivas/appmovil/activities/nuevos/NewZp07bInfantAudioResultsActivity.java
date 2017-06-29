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
import ni.org.ics.zikapositivas.appmovil.domain.Zp07bInfantAudioResults;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp07bInfantAudioResultsXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;

/**
 * Created by ics on 20/6/2017.
 * V1.0
 */
public class NewZp07bInfantAudioResultsActivity extends AbstractAsyncActivity {
    protected static final String TAG = NewZp07bInfantAudioResultsActivity.class.getSimpleName();

    private ZikaPosAdapter zikaPos;
    private static Zp07bInfantAudioResults mInfantAssessment = null;

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
        mInfantAssessment = (Zp07bInfantAudioResults) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP07B);
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
            message.setText(getString(R.string.edit) + " " + getString(R.string.infant_b_6) + "?");

        } else {
            message.setText(getString(R.string.add) + " " + getString(R.string.infant_b_6) + "?");
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
                    parseZp07bInfantAudioResults(idInstancia, instanceFilePath, accion);
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
        try {
            Uri formUri;
            if (mInfantAssessment == null) {
                //campos de proveedor de collect
                String[] projection = new String[]{
                        "_id", "jrFormId", "displayName"};
                //cursor que busca el formulario
                Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
                        "jrFormId = 'ZPos07b_Infant_Audio_Results' and displayName = 'Zika Positivas - Resultados de examenes Audiologicos'", null, null);
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

                Integer id = mInfantAssessment.getIdInstancia();
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

    private void parseZp07bInfantAudioResults(Integer idInstancia, String instanceFilePath, Integer accion) {
        Serializer serializer = new Persister();
        File source = new File(instanceFilePath);
        try {
            Zp07bInfantAudioResultsXml zp07bXml = serializer.read(Zp07bInfantAudioResultsXml.class, source);
            if (accion== ADD_ZP07_ODK) mInfantAssessment = new Zp07bInfantAudioResults();
            mInfantAssessment.setRecordId(mRecordId);
            mInfantAssessment.setRedcapEventName(event);
            mInfantAssessment.setInfantAudioDate(zp07bXml.getInfantAudioDate());
            mInfantAssessment.setInfantAudioAir(zp07bXml.getInfantAudioAir());
            mInfantAssessment.setInfantAr500rt(zp07bXml.getInfantAr500rt());
            mInfantAssessment.setInfantAr500lft(zp07bXml.getInfantAr500lft());
            mInfantAssessment.setInfantAr500vra(zp07bXml.getInfantAr500vra());
            mInfantAssessment.setInfantAr1000rt(zp07bXml.getInfantAr1000rt());
            mInfantAssessment.setInfantAr1000lft(zp07bXml.getInfantAr1000lft());
            mInfantAssessment.setInfantAr1000vra(zp07bXml.getInfantAr1000vra());
            mInfantAssessment.setInfantAr2000rt(zp07bXml.getInfantAr2000rt());
            mInfantAssessment.setInfantAr2000lft(zp07bXml.getInfantAr2000lft());
            mInfantAssessment.setInfantAr2000vra(zp07bXml.getInfantAr2000vra());
            mInfantAssessment.setInfantAr4000rt(zp07bXml.getInfantAr4000rt());
            mInfantAssessment.setInfantAr4000lft(zp07bXml.getInfantAr4000lft());
            mInfantAssessment.setInfantAr4000vra(zp07bXml.getInfantAr4000vra());
            mInfantAssessment.setInfantTransducer(zp07bXml.getInfantTransducer());
            mInfantAssessment.setInfantAudioBone(zp07bXml.getInfantAudioBone());
            mInfantAssessment.setInfantUnmask1(zp07bXml.getInfantUnmask1());
            mInfantAssessment.setInfantUnmask2(zp07bXml.getInfantUnmask2());
            mInfantAssessment.setInfantUnmask3(zp07bXml.getInfantUnmask3());
            mInfantAssessment.setInfantUnmask4(zp07bXml.getInfantUnmask4());
            mInfantAssessment.setInfantImtanceRt(zp07bXml.getInfantImtanceRt());
            mInfantAssessment.setInfantImrtReas(zp07bXml.getInfantImrtReas());
            mInfantAssessment.setInfantImrtMl(zp07bXml.getInfantImrtMl());
            mInfantAssessment.setInfantImrtDapa(zp07bXml.getInfantImrtDapa());
            mInfantAssessment.setInfantImrtAdmi(zp07bXml.getInfantImrtAdmi());
            mInfantAssessment.setInfantImrtTym(zp07bXml.getInfantImrtTym());
            mInfantAssessment.setInfantImtanceLt(zp07bXml.getInfantImtanceLt());
            mInfantAssessment.setInfantImltReas(zp07bXml.getInfantImltReas());
            mInfantAssessment.setInfantImltMl(zp07bXml.getInfantImltMl());
            mInfantAssessment.setInfantImltDapa(zp07bXml.getInfantImltDapa());
            mInfantAssessment.setInfantImltAdmi(zp07bXml.getInfantImltAdmi());
            mInfantAssessment.setInfantImltTym(zp07bXml.getInfantImltTym());
            mInfantAssessment.setInfantImltProbe(zp07bXml.getInfantImltProbe());
            mInfantAssessment.setInfantOe(zp07bXml.getInfantOe());
            mInfantAssessment.setInfatnOetype(zp07bXml.getInfatnOetype());
            mInfantAssessment.setInfantOert(zp07bXml.getInfantOert());
            mInfantAssessment.setInfantOertRea(zp07bXml.getInfantOertRea());
            mInfantAssessment.setInfantOert19(zp07bXml.getInfantOert19());
            mInfantAssessment.setInfantOert29(zp07bXml.getInfantOert29());
            mInfantAssessment.setInfantOert39(zp07bXml.getInfantOert39());
            mInfantAssessment.setInfantOert49(zp07bXml.getInfantOert49());
            mInfantAssessment.setInfantOelt(zp07bXml.getInfantOelt());
            mInfantAssessment.setInfantOeltRea(zp07bXml.getInfantOeltRea());
            mInfantAssessment.setInfantOelt19(zp07bXml.getInfantOelt19());
            mInfantAssessment.setInfantOelt29(zp07bXml.getInfantOelt29());
            mInfantAssessment.setInfantOelt39(zp07bXml.getInfantOelt39());
            mInfantAssessment.setInfantOelt49(zp07bXml.getInfantOelt49());
            mInfantAssessment.setInfantAbr(zp07bXml.getInfantAbr());
            mInfantAssessment.setInfantAb500rt(zp07bXml.getInfantAb500rt());
            mInfantAssessment.setInfantAb500lt(zp07bXml.getInfantAb500lt());
            mInfantAssessment.setInfantAb1000rt(zp07bXml.getInfantAb1000rt());
            mInfantAssessment.setInfantAb1000lt(zp07bXml.getInfantAb1000lt());
            mInfantAssessment.setInfantAb2000rt(zp07bXml.getInfantAb2000rt());
            mInfantAssessment.setInfantAb2000lt(zp07bXml.getInfantAb2000lt());
            mInfantAssessment.setInfantEarphone(zp07bXml.getInfantEarphone());
            mInfantAssessment.setInfantImpress(zp07bXml.getInfantImpress());
            mInfantAssessment.setInfantTypeRt(zp07bXml.getInfantTypeRt());
            mInfantAssessment.setInfantTypeLt(zp07bXml.getInfantTypeLt());
            mInfantAssessment.setInfantTypeSound(zp07bXml.getInfantConfigSound());
            mInfantAssessment.setInfantExtentRt(zp07bXml.getInfantExtentRt());
            mInfantAssessment.setInfantExtentLt(zp07bXml.getInfantExtentLt());
            mInfantAssessment.setInfantExtentSound(zp07bXml.getInfantExtentSound());
            mInfantAssessment.setInfantConfigRt(zp07bXml.getInfantConfigRt());
            mInfantAssessment.setInfantConfigLt(zp07bXml.getInfantConfigLt());
            mInfantAssessment.setInfantConfigSound(zp07bXml.getInfantConfigSound());
            mInfantAssessment.setInfantExamReliable(zp07bXml.getInfantExamReliable());
            mInfantAssessment.setInfantRenotReliable(zp07bXml.getInfantRenotReliable());
            mInfantAssessment.setInfantNreliableOther(zp07bXml.getInfantNreliableOther());
            mInfantAssessment.setInfantAutocom(zp07bXml.getInfantAutocom());
            mInfantAssessment.setInfantComAudo(zp07bXml.getInfantComAudo());
            mInfantAssessment.setInfantAuLne(zp07bXml.getInfantAuLne());
            mInfantAssessment.setInfantAuFne(zp07bXml.getInfantAuFne());
            mInfantAssessment.setInfantAuPhone(zp07bXml.getInfantAuPhone());
            mInfantAssessment.setInfantAuSignat(zp07bXml.getInfantAuSignat());
            mInfantAssessment.setInfantAuDate(zp07bXml.getInfantAuDate());
            mInfantAssessment.setInfantAuidCom(username);
            mInfantAssessment.setInfantAudtCom(new Date());
            mInfantAssessment.setInfantAueyeIdRevi(username);
            mInfantAssessment.setInfantAudtRevi(new Date());
            mInfantAssessment.setInfantAuidEntry(username);
            mInfantAssessment.setInfantAudtEnt(new Date());

            mInfantAssessment.setIdInstancia(idInstancia);
            mInfantAssessment.setRecordDate(new Date());
            mInfantAssessment.setRecordUser(username);
            mInfantAssessment.setInstancePath(instanceFilePath);
            mInfantAssessment.setEstado(Constants.STATUS_NOT_SUBMITTED);
            mInfantAssessment.setStart(zp07bXml.getStart());
            mInfantAssessment.setEnd(zp07bXml.getEnd());
            mInfantAssessment.setDeviceid(zp07bXml.getDeviceid());
            mInfantAssessment.setSimserial(zp07bXml.getSimserial());
            mInfantAssessment.setPhonenumber(zp07bXml.getPhonenumber());
            mInfantAssessment.setToday(zp07bXml.getToday());



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
                        zikaPos.crearZp07bInfantAudioResults(mInfantAssessment);
                    }
                    else{
                        zikaPos.editarZp07bInfantAudioResults(mInfantAssessment);
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
