package ni.org.ics.zikapositivas.appmovil.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.domain.Zp00Screening;
import ni.org.ics.zikapositivas.appmovil.domain.Zp08StudyExit;
import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoEmbarazada;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MenuEmbarazadasAdapter extends ArrayAdapter<String> {

	private final String[] values;
	private final Zp00Screening mZp00;
	private final ZpEstadoEmbarazada mZpEstado;
	private final Zp08StudyExit mZpSalida;
	private final Calendar fechaIngreso;
	private final Context context;
	private Date fechaEvento;
	private Date todayDate;
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public MenuEmbarazadasAdapter(Context context, int textViewResourceId,
			String[] values, Zp00Screening zp00, ZpEstadoEmbarazada zpEstado, Zp08StudyExit zpSalida) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
		this.mZp00 = zp00;
		this.mZpEstado = zpEstado;
		this.mZpSalida = zpSalida;
		try {
			this.todayDate = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fechaIngreso = Calendar.getInstance();
		fechaIngreso.setTime(mZp00.getScrVisitDate());
	}
	
	
	/* Ya no se va a bloquear las opciones en la pantalla por fecha solo si esta fuera del estudio
	@Override
    public boolean isEnabled(int position) {
        // Disable the first item of GridView
		boolean habilitado = true;
		if(mZpSalida!= null){
			return false;
		}
		long diff =0;
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
        return habilitado;
    }*/

	
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
			if(String.valueOf(mZpEstado.getIngreso()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif>15){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.delayed));
				}
				else if(dif<1){
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
			img=getContext().getResources().getDrawable( R.drawable.ic_enroll);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 1: 
			fechaIngreso.add(Calendar.DATE, 14);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem2()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -14);
			break;
		case 2: 
			fechaIngreso.add(Calendar.DATE, 28);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem4()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis1);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -28);
			break;
		case 3: 
			fechaIngreso.add(Calendar.DATE, 42);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem6()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -42);
			break;
		case 4: 
			fechaIngreso.add(Calendar.DATE, 56);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem8()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis2);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -56);
			break;
		case 5:
			fechaIngreso.add(Calendar.DATE, 70);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem14()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -70);
			break;
		case 6:
			fechaIngreso.add(Calendar.DATE, 84);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem12()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis3);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -84);
			break;
		case 7: 
			fechaIngreso.add(Calendar.DATE, 98);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem14()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -98);
			break;
		case 8: 
			fechaIngreso.add(Calendar.DATE, 112);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem16()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis4);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -112);
			break;
		case 9: 
			fechaIngreso.add(Calendar.DATE, 126);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem18()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -126);
			break;
		case 10: 
			fechaIngreso.add(Calendar.DATE, 140);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem20()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis5);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -140);
			break;
		case 11: 
			fechaIngreso.add(Calendar.DATE, 154);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem22()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -154);
			break;
		case 12: 
			fechaIngreso.add(Calendar.DATE, 168);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem24()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis6);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -168);
			break;
		case 13: 
			fechaIngreso.add(Calendar.DATE, 182);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem26()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -182);
			break;
		case 14: 
			fechaIngreso.add(Calendar.DATE, 196);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem28()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis7);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -196);
			break;
		case 15: 
			fechaIngreso.add(Calendar.DATE, 210);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem30()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -210);
			break;
		case 16: 
			fechaIngreso.add(Calendar.DATE, 224);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem32()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis8);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -224);
			break;
		case 17: 
			fechaIngreso.add(Calendar.DATE, 238);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem34()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -238);
			break;
		case 18: 
			fechaIngreso.add(Calendar.DATE, 252);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem36()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis9);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -252);
			break;
		case 19: 
			fechaIngreso.add(Calendar.DATE, 266);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem38()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -266);
			break;
		case 20: 
			fechaIngreso.add(Calendar.DATE, 280);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem40()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-7){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>7){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis10);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -280);
			break;
		case 21: 
			fechaIngreso.add(Calendar.DATE, 294);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem42()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-28){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>28){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_visitacasa);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -294);
			break;
		case 22: 
			fechaIngreso.add(Calendar.DATE, 308);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getSem44()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-28){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>28){
					textView.setTextColor(Color.GRAY);
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
			img=getContext().getResources().getDrawable( R.drawable.ic_vis11);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -308);
			break;
		case 23: 
			fechaIngreso.add(Calendar.DATE, 309);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getParto()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-77){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>77){
					textView.setTextColor(Color.GRAY);
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
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_parto);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -309);
			break;
		case 24: 
			fechaIngreso.add(Calendar.DATE, 322);
			fechaEvento = fechaIngreso.getTime();
			if(String.valueOf(mZpEstado.getPosparto()).equals("0")){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
				long dif = getDateDiff(fechaEvento,todayDate,TimeUnit.DAYS);
				if(dif<-77){
					textView.setTextColor(Color.GRAY);
					textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.programmed)+": "+ formatter.format(fechaEvento));
				}
				else if(dif>77){
					textView.setTextColor(Color.GRAY);
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
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_post);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			fechaIngreso.add(Calendar.DATE, -322);
			break;
		case 25: 
			textView.setTextColor(Color.BLACK);
			if(mZpSalida!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.mat_retired)+"\n\n");
			}
			else{
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_exit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 26: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 27: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 28: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 29: 
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.available)+"\n\n");
			img=getContext().getResources().getDrawable( R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 30:
			textView.setTextColor(Color.BLACK);
			textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.available) + "\n\n");
			img = getContext().getResources().getDrawable(R.drawable.ic_addvisit);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 31:
				textView.setTextColor(Color.BLACK);
				//	textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.inf_tam)+"\n\n");
				img = getContext().getResources().getDrawable(R.drawable.ic_scr);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			default:
				img = getContext().getResources().getDrawable(R.drawable.logo);
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
