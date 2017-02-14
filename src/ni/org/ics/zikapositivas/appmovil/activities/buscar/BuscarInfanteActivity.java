package ni.org.ics.zikapositivas.appmovil.activities.buscar;

import java.util.ArrayList;
import java.util.List;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncListActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.MenuInfantesActivity;
import ni.org.ics.zikapositivas.appmovil.adapters.ZpInfantDataAdapter;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.ZpInfantData;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.Intent;

public class BuscarInfanteActivity extends AbstractAsyncListActivity {


	private Spinner mMetodoView;
	private EditText mParametroView;
	private ImageButton mBarcodeButton;
	private ImageButton mFindButton;
	
	public static final int BARCODE_CAPTURE = 2;

	private ZikaPosAdapter zikaPosA;
	private List<ZpInfantData> mInfantes = new ArrayList<ZpInfantData>();
	

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selec_inf_list);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
		zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
		
		mMetodoView = (Spinner) findViewById(R.id.metodo_busqueda);
		List<String> list = new ArrayList<String>();
		list.add(getString(R.string.desc_barcode));
		list.add(getString(R.string.enter)+" "+getString(R.string.inf_id));
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		mMetodoView.setAdapter(dataAdapter);

		mMetodoView.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
				if (position==0){
					mParametroView.setVisibility(View.GONE);
					mFindButton.setVisibility(View.GONE);
					mBarcodeButton.setVisibility(View.VISIBLE);
				}
				else{
					mParametroView.setVisibility(View.VISIBLE);
					mFindButton.setVisibility(View.VISIBLE);
					mBarcodeButton.setVisibility(View.GONE);
					mParametroView.requestFocus();
					mParametroView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
					mParametroView.setHint(getString(R.string.inf_id));
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> parentView) {

			}
		});
		
		mParametroView = (EditText) findViewById(R.id.parametro);
		mParametroView.setVisibility(View.GONE);


		mBarcodeButton = (ImageButton) findViewById(R.id.barcode_button);
		mFindButton = (ImageButton) findViewById(R.id.find_button);

		mBarcodeButton.setOnClickListener(new View.OnClickListener()  {
			@Override
			public void onClick(View v) {
				Intent i = new Intent("com.google.zxing.client.android.SCAN");
				try {
					startActivityForResult(i, BARCODE_CAPTURE);
				} catch (ActivityNotFoundException e) {
					Toast t = Toast.makeText(getApplicationContext(),
							getString(R.string.error, R.string.barcode_error),
							Toast.LENGTH_LONG);
					t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
					t.show();
				}
			}
		});

		mFindButton.setOnClickListener(new View.OnClickListener()  {
			@Override
			public void onClick(View v) {
				mInfantes.clear();
				if ((mParametroView.getText().toString()==null) || (mParametroView.getText().toString().matches(""))){
					mParametroView.requestFocus();
					mParametroView.setError(getString(R.string.search_hint));
					return;
				}
				if(!mParametroView.getText().toString().matches("^ZP[0-9][0-9][0-9][1-3]$")){
					mParametroView.requestFocus();
					mParametroView.setError(getString(R.string.code_error));
					return;
				}
				buscarInfante(mParametroView.getText().toString());
			}
		});

		mFindButton.setVisibility(View.GONE);

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
	protected void onListItemClick(ListView listView, View view, int position,
			long id) {

		ZpInfantData mZpInfantData = (ZpInfantData) getListAdapter().getItem(position);
		if (mZpInfantData.getInfantConsentInfant().matches("0")){
			showToast(getString(R.string.no_cons));
		}
		else{
            cargarMenu(mZpInfantData);
		}
	}

    private void cargarMenu(ZpInfantData mZpInfantData){
        Bundle arguments = new Bundle();
        if (mZpInfantData!=null) arguments.putSerializable(Constants.OBJECTO_ZPINFDATA , mZpInfantData);
        Intent i = new Intent(getApplicationContext(),
                MenuInfantesActivity.class);
        i.putExtras(arguments);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
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


	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		if (requestCode == BARCODE_CAPTURE && intent != null) {
			String sb = intent.getStringExtra("SCAN_RESULT");
			if (sb != null && sb.length() > 0) {
				try{
					if(!(sb.matches("^ZP[0-9][0-9][0-9][1-3]$"))){
						showToast(getString(R.string.scan_error));
						return;
					}
					buscarInfante(sb);
				}
				catch(Exception e){
					showToast(e.getLocalizedMessage());
					return;
				}
			}
		}
		super.onActivityResult(requestCode, resultCode, intent);

	}
	
	public void buscarInfante(String parametro){
		String filtro = MainDBConstants.recordId + "='" + parametro + "'";
		new FetchDataTask().execute(filtro);
	}
	
	
	// ***************************************
	// Private classes
	// ***************************************
	private class FetchDataTask extends AsyncTask<String, Void, String> {
		private String filtro = null;
		@Override
		protected void onPreExecute() {
			// before the request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected String doInBackground(String... values) {
			filtro = values[0];
			try {
				zikaPosA.open();
				mInfantes = zikaPosA.getZpInfantDatas(filtro, MainDBConstants.recordId);
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
		ZpInfantDataAdapter adapter = new ZpInfantDataAdapter(this, R.layout.complex_list_item, mInfantes);
		setListAdapter(adapter);
		if (mInfantes.isEmpty()) showToast(getString(R.string.no_items));
	}	

	
	
}
