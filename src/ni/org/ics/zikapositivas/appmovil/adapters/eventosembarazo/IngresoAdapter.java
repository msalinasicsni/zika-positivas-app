package ni.org.ics.zikapositivas.appmovil.adapters.eventosembarazo;

import ni.org.ics.zikapositivas.appmovil.domain.Zp01StudyEntrySectionAtoD;
import ni.org.ics.zikapositivas.appmovil.domain.Zp01StudyEntrySectionE;
import ni.org.ics.zikapositivas.appmovil.domain.Zp01StudyEntrySectionFtoK;
import ni.org.ics.zikapositivas.appmovil.domain.Zp02BiospecimenCollection;
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionAtoD;
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionE;
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionFtoH;
import ni.org.ics.zikapositivas.appmovil.domain.Zp05UltrasoundExam;
import ni.org.ics.zikapositivas.appmovil.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class IngresoAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	private final Zp01StudyEntrySectionAtoD mZp01a;
	private final Zp01StudyEntrySectionE mZp01e;
	private final Zp01StudyEntrySectionFtoK mZp01f;
	private final Zp02BiospecimenCollection mZp02;
	private final Zp04TrimesterVisitSectionAtoD mZp04a;
	private final Zp04TrimesterVisitSectionE mZp04e;
	private final Zp04TrimesterVisitSectionFtoH mZp04f;
	private final Zp05UltrasoundExam mZp05;
	
	public IngresoAdapter(Context context, int textViewResourceId,
			String[] values, Zp01StudyEntrySectionAtoD zp01a, Zp01StudyEntrySectionE zp01e, Zp01StudyEntrySectionFtoK zp01f,
			Zp02BiospecimenCollection zp02, Zp04TrimesterVisitSectionAtoD zp04a, Zp04TrimesterVisitSectionE zp04e, Zp04TrimesterVisitSectionFtoH zp04f,
			Zp05UltrasoundExam zp05) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
		this.mZp01a =zp01a;
		this.mZp01e = zp01e;
		this.mZp01f = zp01f;
		this.mZp02 = zp02;
		this.mZp04a = zp04a;
		this.mZp04e = zp04e;
		this.mZp04f = zp04f;
		this.mZp05 = zp05;
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
		textView.setTextColor(Color.BLACK);
		textView.setText(values[position]);
		
		// Change icon based on position
		Drawable img = null;
		switch (position){
		case 0: 
			if(mZp01a!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_demog);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 1:
			if(mZp01e!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_health);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 2: 
			if(mZp01f!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_pregnancy);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 3: 
			if(mZp02!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_sample);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 4: 
			if(mZp04a!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_briefcase);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 5: 
			if(mZp04e!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_spray);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 6: 
			if(mZp04f!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_pest);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		case 7: 
			if(mZp05!=null){
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.done));
			}
			else{
				textView.setTextColor(Color.RED);
				textView.setText(textView.getText()+"\n"+ context.getResources().getString(R.string.pending));
			}
			img=getContext().getResources().getDrawable( R.drawable.ic_us);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		default:
			img=getContext().getResources().getDrawable( R.drawable.ic_launcher);
			textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
			break;
		}

		return v;
	}
}
