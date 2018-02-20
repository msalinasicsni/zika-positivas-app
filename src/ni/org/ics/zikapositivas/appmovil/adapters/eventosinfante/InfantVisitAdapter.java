package ni.org.ics.zikapositivas.appmovil.adapters.eventosinfante;

import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.domain.*;
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
	private final Zp07aInfantOphtResults mZp07a;
	private final Zp07bInfantAudioResults mZp07b;
	private final Zp07cInfantImageStudies mZp07c;
	private final Zp07dInfantBayleyScales mZp07d;
	private final Zp07InfantOtoacousticEmissions mZp07OtoE;
	
	public InfantVisitAdapter(Context context, int textViewResourceId,
							  String[] values, Zp02dInfantBiospecimenCollection zp02, Zp07InfantAssessmentVisit zp07, Zp07aInfantOphtResults zp07a, Zp07bInfantAudioResults zp07b, Zp07cInfantImageStudies zp07c, Zp07dInfantBayleyScales zp07d, Zp07InfantOtoacousticEmissions zp07OtoE) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
		this.mZp02d = zp02;
		this.mZp07 = zp07;
		this.mZp07a = zp07a;
		this.mZp07b = zp07b;
		this.mZp07c = zp07c;
		this.mZp07d = zp07d;
		this.mZp07OtoE = zp07OtoE;
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
			case 0:
				if (mZp02d != null) {
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
				} else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_sample);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			case 1:
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
			case 2:
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
			case 8:
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
			case 3:
				if (mZp07a != null) {
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
				} else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_opht);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			case 4:
				if (mZp07b != null) {
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
				} else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_audio);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;

			case 5:
				if (mZp07c != null) {
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
				} else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_image);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			case 7:
				if (mZp07d != null) {
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
				} else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_bayley);
				textView.setCompoundDrawablesWithIntrinsicBounds(null, img, null, null);
				break;
			case 6:
				if (mZp07OtoE != null) {
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.done));
				} else {
					textView.setTextColor(Color.RED);
					textView.setText(textView.getText() + "\n" + context.getResources().getString(R.string.pending));
				}
				img = getContext().getResources().getDrawable(R.drawable.ic_oae);
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
