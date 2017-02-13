package ni.org.ics.zikapositivas.appmovil.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.domain.Zp08StudyExit;
import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoInfante;
import ni.org.ics.zikapositivas.appmovil.domain.ZpInfantData;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuInfantesAdapter extends ArrayAdapter<String> {

	private final String[] values;
	private final ZpInfantData mZpInfante;
	private final ZpEstadoInfante mZpEstado;
	private final Zp08StudyExit mZpSalida;
	private final Calendar fechaIngreso;
	private final Context context;
	private Date fechaEvento;
	private Date todayDate;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public MenuInfantesAdapter(Context context, int textViewResourceId,
			String[] values, ZpInfantData zp00, ZpEstadoInfante zpEstado, Zp08StudyExit zpSalida) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
		this.mZpInfante = zp00;
		this.mZpEstado = zpEstado;
		this.mZpSalida = zpSalida;
		try {
			this.todayDate = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fechaIngreso = Calendar.getInstance();
		fechaIngreso.setTime(mZpInfante.getInfantBirthDate());
	}

	
	@Override
    public boolean isEnabled(int position) {
        // Disable the first item of GridView
		boolean habilitado = true;
		if(mZpSalida!= null){
			return false;
		}
        return habilitado;
    }
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.menu_item_2, null);
		}
		TextView textView = (TextView) v.findViewById(R.id.label);
		textView.setTypeface(null, Typeface.BOLD);
		textView.setText(values[position]);
		// Change icon based on position
		Drawable img = null;
		switch (position){
		case 0:
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getNacimiento()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif>15){
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
				else if(dif<=3){
					textView.setTextColor(Color.BLUE);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.ontime));
				}
				else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
			}
			else{
				textView.setTextColor(Color.BLACK);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done)+"\n\n");
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_delivery);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 1: 
			fechaIngreso.add(Calendar.DATE, 84);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getMes3()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
				else if(dif<=0){
					textView.setTextColor(Color.BLUE);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.ontime));
				}
				else{
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
			}
			else{
				textView.setTextColor(Color.BLACK);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done)+"\n\n");
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_3m);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -84);
			break;
		case 2: 
			fechaIngreso.add(Calendar.DATE, 182);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getMes6()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
				else if(dif<=0){
					textView.setTextColor(Color.BLUE);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.ontime));
				}
				else{
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
			}
			else{
				textView.setTextColor(Color.BLACK);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done)+"\n\n");
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_6m);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -182);
			break;
		case 3: 
			fechaIngreso.add(Calendar.DATE, 365);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getMes12()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
				else if(dif<=0){
					textView.setTextColor(Color.BLUE);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.ontime));
				}
				else{
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
			}
			else{
				textView.setTextColor(Color.BLACK);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done)+"\n\n");
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_12m);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -365);
			break;
		case 4: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 5: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 6: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 7: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 8: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 9: 
			textView.setTextColor(Color.BLACK);
			if(mZpSalida!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.inf_retired)+"\n\n");
			}
			else{
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_exit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		default:
			img=getContext().getResources().getDrawable( R.drawable.logo);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		}

		return v;
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
}
