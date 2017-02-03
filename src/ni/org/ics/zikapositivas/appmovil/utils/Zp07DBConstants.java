package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by FIRSTICT on 2/1/2017.
 * V1.0
 */
public class Zp07DBConstants {

    //Tabla Zp07InfantAssessmentVisit
    public static final String INFANTASSESSMENT_TABLE = "zp07_infant_assessment";

    //Campos Zp07InfantAssessmentVisit
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String infantVisitDate = "infantVisitDate";
    public static final String infantStatus = "infantStatus";
    public static final String infantVisit = "infantVisit";
    public static final String infantTemp = "infantTemp";
    public static final String infantTmpUnit = "infantTmpUnit";
    public static final String infantWt = "infantWt";
    public static final String infantWtUnit = "infantWtUnit";
    public static final String infantWtPercen = "infantWtPercen";
    public static final String infantWtpercenNa = "infantWtpercenNa";
    public static final String infantLength = "infantLength";
    public static final String infantLengthPercen = "infantLengthPercen";
    public static final String infantLenpercenNa = "infantLenpercenNa";
    public static final String infantHeadcircu = "infantHeadcircu";
    public static final String infantHeapercen = "infantHeapercen";
    public static final String infantHeapercenNa = "infantHeapercenNa";
    public static final String infantReferralNeuro = "infantReferralNeuro";
    public static final String infantApgarNa = "infantApgarNa";
    public static final String infantApgar1min = "infantApgar1min";
    public static final String infantApgar5min = "infantApgar5min";
    public static final String infantSkinEvalu = "infantSkinEvalu";
    public static final String infantRash = "infantRash";
    public static final String infantScarring = "infantScarring";
    public static final String infantOrganEvalu = "infantOrganEvalu";
    public static final String infantAbdominal = "infantAbdominal";
    public static final String infantLiverSpleen = "infantLiverSpleen";
    public static final String infantOphth = "infantOphth";
    public static final String infantOphthAbno = "infantOphthAbno";
    public static final String infantWhichEye = "infantWhichEye";//multiple
    public static final String infantEyeCalci = "infantEyeCalci";
    public static final String infantChoriore = "infantChoriore";
    public static final String infantEyeOther = "infantEyeOther";
    public static final String infantOtherIssue = "infantOtherIssue";//multiple
    public static final String infantEyeOtherSpecify = "infantEyeOtherSpecify";
    public static final String infantReferralOphth = "infantReferralOphth";
    public static final String infantOae = "infantOae";
    public static final String infantOaeAbnormal = "infantOaeAbnormal";
    public static final String infantWhichEar = "infantWhichEar"; //multiple
    public static final String infantReferralAudio = "infantReferralAudio";
    public static final String infantAdditionalAudio = "infantAdditionalAudio";
    public static final String infatnHearLeft = "infatnHearLeft";
    public static final String infantHearRight = "infantHearRight";
    public static final String infantBreastfeeding = "infantBreastfeeding";
    public static final String infantBreastReason = "infantBreastReason";//multiple
    public static final String infantBreastOther = "infantBreastOther";
    public static final String infantNeurodeve = "infantNeurodeve";
    public static final String infantNeurodeveType = "infantNeurodeveType";//multiple
    public static final String infantOtherSpecify = "infantOtherSpecify";
    public static final String infantExhibited = "infantExhibited"; //multiple
    public static final String infantOtherMovement = "infantOtherMovement";
    public static final String infantFurtherNeuro = "infantFurtherNeuro";
    public static final String infantHeadAltra = "infantHeadAltra";
    public static final String infantUltraObtained = "infantUltraObtained";
    public static final String infantUltraDt = "infantUltraDt";
    public static final String infantResultsUltra = "infantResultsUltra";
    public static final String infantResultsSpecify = "infantResultsSpecify";
    public static final String infantHeadCt = "infantHeadCt";
    public static final String infantCtObtained = "infantCtObtained";
    public static final String infantCtDt = "infantCtDt";
    public static final String infantResultsCt = "infantResultsCt";
    public static final String infantCtSpecify = "infantCtSpecify";
    public static final String infantCerebrospinal = "infantCerebrospinal";
    public static final String infantCerebroStored = "infantCerebroStored";
    public static final String infantCerebroDt = "infantCerebroDt";
    public static final String infantCerebroAmount = "infantCerebroAmount";
    public static final String infantResultsCerebro = "infantResultsCerebro";
    public static final String infantCerebroSpecify = "infantCerebroSpecify";
    public static final String infantMri = "infantMri";
    public static final String infantMriObtained = "infantMriObtained";
    public static final String infantMriDt = "infantMriDt";
    public static final String infantResultsMri = "infantResultsMri";
    public static final String infantMriSpecify = "infantMriSpecify";
    public static final String infantPreviousResults = "infantPreviousResults";
    public static final String infantReferrCounselling = "infantReferrCounselling";
    public static final String infantOtherLabCollect = "infantOtherLabCollect";
    public static final String infantIdCompleting = "infantIdCompleting";
    public static final String infantDateCompleted = "infantDateCompleted";
    public static final String infantIdReviewer = "infantIdReviewer";
    public static final String infantDateReviewed = "infantDateReviewed";
    public static final String infantIdDataEntry = "infantIdDataEntry";
    public static final String infantDateEntered = "infantDateEntered";

    //Crear tabla Zp07InfantAssessmentVisit
    public static final String CREATE_INFANTASSESSMENT_TABLE = "create table if not exists "
            + INFANTASSESSMENT_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + infantVisitDate + " date, "
            + infantStatus + " text, "
            + infantVisit + " text, "
            + infantTemp + " real, "
            + infantTmpUnit + " text, "
            + infantWt + " real, "
            + infantWtUnit + " text, "
            + infantWtPercen + " real, "
            + infantWtpercenNa + " text, "
            + infantLength + " real, "
            + infantLengthPercen + " real, "
            + infantLenpercenNa + " text, "
            + infantHeadcircu + " real, "
            + infantHeapercen + " real, "
            + infantHeapercenNa + " text, "
            + infantReferralNeuro + " text, "
            + infantApgarNa + " text, "
            + infantApgar1min + " real, "
            + infantApgar5min + " real, "
            + infantSkinEvalu + " text, "
            + infantRash + " text, "
            + infantScarring + " text, "
            + infantOrganEvalu + " text, "
            + infantAbdominal + " text, "
            + infantLiverSpleen + " text, "
            + infantOphth + " text, "
            + infantOphthAbno + " text, "
            + infantWhichEye + " text, "
            + infantEyeCalci + " text, "
            + infantChoriore + " text, "
            + infantEyeOther + " text, "
            + infantOtherIssue + " text, "
            + infantEyeOtherSpecify + " text, "
            + infantReferralOphth + " text, "
            + infantOae + " text, "
            + infantOaeAbnormal + " text, "
            + infantWhichEar + " text, "
            + infantReferralAudio + " text, "
            + infantAdditionalAudio + " text, "
            + infatnHearLeft + " real, "
            + infantHearRight + " real, "
            + infantBreastfeeding + " text, "
            + infantBreastReason + " text, "
            + infantBreastOther + " text, "
            + infantNeurodeve + " text, "
            + infantNeurodeveType + " text, "
            + infantOtherSpecify + " text, "
            + infantExhibited + " text, "
            + infantOtherMovement + " text, "
            + infantFurtherNeuro + " text, "
            + infantHeadAltra + " text, "
            + infantUltraObtained + " text, "
            + infantUltraDt + " date, "
            + infantResultsUltra + " text, "
            + infantResultsSpecify + " text, "
            + infantHeadCt + " text, "
            + infantCtObtained + " text, "
            + infantCtDt + " date, "
            + infantResultsCt + " text, "
            + infantCtSpecify + " text, "
            + infantCerebrospinal + " text, "
            + infantCerebroStored + " text, "
            + infantCerebroDt + " date, "
            + infantCerebroAmount + " real, "
            + infantResultsCerebro + " text, "
            + infantCerebroSpecify + " text, "
            + infantMri + " text, "
            + infantMriObtained + " text, "
            + infantMriDt + " date, "
            + infantResultsMri + " text, "
            + infantMriSpecify + " text, "
            + infantPreviousResults + " text, "
            + infantReferrCounselling + " text, "
            + infantOtherLabCollect + " text, "
            + infantIdCompleting + " text, "
            + infantDateCompleted + " date, "
            + infantIdReviewer + " text, "
            + infantDateReviewed + " date, "
            + infantIdDataEntry + " text, "
            + infantDateEntered + " date, "
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
