package ni.org.ics.zikapositivas.appmovil.adapters.eventosinfante;

import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.domain.Zp02dInfantBiospecimenCollection;
import ni.org.ics.zikapositivas.appmovil.domain.Zp07InfantAssessmentVisit;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class InfantVisitAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	private final Zp02dInfantBiospecimenCollection mZp02d;
	private final Zp07InfantAssessmentVisit mZp07;
	
	public InfantVisitAdapter(Context context, int textViewResourceId,
			String[] values, Zp02dInfantBiospecimenCollection zp02, Zp07InfantAssessmentVisit zp07) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
		this.mZp02d = zp02;
		this.mZp07 = zp07;
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
		switch (position) {
			case 3:
				if (mZp02d != null) {
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
				} else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_sample);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			case 0:
                if (mZp07 != null) {
                    if (mZp07.getPart1() != null) {
                        textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));

                    }else{
						textView.setTextColor(Color.RED);
						textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
					}
                }else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_monthly);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			case 1:
				if (mZp07 != null) {
                  if (mZp07.getPart2() != null){
                      textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
                  }else{
					  textView.setTextColor(Color.RED);
					  textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				  }
                }else{
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_monthly);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			case 2:
				if (mZp07 != null) {
                    if (mZp07.getPart3() != null){
                        textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
                    }else{
						textView.setTextColor(Color.RED);
						textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
					}
				}else{
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_monthly);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			default:
				img = getContext().getResources().getDrawable(R.drawable.ic_launcher);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
		}

		return v;
	}
}
