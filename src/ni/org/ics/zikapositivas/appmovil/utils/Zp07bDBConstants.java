package ni.org.ics.zikapositivas.appmovil.utils;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07bDBConstants {

    //Tabla Zp07bInfantAudioResults
    public static final String BINFANT_AUDIORESULTS_TABLE = "zp07b_infant_audio_results";

    //Campos Zp07bInfantAudioResults
    public static final String recordId = "recordId";
    public static final String redcapEventName = "redcapEventName";
    public static final String infantAudioDate = "infantAudioDate";
    public static final String infantAudioAir = "infantAudioAir";
    public static final String infantAr500rt = "infantAr500rt";
    public static final String infantAr500lft = "infantAr500lft";
    public static final String infantAr500vra = "infantAr500vra";
    public static final String infantAr1000rt = "infantAr1000rt";
    public static final String infantAr1000lft = "infantAr1000lft";
    public static final String infantAr1000vra = "infantAr1000vra";
    public static final String infantAr2000rt = "infantAr2000rt";
    public static final String infantAr2000lft = "infantAr2000lft";
    public static final String infantAr2000vra = "infantAr2000vra";
    public static final String infantAr4000rt = "infantAr4000rt";
    public static final String infantAr4000lft = "infantAr4000lft";
    public static final String infantAr4000vra = "infantAr4000vra";
    public static final String infantTransducer = "infantTransducer";
    public static final String infantAudioBone = "infantAudioBone";
    public static final String infantUnmask1 = "infantUnmask1";
    public static final String infantUnmask2 = "infantUnmask2";
    public static final String infantUnmask3 = "infantUnmask3";
    public static final String infantUnmask4 = "infantUnmask4";
    public static final String infantImtanceRt = "infantImtanceRt";
    public static final String infantImrtReas = "infantImrtReas";
    public static final String infantImrtMl = "infantImrtMl";
    public static final String infantImrtDapa = "infantImrtDapa";
    public static final String infantImrtAdmi = "infantImrtAdmi";
    public static final String infantImrtTym = "infantImrtTym";
    public static final String infantImtanceLt = "infantImtanceLt";
    public static final String infantImltReas = "infantImltReas";
    public static final String infantImltMl = "infantImltMl";
    public static final String infantImltDapa = "infantImltDapa";
    public static final String infantImltAdmi = "infantImltAdmi";
    public static final String infantImltTym = "infantImltTym";
    public static final String infantImltProbe = "infantImltProbe";
    public static final String infantOe = "infantOe";
    public static final String infatnOetype = "infatnOetype";
    public static final String infantOert = "infantOert";
    public static final String infantOertRea = "infantOertRea";
    public static final String infantOert19 = "infantOert19";
    public static final String infantOert29 = "infantOert29";
    public static final String infantOert39 = "infantOert39";
    public static final String infantOert49 = "infantOert49";
    public static final String infantOelt = "infantOelt";
    public static final String infantOeltRea = "infantOeltRea";
    public static final String infantOelt19 = "infantOelt19";
    public static final String infantOelt29 = "infantOelt29";
    public static final String infantOelt39 = "infantOelt39";
    public static final String infantOelt49 = "infantOelt49";
    public static final String infantAbr = "infantAbr";
    public static final String infantAb500rt = "infantAb500rt";
    public static final String infantAb500lt = "infantAb500lt";
    public static final String infantAb1000rt = "infantAb1000rt";
    public static final String infantAb1000lt = "infantAb1000lt";
    public static final String infantAb2000rt = "infantAb2000rt";
    public static final String infantAb2000lt = "infantAb2000lt";
    public static final String infantEarphone = "infantEarphone";
    public static final String infantImpress = "infantImpress";
    public static final String infantTypeRt = "infantTypeRt";
    public static final String infantTypeLt = "infantTypeLt";
    public static final String infantTypeSound = "infantTypeSound";
    public static final String infantExtentRt = "infantExtentRt";
    public static final String infantExtentLt = "infantExtentLt";
    public static final String infantExtentSound = "infantExtentSound";
    public static final String infantConfigRt = "infantConfigRt";
    public static final String infantConfigLt = "infantConfigLt";
    public static final String infantConfigSound = "infantConfigSound";
    public static final String infantExamReliable = "infantExamReliable";
    public static final String infantRenotReliable = "infantRenotReliable";
    public static final String infantNreliableOther = "infantNreliableOther";
    public static final String infantAutocom = "infantAutocom";
    public static final String infantComAudo = "infantComAudo";
    public static final String infantAuLne = "infantAuLne";
    public static final String infantAuFne = "infantAuFne";
    public static final String infantAuPhone = "infantAuPhone";
    public static final String infantAuSignat = "infantAuSignat";
    public static final String infantAuDate = "infantAuDate";
    public static final String infantAuidCom = "infantAuidCom";
    public static final String infantAudtCom = "infantAudtCom";
    public static final String infantAueyeIdRevi = "infantAueyeIdRevi";
    public static final String infantAudtRevi = "infantAudtRevi";
    public static final String infantAuidEntry = "infantAuidEntry";
    public static final String infantAudtEnt = "infantAudtEnt";

    //Crear tabla Zp07bInfantAudioResults
    public static final String CREATE_BINFANT_AUDIORESULTS_TABLE = "create table if not exists "
            + BINFANT_AUDIORESULTS_TABLE + " ("
            + recordId + " text not null, "
            + redcapEventName + " text, "
            + infantAudioDate + " date, "
            + infantAudioAir + " text, "
            + infantAr500rt + " text, "
            + infantAr500lft + " text, "
            + infantAr500vra + " text, "
            + infantAr1000rt + " text, "
            + infantAr1000lft + " text, "
            + infantAr1000vra + " text, "
            + infantAr2000rt + " text, "
            + infantAr2000lft + " text, "
            + infantAr2000vra + " text, "
            + infantAr4000rt + " text, "
            + infantAr4000lft + " text, "
            + infantAr4000vra + " text, "
            + infantTransducer + " text, "
            + infantAudioBone + " text, "
            + infantUnmask1 + " text, "
            + infantUnmask2 + " text, "
            + infantUnmask3 + " text, "
            + infantUnmask4 + " text, "
            + infantImtanceRt + " text, "
            + infantImrtReas + " text, "
            + infantImrtMl + " real, "
            + infantImrtDapa + " text, "
            + infantImrtAdmi + " real, "
            + infantImrtTym + " text, "
            + infantImtanceLt + " text, "
            + infantImltReas + " text, "
            + infantImltMl + " real, "
            + infantImltDapa + " text, "
            + infantImltAdmi + " real, "
            + infantImltTym + " text, "
            + infantImltProbe + " text, "
            + infantOe + " text, "
            + infatnOetype + " text, "
            + infantOert + " text, "
            + infantOertRea + " text, "
            + infantOert19 + " text, "
            + infantOert29 + " text, "
            + infantOert39 + " text, "
            + infantOert49 + " text, "
            + infantOelt + " text, "
            + infantOeltRea + " text, "
            + infantOelt19 + " text, "
            + infantOelt29 + " text, "
            + infantOelt39 + " text, "
            + infantOelt49 + " text, "
            + infantAbr + " text, "
            + infantAb500rt + " text, "
            + infantAb500lt + " text, "
            + infantAb1000rt + " text, "
            + infantAb1000lt + " text, "
            + infantAb2000rt + " text, "
            + infantAb2000lt + " text, "
            + infantEarphone + " text, "
            + infantImpress + " text, "
            + infantTypeRt + " text, "
            + infantTypeLt + " text, "
            + infantTypeSound + " text, "
            + infantExtentRt + " text, "
            + infantExtentLt + " text, "
            + infantExtentSound + " text, "
            + infantConfigRt + " text, "
            + infantConfigLt + " text, "
            + infantConfigSound + " text, "
            + infantExamReliable + " text, "
            + infantRenotReliable + " text, "
            + infantNreliableOther + " text, "
            + infantAutocom + " text, "
            + infantComAudo + " text, "
            + infantAuLne + " text, "
            + infantAuFne + " text, "
            + infantAuPhone + " integer, "
            + infantAuSignat + " text, "
            + infantAuDate + " date, "
            + infantAuidCom + " text, "
            + infantAudtCom + " date, "
            + infantAueyeIdRevi + " text, "
            + infantAudtRevi + " date, "
            + infantAuidEntry + " text, "
            + infantAudtEnt + " date, "


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
