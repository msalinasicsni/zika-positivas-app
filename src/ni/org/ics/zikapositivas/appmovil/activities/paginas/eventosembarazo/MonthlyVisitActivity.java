package ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosembarazo;

import java.text.SimpleDateFormat;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp02BiospecimenCollectionActivity;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp03MonthlyVisitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp04TrimesterVisitSectionAtoDActivity;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp04TrimesterVisitSectionEActivity;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp04TrimesterVisitSectionFtoHActivity;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp05UltrasoundExamActivity;
import ni.org.ics.zikapositivas.appmovil.adapters.eventosembarazo.MonthlyVisitAdapter;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp00Screening;
import ni.org.ics.zikapositivas.appmovil.domain.Zp02BiospecimenCollection;
import ni.org.ics.zikapositivas.appmovil.domain.Zp03MonthlyVisit;
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionAtoD;
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionE;
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionFtoH;
import ni.org.ics.zikapositivas.appmovil.domain.Zp05UltrasoundExam;
import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoEmbarazada;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.utils.Zp02DBConstants;
import ni.org.ics.zikapositivas.appmovil.R;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class MonthlyVisitActivity extends AbstractAsyncActivity {
	private ZikaPosAdapter zikaPosA;
	private static Zp00Screening zp00 = new Zp00Screening();
	private static ZpEstadoEmbarazada zpEstado = new ZpEstadoEmbarazada();
	private static Zp02BiospecimenCollection zp02 = null;
	private static Zp03MonthlyVisit zp03 = null;
	private static Zp04TrimesterVisitSectionAtoD zp04a = null;
	private static Zp04TrimesterVisitSectionE zp04e = null;
    private static Zp04TrimesterVisitSectionFtoH zp04f = null;
    private static Zp05UltrasoundExam zp05 = null;

	
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MMM dd, yyyy");
	private static String evento;
	private GridView gridView;
	private TextView textView;
	private AlertDialog alertDialog;
	private static final int EXIT = 1;
	private boolean mExitShowing;
	private boolean pendiente = false;
	private static final String EXIT_SHOWING = "exitshowing";
	String[] menu_maternal_info;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_maternal);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		if (savedInstanceState != null) {
			if (savedInstanceState.containsKey(EXIT_SHOWING)) {
				mExitShowing = savedInstanceState.getBoolean(EXIT_SHOWING, false);
			}
		}
		String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
		zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
		/*Aca se recupera evento, tamizaje y estado*/
		evento = getIntent().getStringExtra(Constants.EVENT);
		zp00 = (Zp00Screening) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP00);
		zpEstado = (ZpEstadoEmbarazada) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZPEST);
		//Aca se recupera los datos de los formularios para ver si estan realizados o no...
		new FetchDataVisitaMensualTask().execute(evento);
		textView = (TextView) findViewById(R.id.label);
		textView.setText(getString(R.string.forms)+"\n"+
				getString(R.string.mat_id)+": "+zp00.getRecordId()+"\n"+
						getString(R.string.mat_fec)+": "+ mDateFormat.format(zp00.getScrVisitDate()));
		menu_maternal_info = getResources().getStringArray(R.array.menu_maternal_mensual);
		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Bundle arguments = new Bundle();
				Intent i;
				arguments.putString(Constants.EVENT, evento);
                arguments.putString(Constants.RECORDID, zp00.getRecordId());
				switch(position){ 
                case 0: //MUESTRAS
                    i = new Intent(getApplicationContext(),
                            NewZp02BiospecimenCollectionActivity.class);
                    if (zp02!=null) arguments.putSerializable(Constants.OBJECTO_ZP02 , zp02);
                    i.putExtras(arguments);
                    startActivity(i);
                    break;
                case 1: //VISITA
                    i = new Intent(getApplicationContext(),
                    		NewZp03MonthlyVisitActivity.class);
                    if (zp03!=null) arguments.putSerializable(Constants.OBJECTO_ZP03 , zp03);
                    i.putExtras(arguments);
                    startActivity(i);
                    break;
                case 2: //PROFESION
                    i = new Intent(getApplicationContext(),
                            NewZp04TrimesterVisitSectionAtoDActivity.class);
                    if (zp04a!=null) arguments.putSerializable(Constants.OBJECTO_ZP04A , zp04a);
                    i.putExtras(arguments);
                    startActivity(i);
                    break;
                case 3: //EXPOSICION
                    i = new Intent(getApplicationContext(),
                            NewZp04TrimesterVisitSectionEActivity.class);
                    if (zp04e!=null) arguments.putSerializable(Constants.OBJECTO_ZP04E , zp04e);
                    i.putExtras(arguments);
                    startActivity(i);
                    break;
                case 4: //PESTICIDAS
                    i = new Intent(getApplicationContext(),
                            NewZp04TrimesterVisitSectionFtoHActivity.class);
                    if (zp04f!=null) arguments.putSerializable(Constants.OBJECTO_ZP04F , zp04f);
                    i.putExtras(arguments);
                    startActivity(i);
                    break;
                case 5: //ULTRASONIDOS
                    i = new Intent(getApplicationContext(),
                            NewZp05UltrasoundExamActivity.class);
                    if (zp05!=null) arguments.putSerializable(Constants.OBJECTO_ZP05 , zp05);
                    i.putExtras(arguments);
                    startActivity(i);
                    break;
				default:					
					break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(EXIT_SHOWING, mExitShowing);
	}

	@Override
	protected void onResume() {
		//getParticipanteData();
		if (mExitShowing) {
			createDialog(EXIT);
		}
		new FetchDataVisitaMensualTask().execute(evento);
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (alertDialog != null && alertDialog.isShowing()) {
			alertDialog.dismiss();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.MENU_BACK:
			if (pendiente){
				createDialog(EXIT);
			}
			else{
				finish();
			}
			return true;
		case R.id.MENU_HOME:
			if (pendiente){
				createDialog(EXIT);
			}
			else{
				i = new Intent(getApplicationContext(),
						MainActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				finish();
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onBackPressed (){
		if (pendiente){
			createDialog(EXIT);
		}
		else{
			finish();
		}
	}

	private void createDialog(int dialog) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		switch(dialog){
		case EXIT:
			builder.setTitle(this.getString(R.string.confirm));
			builder.setMessage(this.getString(R.string.ok));
			builder.setPositiveButton(this.getString(R.string.yes), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					// Finish app
					dialog.dismiss();
					mExitShowing=false;
				}

			});
			builder.setNegativeButton(this.getString(R.string.no), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// Do nothing
					dialog.dismiss();
					mExitShowing=false;
				}
			});
			mExitShowing=true;
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
		private class FetchDataVisitaMensualTask extends AsyncTask<String, Void, String> {
			private String eventoaFiltrar = null;
			private String filtro = null;
			@Override
			protected void onPreExecute() {
				// before the request begins, show a progress indicator
				showLoadingProgressDialog();
			}

			@Override
			protected String doInBackground(String... values) {
				eventoaFiltrar = values[0];
				try {
					zikaPosA.open();
					filtro = MainDBConstants.recordId + "='" + zp00.getRecordId() + "' and " + Zp02DBConstants.redcapEventName + "='" + eventoaFiltrar +"'";
					zp02 = zikaPosA.getZp02BiospecimenCollection(filtro, MainDBConstants.recordId);
					zp03 = zikaPosA.getZp03MonthlyVisit(filtro, MainDBConstants.recordId);
					zp04a = zikaPosA.getZp04TrimesterVisitSectionAtoD(filtro, null);
					zp04e = zikaPosA.getZp04TrimesterVisitSectionE(filtro, null);
					zp04f = zikaPosA.getZp04TrimesterVisitSectionFtoH(filtro, null);
					zp05 = zikaPosA.getZp05UltrasoundExam(filtro, null);
					if (zp02!=null && zp03!=null &&
							zp04a!=null && zp04e!=null && zp04f!=null && zp05!=null){
						if(eventoaFiltrar.matches(Constants.WEEK4)){
							zpEstado.setSem4('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK8)){
							zpEstado.setSem8('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK12)){
							zpEstado.setSem12('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK16)){
							zpEstado.setSem16('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK20)){
							zpEstado.setSem20('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK24)){
							zpEstado.setSem24('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK28)){
							zpEstado.setSem28('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK32)){
							zpEstado.setSem32('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK36)){
							zpEstado.setSem36('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK40)){
							zpEstado.setSem40('1');
						}
						else if(eventoaFiltrar.matches(Constants.WEEK44)){
							zpEstado.setSem44('1');
						}
						zikaPosA.editarZpEstadoEmbarazada(zpEstado);
					}
					zikaPosA.close();
				} catch (Exception e) {
					Log.e(TAG, e.getLocalizedMessage(), e);
					return "Error";
				}
				return "Exito";
			}

			protected void onPostExecute(String resultado) {
				// after the network request completes, hide the progress indicator
				gridView.setAdapter(new MonthlyVisitAdapter(getApplicationContext(), R.layout.menu_item_2, menu_maternal_info, 
						zp02, zp03, zp04a, zp04e ,zp04f, zp05
						));
				dismissProgressDialog();
			}

		}

}
	
