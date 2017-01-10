package ni.org.ics.zikapositivas.appmovil.activities.nuevos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.activities.DataEnterActivity;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.ZpDatosEmbarazada;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.DeviceInfo;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.R;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class NewDatosEmbarazadaActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewDatosEmbarazadaActivity.class.getSimpleName();
	public static final int ADD_DATOS = 1;
	private Dialog dialogInit;
	private DeviceInfo infoMovil;
	private String mRecordId;
	private SharedPreferences settings;
	private String username;
	private ZikaPosAdapter zikaPosA;
	private ZpDatosEmbarazada mZpDatos = null;

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
		infoMovil = new DeviceInfo(NewDatosEmbarazadaActivity.this);
		mRecordId = getIntent().getStringExtra(Constants.RECORDID);
		mZpDatos = (ZpDatosEmbarazada) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZPDATA);
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
		if (mZpDatos!=null){
			message.setText(getString(R.string.edit)+ " " + getString(R.string.mat_data)+"?");
		}
		else{
			message.setText(getString(R.string.add)+ " " + getString(R.string.mat_data)+"?");
		}

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				addDatosEmbarazada();
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

		if(requestCode == ADD_DATOS) {
	        if(resultCode == RESULT_OK) {
	        	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        	mZpDatos.setRecordId(mRecordId);
	        	mZpDatos.setCs(intent.getExtras().getString(this.getString(R.string.cs)));
	        	mZpDatos.setNombre1(intent.getExtras().getString(this.getString(R.string.nombre1)));
	        	mZpDatos.setNombre2(intent.getExtras().getString(this.getString(R.string.nombre2)));
	        	mZpDatos.setApellido1(intent.getExtras().getString(this.getString(R.string.apellido1)));
	        	mZpDatos.setApellido2(intent.getExtras().getString(this.getString(R.string.apellido2)));
	        	mZpDatos.setDireccion(intent.getExtras().getString(this.getString(R.string.direccion)));
	        	try {
	        		if(intent.getExtras().getString(this.getString(R.string.fechaNac))!=null){
		        		Date todayDate = formatter.parse(formatter.format(new Date()));
						Date fecnac = formatter.parse(intent.getExtras().getString(this.getString(R.string.fechaNac)));
						if(fecnac.before(todayDate)) mZpDatos.setFechaNac(fecnac);
	        		}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	mZpDatos.setTelefonoContacto(intent.getExtras().getString(this.getString(R.string.telefonoContacto)));
	        	mZpDatos.setRecordDate(new Date());
	        	mZpDatos.setRecordUser(username);
	        	mZpDatos.setEstado(Constants.STATUS_NOT_SUBMITTED);
	        	mZpDatos.setDeviceid(infoMovil.getDeviceId());
	        	mZpDatos.setToday(new Date());
	        	new SaveDataTask().execute();
	        }
	        else{
	        	finish();
	        }
	    }
		Intent i = new Intent(getApplicationContext(),
				MainActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		finish();
		super.onActivityResult(requestCode, resultCode, intent);
	}

	/**
	 * 
	 */
	private void addDatosEmbarazada() {
		try{
			Bundle arguments = new Bundle();
			Intent i = new Intent(getApplicationContext(),
					DataEnterActivity.class);
			arguments.putString(Constants.FORM_NAME, Constants.FORM_DATOS_EMB);
			if (mZpDatos!=null) arguments.putSerializable(Constants.OBJECTO_ZPDATA , mZpDatos);
			i.putExtras(arguments);
			startActivityForResult(i , ADD_DATOS);
		}
		catch(Exception e){
			Log.e(TAG, e.getMessage(), e);
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
			String res = "exito";
			try {
				zikaPosA.open();
				zikaPosA.crearZpDatosEmbarazada(mZpDatos);
				zikaPosA.close();
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				res = "error";
			}
			return res;
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
