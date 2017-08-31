package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/10/2016.
 * V1.0
 */

public class Zp06DeliveryAnd6weekVisit extends BaseMetaData{

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String redcapEventName;
    private Date deliVisitDate;
    private String deliVisitStatus;
    private String deliVisitType;
    private Float deliMotherWt;
    private String deliWtUnit;
    private Integer deliSystolic;
    private Integer deliDiastolic;
    private Float deliTemperature;
    private String deliTempUnit;
    private Date deliDeliveryDate;
    private String deliMode;
    private String deliDeliveryWho;
    private String deliDeliveryOccur;
    private String deliHospitalId;
    private String deliClinicId;
    private String deliDeliveryOther;
    private String deliNumBirth;
    private String deliFetalOutcome1;
    private String deliCauseDeath1;
    private String deliSexBaby1;
    private String deliFetalOutcome2;
    private String deliCauseDeath2;
    private String deliSexBaby2;
    private String deliFetalOutcome3;
    private String deliCauseDeath3;
    private String deliSexBaby3;
    private String deliConsentInfant;
    private String deliReasonNoconsent;
    private String deliNoconsentOther;
    private String deliFeverSymptom;
    private String deliRash;
    private String deliItch;
    private String deliRashFirst;//multiple
    private String deliRashDay;
    private String deliRashMonth;
    private String deliRashYear;
    private Integer deliRashDuration;
    private String deliRashSpread;
    private String deliSpreadPart;//multiple
    private String deliFeverExperience;
    private String deliTempMeasure;
    private Float deliHighTemp;
    private String deliHightemUnit;
    private String deliTempunknown;
    private String deliFeverDay;
    private String deliFeverMonth;
    private String deliFeverYear;
    private Integer deliFeverDuration;
    private String deliRedeyes;
    private String deliRedeyesDay;
    private String deliRedeyesMonth;
    private String deliRedeyesYear;
    private Integer deliRedeyesDuration;
    private String deliJoint;
    private String deliJointDay;
    private String deliJointMonth;
    private String deliJointYear;
    private Integer deliJointDuration;
    private String deliHeadache;
    private String deliHeadacheDay;
    private String deliHeadacheMonth;
    private String deliHeadacheYear;
    private Integer deliHeadacheDuration;
    private String deliSymptomOther;
    private String deliSpecifySymptom;
    private String deliOtherSymptom;
    private String deliMedicare;
    private String deliCareDay;
    private String deliCareMonth;
    private String deliCareYear;
    private String deliCareFacility;
    private String deliHospitalized;
    private String deliHospital;
    private String deliDiagRubella;
    private String deliDiagDengue;
    private String deliDiagChikung;
    private String deliDiagZika;
    private String deliDiagCytome;
    private String deliMedicine;
    private String deliMedcineName;
    private String deliSymptomDiary;
    private String deliGuillainbarre;
    private String deliTingling;
    private String deliTinglingArm;//multiple
    private String deliTinglingLeg;//multiple
    private String deliTinglingHand;//multiple
    private String deliTinglingFoot;//multiple
    private String deliTinglingFace;//multiple
    private String deliTinglingOther;
    private Integer deliSensationMin;
    private Integer deliSensationHr;
    private Integer deliSenstaionDay;
    private String deliInjury;
    private String deliTinglingDay;
    private String deliTinglingMonth;
    private String deliTinglingYear;
    private Integer deliTinglingDuration;
    private String deliNumbness;
    private String deliNumbArm;//multiple
    private String deliNumbLeg;//multiple
    private String deliNumbHand;//multiple
    private String deliNumbFoot;//multiple
    private String deliNumbFace;//multiple
    private String deliNumbOther;
    private String deliNumbDay;
    private String deliNumbMonth;
    private String deliNumbYear;
    private Integer deliNumbDuration;
    private String deliParalysis;
    private String deliParaArm;//multiple
    private String deliParaLeg;//multiple
    private String deliParaHand;//multiple
    private String deliParaFoot;//multiple
    private String deliParaFace;//multiple
    private String deliParaOther;
    private String deliParaDay;
    private String deliParaMonth;
    private String deliParaYear;
    private Integer deliParaDuration;
    private String deliResultsProvided;
    private String deliCounseling;
    private String deliResultsOther;
    private String deliIdCompleting;
    private Date deliDateCompleted;
    private String deliIdReviewer;
    private Date deliDateReviewed;
    private String deliIdDataEntry;
    private Date deliDateEntered;
    
    //v2.4
    private String deliHyperDisease;
    private String deliPreterm1;
    private String deliPreterm2;
    private String deliPreterm3;
    private String deliDeliverEarly;

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

    public Date getDeliVisitDate() {
        return deliVisitDate;
    }

    public void setDeliVisitDate(Date deliVisitDate) {
        this.deliVisitDate = deliVisitDate;
    }

    public String getDeliVisitStatus() {
        return deliVisitStatus;
    }

    public void setDeliVisitStatus(String deliVisitStatus) {
        this.deliVisitStatus = deliVisitStatus;
    }

    public String getDeliVisitType() {
        return deliVisitType;
    }

    public void setDeliVisitType(String deliVisitType) {
        this.deliVisitType = deliVisitType;
    }

    public Float getDeliMotherWt() {
        return deliMotherWt;
    }

    public void setDeliMotherWt(Float deliMotherWt) {
        this.deliMotherWt = deliMotherWt;
    }

    public String getDeliWtUnit() {
        return deliWtUnit;
    }

    public void setDeliWtUnit(String deliWtUnit) {
        this.deliWtUnit = deliWtUnit;
    }

    public Integer getDeliSystolic() {
        return deliSystolic;
    }

    public void setDeliSystolic(Integer deliSystolic) {
        this.deliSystolic = deliSystolic;
    }

    public Integer getDeliDiastolic() {
        return deliDiastolic;
    }

    public void setDeliDiastolic(Integer deliDiastolic) {
        this.deliDiastolic = deliDiastolic;
    }

    public Float getDeliTemperature() {
        return deliTemperature;
    }

    public void setDeliTemperature(Float deliTemperature) {
        this.deliTemperature = deliTemperature;
    }

    public String getDeliTempUnit() {
        return deliTempUnit;
    }

    public void setDeliTempUnit(String deliTempUnit) {
        this.deliTempUnit = deliTempUnit;
    }

    public Date getDeliDeliveryDate() {
        return deliDeliveryDate;
    }

    public void setDeliDeliveryDate(Date deliDeliveryDate) {
        this.deliDeliveryDate = deliDeliveryDate;
    }

    public String getDeliMode() {
        return deliMode;
    }

    public void setDeliMode(String deliMode) {
        this.deliMode = deliMode;
    }

    public String getDeliDeliveryWho() {
        return deliDeliveryWho;
    }

    public void setDeliDeliveryWho(String deliDeliveryWho) {
        this.deliDeliveryWho = deliDeliveryWho;
    }

    public String getDeliDeliveryOccur() {
        return deliDeliveryOccur;
    }

    public void setDeliDeliveryOccur(String deliDeliveryOccur) {
        this.deliDeliveryOccur = deliDeliveryOccur;
    }

    public String getDeliHospitalId() {
        return deliHospitalId;
    }

    public void setDeliHospitalId(String deliHospitalId) {
        this.deliHospitalId = deliHospitalId;
    }

    public String getDeliClinicId() {
        return deliClinicId;
    }

    public void setDeliClinicId(String deliClinicId) {
        this.deliClinicId = deliClinicId;
    }

    public String getDeliDeliveryOther() {
        return deliDeliveryOther;
    }

    public void setDeliDeliveryOther(String deliDeliveryOther) {
        this.deliDeliveryOther = deliDeliveryOther;
    }

    public String getDeliNumBirth() {
        return deliNumBirth;
    }

    public void setDeliNumBirth(String deliNumBirth) {
        this.deliNumBirth = deliNumBirth;
    }

    public String getDeliFetalOutcome1() {
        return deliFetalOutcome1;
    }

    public void setDeliFetalOutcome1(String deliFetalOutcome1) {
        this.deliFetalOutcome1 = deliFetalOutcome1;
    }

    public String getDeliCauseDeath1() {
        return deliCauseDeath1;
    }

    public void setDeliCauseDeath1(String deliCauseDeath1) {
        this.deliCauseDeath1 = deliCauseDeath1;
    }

    public String getDeliSexBaby1() {
        return deliSexBaby1;
    }

    public void setDeliSexBaby1(String deliSexBaby1) {
        this.deliSexBaby1 = deliSexBaby1;
    }

    public String getDeliFetalOutcome2() {
        return deliFetalOutcome2;
    }

    public void setDeliFetalOutcome2(String deliFetalOutcome2) {
        this.deliFetalOutcome2 = deliFetalOutcome2;
    }

    public String getDeliCauseDeath2() {
        return deliCauseDeath2;
    }

    public void setDeliCauseDeath2(String deliCauseDeath2) {
        this.deliCauseDeath2 = deliCauseDeath2;
    }

    public String getDeliSexBaby2() {
        return deliSexBaby2;
    }

    public void setDeliSexBaby2(String deliSexBaby2) {
        this.deliSexBaby2 = deliSexBaby2;
    }

    public String getDeliFetalOutcome3() {
        return deliFetalOutcome3;
    }

    public void setDeliFetalOutcome3(String deliFetalOutcome3) {
        this.deliFetalOutcome3 = deliFetalOutcome3;
    }

    public String getDeliCauseDeath3() {
        return deliCauseDeath3;
    }

    public void setDeliCauseDeath3(String deliCauseDeath3) {
        this.deliCauseDeath3 = deliCauseDeath3;
    }

    public String getDeliSexBaby3() {
        return deliSexBaby3;
    }

    public void setDeliSexBaby3(String deliSexBaby3) {
        this.deliSexBaby3 = deliSexBaby3;
    }

    public String getDeliConsentInfant() {
        return deliConsentInfant;
    }

    public void setDeliConsentInfant(String deliConsentInfant) {
        this.deliConsentInfant = deliConsentInfant;
    }

    public String getDeliReasonNoconsent() {
        return deliReasonNoconsent;
    }

    public void setDeliReasonNoconsent(String deliReasonNoconsent) {
        this.deliReasonNoconsent = deliReasonNoconsent;
    }

    public String getDeliNoconsentOther() {
        return deliNoconsentOther;
    }

    public void setDeliNoconsentOther(String deliNoconsentOther) {
        this.deliNoconsentOther = deliNoconsentOther;
    }

    public String getDeliFeverSymptom() {
        return deliFeverSymptom;
    }

    public void setDeliFeverSymptom(String deliFeverSymptom) {
        this.deliFeverSymptom = deliFeverSymptom;
    }

    public String getDeliRash() {
        return deliRash;
    }

    public void setDeliRash(String deliRash) {
        this.deliRash = deliRash;
    }

    public String getDeliItch() {
        return deliItch;
    }

    public void setDeliItch(String deliItch) {
        this.deliItch = deliItch;
    }

    public String getDeliRashFirst() {
        return deliRashFirst;
    }

    public void setDeliRashFirst(String deliRashFirst) {
        this.deliRashFirst = deliRashFirst;
    }

    public String getDeliRashDay() {
        return deliRashDay;
    }

    public void setDeliRashDay(String deliRashDay) {
        this.deliRashDay = deliRashDay;
    }

    public String getDeliRashMonth() {
        return deliRashMonth;
    }

    public void setDeliRashMonth(String deliRashMonth) {
        this.deliRashMonth = deliRashMonth;
    }

    public String getDeliRashYear() {
        return deliRashYear;
    }

    public void setDeliRashYear(String deliRashYear) {
        this.deliRashYear = deliRashYear;
    }

    public Integer getDeliRashDuration() {
        return deliRashDuration;
    }

    public void setDeliRashDuration(Integer deliRashDuration) {
        this.deliRashDuration = deliRashDuration;
    }

    public String getDeliRashSpread() {
        return deliRashSpread;
    }

    public void setDeliRashSpread(String deliRashSpread) {
        this.deliRashSpread = deliRashSpread;
    }

    public String getDeliSpreadPart() {
        return deliSpreadPart;
    }

    public void setDeliSpreadPart(String deliSpreadPart) {
        this.deliSpreadPart = deliSpreadPart;
    }

    public String getDeliFeverExperience() {
        return deliFeverExperience;
    }

    public void setDeliFeverExperience(String deliFeverExperience) {
        this.deliFeverExperience = deliFeverExperience;
    }

    public String getDeliTempMeasure() {
        return deliTempMeasure;
    }

    public void setDeliTempMeasure(String deliTempMeasure) {
        this.deliTempMeasure = deliTempMeasure;
    }

    public Float getDeliHighTemp() {
        return deliHighTemp;
    }

    public void setDeliHighTemp(Float deliHighTemp) {
        this.deliHighTemp = deliHighTemp;
    }

    public String getDeliHightemUnit() {
        return deliHightemUnit;
    }

    public void setDeliHightemUnit(String deliHightemUnit) {
        this.deliHightemUnit = deliHightemUnit;
    }

    public String getDeliTempunknown() {
        return deliTempunknown;
    }

    public void setDeliTempunknown(String deliTempunknown) {
        this.deliTempunknown = deliTempunknown;
    }

    public String getDeliFeverDay() {
        return deliFeverDay;
    }

    public void setDeliFeverDay(String deliFeverDay) {
        this.deliFeverDay = deliFeverDay;
    }

    public String getDeliFeverMonth() {
        return deliFeverMonth;
    }

    public void setDeliFeverMonth(String deliFeverMonth) {
        this.deliFeverMonth = deliFeverMonth;
    }

    public String getDeliFeverYear() {
        return deliFeverYear;
    }

    public void setDeliFeverYear(String deliFeverYear) {
        this.deliFeverYear = deliFeverYear;
    }

    public Integer getDeliFeverDuration() {
        return deliFeverDuration;
    }

    public void setDeliFeverDuration(Integer deliFeverDuration) {
        this.deliFeverDuration = deliFeverDuration;
    }

    public String getDeliRedeyes() {
        return deliRedeyes;
    }

    public void setDeliRedeyes(String deliRedeyes) {
        this.deliRedeyes = deliRedeyes;
    }

    public String getDeliRedeyesDay() {
        return deliRedeyesDay;
    }

    public void setDeliRedeyesDay(String deliRedeyesDay) {
        this.deliRedeyesDay = deliRedeyesDay;
    }

    public String getDeliRedeyesMonth() {
        return deliRedeyesMonth;
    }

    public void setDeliRedeyesMonth(String deliRedeyesMonth) {
        this.deliRedeyesMonth = deliRedeyesMonth;
    }

    public String getDeliRedeyesYear() {
        return deliRedeyesYear;
    }

    public void setDeliRedeyesYear(String deliRedeyesYear) {
        this.deliRedeyesYear = deliRedeyesYear;
    }

    public Integer getDeliRedeyesDuration() {
        return deliRedeyesDuration;
    }

    public void setDeliRedeyesDuration(Integer deliRedeyesDuration) {
        this.deliRedeyesDuration = deliRedeyesDuration;
    }

    public String getDeliJoint() {
        return deliJoint;
    }

    public void setDeliJoint(String deliJoint) {
        this.deliJoint = deliJoint;
    }

    public String getDeliJointDay() {
        return deliJointDay;
    }

    public void setDeliJointDay(String deliJointDay) {
        this.deliJointDay = deliJointDay;
    }

    public String getDeliJointMonth() {
        return deliJointMonth;
    }

    public void setDeliJointMonth(String deliJointMonth) {
        this.deliJointMonth = deliJointMonth;
    }

    public String getDeliJointYear() {
        return deliJointYear;
    }

    public void setDeliJointYear(String deliJointYear) {
        this.deliJointYear = deliJointYear;
    }

    public Integer getDeliJointDuration() {
        return deliJointDuration;
    }

    public void setDeliJointDuration(Integer deliJointDuration) {
        this.deliJointDuration = deliJointDuration;
    }

    public String getDeliHeadache() {
        return deliHeadache;
    }

    public void setDeliHeadache(String deliHeadache) {
        this.deliHeadache = deliHeadache;
    }

    public String getDeliHeadacheDay() {
        return deliHeadacheDay;
    }

    public void setDeliHeadacheDay(String deliHeadacheDay) {
        this.deliHeadacheDay = deliHeadacheDay;
    }

    public String getDeliHeadacheMonth() {
        return deliHeadacheMonth;
    }

    public void setDeliHeadacheMonth(String deliHeadacheMonth) {
        this.deliHeadacheMonth = deliHeadacheMonth;
    }

    public String getDeliHeadacheYear() {
        return deliHeadacheYear;
    }

    public void setDeliHeadacheYear(String deliHeadacheYear) {
        this.deliHeadacheYear = deliHeadacheYear;
    }

    public Integer getDeliHeadacheDuration() {
        return deliHeadacheDuration;
    }

    public void setDeliHeadacheDuration(Integer deliHeadacheDuration) {
        this.deliHeadacheDuration = deliHeadacheDuration;
    }

    public String getDeliSymptomOther() {
        return deliSymptomOther;
    }

    public void setDeliSymptomOther(String deliSymptomOther) {
        this.deliSymptomOther = deliSymptomOther;
    }

    public String getDeliSpecifySymptom() {
        return deliSpecifySymptom;
    }

    public void setDeliSpecifySymptom(String deliSpecifySymptom) {
        this.deliSpecifySymptom = deliSpecifySymptom;
    }

    public String getDeliOtherSymptom() {
        return deliOtherSymptom;
    }

    public void setDeliOtherSymptom(String deliOtherSymptom) {
        this.deliOtherSymptom = deliOtherSymptom;
    }

    public String getDeliMedicare() {
        return deliMedicare;
    }

    public void setDeliMedicare(String deliMedicare) {
        this.deliMedicare = deliMedicare;
    }

    public String getDeliCareDay() {
        return deliCareDay;
    }

    public void setDeliCareDay(String deliCareDay) {
        this.deliCareDay = deliCareDay;
    }

    public String getDeliCareMonth() {
        return deliCareMonth;
    }

    public void setDeliCareMonth(String deliCareMonth) {
        this.deliCareMonth = deliCareMonth;
    }

    public String getDeliCareYear() {
        return deliCareYear;
    }

    public void setDeliCareYear(String deliCareYear) {
        this.deliCareYear = deliCareYear;
    }

    public String getDeliCareFacility() {
        return deliCareFacility;
    }

    public void setDeliCareFacility(String deliCareFacility) {
        this.deliCareFacility = deliCareFacility;
    }

    public String getDeliHospitalized() {
        return deliHospitalized;
    }

    public void setDeliHospitalized(String deliHospitalized) {
        this.deliHospitalized = deliHospitalized;
    }

    public String getDeliHospital() {
        return deliHospital;
    }

    public void setDeliHospital(String deliHospital) {
        this.deliHospital = deliHospital;
    }

    public String getDeliDiagRubella() {
        return deliDiagRubella;
    }

    public void setDeliDiagRubella(String deliDiagRubella) {
        this.deliDiagRubella = deliDiagRubella;
    }

    public String getDeliDiagDengue() {
        return deliDiagDengue;
    }

    public void setDeliDiagDengue(String deliDiagDengue) {
        this.deliDiagDengue = deliDiagDengue;
    }

    public String getDeliDiagChikung() {
        return deliDiagChikung;
    }

    public void setDeliDiagChikung(String deliDiagChikung) {
        this.deliDiagChikung = deliDiagChikung;
    }

    public String getDeliDiagZika() {
        return deliDiagZika;
    }

    public void setDeliDiagZika(String deliDiagZika) {
        this.deliDiagZika = deliDiagZika;
    }

    public String getDeliDiagCytome() {
        return deliDiagCytome;
    }

    public void setDeliDiagCytome(String deliDiagCytome) {
        this.deliDiagCytome = deliDiagCytome;
    }

    public String getDeliMedicine() {
        return deliMedicine;
    }

    public void setDeliMedicine(String deliMedicine) {
        this.deliMedicine = deliMedicine;
    }

    public String getDeliMedcineName() {
        return deliMedcineName;
    }

    public void setDeliMedcineName(String deliMedcineName) {
        this.deliMedcineName = deliMedcineName;
    }

    public String getDeliSymptomDiary() {
        return deliSymptomDiary;
    }

    public void setDeliSymptomDiary(String deliSymptomDiary) {
        this.deliSymptomDiary = deliSymptomDiary;
    }

    public String getDeliGuillainbarre() {
        return deliGuillainbarre;
    }

    public void setDeliGuillainbarre(String deliGuillainbarre) {
        this.deliGuillainbarre = deliGuillainbarre;
    }

    public String getDeliTingling() {
        return deliTingling;
    }

    public void setDeliTingling(String deliTingling) {
        this.deliTingling = deliTingling;
    }

    public String getDeliTinglingArm() {
        return deliTinglingArm;
    }

    public void setDeliTinglingArm(String deliTinglingArm) {
        this.deliTinglingArm = deliTinglingArm;
    }

    public String getDeliTinglingLeg() {
        return deliTinglingLeg;
    }

    public void setDeliTinglingLeg(String deliTinglingLeg) {
        this.deliTinglingLeg = deliTinglingLeg;
    }

    public String getDeliTinglingHand() {
        return deliTinglingHand;
    }

    public void setDeliTinglingHand(String deliTinglingHand) {
        this.deliTinglingHand = deliTinglingHand;
    }

    public String getDeliTinglingFoot() {
        return deliTinglingFoot;
    }

    public void setDeliTinglingFoot(String deliTinglingFoot) {
        this.deliTinglingFoot = deliTinglingFoot;
    }

    public String getDeliTinglingFace() {
        return deliTinglingFace;
    }

    public void setDeliTinglingFace(String deliTinglingFace) {
        this.deliTinglingFace = deliTinglingFace;
    }

    public String getDeliTinglingOther() {
        return deliTinglingOther;
    }

    public void setDeliTinglingOther(String deliTinglingOther) {
        this.deliTinglingOther = deliTinglingOther;
    }

    public Integer getDeliSensationMin() {
        return deliSensationMin;
    }

    public void setDeliSensationMin(Integer deliSensationMin) {
        this.deliSensationMin = deliSensationMin;
    }

    public Integer getDeliSensationHr() {
        return deliSensationHr;
    }

    public void setDeliSensationHr(Integer deliSensationHr) {
        this.deliSensationHr = deliSensationHr;
    }

    public Integer getDeliSenstaionDay() {
        return deliSenstaionDay;
    }

    public void setDeliSenstaionDay(Integer deliSenstaionDay) {
        this.deliSenstaionDay = deliSenstaionDay;
    }

    public String getDeliInjury() {
        return deliInjury;
    }

    public void setDeliInjury(String deliInjury) {
        this.deliInjury = deliInjury;
    }

    public String getDeliTinglingDay() {
        return deliTinglingDay;
    }

    public void setDeliTinglingDay(String deliTinglingDay) {
        this.deliTinglingDay = deliTinglingDay;
    }

    public String getDeliTinglingMonth() {
        return deliTinglingMonth;
    }

    public void setDeliTinglingMonth(String deliTinglingMonth) {
        this.deliTinglingMonth = deliTinglingMonth;
    }

    public String getDeliTinglingYear() {
        return deliTinglingYear;
    }

    public void setDeliTinglingYear(String deliTinglingYear) {
        this.deliTinglingYear = deliTinglingYear;
    }

    public Integer getDeliTinglingDuration() {
        return deliTinglingDuration;
    }

    public void setDeliTinglingDuration(Integer deliTinglingDuration) {
        this.deliTinglingDuration = deliTinglingDuration;
    }

    public String getDeliNumbness() {
        return deliNumbness;
    }

    public void setDeliNumbness(String deliNumbness) {
        this.deliNumbness = deliNumbness;
    }

    public String getDeliNumbArm() {
        return deliNumbArm;
    }

    public void setDeliNumbArm(String deliNumbArm) {
        this.deliNumbArm = deliNumbArm;
    }

    public String getDeliNumbLeg() {
        return deliNumbLeg;
    }

    public void setDeliNumbLeg(String deliNumbLeg) {
        this.deliNumbLeg = deliNumbLeg;
    }

    public String getDeliNumbHand() {
        return deliNumbHand;
    }

    public void setDeliNumbHand(String deliNumbHand) {
        this.deliNumbHand = deliNumbHand;
    }

    public String getDeliNumbFoot() {
        return deliNumbFoot;
    }

    public void setDeliNumbFoot(String deliNumbFoot) {
        this.deliNumbFoot = deliNumbFoot;
    }

    public String getDeliNumbFace() {
        return deliNumbFace;
    }

    public void setDeliNumbFace(String deliNumbFace) {
        this.deliNumbFace = deliNumbFace;
    }

    public String getDeliNumbOther() {
        return deliNumbOther;
    }

    public void setDeliNumbOther(String deliNumbOther) {
        this.deliNumbOther = deliNumbOther;
    }

    public String getDeliNumbDay() {
        return deliNumbDay;
    }

    public void setDeliNumbDay(String deliNumbDay) {
        this.deliNumbDay = deliNumbDay;
    }

    public String getDeliNumbMonth() {
        return deliNumbMonth;
    }

    public void setDeliNumbMonth(String deliNumbMonth) {
        this.deliNumbMonth = deliNumbMonth;
    }

    public String getDeliNumbYear() {
        return deliNumbYear;
    }

    public void setDeliNumbYear(String deliNumbYear) {
        this.deliNumbYear = deliNumbYear;
    }

    public Integer getDeliNumbDuration() {
        return deliNumbDuration;
    }

    public void setDeliNumbDuration(Integer deliNumbDuration) {
        this.deliNumbDuration = deliNumbDuration;
    }

    public String getDeliParalysis() {
        return deliParalysis;
    }

    public void setDeliParalysis(String deliParalysis) {
        this.deliParalysis = deliParalysis;
    }

    public String getDeliParaArm() {
        return deliParaArm;
    }

    public void setDeliParaArm(String deliParaArm) {
        this.deliParaArm = deliParaArm;
    }

    public String getDeliParaLeg() {
        return deliParaLeg;
    }

    public void setDeliParaLeg(String deliParaLeg) {
        this.deliParaLeg = deliParaLeg;
    }

    public String getDeliParaHand() {
        return deliParaHand;
    }

    public void setDeliParaHand(String deliParaHand) {
        this.deliParaHand = deliParaHand;
    }

    public String getDeliParaFoot() {
        return deliParaFoot;
    }

    public void setDeliParaFoot(String deliParaFoot) {
        this.deliParaFoot = deliParaFoot;
    }

    public String getDeliParaFace() {
        return deliParaFace;
    }

    public void setDeliParaFace(String deliParaFace) {
        this.deliParaFace = deliParaFace;
    }

    public String getDeliParaOther() {
        return deliParaOther;
    }

    public void setDeliParaOther(String deliParaOther) {
        this.deliParaOther = deliParaOther;
    }

    public String getDeliParaDay() {
        return deliParaDay;
    }

    public void setDeliParaDay(String deliParaDay) {
        this.deliParaDay = deliParaDay;
    }

    public String getDeliParaMonth() {
        return deliParaMonth;
    }

    public void setDeliParaMonth(String deliParaMonth) {
        this.deliParaMonth = deliParaMonth;
    }

    public String getDeliParaYear() {
        return deliParaYear;
    }

    public void setDeliParaYear(String deliParaYear) {
        this.deliParaYear = deliParaYear;
    }

    public Integer getDeliParaDuration() {
        return deliParaDuration;
    }

    public void setDeliParaDuration(Integer deliParaDuration) {
        this.deliParaDuration = deliParaDuration;
    }

    public String getDeliResultsProvided() {
        return deliResultsProvided;
    }

    public void setDeliResultsProvided(String deliResultsProvided) {
        this.deliResultsProvided = deliResultsProvided;
    }

    public String getDeliCounseling() {
        return deliCounseling;
    }

    public void setDeliCounseling(String deliCounseling) {
        this.deliCounseling = deliCounseling;
    }

    public String getDeliResultsOther() {
        return deliResultsOther;
    }

    public void setDeliResultsOther(String deliResultsOther) {
        this.deliResultsOther = deliResultsOther;
    }

    public String getDeliIdCompleting() {
        return deliIdCompleting;
    }

    public void setDeliIdCompleting(String deliIdCompleting) {
        this.deliIdCompleting = deliIdCompleting;
    }

    public Date getDeliDateCompleted() {
        return deliDateCompleted;
    }

    public void setDeliDateCompleted(Date deliDateCompleted) {
        this.deliDateCompleted = deliDateCompleted;
    }

    public String getDeliIdReviewer() {
        return deliIdReviewer;
    }

    public void setDeliIdReviewer(String deliIdReviewer) {
        this.deliIdReviewer = deliIdReviewer;
    }

    public Date getDeliDateReviewed() {
        return deliDateReviewed;
    }

    public void setDeliDateReviewed(Date deliDateReviewed) {
        this.deliDateReviewed = deliDateReviewed;
    }

    public String getDeliIdDataEntry() {
        return deliIdDataEntry;
    }

    public void setDeliIdDataEntry(String deliIdDataEntry) {
        this.deliIdDataEntry = deliIdDataEntry;
    }

    public Date getDeliDateEntered() {
        return deliDateEntered;
    }

    public void setDeliDateEntered(Date deliDateEntered) {
        this.deliDateEntered = deliDateEntered;
    }
    
    public String getDeliHyperDisease() {
		return deliHyperDisease;
	}

	public void setDeliHyperDisease(String deliHyperDisease) {
		this.deliHyperDisease = deliHyperDisease;
	}

	public String getDeliPreterm1() {
		return deliPreterm1;
	}

	public void setDeliPreterm1(String deliPreterm1) {
		this.deliPreterm1 = deliPreterm1;
	}

	public String getDeliPreterm2() {
		return deliPreterm2;
	}

	public void setDeliPreterm2(String deliPreterm2) {
		this.deliPreterm2 = deliPreterm2;
	}

	public String getDeliPreterm3() {
		return deliPreterm3;
	}

	public void setDeliPreterm3(String deliPreterm3) {
		this.deliPreterm3 = deliPreterm3;
	}

	public String getDeliDeliverEarly() {
		return deliDeliverEarly;
	}

	public void setDeliDeliverEarly(String deliDeliverEarly) {
		this.deliDeliverEarly = deliDeliverEarly;
	}
}
