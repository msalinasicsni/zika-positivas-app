package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 1/31/2017.
 * V1.0
 */

public class Zp07InfantAssessmentVisit extends BaseMetaData {

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String redcapEventName;
    private Date infantVisitDate;
    private String infantStatus;
    private String infantVisit;
    private Float infantTemp;
    private String infantTmpUnit;
    private Float infantWt;
    private String infantWtUnit;
    private Float infantWtPercen;
    private String infantWtpercenNa;
    private Float infantLength;
    private Float infantLengthPercen;
    private String infantLenpercenNa;
    private Float infantHeadcircu;
    private Float infantHeapercen;
    private String infantHeapercenNa;
    private String infantReferralNeuro;
    private String infantApgarNa;
    private Float infantApgar1min;
    private Float infantApgar5min;
    private String infantSkinEvalu;
    private String infantRash;
    private String infantScarring;
    private String infantOrganEvalu;
    private String infantAbdominal;
    private String infantLiverSpleen;
    private String infantOphth;
    private String infantOphthAbno;
    private String infantWhichEye;//multiple
    private String infantEyeCalci;
    private String infantChoriore;
    private String infantEyeOther;
    private String infantOtherIssue;//multiple
    private String infantEyeOtherSpecify;
    private String infantReferralOphth;
    private String infantOae;
    private String infantOaeAbnormal;
    private String infantWhichEar; //multiple
    private String infantReferralAudio;
    private String infantAdditionalAudio;
    private Float infatnHearLeft;
    private Float infantHearRight;
    private String infantBreastfeeding;
    private String infantBreastReason;//multiple
    private String infantBreastOther;
    private String infantNeurodeve;
    private String infantNeurodeveType;//multiple
    private String infantOtherSpecify;
    private String infantExhibited; //multiple
    private String infantOtherMovement;
    private String infantFurtherNeuro;
    private String infantHeadAltra;
    private String infantUltraObtained;
    private Date infantUltraDt;
    private String infantResultsUltra;
    private String infantResultsSpecify;
    private String infantHeadCt;
    private String infantCtObtained;
    private Date infantCtDt;
    private String infantResultsCt;
    private String infantCtSpecify;
    private String infantCerebrospinal;
    private String infantCerebroStored;
    private Date infantCerebroDt;
    private Float infantCerebroAmount;
    private String infantResultsCerebro;
    private String infantCerebroSpecify;
    private String infantMri;
    private String infantMriObtained;
    private Date infantMriDt;
    private String infantResultsMri;
    private String infantMriSpecify;
    private String infantPreviousResults;
    private String infantReferrCounselling;
    private String infantOtherLabCollect;
    private String infantIdCompleting;
    private Date infantDateCompleted;
    private String infantIdReviewer;
    private Date infantDateReviewed;
    private String infantIdDataEntry;
    private Date infantDateEntered;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRedcapEventName() {
        return redcapEventName;
    }

    public void setRedcapEventName(String redcapEventName) {
        this.redcapEventName = redcapEventName;
    }

    public Date getInfantVisitDate() {
        return infantVisitDate;
    }

    public void setInfantVisitDate(Date infantVisitDate) {
        this.infantVisitDate = infantVisitDate;
    }

    public String getInfantStatus() {
        return infantStatus;
    }

    public void setInfantStatus(String infantStatus) {
        this.infantStatus = infantStatus;
    }

    public String getInfantVisit() {
        return infantVisit;
    }

    public void setInfantVisit(String infantVisit) {
        this.infantVisit = infantVisit;
    }

    public Float getInfantTemp() {
        return infantTemp;
    }

    public void setInfantTemp(Float infantTemp) {
        this.infantTemp = infantTemp;
    }

    public String getInfantTmpUnit() {
        return infantTmpUnit;
    }

    public void setInfantTmpUnit(String infantTmpUnit) {
        this.infantTmpUnit = infantTmpUnit;
    }

    public Float getInfantWt() {
        return infantWt;
    }

    public void setInfantWt(Float infantWt) {
        this.infantWt = infantWt;
    }

    public String getInfantWtUnit() {
        return infantWtUnit;
    }

    public void setInfantWtUnit(String infantWtUnit) {
        this.infantWtUnit = infantWtUnit;
    }

    public Float getInfantWtPercen() {
        return infantWtPercen;
    }

    public void setInfantWtPercen(Float infantWtPercen) {
        this.infantWtPercen = infantWtPercen;
    }

    public String getInfantWtpercenNa() {
        return infantWtpercenNa;
    }

    public void setInfantWtpercenNa(String infantWtpercenNa) {
        this.infantWtpercenNa = infantWtpercenNa;
    }

    public Float getInfantLength() {
        return infantLength;
    }

    public void setInfantLength(Float infantLength) {
        this.infantLength = infantLength;
    }

    public Float getInfantLengthPercen() {
        return infantLengthPercen;
    }

    public void setInfantLengthPercen(Float infantLengthPercen) {
        this.infantLengthPercen = infantLengthPercen;
    }

    public String getInfantLenpercenNa() {
        return infantLenpercenNa;
    }

    public void setInfantLenpercenNa(String infantLenpercenNa) {
        this.infantLenpercenNa = infantLenpercenNa;
    }

    public Float getInfantHeadcircu() {
        return infantHeadcircu;
    }

    public void setInfantHeadcircu(Float infantHeadcircu) {
        this.infantHeadcircu = infantHeadcircu;
    }

    public Float getInfantHeapercen() {
        return infantHeapercen;
    }

    public void setInfantHeapercen(Float infantHeapercen) {
        this.infantHeapercen = infantHeapercen;
    }

    public String getInfantHeapercenNa() {
        return infantHeapercenNa;
    }

    public void setInfantHeapercenNa(String infantHeapercenNa) {
        this.infantHeapercenNa = infantHeapercenNa;
    }

    public String getInfantReferralNeuro() {
        return infantReferralNeuro;
    }

    public void setInfantReferralNeuro(String infantReferralNeuro) {
        this.infantReferralNeuro = infantReferralNeuro;
    }

    public String getInfantApgarNa() {
        return infantApgarNa;
    }

    public void setInfantApgarNa(String infantApgarNa) {
        this.infantApgarNa = infantApgarNa;
    }

    public Float getInfantApgar1min() {
        return infantApgar1min;
    }

    public void setInfantApgar1min(Float infantApgar1min) {
        this.infantApgar1min = infantApgar1min;
    }

    public Float getInfantApgar5min() {
        return infantApgar5min;
    }

    public void setInfantApgar5min(Float infantApgar5min) {
        this.infantApgar5min = infantApgar5min;
    }

    public String getInfantSkinEvalu() {
        return infantSkinEvalu;
    }

    public void setInfantSkinEvalu(String infantSkinEvalu) {
        this.infantSkinEvalu = infantSkinEvalu;
    }

    public String getInfantRash() {
        return infantRash;
    }

    public void setInfantRash(String infantRash) {
        this.infantRash = infantRash;
    }

    public String getInfantScarring() {
        return infantScarring;
    }

    public void setInfantScarring(String infantScarring) {
        this.infantScarring = infantScarring;
    }

    public String getInfantOrganEvalu() {
        return infantOrganEvalu;
    }

    public void setInfantOrganEvalu(String infantOrganEvalu) {
        this.infantOrganEvalu = infantOrganEvalu;
    }

    public String getInfantAbdominal() {
        return infantAbdominal;
    }

    public void setInfantAbdominal(String infantAbdominal) {
        this.infantAbdominal = infantAbdominal;
    }

    public String getInfantLiverSpleen() {
        return infantLiverSpleen;
    }

    public void setInfantLiverSpleen(String infantLiverSpleen) {
        this.infantLiverSpleen = infantLiverSpleen;
    }

    public String getInfantOphth() {
        return infantOphth;
    }

    public void setInfantOphth(String infantOphth) {
        this.infantOphth = infantOphth;
    }

    public String getInfantOphthAbno() {
        return infantOphthAbno;
    }

    public void setInfantOphthAbno(String infantOphthAbno) {
        this.infantOphthAbno = infantOphthAbno;
    }

    public String getInfantWhichEye() {
        return infantWhichEye;
    }

    public void setInfantWhichEye(String infantWhichEye) {
        this.infantWhichEye = infantWhichEye;
    }

    public String getInfantEyeCalci() {
        return infantEyeCalci;
    }

    public void setInfantEyeCalci(String infantEyeCalci) {
        this.infantEyeCalci = infantEyeCalci;
    }

    public String getInfantChoriore() {
        return infantChoriore;
    }

    public void setInfantChoriore(String infantChoriore) {
        this.infantChoriore = infantChoriore;
    }

    public String getInfantEyeOther() {
        return infantEyeOther;
    }

    public void setInfantEyeOther(String infantEyeOther) {
        this.infantEyeOther = infantEyeOther;
    }

    public String getInfantOtherIssue() {
        return infantOtherIssue;
    }

    public void setInfantOtherIssue(String infantOtherIssue) {
        this.infantOtherIssue = infantOtherIssue;
    }

    public String getInfantEyeOtherSpecify() {
        return infantEyeOtherSpecify;
    }

    public void setInfantEyeOtherSpecify(String infantEyeOtherSpecify) {
        this.infantEyeOtherSpecify = infantEyeOtherSpecify;
    }

    public String getInfantReferralOphth() {
        return infantReferralOphth;
    }

    public void setInfantReferralOphth(String infantReferralOphth) {
        this.infantReferralOphth = infantReferralOphth;
    }

    public String getInfantOae() {
        return infantOae;
    }

    public void setInfantOae(String infantOae) {
        this.infantOae = infantOae;
    }

    public String getInfantOaeAbnormal() {
        return infantOaeAbnormal;
    }

    public void setInfantOaeAbnormal(String infantOaeAbnormal) {
        this.infantOaeAbnormal = infantOaeAbnormal;
    }

    public String getInfantWhichEar() {
        return infantWhichEar;
    }

    public void setInfantWhichEar(String infantWhichEar) {
        this.infantWhichEar = infantWhichEar;
    }

    public String getInfantReferralAudio() {
        return infantReferralAudio;
    }

    public void setInfantReferralAudio(String infantReferralAudio) {
        this.infantReferralAudio = infantReferralAudio;
    }

    public String getInfantAdditionalAudio() {
        return infantAdditionalAudio;
    }

    public void setInfantAdditionalAudio(String infantAdditionalAudio) {
        this.infantAdditionalAudio = infantAdditionalAudio;
    }

    public Float getInfatnHearLeft() {
        return infatnHearLeft;
    }

    public void setInfatnHearLeft(Float infatnHearLeft) {
        this.infatnHearLeft = infatnHearLeft;
    }

    public Float getInfantHearRight() {
        return infantHearRight;
    }

    public void setInfantHearRight(Float infantHearRight) {
        this.infantHearRight = infantHearRight;
    }

    public String getInfantBreastfeeding() {
        return infantBreastfeeding;
    }

    public void setInfantBreastfeeding(String infantBreastfeeding) {
        this.infantBreastfeeding = infantBreastfeeding;
    }

    public String getInfantBreastReason() {
        return infantBreastReason;
    }

    public void setInfantBreastReason(String infantBreastReason) {
        this.infantBreastReason = infantBreastReason;
    }

    public String getInfantBreastOther() {
        return infantBreastOther;
    }

    public void setInfantBreastOther(String infantBreastOther) {
        this.infantBreastOther = infantBreastOther;
    }

    public String getInfantNeurodeve() {
        return infantNeurodeve;
    }

    public void setInfantNeurodeve(String infantNeurodeve) {
        this.infantNeurodeve = infantNeurodeve;
    }

    public String getInfantNeurodeveType() {
        return infantNeurodeveType;
    }

    public void setInfantNeurodeveType(String infantNeurodeveType) {
        this.infantNeurodeveType = infantNeurodeveType;
    }

    public String getInfantOtherSpecify() {
        return infantOtherSpecify;
    }

    public void setInfantOtherSpecify(String infantOtherSpecify) {
        this.infantOtherSpecify = infantOtherSpecify;
    }

    public String getInfantExhibited() {
        return infantExhibited;
    }

    public void setInfantExhibited(String infantExhibited) {
        this.infantExhibited = infantExhibited;
    }

    public String getInfantOtherMovement() {
        return infantOtherMovement;
    }

    public void setInfantOtherMovement(String infantOtherMovement) {
        this.infantOtherMovement = infantOtherMovement;
    }

    public String getInfantFurtherNeuro() {
        return infantFurtherNeuro;
    }

    public void setInfantFurtherNeuro(String infantFurtherNeuro) {
        this.infantFurtherNeuro = infantFurtherNeuro;
    }

    public String getInfantHeadAltra() {
        return infantHeadAltra;
    }

    public void setInfantHeadAltra(String infantHeadAltra) {
        this.infantHeadAltra = infantHeadAltra;
    }

    public String getInfantUltraObtained() {
        return infantUltraObtained;
    }

    public void setInfantUltraObtained(String infantUltraObtained) {
        this.infantUltraObtained = infantUltraObtained;
    }

    public Date getInfantUltraDt() {
        return infantUltraDt;
    }

    public void setInfantUltraDt(Date infantUltraDt) {
        this.infantUltraDt = infantUltraDt;
    }

    public String getInfantResultsUltra() {
        return infantResultsUltra;
    }

    public void setInfantResultsUltra(String infantResultsUltra) {
        this.infantResultsUltra = infantResultsUltra;
    }

    public String getInfantResultsSpecify() {
        return infantResultsSpecify;
    }

    public void setInfantResultsSpecify(String infantResultsSpecify) {
        this.infantResultsSpecify = infantResultsSpecify;
    }

    public String getInfantHeadCt() {
        return infantHeadCt;
    }

    public void setInfantHeadCt(String infantHeadCt) {
        this.infantHeadCt = infantHeadCt;
    }

    public String getInfantCtObtained() {
        return infantCtObtained;
    }

    public void setInfantCtObtained(String infantCtObtained) {
        this.infantCtObtained = infantCtObtained;
    }

    public Date getInfantCtDt() {
        return infantCtDt;
    }

    public void setInfantCtDt(Date infantCtDt) {
        this.infantCtDt = infantCtDt;
    }

    public String getInfantResultsCt() {
        return infantResultsCt;
    }

    public void setInfantResultsCt(String infantResultsCt) {
        this.infantResultsCt = infantResultsCt;
    }

    public String getInfantCtSpecify() {
        return infantCtSpecify;
    }

    public void setInfantCtSpecify(String infantCtSpecify) {
        this.infantCtSpecify = infantCtSpecify;
    }

    public String getInfantCerebrospinal() {
        return infantCerebrospinal;
    }

    public void setInfantCerebrospinal(String infantCerebrospinal) {
        this.infantCerebrospinal = infantCerebrospinal;
    }

    public String getInfantCerebroStored() {
        return infantCerebroStored;
    }

    public void setInfantCerebroStored(String infantCerebroStored) {
        this.infantCerebroStored = infantCerebroStored;
    }

    public Date getInfantCerebroDt() {
        return infantCerebroDt;
    }

    public void setInfantCerebroDt(Date infantCerebroDt) {
        this.infantCerebroDt = infantCerebroDt;
    }

    public Float getInfantCerebroAmount() {
        return infantCerebroAmount;
    }

    public void setInfantCerebroAmount(Float infantCerebroAmount) {
        this.infantCerebroAmount = infantCerebroAmount;
    }

    public String getInfantResultsCerebro() {
        return infantResultsCerebro;
    }

    public void setInfantResultsCerebro(String infantResultsCerebro) {
        this.infantResultsCerebro = infantResultsCerebro;
    }

    public String getInfantCerebroSpecify() {
        return infantCerebroSpecify;
    }

    public void setInfantCerebroSpecify(String infantCerebroSpecify) {
        this.infantCerebroSpecify = infantCerebroSpecify;
    }

    public String getInfantMri() {
        return infantMri;
    }

    public void setInfantMri(String infantMri) {
        this.infantMri = infantMri;
    }

    public String getInfantMriObtained() {
        return infantMriObtained;
    }

    public void setInfantMriObtained(String infantMriObtained) {
        this.infantMriObtained = infantMriObtained;
    }

    public Date getInfantMriDt() {
        return infantMriDt;
    }

    public void setInfantMriDt(Date infantMriDt) {
        this.infantMriDt = infantMriDt;
    }

    public String getInfantResultsMri() {
        return infantResultsMri;
    }

    public void setInfantResultsMri(String infantResultsMri) {
        this.infantResultsMri = infantResultsMri;
    }

    public String getInfantMriSpecify() {
        return infantMriSpecify;
    }

    public void setInfantMriSpecify(String infantMriSpecify) {
        this.infantMriSpecify = infantMriSpecify;
    }

    public String getInfantPreviousResults() {
        return infantPreviousResults;
    }

    public void setInfantPreviousResults(String infantPreviousResults) {
        this.infantPreviousResults = infantPreviousResults;
    }

    public String getInfantReferrCounselling() {
        return infantReferrCounselling;
    }

    public void setInfantReferrCounselling(String infantReferrCounselling) {
        this.infantReferrCounselling = infantReferrCounselling;
    }

    public String getInfantOtherLabCollect() {
        return infantOtherLabCollect;
    }

    public void setInfantOtherLabCollect(String infantOtherLabCollect) {
        this.infantOtherLabCollect = infantOtherLabCollect;
    }

    public String getInfantIdCompleting() {
        return infantIdCompleting;
    }

    public void setInfantIdCompleting(String infantIdCompleting) {
        this.infantIdCompleting = infantIdCompleting;
    }

    public Date getInfantDateCompleted() {
        return infantDateCompleted;
    }

    public void setInfantDateCompleted(Date infantDateCompleted) {
        this.infantDateCompleted = infantDateCompleted;
    }

    public String getInfantIdReviewer() {
        return infantIdReviewer;
    }

    public void setInfantIdReviewer(String infantIdReviewer) {
        this.infantIdReviewer = infantIdReviewer;
    }

    public Date getInfantDateReviewed() {
        return infantDateReviewed;
    }

    public void setInfantDateReviewed(Date infantDateReviewed) {
        this.infantDateReviewed = infantDateReviewed;
    }

    public String getInfantIdDataEntry() {
        return infantIdDataEntry;
    }

    public void setInfantIdDataEntry(String infantIdDataEntry) {
        this.infantIdDataEntry = infantIdDataEntry;
    }

    public Date getInfantDateEntered() {
        return infantDateEntered;
    }

    public void setInfantDateEntered(Date infantDateEntered) {
        this.infantDateEntered = infantDateEntered;
    }
}
