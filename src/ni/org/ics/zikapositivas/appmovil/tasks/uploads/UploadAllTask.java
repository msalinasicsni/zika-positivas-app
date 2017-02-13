package ni.org.ics.zikapositivas.appmovil.tasks.uploads;

import java.util.ArrayList;
import java.util.List;

import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.*;
import ni.org.ics.zikapositivas.appmovil.listeners.UploadListener;
import ni.org.ics.zikapositivas.appmovil.tasks.UploadTask;
import ni.org.ics.zikapositivas.appmovil.utils.Constants;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.content.Context;
import android.util.Log;

public class UploadAllTask extends UploadTask {

    private final Context mContext;

    public UploadAllTask(Context context) {
        mContext = context;
    }

    protected static final String TAG = UploadAllTask.class.getSimpleName();
    private ZikaPosAdapter zikaPosA = null;
    private static final String TOTAL_TASK = "22";
    private List<ZpPreScreening> mPreTamizajes = new ArrayList<ZpPreScreening>();
    private List<Zp00Screening> mTamizajes = new ArrayList<Zp00Screening>();
    private List<Zp01StudyEntrySectionAtoD> mIngresosAD = new ArrayList<Zp01StudyEntrySectionAtoD>();
    private List<Zp01StudyEntrySectionE> mIngresosE = new ArrayList<Zp01StudyEntrySectionE>();
    private List<Zp01StudyEntrySectionFtoK> mIngresosFK = new ArrayList<Zp01StudyEntrySectionFtoK>();
    private List<Zp02BiospecimenCollection> mCollections = new ArrayList<Zp02BiospecimenCollection>();
    private List<Zp03MonthlyVisit> mMonthlyVisits = new ArrayList<Zp03MonthlyVisit>();
    private List<Zp04TrimesterVisitSectionAtoD> mTrimesterVisitAD = new ArrayList<Zp04TrimesterVisitSectionAtoD>();
    private List<Zp04TrimesterVisitSectionE> mTrimesterVisitE = new ArrayList<Zp04TrimesterVisitSectionE>();
    private List<Zp04TrimesterVisitSectionFtoH> mTrimesterVisitFH = new ArrayList<Zp04TrimesterVisitSectionFtoH>();
    private List<Zp05UltrasoundExam> mUltrasounds = new ArrayList<Zp05UltrasoundExam>();
    private List<Zp06DeliveryAnd6weekVisit> mDeliverys = new ArrayList<Zp06DeliveryAnd6weekVisit>();
    private List<Zp08StudyExit> mExits = new ArrayList<Zp08StudyExit>();
    private List<ZpEstadoEmbarazada> mStatus = new ArrayList<ZpEstadoEmbarazada>();
    private List<ZpControlConsentimientosSalida> mSalidasCons = new ArrayList<ZpControlConsentimientosSalida>();
    private List<ZpControlConsentimientosRecepcion> mRecepcionesCons = new ArrayList<ZpControlConsentimientosRecepcion>();
    private List<ZpControlReporteUSSalida> mSalidasUS = new ArrayList<ZpControlReporteUSSalida>();
    private List<ZpControlReporteUSRecepcion> mRecepcionUS = new ArrayList<ZpControlReporteUSRecepcion>();

    private List<ZpInfantData> mInfantData = new ArrayList<ZpInfantData>();
    private List<ZpEstadoInfante> mEstadoInfante = new ArrayList<ZpEstadoInfante>();
    private List<Zp02dInfantBiospecimenCollection> mInfantCollections = new ArrayList<Zp02dInfantBiospecimenCollection>();
    private List<Zp07InfantAssessmentVisit> mInfantAssessment = new ArrayList<Zp07InfantAssessmentVisit>();

    private String url = null;
    private String username = null;
    private String password = null;
    private String error = null;
    protected UploadListener mStateListener;
    public static final int PRE_TAMIZAJE = 0;
    public static final int TAMIZAJE = 1;
    public static final int INGRESO1 = 2;
    public static final int INGRESO2 = 3;
    public static final int INGRESO3 = 4;
    public static final int MUESTRAS = 5;
    public static final int VISMENSUAL = 6;
    public static final int TRIMESTRE1 = 7;
    public static final int TRIMESTRE2 = 8;
    public static final int TRIMESTRE3 = 9;
    public static final int US = 10;
    public static final int PARTO = 11;
    public static final int SALIDA = 12;
    public static final int ESTADO = 13;
    public static final int CONSSAL = 14;
    public static final int CONSREC = 15;
    public static final int USSAL = 16;
    public static final int USREC = 17;
    public static final int MUESTRAS_INFANTE = 18;
    public static final int EVAL_INFANTE = 19;
    public static final int DAT_INFANTE = 20;
    public static final int ESTADO_INFANTE = 21;


    @Override
    protected String doInBackground(String... values) {
        url = values[0];
        username = values[1];
        password = values[2];

        try {
            publishProgress("Obteniendo registros de la base de datos", "1", "2");
            zikaPosA = new ZikaPosAdapter(mContext, password, false,false);
            zikaPosA.open();
            String filtro = MainDBConstants.STATUS + "='" + Constants.STATUS_NOT_SUBMITTED + "'";
            mPreTamizajes = zikaPosA.getZpPreScreenings(filtro, MainDBConstants.recId);
            mTamizajes = zikaPosA.getZp00Screenings(filtro, MainDBConstants.recordId);
            mIngresosAD = zikaPosA.getZp01StudyEntrySectionAtoDs(filtro, MainDBConstants.recordId);
            mIngresosE = zikaPosA.getZp01StudyEntrySectionEs(filtro, MainDBConstants.recordId);
            mIngresosFK = zikaPosA.getZp01StudyEntrySectionFtoKs(filtro, MainDBConstants.recordId);
            mCollections = zikaPosA.getZp02BiospecimenCollections(filtro, MainDBConstants.recordId);
            mMonthlyVisits = zikaPosA.getZp03MonthlyVisits(filtro, MainDBConstants.recordId);
            mTrimesterVisitAD = zikaPosA.getZp04TrimesterVisitSectionAtoDs(filtro, MainDBConstants.recordId);
            mTrimesterVisitE = zikaPosA.getZp04TrimesterVisitSectionEs(filtro, MainDBConstants.recordId);
            mTrimesterVisitFH = zikaPosA.getZp04TrimesterVisitSectionFtoHs(filtro, MainDBConstants.recordId);
            mUltrasounds = zikaPosA.getZp05UltrasoundExams(filtro, MainDBConstants.recordId);
            mDeliverys = zikaPosA.getZp06DeliveryAnd6weekVisits(filtro, MainDBConstants.recordId);
            mExits = zikaPosA.getZp08StudyExits(filtro, MainDBConstants.recordId);
            mStatus = zikaPosA.getZpEstadoEmbarazadas(filtro, MainDBConstants.recordId);
            mSalidasCons = zikaPosA.getZpControlConsentimientosSalidas(filtro, null);
            mRecepcionesCons = zikaPosA.getZpControlConsentimientosRecepciones(filtro, null);
            mSalidasUS = zikaPosA.getZpControlReporteUSSalidas(filtro, null);
            mRecepcionUS = zikaPosA.getZpControlReporteUSRecepciones(filtro, null);
            mInfantData = zikaPosA.getZpInfantDatas(filtro,null);
            mInfantCollections = zikaPosA.getZp02dInfantBiospecimenCollections(filtro, MainDBConstants.recordId);
            mInfantAssessment = zikaPosA.getZp07InfantAssessmentVisits(filtro, MainDBConstants.recordId);
            mEstadoInfante = zikaPosA.getZpEstadoInfantes(filtro, MainDBConstants.recordId);
            publishProgress("Datos completos!", "2", "2");
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, PRE_TAMIZAJE);
            error = cargarPreTamizajes(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, PRE_TAMIZAJE);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, TAMIZAJE);
            error = cargarTamizajes(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, TAMIZAJE);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, INGRESO1);
            error = uploadEntrysAD(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, INGRESO1);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, INGRESO2);
            error = uploadEntrysZp01E(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, INGRESO2);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, INGRESO3);
            error = uploadEntrysFK(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, INGRESO3);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, MUESTRAS);
            error = upLoadBioCollections(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, MUESTRAS);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, VISMENSUAL);
            error = uploadMonthlyVisits(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, VISMENSUAL);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, TRIMESTRE1);
            error = uploadTrimesterVisitAD(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, TRIMESTRE1);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, TRIMESTRE2);
            error = uploadTrimesterVisitE(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, TRIMESTRE2);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, TRIMESTRE3);
            error = uploadTrimesterVisitFH(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, TRIMESTRE3);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, US);
            error = uploadUltrasoundExams(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, US);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, PARTO);
            error = uploadDeliverys(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, PARTO);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, SALIDA);
            error = uploadExits(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, SALIDA);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, ESTADO);
            error = uploadStatusPreg(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, ESTADO);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, CONSSAL);
            error = uploadControlConsentimientosSalida(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, CONSSAL);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, CONSREC);
            error = uploadControlConsentimientosRecepcion(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, CONSREC);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, USSAL);
            error = uploadControlUSSalida(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, USSAL);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, USREC);
            error = uploadControlReporteUSRecepcion(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, USREC);
                return error;
            }
            /********infante*******/
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, DAT_INFANTE);
            error = uploadInfantData(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, DAT_INFANTE);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, MUESTRAS_INFANTE);
            error = uploadInfantBiospecimenCollection(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, MUESTRAS_INFANTE);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, EVAL_INFANTE);
            error = uploadInfantAssessment(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, EVAL_INFANTE);
                return error;
            }
            actualizarBaseDatos(Constants.STATUS_SUBMITTED, ESTADO_INFANTE);
            error = uploadInfantStatus(url, username, password);
            if (!error.matches("Datos recibidos!")){
                actualizarBaseDatos(Constants.STATUS_NOT_SUBMITTED, ESTADO_INFANTE);
                return error;
            }
            zikaPosA.close();
        } catch (Exception e1) {
            zikaPosA.close();
            e1.printStackTrace();
            return e1.getLocalizedMessage();
        }
        return error;
    }

    private void actualizarBaseDatos(String estado, int opcion) {
        int c;
        if(opcion==PRE_TAMIZAJE){
            c = mPreTamizajes.size();
            if(c>0){
                for (ZpPreScreening pretamizaje : mPreTamizajes) {
                    pretamizaje.setEstado(estado);
                    zikaPosA.editarZpPreScreening(pretamizaje);
                    publishProgress("Actualizando pre-tamizajes base de datos local", Integer.valueOf(mPreTamizajes.indexOf(pretamizaje)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==TAMIZAJE){
            c = mTamizajes.size();
            if(c>0){
                for (Zp00Screening tamizaje : mTamizajes) {
                    tamizaje.setEstado(estado);
                    zikaPosA.editarZp00Screening(tamizaje);
                    publishProgress("Actualizando tamizajes base de datos local", Integer.valueOf(mTamizajes.indexOf(tamizaje)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==INGRESO1){
            c = mIngresosAD.size();
            if(c>0){
                for (Zp01StudyEntrySectionAtoD ingreso : mIngresosAD) {
                    ingreso.setEstado(estado);
                    zikaPosA.editarZp01StudyEntrySectionAtoD(ingreso);
                    publishProgress("Actualizando datos de ingreso (A-D) base de datos local", Integer.valueOf(mIngresosAD.indexOf(ingreso)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==INGRESO2){
            c = mIngresosE.size();
            if(c>0){
                for (Zp01StudyEntrySectionE ingreso : mIngresosE) {
                    ingreso.setEstado(estado);
                    zikaPosA.editarZp01StudyEntrySectionE(ingreso);
                    publishProgress("Actualizando datos de ingreso (E) base de datos local", Integer.valueOf(mIngresosE.indexOf(ingreso)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==INGRESO3){
            c = mIngresosFK.size();
            if(c>0){
                for (Zp01StudyEntrySectionFtoK ingreso : mIngresosFK) {
                    ingreso.setEstado(estado);
                    zikaPosA.editarZp01StudyEntrySectionFtoK(ingreso);
                    publishProgress("Actualizando datos de ingreso (F-K) base de datos local", Integer.valueOf(mIngresosFK.indexOf(ingreso)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==MUESTRAS){
            c = mCollections.size();
            if(c>0){
                for (Zp02BiospecimenCollection collection : mCollections) {
                    collection.setEstado(estado);
                    zikaPosA.editarZp02BiospecimenCollection(collection);
                    publishProgress("Actualizando recoleccion de muestras base de datos local", Integer.valueOf(mCollections.indexOf(collection)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==VISMENSUAL){
            c = mMonthlyVisits.size();
            if(c>0){
                for (Zp03MonthlyVisit monthlyVisit : mMonthlyVisits) {
                    monthlyVisit.setEstado(estado);
                    zikaPosA.editarZp03MonthlyVisit(monthlyVisit);
                    publishProgress("Actualizando visita mensual base de datos local", Integer.valueOf(mMonthlyVisits.indexOf(monthlyVisit)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==TRIMESTRE1){
            c = mTrimesterVisitAD.size();
            if(c>0){
                for (Zp04TrimesterVisitSectionAtoD trimesterVisitAD : mTrimesterVisitAD) {
                    trimesterVisitAD.setEstado(estado);
                    zikaPosA.editarZp04TrimesterVisitSectionAtoD(trimesterVisitAD);
                    publishProgress("Actualizando Visita Trimestral (A-D) base de datos local", Integer.valueOf(mTrimesterVisitAD.indexOf(trimesterVisitAD)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==TRIMESTRE2){
            c = mTrimesterVisitE.size();
            if(c>0){
                for (Zp04TrimesterVisitSectionE trimesterVisitE : mTrimesterVisitE) {
                    trimesterVisitE.setEstado(estado);
                    zikaPosA.editarZp04TrimesterVisitSectionE(trimesterVisitE);
                    publishProgress("Actualizando Visita Trimestral (E) base de datos local", Integer.valueOf(mTrimesterVisitE.indexOf(trimesterVisitE)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==TRIMESTRE3){
            c = mTrimesterVisitFH.size();
            if(c>0){
                for (Zp04TrimesterVisitSectionFtoH trimesterVisitFH : mTrimesterVisitFH) {
                    trimesterVisitFH.setEstado(estado);
                    zikaPosA.editarZp04TrimesterVisitSectionFtoH(trimesterVisitFH);
                    publishProgress("Actualizando Visita Trimestral (F-H) base de datos local", Integer.valueOf(mTrimesterVisitFH.indexOf(trimesterVisitFH)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==US){
            c = mUltrasounds.size();
            if(c>0){
                for (Zp05UltrasoundExam ultrasoundExam : mUltrasounds) {
                    ultrasoundExam.setEstado(estado);
                    zikaPosA.editarZp05UltrasoundExam(ultrasoundExam);
                    publishProgress("Actualizando ultrasonidos base de datos local", Integer.valueOf(mUltrasounds.indexOf(ultrasoundExam)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==PARTO){
            c = mDeliverys.size();
            if(c>0){
                for (Zp06DeliveryAnd6weekVisit deliveryAnd6weekVisit : mDeliverys) {
                    deliveryAnd6weekVisit.setEstado(estado);
                    zikaPosA.editarZp06DeliveryAnd6weekVisit(deliveryAnd6weekVisit);
                    publishProgress("Actualizando partos base de datos local", Integer.valueOf(mDeliverys.indexOf(deliveryAnd6weekVisit)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==SALIDA){
            c = mExits.size();
            if(c>0){
                for (Zp08StudyExit studyExit : mExits) {
                    studyExit.setEstado(estado);
                    zikaPosA.editarZp08StudyExit(studyExit);
                    publishProgress("Actualizando salidas del estudio base de datos local", Integer.valueOf(mExits.indexOf(studyExit)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==ESTADO){
            c = mStatus.size();
            if(c>0){
                for (ZpEstadoEmbarazada estadoEmbarazada : mStatus) {
                    estadoEmbarazada.setEstado(estado);
                    zikaPosA.editarZpEstadoEmbarazada(estadoEmbarazada);
                    publishProgress("Actualizando estado de embarazadas base de datos local", Integer.valueOf(mStatus.indexOf(estadoEmbarazada)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==CONSSAL){
            c = mSalidasCons.size();
            if(c>0){
                for (ZpControlConsentimientosSalida salidaCons : mSalidasCons) {
                    salidaCons.setEstado(estado);
                    zikaPosA.editarZpControlConsentimientosSalida(salidaCons);
                    publishProgress("Actualizando salidas de consentimientos base de datos local", Integer.valueOf(mSalidasCons.indexOf(salidaCons)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==CONSREC){
            c = mRecepcionesCons.size();
            if(c>0){
                for (ZpControlConsentimientosRecepcion recepcionCons : mRecepcionesCons) {
                    recepcionCons.setEstado(estado);
                    zikaPosA.editarZpControlConsentimientosRecepcion(recepcionCons);
                    publishProgress("Actualizando recepciones de consentimientos base de datos local", Integer.valueOf(mRecepcionesCons.indexOf(recepcionCons)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==USSAL){
            c = mSalidasUS.size();
            if(c>0){
                for (ZpControlReporteUSSalida salidaUs : mSalidasUS) {
                    salidaUs.setEstado(estado);
                    zikaPosA.editarZpControlReporteUSSalida(salidaUs);
                    publishProgress("Actualizando salidas de us base de datos local", Integer.valueOf(mSalidasUS.indexOf(salidaUs)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==USREC){
            c = mRecepcionUS.size();
            if(c>0){
                for (ZpControlReporteUSRecepcion recepcionUs : mRecepcionUS) {
                    recepcionUs.setEstado(estado);
                    zikaPosA.editarZpControlReporteUSRecepcion(recepcionUs);
                    publishProgress("Actualizando recepciones de us base de datos local", Integer.valueOf(mRecepcionUS.indexOf(recepcionUs)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        } 
        /***************INFANTES***********/
        else if(opcion==MUESTRAS_INFANTE){
            c = mInfantCollections.size();
            if(c>0){
                for (Zp02dInfantBiospecimenCollection biospecimenCollection : mInfantCollections) {
                    biospecimenCollection.setEstado(estado);
                    zikaPosA.editarZp02dInfantBiospecimenCollection(biospecimenCollection);
                    publishProgress("Actualizando muestras de infantes base de datos local", Integer.valueOf(mInfantCollections.indexOf(biospecimenCollection)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==EVAL_INFANTE){
            c = mInfantAssessment.size();
            if(c>0){
                for (Zp07InfantAssessmentVisit infantAssessmentVisit : mInfantAssessment) {
                    infantAssessmentVisit.setEstado(estado);
                    zikaPosA.editarZp07InfantAssessmentVisit(infantAssessmentVisit);
                    publishProgress("Actualizando evaluaciones de infantes base de datos local", Integer.valueOf(mInfantAssessment.indexOf(infantAssessmentVisit)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==DAT_INFANTE){
            c = mInfantData.size();
            if(c>0){
                for (ZpInfantData infantData : mInfantData) {
                    infantData.setEstado(estado);
                    zikaPosA.editarZpInfantData(infantData);
                    publishProgress("Actualizando datos de infantes base de datos local", Integer.valueOf(mInfantData.indexOf(infantData)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        else if(opcion==ESTADO_INFANTE){
            c = mEstadoInfante.size();
            if(c>0){
                for (ZpEstadoInfante infantEstado : mEstadoInfante) {
                    infantEstado.setEstado(estado);
                    zikaPosA.editarZpEstadoInfante(infantEstado);
                    publishProgress("Actualizando estado de infantes base de datos local", Integer.valueOf(mInfantData.indexOf(infantEstado)).toString(), Integer
                            .valueOf(c).toString());
                }
            }
        }
        
    }


    /***************************************************/
    /********************* ZpPretamizajes ************************/
    /***************************************************/
    // url, username, password
    protected String cargarPreTamizajes(String url, String username,
                                        String password) throws Exception {
        try {
            if(mPreTamizajes.size()>0){
                // La URL de la solicitud POST
                publishProgress("Enviando pre-tamizajes!", "1", TOTAL_TASK);
                final String urlRequest = url + "/movil/zpPreScreening";
                ZpPreScreening[] envio = mPreTamizajes.toArray(new ZpPreScreening[mPreTamizajes.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpPreScreening[]> requestEntity =
                        new HttpEntity<ZpPreScreening[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp00Tamizajes ************************/
    /***************************************************/
    // url, username, password
    protected String cargarTamizajes(String url, String username,
                                     String password) throws Exception {
        try {
            if(mTamizajes.size()>0){
                publishProgress("Enviando tamizajes!", "2", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp00Screenings";
                Zp00Screening[] envio = mTamizajes.toArray(new Zp00Screening[mTamizajes.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp00Screening[]> requestEntity =
                        new HttpEntity<Zp00Screening[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /*************** Zp01 AtoD ************************/
    /***************************************************/
    // url, username, password
    protected String uploadEntrysAD(String url, String username,
                                    String password) throws Exception {
        try {
            if(mIngresosAD.size()>0){
                publishProgress("Enviando ingresos (1)!", "3", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp01StudyEntrySectionAtoDs";
                Zp01StudyEntrySectionAtoD[] envio = mIngresosAD.toArray(new Zp01StudyEntrySectionAtoD[mIngresosAD.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp01StudyEntrySectionAtoD[]> requestEntity =
                        new HttpEntity<Zp01StudyEntrySectionAtoD[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /*************** Zp01 E ************************/
    /***************************************************/
    // url, username, password
    protected String uploadEntrysZp01E(String url, String username,
                                       String password) throws Exception {
        try {
            if(mIngresosE.size()>0){
                publishProgress("Enviando ingresos (2)!", "4", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp01StudyEntrySectionEs";
                Zp01StudyEntrySectionE[] envio = mIngresosE.toArray(new Zp01StudyEntrySectionE[mIngresosE.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp01StudyEntrySectionE[]> requestEntity =
                        new HttpEntity<Zp01StudyEntrySectionE[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /*************** Zp01 FtoK ************************/
    /***************************************************/
    // url, username, password
    protected String uploadEntrysFK(String url, String username,
                                    String password) throws Exception {
        try {
            if(mIngresosFK.size()>0){
                publishProgress("Enviando ingresos (3)!", "5", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp01StudyEntrySectionFtoKs";
                Zp01StudyEntrySectionFtoK[] envio = mIngresosFK.toArray(new Zp01StudyEntrySectionFtoK[mIngresosFK.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp01StudyEntrySectionFtoK[]> requestEntity =
                        new HttpEntity<Zp01StudyEntrySectionFtoK[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp02 ************************/
    /***************************************************/
    // url, username, password
    protected String upLoadBioCollections(String url, String username,
                                          String password) throws Exception {
        try {
            if(mCollections.size()>0){
                publishProgress("Enviando muestras!", "6", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp02BiospecimenCollections";
                Zp02BiospecimenCollection[] envio = mCollections.toArray(new Zp02BiospecimenCollection[mCollections.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp02BiospecimenCollection[]> requestEntity =
                        new HttpEntity<Zp02BiospecimenCollection[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp03 ************************/
    /***************************************************/
    // url, username, password
    protected String uploadMonthlyVisits(String url, String username,
                                         String password) throws Exception {
        try {
            if(mMonthlyVisits.size()>0){
                publishProgress("Enviando visitas mensuales!", "7", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp03MonthlyVisits";
                Zp03MonthlyVisit[] envio = mMonthlyVisits.toArray(new Zp03MonthlyVisit[mMonthlyVisits.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp03MonthlyVisit[]> requestEntity =
                        new HttpEntity<Zp03MonthlyVisit[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp04 AtoD ************************/
    /***************************************************/
    // url, username, password
    protected String uploadTrimesterVisitAD(String url, String username,
                                            String password) throws Exception {
        try {
            if(mTrimesterVisitAD.size()>0){
                publishProgress("Enviando visitas trimestrales (1)!", "8", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp04TrimesterVisitSectionAtoDs";
                Zp04TrimesterVisitSectionAtoD[] envio = mTrimesterVisitAD.toArray(new Zp04TrimesterVisitSectionAtoD[mTrimesterVisitAD.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp04TrimesterVisitSectionAtoD[]> requestEntity =
                        new HttpEntity<Zp04TrimesterVisitSectionAtoD[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp04 E ************************/
    /***************************************************/
    // url, username, password
    protected String uploadTrimesterVisitE(String url, String username,
                                           String password) throws Exception {
        try {
            if(mTrimesterVisitE.size()>0){
                publishProgress("Enviando visitas trimestrales (2)!", "9", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp04TrimesterVisitSectionEs";
                Zp04TrimesterVisitSectionE[] envio = mTrimesterVisitE.toArray(new Zp04TrimesterVisitSectionE[mTrimesterVisitE.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp04TrimesterVisitSectionE[]> requestEntity =
                        new HttpEntity<Zp04TrimesterVisitSectionE[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp04 FtoH ************************/
    /***************************************************/
    // url, username, password
    protected String uploadTrimesterVisitFH(String url, String username,
                                            String password) throws Exception {
        try {
            if(mTrimesterVisitFH.size()>0){
                publishProgress("Enviando visitas trimestrales (3)!", "10", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp04TrimesterVisitSectionFtoHs";
                Zp04TrimesterVisitSectionFtoH[] envio = mTrimesterVisitFH.toArray(new Zp04TrimesterVisitSectionFtoH[mTrimesterVisitFH.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp04TrimesterVisitSectionFtoH[]> requestEntity =
                        new HttpEntity<Zp04TrimesterVisitSectionFtoH[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp05 ************************/
    /***************************************************/
    // url, username, password
    protected String uploadUltrasoundExams(String url, String username,
                                           String password) throws Exception {
        try {
            if(mUltrasounds.size()>0){
                publishProgress("Enviando ultrasonidos!", "11", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp05UltrasoundExams";
                Zp05UltrasoundExam[] envio = mUltrasounds.toArray(new Zp05UltrasoundExam[mUltrasounds.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp05UltrasoundExam[]> requestEntity =
                        new HttpEntity<Zp05UltrasoundExam[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp06 ************************/
    /***************************************************/
    // url, username, password
    protected String uploadDeliverys(String url, String username,
                                     String password) throws Exception {
        try {
            if(mDeliverys.size()>0){
                publishProgress("Enviando partos!", "12", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp06DeliveryAnd6weekVisits";
                Zp06DeliveryAnd6weekVisit[] envio = mDeliverys.toArray(new Zp06DeliveryAnd6weekVisit[mDeliverys.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp06DeliveryAnd6weekVisit[]> requestEntity =
                        new HttpEntity<Zp06DeliveryAnd6weekVisit[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp08 ************************/
    /***************************************************/
    // url, username, password
    protected String uploadExits(String url, String username,
                                 String password) throws Exception {
        try {
            if(mExits.size()>0){
                publishProgress("Enviando salidas!", "13", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp08StudyExits";
                Zp08StudyExit[] envio = mExits.toArray(new Zp08StudyExit[mExits.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp08StudyExit[]> requestEntity =
                        new HttpEntity<Zp08StudyExit[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* ZpEstadosEmbarazadas ************************/
    /***************************************************/
    // url, username, password
    protected String uploadStatusPreg(String url, String username,
                                      String password) throws Exception {
        try {
            if(mStatus.size()>0){
                publishProgress("Enviando estado embarazadas!", "14", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zpEstadoEmb";
                ZpEstadoEmbarazada[] envio = mStatus.toArray(new ZpEstadoEmbarazada[mStatus.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpEstadoEmbarazada[]> requestEntity =
                        new HttpEntity<ZpEstadoEmbarazada[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }


    /***************************************************/
    /********************* ZpControlConsentimientosSalida******/
    /***************************************************/
    // url, username, password
    protected String uploadControlConsentimientosSalida(String url, String username,
                                                        String password) throws Exception {
        try {
            if(mSalidasCons.size()>0){
                publishProgress("Enviando salidas de consentimientos!", "15", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zpSalidaCons";
                ZpControlConsentimientosSalida[] envio = mSalidasCons.toArray(new ZpControlConsentimientosSalida[mSalidasCons.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpControlConsentimientosSalida[]> requestEntity =
                        new HttpEntity<ZpControlConsentimientosSalida[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* ZpControlConsentimientosRecepcion******/
    /***************************************************/
    // url, username, password
    protected String uploadControlConsentimientosRecepcion(String url, String username,
                                                           String password) throws Exception {
        try {
            if(mRecepcionesCons.size()>0){
                publishProgress("Enviando recepciones de consentimientos!", "16", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zpRecepcionCons";
                ZpControlConsentimientosRecepcion[] envio = mRecepcionesCons.toArray(new ZpControlConsentimientosRecepcion[mRecepcionesCons.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpControlConsentimientosRecepcion[]> requestEntity =
                        new HttpEntity<ZpControlConsentimientosRecepcion[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* ZpControlReporteUSSalida******/
    /***************************************************/
    // url, username, password
    protected String uploadControlUSSalida(String url, String username,
                                           String password) throws Exception {
        try {
            if(mSalidasUS.size()>0){
                publishProgress("Enviando salidas de us!", "17", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zpSalidaUS";
                ZpControlReporteUSSalida[] envio = mSalidasUS.toArray(new ZpControlReporteUSSalida[mSalidasUS.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpControlReporteUSSalida[]> requestEntity =
                        new HttpEntity<ZpControlReporteUSSalida[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* ZpControlReporteUSRecepcion******/
    /***************************************************/
    // url, username, password
    protected String uploadControlReporteUSRecepcion(String url, String username,
                                                     String password) throws Exception {
        try {
            if(mRecepcionUS.size()>0){
                publishProgress("Enviando recepciones de us!", "18", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zpRecepcionUS";
                ZpControlReporteUSRecepcion[] envio = mRecepcionUS.toArray(new ZpControlReporteUSRecepcion[mRecepcionUS.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpControlReporteUSRecepcion[]> requestEntity =
                        new HttpEntity<ZpControlReporteUSRecepcion[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /*******INFANTES*********/

    /***************************************************/
    /********************* ZpInfantData******/
    /***************************************************/
    // url, username, password
    protected String uploadInfantData(String url, String username,
                                      String password) throws Exception {
        try {
            if(mInfantData.size()>0){
                publishProgress("Enviando datos de infantes!", "19", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zpInfants";
                ZpInfantData[] envio = mInfantData.toArray(new ZpInfantData[mInfantData.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpInfantData[]> requestEntity =
                        new HttpEntity<ZpInfantData[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp02dInfantBiospecimenCollection******/
    /***************************************************/
    // url, username, password
    protected String uploadInfantBiospecimenCollection(String url, String username,
                                                     String password) throws Exception {
        try {
            if(mRecepcionUS.size()>0){
                publishProgress("Enviando muestras de infantes!", "20", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp02dInfantBiospecimenCollections";
                Zp02dInfantBiospecimenCollection[] envio = mInfantCollections.toArray(new Zp02dInfantBiospecimenCollection[mInfantCollections.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp02dInfantBiospecimenCollection[]> requestEntity =
                        new HttpEntity<Zp02dInfantBiospecimenCollection[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }

    /***************************************************/
    /********************* Zp07InfantAssessmentVisit******/
    /***************************************************/
    // url, username, password
    protected String uploadInfantAssessment(String url, String username,
                                                       String password) throws Exception {
        try {
            if(mInfantAssessment.size()>0){
                publishProgress("Enviando evaluaciones de infantes!", "21", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zp07InfantAssessmentVisits";
                Zp07InfantAssessmentVisit[] envio = mInfantAssessment.toArray(new Zp07InfantAssessmentVisit[mInfantAssessment.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<Zp07InfantAssessmentVisit[]> requestEntity =
                        new HttpEntity<Zp07InfantAssessmentVisit[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }
    
    /***************************************************/
    /********************* ZpEstadoInfante******/
    /***************************************************/
    // url, username, password
    protected String uploadInfantStatus(String url, String username,
                                      String password) throws Exception {
        try {
            if(mEstadoInfante.size()>0){
                publishProgress("Enviando datos de estado de infantes!", "22", TOTAL_TASK);
                // La URL de la solicitud POST
                final String urlRequest = url + "/movil/zpEstadoInfantes";
                ZpEstadoInfante[] envio = mEstadoInfante.toArray(new ZpEstadoInfante[mEstadoInfante.size()]);
                HttpHeaders requestHeaders = new HttpHeaders();
                HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                requestHeaders.setAuthorization(authHeader);
                HttpEntity<ZpEstadoInfante[]> requestEntity =
                        new HttpEntity<ZpEstadoInfante[]>(envio, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                // Hace la solicitud a la red, pone la vivienda y espera un mensaje de respuesta del servidor
                ResponseEntity<String> response = restTemplate.exchange(urlRequest, HttpMethod.POST, requestEntity,
                        String.class);
                return response.getBody();
            }
            else{
                return "Datos recibidos!";
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getMessage();
        }
    }    
}