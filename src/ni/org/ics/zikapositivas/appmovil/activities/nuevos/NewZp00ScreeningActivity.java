package ni.org.ics.zikapositivas.appmovil.activities.nuevos;

import java.io.File;
import java.util.Date;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.MenuEmbarazadasActivity;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp00Screening;
import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoEmbarazada;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp00ScreeningXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class NewZp00ScreeningActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewZp00ScreeningActivity.class.getSimpleName();
	
	private ZikaPosAdapter zikaPosA;
	private static Zp00Screening mTamizaje = null;
	private static ZpEstadoEmbarazada mEstado = null;
	
	public static final int ADD_TAMIZAJE_ODK = 1;
	public static final int BARCODE_CAPTURE_TAM = 2;

	Dialog dialogInit;
	private AlertDialog alertDialog;
	private static final int ADD_TAM_MANUAL = 100;
	private static final int CONFIRM_NUM_TAMIZAJE = 101;
	
	private SharedPreferences settings;
	private boolean barcode;
	private String username;
	private String mRecordId = "";
	private String mPreScreenId = "";
	
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
		barcode = settings.getBoolean(PreferencesActivity.KEY_BARCODE, true);
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		mPreScreenId = getIntent().getStringExtra(Constants.PRESCREENID);
		String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
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
		message.setText(getString(R.string.add)+ " " + getString(R.string.mat_tam)+"?");

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				if(barcode){
					Intent i = new Intent("com.google.zxing.client.android.SCAN");
					try {
						startActivityForResult(i, BARCODE_CAPTURE_TAM);
					} catch (ActivityNotFoundException e) {
						Toast t = Toast.makeText(getApplicationContext(),
								getString(R.string.error, R.string.barcode_error),
								Toast.LENGTH_LONG);
						t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
						t.show();
					}
				}
				else{
					createDialog(ADD_TAM_MANUAL);
				}
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
		if (requestCode == BARCODE_CAPTURE_TAM && intent != null) {
			mRecordId = intent.getStringExtra("SCAN_RESULT");
			if (mRecordId != null && mRecordId.length() > 0) {
				try{
					if(!(mRecordId.matches("^ZP[0-9][0-9][0-9][0-3]$"))){
						Toast.makeText(getApplicationContext(),	getString(R.string.scan_error), Toast.LENGTH_LONG).show();
						createInitDialog();
						return;
					}
					else{
						createDialog(CONFIRM_NUM_TAMIZAJE);
					}
				}
				catch(Exception e){
					Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
					return;
				}
			}
		}
		else{
			finish();
		}
		if(requestCode == ADD_TAMIZAJE_ODK) {
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
					parseTamizaje(idInstancia,instanceFilePath);
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
	private void addTamizaje() {
		try{
			//campos de proveedor de collect
			String[] projection = new String[] {
					"_id","jrFormId","displayName"};
			//cursor que busca el formulario
			Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
					"jrFormId = 'ZPos00_screening' and displayName = 'Zika Positivas Visita de Tamizaje'", null, null);
			c.moveToFirst();
			//captura el id del formulario
			Integer id = Integer.parseInt(c.getString(0));
			//cierra el cursor
			if (c != null) {
				c.close();
			}
			//forma el uri para ODK Collect
			Uri formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
			//Arranca la actividad ODK Collect en busca de resultado
			Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
			startActivityForResult(odkA, ADD_TAMIZAJE_ODK);
		}
		catch(Exception e){
			//No existe el formulario en el equipo
			Log.e(TAG, e.getMessage(), e);
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
			finish();
		}
	}
	
	private void parseTamizaje(Integer idInstancia, String instanceFilePath) {
		Serializer serializer = new Persister(); 
		File source = new File(instanceFilePath);
		try {
			mTamizaje = new Zp00Screening();
			Zp00ScreeningXml zp00Xml = new Zp00ScreeningXml();
			zp00Xml = serializer.read(Zp00ScreeningXml.class, source);
			mTamizaje.setRecordId(mRecordId);
			mTamizaje.setPreScreenId(mPreScreenId);
			mTamizaje.setRedcapEventName(Constants.SCREENING);
			mTamizaje.setScrVisitDate(zp00Xml.getScrVisitDate());
			mTamizaje.setScrVerbalConsent(zp00Xml.getScrVerbalConsent());
			mTamizaje.setScrRemain(zp00Xml.getScrRemain());
			mTamizaje.setScrAge(zp00Xml.getScrAge());
			mTamizaje.setScrAge15(zp00Xml.getScrAge15());
			mTamizaje.setScrPregnant(zp00Xml.getScrPregnant());
			mTamizaje.setScrPreWeeks(zp00Xml.getScrPreWeeks());
			mTamizaje.setScrPreDays(zp00Xml.getScrPreDays());
			mTamizaje.setScrPregant13(zp00Xml.getScrPregant13());
			mTamizaje.setScrZikaOther(zp00Xml.getScrZikaOther());
			mTamizaje.setScrMeetCriteria(zp00Xml.getScrMeetCriteria());
			mTamizaje.setScrConsentObta(zp00Xml.getScrConsentObta());
			mTamizaje.setScrObDobDay(zp00Xml.getScrObDobDay());
			mTamizaje.setScrObDobMon(zp00Xml.getScrObDobMon());
			mTamizaje.setScrObDobYear(zp00Xml.getScrObDobYear());
			mTamizaje.setScrObAge(zp00Xml.getScrObAge());
			mTamizaje.setScrObAssent(zp00Xml.getScrObAssent());
			mTamizaje.setScrConsentA(zp00Xml.getScrConsentA());
			mTamizaje.setScrConsentB(zp00Xml.getScrConsentB());
			mTamizaje.setScrConsentC(zp00Xml.getScrConsentC());
			mTamizaje.setScrConsentD(zp00Xml.getScrConsentD());
			mTamizaje.setScrConsentE(zp00Xml.getScrConsentE());
			mTamizaje.setScrConsentF(zp00Xml.getScrConsentF());
			mTamizaje.setScrAddtConsentG(zp00Xml.getScrAddtConsentG());
			mTamizaje.setScrPreviousZikaPos(zp00Xml.getScrPreviousZikaPos());
			mTamizaje.setScrPreviousStudyId(zp00Xml.getScrPreviousStudyId());
			mTamizaje.setScrPreStudyNa(zp00Xml.getScrPreStudyNa());
			mTamizaje.setScrReasonNot(zp00Xml.getScrReasonNot());
			mTamizaje.setScrReasonOther(zp00Xml.getScrReasonOther());
			mTamizaje.setScrIdCompleting(username);
			mTamizaje.setScrDateCompleted(new Date());
			mTamizaje.setScrIdReviewer(username);
			mTamizaje.setScrDateReviewed(new Date());
			mTamizaje.setScrIdDataEntry(username);
			mTamizaje.setScrDateEntered(new Date());
			mTamizaje.setRecordDate(new Date());
			mTamizaje.setRecordUser(username);
			mTamizaje.setIdInstancia(idInstancia);
			mTamizaje.setInstancePath(instanceFilePath);
			mTamizaje.setEstado(Constants.STATUS_NOT_SUBMITTED);
			mTamizaje.setStart(zp00Xml.getStart());
			mTamizaje.setEnd(zp00Xml.getEnd());
			mTamizaje.setDeviceid(zp00Xml.getDeviceid());
			mTamizaje.setSimserial(zp00Xml.getSimserial());
			mTamizaje.setPhonenumber(zp00Xml.getPhonenumber());
			mTamizaje.setToday(zp00Xml.getToday());
			mEstado = new ZpEstadoEmbarazada();
			mEstado.setRecordId(mRecordId);
			mEstado.setRecordDate(new Date());
			mEstado.setRecordUser(username);
			mEstado.setIdInstancia(idInstancia);
			mEstado.setInstancePath(instanceFilePath);
			mEstado.setEstado(Constants.STATUS_NOT_SUBMITTED);
			mEstado.setStart(zp00Xml.getStart());
			mEstado.setEnd(zp00Xml.getEnd());
			mEstado.setDeviceid(zp00Xml.getDeviceid());
			mEstado.setSimserial(zp00Xml.getSimserial());
			mEstado.setPhonenumber(zp00Xml.getPhonenumber());
			mEstado.setToday(zp00Xml.getToday());
			new SaveDataTask().execute();
			
		} catch (Exception e) {
			// Presenta el error al parsear el xml
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
			finish();
		}		
	}
	
	private void createDialog(int dialog) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		switch(dialog){
		case ADD_TAM_MANUAL:
			builder.setTitle(this.getString(R.string.add));
			builder.setMessage(getString(R.string.enter)+ " " + getString(R.string.mat_id));
			builder.setIcon(android.R.drawable.ic_dialog_info);
			// Set an EditText view to get user input 
			final EditText input = new EditText(this);
			input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
			builder.setView(input);
			builder.setPositiveButton(this.getString(R.string.ok), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					mRecordId = input.getText().toString(); 
					if(!(mRecordId.matches("^ZP[0-9][0-9][0-9][0-3]$"))){
						Toast.makeText(getApplicationContext(),	getString(R.string.code_error), Toast.LENGTH_LONG).show();
						createDialog(ADD_TAM_MANUAL);
						return;
					}
					else{
						createDialog(CONFIRM_NUM_TAMIZAJE);
					}
				}
			});
			builder.setNegativeButton(this.getString(R.string.cancel), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// Do nothing
					dialog.dismiss();
					finish();
				}
			});
			break;
		case CONFIRM_NUM_TAMIZAJE:
			builder.setTitle(this.getString(R.string.confirm));
			builder.setMessage(this.getString(R.string.mat_id)+ " " + mRecordId + "?");
			builder.setIcon(android.R.drawable.ic_dialog_info);
			builder.setPositiveButton(this.getString(R.string.ok), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					new FindDataTask().execute(mRecordId);
				}
			});
			builder.setNegativeButton(this.getString(R.string.cancel), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// Do nothing
					dialog.dismiss();
					finish();
				}
			});
			break;
		default:
			break;
		}
		alertDialog = builder.create();
		alertDialog.show();
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
				zikaPosA.crearZp00Screening(mTamizaje);
				zikaPosA.crearZpEstadoEmbarazada(mEstado);
				zikaPosA.close();
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return "Error";
			}
			return "Exito";
		}

		protected void onPostExecute(String resultado) {
			// after the network request completes, hide the progress indicator
			dismissProgressDialog();
			showResult(resultado);
			if (mTamizaje.getScrRemain().equals("0") || mTamizaje.getScrAge15().equals("0") || mTamizaje.getScrPregnant().equals("0")
					|| mTamizaje.getScrPregant13().equals("0")|| mTamizaje.getScrZikaOther().equals("1") || mTamizaje.getScrMeetCriteria().equals("0")
					|| mTamizaje.getScrConsentObta().equals("0")){
				Toast.makeText(getApplicationContext(),	getString(R.string.notelegible), Toast.LENGTH_LONG).show();
			}
			else if(mTamizaje.getScrConsentObta().equals("1") && mTamizaje.getScrObAge()<18){
				if(mTamizaje.getScrObAssent().matches("0"))
                    Toast.makeText(getApplicationContext(),	getString(R.string.notelegible), Toast.LENGTH_LONG).show();
                else
                    cargarMenu();
			}
			else{
				cargarMenu();
			}
			finish();
		}

	}

    private void cargarMenu(){
        Bundle arguments = new Bundle();
        if (mTamizaje!=null) arguments.putSerializable(Constants.OBJECTO_ZP00 , mTamizaje);
        Intent i = new Intent(getApplicationContext(),
                MenuEmbarazadasActivity.class);
        i.putExtras(arguments);
        startActivity(i);
    }
	// ***************************************
	// Private methods
	// ***************************************
	private void showResult(String resultado) {
		Toast.makeText(getApplicationContext(),	resultado, Toast.LENGTH_LONG).show();
	}	
	
	// ***************************************
	// Private classes
	// ***************************************
	private class FindDataTask extends AsyncTask<String, Void, String> {
		private String filtro = null;
		@Override
		protected void onPreExecute() {
			// before the request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected String doInBackground(String... values) {
			filtro = MainDBConstants.recordId + "='" + values[0] + "'";
			try {
				zikaPosA.open();
				mTamizaje = zikaPosA.getZp00Screening(filtro, null);
				zikaPosA.close();
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return "Error";
			}
			return "Exito";
		}

		protected void onPostExecute(String resultado) {
			// after the network request completes, hide the progress indicator
			dismissProgressDialog();
			if(mTamizaje!=null){
				Toast.makeText(getApplicationContext(),	getString(R.string.err_duplicated), Toast.LENGTH_LONG).show();
				finish();
			}
			else{
				addTamizaje();
			}
		}	

	}	


}
