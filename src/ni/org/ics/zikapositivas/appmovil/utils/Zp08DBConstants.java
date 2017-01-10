package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by FIRSTICT on 10/25/2016.
 * V1.0
 */
public class Zp08DBConstants {

    //Tabla Zp08StudyExit
    public static final String STUDYEXIT_TABLE = "zp08_study_exit";

    //Campos Zp08StudyExit
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String extStudyExitDate = "extStudyExitDate";
    public static final String extSubjClass = "extSubjClass";
    public static final String extStudyExitReason = "extStudyExitReason";
    public static final String extNonpregMatrnlDth = "extNonpregMatrnlDth";
    public static final String extAcuteHealthSpec = "extAcuteHealthSpec";
    public static final String extHealthCondSpec = "extHealthCondSpec";
    public static final String extFatalInjSpec = "extFatalInjSpec";
    public static final String extInfDeathTime = "extInfDeathTime";
    public static final String extTestResultsRcvd = "extTestResultsRcvd";
    public static final String extCounselingRcvd = "extCounselingRcvd";
    public static final String extComments = "extComments";
    public static final String extIdCompleting = "extIdCompleting";
    public static final String extDateCompleted = "extDateCompleted";
    public static final String extIdReviewer = "extIdReviewer";
    public static final String extDateReviewed = "extDateReviewed";
    public static final String extIdDataEntry = "extIdDataEntry";
    public static final String extDateEntered = "extDateEntered";

    //Crear tabla Zp08StudyExit
    public static final String CREATE_STUDYEXIT_TABLE = "create table if not exists "
            + STUDYEXIT_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + extStudyExitDate + " date, "
            + extSubjClass + " text, "
            + extStudyExitReason + " text, "
            + extNonpregMatrnlDth + " text, "
            + extAcuteHealthSpec + " text, "
            + extHealthCondSpec + " text, "
            + extFatalInjSpec + " text, "
            + extInfDeathTime + " text, "
            + extTestResultsRcvd + " text, "
            + extCounselingRcvd + " text, "
            + extComments + " text, "
            + extIdCompleting + " text, "
            + extDateCompleted + " date, "
            + extIdReviewer + " text, "
            + extDateReviewed + " date, "
            + extIdDataEntry + " text, "
            + extDateEntered + " date, "
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
            + "primary key (" + recordId + "));";

}
