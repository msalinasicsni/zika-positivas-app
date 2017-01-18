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
import ni.org.ics.zikapositivas.appmovil.domain.Zp01StudyEntrySectionE;
import ni.org.ics.zikapositivas.appmovil.parsers.Zp01StudyEntrySectionEXml;
import ni.org.ics.zikapositivas.appmovil.preferences.PreferencesActivity;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.FileUtils;
import ni.org.ics.zikapositivas.appmovil.R;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.Date;


public class NewZp01StudyEntrySectionEActivity extends AbstractAsyncActivity {

	protected static final String TAG = NewZp01StudyEntrySectionEActivity.class.getSimpleName();
	
	private ZikaPosAdapter zikaPosA;
	private static Zp01StudyEntrySectionE mZp01E = null;
	
	public static final int ADD_ZP01E_ODK = 1;
	public static final int EDIT_ZP01E_ODK = 2;

	Dialog dialogInit;
	private SharedPreferences settings;
	private String username;
	private String mRecordId = "";
	private Integer accion = 0;

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
		mZp01E = (Zp01StudyEntrySectionE) getIntent().getExtras().getSerializable(Constants.OBJECTO_ZP01E);
        mRecordId = getIntent().getExtras().getString(Constants.RECORDID);
        zikaPosA = new ZikaPosAdapter(this.getApplicationContext(),mPass,false,false);
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
		if (mZp01E!=null){
			message.setText(getString(R.string.edit)+ " " + getString(R.string.maternal_b_2)+"?");
		}
		else{
			message.setText(getString(R.string.add)+ " " + getString(R.string.maternal_b_2)+"?");
		}

		//add some action to the buttons

		Button yes = (Button) dialogInit.findViewById(R.id.yesnoYes);
		yes.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				dialogInit.dismiss();
				addStudyEntryE();
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
		if(requestCode == ADD_ZP01E_ODK||requestCode == EDIT_ZP01E_ODK) {
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
					parseStudyEntryE(idInstancia,instanceFilePath,accion);
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
	private void addStudyEntryE() {
		try{
			Uri formUri;
			if(mZp01E==null){
				//campos de proveedor de collect
				String[] projection = new String[] {
						"_id","jrFormId","displayName"};
				//cursor que busca el formulario
				Cursor c = getContentResolver().query(Constants.CONTENT_URI, projection,
						"jrFormId = 'ZPos01_study_entry_e' and displayName = 'Zika Positivas Visita inicial en el estudio_E'", null, null);
				c.moveToFirst();
				//captura el id del formulario
				Integer id = Integer.parseInt(c.getString(0));
				//cierra el cursor
				if (c != null) {
					c.close();
				}
				//forma el uri para ODK Collect
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI,id);
				accion = ADD_ZP01E_ODK;
			}
			else{
				//forma el uri para la instancia en ODK Collect
				Integer id = mZp01E.getIdInstancia();
				formUri = ContentUris.withAppendedId(Constants.CONTENT_URI_I,id);
				accion = EDIT_ZP01E_ODK;
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
	
	private void parseStudyEntryE(Integer idInstancia, String instanceFilePath, Integer accion) {
		Serializer serializer = new Persister(); 
		File source = new File(instanceFilePath);
		try {
			Zp01StudyEntrySectionEXml zp01Xml = new Zp01StudyEntrySectionEXml();
			zp01Xml = serializer.read(Zp01StudyEntrySectionEXml.class, source);
			if (accion==ADD_ZP01E_ODK) mZp01E = new Zp01StudyEntrySectionE();
			mZp01E.setRecordId(mRecordId);
			mZp01E.setRedcapEventName(Constants.ENTRY);
            mZp01E.setSeaDiseases(zp01Xml.getSeaDiseases());
            mZp01E.setSeaOtherSpecify(zp01Xml.getSeaOtherSpecify());
            mZp01E.setSeaHepatitis(zp01Xml.getSeaHepatitis());
            mZp01E.setSeaHepatitisDate1(zp01Xml.getSeaHepatitisDate1());
            mZp01E.setSeaHepatitisDate2(zp01Xml.getSeaHepatitisDate2());
            mZp01E.setSeaHepatitisDate3(zp01Xml.getSeaHepatitisDate3());
            mZp01E.setSeaMeasles(zp01Xml.getSeaMeasles());
            mZp01E.setSeaMeaslesDate1(zp01Xml.getSeaMeaslesDate1());
            mZp01E.setSeaMeaslesDate2(zp01Xml.getSeaMeaslesDate2());
            mZp01E.setSeaMeaslesDate3(zp01Xml.getSeaMeaslesDate3());
            mZp01E.setSeaChickenpox(zp01Xml.getSeaChickenpox());
            mZp01E.setSeaChickenpoxDate1(zp01Xml.getSeaChickenpoxDate1());
            mZp01E.setSeaChickenpoxDate2(zp01Xml.getSeaChickenpoxDate2());
            mZp01E.setSeaChickenpoxDate3(zp01Xml.getSeaChickenpoxDate3());
            mZp01E.setSeaInfluenza(zp01Xml.getSeaInfluenza());
            mZp01E.setSeaInfluenzaDate1(zp01Xml.getSeaInfluenzaDate1());
            mZp01E.setSeaInfluenzaDate2(zp01Xml.getSeaInfluenzaDate2());
            mZp01E.setSeaInfluenzaDate3(zp01Xml.getSeaInfluenzaDate3());
            mZp01E.setSeaYellow(zp01Xml.getSeaYellow());
            mZp01E.setSeaYellowDate1(zp01Xml.getSeaYellowDate1());
            mZp01E.setSeaYellowDate2(zp01Xml.getSeaYellowDate2());
            mZp01E.setSeaYellowDate3(zp01Xml.getSeaYellowDate3());
            mZp01E.setSeaDengue(zp01Xml.getSeaDengue());
            mZp01E.setSeaDengueDate1(zp01Xml.getSeaDengueDate1());
            mZp01E.setSeaDengueDate2(zp01Xml.getSeaDengueDate2());
            mZp01E.setSeaDengueDate3(zp01Xml.getSeaDengueDate3());
            mZp01E.setSeaVacOther(zp01Xml.getSeaVacOther());
            mZp01E.setSeaVacotherSpecify(zp01Xml.getSeaVacotherSpecify());
            mZp01E.setSeaOtherDate1(zp01Xml.getSeaOtherDate1());
            mZp01E.setSeaOtherDate2(zp01Xml.getSeaOtherDate2());
            mZp01E.setSeaOtherDate3(zp01Xml.getSeaOtherDate3());
            mZp01E.setSeaRubella(zp01Xml.getSeaRubella());
            mZp01E.setSeaRubellaDate1(zp01Xml.getSeaRubellaDate1());
            mZp01E.setSeaRubellaDate2(zp01Xml.getSeaRubellaDate2());
            mZp01E.setSeaRubellaDate3(zp01Xml.getSeaRubellaDate3());
            mZp01E.setSeaRubellaDoc(zp01Xml.getSeaRubellaDoc());
            mZp01E.setSeaCmv(zp01Xml.getSeaCmv());
            mZp01E.setSeaCmvDate1(zp01Xml.getSeaCmvDate1());
            mZp01E.setSeaCmvDate2(zp01Xml.getSeaCmvDate2());
            mZp01E.setSeaCmvDate3(zp01Xml.getSeaCmvDate3());
            mZp01E.setSeaCmvDoc(zp01Xml.getSeaCmvDoc());
            mZp01E.setSeaHerpes(zp01Xml.getSeaHerpes());
            mZp01E.setSeaHerpesDate1(zp01Xml.getSeaHerpesDate1());
            mZp01E.setSeaHerpesDate2(zp01Xml.getSeaHerpesDate2());
            mZp01E.setSeaHerpesDate3(zp01Xml.getSeaHerpesDate3());
            mZp01E.setSeaHerpesDoc(zp01Xml.getSeaHerpesDoc());
            mZp01E.setSeaParvovirus(zp01Xml.getSeaParvovirus());
            mZp01E.setSeaParvovirusDate1(zp01Xml.getSeaParvovirusDate1());
            mZp01E.setSeaParvovirusDate2(zp01Xml.getSeaParvovirusDate2());
            mZp01E.setSeaParvovirusDate3(zp01Xml.getSeaParvovirusDate3());
            mZp01E.setSeaParvovirusDoc(zp01Xml.getSeaParvovirusDoc());
            mZp01E.setSeaToxoplasmosis(zp01Xml.getSeaToxoplasmosis());
            mZp01E.setSeaToxoplasmosisDate1(zp01Xml.getSeaToxoplasmosisDate1());
            mZp01E.setSeaToxoplasmosisDate2(zp01Xml.getSeaToxoplasmosisDate2());
            mZp01E.setSeaToxoplasmosisDate3(zp01Xml.getSeaToxoplasmosisDate3());
            mZp01E.setSeaToxoplasmosisDoc(zp01Xml.getSeaToxoplasmosisDoc());
            mZp01E.setSeaSyphillis(zp01Xml.getSeaSyphillis());
            mZp01E.setSeaSyphillisDate1(zp01Xml.getSeaSyphillisDate1());
            mZp01E.setSeaSyphillisDate2(zp01Xml.getSeaSyphillisDate2());
            mZp01E.setSeaSyphillisDate3(zp01Xml.getSeaSyphillisDate3());
            mZp01E.setSeaSyphillisDoc(zp01Xml.getSeaSyphillisDoc());
            mZp01E.setSeaHiv(zp01Xml.getSeaHiv());
            mZp01E.setSeaHivDate1(zp01Xml.getSeaHivDate1());
            mZp01E.setSeaHivDate2(zp01Xml.getSeaHivDate2());
            mZp01E.setSeaHivDate3(zp01Xml.getSeaHivDate3());
            mZp01E.setSeaHivDoc(zp01Xml.getSeaHivDoc());
            mZp01E.setSeaZika(zp01Xml.getSeaZika());
            mZp01E.setSeaZikaDate1(zp01Xml.getSeaZikaDate1());
            mZp01E.setSeaZikaDate2(zp01Xml.getSeaZikaDate2());
            mZp01E.setSeaZikaDate3(zp01Xml.getSeaZikaDate3());
            mZp01E.setSeaZikaDoc(zp01Xml.getSeaZikaDoc());
            mZp01E.setSeaChikung(zp01Xml.getSeaChikung());
            mZp01E.setSeaChikungDate1(zp01Xml.getSeaChikungDate1());
            mZp01E.setSeaChikungDate2(zp01Xml.getSeaChikungDate2());
            mZp01E.setSeaChikungDate3(zp01Xml.getSeaChikungDate3());
            mZp01E.setSeaChikungDoc(zp01Xml.getSeaChikungDoc());
            mZp01E.setSeaInfluInfect(zp01Xml.getSeaInfluInfect());
            mZp01E.setSeaInflueInfectDate1(zp01Xml.getSeaInflueInfectDate1());
            mZp01E.setSeaInfluInfectDate2(zp01Xml.getSeaInfluInfectDate2());
            mZp01E.setSeaInfluInfectDate3(zp01Xml.getSeaInfluInfectDate3());
            mZp01E.setSeaInfluInfectDoc(zp01Xml.getSeaInfluInfectDoc());
            mZp01E.setSeaDengueInfect(zp01Xml.getSeaDengueInfect());
            mZp01E.setSeaDengueInfectDate1(zp01Xml.getSeaDengueInfectDate1());
            mZp01E.setSeaDengueInfectDate2(zp01Xml.getSeaDengueInfectDate2());
            mZp01E.setSeaDengueInfectDate3(zp01Xml.getSeaDengueInfectDate3());
            mZp01E.setSeaDengueInfectDoc(zp01Xml.getSeaDengueInfectDoc());
            mZp01E.setSeaFeverSymptom(zp01Xml.getSeaFeverSymptom());
            mZp01E.setSeaRash(zp01Xml.getSeaRash());
            mZp01E.setSeaItch(zp01Xml.getSeaItch());
            mZp01E.setSeaRashFirst(zp01Xml.getSeaRashFirst());
            mZp01E.setSeaRashDay(zp01Xml.getSeaRashDay());
            mZp01E.setSeaRashMonth(zp01Xml.getSeaRashMonth());
            mZp01E.setSeaRashYear(zp01Xml.getSeaRashYear());
            mZp01E.setSeaRashDuration(zp01Xml.getSeaRashDuration());
            mZp01E.setSeaRashSpread(zp01Xml.getSeaRashSpread());
            mZp01E.setSeaSpreadPart(zp01Xml.getSeaSpreadPart());
            mZp01E.setSeaFeverExperience(zp01Xml.getSeaFeverExperience());
            mZp01E.setSeaTempMeasure(zp01Xml.getSeaTempMeasure());
            mZp01E.setSeaHighTemp(zp01Xml.getSeaHighTemp());
            mZp01E.setSeaHightemUnit(zp01Xml.getSeaHightemUnit());
            mZp01E.setSeaTempunknown(zp01Xml.getSeaTempunknown());
            mZp01E.setSeaFeverDay(zp01Xml.getSeaFeverDay());
            mZp01E.setSeaFeverMonth(zp01Xml.getSeaFeverMonth());
            mZp01E.setSeaFeverYear(zp01Xml.getSeaFeverYear());
            mZp01E.setSeaFeverDuration(zp01Xml.getSeaFeverDuration());
            mZp01E.setSeaRedeyes(zp01Xml.getSeaRedeyes());
            mZp01E.setSeaRedeyesDay(zp01Xml.getSeaRedeyesDay());
            mZp01E.setSeaRedeyesMonth(zp01Xml.getSeaRedeyesMonth());
            mZp01E.setSeaRedeyesYear(zp01Xml.getSeaRedeyesYear());
            mZp01E.setSeaRedeyesDuration(zp01Xml.getSeaRedeyesDuration());
            mZp01E.setSeaOccurSame(zp01Xml.getSeaOccurSame());
            mZp01E.setSeaSameSymptom(zp01Xml.getSeaSameSymptom());
            mZp01E.setSeaJoint(zp01Xml.getSeaJoint());
            mZp01E.setSeaJointDay(zp01Xml.getSeaJointDay());
            mZp01E.setSeaJointMonth(zp01Xml.getSeaJointMonth());
            mZp01E.setSeaJointYear(zp01Xml.getSeaJointYear());
            mZp01E.setSeaJointDuration(zp01Xml.getSeaJointDuration());
            mZp01E.setSeaHeadache(zp01Xml.getSeaHeadache());
            mZp01E.setSeaHeadacheDay(zp01Xml.getSeaHeadacheDay());
            mZp01E.setSeaHeadacheMonth(zp01Xml.getSeaHeadacheMonth());
            mZp01E.setSeaHeadacheYear(zp01Xml.getSeaHeadacheYear());
            mZp01E.setSeaHeadacheDuration(zp01Xml.getSeaHeadacheDuration());
            mZp01E.setSeaSymptomOther(zp01Xml.getSeaSymptomOther());
            mZp01E.setSeaSpecifySymptom(zp01Xml.getSeaSpecifySymptom());
            mZp01E.setSeaOtherSymptom(zp01Xml.getSeaOtherSymptom());
            mZp01E.setSeaMedicare(zp01Xml.getSeaMedicare());
            mZp01E.setSeaCareDay(zp01Xml.getSeaCareDay());
            mZp01E.setSeaCareMonth(zp01Xml.getSeaCareMonth());
            mZp01E.setSeaCareYear(zp01Xml.getSeaCareYear());
            mZp01E.setSeaCareFacility(zp01Xml.getSeaCareFacility());
            mZp01E.setSeaHospitalized(zp01Xml.getSeaHospitalized());
            mZp01E.setSeaHospital(zp01Xml.getSeaHospital());
            mZp01E.setSeaDiagRubella(zp01Xml.getSeaDiagRubella());
            mZp01E.setSeaDiagDengue(zp01Xml.getSeaDiagDengue());
            mZp01E.setSeaDiagChikung(zp01Xml.getSeaDiagChikung());
            mZp01E.setSeaDiagZika(zp01Xml.getSeaDiagZika());
            mZp01E.setSeaDiagCytome(zp01Xml.getSeaDiagCytome());
            mZp01E.setSeaMedicine(zp01Xml.getSeaMedicine());
            mZp01E.setSeaMedcineName(zp01Xml.getSeaMedcineName());
            mZp01E.setSeaGuillainbarre(zp01Xml.getSeaGuillainbarre());
            mZp01E.setSeaTingling(zp01Xml.getSeaTingling());
            mZp01E.setSeaTinglingArm(zp01Xml.getSeaTinglingArm());
            mZp01E.setSeaTinglingLeg(zp01Xml.getSeaTinglingLeg());
            mZp01E.setSeaTinglingHand(zp01Xml.getSeaTinglingHand());
            mZp01E.setSeaTinglingFoot(zp01Xml.getSeaTinglingFoot());
            mZp01E.setSeaTinglingFace(zp01Xml.getSeaTinglingFace());
            mZp01E.setSeaTinglingOther(zp01Xml.getSeaTinglingOther());
            mZp01E.setSeaSensationMin(zp01Xml.getSeaSensationMin());
            mZp01E.setSeaSensationHr(zp01Xml.getSeaSensationHr());
            mZp01E.setSeaSenstaionDay(zp01Xml.getSeaSenstaionDay());
            mZp01E.setSeaInjury(zp01Xml.getSeaInjury());
            mZp01E.setSeaTinglingDay(zp01Xml.getSeaTinglingDay());
            mZp01E.setSeaTinglingMonth(zp01Xml.getSeaTinglingMonth());
            mZp01E.setSeaTinglingYear(zp01Xml.getSeaTinglingYear());
            mZp01E.setSeaTinglingDuration(zp01Xml.getSeaTinglingDuration());
            mZp01E.setSeaNumbness(zp01Xml.getSeaNumbness());
            mZp01E.setSeaNumbArm(zp01Xml.getSeaNumbArm());
            mZp01E.setSeaNumbLeg(zp01Xml.getSeaNumbLeg());
            mZp01E.setSeaNumbHand(zp01Xml.getSeaNumbHand());
            mZp01E.setSeaNumbFoot(zp01Xml.getSeaNumbFoot());
            mZp01E.setSeaNumbFace(zp01Xml.getSeaNumbFace());
            mZp01E.setSeaNumbOther(zp01Xml.getSeaNumbOther());
            mZp01E.setSeaNumbDay(zp01Xml.getSeaNumbDay());
            mZp01E.setSeaNumbMonth(zp01Xml.getSeaNumbMonth());
            mZp01E.setSeaNumbYear(zp01Xml.getSeaNumbYear());
            mZp01E.setSeaNumbDuration(zp01Xml.getSeaNumbDuration());
            mZp01E.setSeaParalysis(zp01Xml.getSeaParalysis());
            mZp01E.setSeaParaArm(zp01Xml.getSeaParaArm());
            mZp01E.setSeaParaLeg(zp01Xml.getSeaParaLeg());
            mZp01E.setSeaParaHand(zp01Xml.getSeaParaHand());
            mZp01E.setSeaParaFoot(zp01Xml.getSeaParaFoot());
            mZp01E.setSeaParaFace(zp01Xml.getSeaParaFace());
            mZp01E.setSeaParaOther(zp01Xml.getSeaParaOther());
            mZp01E.setSeaParaDay(zp01Xml.getSeaParaDay());
            mZp01E.setSeaParaMonth(zp01Xml.getSeaParaMonth());
            mZp01E.setSeaParaYear(zp01Xml.getSeaParaYear());
            mZp01E.setSeaParaDuration(zp01Xml.getSeaParaDuration());
			mZp01E.setRecordDate(new Date());
			mZp01E.setRecordUser(username);
			mZp01E.setIdInstancia(idInstancia);
			mZp01E.setInstancePath(instanceFilePath);
			mZp01E.setEstado(Constants.STATUS_NOT_SUBMITTED);
			mZp01E.setStart(zp01Xml.getStart());
			mZp01E.setEnd(zp01Xml.getEnd());
			mZp01E.setDeviceid(zp01Xml.getDeviceid());
			mZp01E.setSimserial(zp01Xml.getSimserial());
			mZp01E.setPhonenumber(zp01Xml.getPhonenumber());
			mZp01E.setToday(zp01Xml.getToday());
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
				if (accionaRealizar == ADD_ZP01E_ODK){
					zikaPosA.crearZp01StudyEntrySectionE(mZp01E);
				}
				else{
					zikaPosA.editarZp01StudyEntrySectionE(mZp01E);
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
