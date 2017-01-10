package ni.org.ics.zikapositivas.appmovil.activities.nuevos;

import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewPreScreeningActivity;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.ZpPreScreening;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.DeviceInfo;
import ni.org.ics.zikapositivas.appmovil.R;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;

public class NewPreScreeningActivity extends AbstractAsyncActivity {


	private Spinner mCsView;
	private Spinner mConsView;
	private Button mSaveButton;
	
	public static final int BARCODE_CAPTURE = 2;

	private ZikaPosAdapter zikaPosA;
	private ZpPreScreening mPreScreening = null;
	private String username;
	private SharedPreferences settings;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prescreening);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		
		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		
		String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
		zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
		
		mCsView = (Spinner) findViewById(R.id.cs);
		mConsView = (Spinner) findViewById(R.id.cons);
		
		String[] list_cs = getResources().getStringArray(R.array.list_cs);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_cs);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		mCsView.setAdapter(dataAdapter);
		
		String[] list_cons = getResources().getStringArray(R.array.yes_no);
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list_cons);
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		mConsView.setAdapter(dataAdapter2);

		mSaveButton = (Button) findViewById(R.id.add_button);
		mSaveButton.setText(R.string.ok);
	
		mSaveButton.setOnClickListener(new View.OnClickListener()  {
			@Override
			public void onClick(View v) {
				if(validarEntrada()){
					new SaveDataTask().execute(mCsView.getSelectedItem().toString(),mConsView.getSelectedItem().toString());
				}
				
			}
		});

	}
	
	private boolean validarEntrada() {
		//Valida la entrada 
		if (mCsView.getSelectedItemPosition()==0){
			showToast(this.getString( R.string.error_cs));
			return false;
		}
		if (mConsView.getSelectedItemPosition()==0){
			showToast(this.getString( R.string.error_cons));
			return false;
		}
		else{
			return true;
		}
	}
	
	private void showToast(String mensaje){
		LayoutInflater inflater = getLayoutInflater();

		View layout = inflater.inflate(R.layout.toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));

		TextView text = (TextView) layout.findViewById(R.id.text);
		text.setText(mensaje);

		Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(layout);
		toast.show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home){
			finish();
			return true;
		}
		else if(item.getItemId()==R.id.MENU_BACK){
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
	
	// ***************************************
	// Private classes
	// ***************************************
	private class SaveDataTask extends AsyncTask<String, Void, String> {
		private String cs = null;
		private String cons = null;
		private Integer consecutivo = 0;
		private ZpPreScreening zpVerificacion = null;
		@Override
		protected void onPreExecute() {
			// before the request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected String doInBackground(String... values) {
			cs = values[0];
			cons = values[1];
			try {
				zikaPosA.open();
				consecutivo = zikaPosA.getLastZpPreScreening(cs);
				if(consecutivo>0){
					consecutivo = consecutivo+1;
				}
				else{
					consecutivo = 1;
				}
				Date fecha = new Date();
				mPreScreening = new ZpPreScreening();
				mPreScreening.setRecId(new DeviceInfo(NewPreScreeningActivity.this).getId());
				mPreScreening.setCompId(cs+"-"+consecutivo.toString());
				mPreScreening.setCs(cs);
				mPreScreening.setConsecutive(consecutivo);
				mPreScreening.setVerbalConsent(cons);
				mPreScreening.setRecordDate(fecha);
				mPreScreening.setRecordUser(username);
				mPreScreening.setDeviceid(new DeviceInfo(NewPreScreeningActivity.this).getDeviceId());
				mPreScreening.setEstado(Constants.STATUS_NOT_SUBMITTED);
				mPreScreening.setToday(fecha);
				zikaPosA.crearZpPreScreening(mPreScreening);
				zpVerificacion = zikaPosA.getZpPreScreening("recId = '"+mPreScreening.getRecId()+"'", null);
				zikaPosA.close();
				if(zpVerificacion!=null){
					if(zpVerificacion.getVerbalConsent().equals("Si")){
						return "1";
					}
					else{
						return "2";
					}
				}
				else{
					return "0";
				}
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return "0";
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
		if(resultado.matches("0")){
			Toast.makeText(getApplicationContext(),	R.string.error, Toast.LENGTH_LONG).show();
		}
		else if(resultado.matches("1")){
			Intent i = new Intent(getApplicationContext(),
					NewZp00ScreeningActivity.class);
			i.putExtra(Constants.PRESCREENID, mPreScreening.getRecId());
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		}
		else if(resultado.matches("2")){
			Toast.makeText(getApplicationContext(),	R.string.no_cons, Toast.LENGTH_LONG).show();
		}
		else{
			Toast.makeText(getApplicationContext(),	R.string.error, Toast.LENGTH_LONG).show();
		}
		finish();
	}	

	
	
}
