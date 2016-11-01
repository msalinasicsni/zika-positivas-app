package ni.org.ics.zip.appmovil.activities.nuevos;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import ni.org.ics.zip.appmovil.AbstractAsyncActivity;
import ni.org.ics.zip.appmovil.MainActivity;
import ni.org.ics.zip.appmovil.MyZipApplication;
import ni.org.ics.zip.appmovil.R;
import ni.org.ics.zip.appmovil.database.ZipAdapter;
import ni.org.ics.zip.appmovil.domain.Zp00Screening;
import ni.org.ics.zip.appmovil.domain.Zp04TrimesterVisitSectionAtoD;
import ni.org.ics.zip.appmovil.parsers.Zp04TrimesterVisitSectionAtoDXml;
import ni.org.ics.zip.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zip.appmovil.utils.Constants;
import ni.org.ics.zip.appmovil.utils.FileUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.File;
import java.util.Date;


public class NewZp04TrimesterVisitSectionAtoDActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewZp04TrimesterVisitSectionAtoDActivity.class.getSimpleName();
	
	private ZipAdapter zipA;
	private static Zp04TrimesterVisitSectionAtoD mIngreso = new Zp04TrimesterVisitSectionAtoD();
	
	public static final int ADD_TAMIZAJE_ODK = 1;
	public static final int BARCODE_CAPTURE_TAM = 2;

	Dialog dialogInit;
	private SharedPreferences settings;
	private String username;
	private String mRecordId = "";
	private boolean hecho =  false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (!FileUtils.storageReady()) {
			Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.error, R.string.storage_error),Toast.LENGTH_LONG);
			toast.show();
			finish();
		}
		settings =
				PreferenceManager.getDefaultSharedPreferences(this);
		username =
				settings.getString(PreferencesActivity.KEY_USERNAME,
						null);
		String mPass = ((MyZipApplication) this.getApplication()).getPassApp();
		zipA = new ZipAdapter(this.getApplicationContext(),mPass,false);
		hecho = getIntent().getExtras().getBoolean(Constants.DONE);
		Zp00Screening screening = (Zp00Screening) getIntent().getExtras().getSerializable(Constants.OBJECTO);
		mRecordId = screening.getRecordId();
		createInitDialog();
	}

	/**
	 * Presenta dialogo inicial
	 */

	private void createInitDialog() {
		dialogInit = new Dialog(this, R.style.FullHeightDialog); 
		dialogInit.setContentView(R.layout.yesno); 
		dialogInit.setCancelable(false);

		//to set the message
		TextView message =(TextView) dialogInit.findViewById(R.id.yesnotext);
		if (hecho){
			message.setText(getString(R.string.edit)+ " " + getString(R.string.main_maternal));
		}
		else{
			message.setText(getString(R.string.add)+ " " + getString(R.string.main_maternal));
		}

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				addTrimesterVisit();
			}
		});

		Button no = (Button) dialogInit.findViewById(R.id.yesnoNo);
		no.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// Cierra
				dialogInit.dismiss();
				finish();
			}
		});
		dialogInit.show();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.general, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==R.id.MENU_BACK){
			finish();
			return true;
		}
		else if(item.getItemId()==R.id.MENU_HOME){
			Intent i = new Intent(getApplicationContext(),
					MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
			return true;
		}
		else{
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		if(requestCode == ADD_TAMIZAJE_ODK) {
	        if(resultCode == RESULT_OK) {
	        	Uri instanceUri = intent.getData();
				//Busca la instancia resultado
				String[] projection = new String[] {
						"_id","instanceFilePath", "status","displaySubtext"};
				Cursor c = getContentResolver().query(instanceUri, projection,
						null, null, null);
				c.moveToFirst();
				//Captura la id de la instancia y la ruta del archivo para agregarlo al participante
				Integer idInstancia = c.getInt(c.getColumnIndex("_id"));
				String instanceFilePath = c.getString(c.getColumnIndex("instanceFilePath"));
				String complete = c.getString(c.getColumnIndex("status"));
				//cierra el cursor
				if (c != null) {
					c.close();
				}
				if (complete.matches("complete")){
					//Parsear el resultado obteniendo un tamizaje si esta completo
					parseTrimesterVisit(idInstancia,instanceFilePath);
				}
				else{
					Toast.makeText(getApplicationContext(),	getString(R.string.err_not_completed), Toast.LENGTH_LONG).show();
				}
	        }
	        else{
	        	
	        }
	    }
		super.onActivityResult(requestCode, resultCode, intent);
	}

	/**
	 * 
	 */
	private void addTrimesterVisit() {
		try{
			//campos de proveedor de collect
			String[] projection = new String[] {
					"_id","jrFormId","displayName"};
			//cursor que busca el formulario
			Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
					"jrFormId = 'ZP04_Trimester_Visit_A_D' and displayName = 'Estudio ZIP Visita Cuestionario Trimestral_A_D'", null, null);
			c.moveToFirst();
			//captura el id del formulario
			Integer id = Integer.parseInt(c.getString(0));
			//cierra el cursor
			if (c != null) {
				c.close();
			}
			//forma el uri para ODK Collect
			Uri formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
			//Arranca la actividad ODK Collect en busca de resultado
			Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
			startActivityForResult(odkA, ADD_TAMIZAJE_ODK);
		}
		catch(Exception e){
			//No existe el formulario en el equipo
			Log.e(TAG, e.getMessage(), e);
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
		}
	}
	
	private void parseTrimesterVisit(Integer idInstancia, String instanceFilePath) {
		Serializer serializer = new Persister(); 
		File source = new File(instanceFilePath);
		try {
			Zp04TrimesterVisitSectionAtoDXml zp04Xml = new Zp04TrimesterVisitSectionAtoDXml();
			zp04Xml = serializer.read(Zp04TrimesterVisitSectionAtoDXml.class, source);
			mIngreso.setRecordId(mRecordId);
			//mIngreso.setRedcapEventName();
			mIngreso.setTriDov(zp04Xml.getTriDov());
			mIngreso.setTriVisitTyp(zp04Xml.getTriVisitTyp());
			mIngreso.setTriOccChange(zp04Xml.getTriOccChange());
			mIngreso.setTriPrimJobInd(zp04Xml.getTriPrimJobInd());
			mIngreso.setTriPrimJobTitle(zp04Xml.getTriPrimJobTitle());
			mIngreso.setTriPrimJobTitleRef(zp04Xml.getTriPrimJobTitleRef());
			mIngreso.setTriPrimJobDat(zp04Xml.getTriPrimJobDat());
			mIngreso.setTriPrimJobYear(zp04Xml.getTriPrimJobYear());
			mIngreso.setTriPrimJobHours(zp04Xml.getTriPrimJobHours());
			mIngreso.setTriPrimJobHoursRef(zp04Xml.getTriPrimJobHoursRef());
			mIngreso.setTriPrimJobSetting(zp04Xml.getTriPrimJobSetting());
			mIngreso.setTriPrimJobSetRef(zp04Xml.getTriPrimJobSetRef());
			mIngreso.setTriPrimJobSetSpecify(zp04Xml.getTriPrimJobSetSpecify());
			mIngreso.setTriPrevJobInd(zp04Xml.getTriPrevJobInd());
			mIngreso.setTriPrevJobTitle(zp04Xml.getTriPrevJobTitle());
			mIngreso.setTriPrevJobTitleRef(zp04Xml.getTriPrevJobTitleRef());
			mIngreso.setTriPrevJobDat(zp04Xml.getTriPrevJobDat());
			mIngreso.setTriPrevJobYear(zp04Xml.getTriPrevJobYear());
			mIngreso.setTriPrevJobHours(zp04Xml.getTriPrevJobHours());
			mIngreso.setTriPrevJobHoursRef(zp04Xml.getTriPrevJobHoursRef());
			mIngreso.setTriPrevJobSetting(zp04Xml.getTriPrevJobSetting());
			mIngreso.setTriPrevJobSetRef(zp04Xml.getTriPrevJobSetRef());
			mIngreso.setTriPrevJobSetSpecify(zp04Xml.getTriPrevJobSetSpecify());
			mIngreso.setTriHusbJobInd(zp04Xml.getTriHusbJobInd());
			mIngreso.setTriHusbJobTitle(zp04Xml.getTriHusbJobTitle());
			mIngreso.setTriHusbJobTitleRef(zp04Xml.getTriHusbJobTitleRef());
			mIngreso.setTriHusbJobSet(zp04Xml.getTriHusbJobSet());
			mIngreso.setTriHusbJobSetRef(zp04Xml.getTriHusbJobSetRef());
			mIngreso.setTriHusbJobSetSpecify(zp04Xml.getTriHusbJobSetSpecify());
			mIngreso.setTriHouseSitInd(zp04Xml.getTriHouseSitInd());
			mIngreso.setTriCity(zp04Xml.getTriCity());
			mIngreso.setTriState(zp04Xml.getTriState());
			mIngreso.setTriCountry(zp04Xml.getTriCountry());
			mIngreso.setTriResidRef(zp04Xml.getTriResidRef());
			mIngreso.setTriCurrResidDur(zp04Xml.getTriCurrResidDur());
			mIngreso.setTriCurrResidDurRef(zp04Xml.getTriCurrResidDurRef());
			mIngreso.setTriNbhoodTyp(zp04Xml.getTriNbhoodTyp());
			mIngreso.setTriResidTyp(zp04Xml.getTriResidTyp());
			mIngreso.setTriResidTypSpecify(zp04Xml.getTriResidTypSpecify());
			mIngreso.setTriFloorMat(zp04Xml.getTriFloorMat());
			mIngreso.setTriFloorMatSpecify(zp04Xml.getTriFloorMatSpecify());
			mIngreso.setTriWallMat(zp04Xml.getTriWallMat());
			mIngreso.setTriWallMatSpecify(zp04Xml.getTriWallMatSpecify());
			mIngreso.setTriRoofMat(zp04Xml.getTriRoofMat());
			mIngreso.setTriRoofMatSpecify(zp04Xml.getTriRoofMatSpecify());
			mIngreso.setTriTrashDispos(zp04Xml.getTriTrashDispos());
			mIngreso.setTriTrashDisposSpecify(zp04Xml.getTriTrashDisposSpecify());
			mIngreso.setTriNumTotalRooms(zp04Xml.getTriNumTotalRooms());
			mIngreso.setTriNumSleepRooms(zp04Xml.getTriNumSleepRooms());
			mIngreso.setTriNumPeople(zp04Xml.getTriNumPeople());
			mIngreso.setTriScreensInd(zp04Xml.getTriScreensInd());
			mIngreso.setTriHouseAmenities(zp04Xml.getTriHouseAmenities());
			mIngreso.setTriTransAccess(zp04Xml.getTriTransAccess());
			mIngreso.setTriPrimWaterSrc(zp04Xml.getTriPrimWaterSrc());
			mIngreso.setTriWaterContainInd(zp04Xml.getTriWaterContainInd());
			mIngreso.setTriWaterContainTyp(zp04Xml.getTriWaterContainTyp());
			mIngreso.setTriWaterConSpecify(zp04Xml.getTriWaterConSpecify());
			mIngreso.setTriWaterTreatHome(zp04Xml.getTriWaterTreatHome());
			mIngreso.setTriWaterTreatFreq(zp04Xml.getTriWaterTreatFreq());
			mIngreso.setTriToiletTyp(zp04Xml.getTriToiletTyp());
			mIngreso.setTriToiletTypSpecify(zp04Xml.getTriToiletTypSpecify());
			mIngreso.setTriOpSewageInd(zp04Xml.getTriOpSewageInd());
			mIngreso.setTriAnimalsInd(zp04Xml.getTriAnimalsInd());
			mIngreso.setTriAnimalTyp(zp04Xml.getTriAnimalTyp());//multiple
			mIngreso.setTriAnimalSpecify(zp04Xml.getTriAnimalSpecify());
			mIngreso.setTriNumOtherAnimal(zp04Xml.getTriNumOtherAnimal());
			mIngreso.setTriNumCattle(zp04Xml.getTriNumCattle());
			mIngreso.setTriNumPig(zp04Xml.getTriNumPig());
			mIngreso.setTriNumFowl(zp04Xml.getTriNumFowl());
			mIngreso.setTriNumGoatsSheep(zp04Xml.getTriNumGoatsSheep());
			mIngreso.setTriDrugUseInd(zp04Xml.getTriDrugUseInd());
			mIngreso.setTriSmokeInd(zp04Xml.getTriSmokeInd());
			mIngreso.setTriSmokeEverInd(zp04Xml.getTriSmokeEverInd());
			mIngreso.setTriSmokeCigPrevInd(zp04Xml.getTriSmokeCigPrevInd());
			mIngreso.setTriYearsSmoked(zp04Xml.getTriYearsSmoked());
			mIngreso.setTriYearsSmokedRef(zp04Xml.getTriYearsSmokedRef());
			mIngreso.setTriNumCigDay(zp04Xml.getTriNumCigDay());
			mIngreso.setTriNumCigRef(zp04Xml.getTriNumCigRef());
			mIngreso.setTriLastCig(zp04Xml.getTriLastCig());
			mIngreso.setTriHouseSmokeInd(zp04Xml.getTriHouseSmokeInd());
			mIngreso.setTriNumHrsSmoke(zp04Xml.getTriNumHrsSmoke());
			mIngreso.setTriNumHrsSmokeRef(zp04Xml.getTriNumHrsSmokeRef());
			mIngreso.setTriLastDrink(zp04Xml.getTriLastDrink());
			mIngreso.setTriDaysDrink(zp04Xml.getTriDaysDrink());
			mIngreso.setTriNumDrinks(zp04Xml.getTriNumDrinks());
			mIngreso.setTriMarijuanaInd(zp04Xml.getTriMarijuanaInd());
			mIngreso.setTriOtherDrugsInd(zp04Xml.getTriOtherDrugsInd());
			mIngreso.setTriOtherDrugs1(zp04Xml.getTriOtherDrugs1());
			mIngreso.setTriOtherDrugs2(zp04Xml.getTriOtherDrugs2());
			mIngreso.setTriOtherDrugs3(zp04Xml.getTriOtherDrugs3());
			mIngreso.setTriOtherDrugs4(zp04Xml.getTriOtherDrugs4());
			mIngreso.setRecordDate(new Date());
			mIngreso.setRecordUser(username);
			mIngreso.setIdInstancia(idInstancia);
			mIngreso.setInstancePath(instanceFilePath);
			mIngreso.setEstado(Constants.STATUS_NOT_SUBMITTED);
			mIngreso.setStart(zp04Xml.getStart());
			mIngreso.setEnd(zp04Xml.getEnd());
			mIngreso.setDeviceid(zp04Xml.getDeviceid());
			mIngreso.setSimserial(zp04Xml.getSimserial());
			mIngreso.setPhonenumber(zp04Xml.getPhonenumber());
			mIngreso.setToday(zp04Xml.getToday());
			new SaveDataTask().execute();
			
		} catch (Exception e) {
			// Presenta el error al parsear el xml
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}		
	}
	
	// ***************************************
	// Private classes
	// ***************************************
	private class SaveDataTask extends AsyncTask<String, Void, String> {
		@Override
		protected void onPreExecute() {
			// before the request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected String doInBackground(String... values) {
			try {
				zipA.open();
				zipA.crearZp04TrimesterVisitSectionAtoD(mIngreso);
				zipA.close();
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return "error";
			}
			return "exito";
		}

		protected void onPostExecute(String resultado) {
			// after the network request completes, hide the progress indicator
			dismissProgressDialog();
			showResult(resultado);
		}

	}

	// ***************************************
	// Private methods
	// ***************************************
	private void showResult(String resultado) {
		Toast.makeText(getApplicationContext(),	resultado, Toast.LENGTH_LONG).show();
	}	


}
