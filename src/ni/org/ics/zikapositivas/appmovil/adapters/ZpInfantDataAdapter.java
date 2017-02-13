package ni.org.ics.zikapositivas.appmovil.adapters;

import java.text.SimpleDateFormat;
import java.util.List;

import ni.org.ics.zikapositivas.appmovil.R;
import ni.org.ics.zikapositivas.appmovil.domain.ZpInfantData;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ZpInfantDataAdapter extends ArrayAdapter<ZpInfantData> {

	private SimpleDateFormat mDateFormat = new SimpleDateFormat("MMM dd, yyyy");
	
	public ZpInfantDataAdapter(Context context, int textViewResourceId,
			List<ZpInfantData> items) {
		super(context, textViewResourceId, items);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.complex_list_item, null);
		}
		ZpInfantData p = getItem(position);
		if (p != null) {

			TextView textView = (TextView) v.findViewById(R.id.name_text);
			if (textView != null) {
				textView.setText(this.getContext().getString(R.string.study_id) + ": " + p.getRecordId());
			}

			textView = (TextView) v.findViewById(R.id.identifier_text);
			if (textView != null) {
				textView.setText(this.getContext().getString(R.string.inf_dob) + ": " + mDateFormat.format(p.getInfantBirthDate()));
			}
			
			ImageView imageView = (ImageView) v.findViewById(R.id.image);
			if (imageView != null) {
				imageView.setImageResource(R.drawable.ic_baby);
			}
		}
		return v;
	}
}
