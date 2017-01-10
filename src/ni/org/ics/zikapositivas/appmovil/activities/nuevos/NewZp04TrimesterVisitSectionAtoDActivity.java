package ni.org.ics.zikapositivas.appmovil.activities.nuevos;

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
import ni.org.ics.zikapositivas.appmovil.AbstractAsyncActivity;
import ni.org.ics.zikapositivas.appmovil.MainActivity;
import ni.org.ics.zikapositivas.appmovil.MyZikaPosApplication;
import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.Zp04TrimesterVisitSectionAtoD;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp04TrimesterVisitSectionAtoDXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.R;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.io.File;
import java.util.Date;


public class NewZp04TrimesterVisitSectionAtoDActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewZp04TrimesterVisitSectionAtoDActivity.class.getSimpleName();
	
	private ZikaPosAdapter zikaPosA;
	private static Zp04TrimesterVisitSectionAtoD mZp04A = null;
	
	public static final int ADD_ZP04A_ODK = 1;
	public static final int EDIT_ZP04A_ODK = 2;

	Dialog dialogInit;
	private SharedPreferences settings;
	private String username;
	private String mRecordId = "";
	private Integer accion = 0;
	private String event;

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
		String mPass = ((MyZikaPosApplication) this.getApplication()).getPassApp();
		zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
        mZp04A = (Zp04TrimesterVisitSectionAtoD) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP04A);
        mRecordId = getIntent().getExtras().getString(Constants.RECORDID);
        event = getIntent().getExtras().getString(Constants.EVENT);
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
		if (mZp04A!=null){
			message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_6)+"?");
		}
		else{
			message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_6)+"?");
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
		if(requestCode == ADD_ZP04A_ODK||requestCode == EDIT_ZP04A_ODK) {
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
					parseTrimesterVisit(idInstancia,instanceFilePath,accion);
				}
				else{
					Toast.makeText(getApplicationContext(),	getString(R.string.err_not_completed), Toast.LENGTH_LONG).show();
				}
	        }
	        else{
	        	finish();
	        }
	    }
		super.onActivityResult(requestCode, resultCode, intent);
	}

	/**
	 * 
	 */
	private void addTrimesterVisit() {
		try{
			Uri formUri;
			if(mZp04A==null){
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
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
				accion = ADD_ZP04A_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mZp04A.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP04A_ODK;
			}
			Intent odkA =  new Intent(Intent.ACTION_EDIT,formUri);
			//Arranca la actividad proveedor de instancias de ODK Collect en busca de resultado
			startActivityForResult(odkA, accion);
		}
		catch(Exception e){
			//No existe el formulario en el equipo
			Log.e(TAG, e.getMessage(), e);
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
			finish();
		}
	}
	
	private void parseTrimesterVisit(Integer idInstancia, String instanceFilePath, Integer accion) {
		Serializer serializer = new Persister(); 
		File source = new File(instanceFilePath);
		try {
			Zp04TrimesterVisitSectionAtoDXml zp04Xml = new Zp04TrimesterVisitSectionAtoDXml();
			zp04Xml = serializer.read(Zp04TrimesterVisitSectionAtoDXml.class, source);
			if (accion==ADD_ZP04A_ODK) mZp04A = new Zp04TrimesterVisitSectionAtoD();
			mZp04A.setRecordId(mRecordId);
			mZp04A.setRedcapEventName(event);
			mZp04A.setTriDov(zp04Xml.getTriDov());
			mZp04A.setTriVisitTyp(zp04Xml.getTriVisitTyp());
			mZp04A.setTriOccChange(zp04Xml.getTriOccChange());
			mZp04A.setTriPrimJobInd(zp04Xml.getTriPrimJobInd());
			mZp04A.setTriPrimJobTitle(zp04Xml.getTriPrimJobTitle());
			mZp04A.setTriPrimJobTitleRef(zp04Xml.getTriPrimJobTitleRef());
			mZp04A.setTriPrimJobDat(zp04Xml.getTriPrimJobDat());
			mZp04A.setTriPrimJobYear(zp04Xml.getTriPrimJobYear());
			mZp04A.setTriPrimJobHours(zp04Xml.getTriPrimJobHours());
			mZp04A.setTriPrimJobHoursRef(zp04Xml.getTriPrimJobHoursRef());
			mZp04A.setTriPrimJobSetting(zp04Xml.getTriPrimJobSetting());
			mZp04A.setTriPrimJobSetRef(zp04Xml.getTriPrimJobSetRef());
			mZp04A.setTriPrimJobSetSpecify(zp04Xml.getTriPrimJobSetSpecify());
			mZp04A.setTriPrevJobInd(zp04Xml.getTriPrevJobInd());
			mZp04A.setTriPrevJobTitle(zp04Xml.getTriPrevJobTitle());
			mZp04A.setTriPrevJobTitleRef(zp04Xml.getTriPrevJobTitleRef());
			mZp04A.setTriPrevJobDat(zp04Xml.getTriPrevJobDat());
			mZp04A.setTriPrevJobYear(zp04Xml.getTriPrevJobYear());
			mZp04A.setTriPrevJobHours(zp04Xml.getTriPrevJobHours());
			mZp04A.setTriPrevJobHoursRef(zp04Xml.getTriPrevJobHoursRef());
			mZp04A.setTriPrevJobSetting(zp04Xml.getTriPrevJobSetting());
			mZp04A.setTriPrevJobSetRef(zp04Xml.getTriPrevJobSetRef());
			mZp04A.setTriPrevJobSetSpecify(zp04Xml.getTriPrevJobSetSpecify());
			mZp04A.setTriHusbJobInd(zp04Xml.getTriHusbJobInd());
			mZp04A.setTriHusbJobTitle(zp04Xml.getTriHusbJobTitle());
			mZp04A.setTriHusbJobTitleRef(zp04Xml.getTriHusbJobTitleRef());
			mZp04A.setTriHusbJobSet(zp04Xml.getTriHusbJobSet());
			mZp04A.setTriHusbJobSetRef(zp04Xml.getTriHusbJobSetRef());
			mZp04A.setTriHusbJobSetSpecify(zp04Xml.getTriHusbJobSetSpecify());
			mZp04A.setTriHouseSitInd(zp04Xml.getTriHouseSitInd());
			mZp04A.setTriCity(zp04Xml.getTriCity());
			mZp04A.setTriState(zp04Xml.getTriState());
			mZp04A.setTriCountry(zp04Xml.getTriCountry());
			mZp04A.setTriResidRef(zp04Xml.getTriResidRef());
			mZp04A.setTriCurrResidDur(zp04Xml.getTriCurrResidDur());
			mZp04A.setTriCurrResidDurRef(zp04Xml.getTriCurrResidDurRef());
			mZp04A.setTriNbhoodTyp(zp04Xml.getTriNbhoodTyp());
			mZp04A.setTriResidTyp(zp04Xml.getTriResidTyp());
			mZp04A.setTriResidTypSpecify(zp04Xml.getTriResidTypSpecify());
			mZp04A.setTriFloorMat(zp04Xml.getTriFloorMat());
			mZp04A.setTriFloorMatSpecify(zp04Xml.getTriFloorMatSpecify());
			mZp04A.setTriWallMat(zp04Xml.getTriWallMat());
			mZp04A.setTriWallMatSpecify(zp04Xml.getTriWallMatSpecify());
			mZp04A.setTriRoofMat(zp04Xml.getTriRoofMat());
			mZp04A.setTriRoofMatSpecify(zp04Xml.getTriRoofMatSpecify());
			mZp04A.setTriTrashDispos(zp04Xml.getTriTrashDispos());
			mZp04A.setTriTrashDisposSpecify(zp04Xml.getTriTrashDisposSpecify());
			mZp04A.setTriNumTotalRooms(zp04Xml.getTriNumTotalRooms());
			mZp04A.setTriNumSleepRooms(zp04Xml.getTriNumSleepRooms());
			mZp04A.setTriNumPeople(zp04Xml.getTriNumPeople());
			mZp04A.setTriScreensInd(zp04Xml.getTriScreensInd());
			mZp04A.setTriHouseAmenities(zp04Xml.getTriHouseAmenities());
			mZp04A.setTriTransAccess(zp04Xml.getTriTransAccess());
			mZp04A.setTriPrimWaterSrc(zp04Xml.getTriPrimWaterSrc());
			mZp04A.setTriWaterContainInd(zp04Xml.getTriWaterContainInd());
			mZp04A.setTriWaterContainTyp(zp04Xml.getTriWaterContainTyp());
			mZp04A.setTriWaterConSpecify(zp04Xml.getTriWaterConSpecify());
			mZp04A.setTriWaterTreatHome(zp04Xml.getTriWaterTreatHome());
			mZp04A.setTriWaterTreatFreq(zp04Xml.getTriWaterTreatFreq());
			mZp04A.setTriToiletTyp(zp04Xml.getTriToiletTyp());
			mZp04A.setTriToiletTypSpecify(zp04Xml.getTriToiletTypSpecify());
			mZp04A.setTriOpSewageInd(zp04Xml.getTriOpSewageInd());
			mZp04A.setTriAnimalsInd(zp04Xml.getTriAnimalsInd());
			mZp04A.setTriAnimalTyp(zp04Xml.getTriAnimalTyp());//multiple
			mZp04A.setTriAnimalSpecify(zp04Xml.getTriAnimalSpecify());
			mZp04A.setTriNumOtherAnimal(zp04Xml.getTriNumOtherAnimal());
			mZp04A.setTriNumCattle(zp04Xml.getTriNumCattle());
			mZp04A.setTriNumPig(zp04Xml.getTriNumPig());
			mZp04A.setTriNumFowl(zp04Xml.getTriNumFowl());
			mZp04A.setTriNumGoatsSheep(zp04Xml.getTriNumGoatsSheep());
			mZp04A.setTriDrugUseInd(zp04Xml.getTriDrugUseInd());
			mZp04A.setTriSmokeInd(zp04Xml.getTriSmokeInd());
			mZp04A.setTriSmokeEverInd(zp04Xml.getTriSmokeEverInd());
			mZp04A.setTriSmokeCigPrevInd(zp04Xml.getTriSmokeCigPrevInd());
			mZp04A.setTriYearsSmoked(zp04Xml.getTriYearsSmoked());
			mZp04A.setTriYearsSmokedRef(zp04Xml.getTriYearsSmokedRef());
			mZp04A.setTriNumCigDay(zp04Xml.getTriNumCigDay());
			mZp04A.setTriNumCigRef(zp04Xml.getTriNumCigRef());
			mZp04A.setTriLastCig(zp04Xml.getTriLastCig());
			mZp04A.setTriHouseSmokeInd(zp04Xml.getTriHouseSmokeInd());
			mZp04A.setTriNumHrsSmoke(zp04Xml.getTriNumHrsSmoke());
			mZp04A.setTriNumHrsSmokeRef(zp04Xml.getTriNumHrsSmokeRef());
			mZp04A.setTriLastDrink(zp04Xml.getTriLastDrink());
			mZp04A.setTriDaysDrink(zp04Xml.getTriDaysDrink());
			mZp04A.setTriNumDrinks(zp04Xml.getTriNumDrinks());
			mZp04A.setTriMarijuanaInd(zp04Xml.getTriMarijuanaInd());
			mZp04A.setTriOtherDrugsInd(zp04Xml.getTriOtherDrugsInd());
			mZp04A.setTriOtherDrugs1(zp04Xml.getTriOtherDrugs1());
			mZp04A.setTriOtherDrugs2(zp04Xml.getTriOtherDrugs2());
			mZp04A.setTriOtherDrugs3(zp04Xml.getTriOtherDrugs3());
			mZp04A.setTriOtherDrugs4(zp04Xml.getTriOtherDrugs4());
			
            //Version 2
            mZp04A.setTriAddtMedicines(zp04Xml.getTriAddtMedicines());
            mZp04A.setTriAddtDrugsType(zp04Xml.getTriAddtDrugsType());
            mZp04A.setTriAddtOthDrugsType1(zp04Xml.getTriAddtOthDrugsType1());
            mZp04A.setTriAddtOthDrugsBrand1(zp04Xml.getTriAddtOthDrugsBrand1());
            mZp04A.setTriAddtOthDrugsType2(zp04Xml.getTriAddtOthDrugsType2());
            mZp04A.setTriAddtOthDrugsBrand2(zp04Xml.getTriAddtOthDrugsBrand2());
            mZp04A.setTriAddtOthDrugsType3(zp04Xml.getTriAddtOthDrugsType3());
            mZp04A.setTriAddtOthDrugsBrand3(zp04Xml.getTriAddtOthDrugsBrand3());
            mZp04A.setTriAddtOthDrugsType4(zp04Xml.getTriAddtOthDrugsType4());
            mZp04A.setTriAddtOthDrugsBrand4(zp04Xml.getTriAddtOthDrugsBrand4());
            mZp04A.setTriAddtOthDrugsType5(zp04Xml.getTriAddtOthDrugsType5());
            mZp04A.setTriAddtOthDrugsBrand5(zp04Xml.getTriAddtOthDrugsBrand5());
            // termina Version2
            
			mZp04A.setRecordDate(new Date());
			mZp04A.setRecordUser(username);
			mZp04A.setIdInstancia(idInstancia);
			mZp04A.setInstancePath(instanceFilePath);
			mZp04A.setEstado(Constants.STATUS_NOT_SUBMITTED);
			mZp04A.setStart(zp04Xml.getStart());
			mZp04A.setEnd(zp04Xml.getEnd());
			mZp04A.setDeviceid(zp04Xml.getDeviceid());
			mZp04A.setSimserial(zp04Xml.getSimserial());
			mZp04A.setPhonenumber(zp04Xml.getPhonenumber());
			mZp04A.setToday(zp04Xml.getToday());
			new SaveDataTask().execute(accion);
			
		} catch (Exception e) {
			// Presenta el error al parsear el xml
			Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
			e.printStackTrace();
			finish();
		}		
	}
	
	// ***************************************
	// Private classes
	// ***************************************
	private class SaveDataTask extends AsyncTask<Integer, Void, String> {
		private Integer accionaRealizar = null;
		@Override
		protected void onPreExecute() {
			// before the request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected String doInBackground(Integer... values) {
			accionaRealizar = values[0];
			try {
				zikaPosA.open();
				if (accionaRealizar == ADD_ZP04A_ODK){
					zikaPosA.crearZp04TrimesterVisitSectionAtoD(mZp04A);
				}
				else{
					zikaPosA.editarZp04TrimesterVisitSectionAtoD(mZp04A);
				}
				zikaPosA.close();
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
		finish();
	}	


}
