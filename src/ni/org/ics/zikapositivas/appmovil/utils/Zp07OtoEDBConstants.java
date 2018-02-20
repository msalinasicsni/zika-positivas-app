package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by FIRSTICT on 2/1/2017.
 * V1.0
 */
public class Zp07OtoEDBConstants {

    //Tabla Zp07InfantOtoacousticEmissions
    public static final String INFANT_OTO_EMS_TABLE = "zp07_infant_otoacoustic_ems";

    //Campos Zp07InfantOtoacousticEmissions
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String infantVisitDate = "infantVisitDate";
    public static final String infantStatus = "infantStatus";
    public static final String infantVisit = "infantVisit";
    public static final String infantAgeMonths = "infantAgeMonths";
    public static final String infantOae = "infantOae";
    public static final String infantOphthType = "infantOphthType";
    public static final String infantHearingOverall = "infantHearingOverall";
    public static final String infantRoae = "infantRoae";
    public static final String infantRaabr = "infantRaabr";
    public static final String infantLoae = "infantLoae";
    public static final String infantLaabr = "infantLaabr";
    public static final String infantComments2 = "infantComments2";
    public static final String infantIdCompleting = "infantIdCompleting";
    public static final String infantDtComp = "infantDtComp";
    public static final String infantIdReviewer = "infantIdReviewer";
    public static final String infantDtReview = "infantDtReview";
    public static final String infantIdDataEntry= "infantIdDataEntry";
    public static final String infantDtEnter = "infantDtEnter";


    //Crear tabla Zp07InfantOtoacousticEmissions
    public static final String CREATE_INFANT_OTO_EMS_TABLE = "create table if not exists "
            + INFANT_OTO_EMS_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + infantVisitDate + " date, "
            + infantStatus + " text, "
            + infantVisit + " text, "
            + infantOae + " text, "
            + infantOphthType + " text, "
            + infantAgeMonths + " integer, "
            + infantHearingOverall + " text, "
            + infantRoae + " text, "
            + infantRaabr + " text, "
            + infantLoae + " text, "
            + infantLaabr + " text, "
            + infantComments2 + " text, "
            + infantIdCompleting + " text, "
            + infantDtComp + " date, "
            + infantIdReviewer + " text, "
            + infantDtReview + " date, "
            + infantIdDataEntry + " text, "
            + infantDtEnter + " date, "
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
