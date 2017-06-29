package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07dDBConstants {

    //Tabla Zp07dInfantBayleyScales
    public static final String DINFANT_BAYLEYSCALES_TABLE = "zp07d_infant_bayley_scales";

    //Campos Zp07dInfantBayleyScales
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String infantVisitdt = "infantVisitdt";
    public static final String infantDone = "infantDone";
    public static final String infantReaNot = "infantReaNot";
    public static final String infantNreaOther = "infantNreaOther";
    public static final String infantPerfdt = "infantPerfdt";
    public static final String infantEnglish = "infantEnglish";
    public static final String infantPrilanguage = "infantPrilanguage";
    public static final String infantParentlan = "infantParentlan";
    public static final String infantBayenglish = "infantBayenglish";
    public static final String infantMed = "infantMed";
    public static final String infantMedDay = "infantMedDay";
    public static final String infantTypMed = "infantTypMed";
    public static final String infantCoguAttem = "infantCoguAttem";
    public static final String infantCograScore = "infantCograScore";
    public static final String infantCogscScore = "infantCogscScore";
    public static final String infantCogcoScore = "infantCogcoScore";
    public static final String infantCogValid = "infantCogValid";
    public static final String infantReaInvali = "infantReaInvali";
    public static final String infantInvaOther = "infantInvaOther";
    public static final String infantResAtte = "infantResAtte";
    public static final String infantRetoScore = "infantRetoScore";
    public static final String infantRescScore = "infantRescScore";
    public static final String infantExsuAtte = "infantExsuAtte";
    public static final String infantExtoScore = "infantExtoScore";
    public static final String infantExscScore = "infantExscScore";
    public static final String infantSuScore = "infantSuScore";
    public static final String infantSucomScore = "infantSucomScore";
    public static final String infantLangValid = "infantLangValid";
    public static final String infantRelanInvalid = "infantRelanInvalid";
    public static final String infantRelanOther = "infantRelanOther";
    public static final String infantFmsAtte = "infantFmsAtte";
    public static final String infantFmtoScore = "infantFmtoScore";
    public static final String infantFmscScore = "infantFmscScore";
    public static final String infantGmsuattm = "infantGmsuattm";
    public static final String infantGmtoScore = "infantGmtoScore";
    public static final String infantGmscScore = "infantGmscScore";
    public static final String infantMssuScore = "infantMssuScore";
    public static final String infantMscoscore = "infantMscoscore";
    public static final String infantMtValid = "infantMtValid";
    public static final String infantMtInvalid = "infantMtInvalid";
    public static final String infantMtinvOther = "infantMtinvOther";
    public static final String infantSesAtte = "infantSesAtte";
    public static final String infantSetoSore = "infantSetoSore";
    public static final String infantSescScre = "infantSescScre";
    public static final String infantSecoScre = "infantSecoScre";
    public static final String infantSemoValid = "infantSemoValid";
    public static final String infantSemoInvalid = "infantSemoInvalid";
    public static final String infantSemoinvOther = "infantSemoinvOther";
    public static final String infantCog76 = "infantCog76";
    public static final String infantCircuEvalu = "infantCircuEvalu";
    public static final String infantExplain = "infantExplain";
    public static final String infantBaidCom = "infantBaidCom";
    public static final String infantBadtCom = "infantBadtCom";
    public static final String infantBaeyeIdRevi = "infantBaeyeIdRevi";
    public static final String infantBadtRevi = "infantBadtRevi";
    public static final String infantBaidEntry = "infantBaidEntry";
    public static final String infantBadtEnt = "infantBadtEnt";


    //Crear tabla Zp07dInfantBayleyScales
    public static final String CREATE_DINFANT_BAYLEYSCALES_TABLE = "create table if not exists "
            + DINFANT_BAYLEYSCALES_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "

            + infantVisitdt + " date, "
            + infantDone + " text, "
            + infantReaNot + " text, "
            + infantNreaOther + " text, "
            + infantPerfdt + " date, "
            + infantEnglish + " text, "
            + infantPrilanguage + " text, "
            + infantParentlan + " text, "
            + infantBayenglish + " text, "
            + infantMed + " text, "
            + infantMedDay + " text, "
            + infantTypMed + " text, "
            + infantCoguAttem + " text, "
            + infantCograScore + " text, "
            + infantCogscScore + " text, "
            + infantCogcoScore + " text, "
            + infantCogValid + " text, "
            + infantReaInvali + " text, "
            + infantInvaOther + " text, "
            + infantResAtte + " text, "
            + infantRetoScore + " text, "
            + infantRescScore + " text, "
            + infantExsuAtte + " text, "
            + infantExtoScore + " text, "
            + infantExscScore + " text, "
            + infantSuScore + " text, "
            + infantSucomScore + " text, "
            + infantLangValid + " text, "
            + infantRelanInvalid + " text, "
            + infantRelanOther + " text, "
            + infantFmsAtte + " text, "
            + infantFmtoScore + " text, "
            + infantFmscScore + " text, "
            + infantGmsuattm + " text, "
            + infantGmtoScore + " text, "
            + infantGmscScore + " text, "
            + infantMssuScore + " text, "
            + infantMscoscore + " text, "
            + infantMtValid + " text, "
            + infantMtInvalid + " text, "
            + infantMtinvOther + " text, "
            + infantSesAtte + " text, "
            + infantSetoSore + " text, "
            + infantSescScre + " text, "
            + infantSecoScre + " text, "
            + infantSemoValid + " text, "
            + infantSemoInvalid + " text, "
            + infantSemoinvOther + " text, "
            + infantCog76 + " text, "
            + infantCircuEvalu + " text, "
            + infantExplain + " text, "
            + infantBaidCom + " text, "
            + infantBadtCom + " date, "
            + infantBaeyeIdRevi + " text, "
            + infantBadtRevi + " date, "
            + infantBaidEntry + " text, "
            + infantBadtEnt + " date, "

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
