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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp01StudyEntrySectionFtoK;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp01StudyEntrySectionFtoKXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.R;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;


public class NewZp01StudyEntrySectionFtoKActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewZp01StudyEntrySectionFtoKActivity.class.getSimpleName();
	
	private ZikaPosAdapter zikaPosA;
	private static Zp01StudyEntrySectionFtoK mZp01F = null;
	
	public static final int ADD_ZP01F_ODK = 1;
	public static final int EDIT_ZP01F_ODK = 2;

	Dialog dialogInit;
	private SharedPreferences settings;
	private String username;
	private String mRecordId = "";
	private Integer accion = 0;

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
		mZp01F = (Zp01StudyEntrySectionFtoK) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP01F);
        mRecordId = getIntent().getExtras().getString(Constants.RECORDID);
        zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
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
		if (mZp01F!=null){
			message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_3)+"?");
		}
		else{
			message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_3)+"?");
		}

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				addZp01StudyEntryFtoK();
			}
		});

		Button no = (Button) dialogInit.findViewById(R.id.yesnoNo);
		no.setOnClickListener(new OnClickListener() {

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
		if(requestCode == ADD_ZP01F_ODK||requestCode == EDIT_ZP01F_ODK) {
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
					parseZp01StudyEntryFtoK(idInstancia, instanceFilePath,accion);
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
	private void addZp01StudyEntryFtoK() {
		try{
			Uri formUri;
			if(mZp01F==null){
				//campos de proveedor de collect
				String[] projection = new String[] {
						"_id","jrFormId","displayName"};
				//cursor que busca el formulario
				Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
						"jrFormId = 'zp01_study_entry_f_k' and displayName = 'Estudio ZIP Visita inicial en el estudio_F_K'", null, null);
				c.moveToFirst();
				//captura el id del formulario
				Integer id = Integer.parseInt(c.getString(0));
				//cierra el cursor
				if (c != null) {
					c.close();
				}
				//forma el uri para ODK Collect
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
				accion = ADD_ZP01F_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mZp01F.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP01F_ODK;
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
	
	private void parseZp01StudyEntryFtoK(Integer idInstancia, String instanceFilePath, Integer accion) {
		Serializer serializer = new Persister(); 
		File source = new File(instanceFilePath);
		try {
			Zp01StudyEntrySectionFtoKXml zp01Xml = new Zp01StudyEntrySectionFtoKXml();
			zp01Xml = serializer.read(Zp01StudyEntrySectionFtoKXml.class, source);
			if (accion==ADD_ZP01F_ODK) mZp01F = new Zp01StudyEntrySectionFtoK();
			mZp01F.setRecordId(mRecordId);
			mZp01F.setRedcapEventName(Constants.ENTRY);
			mZp01F.setSeaPreg(zp01Xml.getSeaPreg());
            mZp01F.setSeaFirstPreg(zp01Xml.getSeaFirstPreg());
            mZp01F.setSeaAnemia(zp01Xml.getSeaAnemia());
            mZp01F.setSeaVaginal(zp01Xml.getSeaVaginal());
            mZp01F.setSeaUtiPrior(zp01Xml.getSeaUtiPrior());
            mZp01F.setSeaSexually(zp01Xml.getSeaSexually());
            mZp01F.setSeaPreterm(zp01Xml.getSeaPreterm());
            mZp01F.setSeaPreeclampsia(zp01Xml.getSeaPreeclampsia());
            mZp01F.setSeaEclampsia(zp01Xml.getSeaEclampsia());
            mZp01F.setSeaHeart(zp01Xml.getSeaHeart());
            mZp01F.setSeaNeuropathy(zp01Xml.getSeaNeuropathy());
            mZp01F.setSeaGestational(zp01Xml.getSeaGestational());
            mZp01F.setSeaTotalPreg(zp01Xml.getSeaTotalPreg());
            mZp01F.setSeaDeliveryDate1(zp01Xml.getSeaDeliveryDate1());
            mZp01F.setSeaGage1(zp01Xml.getSeaGage1());
            mZp01F.setSeaOutcome1(zp01Xml.getSeaOutcome1());
            mZp01F.setSeaBdefects1(zp01Xml.getSeaBdefects1());
            mZp01F.setSeaDeliveryDate2(zp01Xml.getSeaDeliveryDate2());
            mZp01F.setSeaGage2(zp01Xml.getSeaGage2());
            mZp01F.setSeaOutcome2(zp01Xml.getSeaOutcome2());
            mZp01F.setSeaBdefects2(zp01Xml.getSeaBdefects2());
            mZp01F.setSeaDeliveryDate3(zp01Xml.getSeaDeliveryDate3());
            mZp01F.setSeaGage3(zp01Xml.getSeaGage3());
            mZp01F.setSeaOutcome3(zp01Xml.getSeaOutcome3());
            mZp01F.setSeaBdefects3(zp01Xml.getSeaBdefects3());
            mZp01F.setSeaDeliveryDate4(zp01Xml.getSeaDeliveryDate4());
            mZp01F.setSeaGage4(zp01Xml.getSeaGage4());
            mZp01F.setSeaOutcome4(zp01Xml.getSeaOutcome4());
            mZp01F.setSeaBdefects4(zp01Xml.getSeaBdefects4());
            mZp01F.setSeaDeliveryDate5(zp01Xml.getSeaDeliveryDate5());
            mZp01F.setSeaGage5(zp01Xml.getSeaGage5());
            mZp01F.setSeaOutcome5(zp01Xml.getSeaOutcome5());
            mZp01F.setSeaBdefects5(zp01Xml.getSeaBdefects5());
            mZp01F.setSeaDeliveryDate6(zp01Xml.getSeaDeliveryDate6());
            mZp01F.setSeaGage6(zp01Xml.getSeaGage6());
            mZp01F.setSeaOutcome6(zp01Xml.getSeaOutcome6());
            mZp01F.setSeaBdefects6(zp01Xml.getSeaBdefects6());
            mZp01F.setSeaPersisHeadache(zp01Xml.getSeaPersisHeadache());
            mZp01F.setSeaDizziness(zp01Xml.getSeaDizziness());
            mZp01F.setSeaNausea(zp01Xml.getSeaNausea());
            mZp01F.setSeaVomiting(zp01Xml.getSeaVomiting());
            mZp01F.setSeaSeeingLights(zp01Xml.getSeaSeeingLights());
            mZp01F.setSeaSpecifyType(zp01Xml.getSeaSpecifyType());
            mZp01F.setSeaSwelling(zp01Xml.getSeaSwelling());
            mZp01F.setSeaFetalMov(zp01Xml.getSeaFetalMov());
            mZp01F.setSeaMovUsual(zp01Xml.getSeaMovUsual());
            mZp01F.setSeaMovDecreased(zp01Xml.getSeaMovDecreased());
            mZp01F.setSeaContraction(zp01Xml.getSeaContraction());
            mZp01F.setSeaFreqWeek(zp01Xml.getSeaFreqWeek());
            mZp01F.setSeaFreqDay(zp01Xml.getSeaFreqDay());
            mZp01F.setSeaFreqHour(zp01Xml.getSeaFreqHour());
            mZp01F.setSeaFreqMin(zp01Xml.getSeaFreqMin());
            mZp01F.setSeaVagiDischarge(zp01Xml.getSeaVagiDischarge());
            mZp01F.setSeaCharacterDisch(zp01Xml.getSeaCharacterDisch());//multiple
            mZp01F.setSeaBleeding(zp01Xml.getSeaBleeding());
            mZp01F.setSeaYesBleeding(zp01Xml.getSeaYesBleeding());
            mZp01F.setSeaUti(zp01Xml.getSeaUti());
            mZp01F.setSeaPrenatalCare(zp01Xml.getSeaPrenatalCare());
            mZp01F.setSeaMutiv(zp01Xml.getSeaMutiv());
            mZp01F.setSeaIron(zp01Xml.getSeaIron());
            mZp01F.setSeaOften(zp01Xml.getSeaOften());
            mZp01F.setSeaProvideSym(zp01Xml.getSeaProvideSym());
            mZp01F.setSeaReminderPreg(zp01Xml.getSeaReminderPreg());
            mZp01F.setSeaReminderProvided(zp01Xml.getSeaReminderProvided());
            mZp01F.setSeaOneweekDate(zp01Xml.getSeaOneweekDate());
            mZp01F.setSeaOneweekTime(zp01Xml.getSeaOneweekTime());
            mZp01F.setSeaNextDate(zp01Xml.getSeaNextDate());
            mZp01F.setSeaNextTime(zp01Xml.getSeaNextTime());
            mZp01F.setSeaIdCompleting(username);
            mZp01F.setSeaDateCompleted(new Date());
            mZp01F.setSeaIdReviewer(username);
            mZp01F.setSeaDateReviewed(new Date());
            mZp01F.setSeaIdDataEntry(username);
            mZp01F.setSeaDateEntered(new Date());

			mZp01F.setRecordDate(new Date());
			mZp01F.setRecordUser(username);
			mZp01F.setIdInstancia(idInstancia);
			mZp01F.setInstancePath(instanceFilePath);
			mZp01F.setEstado(Constants.STATUS_NOT_SUBMITTED);
			mZp01F.setStart(zp01Xml.getStart());
			mZp01F.setEnd(zp01Xml.getEnd());
			mZp01F.setDeviceid(zp01Xml.getDeviceid());
			mZp01F.setSimserial(zp01Xml.getSimserial());
			mZp01F.setPhonenumber(zp01Xml.getPhonenumber());
			mZp01F.setToday(zp01Xml.getToday());

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
				if (accionaRealizar == ADD_ZP01F_ODK){
					zikaPosA.crearZp01StudyEntrySectionFtoK(mZp01F);
				}
				else{
					zikaPosA.editarZp01StudyEntrySectionFtoK(mZp01F);
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
