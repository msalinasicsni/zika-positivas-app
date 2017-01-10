package ni.org.ics.zikapositivas.appmovil.wizard.ui;

import ni.org.ics.zikapositivas.appmovil.wizard.model.Page;
import ni.org.ics.zikapositivas.appmovil.R;

import org.joda.time.DateMidnight;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.DatePicker.OnDateChangedListener;


public class DateFragment extends Fragment {
	protected static final String ARG_KEY = "key";

	private PageFragmentCallbacks mCallbacks;
	private String mKey;
	private Page mPage;
	private static DateMidnight mMinDate;
	private static DateMidnight mMaxDate;
	private static boolean mValRange;

	protected DatePicker mDatePickerInput;

	public static DateFragment create(String key, boolean valRange, DateMidnight minimo, DateMidnight maximo) {
		Bundle args = new Bundle();
		args.putString(ARG_KEY, key);
		mMinDate=minimo;
		mMaxDate=maximo;
		mValRange=valRange;
		DateFragment f = new DateFragment();
		f.setArguments(args);
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle args = getArguments();
		mKey = args.getString(ARG_KEY);
		mPage = mCallbacks.onGetPage(mKey);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_page_date,
				container, false);
		((TextView) rootView.findViewById(android.R.id.title)).setText(mPage
				.getTitle());
		((TextView) rootView.findViewById(R.id.label_hint)).setText(mPage
				.getHint());

		mDatePickerInput = (DatePicker) rootView.findViewById(R.id.datePickerInput);
		if(mValRange){
			mDatePickerInput.setMinDate(mMinDate.getMillis());
			mDatePickerInput.setMaxDate(mMaxDate.getMillis());
		}
		mDatePickerInput.init(mDatePickerInput.getYear(), mDatePickerInput.getMonth(), mDatePickerInput.getDayOfMonth(),new OnDateChangedListener() {
     	   @Override
     	   public void onDateChanged(DatePicker arg0, int arg1, int arg2, int arg3) {
     	    // TODO Auto-generated method stub
     		   mPage.getData().putString(Page.SIMPLE_DATA_KEY,
                        (arg0 != null) ? String.valueOf(arg3)+"/"+String.valueOf(arg2+1)+"/"+String.valueOf(arg1) : null);
                mPage.notifyDataChanged();
     	   }
     	  });
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		if (!(activity instanceof PageFragmentCallbacks)) {
			throw new ClassCastException(
					"Activity must implement PageFragmentCallbacks");
		}

		mCallbacks = (PageFragmentCallbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mCallbacks = null;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}
	
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);

		// In a future update to the support library, this should override
		// setUserVisibleHint
		// instead of setMenuVisibility.
		if (mDatePickerInput != null) {
			InputMethodManager imm = (InputMethodManager) getActivity()
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			if (!menuVisible) {
				imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
			}
		}
	}
}
