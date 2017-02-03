package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 2/2/2017.
 * V1.0
 */
public class Zp07InfantAssessmentVisitXml {

    @Element(required=false)
    private Date infantVisitDate;
    @Element(required=false)
    private String infantStatus;
    @Element(required=false)
    private String infantVisit;
    @Element(required=false)
    private Float infantTemp;
    @Element(required=false)
    private String infantTmpUnit;
    @Element(required=false)
    private Float infantWt;
    @Element(required=false)
    private String infantWtUnit;
    @Element(required=false)
    private Float infantWtPercen;
    @Element(required=false)
    private String infantWtpercenNa;
    @Element(required=false)
    private Float infantLength;
    @Element(required=false)
    private Float infantLengthPercen;
    @Element(required=false)
    private String infantLenpercenNa;
    @Element(required=false)
    private Float infantHeadcircu;
    @Element(required=false)
    private Float infantHeapercen;
    @Element(required=false)
    private String infantHeapercenNa;
    @Element(required=false)
    private String infantReferralNeuro;
    @Element(required=false)
    private String infantApgarNa;
    @Element(required=false)
    private Float infantApgar1min;
    @Element(required=false)
    private Float infantApgar5min;
    @Element(required=false)
    private String infantSkinEvalu;
    @Element(required=false)
    private String infantRash;
    @Element(required=false)
    private String infantScarring;
    @Element(required=false)
    private String infantOrganEvalu;
    @Element(required=false)
    private String infantAbdominal;
    @Element(required=false)
    private String infantLiverSpleen;
    @Element(required=false)
    private String infantOphth;
    @Element(required=false)
    private String infantOphthAbno;
    @Element(required=false)
    private String infantWhichEye;//multiple
    @Element(required=false)
    private String infantEyeCalci;
    @Element(required=false)
    private String infantChoriore;
    @Element(required=false)
    private String infantEyeOther;
    @Element(required=false)
    private String infantOtherIssue;//multiple
    @Element(required=false)
    private String infantEyeOtherSpecify;
    @Element(required=false)
    private String infantReferralOphth;
    @Element(required=false)
    private String infantOae;
    @Element(required=false)
    private String infantOaeAbnormal;
    @Element(required=false)
    private String infantWhichEar; //multiple
    @Element(required=false)
    private String infantReferralAudio;
    @Element(required=false)
    private String infantAdditionalAudio;
    @Element(required=false)
    private Float infatnHearLeft;
    @Element(required=false)
    private Float infantHearRight;
    @Element(required=false)
    private String infantBreastfeeding;
    @Element(required=false)
    private String infantBreastReason;//multiple
    @Element(required=false)
    private String infantBreastOther;
    @Element(required=false)
    private String infantNeurodeve;
    @Element(required=false)
    private String infantNeurodeveType;//multiple
    @Element(required=false)
    private String infantOtherSpecify;
    @Element(required=false)
    private String infantExhibited; //multiple
    @Element(required=false)
    private String infantOtherMovement;
    @Element(required=false)
    private String infantFurtherNeuro;
    @Element(required=false)
    private String infantHeadAltra;
    @Element(required=false)
    private String infantUltraObtained;
    @Element(required=false)
    private Date infantUltraDt;
    @Element(required=false)
    private String infantResultsUltra;
    @Element(required=false)
    private String infantResultsSpecify;
    @Element(required=false)
    private String infantHeadCt;
    @Element(required=false)
    private String infantCtObtained;
    @Element(required=false)
    private Date infantCtDt;
    @Element(required=false)
    private String infantResultsCt;
    @Element(required=false)
    private String infantCtSpecify;
    @Element(required=false)
    private String infantCerebrospinal;
    @Element(required=false)
    private String infantCerebroStored;
    @Element(required=false)
    private Date infantCerebroDt;
    @Element(required=false)
    private Float infantCerebroAmount;
    @Element(required=false)
    private String infantResultsCerebro;
    @Element(required=false)
    private String infantCerebroSpecify;
    @Element(required=false)
    private String infantMri;
    @Element(required=false)
    private String infantMriObtained;
    @Element(required=false)
    private Date infantMriDt;
    @Element(required=false)
    private String infantResultsMri;
    @Element(required=false)
    private String infantMriSpecify;
    @Element(required=false)
    private String infantPreviousResults;
    @Element(required=false)
    private String infantReferrCounselling;
    @Element(required=false)
    private String infantOtherLabCollect;
    @Element(required=false)
    private String infantIdCompleting;
    @Element(required=false)
    private Date infantDateCompleted;
    @Element(required=false)
    private String infantIdReviewer;
    @Element(required=false)
    private Date infantDateReviewed;
    @Element(required=false)
    private String infantIdDataEntry;
    @Element(required=false)
    private Date infantDateEntered;

    @Element(required=false)
    private String group1;
    @Element(required=false)
    private String group2;
    @Element(required=false)
    private String group3;
    @Element(required=false)
    private String group4;
    @Element(required=false)
    private String group5;
    @Element(required=false)
    private String group6;
    @Element(required=false)
    private String group7;
    @Element(required=false)
    private String group8;

    @Element(required=false)
    private String note1;
    @Element(required=false)
    private String note2;

    @Element(required=false)
    private String question1;
    @Element(required=false)
    private String question2;
    @Element(required=false)
    private String question3;

    @Attribute
    private String id;
    @Attribute(required = false)
    private String version;
    @Element(required=false)
    private Meta meta;

    @Element(required=false)
    private String start;
    @Element(required=false)
    private String end;
    @Element(required=false)
    private String deviceid;
    @Element(required=false)
    private String simserial;
    @Element(required=false)
    private String phonenumber;
    @Element(required=false)
    private String imei;
    @Element(required=false)
    private Date today;

    public Date getInfantVisitDate() {
        return infantVisitDate;
    }

    public String getInfantStatus() {
        return infantStatus;
    }

    public String getInfantVisit() {
        return infantVisit;
    }

    public Float getInfantTemp() {
        return infantTemp;
    }

    public String getInfantTmpUnit() {
        return infantTmpUnit;
    }

    public Float getInfantWt() {
        return infantWt;
    }

    public String getInfantWtUnit() {
        return infantWtUnit;
    }

    public Float getInfantWtPercen() {
        return infantWtPercen;
    }

    public String getInfantWtpercenNa() {
        return infantWtpercenNa;
    }

    public Float getInfantLength() {
        return infantLength;
    }

    public Float getInfantLengthPercen() {
        return infantLengthPercen;
    }

    public String getInfantLenpercenNa() {
        return infantLenpercenNa;
    }

    public Float getInfantHeadcircu() {
        return infantHeadcircu;
    }

    public Float getInfantHeapercen() {
        return infantHeapercen;
    }

    public String getInfantHeapercenNa() {
        return infantHeapercenNa;
    }

    public String getInfantReferralNeuro() {
        return infantReferralNeuro;
    }

    public String getInfantApgarNa() {
        return infantApgarNa;
    }

    public Float getInfantApgar1min() {
        return infantApgar1min;
    }

    public Float getInfantApgar5min() {
        return infantApgar5min;
    }

    public String getInfantSkinEvalu() {
        return infantSkinEvalu;
    }

    public String getInfantRash() {
        return infantRash;
    }

    public String getInfantScarring() {
        return infantScarring;
    }

    public String getInfantOrganEvalu() {
        return infantOrganEvalu;
    }

    public String getInfantAbdominal() {
        return infantAbdominal;
    }

    public String getInfantLiverSpleen() {
        return infantLiverSpleen;
    }

    public String getInfantOphth() {
        return infantOphth;
    }

    public String getInfantOphthAbno() {
        return infantOphthAbno;
    }

    public String getInfantWhichEye() {
        return infantWhichEye;
    }

    public String getInfantEyeCalci() {
        return infantEyeCalci;
    }

    public String getInfantChoriore() {
        return infantChoriore;
    }

    public String getInfantEyeOther() {
        return infantEyeOther;
    }

    public String getInfantOtherIssue() {
        return infantOtherIssue;
    }

    public String getInfantEyeOtherSpecify() {
        return infantEyeOtherSpecify;
    }

    public String getInfantReferralOphth() {
        return infantReferralOphth;
    }

    public String getInfantOae() {
        return infantOae;
    }

    public String getInfantOaeAbnormal() {
        return infantOaeAbnormal;
    }

    public String getInfantWhichEar() {
        return infantWhichEar;
    }

    public String getInfantReferralAudio() {
        return infantReferralAudio;
    }

    public String getInfantAdditionalAudio() {
        return infantAdditionalAudio;
    }

    public Float getInfatnHearLeft() {
        return infatnHearLeft;
    }

    public Float getInfantHearRight() {
        return infantHearRight;
    }

    public String getInfantBreastfeeding() {
        return infantBreastfeeding;
    }

    public String getInfantBreastReason() {
        return infantBreastReason;
    }

    public String getInfantBreastOther() {
        return infantBreastOther;
    }

    public String getInfantNeurodeve() {
        return infantNeurodeve;
    }

    public String getInfantNeurodeveType() {
        return infantNeurodeveType;
    }

    public String getInfantOtherSpecify() {
        return infantOtherSpecify;
    }

    public String getInfantExhibited() {
        return infantExhibited;
    }

    public String getInfantOtherMovement() {
        return infantOtherMovement;
    }

    public String getInfantFurtherNeuro() {
        return infantFurtherNeuro;
    }

    public String getInfantHeadAltra() {
        return infantHeadAltra;
    }

    public String getInfantUltraObtained() {
        return infantUltraObtained;
    }

    public Date getInfantUltraDt() {
        return infantUltraDt;
    }

    public String getInfantResultsUltra() {
        return infantResultsUltra;
    }

    public String getInfantResultsSpecify() {
        return infantResultsSpecify;
    }

    public String getInfantHeadCt() {
        return infantHeadCt;
    }

    public String getInfantCtObtained() {
        return infantCtObtained;
    }

    public Date getInfantCtDt() {
        return infantCtDt;
    }

    public String getInfantResultsCt() {
        return infantResultsCt;
    }

    public String getInfantCtSpecify() {
        return infantCtSpecify;
    }

    public String getInfantCerebrospinal() {
        return infantCerebrospinal;
    }

    public String getInfantCerebroStored() {
        return infantCerebroStored;
    }

    public Date getInfantCerebroDt() {
        return infantCerebroDt;
    }

    public Float getInfantCerebroAmount() {
        return infantCerebroAmount;
    }

    public String getInfantResultsCerebro() {
        return infantResultsCerebro;
    }

    public String getInfantCerebroSpecify() {
        return infantCerebroSpecify;
    }

    public String getInfantMri() {
        return infantMri;
    }

    public String getInfantMriObtained() {
        return infantMriObtained;
    }

    public Date getInfantMriDt() {
        return infantMriDt;
    }

    public String getInfantResultsMri() {
        return infantResultsMri;
    }

    public String getInfantMriSpecify() {
        return infantMriSpecify;
    }

    public String getInfantPreviousResults() {
        return infantPreviousResults;
    }

    public String getInfantReferrCounselling() {
        return infantReferrCounselling;
    }

    public String getInfantOtherLabCollect() {
        return infantOtherLabCollect;
    }

    public String getInfantIdCompleting() {
        return infantIdCompleting;
    }

    public Date getInfantDateCompleted() {
        return infantDateCompleted;
    }

    public String getInfantIdReviewer() {
        return infantIdReviewer;
    }

    public Date getInfantDateReviewed() {
        return infantDateReviewed;
    }

    public String getInfantIdDataEntry() {
        return infantIdDataEntry;
    }

    public Date getInfantDateEntered() {
        return infantDateEntered;
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
