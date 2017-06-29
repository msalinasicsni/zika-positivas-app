package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07aDBConstants {

    //Tabla Zp07InfantAssessmentVisit
    public static final String AINFANT_OPHTRESULTS_TABLE = "zp07a_infant_opht_results";

    //Campos Zp07InfantAssessmentVisit
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String infantOphthDt = "infantOphthDt" ;
    public static final String infantOphType = "infantOphType" ;
    public static final String infantEyeCalci = "infantEyeCalci" ;
    public static final String infantChoriore = "infantChoriore" ;
    public static final String infantFocalPm = "infantFocalPm" ;
    public static final String infantChorioreAtro = "infantChorioreAtro" ;
    public static final String infantMicroph = "infantMicroph" ;
    public static final String infantMicrocornea = "infantMicrocornea" ;
    public static final String infantIrisColobo= "infantIrisColobo" ;
    public static final String infantOpticNerve = "infantOpticNerve" ;
    public static final String infantSubLuxated = "infantSubLuxated" ;
    public static final String infantStrabismus = "infantStrabismus" ;
    public static final String infantEyeOther = "infantEyeOther" ;
    public static final String infantEyeOtherSpecify = "infantEyeOtherSpecify" ;
    public static final String infantReferralOphth = "infantReferralOphth" ;
    public static final String infantEyeFile = "infantEyeFile" ;
    public static final String infantEyeCom = "infantEyeCom" ;
    public static final String infantEyComdetail = "infantEyComdetail" ;
    public static final String infantEyidCom = "infantEyidCom" ;
    public static final String infantEydtCom = "infantEydtCom" ;
    public static final String infantEyidRevi = "infantEyidRevi" ;
    public static final String infantEydtRevi = "infantEydtRevi" ;
    public static final String infantEyidEntry = "infantEyidEntry" ;
    public static final String infantEydtEnt = "infantEydtEnt" ;

    //Crear tabla Zp07aInfantOphtResults
    public static final String CREATE_AINFANT_OPHTRESULTS_TABLE = "create table if not exists "
            + AINFANT_OPHTRESULTS_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + infantOphthDt + " date, "
            + infantOphType + " text, "
            + infantEyeCalci + " text, "
            + infantChoriore + " text, "
            + infantFocalPm + " text, "
            + infantChorioreAtro + " text, "
            + infantMicroph + " text, "
            + infantMicrocornea + " text, "
            + infantIrisColobo + " text, "
            + infantOpticNerve + " text, "
            + infantSubLuxated + " text, "
            + infantStrabismus + " text, "
            + infantEyeOther + " text, "
            + infantEyeOtherSpecify + " text, "
            + infantReferralOphth + " text, "
            + infantEyeFile + " text, "
            + infantEyeCom + " text, "
            + infantEyComdetail + " text, "
            + infantEyidCom + " text, "
            + infantEydtCom + " date, "
            + infantEyidRevi + " text, "
            + infantEydtRevi + " date, "
            + infantEyidEntry + " text, "
            + infantEydtEnt + " date, "


            + MainDBConstants.recordDate + " date, "
            + MainDBConstants.recordUser + " text, "
            + MainDBConstants.pasive + " text, "
            + MainDBConstants.ID_INSTANCIA + " integer,"
            + MainDBConstants.FILE_PATH + " text,"
            + MainDBConstants.STATUS + " text not null, "
            + MainDBConstants.START  + " text, "
            + MainDBConstants.END  + " text, "
            + MainDBConstants.DEVICE_ID  + " text, "
            + MainDBConstants.SIM_SERIAL + " text, "
            + MainDBConstants.PHONE_NUMBER  + " text, "
            + MainDBConstants.TODAY  + " date, "
            + "primary key (" + recordId + ", "+redcapEventName+"));";



}
