package ni.org.ics.zikapositivas.appmovil.tasks.downloads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import ni.org.ics.zikapositivas.appmovil.database.ZikaPosAdapter;
import ni.org.ics.zikapositivas.appmovil.domain.*;
import ni.org.ics.zikapositivas.appmovil.tasks.DownloadTask;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.content.Context;
import android.util.Log;



public class DownloadAllTask extends DownloadTask {

    private final Context mContext;

    public DownloadAllTask(Context context) {
        mContext = context;
    }

    protected static final String TAG = DownloadAllTask.class.getSimpleName();
    private ZikaPosAdapter zikaPosA = null;
    private List<ZpPreScreening> mPreTamizajes = null;
    private List<Zp00Screening> mTamizajes = null;
    private List<Zp01StudyEntrySectionAtoD> mIngresosAD = null;
    private List<Zp01StudyEntrySectionE> mIngresosE = null;
    private List<Zp01StudyEntrySectionFtoK> mIngresosFK = null;
    private List<Zp02BiospecimenCollection> mCollections = null;
    private List<Zp03MonthlyVisit> mMonthlyVisits = null;
    private List<Zp04TrimesterVisitSectionAtoD> mTrimesterVisitAD = null;
    private List<Zp04TrimesterVisitSectionE> mTrimesterVisitE = null;
    private List<Zp04TrimesterVisitSectionFtoH> mTrimesterVisitFH = null;
    private List<Zp05UltrasoundExam> mUltrasounds = null;
    private List<Zp06DeliveryAnd6weekVisit> mDeliverys = null;
    private List<Zp08StudyExit> mExits = null;
    private List<ZpEstadoEmbarazada> mStatus = null;
    
    private List<ZpControlConsentimientosSalida> mZpControlConsentimientosSalida = null;
    private List<ZpControlConsentimientosRecepcion> mZpControlConsentimientosRecepcion = null;
    private List<ZpControlReporteUSSalida> mZpControlReporteUSSalida = null;
    private List<ZpControlReporteUSRecepcion> mZpControlReporteUSRecepcion = null;
    
    private List<Zp02dInfantBiospecimenCollection> mInfantCollections = null;
    private List<Zp07InfantAssessmentVisit> mInfantAssessment = null;

    private String error = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private int v =0;

    @Override
    protected String doInBackground(String... values) {
        url = values[0];
        username = values[1];
        password = values[2];

        try {
            error = descargarDatos();
            if (error!=null) return error;
        } catch (Exception e) {
            // Regresa error al descargar
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
        publishProgress("Abriendo base de datos...","1","1");
        zikaPosA = new ZikaPosAdapter(mContext, password, false,false);
        zikaPosA.open();
        //Borrar los datos de la base de datos
        zikaPosA.borrarZpPreScreening();
        zikaPosA.borrarZp00Screening();
        zikaPosA.borrarZp01StudyEntrySectionAtoD();
        zikaPosA.borrarZp01StudyEntrySectionE();
        zikaPosA.borrarZp01StudyEntrySectionFtoK();
        zikaPosA.borrarZp02BiospecimenCollection();
        zikaPosA.borrarZp03MonthlyVisit();
        zikaPosA.borrarZp04TrimesterVisitSectionAtoD();
        zikaPosA.borrarZp04TrimesterVisitSectionE();
        zikaPosA.borrarZp04TrimesterVisitSectionFtoH();
        zikaPosA.borrarZp05UltrasoundExam();
        zikaPosA.borrarZp06DeliveryAnd6weekVisit();
        zikaPosA.borrarZp08StudyExit();
        zikaPosA.borrarZpEstadoEmbarazada();
        zikaPosA.borrarZpControlConsentimientosSalida();
        zikaPosA.borrarZpControlConsentimientosRecepcion();
        zikaPosA.borrarZpControlReporteUSSalida();
        zikaPosA.borrarZpControlReporteUSRecepcion();
        zikaPosA.borrarZp02dInfantBiospecimenCollection();
        zikaPosA.borrarZp07InfantAssessmentVisit();
        try {
            if (mPreTamizajes != null){
                v = mPreTamizajes.size();
                ListIterator<ZpPreScreening> iter = mPreTamizajes.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZpPreScreening(iter.next());
                    publishProgress("Insertando pre tamizajes en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mTamizajes != null){
                v = mTamizajes.size();
                ListIterator<Zp00Screening> iter = mTamizajes.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp00Screening(iter.next());
                    publishProgress("Insertando tamizajes en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mIngresosAD != null){
                v = mIngresosAD.size();
                ListIterator<Zp01StudyEntrySectionAtoD> iter = mIngresosAD.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp01StudyEntrySectionAtoD(iter.next());
                    publishProgress("Insertando ingresos(1) en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mIngresosE != null){
                v = mIngresosE.size();
                ListIterator<Zp01StudyEntrySectionE> iter = mIngresosE.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp01StudyEntrySectionE(iter.next());
                    publishProgress("Insertando ingresos(2) en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mIngresosFK != null){
                v = mIngresosFK.size();
                ListIterator<Zp01StudyEntrySectionFtoK> iter = mIngresosFK.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp01StudyEntrySectionFtoK(iter.next());
                    publishProgress("Insertando ingresos(3) en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mCollections != null){
                v = mCollections.size();
                ListIterator<Zp02BiospecimenCollection> iter = mCollections.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp02BiospecimenCollection(iter.next());
                    publishProgress("Insertando muestras en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mMonthlyVisits != null){
                v = mMonthlyVisits.size();
                ListIterator<Zp03MonthlyVisit> iter = mMonthlyVisits.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp03MonthlyVisit(iter.next());
                    publishProgress("Insertando visitas mensuales en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mTrimesterVisitAD != null){
                v = mTrimesterVisitAD.size();
                ListIterator<Zp04TrimesterVisitSectionAtoD> iter = mTrimesterVisitAD.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp04TrimesterVisitSectionAtoD(iter.next());
                    publishProgress("Insertando visitas trimestrales(1) en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mTrimesterVisitE != null){
                v = mTrimesterVisitE.size();
                ListIterator<Zp04TrimesterVisitSectionE> iter = mTrimesterVisitE.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp04TrimesterVisitSectionE(iter.next());
                    publishProgress("Insertando visitas trimestrales(2) en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mTrimesterVisitFH != null){
                v = mTrimesterVisitFH.size();
                ListIterator<Zp04TrimesterVisitSectionFtoH> iter = mTrimesterVisitFH.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp04TrimesterVisitSectionFtoH(iter.next());
                    publishProgress("Insertando visitas trimestrales(3) en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mUltrasounds != null){
                v = mUltrasounds.size();
                ListIterator<Zp05UltrasoundExam> iter = mUltrasounds.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp05UltrasoundExam(iter.next());
                    publishProgress("Insertando ultrasonidos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mDeliverys != null){
                v = mDeliverys.size();
                ListIterator<Zp06DeliveryAnd6weekVisit> iter = mDeliverys.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp06DeliveryAnd6weekVisit(iter.next());
                    publishProgress("Insertando partos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mExits != null){
                v = mExits.size();
                ListIterator<Zp08StudyExit> iter = mExits.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp08StudyExit(iter.next());
                    publishProgress("Insertando salidas del estudio en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mStatus != null){
                v = mStatus.size();
                ListIterator<ZpEstadoEmbarazada> iter = mStatus.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZpEstadoEmbarazada(iter.next());
                    publishProgress("Insertando estado de embarazadas en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mZpControlConsentimientosSalida != null){
                v = mZpControlConsentimientosSalida.size();
                ListIterator<ZpControlConsentimientosSalida> iter = mZpControlConsentimientosSalida.listIterator();
                while (iter.hasNext()){
                	zikaPosA.crearZpControlConsentimientosSalida(iter.next());
                    publishProgress("Insertando salidas de consentimientos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mZpControlConsentimientosRecepcion != null){
                v = mZpControlConsentimientosRecepcion.size();
                ListIterator<ZpControlConsentimientosRecepcion> iter = mZpControlConsentimientosRecepcion.listIterator();
                while (iter.hasNext()){
                	zikaPosA.crearZpControlConsentimientosRecepcion(iter.next());
                    publishProgress("Insertando recepcion de consentimientos en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mZpControlReporteUSSalida != null){
                v = mZpControlReporteUSSalida.size();
                ListIterator<ZpControlReporteUSSalida> iter = mZpControlReporteUSSalida.listIterator();
                while (iter.hasNext()){
                	zikaPosA.crearZpControlReporteUSSalida(iter.next());
                    publishProgress("Insertando salida de us en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mZpControlReporteUSRecepcion != null){
                v = mZpControlReporteUSRecepcion.size();
                ListIterator<ZpControlReporteUSRecepcion> iter = mZpControlReporteUSRecepcion.listIterator();
                while (iter.hasNext()){
                	zikaPosA.crearZpControlReporteUSRecepcion(iter.next());
                    publishProgress("Insertando recepcion de us en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            /**************INFANTES*****/
            if (mInfantCollections != null){
                v = mInfantCollections.size();
                ListIterator<Zp02dInfantBiospecimenCollection> iter = mInfantCollections.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp02dInfantBiospecimenCollection(iter.next());
                    publishProgress("Insertando muestras de infantes en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }
            if (mInfantAssessment != null){
                v = mInfantAssessment.size();
                ListIterator<Zp07InfantAssessmentVisit> iter = mInfantAssessment.listIterator();
                while (iter.hasNext()){
                    zikaPosA.crearZp07InfantAssessmentVisit(iter.next());
                    publishProgress("Insertando evaluaciones de infantes en la base de datos...", Integer.valueOf(iter.nextIndex()).toString(), Integer
                            .valueOf(v).toString());
                }
            }

        } catch (Exception e) {
            // Regresa error al insertar
            e.printStackTrace();
            zikaPosA.close();
            return e.getLocalizedMessage();
        }
        zikaPosA.close();
        return error;
    }

    // url, username, password
    protected String descargarDatos() throws Exception {
        try {
            // The URL for making the GET request
            String urlRequest;
            // Set the Accept header for "application/json"
            HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
            HttpHeaders requestHeaders = new HttpHeaders();
            List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
            acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
            requestHeaders.setAccept(acceptableMediaTypes);
            requestHeaders.setAuthorization(authHeader);
            // Populate the headers in an HttpEntity object to use for the request
            HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
            // Create a new RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            //Descargar pretamizajes
            urlRequest = url + "/movil/zpPreScreening/{username}";
            publishProgress("Solicitando pretamizajes","1","20");
            // Perform the HTTP GET request
            ResponseEntity<ZpPreScreening[]> responseEntityZpPreScreening = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    ZpPreScreening[].class, username);
            // convert the array to a list and return it
            mPreTamizajes = Arrays.asList(responseEntityZpPreScreening.getBody());
            //Descargar tamizajes
            urlRequest = url + "/movil/zp00Screenings/{username}";
            publishProgress("Solicitando tamizajes","2","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp00Screening[]> responseEntityZp00Screening = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp00Screening[].class, username);
            // convert the array to a list and return it
            mTamizajes = Arrays.asList(responseEntityZp00Screening.getBody());
            //Descargar ingresos parte 1
            urlRequest = url + "/movil/zp01StudyEntrySectionAtoDs/{username}";
            publishProgress("Solicitando ingresos (1)","3","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp01StudyEntrySectionAtoD[]> responseEntityZp01StudyEntrySectionAtoD = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp01StudyEntrySectionAtoD[].class, username);
            // convert the array to a list and return it
            mIngresosAD = Arrays.asList(responseEntityZp01StudyEntrySectionAtoD.getBody());
            //Descargar ingresos parte 2
            urlRequest = url + "/movil/zp01StudyEntrySectionEs/{username}";
            publishProgress("Solicitando ingresos (2)","4","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp01StudyEntrySectionE[]> responseEntityZp01StudyEntrySectionE = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp01StudyEntrySectionE[].class, username);
            // convert the array to a list and return it
            mIngresosE = Arrays.asList(responseEntityZp01StudyEntrySectionE.getBody());
            //Descargar ingresos parte 3
            urlRequest = url + "/movil/zp01StudyEntrySectionFtoKs/{username}";
            publishProgress("Solicitando ingresos (3)","5","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp01StudyEntrySectionFtoK[]> responseZp01StudyEntrySectionFtoK = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp01StudyEntrySectionFtoK[].class, username);
            // convert the array to a list and return it
            mIngresosFK = Arrays.asList(responseZp01StudyEntrySectionFtoK.getBody());
            //Descargar muestras
            urlRequest = url + "/movil/zp02BiospecimenCollections/{username}";
            publishProgress("Solicitando muestras","6","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp02BiospecimenCollection[]> responseZp02BiospecimenCollection = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp02BiospecimenCollection[].class, username);
            // convert the array to a list and return it
            mCollections = Arrays.asList(responseZp02BiospecimenCollection.getBody());
            //Descargar visitas mensuales
            urlRequest = url + "/movil/zp03MonthlyVisits/{username}";
            publishProgress("Solicitando visitas mensuales","7","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp03MonthlyVisit[]> responseZp03MonthlyVisit = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp03MonthlyVisit[].class, username);
            // convert the array to a list and return it
            mMonthlyVisits = Arrays.asList(responseZp03MonthlyVisit.getBody());
            //Descargar visitas trimestrales parte 1
            urlRequest = url + "/movil/zp04TrimesterVisitSectionAtoDs/{username}";
            publishProgress("Solicitando visitas trimestrales (1)","8","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp04TrimesterVisitSectionAtoD[]> responseZp04TrimesterVisitSectionAtoD = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp04TrimesterVisitSectionAtoD[].class, username);
            // convert the array to a list and return it
            mTrimesterVisitAD = Arrays.asList(responseZp04TrimesterVisitSectionAtoD.getBody());
            //Descargar visitas trimestrales parte 2
            urlRequest = url + "/movil/zp04TrimesterVisitSectionEs/{username}";
            publishProgress("Solicitando visitas trimestrales (2)","9","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp04TrimesterVisitSectionE[]> responseZp04TrimesterVisitSectionE = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp04TrimesterVisitSectionE[].class, username);
            // convert the array to a list and return it
            mTrimesterVisitE = Arrays.asList(responseZp04TrimesterVisitSectionE.getBody());
            //Descargar visitas trimestrales parte 3
            urlRequest = url + "/movil/zp04TrimesterVisitSectionFtoHs/{username}";
            publishProgress("Solicitando visitas trimestrales (3)","10","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp04TrimesterVisitSectionFtoH[]> responseZp04TrimesterVisitSectionFtoH = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp04TrimesterVisitSectionFtoH[].class, username);
            // convert the array to a list and return it
            mTrimesterVisitFH = Arrays.asList(responseZp04TrimesterVisitSectionFtoH.getBody());
            //Descargar ultrasonidos
            urlRequest = url + "/movil/zp05UltrasoundExams/{username}";
            publishProgress("Solicitando ultrasonidos","11","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp05UltrasoundExam[]> responseZp05UltrasoundExam = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp05UltrasoundExam[].class, username);
            // convert the array to a list and return it
            mUltrasounds = Arrays.asList(responseZp05UltrasoundExam.getBody());
            //Descargar partos
            urlRequest = url + "/movil/zp06DeliveryAnd6weekVisits/{username}";
            publishProgress("Solicitando partos","12","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp06DeliveryAnd6weekVisit[]> responseZp06DeliveryAnd6weekVisit = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp06DeliveryAnd6weekVisit[].class, username);
            // convert the array to a list and return it
            mDeliverys = Arrays.asList(responseZp06DeliveryAnd6weekVisit.getBody());
            //Descargar salidas del estudio
            urlRequest = url + "/movil/zp08StudyExits/{username}";
            publishProgress("Solicitando salidas del estudio","13","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp08StudyExit[]> responseZp08StudyExit = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp08StudyExit[].class, username);
            // convert the array to a list and return it
            mExits = Arrays.asList(responseZp08StudyExit.getBody());
            //Descargar estado de embarazadas
            urlRequest = url + "/movil/zpEstadoEmb/{username}";
            publishProgress("Solicitando estado de embarazadas","14","20");
            // Perform the HTTP GET request
            ResponseEntity<ZpEstadoEmbarazada[]> responseZpEstadoEmbarazada = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    ZpEstadoEmbarazada[].class, username);
            // convert the array to a list and return it
            mStatus = Arrays.asList(responseZpEstadoEmbarazada.getBody());
          //Descargar salidas de consentimientos
            urlRequest = url + "/movil/zpSalidaCons";
            publishProgress("Solicitando ZpControlConsentimientosSalida","15","20");
            // Perform the HTTP GET request
            ResponseEntity<ZpControlConsentimientosSalida[]> responseZpControlConsentimientosSalida = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    ZpControlConsentimientosSalida[].class, username);
            // convert the array to a list and return it
            mZpControlConsentimientosSalida = Arrays.asList(responseZpControlConsentimientosSalida.getBody());
            //Descargar recepcion de consentimientos
            urlRequest = url + "/movil/zpRecepcionCons";
            publishProgress("Solicitando ZpControlConsentimientosRecepcion","16","20");
            // Perform the HTTP GET request
            ResponseEntity<ZpControlConsentimientosRecepcion[]> responseZpControlConsentimientosRecepcion = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    ZpControlConsentimientosRecepcion[].class, username);
            // convert the array to a list and return it
            mZpControlConsentimientosRecepcion = Arrays.asList(responseZpControlConsentimientosRecepcion.getBody());
            //Descargar salida de us
            urlRequest = url + "/movil/zpSalidaUS";
            publishProgress("Solicitando ZpControlReporteUSSalida","17","20");
            // Perform the HTTP GET request
            ResponseEntity<ZpControlReporteUSSalida[]> responseZpControlReporteUSSalida = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    ZpControlReporteUSSalida[].class, username);
            // convert the array to a list and return it
            mZpControlReporteUSSalida = Arrays.asList(responseZpControlReporteUSSalida.getBody());
            //Descargar recepcion de us
            urlRequest = url + "/movil/zpRecepcionUS";
            publishProgress("Solicitando ZpControlReporteUSRecepcion","18","20");
            // Perform the HTTP GET request
            ResponseEntity<ZpControlReporteUSRecepcion[]> responseZpControlReporteUSRecepcion = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    ZpControlReporteUSRecepcion[].class, username);
            // convert the array to a list and return it
            mZpControlReporteUSRecepcion = Arrays.asList(responseZpControlReporteUSRecepcion.getBody());
            /***********INFANTES***********/
            //Descargar muestras de infantes
            urlRequest = url + "/movil/zp02dInfantBiospecimenCollections/{username}";
            publishProgress("Solicitando muestras de infantes","19","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp02dInfantBiospecimenCollection[]> responseZp02dInfantBiospecimenCollection = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp02dInfantBiospecimenCollection[].class, username);
            // convert the array to a list and return it
            mInfantCollections = Arrays.asList(responseZp02dInfantBiospecimenCollection.getBody());

            //Descargar evaluaciones de infantes
            urlRequest = url + "/movil/zp07InfantAssessmentVisits/{username}";
            publishProgress("Solicitando evaluaciones de infantes","20","20");
            // Perform the HTTP GET request
            ResponseEntity<Zp07InfantAssessmentVisit[]> responseZp07InfantAssessmentVisit = restTemplate.exchange(urlRequest, HttpMethod.GET, requestEntity,
                    Zp07InfantAssessmentVisit[].class, username);
            // convert the array to a list and return it
            mInfantAssessment = Arrays.asList(responseZp07InfantAssessmentVisit.getBody());

            return null;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return e.getLocalizedMessage();
        }
    }
}
