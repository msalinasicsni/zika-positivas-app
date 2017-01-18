package ni.org.ics.zikapositivas.appmovil.activities.paginas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.activities.nuevos.NewZp08StudyExitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosembarazo.DeliveryVisitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosembarazo.IngresoActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosembarazo.MonthlyVisitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosembarazo.PostPartumVisitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosembarazo.TwoWeekVisitActivity;
import ni.org.ics.zikapositivas.appmovil.activities.paginas.eventosembarazo.UnscheduledVisitActivity;
import ni.org.ics.zikapositivas.appmovil.adapters.MenuEmbarazadasAdapter;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp00Screening;
import ni.org.ics.zikapositivas.appmovil.domain.Zp08StudyExit;
import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoEmbarazada;
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

public class MenuEmbarazadasActivity extends AbstractAsyncActivity {

	private static Zp00Screening zp00 = new Zp00Screening();
	private static ZpEstadoEmbarazada zpEstado = new ZpEstadoEmbarazada();
	private static Zp08StudyExit zpSalida= new Zp08StudyExit();
	private GridView gridView;
	private TextView textView;
	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MMM dd, yyyy");
	private ZikaPosAdapter zikaPosA;
	private String[] menu_maternal_info;
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
		setContentView(R.layout.menu_maternal);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		textView = (TextView) findViewById(R.id.label);
		gridView = (GridView) findViewById(R.id.gridView1);
		String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
		zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
		zp00 = (Zp00Screening) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP00);
		filtro = MainDBConstants.recordId + "='" + zp00.getRecordId() + "'";
		new FetchDataEmbarazadaTask().execute(filtro);
		menu_maternal_info = getResources().getStringArray(R.array.menu_maternal_a);
		try {
			this.todayDate = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fechaIngreso = Calendar.getInstance();
		fechaIngreso.setTime(zp00.getScrVisitDate());
		
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
					fechaIngreso.add(Calendar.DATE, 14);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -14);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 2:
					fechaIngreso.add(Calendar.DATE, 28);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -28);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 3:
					fechaIngreso.add(Calendar.DATE, 42);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -42);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 4:
					fechaIngreso.add(Calendar.DATE, 56);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -56);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 5:
					fechaIngreso.add(Calendar.DATE, 70);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -70);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 6:
					fechaIngreso.add(Calendar.DATE, 84);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -84);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 7:
					fechaIngreso.add(Calendar.DATE, 98);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -98);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 8:
					fechaIngreso.add(Calendar.DATE, 112);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -112);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 9:
					fechaIngreso.add(Calendar.DATE, 126);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -126);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 10:
					fechaIngreso.add(Calendar.DATE, 140);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -140);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 11:
					fechaIngreso.add(Calendar.DATE, 154);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -154);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 12:
					fechaIngreso.add(Calendar.DATE, 168);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -168);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 13:
					fechaIngreso.add(Calendar.DATE, 182);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -182);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 14:
					fechaIngreso.add(Calendar.DATE, 196);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -196);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;	
				case 15:
					fechaIngreso.add(Calendar.DATE, 210);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -210);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 16:
					fechaIngreso.add(Calendar.DATE, 224);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -224);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 17:
					fechaIngreso.add(Calendar.DATE, 238);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -238);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 18:
					fechaIngreso.add(Calendar.DATE, 252);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -252);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 19:
					fechaIngreso.add(Calendar.DATE, 266);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -266);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 20:
					fechaIngreso.add(Calendar.DATE, 280);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -280);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 21:
					fechaIngreso.add(Calendar.DATE, 294);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -294);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-7||diff>7) habilitado = false;
		        	break;
				case 22:
					fechaIngreso.add(Calendar.DATE, 308);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -308);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-28||diff>28) habilitado = false;
		        	break;
				case 23:
					fechaIngreso.add(Calendar.DATE, 309);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -309);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-77||diff>77) habilitado = false;
		        	break;
				case 24:
					fechaIngreso.add(Calendar.DATE, 322);fechaEvento = fechaIngreso.getTime();fechaIngreso.add(Calendar.DATE, -322);
		        	diff = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
		        	if(diff<-77||diff>77) habilitado = false;
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
		new FetchDataEmbarazadaTask().execute(filtro);
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
					IngresoActivity.class);
			//Aca se pasa evento, tamizaje y estado
			arguments.putString(Constants.EVENT, Constants.ENTRY);
			if (zp00!=null) arguments.putSerializable(Constants.OBJECTO_ZP00 , zp00);
			if (zpEstado!=null) arguments.putSerializable(Constants.OBJECTO_ZPEST , zpEstado);
			i.putExtras(arguments);
			startActivity(i);
			break;
		case 1: case 3:case 5:case 7:case 9:case 11:case 13:case 15:case 17:case 19:case 21:
			i = new Intent(getApplicationContext(),
					TwoWeekVisitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			if(position==1)	arguments.putString(Constants.EVENT, Constants.WEEK2);
			if(position==3)	arguments.putString(Constants.EVENT, Constants.WEEK6);
			if(position==5)	arguments.putString(Constants.EVENT, Constants.WEEK10);
			if(position==7)	arguments.putString(Constants.EVENT, Constants.WEEK14);
			if(position==9)	arguments.putString(Constants.EVENT, Constants.WEEK18);
			if(position==11)	arguments.putString(Constants.EVENT, Constants.WEEK22);
			if(position==13)	arguments.putString(Constants.EVENT, Constants.WEEK26);
			if(position==15)	arguments.putString(Constants.EVENT, Constants.WEEK30);
			if(position==17)	arguments.putString(Constants.EVENT, Constants.WEEK34);
			if(position==19)	arguments.putString(Constants.EVENT, Constants.WEEK38);
			if(position==21)	arguments.putString(Constants.EVENT, Constants.WEEK42);
			if (zp00!=null) arguments.putSerializable(Constants.OBJECTO_ZP00 , zp00);
			if (zpEstado!=null) arguments.putSerializable(Constants.OBJECTO_ZPEST , zpEstado);
			i.putExtras(arguments);
			startActivity(i);
			break;		
		case 2: case 4:case 6:case 8:case 10:case 12:case 14:case 16:case 18:case 20:case 22:
			i = new Intent(getApplicationContext(),
					MonthlyVisitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			if(position==2)	arguments.putString(Constants.EVENT, Constants.WEEK4);
			if(position==4)	arguments.putString(Constants.EVENT, Constants.WEEK8);
			if(position==6)	arguments.putString(Constants.EVENT, Constants.WEEK12);
			if(position==8)	arguments.putString(Constants.EVENT, Constants.WEEK16);
			if(position==10)	arguments.putString(Constants.EVENT, Constants.WEEK20);
			if(position==12)	arguments.putString(Constants.EVENT, Constants.WEEK24);
			if(position==14)	arguments.putString(Constants.EVENT, Constants.WEEK28);
			if(position==16)	arguments.putString(Constants.EVENT, Constants.WEEK32);
			if(position==18)	arguments.putString(Constants.EVENT, Constants.WEEK36);
			if(position==20)	arguments.putString(Constants.EVENT, Constants.WEEK40);
			if(position==22)	arguments.putString(Constants.EVENT, Constants.WEEK44);
			if (zp00!=null) arguments.putSerializable(Constants.OBJECTO_ZP00 , zp00);
			if (zpEstado!=null) arguments.putSerializable(Constants.OBJECTO_ZPEST , zpEstado);
			i.putExtras(arguments);
			startActivity(i);
			break;	
		case 23:
			i = new Intent(getApplicationContext(),
					DeliveryVisitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			arguments.putString(Constants.EVENT, Constants.DELIVERY);
			if (zp00!=null) arguments.putSerializable(Constants.OBJECTO_ZP00 , zp00);
			if (zpEstado!=null) arguments.putSerializable(Constants.OBJECTO_ZPEST , zpEstado);
			i.putExtras(arguments);
			startActivity(i);
			break;
		case 24:
			i = new Intent(getApplicationContext(),
					PostPartumVisitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			arguments.putString(Constants.EVENT, Constants.AFTERDELIVERY);
			if (zp00!=null) arguments.putSerializable(Constants.OBJECTO_ZP00 , zp00);
			if (zpEstado!=null) arguments.putSerializable(Constants.OBJECTO_ZPEST , zpEstado);
			i.putExtras(arguments);
			startActivity(i);
			break;
		case 25:
			i = new Intent(getApplicationContext(),
					NewZp08StudyExitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			arguments.putString(Constants.RECORDID, zp00.getRecordId());
			i.putExtras(arguments);
			startActivity(i);
			break;
		case 26: case 27:case 28:case 29:case 30:
			i = new Intent(getApplicationContext(),
					UnscheduledVisitActivity.class);
			//Aca se pasa evento, tamizaje y estado
			if(position==26)	arguments.putString(Constants.EVENT, Constants.UNSHED1);
			if(position==27)	arguments.putString(Constants.EVENT, Constants.UNSHED2);
			if(position==28)	arguments.putString(Constants.EVENT, Constants.UNSHED3);
			if(position==29)	arguments.putString(Constants.EVENT, Constants.UNSHED4);
			if(position==30)	arguments.putString(Constants.EVENT, Constants.UNSHED5);
			if (zp00!=null) arguments.putSerializable(Constants.OBJECTO_ZP00 , zp00);
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
	private class FetchDataEmbarazadaTask extends AsyncTask<String, Void, String> {
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
				zpEstado = zikaPosA.getZpEstadoEmbarazada(filtro, MainDBConstants.recordId);
				zpSalida = zikaPosA.getZp08StudyExit(filtro, null);
				zikaPosA.close();
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
			textView.setText(getString(R.string.maternal_events)+"\n"+
								getString(R.string.mat_id)+": "+zp00.getRecordId()+"\n"+
										getString(R.string.mat_fec)+": "+ mDateFormat.format(zp00.getScrVisitDate()));
			gridView.setAdapter(new MenuEmbarazadasAdapter(getApplicationContext(), R.layout.menu_item_2, menu_maternal_info, zp00, zpEstado, zpSalida));
			if (zpSalida != null){
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+getString(R.string.mat_retired)
						+"\n"+getString(R.string.mat_exit)+": "+ mDateFormat.format(zpSalida.getExtStudyExitDate()));
			}
			dismissProgressDialog();
		}

	}
		
		
}
	
