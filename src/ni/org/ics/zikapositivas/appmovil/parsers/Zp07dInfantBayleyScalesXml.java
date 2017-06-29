package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by ics on 20/6/2017.
 */
public class Zp07dInfantBayleyScalesXml {

    @Element(required = false)
    private Date infantVisitdt;
    @Element(required = false)
    private String infantDone;
    @Element(required = false)
    private String infantReaNot;
    @Element(required = false)
    private String infantNreaOther;
    @Element(required = false)
    private Date infantPerfdt;
    @Element(required = false)
    private String infantEnglish;
    @Element(required = false)
    private String infantPrilanguage;
    @Element(required = false)
    private String infantParentlan;
    @Element(required = false)
    private String infantBayenglish;
    @Element(required = false)
    private String infantMed;
    @Element(required = false)
    private String infantMedDay;
    @Element(required = false)
    private String infantTypMed;
    @Element(required = false)
    private String infantCoguAttem;
    @Element(required = false)
    private String infantCograScore;
    @Element(required = false)
    private String infantCogscScore;
    @Element(required = false)
    private String infantCogcoScore;
    @Element(required = false)
    private String infantCogValid;
    @Element(required = false)
    private String infantReaInvali;
    @Element(required = false)
    private String infantInvaOther;
    @Element(required = false)
    private String infantResAtte;
    @Element(required = false)
    private String infantRetoScore;
    @Element(required = false)
    private String infantRescScore;
    @Element(required = false)
    private String infantExsuAtte;
    @Element(required = false)
    private String infantExtoScore;
    @Element(required = false)
    private String infantExscScore;
    @Element(required = false)
    private String infantSuScore;
    @Element(required = false)
    private String infantSucomScore;
    @Element(required = false)
    private String infantLangValid;
    @Element(required = false)
    private String infantRelanInvalid;
    @Element(required = false)
    private String infantRelanOther;
    @Element(required = false)
    private String infantFmsAtte;
    @Element(required = false)
    private String infantFmtoScore;
    @Element(required = false)
    private String infantFmscScore;
    @Element(required = false)
    private String infantGmsuattm;
    @Element(required = false)
    private String infantGmtoScore;
    @Element(required = false)
    private String infantGmscScore;
    @Element(required = false)
    private String infantMssuScore;
    @Element(required = false)
    private String infantMscoscore;
    @Element(required = false)
    private String infantMtValid;
    @Element(required = false)
    private String infantMtInvalid;
    @Element(required = false)
    private String infantMtinvOther;
    @Element(required = false)
    private String infantSesAtte;
    @Element(required = false)
    private String infantSetoSore;
    @Element(required = false)
    private String infantSescScre;
    @Element(required = false)
    private String infantSecoScre;
    @Element(required = false)
    private String infantSemoValid;
    @Element(required = false)
    private String infantSemoInvalid;
    @Element(required = false)
    private String infantSemoinvOther;
    @Element(required = false)
    private String infantCog76;
    @Element(required = false)
    private String infantCircuEvalu;
    @Element(required = false)
    private String infantExplain;
    @Element(required = false)
    private String infantBaidCom;
    @Element(required = false)
    private Date infantBadtCom;
    @Element(required = false)
    private String infantBaeyeIdRevi;
    @Element(required = false)
    private Date infantBadtRevi;
    @Element(required = false)
    private String infantBaidEntry;
    @Element(required = false)
    private Date infantBadtEnt;


    @Element(required = false)
    private String group1;
    @Element(required = false)
    private String group2;
    @Element(required = false)
    private String group3;
    @Element(required = false)
    private String group4;
    @Element(required = false)
    private String group5;
    @Element(required = false)
    private String group6;
    @Element(required = false)
    private String group7;
    @Element(required = false)
    private String group8;
    @Element(required = false)
    private String group9;
    @Element(required = false)
    private String group10;
    @Element(required = false)
    private String group11;
    @Element(required = false)
    private String group12;

    @Element(required = false)
    private String note1;

    @Attribute
    private String id;
    @Attribute(required = false)
    private String version;
    @Element(required = false)
    private Meta meta;

    @Element(required = false)
    private String start;
    @Element(required = false)
    private String end;
    @Element(required = false)
    private String deviceid;
    @Element(required = false)
    private String simserial;
    @Element(required = false)
    private String phonenumber;
    @Element(required = false)
    private String imei;
    @Element(required = false)
    private Date today;


    public Date getInfantVisitdt() {
        return infantVisitdt;
    }

    public String getInfantDone() {
        return infantDone;
    }

    public String getInfantReaNot() {
        return infantReaNot;
    }

    public String getInfantNreaOther() {
        return infantNreaOther;
    }

    public Date getInfantPerfdt() {
        return infantPerfdt;
    }

    public String getInfantEnglish() {
        return infantEnglish;
    }

    public String getInfantPrilanguage() {
        return infantPrilanguage;
    }

    public String getInfantParentlan() {
        return infantParentlan;
    }

    public String getInfantBayenglish() {
        return infantBayenglish;
    }

    public String getInfantMed() {
        return infantMed;
    }

    public String getInfantMedDay() {
        return infantMedDay;
    }

    public String getInfantTypMed() {
        return infantTypMed;
    }

    public String getInfantCoguAttem() {
        return infantCoguAttem;
    }

    public String getInfantCograScore() {
        return infantCograScore;
    }

    public String getInfantCogscScore() {
        return infantCogscScore;
    }

    public String getInfantCogcoScore() {
        return infantCogcoScore;
    }

    public String getInfantCogValid() {
        return infantCogValid;
    }

    public String getInfantReaInvali() {
        return infantReaInvali;
    }

    public String getInfantInvaOther() {
        return infantInvaOther;
    }

    public String getInfantResAtte() {
        return infantResAtte;
    }

    public String getInfantRetoScore() {
        return infantRetoScore;
    }

    public String getInfantRescScore() {
        return infantRescScore;
    }

    public String getInfantExsuAtte() {
        return infantExsuAtte;
    }

    public String getInfantExtoScore() {
        return infantExtoScore;
    }

    public String getInfantExscScore() {
        return infantExscScore;
    }

    public String getInfantSuScore() {
        return infantSuScore;
    }

    public String getInfantSucomScore() {
        return infantSucomScore;
    }

    public String getInfantLangValid() {
        return infantLangValid;
    }

    public String getInfantRelanInvalid() {
        return infantRelanInvalid;
    }

    public String getInfantRelanOther() {
        return infantRelanOther;
    }

    public String getInfantFmsAtte() {
        return infantFmsAtte;
    }

    public String getInfantFmtoScore() {
        return infantFmtoScore;
    }

    public String getInfantFmscScore() {
        return infantFmscScore;
    }

    public String getInfantGmsuattm() {
        return infantGmsuattm;
    }

    public String getInfantGmtoScore() {
        return infantGmtoScore;
    }

    public String getInfantGmscScore() {
        return infantGmscScore;
    }

    public String getInfantMssuScore() {
        return infantMssuScore;
    }

    public String getInfantMscoscore() {
        return infantMscoscore;
    }

    public String getInfantMtValid() {
        return infantMtValid;
    }

    public String getInfantMtInvalid() {
        return infantMtInvalid;
    }

    public String getInfantMtinvOther() {
        return infantMtinvOther;
    }

    public String getInfantSesAtte() {
        return infantSesAtte;
    }

    public String getInfantSetoSore() {
        return infantSetoSore;
    }

    public String getInfantSescScre() {
        return infantSescScre;
    }

    public String getInfantSecoScre() {
        return infantSecoScre;
    }

    public String getInfantSemoValid() {
        return infantSemoValid;
    }

    public String getInfantSemoInvalid() {
        return infantSemoInvalid;
    }

    public String getInfantSemoinvOther() {
        return infantSemoinvOther;
    }

    public String getInfantCog76() {
        return infantCog76;
    }

    public String getInfantCircuEvalu() {
        return infantCircuEvalu;
    }

    public String getInfantExplain() {
        return infantExplain;
    }

    public String getInfantBaidCom() {
        return infantBaidCom;
    }

    public Date getInfantBadtCom() {
        return infantBadtCom;
    }

    public String getInfantBaeyeIdRevi() {
        return infantBaeyeIdRevi;
    }

    public Date getInfantBadtRevi() {
        return infantBadtRevi;
    }

    public String getInfantBaidEntry() {
        return infantBaidEntry;
    }

    public Date getInfantBadtEnt() {
        return infantBadtEnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getSimserial() {
        return simserial;
    }

    public void setSimserial(String simserial) {
        this.simserial = simserial;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }
}
