package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by FIRSTICT on 10/25/2016.
 * V1.0
 */
public class Zp05DBConstants {

    //Tabla Zp05UltrasoundExam
    public static String ULTRASOUNDEXAM_TABLE = "zp05_ultrasound_exam";

    //Campos Zp05UltrasoundExam
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String ultDate = "ultDate";
    public static final String ultGaWeeks = "ultGaWeeks";
    public static final String ultGaDays = "ultGaDays";
    public static final String ultGeDetermined = "ultGeDetermined";
    public static final String ultReason = "ultReason";
    public static final String ultReasonOther = "ultReasonOther";
    public static final String ultTime = "ultTime";
    public static final String ultNameFacility = "ultNameFacility";
    public static final String ultFacilityid = "ultFacilityid";
    public static final String ultIdSonographer = "ultIdSonographer";
    public static final String ultIdNa = "ultIdNa";
    public static final String ultFestiGaWeeks1 = "ultFestiGaWeeks1";
    public static final String ultFestiGaDays1 = "ultFestiGaDays1";
    public static final String ultFestiDelivery1 = "ultFestiDelivery1";
    public static final String ultFirstYesno1 = "ultFirstYesno1";
    public static final String ultFabnormal1 = "ultFabnormal1";
    public static final String ultFyesSpecify1 = "ultFyesSpecify1";
    public static final String ultFotherFindings1 = "ultFotherFindings1";
    public static final String ultFurtherTesting1 = "ultFurtherTesting1";
    public static final String ultFnumFetuses = "ultFnumFetuses";
    public static final String ultFfetusViable1 = "ultFfetusViable1";
    public static final String ultFfetalCardia1 = "ultFfetalCardia1";
    public static final String ultFfetalHeart1 = "ultFfetalHeart1";
    public static final String ultFcrl1 = "ultFcrl1";
    public static final String ultFcrlNa1 = "ultFcrlNa1";
    public static final String ultFfetusViable2 = "ultFfetusViable2";
    public static final String ultFfetalCardia2 = "ultFfetalCardia2";
    public static final String ultFfetalHeart2 = "ultFfetalHeart2";
    public static final String ultFcrl2 = "ultFcrl2";
    public static final String ultFcrlNa2 = "ultFcrlNa2";
    public static final String ultFfetusViable3 = "ultFfetusViable3";
    public static final String ultFfetalCardia3 = "ultFfetalCardia3";
    public static final String ultFfetalHeart3 = "ultFfetalHeart3";
    public static final String ultFcrl3 = "ultFcrl3";
    public static final String ultFcrlNa3 = "ultFcrlNa3";
    public static final String ultSfindings1 = "ultSfindings1";
    public static final String ultSspecify1 = "ultSspecify1";
    public static final String ultSfindingsSpecify1 = "ultSfindingsSpecify1";
    public static final String ultFurtherExamination1 = "ultFurtherExamination1";
    public static final String ultSplacental1 = "ultSplacental1";
    public static final String ultSnumFetuses = "ultSnumFetuses";
    public static final String ultSfetusViable1 = "ultSfetusViable1";
    public static final String ultSfetalCardia1 = "ultSfetalCardia1";
    public static final String ultSfetalHeart1 = "ultSfetalHeart1";
    public static final String ultSbiparietal1 = "ultSbiparietal1";
    public static final String ultShead1 = "ultShead1";
    public static final String ultMicroceph1 = "ultMicroceph1";
    public static final String ultSevMicroceph1 = "ultSevMicroceph1";
    public static final String ultSabdominal1 = "ultSabdominal1";
    public static final String ultSfemur1 = "ultSfemur1";
    public static final String ultSfetalWt1 = "ultSfetalWt1";
    public static final String ultSpresentation1 = "ultSpresentation1";
    public static final String ultSfetusViable2 = "ultSfetusViable2";
    public static final String ultSfetalCardia2 = "ultSfetalCardia2";
    public static final String ultSfetalHeart2 = "ultSfetalHeart2";
    public static final String ultSbiparietal2 = "ultSbiparietal2";
    public static final String ultShead2 = "ultShead2";
    public static final String ultMicroceph2 = "ultMicroceph2";
    public static final String ultSevMicroceph2 = "ultSevMicroceph2";
    public static final String ultSabdominal2 = "ultSabdominal2";
    public static final String ultSfemur2 = "ultSfemur2";
    public static final String ultSfetalWt2 = "ultSfetalWt2";
    public static final String ultSpresentation2 = "ultSpresentation2";
    public static final String ultSfetusViable3 = "ultSfetusViable3";
    public static final String ultSfetalCardia3 = "ultSfetalCardia3";
    public static final String ultSfetalHeart3 = "ultSfetalHeart3";
    public static final String ultSbiparietal3 = "ultSbiparietal3";
    public static final String ultShead3 = "ultShead3";
    public static final String ultMicroceph3 = "ultMicroceph3";
    public static final String ultSevMicroceph3 = "ultSevMicroceph3";
    public static final String ultSabdominal3 = "ultSabdominal3";
    public static final String ultSfemur3 = "ultSfemur3";
    public static final String ultSfetalWt3 = "ultSfetalWt3";
    public static final String ultSpresentation3 = "ultSpresentation3";
    public static final String ultIdCompleting = "ultIdCompleting";
    public static final String ultDateCompleted = "ultDateCompleted";
    public static final String ultIdReviewer = "ultIdReviewer";
    public static final String ultDateReviewed = "ultDateReviewed";
    public static final String ultIdDataEntry = "ultIdDataEntry";
    public static final String ultDateEntered = "ultDateEntered";

    //Crear tabla Zp05UltrasoundExam
    public static final String CREATE_ULTRASOUNDEXAM_TABLE = "create table if not exists "
            + ULTRASOUNDEXAM_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + ultDate  + " date, "
            + ultGaWeeks  + " integer, "
            + ultGaDays  + " integer, "
            + ultGeDetermined  + " text, "
            + ultReason  + " text, "
            + ultReasonOther  + " text, "
            + ultTime  + " text, "
            + ultNameFacility  + " text, "
            + ultFacilityid  + " text, "
            + ultIdSonographer  + " text, "
            + ultIdNa  + " text, "
            + ultFestiGaWeeks1  + " integer, "
            + ultFestiGaDays1  + " integer, "
            + ultFestiDelivery1  + " date, "
            + ultFirstYesno1  + " text, "
            + ultFabnormal1  + " text, "
            + ultFyesSpecify1  + " text, "
            + ultFotherFindings1  + " text, "
            + ultFurtherTesting1  + " text, "
            + ultFnumFetuses  + " integer, "
            + ultFfetusViable1  + " text, "
            + ultFfetalCardia1  + " text, "
            + ultFfetalHeart1  + " real, "
            + ultFcrl1  + " integer, "
            + ultFcrlNa1  + " text, "
            + ultFfetusViable2  + " text, "
            + ultFfetalCardia2  + " text, "
            + ultFfetalHeart2  + " real, "
            + ultFcrl2  + " integer, "
            + ultFcrlNa2  + " text, "
            + ultFfetusViable3  + " text, "
            + ultFfetalCardia3  + " text, "
            + ultFfetalHeart3  + " real, "
            + ultFcrl3  + " integer, "
            + ultFcrlNa3  + " text, "
            + ultSfindings1  + " text, "
            + ultSspecify1  + " text, "
            + ultSfindingsSpecify1  + " text, "
            + ultFurtherExamination1  + " text, "
            + ultSplacental1  + " text, "
            + ultSnumFetuses  + " integer, "
            + ultSfetusViable1  + " text, "
            + ultSfetalCardia1  + " text, "
            + ultSfetalHeart1  + " real, "
            + ultSbiparietal1  + " integer, "
            + ultShead1  + " integer, "
            + ultMicroceph1  + " text, "
            + ultSevMicroceph1  + " text, "
            + ultSabdominal1  + " integer, "
            + ultSfemur1  + " integer, "
            + ultSfetalWt1  + " integer, "
            + ultSpresentation1  + " text, "
            + ultSfetusViable2  + " text, "
            + ultSfetalCardia2  + " text, "
            + ultSfetalHeart2  + " real, "
            + ultSbiparietal2  + " integer, "
            + ultShead2  + " integer, "
            + ultMicroceph2  + " text, "
            + ultSevMicroceph2  + " text, "
            + ultSabdominal2  + " integer, "
            + ultSfemur2  + " integer, "
            + ultSfetalWt2  + " integer, "
            + ultSpresentation2  + " text, "
            + ultSfetusViable3  + " text, "
            + ultSfetalCardia3  + " text, "
            + ultSfetalHeart3  + " real, "
            + ultSbiparietal3  + " integer, "
            + ultShead3  + " integer, "
            + ultMicroceph3  + " text, "
            + ultSevMicroceph3  + " text, "
            + ultSabdominal3  + " integer, "
            + ultSfemur3  + " integer, "
            + ultSfetalWt3  + " integer, "
            + ultSpresentation3  + " text, "
            + ultIdCompleting  + " text, "
            + ultDateCompleted  + " date, "
            + ultIdReviewer  + " text, "
            + ultDateReviewed  + " date, "
            + ultIdDataEntry  + " text, "
            + ultDateEntered  + " date, "
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
            + "primary key (" + recordId + ","+redcapEventName+"));";
}
