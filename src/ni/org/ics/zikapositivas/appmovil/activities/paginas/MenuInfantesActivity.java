package ni.org.ics.zikapositivas.appmovil.activities.paginas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp08StudyExitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosinfante.BirthVisitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosinfante.InfantVisitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosinfante.UnscheduledInfantVisitActivity;
import ni.org.ics.zikapositivas.appmovil.adapters.MenuInfantesAdapter;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp08StudyExit;
import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoInfante;
import ni.org.ics.zikapositivas.appmovil.domain.ZpInfantData;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;

public class MenuInfantesActivity extends AbstractAsyncActivity {

	private static ZpInfantData zpInfante = new ZpInfantData();
	private static ZpEstadoInfante zpEstado = new ZpEstadoInfante();
	private static Zp08StudyExit zpSalida= new Zp08StudyExit();
	private GridView gridView;
	private TextView textView;
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MMM dd, yyyy");
	private ZikaPosAdapter zipA;
	private String[] menu_infante_info;
	private String filtro;
	private Calendar fechaIngreso;
	private Date fechaEvento;
	private Date todayDate;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private AlertDialog alertDialog;
	private static final int FUERA = 1;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_infante);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		textView = (TextView) findViewById(R.id.label);
		gridView = (GridView) findViewById(R.id.gridView1);
		String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
		zipA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
		zpInfante = (ZpInfantData) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZPINFDATA);
		filtro = MainDBConstants.recordId + "='" + zpInfante.getRecordId() + "'";
		new FetchDataInfanteTask().execute(filtro);
		menu_infante_info = getResources().getStringArray(R.array.menu_infant);
		try {
			this.todayDate = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fechaIngreso = Calendar.getInstance();
		fechaIngreso.setTime(zpInfante.getInfantBirthDate());
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				long diff =0;
				boolean habilitado = true;
				switch (position){
				case 0:
		        	fechaEvento = fechaIngreso.getTime();
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff>15) habilitado = false;
		        	break;
				case 1:
					fechaIngreso.add(Calendar.DATE, 84);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -84);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 2:
					fechaIngreso.add(Calendar.DATE, 182);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -182);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 3:
					fechaIngreso.add(Calendar.DATE, 365);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -365);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				default:
					habilitado = true;
					break;
		        }
				if(!habilitado){
					createDialog(FUERA,position);
				}
				else{
					entrarPantalla(position);
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
	}

	@Override
	protected void onResume() {
		new FetchDataInfanteTask().execute(filtro);
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		case R.id.MENU_BACK:
			finish();
			return true;
		case R.id.MENU_HOME:
			i = new Intent(getApplicationContext(),
					MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private void createDialog(int dialog,final int position) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		switch(dialog){
		case FUERA:
			builder.setTitle(this.getString(R.string.confirm));
			builder.setMessage(this.getString(R.string.out_of_time));
			builder.setPositiveButton(this.getString(R.string.yes), new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					entrarPantalla(position);
				}
			});
			builder.setNegativeButton(this.getString(R.string.no), new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// Do nothing
					dialog.dismiss();
				}
			});
			break;
		default:
			break;
		}
		alertDialog = builder.create();
		alertDialog.show();
	}
	
	private void entrarPantalla(int position){
		Bundle arguments = new Bundle();
		Intent i;
		switch(position){
			case 0:
				i = new Intent(getApplicationContext(),
						BirthVisitActivity.class);
				//Aca se pasa evento, infante y estado
				if(position==0)	arguments.putString(Constants.EVENT, Constants.BIRTH);
				if (zpInfante!=null) arguments.putSerializable(Constants.OBJECTO_ZPINFDATA , zpInfante);
				if (zpEstado!=null) arguments.putSerializable(Constants.OBJECTO_ZPESTINF , zpEstado);
				i.putExtras(arguments);
				startActivity(i);
				break;
		case 1: case 2: case 3:
			i = new Intent(getApplicationContext(),
					InfantVisitActivity.class);
			//Aca se pasa evento, infante y estado
			if(position==0)	arguments.putString(Constants.EVENT, Constants.BIRTH);
			if(position==1)	arguments.putString(Constants.EVENT, Constants.MONTH3);
			if(position==2)	arguments.putString(Constants.EVENT, Constants.MONTH6);
			if(position==3)	arguments.putString(Constants.EVENT, Constants.MONTH12);
			if (zpInfante!=null) arguments.putSerializable(Constants.OBJECTO_ZPINFDATA , zpInfante);
			if (zpEstado!=null) arguments.putSerializable(Constants.OBJECTO_ZPESTINF , zpEstado);
			i.putExtras(arguments);
			startActivity(i);
			break;
		case 4: case 5:case 6:case 7:case 8:
			i = new Intent(getApplicationContext(),
					UnscheduledInfantVisitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			if(position==4)	arguments.putString(Constants.EVENT, Constants.UNSHEDINF1);
			if(position==5)	arguments.putString(Constants.EVENT, Constants.UNSHEDINF2);
			if(position==6)	arguments.putString(Constants.EVENT, Constants.UNSHEDINF3);
			if(position==7)	arguments.putString(Constants.EVENT, Constants.UNSHEDINF4);
			if(position==8)	arguments.putString(Constants.EVENT, Constants.UNSHEDINF5);
			if (zpInfante!=null) arguments.putSerializable(Constants.OBJECTO_ZPINFDATA , zpInfante);
			i.putExtras(arguments);
			startActivity(i);
			break;	
		case 9:
			i = new Intent(getApplicationContext(),
					NewZp08StudyExitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			arguments.putString(Constants.RECORDID, zpInfante.getRecordId());
			i.putExtras(arguments);
			startActivity(i);
			break;			
		default:
			break;
		}
	}
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
	// ***************************************
	// Private classes
	// ***************************************
	private class FetchDataInfanteTask extends AsyncTask<String, Void, String> {
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
				zipA.open();
				zpEstado = zipA.getZpEstadoInfante(filtro, MainDBConstants.recordId);
				zpSalida = zipA.getZp08StudyExit(filtro, null);
				zipA.close();
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return "error";
			}
			return "exito";
		}

		protected void onPostExecute(String resultado) {
			// after the network request completes, hide the progress indicator
			textView.setText("");
			textView.setTextColor(Color.BLUE);
			textView.setText(getString(R.string.infant_events)+"\n"+
								getString(R.string.inf_id)+": "+zpInfante.getRecordId()+"\n"+
										getString(R.string.inf_dob)+": "+ mDateFormat.format(zpInfante.getInfantBirthDate()));
			gridView.setAdapter(new MenuInfantesAdapter(getApplicationContext(), R.layout.menu_item_2, menu_infante_info, zpInfante, zpEstado, zpSalida));
			if (zpSalida != null){
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+getString(R.string.inf_retired)
						+"\n"+getString(R.string.inf_exit)+": "+ mDateFormat.format(zpSalida.getExtStudyExitDate()));
			}
			dismissProgressDialog();
		}

	}
		
		
}
	
