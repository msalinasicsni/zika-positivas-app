package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/10/2016.
 * V1.0
 */
public class Zp03MonthlyVisit extends BaseMetaData{

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String redcapEventName;
    private Date monVisitDate;
    private String monVisitType;
    private String monReasonMissed;
    private String monOtherReschedu;
    private String monReasonUnscheduled;
    private String monOtherUnscheduled;
    private Float monMotherWt;
    private String monWtUnit;
    private Integer monSystolic;
    private Integer monDiastolic;
    private Float monTemperature;
    private String monTempUnit;
    private String monPregnancyLoss;
    private Date monDateLoss;
    private String monPersisHeadache;
    private String monDizziness;
    private String monNausea;
    private String monVomiting;
    private String monLights;
    private String monLightsSpecify;
    private String monSwelling;
    private String monFetalMovement;
    private String monMoveUsual;
    private String monMoveDecrease;
    private String monContractions;
    private Integer monContractWeek;
    private Integer monContractDay;
    private Integer monContractHour;
    private Integer monContract10min;
    private String monVaginalDischarge;
    private String monCharacDischarge;//multiple
    private String monBleeding;
    private String monBleedingCharac;
    private String monUtiTold;
    private String monPrenatalDay;
    private String monPrenatalMonth;
    private String monPrenatalYear;
    private String monFeverSymptom;
    private String monRash;
    private String monItch;
    private String monRashFirst;//multiple
    private String monRashDay;
    private String monRashMonth;
    private String monRashYear;
    private Integer monRashDuration;
    private String monRashSpread;
    private String monSpreadPart;//multiple
    private String monFeverExperience;
    private String monTempMeasure;
    private Float monHighTemp;
    private String monHightemUnit;
    private String monTempunknown;
    private String monFeverDay;
    private String monFeverMonth;
    private String monFeverYear;
    private Integer monFeverDuration;
    private String monRedeyes;
    private String monRedeyesDay;
    private String monRedeyesMonth;
    private String monRedeyesYear;
    private Integer monRedeyesDuration;
    private String monJoint;
    private String monJointDay;
    private String monJointMonth;
    private String monJointYear;
    private Integer monJointDuration;
    private String monHeadache;
    private String monHeadacheDay;
    private String monHeadacheMonth;
    private String monHeadacheYear;
    private Integer monHeadacheDuration;
    private String monSymptomOther;
    private String monSpecifySymptom;//multiple
    private String monOtherSymptom;
    private String monMedicare;
    private String monCareDay;
    private String monCareMonth;
    private String monCareYear;
    private String monCareFacility;
    private String monHospitalized;
    private String monHospital;
    private String monDiagRubella;
    private String monDiagDengue;
    private String monDiagChikung;
    private String monDiagZika;
    private String monDiagCytome;
    private String monMedicine;
    private String monMedcineName;
    private String monSymptomDiary;
    private String monGuillainbarre;
    private String monTingling;
    private String monTinglingArm;//multiple
    private String monTinglingLeg;//multiple
    private String monTinglingHand;//multiple
    private String monTinglingFoot;//multiple
    private String monTinglingFace;//multiple
    private String monTinglingOther;
    private String monSensationMin;
    private String monSensationHr;
    private String monSenstaionDay;
    private String monInjury;
    private String monTinglingDay;
    private String monTinglingMonth;
    private String monTinglingYear;
    private Integer monTinglingDuration;
    private String monNumbness;
    private String monNumbArm;//multiple
    private String monNumbLeg;//multiple
    private String monNumbHand;//multiple
    private String monNumbFoot;//multiple
    private String monNumbFace;//multiple
    private String monNumbOther;
    private String monNumbDay;
    private String monNumbMonth;
    private String monNumbYear;
    private Integer monNumbDuration;
    private String monParalysis;
    private String monParaArm;//multiple
    private String monParaLeg;//multiple
    private String monParaHand;//multiple
    private String monParaFoot;//multiple
    private String monParaFace;//multiple
    private String monParaOther;
    private String monParaDay;
    private String monParaMonth;
    private String monParaYear;
    private Integer monParaDuration;
    private String monResultsProvided;
    private String monCounseling;
    private String monResultsOther;
    private Date monOneweekDate;
    private String monOneweekTime;
    private String monProvideSym;
    private String monReminderPreg;
    private String monReminderProvided;
    private Date monNextDate;
    private String monNextTime;
    private String monIdCompleting;
    private Date monDateCompleted;
    private String monIdReviewer;
    private Date monDateReviewed;
    private String monIdDataEntry;
    private Date monDateEntered;
    private String monAddtMedicines;
    private String monAddtDrugsType;
    private String monAddtOthDrugsType1;
    private String monAddtOthDrugsBrand1;
    private String monAddtOthDrugsType2;
    private String monAddtOthDrugsBrand2;
    private String monAddtOthDrugsType3;
    private String monAddtOthDrugsBrand3;
    private String monAddtOthDrugsType4;
    private String monAddtOthDrugsBrand4;
    private String monAddtOthDrugsType5;
    private String monAddtOthDrugsBrand5;


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

    public Date getMonVisitDate() {
        return monVisitDate;
    }

    public void setMonVisitDate(Date monVisitDate) {
        this.monVisitDate = monVisitDate;
    }

    public String getMonVisitType() {
        return monVisitType;
    }

    public void setMonVisitType(String monVisitType) {
        this.monVisitType = monVisitType;
    }

    public String getMonReasonMissed() {
        return monReasonMissed;
    }

    public void setMonReasonMissed(String monReasonMissed) {
        this.monReasonMissed = monReasonMissed;
    }

    public String getMonOtherReschedu() {
        return monOtherReschedu;
    }

    public void setMonOtherReschedu(String monOtherReschedu) {
        this.monOtherReschedu = monOtherReschedu;
    }

    public String getMonReasonUnscheduled() {
        return monReasonUnscheduled;
    }

    public void setMonReasonUnscheduled(String monReasonUnscheduled) {
        this.monReasonUnscheduled = monReasonUnscheduled;
    }

    public String getMonOtherUnscheduled() {
        return monOtherUnscheduled;
    }

    public void setMonOtherUnscheduled(String monOtherUnscheduled) {
        this.monOtherUnscheduled = monOtherUnscheduled;
    }

    public Float getMonMotherWt() {
        return monMotherWt;
    }

    public void setMonMotherWt(Float monMotherWt) {
        this.monMotherWt = monMotherWt;
    }

    public String getMonWtUnit() {
        return monWtUnit;
    }

    public void setMonWtUnit(String monWtUnit) {
        this.monWtUnit = monWtUnit;
    }

    public Integer getMonSystolic() {
        return monSystolic;
    }

    public void setMonSystolic(Integer monSystolic) {
        this.monSystolic = monSystolic;
    }

    public Integer getMonDiastolic() {
        return monDiastolic;
    }

    public void setMonDiastolic(Integer monDiastolic) {
        this.monDiastolic = monDiastolic;
    }

    public Float getMonTemperature() {
        return monTemperature;
    }

    public void setMonTemperature(Float monTemperature) {
        this.monTemperature = monTemperature;
    }

    public String getMonTempUnit() {
        return monTempUnit;
    }

    public void setMonTempUnit(String monTempUnit) {
        this.monTempUnit = monTempUnit;
    }

    public String getMonPregnancyLoss() {
        return monPregnancyLoss;
    }

    public void setMonPregnancyLoss(String monPregnancyLoss) {
        this.monPregnancyLoss = monPregnancyLoss;
    }

    public Date getMonDateLoss() {
        return monDateLoss;
    }

    public void setMonDateLoss(Date monDateLoss) {
        this.monDateLoss = monDateLoss;
    }

    public String getMonPersisHeadache() {
        return monPersisHeadache;
    }

    public void setMonPersisHeadache(String monPersisHeadache) {
        this.monPersisHeadache = monPersisHeadache;
    }

    public String getMonDizziness() {
        return monDizziness;
    }

    public void setMonDizziness(String monDizziness) {
        this.monDizziness = monDizziness;
    }

    public String getMonNausea() {
        return monNausea;
    }

    public void setMonNausea(String monNausea) {
        this.monNausea = monNausea;
    }

    public String getMonVomiting() {
        return monVomiting;
    }

    public void setMonVomiting(String monVomiting) {
        this.monVomiting = monVomiting;
    }

    public String getMonLights() {
        return monLights;
    }

    public void setMonLights(String monLights) {
        this.monLights = monLights;
    }

    public String getMonLightsSpecify() {
        return monLightsSpecify;
    }

    public void setMonLightsSpecify(String monLightsSpecify) {
        this.monLightsSpecify = monLightsSpecify;
    }

    public String getMonSwelling() {
        return monSwelling;
    }

    public void setMonSwelling(String monSwelling) {
        this.monSwelling = monSwelling;
    }

    public String getMonFetalMovement() {
        return monFetalMovement;
    }

    public void setMonFetalMovement(String monFetalMovement) {
        this.monFetalMovement = monFetalMovement;
    }

    public String getMonMoveUsual() {
        return monMoveUsual;
    }

    public void setMonMoveUsual(String monMoveUsual) {
        this.monMoveUsual = monMoveUsual;
    }

    public String getMonMoveDecrease() {
        return monMoveDecrease;
    }

    public void setMonMoveDecrease(String monMoveDecrease) {
        this.monMoveDecrease = monMoveDecrease;
    }

    public String getMonContractions() {
        return monContractions;
    }

    public void setMonContractions(String monContractions) {
        this.monContractions = monContractions;
    }

    public Integer getMonContractWeek() {
        return monContractWeek;
    }

    public void setMonContractWeek(Integer monContractWeek) {
        this.monContractWeek = monContractWeek;
    }

    public Integer getMonContractDay() {
        return monContractDay;
    }

    public void setMonContractDay(Integer monContractDay) {
        this.monContractDay = monContractDay;
    }

    public Integer getMonContractHour() {
        return monContractHour;
    }

    public void setMonContractHour(Integer monContractHour) {
        this.monContractHour = monContractHour;
    }

    public Integer getMonContract10min() {
        return monContract10min;
    }

    public void setMonContract10min(Integer monContract10min) {
        this.monContract10min = monContract10min;
    }

    public String getMonVaginalDischarge() {
        return monVaginalDischarge;
    }

    public void setMonVaginalDischarge(String monVaginalDischarge) {
        this.monVaginalDischarge = monVaginalDischarge;
    }

    public String getMonCharacDischarge() {
        return monCharacDischarge;
    }

    public void setMonCharacDischarge(String monCharacDischarge) {
        this.monCharacDischarge = monCharacDischarge;
    }

    public String getMonBleeding() {
        return monBleeding;
    }

    public void setMonBleeding(String monBleeding) {
        this.monBleeding = monBleeding;
    }

    public String getMonBleedingCharac() {
        return monBleedingCharac;
    }

    public void setMonBleedingCharac(String monBleedingCharac) {
        this.monBleedingCharac = monBleedingCharac;
    }

    public String getMonUtiTold() {
        return monUtiTold;
    }

    public void setMonUtiTold(String monUtiTold) {
        this.monUtiTold = monUtiTold;
    }

    public String getMonPrenatalDay() {
        return monPrenatalDay;
    }

    public void setMonPrenatalDay(String monPrenatalDay) {
        this.monPrenatalDay = monPrenatalDay;
    }

    public String getMonPrenatalMonth() {
        return monPrenatalMonth;
    }

    public void setMonPrenatalMonth(String monPrenatalMonth) {
        this.monPrenatalMonth = monPrenatalMonth;
    }

    public String getMonPrenatalYear() {
        return monPrenatalYear;
    }

    public void setMonPrenatalYear(String monPrenatalYear) {
        this.monPrenatalYear = monPrenatalYear;
    }

    public String getMonFeverSymptom() {
        return monFeverSymptom;
    }

    public void setMonFeverSymptom(String monFeverSymptom) {
        this.monFeverSymptom = monFeverSymptom;
    }

    public String getMonRash() {
        return monRash;
    }

    public void setMonRash(String monRash) {
        this.monRash = monRash;
    }

    public String getMonItch() {
        return monItch;
    }

    public void setMonItch(String monItch) {
        this.monItch = monItch;
    }

    public String getMonRashFirst() {
        return monRashFirst;
    }

    public void setMonRashFirst(String monRashFirst) {
        this.monRashFirst = monRashFirst;
    }

    public String getMonRashDay() {
        return monRashDay;
    }

    public void setMonRashDay(String monRashDay) {
        this.monRashDay = monRashDay;
    }

    public String getMonRashMonth() {
        return monRashMonth;
    }

    public void setMonRashMonth(String monRashMonth) {
        this.monRashMonth = monRashMonth;
    }

    public String getMonRashYear() {
        return monRashYear;
    }

    public void setMonRashYear(String monRashYear) {
        this.monRashYear = monRashYear;
    }

    public Integer getMonRashDuration() {
        return monRashDuration;
    }

    public void setMonRashDuration(Integer monRashDuration) {
        this.monRashDuration = monRashDuration;
    }

    public String getMonRashSpread() {
        return monRashSpread;
    }

    public void setMonRashSpread(String monRashSpread) {
        this.monRashSpread = monRashSpread;
    }

    public String getMonSpreadPart() {
        return monSpreadPart;
    }

    public void setMonSpreadPart(String monSpreadPart) {
        this.monSpreadPart = monSpreadPart;
    }

    public String getMonFeverExperience() {
        return monFeverExperience;
    }

    public void setMonFeverExperience(String monFeverExperience) {
        this.monFeverExperience = monFeverExperience;
    }

    public String getMonTempMeasure() {
        return monTempMeasure;
    }

    public void setMonTempMeasure(String monTempMeasure) {
        this.monTempMeasure = monTempMeasure;
    }

    public Float getMonHighTemp() {
        return monHighTemp;
    }

    public void setMonHighTemp(Float monHighTemp) {
        this.monHighTemp = monHighTemp;
    }

    public String getMonHightemUnit() {
        return monHightemUnit;
    }

    public void setMonHightemUnit(String monHightemUnit) {
        this.monHightemUnit = monHightemUnit;
    }

    public String getMonTempunknown() {
        return monTempunknown;
    }

    public void setMonTempunknown(String monTempunknown) {
        this.monTempunknown = monTempunknown;
    }

    public String getMonFeverDay() {
        return monFeverDay;
    }

    public void setMonFeverDay(String monFeverDay) {
        this.monFeverDay = monFeverDay;
    }

    public String getMonFeverMonth() {
        return monFeverMonth;
    }

    public void setMonFeverMonth(String monFeverMonth) {
        this.monFeverMonth = monFeverMonth;
    }

    public String getMonFeverYear() {
        return monFeverYear;
    }

    public void setMonFeverYear(String monFeverYear) {
        this.monFeverYear = monFeverYear;
    }

    public Integer getMonFeverDuration() {
        return monFeverDuration;
    }

    public void setMonFeverDuration(Integer monFeverDuration) {
        this.monFeverDuration = monFeverDuration;
    }

    public String getMonRedeyes() {
        return monRedeyes;
    }

    public void setMonRedeyes(String monRedeyes) {
        this.monRedeyes = monRedeyes;
    }

    public String getMonRedeyesDay() {
        return monRedeyesDay;
    }

    public void setMonRedeyesDay(String monRedeyesDay) {
        this.monRedeyesDay = monRedeyesDay;
    }

    public String getMonRedeyesMonth() {
        return monRedeyesMonth;
    }

    public void setMonRedeyesMonth(String monRedeyesMonth) {
        this.monRedeyesMonth = monRedeyesMonth;
    }

    public String getMonRedeyesYear() {
        return monRedeyesYear;
    }

    public void setMonRedeyesYear(String monRedeyesYear) {
        this.monRedeyesYear = monRedeyesYear;
    }

    public Integer getMonRedeyesDuration() {
        return monRedeyesDuration;
    }

    public void setMonRedeyesDuration(Integer monRedeyesDuration) {
        this.monRedeyesDuration = monRedeyesDuration;
    }

    public String getMonJoint() {
        return monJoint;
    }

    public void setMonJoint(String monJoint) {
        this.monJoint = monJoint;
    }

    public String getMonJointDay() {
        return monJointDay;
    }

    public void setMonJointDay(String monJointDay) {
        this.monJointDay = monJointDay;
    }

    public String getMonJointMonth() {
        return monJointMonth;
    }

    public void setMonJointMonth(String monJointMonth) {
        this.monJointMonth = monJointMonth;
    }

    public String getMonJointYear() {
        return monJointYear;
    }

    public void setMonJointYear(String monJointYear) {
        this.monJointYear = monJointYear;
    }

    public Integer getMonJointDuration() {
        return monJointDuration;
    }

    public void setMonJointDuration(Integer monJointDuration) {
        this.monJointDuration = monJointDuration;
    }

    public String getMonHeadache() {
        return monHeadache;
    }

    public void setMonHeadache(String monHeadache) {
        this.monHeadache = monHeadache;
    }

    public String getMonHeadacheDay() {
        return monHeadacheDay;
    }

    public void setMonHeadacheDay(String monHeadacheDay) {
        this.monHeadacheDay = monHeadacheDay;
    }

    public String getMonHeadacheMonth() {
        return monHeadacheMonth;
    }

    public void setMonHeadacheMonth(String monHeadacheMonth) {
        this.monHeadacheMonth = monHeadacheMonth;
    }

    public String getMonHeadacheYear() {
        return monHeadacheYear;
    }

    public void setMonHeadacheYear(String monHeadacheYear) {
        this.monHeadacheYear = monHeadacheYear;
    }

    public Integer getMonHeadacheDuration() {
        return monHeadacheDuration;
    }

    public void setMonHeadacheDuration(Integer monHeadacheDuration) {
        this.monHeadacheDuration = monHeadacheDuration;
    }

    public String getMonSymptomOther() {
        return monSymptomOther;
    }

    public void setMonSymptomOther(String monSymptomOther) {
        this.monSymptomOther = monSymptomOther;
    }

    public String getMonSpecifySymptom() {
        return monSpecifySymptom;
    }

    public void setMonSpecifySymptom(String monSpecifySymptom) {
        this.monSpecifySymptom = monSpecifySymptom;
    }

    public String getMonOtherSymptom() {
        return monOtherSymptom;
    }

    public void setMonOtherSymptom(String monOtherSymptom) {
        this.monOtherSymptom = monOtherSymptom;
    }

    public String getMonMedicare() {
        return monMedicare;
    }

    public void setMonMedicare(String monMedicare) {
        this.monMedicare = monMedicare;
    }

    public String getMonCareDay() {
        return monCareDay;
    }

    public void setMonCareDay(String monCareDay) {
        this.monCareDay = monCareDay;
    }

    public String getMonCareMonth() {
        return monCareMonth;
    }

    public void setMonCareMonth(String monCareMonth) {
        this.monCareMonth = monCareMonth;
    }

    public String getMonCareYear() {
        return monCareYear;
    }

    public void setMonCareYear(String monCareYear) {
        this.monCareYear = monCareYear;
    }

    public String getMonCareFacility() {
        return monCareFacility;
    }

    public void setMonCareFacility(String monCareFacility) {
        this.monCareFacility = monCareFacility;
    }

    public String getMonHospitalized() {
        return monHospitalized;
    }

    public void setMonHospitalized(String monHospitalized) {
        this.monHospitalized = monHospitalized;
    }

    public String getMonHospital() {
        return monHospital;
    }

    public void setMonHospital(String monHospital) {
        this.monHospital = monHospital;
    }

    public String getMonDiagRubella() {
        return monDiagRubella;
    }

    public void setMonDiagRubella(String monDiagRubella) {
        this.monDiagRubella = monDiagRubella;
    }

    public String getMonDiagDengue() {
        return monDiagDengue;
    }

    public void setMonDiagDengue(String monDiagDengue) {
        this.monDiagDengue = monDiagDengue;
    }

    public String getMonDiagChikung() {
        return monDiagChikung;
    }

    public void setMonDiagChikung(String monDiagChikung) {
        this.monDiagChikung = monDiagChikung;
    }

    public String getMonDiagZika() {
        return monDiagZika;
    }

    public void setMonDiagZika(String monDiagZika) {
        this.monDiagZika = monDiagZika;
    }

    public String getMonDiagCytome() {
        return monDiagCytome;
    }

    public void setMonDiagCytome(String monDiagCytome) {
        this.monDiagCytome = monDiagCytome;
    }

    public String getMonMedicine() {
        return monMedicine;
    }

    public void setMonMedicine(String monMedicine) {
        this.monMedicine = monMedicine;
    }

    public String getMonMedcineName() {
        return monMedcineName;
    }

    public void setMonMedcineName(String monMedcineName) {
        this.monMedcineName = monMedcineName;
    }

    public String getMonSymptomDiary() {
        return monSymptomDiary;
    }

    public void setMonSymptomDiary(String monSymptomDiary) {
        this.monSymptomDiary = monSymptomDiary;
    }

    public String getMonGuillainbarre() {
        return monGuillainbarre;
    }

    public void setMonGuillainbarre(String monGuillainbarre) {
        this.monGuillainbarre = monGuillainbarre;
    }

    public String getMonTingling() {
        return monTingling;
    }

    public void setMonTingling(String monTingling) {
        this.monTingling = monTingling;
    }

    public String getMonTinglingArm() {
        return monTinglingArm;
    }

    public void setMonTinglingArm(String monTinglingArm) {
        this.monTinglingArm = monTinglingArm;
    }

    public String getMonTinglingLeg() {
        return monTinglingLeg;
    }

    public void setMonTinglingLeg(String monTinglingLeg) {
        this.monTinglingLeg = monTinglingLeg;
    }

    public String getMonTinglingHand() {
        return monTinglingHand;
    }

    public void setMonTinglingHand(String monTinglingHand) {
        this.monTinglingHand = monTinglingHand;
    }

    public String getMonTinglingFoot() {
        return monTinglingFoot;
    }

    public void setMonTinglingFoot(String monTinglingFoot) {
        this.monTinglingFoot = monTinglingFoot;
    }

    public String getMonTinglingFace() {
        return monTinglingFace;
    }

    public void setMonTinglingFace(String monTinglingFace) {
        this.monTinglingFace = monTinglingFace;
    }

    public String getMonTinglingOther() {
        return monTinglingOther;
    }

    public void setMonTinglingOther(String monTinglingOther) {
        this.monTinglingOther = monTinglingOther;
    }

    public String getMonSensationMin() {
        return monSensationMin;
    }

    public void setMonSensationMin(String monSensationMin) {
        this.monSensationMin = monSensationMin;
    }

    public String getMonSensationHr() {
        return monSensationHr;
    }

    public void setMonSensationHr(String monSensationHr) {
        this.monSensationHr = monSensationHr;
    }

    public String getMonSenstaionDay() {
        return monSenstaionDay;
    }

    public void setMonSenstaionDay(String monSenstaionDay) {
        this.monSenstaionDay = monSenstaionDay;
    }

    public String getMonInjury() {
        return monInjury;
    }

    public void setMonInjury(String monInjury) {
        this.monInjury = monInjury;
    }

    public String getMonTinglingDay() {
        return monTinglingDay;
    }

    public void setMonTinglingDay(String monTinglingDay) {
        this.monTinglingDay = monTinglingDay;
    }

    public String getMonTinglingMonth() {
        return monTinglingMonth;
    }

    public void setMonTinglingMonth(String monTinglingMonth) {
        this.monTinglingMonth = monTinglingMonth;
    }

    public String getMonTinglingYear() {
        return monTinglingYear;
    }

    public void setMonTinglingYear(String monTinglingYear) {
        this.monTinglingYear = monTinglingYear;
    }

    public Integer getMonTinglingDuration() {
        return monTinglingDuration;
    }

    public void setMonTinglingDuration(Integer monTinglingDuration) {
        this.monTinglingDuration = monTinglingDuration;
    }

    public String getMonNumbness() {
        return monNumbness;
    }

    public void setMonNumbness(String monNumbness) {
        this.monNumbness = monNumbness;
    }

    public String getMonNumbArm() {
        return monNumbArm;
    }

    public void setMonNumbArm(String monNumbArm) {
        this.monNumbArm = monNumbArm;
    }

    public String getMonNumbLeg() {
        return monNumbLeg;
    }

    public void setMonNumbLeg(String monNumbLeg) {
        this.monNumbLeg = monNumbLeg;
    }

    public String getMonNumbHand() {
        return monNumbHand;
    }

    public void setMonNumbHand(String monNumbHand) {
        this.monNumbHand = monNumbHand;
    }

    public String getMonNumbFoot() {
        return monNumbFoot;
    }

    public void setMonNumbFoot(String monNumbFoot) {
        this.monNumbFoot = monNumbFoot;
    }

    public String getMonNumbFace() {
        return monNumbFace;
    }

    public void setMonNumbFace(String monNumbFace) {
        this.monNumbFace = monNumbFace;
    }

    public String getMonNumbOther() {
        return monNumbOther;
    }

    public void setMonNumbOther(String monNumbOther) {
        this.monNumbOther = monNumbOther;
    }

    public String getMonNumbDay() {
        return monNumbDay;
    }

    public void setMonNumbDay(String monNumbDay) {
        this.monNumbDay = monNumbDay;
    }

    public String getMonNumbMonth() {
        return monNumbMonth;
    }

    public void setMonNumbMonth(String monNumbMonth) {
        this.monNumbMonth = monNumbMonth;
    }

    public String getMonNumbYear() {
        return monNumbYear;
    }

    public void setMonNumbYear(String monNumbYear) {
        this.monNumbYear = monNumbYear;
    }

    public Integer getMonNumbDuration() {
        return monNumbDuration;
    }

    public void setMonNumbDuration(Integer monNumbDuration) {
        this.monNumbDuration = monNumbDuration;
    }

    public String getMonParalysis() {
        return monParalysis;
    }

    public void setMonParalysis(String monParalysis) {
        this.monParalysis = monParalysis;
    }

    public String getMonParaArm() {
        return monParaArm;
    }

    public void setMonParaArm(String monParaArm) {
        this.monParaArm = monParaArm;
    }

    public String getMonParaLeg() {
        return monParaLeg;
    }

    public void setMonParaLeg(String monParaLeg) {
        this.monParaLeg = monParaLeg;
    }

    public String getMonParaHand() {
        return monParaHand;
    }

    public void setMonParaHand(String monParaHand) {
        this.monParaHand = monParaHand;
    }

    public String getMonParaFoot() {
        return monParaFoot;
    }

    public void setMonParaFoot(String monParaFoot) {
        this.monParaFoot = monParaFoot;
    }

    public String getMonParaFace() {
        return monParaFace;
    }

    public void setMonParaFace(String monParaFace) {
        this.monParaFace = monParaFace;
    }

    public String getMonParaOther() {
        return monParaOther;
    }

    public void setMonParaOther(String monParaOther) {
        this.monParaOther = monParaOther;
    }

    public String getMonParaDay() {
        return monParaDay;
    }

    public void setMonParaDay(String monParaDay) {
        this.monParaDay = monParaDay;
    }

    public String getMonParaMonth() {
        return monParaMonth;
    }

    public void setMonParaMonth(String monParaMonth) {
        this.monParaMonth = monParaMonth;
    }

    public String getMonParaYear() {
        return monParaYear;
    }

    public void setMonParaYear(String monParaYear) {
        this.monParaYear = monParaYear;
    }

    public Integer getMonParaDuration() {
        return monParaDuration;
    }

    public void setMonParaDuration(Integer monParaDuration) {
        this.monParaDuration = monParaDuration;
    }

    public String getMonResultsProvided() {
        return monResultsProvided;
    }

    public void setMonResultsProvided(String monResultsProvided) {
        this.monResultsProvided = monResultsProvided;
    }

    public String getMonCounseling() {
        return monCounseling;
    }

    public void setMonCounseling(String monCounseling) {
        this.monCounseling = monCounseling;
    }

    public String getMonResultsOther() {
        return monResultsOther;
    }

    public void setMonResultsOther(String monResultsOther) {
        this.monResultsOther = monResultsOther;
    }

    public Date getMonOneweekDate() {
        return monOneweekDate;
    }

    public void setMonOneweekDate(Date monOneweekDate) {
        this.monOneweekDate = monOneweekDate;
    }

    public String getMonOneweekTime() {
        return monOneweekTime;
    }

    public void setMonOneweekTime(String monOneweekTime) {
        this.monOneweekTime = monOneweekTime;
    }

    public String getMonProvideSym() {
        return monProvideSym;
    }

    public void setMonProvideSym(String monProvideSym) {
        this.monProvideSym = monProvideSym;
    }

    public String getMonReminderPreg() {
        return monReminderPreg;
    }

    public void setMonReminderPreg(String monReminderPreg) {
        this.monReminderPreg = monReminderPreg;
    }

    public String getMonReminderProvided() {
        return monReminderProvided;
    }

    public void setMonReminderProvided(String monReminderProvided) {
        this.monReminderProvided = monReminderProvided;
    }

    public Date getMonNextDate() {
        return monNextDate;
    }

    public void setMonNextDate(Date monNextDate) {
        this.monNextDate = monNextDate;
    }

    public String getMonNextTime() {
        return monNextTime;
    }

    public void setMonNextTime(String monNextTime) {
        this.monNextTime = monNextTime;
    }

    public String getMonIdCompleting() {
        return monIdCompleting;
    }

    public void setMonIdCompleting(String monIdCompleting) {
        this.monIdCompleting = monIdCompleting;
    }

    public Date getMonDateCompleted() {
        return monDateCompleted;
    }

    public void setMonDateCompleted(Date monDateCompleted) {
        this.monDateCompleted = monDateCompleted;
    }

    public String getMonIdReviewer() {
        return monIdReviewer;
    }

    public void setMonIdReviewer(String monIdReviewer) {
        this.monIdReviewer = monIdReviewer;
    }

    public Date getMonDateReviewed() {
        return monDateReviewed;
    }

    public void setMonDateReviewed(Date monDateReviewed) {
        this.monDateReviewed = monDateReviewed;
    }

    public String getMonIdDataEntry() {
        return monIdDataEntry;
    }

    public void setMonIdDataEntry(String monIdDataEntry) {
        this.monIdDataEntry = monIdDataEntry;
    }

    public Date getMonDateEntered() {
        return monDateEntered;
    }

    public void setMonDateEntered(Date monDateEntered) {
        this.monDateEntered = monDateEntered;
    }

    public String getMonAddtMedicines() {
        return monAddtMedicines;
    }

    public void setMonAddtMedicines(String monAddtMedicines) {
        this.monAddtMedicines = monAddtMedicines;
    }

    public String getMonAddtDrugsType() {
        return monAddtDrugsType;
    }

    public void setMonAddtDrugsType(String monAddtDrugsType) {
        this.monAddtDrugsType = monAddtDrugsType;
    }

    public String getMonAddtOthDrugsType1() {
        return monAddtOthDrugsType1;
    }

    public void setMonAddtOthDrugsType1(String monAddtOthDrugsType1) {
        this.monAddtOthDrugsType1 = monAddtOthDrugsType1;
    }

    public String getMonAddtOthDrugsBrand1() {
        return monAddtOthDrugsBrand1;
    }

    public void setMonAddtOthDrugsBrand1(String monAddtOthDrugsBrand1) {
        this.monAddtOthDrugsBrand1 = monAddtOthDrugsBrand1;
    }

    public String getMonAddtOthDrugsType2() {
        return monAddtOthDrugsType2;
    }

    public void setMonAddtOthDrugsType2(String monAddtOthDrugsType2) {
        this.monAddtOthDrugsType2 = monAddtOthDrugsType2;
    }

    public String getMonAddtOthDrugsBrand2() {
        return monAddtOthDrugsBrand2;
    }

    public void setMonAddtOthDrugsBrand2(String monAddtOthDrugsBrand2) {
        this.monAddtOthDrugsBrand2 = monAddtOthDrugsBrand2;
    }

    public String getMonAddtOthDrugsType3() {
        return monAddtOthDrugsType3;
    }

    public void setMonAddtOthDrugsType3(String monAddtOthDrugsType3) {
        this.monAddtOthDrugsType3 = monAddtOthDrugsType3;
    }

    public String getMonAddtOthDrugsBrand3() {
        return monAddtOthDrugsBrand3;
    }

    public void setMonAddtOthDrugsBrand3(String monAddtOthDrugsBrand3) {
        this.monAddtOthDrugsBrand3 = monAddtOthDrugsBrand3;
    }

    public String getMonAddtOthDrugsType4() {
        return monAddtOthDrugsType4;
    }

    public void setMonAddtOthDrugsType4(String monAddtOthDrugsType4) {
        this.monAddtOthDrugsType4 = monAddtOthDrugsType4;
    }

    public String getMonAddtOthDrugsBrand4() {
        return monAddtOthDrugsBrand4;
    }

    public void setMonAddtOthDrugsBrand4(String monAddtOthDrugsBrand4) {
        this.monAddtOthDrugsBrand4 = monAddtOthDrugsBrand4;
    }

    public String getMonAddtOthDrugsType5() {
        return monAddtOthDrugsType5;
    }

    public void setMonAddtOthDrugsType5(String monAddtOthDrugsType5) {
        this.monAddtOthDrugsType5 = monAddtOthDrugsType5;
    }

    public String getMonAddtOthDrugsBrand5() {
        return monAddtOthDrugsBrand5;
    }

    public void setMonAddtOthDrugsBrand5(String monAddtOthDrugsBrand5) {
        this.monAddtOthDrugsBrand5 = monAddtOthDrugsBrand5;
    }
}
