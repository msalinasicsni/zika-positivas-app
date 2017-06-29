package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07cDBConstants {

    //Tabla Zp07cInfantImageStudies
    public static final String CINFANT_IMAGESTUDIES_TABLE = "zp07c_infant_image_studies";

    //Campos Zp07cInfantImageStudies
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String infantImageDt = "infantImageDt";
    public static final String infantHeadAltra= "infantHeadAltra";
    public static final String infantUltraObtained = "infantUltraObtained";
    public static final String infantUltraDt = "infantUltraDt";
    public static final String infantResultsSpecify = "infantResultsSpecify";
    public static final String infantUltraOther = "infantUltraOther";
    public static final String infantUltraFile = "infantUltraFile";
    public static final String infantHeadCt = "infantHeadCt";
    public static final String infantCtObtained = "infantCtObtained";
    public static final String infantCtDt = "infantCtDt";
    public static final String infantCtspecify = "infantCtspecify";
    public static final String infantCtotherSpecify = "infantCtotherSpecify";
    public static final String infantCtFile = "infantCtFile";
    public static final String infantCerebrospinal = "infantCerebrospinal";
    public static final String infantCerebroStored = "infantCerebroStored";
    public static final String infantCerebroDt = "infantCerebroDt";
    public static final String infantCerebroAmount = "infantCerebroAmount";
    public static final String infantResultsCerebro = "infantResultsCerebro";
    public static final String infantCerebroSpecify = "infantCerebroSpecify";
    public static final String infantMri = "infantMri";
    public static final String infantMriObtained = "infantMriObtained";
    public static final String infantMriDt = "infantMriDt";
    public static final String infantMriSpecify = "infantMriSpecify";
    public static final String infantMriotherSpecify = "infantMriotherSpecify";
    public static final String infantMriFile = "infantMriFile";
    public static final String infantIgcom = "infantIgcom";
    public static final String infantIgcomDetail = "infantIgcomDetail";
    public static final String infantIgidCom = "infantIgidCom";
    public static final String infantIgdtCom = "infantIgdtCom";
    public static final String infantIgeyeIdRevi = "infantIgeyeIdRevi";
    public static final String infantIgdtRevi = "infantIgdtRevi";
    public static final String infantIgidEntry = "infantIgidEntry";
    public static final String infantIgdateEnt = "infantIgdateEnt";



    //Crear tabla Zp07cInfantImageStudies
    public static final String CREATE_CINFANT_IMAGESTUDIES_TABLE = "create table if not exists "
            + CINFANT_IMAGESTUDIES_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "

            + infantImageDt + " date, "
            + infantHeadAltra + " text, "
            + infantUltraObtained + " text, "
            + infantUltraDt + " date, "
            + infantResultsSpecify + " text, "
            + infantUltraOther + " text, "
            + infantUltraFile + " text, "
            + infantHeadCt + " text, "
            + infantCtObtained + " text, "
            + infantCtDt + " date, "
            + infantCtspecify + " text, "
            + infantCtotherSpecify + " text, "
            + infantCtFile + " text, "
            + infantCerebrospinal + " text, "
            + infantCerebroStored + " text, "
            + infantCerebroDt + " date, "
            + infantCerebroAmount + " real, "
            + infantResultsCerebro + " text, "
            + infantCerebroSpecify + " text, "
            + infantMri + " text, "
            + infantMriObtained + " text, "
            + infantMriDt + " date, "
            + infantMriSpecify + " text, "
            + infantMriotherSpecify + " text, "
            + infantMriFile + " text, "
            + infantIgcom + " text, "
            + infantIgcomDetail + " text, "
            + infantIgidCom + " text, "
            + infantIgdtCom + " date, "
            + infantIgeyeIdRevi + " text, "
            + infantIgdtRevi + " date, "
            + infantIgidEntry + " text, "
            + infantIgdateEnt + " date, "



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
