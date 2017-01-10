package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by FIRSTICT on 10/19/2016.
 * V1.0
 */
public class Zp01DBConstants {

    //Tabla Zp01StudyEntrySectionAtoD
    public static final String STUDYENTRY_AD_TABLE = "zp01_study_entry_section_a_to_d";

    //Campos comunes
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";

    //Campos Zp01StudyEntrySectionAtoD
    public static final String seaVdate = "seaVdate";
    public static final String seaPtdate = "seaPtdate";
    public static final String seaTresults = "seaTresults";
    public static final String seaLmpdate = "seaLmpdate";
    public static final String seaLmpunknown = "seaLmpunknown";
    public static final String seaGaWeek = "seaGaWeek";
    public static final String seaGaDay = "seaGaDay";
    public static final String seaEddLmp = "seaEddLmp";
    public static final String seaTriultrasound = "seaTriultrasound";
    public static final String seaUltravailable = "seaUltravailable";
    public static final String seaUltraDay = "seaUltraDay";
    public static final String seaUltraMonth = "seaUltraMonth";
    public static final String seaUltraYear = "seaUltraYear";
    public static final String seaAgweeks = "seaAgweeks";
    public static final String seaAgdays = "seaAgdays";
    public static final String seaEdd = "seaEdd";
    public static final String seaEddUsed = "seaEddUsed";
    public static final String seaPreWt = "seaPreWt";
    public static final String seaPrewtUnit = "seaPrewtUnit";
    public static final String seaCurHt = "seaCurHt";
    public static final String seaCurhtUnit = "seaCurhtUnit";
    public static final String seaMotherWt = "seaMotherWt";
    public static final String seaMotherwtUnit = "seaMotherwtUnit";
    public static final String seaHem = "seaHem";
    public static final String seaSystolic = "seaSystolic";
    public static final String seaDiastolic = "seaDiastolic";
    public static final String seaTemp = "seaTemp";
    public static final String seaTmpUnit = "seaTmpUnit";
    public static final String seaCity = "seaCity";
    public static final String seaState = "seaState";
    public static final String seaCountry = "seaCountry";
    public static final String seaLive = "seaLive";
    public static final String seaAgeLeave = "seaAgeLeave";
    public static final String seaLeavena = "seaLeavena";
    public static final String seaMstatus = "seaMstatus";
    public static final String seaRace = "seaRace";
    public static final String seaEthnicityOther = "seaEthnicityOther";
    public static final String seaDegreeYou = "seaDegreeYou";
    public static final String seaYdegreeYears = "seaYdegreeYears";
    public static final String seaDegreeSpouse = "seaDegreeSpouse";
    public static final String seaSdegreeYears = "seaSdegreeYears";
    //Cambios version 2
    public static final String seaAddtChronicDiseases = "seaAddtChronicDiseases";
    public static final String seaAddtChronicDiseases1 = "seaAddtChronicDiseases1";
    public static final String seaAddtChronicDiseases2 = "seaAddtChronicDiseases2";
    public static final String seaAddtChronicDiseases3 = "seaAddtChronicDiseases3";
    public static final String seaAddtMedicines = "seaAddtMedicines";
    public static final String seaAddtDrugsType = "seaAddtDrugsType";
    public static final String seaAddtOthDrugsType1 = "seaAddtOthDrugsType1";
    public static final String seaAddtOthDrugsBrand1 = "seaAddtOthDrugsBrand1";
    public static final String seaAddtOthDrugsType2 = "seaAddtOthDrugsType2";
    public static final String seaAddtOthDrugsBrand2 = "seaAddtOthDrugsBrand2";
    public static final String seaAddtOthDrugsType3 = "seaAddtOthDrugsType3";
    public static final String seaAddtOthDrugsBrand3 = "seaAddtOthDrugsBrand3";
    public static final String seaAddtOthDrugsType4 = "seaAddtOthDrugsType4";
    public static final String seaAddtOthDrugsBrand4 = "seaAddtOthDrugsBrand4";
    public static final String seaAddtOthDrugsType5 = "seaAddtOthDrugsType5";
    public static final String seaAddtOthDrugsBrand5 = "seaAddtOthDrugsBrand5";

    //Crear tabla Zp01StudyEntrySectionAtoD

    public static final String CREATE_STUDYENTRY_AD_TABLE = "create table if not exists "
            + STUDYENTRY_AD_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + seaVdate + " date, "
            + seaPtdate + " date, "
            + seaTresults + " text, "
            + seaLmpdate  + " date, "
            + seaLmpunknown + " text, "
            + seaGaWeek + " integer, "
            + seaGaDay + " integer, "
            + seaEddLmp  + " date, "
            + seaTriultrasound  + " text, "
            + seaUltravailable  + " text, "
            + seaUltraDay  + " text, "
            + seaUltraMonth + " text, "
            + seaUltraYear + " text, "
            + seaAgweeks + " integer, "
            + seaAgdays + " integer, "
            + seaEdd + " date, "
            + seaEddUsed + " text, "
            + seaPreWt + " real, "
            + seaPrewtUnit + " text, "
            + seaCurHt + " real, "
            + seaCurhtUnit + " text, "
            + seaMotherWt + " real, "
            + seaMotherwtUnit + " text, "
            + seaHem + " real, "
            + seaSystolic  + " integer, "
            + seaDiastolic + " integer, "
            + seaTemp + " real, "
            + seaTmpUnit + " text, "
            + seaCity + " text, "
            + seaState + " text, "
            + seaCountry + " text, "
            + seaLive + " text, "
            + seaAgeLeave + " integer, "
            + seaLeavena + " text, "
            + seaMstatus + " text, "
            + seaRace + " text, "
            + seaEthnicityOther + " text, "
            + seaDegreeYou + " text, "
            + seaYdegreeYears + " real, "
            + seaDegreeSpouse + " text, "
            + seaSdegreeYears + " real, "
            + seaAddtChronicDiseases + " text, "
            + seaAddtChronicDiseases1 + " text, "
            + seaAddtChronicDiseases2 + " text, "
            + seaAddtChronicDiseases3 + " text, "
            + seaAddtMedicines + " text, "
            + seaAddtDrugsType + " text, "
            + seaAddtOthDrugsType1 + " text, "
            + seaAddtOthDrugsBrand1 + " text, "
            + seaAddtOthDrugsType2 + " text, "
            + seaAddtOthDrugsBrand2 + " text, "
            + seaAddtOthDrugsType3 + " text, "
            + seaAddtOthDrugsBrand3 + " text, "
            + seaAddtOthDrugsType4 + " text, "
            + seaAddtOthDrugsBrand4 + " text, "
            + seaAddtOthDrugsType5 + " text, "
            + seaAddtOthDrugsBrand5 + " text, "
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

    //Tabla Zp01StudyEntrySectionE
    public static final String STUDYENTRY_E_TABLE = "zp01_study_entry_section_e";

    //Campos de Zp01StudyEntrySectionE
    public static final String seaDiseases = "seaDiseases"; //multiple
    public static final String seaOtherSpecify = "seaOtherSpecify";
    public static final String seaHepatitis = "seaHepatitis";
    public static final String seaHepatitisDate1 = "seaHepatitisDate1";
    public static final String seaHepatitisDate2 = "seaHepatitisDate2";
    public static final String seaHepatitisDate3 = "seaHepatitisDate3";
    public static final String seaMeasles = "seaMeasles";
    public static final String seaMeaslesDate1 = "seaMeaslesDate1";
    public static final String seaMeaslesDate2 = "seaMeaslesDate2";
    public static final String seaMeaslesDate3 = "seaMeaslesDate3";
    public static final String seaChickenpox = "seaChickenpox";
    public static final String seaChickenpoxDate1 = "seaChickenpoxDate1";
    public static final String seaChickenpoxDate2 = "seaChickenpoxDate2";
    public static final String seaChickenpoxDate3 = "seaChickenpoxDate3";
    public static final String seaInfluenza = "seaInfluenza";
    public static final String seaInfluenzaDate1 = "seaInfluenzaDate1";
    public static final String seaInfluenzaDate2 = "seaInfluenzaDate2";
    public static final String seaInfluenzaDate3 = "seaInfluenzaDate3";
    public static final String seaYellow = "seaYellow";
    public static final String seaYellowDate1 = "seaYellowDate1";
    public static final String seaYellowDate2 = "seaYellowDate2";
    public static final String seaYellowDate3 = "seaYellowDate3";
    public static final String seaDengue = "seaDengue";
    public static final String seaDengueDate1 = "seaDengueDate1";
    public static final String seaDengueDate2 = "seaDengueDate2";
    public static final String seaDengueDate3 = "seaDengueDate3";
    public static final String seaVacOther = "seaVacOther";
    public static final String seaVacotherSpecify = "seaVacotherSpecify";
    public static final String seaOtherDate1 = "seaOtherDate1";
    public static final String seaOtherDate2 = "seaOtherDate2";
    public static final String seaOtherDate3 = "seaOtherDate3";
    public static final String seaRubella = "seaRubella";
    public static final String seaRubellaDate1 = "seaRubellaDate1";
    public static final String seaRubellaDate2 = "seaRubellaDate2";
    public static final String seaRubellaDate3 = "seaRubellaDate3";
    public static final String seaRubellaDoc = "seaRubellaDoc";
    public static final String seaCmv = "seaCmv";
    public static final String seaCmvDate1 = "seaCmvDate1";
    public static final String seaCmvDate2 = "seaCmvDate2";
    public static final String seaCmvDate3 = "seaCmvDate3";
    public static final String seaCmvDoc = "seaCmvDoc";
    public static final String seaHerpes = "seaHerpes";
    public static final String seaHerpesDate1 = "seaHerpesDate1";
    public static final String seaHerpesDate2 = "seaHerpesDate2";
    public static final String seaHerpesDate3 = "seaHerpesDate3";
    public static final String seaHerpesDoc = "seaHerpesDoc";
    public static final String seaParvovirus = "seaParvovirus";
    public static final String seaParvovirusDate1 = "seaParvovirusDate1";
    public static final String seaParvovirusDate2 = "seaParvovirusDate2";
    public static final String seaParvovirusDate3 = "seaParvovirusDate3";
    public static final String seaParvovirusDoc = "seaParvovirusDoc";
    public static final String seaToxoplasmosis = "seaToxoplasmosis";
    public static final String seaToxoplasmosisDate1 = "seaToxoplasmosisDate1";
    public static final String seaToxoplasmosisDate2 = "seaToxoplasmosisDate2";
    public static final String seaToxoplasmosisDate3 = "seaToxoplasmosisDate3";
    public static final String seaToxoplasmosisDoc = "seaToxoplasmosisDoc";
    public static final String seaSyphillis = "seaSyphillis";
    public static final String seaSyphillisDate1 = "seaSyphillisDate1";
    public static final String seaSyphillisDate2 = "seaSyphillisDate2";
    public static final String seaSyphillisDate3 = "seaSyphillisDate3";
    public static final String seaSyphillisDoc = "seaSyphillisDoc";
    public static final String seaHiv = "seaHiv";
    public static final String seaHivDate1 = "seaHivDate1";
    public static final String seaHivDate2 = "seaHivDate2";
    public static final String seaHivDate3 = "seaHivDate3";
    public static final String seaHivDoc = "seaHivDoc";
    public static final String seaZika = "seaZika";
    public static final String seaZikaDate1 = "seaZikaDate1";
    public static final String seaZikaDate2 = "seaZikaDate2";
    public static final String seaZikaDate3 = "seaZikaDate3";
    public static final String seaZikaDoc = "seaZikaDoc";
    public static final String seaChikung = "seaChikung";
    public static final String seaChikungDate1 = "seaChikungDate1";
    public static final String seaChikungDate2 = "seaChikungDate2";
    public static final String seaChikungDate3 = "seaChikungDate3";
    public static final String seaChikungDoc = "seaChikungDoc";
    public static final String seaInfluInfect = "seaInfluInfect";
    public static final String seaInflueInfectDate1 = "seaInflueInfectDate1";
    public static final String seaInfluInfectDate2 = "seaInfluInfectDate2";
    public static final String seaInfluInfectDate3 = "seaInfluInfectDate3";
    public static final String seaInfluInfectDoc = "seaInfluInfectDoc";
    public static final String seaDengueInfect = "seaDengueInfect";
    public static final String seaDengueInfectDate1 = "seaDengueInfectDate1";
    public static final String seaDengueInfectDate2 = "seaDengueInfectDate2";
    public static final String seaDengueInfectDate3 = "seaDengueInfectDate3";
    public static final String seaDengueInfectDoc = "seaDengueInfectDoc";
    public static final String seaFeverSymptom = "seaFeverSymptom";
    public static final String seaRash = "seaRash";
    public static final String seaItch = "seaItch";
    public static final String seaRashFirst = "seaRashFirst";//multiple
    public static final String seaRashDay = "seaRashDay";
    public static final String seaRashMonth = "seaRashMonth";
    public static final String seaRashYear = "seaRashYear";
    public static final String seaRashDuration = "seaRashDuration";
    public static final String seaRashSpread = "seaRashSpread";
    public static final String seaSpreadPart = "seaSpreadPart";//multiple
    public static final String seaFeverExperience = "seaFeverExperience";
    public static final String seaTempMeasure = "seaTempMeasure";
    public static final String seaHighTemp = "seaHighTemp";
    public static final String seaHightemUnit = "seaHightemUnit";
    public static final String seaTempunknown = "seaTempunknown";
    public static final String seaFeverDay = "seaFeverDay";
    public static final String seaFeverMonth = "seaFeverMonth";
    public static final String seaFeverYear = "seaFeverYear";
    public static final String seaFeverDuration = "seaFeverDuration";
    public static final String seaRedeyes = "seaRedeyes";
    public static final String seaRedeyesDay = "seaRedeyesDay";
    public static final String seaRedeyesMonth = "seaRedeyesMonth";
    public static final String seaRedeyesYear = "seaRedeyesYear";
    public static final String seaRedeyesDuration = "seaRedeyesDuration";
    public static final String seaOccurSame = "seaOccurSame";
    public static final String seaSameSymptom = "seaSameSymptom";//multiple
    public static final String seaJoint = "seaJoint";
    public static final String seaJointDay = "seaJointDay";
    public static final String seaJointMonth = "seaJointMonth";
    public static final String seaJointYear = "seaJointYear";
    public static final String seaJointDuration = "seaJointDuration";
    public static final String seaHeadache = "seaHeadache";
    public static final String seaHeadacheDay = "seaHeadacheDay";
    public static final String seaHeadacheMonth = "seaHeadacheMonth";
    public static final String seaHeadacheYear = "seaHeadacheYear";
    public static final String seaHeadacheDuration = "seaHeadacheDuration";
    public static final String seaSymptomOther = "seaSymptomOther";
    public static final String seaSpecifySymptom = "seaSpecifySymptom";//multiple
    public static final String seaOtherSymptom = "seaOtherSymptom";
    public static final String seaMedicare = "seaMedicare";
    public static final String seaCareDay = "seaCareDay";
    public static final String seaCareMonth = "seaCareMonth";
    public static final String seaCareYear = "seaCareYear";
    public static final String seaCareFacility = "seaCareFacility";
    public static final String seaHospitalized = "seaHospitalized";
    public static final String seaHospital = "seaHospital";
    public static final String seaDiagRubella = "seaDiagRubella";
    public static final String seaDiagDengue = "seaDiagDengue";
    public static final String seaDiagChikung = "seaDiagChikung";
    public static final String seaDiagZika = "seaDiagZika";
    public static final String seaDiagCytome = "seaDiagCytome";
    public static final String seaMedicine = "seaMedicine";
    public static final String seaMedcineName = "seaMedcineName";
    public static final String seaGuillainbarre = "seaGuillainbarre";
    public static final String seaTingling = "seaTingling";
    public static final String seaTinglingArm = "seaTinglingArm";//multiple
    public static final String seaTinglingLeg = "seaTinglingLeg";//multiple
    public static final String seaTinglingHand = "seaTinglingHand";//multiple
    public static final String seaTinglingFoot = "seaTinglingFoot";//multiple
    public static final String seaTinglingFace = "seaTinglingFace";//multiple
    public static final String seaTinglingOther = "seaTinglingOther";//multiple
    public static final String seaSensationMin = "seaSensationMin";
    public static final String seaSensationHr = "seaSensationHr";
    public static final String seaSenstaionDay = "seaSenstaionDay";
    public static final String seaInjury = "seaInjury";
    public static final String seaTinglingDay = "seaTinglingDay";
    public static final String seaTinglingMonth = "seaTinglingMonth";
    public static final String seaTinglingYear = "seaTinglingYear";
    public static final String seaTinglingDuration = "seaTinglingDuration";
    public static final String seaNumbness = "seaNumbness";
    public static final String seaNumbArm = "seaNumbArm";//multiple
    public static final String seaNumbLeg = "seaNumbLeg";//multiple
    public static final String seaNumbHand = "seaNumbHand";//multiple
    public static final String seaNumbFoot = "seaNumbFoot";//multiple
    public static final String seaNumbFace = "seaNumbFace";//multiple
    public static final String seaNumbOther = "seaNumbOther";
    public static final String seaNumbDay = "seaNumbDay";
    public static final String seaNumbMonth = "seaNumbMonth";
    public static final String seaNumbYear = "seaNumbYear";
    public static final String seaNumbDuration = "seaNumbDuration";
    public static final String seaParalysis = "seaParalysis";
    public static final String seaParaArm = "seaParaArm";//multiple
    public static final String seaParaLeg = "seaParaLeg";//multiple
    public static final String seaParaHand = "seaParaHand";//multiple
    public static final String seaParaFoot = "seaParaFoot";//multiple
    public static final String seaParaFace = "seaParaFace";//multiple
    public static final String seaParaOther = "seaParaOther";
    public static final String seaParaDay = "seaParaDay";
    public static final String seaParaMonth = "seaParaMonth";
    public static final String seaParaYear = "seaParaYear";
    public static final String seaParaDuration = "seaParaDuration";

    //Crar tabla Zp01StudyEntrySectionE
    public static final String CREATE_STUDYENTRY_E_TABLE = "create table if not exists "
            + STUDYENTRY_E_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + seaDiseases + " text, "
            + seaOtherSpecify + " text, "
            + seaHepatitis + " text, "
            + seaHepatitisDate1  + " date, "
            + seaHepatitisDate2 + " date, "
            + seaHepatitisDate3 + " date, "
            + seaMeasles + " text, "
            + seaMeaslesDate1  + " date, "
            + seaMeaslesDate2  + " date, "
            + seaMeaslesDate3  + " date, "
            + seaChickenpox  + " text, "
            + seaChickenpoxDate1 + " date, "
            + seaChickenpoxDate2 + " date, "
            + seaChickenpoxDate3 + " date, "
            + seaInfluenza + " text, "
            + seaInfluenzaDate1 + " date, "
            + seaInfluenzaDate2 + " date, "
            + seaInfluenzaDate3 + " date, "
            + seaYellow + " text, "
            + seaYellowDate1 + " date, "
            + seaYellowDate2 + " date, "
            + seaYellowDate3 + " date, "
            + seaDengue + " text, "
            + seaDengueDate1 + " date, "
            + seaDengueDate2  + " date, "
            + seaDengueDate3 + " date, "
            + seaVacOther + " text, "
            + seaVacotherSpecify + " text, "
            + seaOtherDate1 + " date, "
            + seaOtherDate2 + " date, "
            + seaOtherDate3 + " date, "
            + seaRubella + " text, "
            + seaRubellaDate1 + " date, "
            + seaRubellaDate2 + " date, "
            + seaRubellaDate3 + " date, "
            + seaRubellaDoc + " text, "
            + seaCmv + " text, "
            + seaCmvDate1 + " date, "
            + seaCmvDate2 + " date, "
            + seaCmvDate3 + " date, "
            + seaCmvDoc + " text, "
            + seaHerpes + " text, "
            + seaHerpesDate1 + " date, "
            + seaHerpesDate2 + " date, "
            + seaHerpesDate3 + " date, "
            + seaHerpesDoc + " text, "
            + seaParvovirus + " text, "
            + seaParvovirusDate1 + " date, "
            + seaParvovirusDate2 + " date, "
            + seaParvovirusDate3 + " date, "
            + seaParvovirusDoc + " text, "
            + seaToxoplasmosis + " text, "
            + seaToxoplasmosisDate1 + " date, "
            + seaToxoplasmosisDate2 + " date, "
            + seaToxoplasmosisDate3 + " date, "
            + seaToxoplasmosisDoc + " text, "
            + seaSyphillis + " text, "
            + seaSyphillisDate1 + " date, "
            + seaSyphillisDate2 + " date, "
            + seaSyphillisDate3 + " date, "
            + seaSyphillisDoc + " text, "
            + seaHiv + " text, "
            + seaHivDate1 + " date, "
            + seaHivDate2 + " date, "
            + seaHivDate3 + " date, "
            + seaHivDoc + " text, "
            + seaZika + " text, "
            + seaZikaDate1 + " date, "
            + seaZikaDate2 + " date, "
            + seaZikaDate3 + " date, "
            + seaZikaDoc + " text, "
            + seaChikung + " text, "
            + seaChikungDate1 + " date, "
            + seaChikungDate2 + " date, "
            + seaChikungDate3 + " date, "
            + seaChikungDoc + " text, "
            + seaInfluInfect + " text, "
            + seaInflueInfectDate1 + " date, "
            + seaInfluInfectDate2 + " date, "
            + seaInfluInfectDate3 + " date, "
            + seaInfluInfectDoc + " text, "
            + seaDengueInfect + " text, "
            + seaDengueInfectDate1 + " date, "
            + seaDengueInfectDate2 + " date, "
            + seaDengueInfectDate3 + " date, "
            + seaDengueInfectDoc + " text, "
            + seaFeverSymptom + " text, "
            + seaRash + " text, "
            + seaItch + " text, "
            + seaRashFirst + " text, "
            + seaRashDay + " text, "
            + seaRashMonth + " text, "
            + seaRashYear + " text, "
            + seaRashDuration + " integer, "
            + seaRashSpread + " text, "
            + seaSpreadPart + " text, "
            + seaFeverExperience + " text, "
            + seaTempMeasure + " text, "
            + seaHighTemp + " real, "
            + seaHightemUnit + " text, "
            + seaTempunknown + " text, "
            + seaFeverDay + " text, "
            + seaFeverMonth + " text, "
            + seaFeverYear + " text, "
            + seaFeverDuration + " integer, "
            + seaRedeyes + " text, "
            + seaRedeyesDay + " text, "
            + seaRedeyesMonth + " text, "
            + seaRedeyesYear + " text, "
            + seaRedeyesDuration + " integer, "
            + seaOccurSame + " text, "
            + seaSameSymptom + " text, "
            + seaJoint + " text, "
            + seaJointDay + " text, "
            + seaJointMonth + " text, "
            + seaJointYear + " text, "
            + seaJointDuration + " integer, "
            + seaHeadache + " text, "
            + seaHeadacheDay + " text, "
            + seaHeadacheMonth + " text, "
            + seaHeadacheYear + " text, "
            + seaHeadacheDuration + " integer, "
            + seaSymptomOther + " text, "
            + seaSpecifySymptom + " text, "
            + seaOtherSymptom + " text, "
            + seaMedicare + " text, "
            + seaCareDay + " text, "
            + seaCareMonth + " text, "
            + seaCareYear + " text, "
            + seaCareFacility + " text, "
            + seaHospitalized + " text, "
            + seaHospital + " text, "
            + seaDiagRubella + " text, "
            + seaDiagDengue + " text, "
            + seaDiagChikung + " text, "
            + seaDiagZika + " text, "
            + seaDiagCytome + " text, "
            + seaMedicine + " text, "
            + seaMedcineName + " text, "
            + seaGuillainbarre + " text, "
            + seaTingling + " text, "
            + seaTinglingArm + " text, "
            + seaTinglingLeg + " text, "
            + seaTinglingHand + " text, "
            + seaTinglingFoot + " text, "
            + seaTinglingFace + " text, "
            + seaTinglingOther + " text, "
            + seaSensationMin + " text, "
            + seaSensationHr + " text, "
            + seaSenstaionDay + " text, "
            + seaInjury + " text, "
            + seaTinglingDay + " text, "
            + seaTinglingMonth + " text, "
            + seaTinglingYear + " text, "
            + seaTinglingDuration + " integer, "
            + seaNumbness + " text, "
            + seaNumbArm + " text, "
            + seaNumbLeg + " text, "
            + seaNumbHand + " text, "
            + seaNumbFoot + " text, "
            + seaNumbFace + " text, "
            + seaNumbOther + " text, "
            + seaNumbDay + " text, "
            + seaNumbMonth + " text, "
            + seaNumbYear + " text, "
            + seaNumbDuration + " integer, "
            + seaParalysis + " text, "
            + seaParaArm + " text, "
            + seaParaLeg + " text, "
            + seaParaHand + " text, "
            + seaParaFoot + " text, "
            + seaParaFace + " text, "
            + seaParaOther + " text, "
            + seaParaDay + " text, "
            + seaParaMonth + " text, "
            + seaParaYear + " text, "
            + seaParaDuration + " integer, "
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

    //Tabla Zp01StudyEntrySectionFtoK
    public static final String STUDYENTRY_FK_TABLE = "zp01_study_entry_section_f_to_k";

    //Campos Zp01StudyEntrySectionFtoK
    public static final String seaPreg = "seaPreg";
    public static final String seaFirstPreg = "seaFirstPreg";
    public static final String seaAnemia = "seaAnemia";
    public static final String seaVaginal = "seaVaginal";
    public static final String seaUtiPrior = "seaUtiPrior";
    public static final String seaSexually = "seaSexually";
    public static final String seaPreterm = "seaPreterm";
    public static final String seaPreeclampsia = "seaPreeclampsia";
    public static final String seaEclampsia = "seaEclampsia";
    public static final String seaHeart = "seaHeart";
    public static final String seaNeuropathy = "seaNeuropathy";
    public static final String seaGestational = "seaGestational";
    public static final String seaTotalPreg = "seaTotalPreg";
    public static final String seaDeliveryDate1 = "seaDeliveryDate1";
    public static final String seaGage1 = "seaGage1";
    public static final String seaOutcome1 = "seaOutcome1";
    public static final String seaBdefects1 = "seaBdefects1";
    public static final String seaDeliveryDate2 = "seaDeliveryDate2";
    public static final String seaGage2 = "seaGage2";
    public static final String seaOutcome2 = "seaOutcome2";
    public static final String seaBdefects2 = "seaBdefects2";
    public static final String seaDeliveryDate3 = "seaDeliveryDate3";
    public static final String seaGage3 = "seaGage3";
    public static final String seaOutcome3 = "seaOutcome3";
    public static final String seaBdefects3 = "seaBdefects3";
    public static final String seaDeliveryDate4 = "seaDeliveryDate4";
    public static final String seaGage4 = "seaGage4";
    public static final String seaOutcome4 = "seaOutcome4";
    public static final String seaBdefects4 = "seaBdefects4";
    public static final String seaDeliveryDate5 = "seaDeliveryDate5";
    public static final String seaGage5 = "seaGage5";
    public static final String seaOutcome5 = "seaOutcome5";
    public static final String seaBdefects5 = "seaBdefects5";
    public static final String seaDeliveryDate6 = "seaDeliveryDate6";
    public static final String seaGage6 = "seaGage6";
    public static final String seaOutcome6 = "seaOutcome6";
    public static final String seaBdefects6 = "seaBdefects6";
    public static final String seaPersisHeadache = "seaPersisHeadache";
    public static final String seaDizziness = "seaDizziness";
    public static final String seaNausea = "seaNausea";
    public static final String seaVomiting = "seaVomiting";
    public static final String seaSeeingLights = "seaSeeingLights";
    public static final String seaSpecifyType = "seaSpecifyType";
    public static final String seaSwelling = "seaSwelling";
    public static final String seaFetalMov = "seaFetalMov";
    public static final String seaMovUsual = "seaMovUsual";
    public static final String seaMovDecreased = "seaMovDecreased";
    public static final String seaContraction = "seaContraction";
    public static final String seaFreqWeek = "seaFreqWeek";
    public static final String seaFreqDay = "seaFreqDay";
    public static final String seaFreqHour = "seaFreqHour";
    public static final String seaFreqMin = "seaFreqMin";
    public static final String seaVagiDischarge = "seaVagiDischarge";
    public static final String seaCharacterDisch = "seaCharacterDisch";
    public static final String seaBleeding = "seaBleeding";
    public static final String seaYesBleeding = "seaYesBleeding";
    public static final String seaUti = "seaUti";
    public static final String seaPrenatalCare = "seaPrenatalCare";
    public static final String seaMutiv = "seaMutiv";
    public static final String seaIron = "seaIron";
    public static final String seaOften = "seaOften";
    public static final String seaProvideSym = "seaProvideSym";
    public static final String seaReminderPreg = "seaReminderPreg";
    public static final String seaReminderProvided = "seaReminderProvided";
    public static final String seaOneweekDate = "seaOneweekDate";
    public static final String seaOneweekTime = "seaOneweekTime";
    public static final String seaNextDate = "seaNextDate";
    public static final String seaNextTime = "seaNextTime";
    public static final String seaIdCompleting = "seaIdCompleting";
    public static final String seaDateCompleted = "seaDateCompleted";
    public static final String seaIdReviewer = "seaIdReviewer";
    public static final String seaDateReviewed = "seaDateReviewed";
    public static final String seaIdDataEntry = "seaIdDataEntry";
    public static final String seaDateEntered = "seaDateEntered";

    //Crear tabla Zp01StudyEntrySectionFtoK

    public static final String CREATE_STUDYENTRY_FK_TABLE = "create table if not exists "
            + STUDYENTRY_FK_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + seaPreg + " text, "
            + seaFirstPreg + " text, "
            + seaAnemia + " text, "
            + seaVaginal  + " text, "
            + seaUtiPrior + " text, "
            + seaSexually + " text, "
            + seaPreterm + " text, "
            + seaPreeclampsia  + " text, "
            + seaEclampsia  + " text, "
            + seaHeart  + " text, "
            + seaNeuropathy  + " text, "
            + seaGestational + " text, "
            + seaTotalPreg + " integer, "
            + seaDeliveryDate1 + " date, "
            + seaGage1 + " integer, "
            + seaOutcome1 + " text, "
            + seaBdefects1 + " text, "
            + seaDeliveryDate2 + " date, "
            + seaGage2 + " integer, "
            + seaOutcome2 + " text, "
            + seaBdefects2 + " text, "
            + seaDeliveryDate3 + " date, "
            + seaGage3 + " integer, "
            + seaOutcome3 + " text, "
            + seaBdefects3  + " text, "
            + seaDeliveryDate4 + " date, "
            + seaGage4 + " integer, "
            + seaOutcome4 + " text, "
            + seaBdefects4 + " text, "
            + seaDeliveryDate5 + " date, "
            + seaGage5 + " integer, "
            + seaOutcome5 + " text, "
            + seaBdefects5 + " text, "
            + seaDeliveryDate6 + " text, "
            + seaGage6 + " text, "
            + seaOutcome6 + " text, "
            + seaBdefects6 + " text, "
            + seaPersisHeadache + " text, "
            + seaDizziness + " real, "
            + seaNausea + " text, "
            + seaVomiting + " text, "
            + seaSeeingLights + " text, "
            + seaSpecifyType + " text, "
            + seaSwelling + " text, "
            + seaFetalMov + " text, "
            + seaMovUsual + " text, "
            + seaMovDecreased + " text, "
            + seaContraction + " text, "
            + seaFreqWeek + " integer, "
            + seaFreqDay + " integer, "
            + seaFreqHour + " integer, "
            + seaFreqMin + " integer, "
            + seaVagiDischarge  + " text, "
            + seaCharacterDisch + " text, "
            + seaBleeding + " text, "
            + seaYesBleeding + " text, "
            + seaUti + " text, "
            + seaPrenatalCare + " text, "
            + seaMutiv + " text, "
            + seaIron + " text, "
            + seaOften + " text, "
            + seaProvideSym + " text, "
            + seaReminderPreg + " text, "
            + seaReminderProvided + " text, "
            + seaOneweekDate + " date, "
            + seaOneweekTime + " date, "
            + seaNextDate + " date, "
            + seaNextTime + " date, "
            + seaIdCompleting + " text, "
            + seaDateCompleted + " text, "
            + seaIdReviewer + " text, "
            + seaDateReviewed + " text, "
            + seaIdDataEntry + " text, "
            + seaDateEntered + " text, "
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
