package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/25/2016.
 * V1.0
 */
public class Zp03MonthlyVisitXml {

    @Element(required=false)
    private Date monVisitDate;
    @Element(required=false)
    private String monVisitType;
    @Element(required=false)
    private String monReasonMissed;
    @Element(required=false)
    private String monOtherReschedu;
    @Element(required=false)
    private String monReasonUnscheduled;
    @Element(required=false)
    private String monOtherUnscheduled;
    @Element(required=false)
    private Float monMotherWt;
    @Element(required=false)
    private String monWtUnit;
    @Element(required=false)
    private Integer monSystolic;
    @Element(required=false)
    private Integer monDiastolic;
    @Element(required=false)
    private Float monTemperature;
    @Element(required=false)
    private String monTempUnit;
    @Element(required=false)
    private String monPregnancyLoss;
    @Element(required=false)
    private Date monDateLoss;
    @Element(required=false)
    private String monPersisHeadache;
    @Element(required=false)
    private String monDizziness;
    @Element(required=false)
    private String monNausea;
    @Element(required=false)
    private String monVomiting;
    @Element(required=false)
    private String monLights;
    @Element(required=false)
    private String monLightsSpecify;
    @Element(required=false)
    private String monSwelling;
    @Element(required=false)
    private String monFetalMovement;
    @Element(required=false)
    private String monMoveUsual;
    @Element(required=false)
    private String monMoveDecrease;
    @Element(required=false)
    private String monContractions;
    @Element(required=false)
    private Integer monContractWeek;
    @Element(required=false)
    private Integer monContractDay;
    @Element(required=false)
    private Integer monContractHour;
    @Element(required=false)
    private Integer monContract10min;
    @Element(required=false)
    private String monVaginalDischarge;
    @Element(required=false)
    private String monCharacDischarge;//multiple
    @Element(required=false)
    private String monBleeding;
    @Element(required=false)
    private String monBleedingCharac;
    @Element(required=false)
    private String monUtiTold;
    @Element(required=false)
    private String monPrenatalDay;
    @Element(required=false)
    private String monPrenatalMonth;
    @Element(required=false)
    private String monPrenatalYear;
    @Element(required=false)
    private String monFeverSymptom;
    @Element(required=false)
    private String monRash;
    @Element(required=false)
    private String monItch;
    @Element(required=false)
    private String monRashFirst;//multiple
    @Element(required=false)
    private String monRashDay;
    @Element(required=false)
    private String monRashMonth;
    @Element(required=false)
    private String monRashYear;
    @Element(required=false)
    private Integer monRashDuration;
    @Element(required=false)
    private String monRashSpread;
    @Element(required=false)
    private String monSpreadPart;//multiple
    @Element(required=false)
    private String monFeverExperience;
    @Element(required=false)
    private String monTempMeasure;
    @Element(required=false)
    private Float monHighTemp;
    @Element(required=false)
    private String monHightemUnit;
    @Element(required=false)
    private String monTempunknown;
    @Element(required=false)
    private String monFeverDay;
    @Element(required=false)
    private String monFeverMonth;
    @Element(required=false)
    private String monFeverYear;
    @Element(required=false)
    private Integer monFeverDuration;
    @Element(required=false)
    private String monRedeyes;
    @Element(required=false)
    private String monRedeyesDay;
    @Element(required=false)
    private String monRedeyesMonth;
    @Element(required=false)
    private String monRedeyesYear;
    @Element(required=false)
    private Integer monRedeyesDuration;
    @Element(required=false)
    private String monJoint;
    @Element(required=false)
    private String monJointDay;
    @Element(required=false)
    private String monJointMonth;
    @Element(required=false)
    private String monJointYear;
    @Element(required=false)
    private Integer monJointDuration;
    @Element(required=false)
    private String monHeadache;
    @Element(required=false)
    private String monHeadacheDay;
    @Element(required=false)
    private String monHeadacheMonth;
    @Element(required=false)
    private String monHeadacheYear;
    @Element(required=false)
    private Integer monHeadacheDuration;
    @Element(required=false)
    private String monSymptomOther;
    @Element(required=false)
    private String monSpecifySymptom;//multiple
    @Element(required=false)
    private String monOtherSymptom;
    @Element(required=false)
    private String monMedicare;
    @Element(required=false)
    private String monCareDay;
    @Element(required=false)
    private String monCareMonth;
    @Element(required=false)
    private String monCareYear;
    @Element(required=false)
    private String monCareFacility;
    @Element(required=false)
    private String monHospitalized;
    @Element(required=false)
    private String monHospital;
    @Element(required=false)
    private String monDiagRubella;
    @Element(required=false)
    private String monDiagDengue;
    @Element(required=false)
    private String monDiagChikung;
    @Element(required=false)
    private String monDiagZika;
    @Element(required=false)
    private String monDiagCytome;
    @Element(required=false)
    private String monMedicine;
    @Element(required=false)
    private String monMedcineName;
    @Element(required=false)
    private String monSymptomDiary;
    @Element(required=false)
    private String monGuillainbarre;
    @Element(required=false)
    private String monTingling;
    @Element(required=false)
    private String monTinglingArm;//multiple
    @Element(required=false)
    private String monTinglingLeg;//multiple
    @Element(required=false)
    private String monTinglingHand;//multiple
    @Element(required=false)
    private String monTinglingFoot;//multiple
    @Element(required=false)
    private String monTinglingFace;//multiple
    @Element(required=false)
    private String monTinglingOther;
    @Element(required=false)
    private String monSensationMin;
    @Element(required=false)
    private String monSensationHr;
    @Element(required=false)
    private String monSenstaionDay;
    @Element(required=false)
    private String monInjury;
    @Element(required=false)
    private String monTinglingDay;
    @Element(required=false)
    private String monTinglingMonth;
    @Element(required=false)
    private String monTinglingYear;
    @Element(required=false)
    private Integer monTinglingDuration;
    @Element(required=false)
    private String monNumbness;
    @Element(required=false)
    private String monNumbArm;//multiple
    @Element(required=false)
    private String monNumbLeg;//multiple
    @Element(required=false)
    private String monNumbHand;//multiple
    @Element(required=false)
    private String monNumbFoot;//multiple
    @Element(required=false)
    private String monNumbFace;//multiple
    @Element(required=false)
    private String monNumbOther;
    @Element(required=false)
    private String monNumbDay;
    @Element(required=false)
    private String monNumbMonth;
    @Element(required=false)
    private String monNumbYear;
    @Element(required=false)
    private Integer monNumbDuration;
    @Element(required=false)
    private String monParalysis;
    @Element(required=false)
    private String monParaArm;//multiple
    @Element(required=false)
    private String monParaLeg;//multiple
    @Element(required=false)
    private String monParaHand;//multiple
    @Element(required=false)
    private String monParaFoot;//multiple
    @Element(required=false)
    private String monParaFace;//multiple
    @Element(required=false)
    private String monParaOther;
    @Element(required=false)
    private String monParaDay;
    @Element(required=false)
    private String monParaMonth;
    @Element(required=false)
    private String monParaYear;
    @Element(required=false)
    private Integer monParaDuration;
    @Element(required=false)
    private String monResultsProvided;
    @Element(required=false)
    private String monCounseling;
    @Element(required=false)
    private String monResultsOther;
    @Element(required=false)
    private Date monOneweekDate;
    @Element(required=false)
    private String monOneweekTime;
    @Element(required=false)
    private String monProvideSym;
    @Element(required=false)
    private String monReminderPreg;
    @Element(required=false)
    private String monReminderProvided;
    @Element(required=false)
    private Date monNextDate;
    @Element(required=false)
    private String monNextTime;
    @Element(required=false)
    private String monIdCompleting;
    @Element(required=false)
    private Date monDateCompleted;
    @Element(required=false)
    private String monIdReviewer;
    @Element(required=false)
    private Date monDateReviewed;
    @Element(required=false)
    private String monIdDataEntry;
    @Element(required=false)
    private Date monDateEntered;
    @Element(required=false)
    private String monAddtMedicines;
    @Element(required=false)
    private String monAddtDrugsType;
    @Element(required=false)
    private String monAddtOthDrugsType1;
    @Element(required=false)
    private String monAddtOthDrugsBrand1;
    @Element(required=false)
    private String monAddtOthDrugsType2;
    @Element(required=false)
    private String monAddtOthDrugsBrand2;
    @Element(required=false)
    private String monAddtOthDrugsType3;
    @Element(required=false)
    private String monAddtOthDrugsBrand3;
    @Element(required=false)
    private String monAddtOthDrugsType4;
    @Element(required=false)
    private String monAddtOthDrugsBrand4;
    @Element(required=false)
    private String monAddtOthDrugsType5;
    @Element(required=false)
    private String monAddtOthDrugsBrand5;

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
    private String group9;
    @Element(required=false)
    private String group10;
    @Element(required=false)
    private String group11;
    @Element(required=false)
    private String group12;
    @Element(required=false)
    private String group13;
    @Element(required=false)
    private String group14;
    @Element(required=false)
    private String group15;
    @Element(required=false)
    private String group16;
    @Element(required=false)
    private String group17;
    @Element(required=false)
    private String group18;
    @Element(required=false)
    private String group19;
    @Element(required=false)
    private String group20;
    @Element(required=false)
    private String group21;
    @Element(required=false)
    private String group22;
    @Element(required=false)
    private String group23;
    @Element(required=false)
    private String group24;
    @Element(required=false)
    private String group25;
    @Element(required=false)
    private String group26;
    @Element(required=false)
    private String group27;
    @Element(required=false)
    private String group28;
    @Element(required=false)
    private String group29;
    @Element(required=false)
    private String group30;
    @Element(required=false)
    private String group31;
    @Element(required=false)
    private String group32;
    @Element(required=false)
    private String group33;
    @Element(required=false)
    private String group34;
    @Element(required=false)
    private String group35;
    @Element(required=false)
    private String group36;
    @Element(required=false)
    private String group37;
    @Element(required=false)
    private String group38;
    @Element(required=false)
    private String group39;
    @Element(required=false)
    private String group40;
    @Element(required=false)
    private String group41;
    @Element(required=false)
    private String group42;
    @Element(required=false)
    private String group43;
    @Element(required=false)
    private String group44;
    @Element(required=false)
    private String group45;
    @Element(required=false)
    private String group46;
    @Element(required=false)
    private String note1;
    @Element(required=false)
    private String note2;
    @Element(required=false)
    private String note3;
    @Element(required=false)
    private String note4;
    @Element(required=false)
    private String note5;
    @Element(required=false)
    private String note6;
    @Element(required=false)
    private String  question1;


    @Attribute
    private String id;
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

    public Date getMonVisitDate() {
        return monVisitDate;
    }

    public String getMonVisitType() {
        return monVisitType;
    }

    public String getMonReasonMissed() {
        return monReasonMissed;
    }

    public String getMonOtherReschedu() {
        return monOtherReschedu;
    }

    public String getMonReasonUnscheduled() {
        return monReasonUnscheduled;
    }

    public String getMonOtherUnscheduled() {
        return monOtherUnscheduled;
    }

    public Float getMonMotherWt() {
        return monMotherWt;
    }

    public String getMonWtUnit() {
        return monWtUnit;
    }

    public Integer getMonSystolic() {
        return monSystolic;
    }

    public Integer getMonDiastolic() {
        return monDiastolic;
    }

    public Float getMonTemperature() {
        return monTemperature;
    }

    public String getMonTempUnit() {
        return monTempUnit;
    }

    public String getMonPregnancyLoss() {
        return monPregnancyLoss;
    }

    public Date getMonDateLoss() {
        return monDateLoss;
    }

    public String getMonPersisHeadache() {
        return monPersisHeadache;
    }

    public String getMonDizziness() {
        return monDizziness;
    }

    public String getMonNausea() {
        return monNausea;
    }

    public String getMonVomiting() {
        return monVomiting;
    }

    public String getMonLights() {
        return monLights;
    }

    public String getMonLightsSpecify() {
        return monLightsSpecify;
    }

    public String getMonSwelling() {
        return monSwelling;
    }

    public String getMonFetalMovement() {
        return monFetalMovement;
    }

    public String getMonMoveUsual() {
        return monMoveUsual;
    }

    public String getMonMoveDecrease() {
        return monMoveDecrease;
    }

    public String getMonContractions() {
        return monContractions;
    }

    public Integer getMonContractWeek() {
        return monContractWeek;
    }

    public Integer getMonContractDay() {
        return monContractDay;
    }

    public Integer getMonContractHour() {
        return monContractHour;
    }

    public Integer getMonContract10min() {
        return monContract10min;
    }

    public String getMonVaginalDischarge() {
        return monVaginalDischarge;
    }

    public String getMonCharacDischarge() {
        return monCharacDischarge;
    }

    public String getMonBleeding() {
        return monBleeding;
    }

    public String getMonBleedingCharac() {
        return monBleedingCharac;
    }

    public String getMonUtiTold() {
        return monUtiTold;
    }

    public String getMonPrenatalDay() {
        return monPrenatalDay;
    }

    public String getMonPrenatalMonth() {
        return monPrenatalMonth;
    }

    public String getMonPrenatalYear() {
        return monPrenatalYear;
    }

    public String getMonFeverSymptom() {
        return monFeverSymptom;
    }

    public String getMonRash() {
        return monRash;
    }

    public String getMonItch() {
        return monItch;
    }

    public String getMonRashFirst() {
        return monRashFirst;
    }

    public String getMonRashDay() {
        return monRashDay;
    }

    public String getMonRashMonth() {
        return monRashMonth;
    }

    public String getMonRashYear() {
        return monRashYear;
    }

    public Integer getMonRashDuration() {
        return monRashDuration;
    }

    public String getMonRashSpread() {
        return monRashSpread;
    }

    public String getMonSpreadPart() {
        return monSpreadPart;
    }

    public String getMonFeverExperience() {
        return monFeverExperience;
    }

    public String getMonTempMeasure() {
        return monTempMeasure;
    }

    public Float getMonHighTemp() {
        return monHighTemp;
    }

    public String getMonHightemUnit() {
        return monHightemUnit;
    }

    public String getMonTempunknown() {
        return monTempunknown;
    }

    public String getMonFeverDay() {
        return monFeverDay;
    }

    public String getMonFeverMonth() {
        return monFeverMonth;
    }

    public String getMonFeverYear() {
        return monFeverYear;
    }

    public Integer getMonFeverDuration() {
        return monFeverDuration;
    }

    public String getMonRedeyes() {
        return monRedeyes;
    }

    public String getMonRedeyesDay() {
        return monRedeyesDay;
    }

    public String getMonRedeyesMonth() {
        return monRedeyesMonth;
    }

    public String getMonRedeyesYear() {
        return monRedeyesYear;
    }

    public Integer getMonRedeyesDuration() {
        return monRedeyesDuration;
    }

    public String getMonJoint() {
        return monJoint;
    }

    public String getMonJointDay() {
        return monJointDay;
    }

    public String getMonJointMonth() {
        return monJointMonth;
    }

    public String getMonJointYear() {
        return monJointYear;
    }

    public Integer getMonJointDuration() {
        return monJointDuration;
    }

    public String getMonHeadache() {
        return monHeadache;
    }

    public String getMonHeadacheDay() {
        return monHeadacheDay;
    }

    public String getMonHeadacheMonth() {
        return monHeadacheMonth;
    }

    public String getMonHeadacheYear() {
        return monHeadacheYear;
    }

    public Integer getMonHeadacheDuration() {
        return monHeadacheDuration;
    }

    public String getMonSymptomOther() {
        return monSymptomOther;
    }

    public String getMonSpecifySymptom() {
        return monSpecifySymptom;
    }

    public String getMonOtherSymptom() {
        return monOtherSymptom;
    }

    public String getMonMedicare() {
        return monMedicare;
    }

    public String getMonCareDay() {
        return monCareDay;
    }

    public String getMonCareMonth() {
        return monCareMonth;
    }

    public String getMonCareYear() {
        return monCareYear;
    }

    public String getMonCareFacility() {
        return monCareFacility;
    }

    public String getMonHospitalized() {
        return monHospitalized;
    }

    public String getMonHospital() {
        return monHospital;
    }

    public String getMonDiagRubella() {
        return monDiagRubella;
    }

    public String getMonDiagDengue() {
        return monDiagDengue;
    }

    public String getMonDiagChikung() {
        return monDiagChikung;
    }

    public String getMonDiagZika() {
        return monDiagZika;
    }

    public String getMonDiagCytome() {
        return monDiagCytome;
    }

    public String getMonMedicine() {
        return monMedicine;
    }

    public String getMonMedcineName() {
        return monMedcineName;
    }

    public String getMonSymptomDiary() {
        return monSymptomDiary;
    }

    public String getMonGuillainbarre() {
        return monGuillainbarre;
    }

    public String getMonTingling() {
        return monTingling;
    }

    public String getMonTinglingArm() {
        return monTinglingArm;
    }

    public String getMonTinglingLeg() {
        return monTinglingLeg;
    }

    public String getMonTinglingHand() {
        return monTinglingHand;
    }

    public String getMonTinglingFoot() {
        return monTinglingFoot;
    }

    public String getMonTinglingFace() {
        return monTinglingFace;
    }

    public String getMonTinglingOther() {
        return monTinglingOther;
    }

    public String getMonSensationMin() {
        return monSensationMin;
    }

    public String getMonSensationHr() {
        return monSensationHr;
    }

    public String getMonSenstaionDay() {
        return monSenstaionDay;
    }

    public String getMonInjury() {
        return monInjury;
    }

    public String getMonTinglingDay() {
        return monTinglingDay;
    }

    public String getMonTinglingMonth() {
        return monTinglingMonth;
    }

    public String getMonTinglingYear() {
        return monTinglingYear;
    }

    public Integer getMonTinglingDuration() {
        return monTinglingDuration;
    }

    public String getMonNumbness() {
        return monNumbness;
    }

    public String getMonNumbArm() {
        return monNumbArm;
    }

    public String getMonNumbLeg() {
        return monNumbLeg;
    }

    public String getMonNumbHand() {
        return monNumbHand;
    }

    public String getMonNumbFoot() {
        return monNumbFoot;
    }

    public String getMonNumbFace() {
        return monNumbFace;
    }

    public String getMonNumbOther() {
        return monNumbOther;
    }

    public String getMonNumbDay() {
        return monNumbDay;
    }

    public String getMonNumbMonth() {
        return monNumbMonth;
    }

    public String getMonNumbYear() {
        return monNumbYear;
    }

    public Integer getMonNumbDuration() {
        return monNumbDuration;
    }

    public String getMonParalysis() {
        return monParalysis;
    }

    public String getMonParaArm() {
        return monParaArm;
    }

    public String getMonParaLeg() {
        return monParaLeg;
    }

    public String getMonParaHand() {
        return monParaHand;
    }

    public String getMonParaFoot() {
        return monParaFoot;
    }

    public String getMonParaFace() {
        return monParaFace;
    }

    public String getMonParaOther() {
        return monParaOther;
    }

    public String getMonParaDay() {
        return monParaDay;
    }

    public String getMonParaMonth() {
        return monParaMonth;
    }

    public String getMonParaYear() {
        return monParaYear;
    }

    public Integer getMonParaDuration() {
        return monParaDuration;
    }

    public String getMonResultsProvided() {
        return monResultsProvided;
    }

    public String getMonCounseling() {
        return monCounseling;
    }

    public String getMonResultsOther() {
        return monResultsOther;
    }

    public Date getMonOneweekDate() {
        return monOneweekDate;
    }

    public String getMonOneweekTime() {
        return monOneweekTime;
    }

    public String getMonProvideSym() {
        return monProvideSym;
    }

    public String getMonReminderPreg() {
        return monReminderPreg;
    }

    public String getMonReminderProvided() {
        return monReminderProvided;
    }

    public Date getMonNextDate() {
        return monNextDate;
    }

    public String getMonNextTime() {
        return monNextTime;
    }

    public String getMonIdCompleting() {
        return monIdCompleting;
    }

    public Date getMonDateCompleted() {
        return monDateCompleted;
    }

    public String getMonIdReviewer() {
        return monIdReviewer;
    }

    public Date getMonDateReviewed() {
        return monDateReviewed;
    }

    public String getMonIdDataEntry() {
        return monIdDataEntry;
    }

    public Date getMonDateEntered() {
        return monDateEntered;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

	public String getMonAddtMedicines() {
		return monAddtMedicines;
	}

	public String getMonAddtDrugsType() {
		return monAddtDrugsType;
	}

	public String getMonAddtOthDrugsType1() {
		return monAddtOthDrugsType1;
	}

	public String getMonAddtOthDrugsBrand1() {
		return monAddtOthDrugsBrand1;
	}

	public String getMonAddtOthDrugsType2() {
		return monAddtOthDrugsType2;
	}

	public String getMonAddtOthDrugsBrand2() {
		return monAddtOthDrugsBrand2;
	}

	public String getMonAddtOthDrugsType3() {
		return monAddtOthDrugsType3;
	}

	public String getMonAddtOthDrugsBrand3() {
		return monAddtOthDrugsBrand3;
	}

	public String getMonAddtOthDrugsType4() {
		return monAddtOthDrugsType4;
	}

	public String getMonAddtOthDrugsBrand4() {
		return monAddtOthDrugsBrand4;
	}

	public String getMonAddtOthDrugsType5() {
		return monAddtOthDrugsType5;
	}

	public String getMonAddtOthDrugsBrand5() {
		return monAddtOthDrugsBrand5;
	}

	public String getGroup1() {
		return group1;
	}

	public String getGroup2() {
		return group2;
	}

	public String getGroup3() {
		return group3;
	}

	public String getGroup4() {
		return group4;
	}

	public String getGroup5() {
		return group5;
	}

	public String getGroup6() {
		return group6;
	}

	public String getGroup7() {
		return group7;
	}

	public String getGroup8() {
		return group8;
	}

	public String getGroup9() {
		return group9;
	}

	public String getGroup10() {
		return group10;
	}

	public String getGroup11() {
		return group11;
	}

	public String getGroup12() {
		return group12;
	}

	public String getGroup13() {
		return group13;
	}

	public String getGroup14() {
		return group14;
	}

	public String getGroup15() {
		return group15;
	}

	public String getGroup16() {
		return group16;
	}

	public String getGroup17() {
		return group17;
	}

	public String getGroup18() {
		return group18;
	}

	public String getGroup19() {
		return group19;
	}

	public String getGroup20() {
		return group20;
	}

	public String getGroup21() {
		return group21;
	}

	public String getGroup22() {
		return group22;
	}

	public String getGroup23() {
		return group23;
	}

	public String getGroup24() {
		return group24;
	}

	public String getGroup25() {
		return group25;
	}

	public String getGroup26() {
		return group26;
	}

	public String getGroup27() {
		return group27;
	}

	public String getGroup28() {
		return group28;
	}

	public String getGroup29() {
		return group29;
	}

	public String getGroup30() {
		return group30;
	}

	public String getGroup31() {
		return group31;
	}

	public String getGroup32() {
		return group32;
	}

	public String getGroup33() {
		return group33;
	}

	public String getGroup34() {
		return group34;
	}

	public String getGroup35() {
		return group35;
	}

	public String getGroup36() {
		return group36;
	}

	public String getGroup37() {
		return group37;
	}

	public String getGroup38() {
		return group38;
	}

	public String getGroup39() {
		return group39;
	}

	public String getGroup40() {
		return group40;
	}

	public String getGroup41() {
		return group41;
	}

	public String getGroup42() {
		return group42;
	}

	public String getGroup43() {
		return group43;
	}

	public String getGroup44() {
		return group44;
	}

	public String getGroup45() {
		return group45;
	}

	public String getGroup46() {
		return group46;
	}

	public String getNote1() {
		return note1;
	}

	public String getNote2() {
		return note2;
	}

	public String getNote3() {
		return note3;
	}

	public String getNote4() {
		return note4;
	}

	public String getNote5() {
		return note5;
	}

	public String getNote6() {
		return note6;
	}

	public String getQuestion1() {
		return question1;
	}
    
    
}
