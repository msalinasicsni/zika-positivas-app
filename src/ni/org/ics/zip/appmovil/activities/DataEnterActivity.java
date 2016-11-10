package ni.org.ics.zip.appmovil.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.DialogInterface;
import android.content.Intent;

import java.util.List;
import java.util.Map;

import ni.org.ics.zip.appmovil.R;
import ni.org.ics.zip.appmovil.domain.ZpDatosEmbarazada;
import ni.org.ics.zip.appmovil.forms.DatosEmbarazadaForm;
import ni.org.ics.zip.appmovil.utils.Constants;
import ni.org.ics.zip.appmovil.wizard.model.AbstractWizardModel;
import ni.org.ics.zip.appmovil.wizard.model.ModelCallbacks;
import ni.org.ics.zip.appmovil.wizard.model.NumberPage;
import ni.org.ics.zip.appmovil.wizard.model.Page;
import ni.org.ics.zip.appmovil.wizard.model.SingleFixedChoicePage;
import ni.org.ics.zip.appmovil.wizard.model.TextPage;
import ni.org.ics.zip.appmovil.wizard.ui.PageFragmentCallbacks;
import ni.org.ics.zip.appmovil.wizard.ui.ReviewFragment;
import ni.org.ics.zip.appmovil.wizard.ui.StepPagerStrip;

public class DataEnterActivity extends FragmentActivity implements
        PageFragmentCallbacks,
        ReviewFragment.Callbacks,
        ModelCallbacks {
	private ViewPager mPager;
    private MyPagerAdapter mPagerAdapter;

    private boolean mEditingAfterReview;

    private AbstractWizardModel mWizardModel;
    private ZpDatosEmbarazada mZpDatos = null;

    private boolean mConsumePageSelectedEvent;

    private Button mNextButton;
    private Button mPrevButton;

    private List<Page> mCurrentPageSequence;
    private StepPagerStrip mStepPagerStrip;
    
    private String formName;

    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_enter);
        formName = getIntent().getExtras().getString(Constants.FORM_NAME);
        if(formName.matches(Constants.FORM_DATOS_EMB)){
        	mZpDatos = (ZpDatosEmbarazada) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZPDATA);
        	mWizardModel = new DatosEmbarazadaForm(this.getApplicationContext());
        	SingleFixedChoicePage pagtest = (SingleFixedChoicePage) mWizardModel.findByKey(this.getString(R.string.cs));
        	if (mZpDatos.getCs()!= null) pagtest.setValue(mZpDatos.getCs());
        	TextPage pagtest2 = (TextPage) mWizardModel.findByKey(this.getString(R.string.nombre1));
        	if (mZpDatos.getNombre1()!= null) pagtest2.setValue(mZpDatos.getNombre1());
        }
        else{
        	finish();
        }
        if (savedInstanceState != null) {
            mWizardModel.load(savedInstanceState.getBundle("model"));
        }

        mWizardModel.registerListener(this);

        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);
        mStepPagerStrip = (StepPagerStrip) findViewById(R.id.strip);
        mStepPagerStrip.setOnPageSelectedListener(new StepPagerStrip.OnPageSelectedListener() {
            @Override
            public void onPageStripSelected(int position) {
                position = Math.min(mPagerAdapter.getCount() - 1, position);
                if (mPager.getCurrentItem() != position) {
                    mPager.setCurrentItem(position);
                }
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mPrevButton = (Button) findViewById(R.id.prev_button);

        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mStepPagerStrip.setCurrentPage(position);

                if (mConsumePageSelectedEvent) {
                    mConsumePageSelectedEvent = false;
                    return; 
                }

                mEditingAfterReview = false;
                updateBottomBar();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPager.getCurrentItem() == mCurrentPageSequence.size()) {
                    DialogFragment dg = new DialogFragment() {
                        @Override
                        public Dialog onCreateDialog(Bundle savedInstanceState) {
                            return new AlertDialog.Builder(getActivity())
                                    .setMessage(R.string.submit_confirm_message)
                                    .setPositiveButton(R.string.submit_confirm_button, new DialogInterface.OnClickListener() {
                                    	@Override
										public void onClick(DialogInterface arg0, int arg1) {
                                    		Bundle arguments = new Bundle();
                                    		Map<String, String> mapa = mWizardModel.getAnswers();
                                    		for (Map.Entry<String, String> entry : mapa.entrySet()){
                                    			arguments.putString(entry.getKey(), entry.getValue());
                                    		}
                                    		Intent intent = new Intent();
                                    		intent.putExtras(arguments);
											setResult(RESULT_OK,intent);
											finish();
										}
                                    })
                                    .setNegativeButton(android.R.string.cancel,null)
                                    .create();
                        }
                    };
                    dg.show(getSupportFragmentManager(), "guardar_dialog");
                } else {
                    if (mEditingAfterReview) {
                        mPager.setCurrentItem(mPagerAdapter.getCount() - 1);
                    } else {
                        mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                    }
                }
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
        });

        onPageTreeChanged();
        updateBottomBar();
    }

    @Override
    public void onPageTreeChanged() {
        mCurrentPageSequence = mWizardModel.getCurrentPageSequence();
        mStepPagerStrip.setPageCount(mCurrentPageSequence.size() + 1); // + 1 = review step
        mPagerAdapter.notifyDataSetChanged();
        updateBottomBar();
    }

    private void updateBottomBar() {
        int position = mPager.getCurrentItem();
        if (position == mCurrentPageSequence.size()) {
            mNextButton.setText(R.string.finish);
            mNextButton.setBackgroundResource(R.drawable.finish_background);
            mNextButton.setTextAppearance(this, R.style.TextAppearanceFinish);
        } else {
            mNextButton.setText(mEditingAfterReview
                    ? R.string.review
                    : R.string.next);
            mNextButton.setBackgroundResource(R.drawable.selectable_item_background);
            TypedValue v = new TypedValue();
            getTheme().resolveAttribute(android.R.attr.textAppearanceMedium, v, true);
            mNextButton.setTextAppearance(this, v.resourceId);
            mNextButton.setEnabled(position != mPagerAdapter.getCutOffPage());
        }
        mPrevButton.setVisibility(position <= 0 ? View.INVISIBLE : View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWizardModel.unregisterListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle("model", mWizardModel.save());
    }

    @Override
    public AbstractWizardModel onGetModel() {
        return mWizardModel;
    }

    @Override
    public void onEditScreenAfterReview(String key) {
        for (int i = mCurrentPageSequence.size() - 1; i >= 0; i--) {
            if (mCurrentPageSequence.get(i).getKey().equals(key)) {
                mConsumePageSelectedEvent = true;
                mEditingAfterReview = true;
                mPager.setCurrentItem(i);
                updateBottomBar();
                break;
            }
        }
    }

    @Override
    public void onPageDataChanged(Page page) {
    	updateConstrains();
        if (recalculateCutOffPage()) {
            mPagerAdapter.notifyDataSetChanged();
            updateBottomBar();
        }
    }

    @Override
    public Page onGetPage(String key) {
        return mWizardModel.findByKey(key);
    }

    private boolean recalculateCutOffPage() {
        // Cut off the pager adapter at first required page that isn't completed
        int cutOffPage = mCurrentPageSequence.size() + 1;
        for (int i = 0; i < mCurrentPageSequence.size(); i++) {
            Page page = mCurrentPageSequence.get(i);
            String clase = page.getClass().toString();
            if (page.isRequired() && !page.isCompleted()) {
                cutOffPage = i;
                break;
            }            
            if ((!page.isRequired() && !page.getData().isEmpty()) || (page.isRequired() && page.isCompleted())) {
            	if (!page.getData().getString(NumberPage.SIMPLE_DATA_KEY).matches("")){
		            if(clase.equals("class ni.gob.minsa.vigento.wizard.model.NumberPage")){ 
		            	NumberPage np = (NumberPage) page;
		            	if ((np.ismValRange() || np.ismValPattern())) {
		            		String valor = np.getData().getString(NumberPage.SIMPLE_DATA_KEY);
		            		if((np.ismValRange() && (np.getmGreaterOrEqualsThan() > Integer.valueOf(valor) || np.getmLowerOrEqualsThan() < Integer.valueOf(valor)))
		            				|| (np.ismValPattern() && !valor.matches(np.getmPattern()))){
		            			cutOffPage = i;
		            			break;
		            		}
		            	}
		            }
		            else if(clase.equals("class ni.gob.minsa.vigento.wizard.model.TextPage")){
		            	TextPage tp = (TextPage) page;
		            	if (tp.ismValPattern()) {
		            		String valor = tp.getData().getString(TextPage.SIMPLE_DATA_KEY);
		            		if(!valor.matches(tp.getmPattern())){
		            			cutOffPage = i;
		            			break;
		            		}
		            	}
		            }
            	}
            }
        }

        if (mPagerAdapter.getCutOffPage() != cutOffPage) {
            mPagerAdapter.setCutOffPage(cutOffPage);
            return true;
        }

        return false;
    }
    
    public void updateConstrains(){

    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {
        private int mCutOffPage;
        private Fragment mPrimaryItem;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            if (i >= mCurrentPageSequence.size()) {
                return new ReviewFragment();
            }

            return mCurrentPageSequence.get(i).createFragment();
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO: be smarter about this
            if (object == mPrimaryItem) {
                // Re-use the current fragment (its position never changes)
                return POSITION_UNCHANGED;
            }

            return POSITION_NONE;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            mPrimaryItem = (Fragment) object;
        }

        @Override
        public int getCount() {
            return Math.min(mCutOffPage + 1, mCurrentPageSequence.size() + 1);
        }

        public void setCutOffPage(int cutOffPage) {
            if (cutOffPage < 0) {
                cutOffPage = Integer.MAX_VALUE;
            }
            mCutOffPage = cutOffPage;
        }

        public int getCutOffPage() {
            return mCutOffPage;
        }
    }
}
