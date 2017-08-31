package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/28/2016.
 * V1.0
 */
public class Zp06DeliveryAnd6weekVisitXml {

    @Element(required=false)
    private Date deliVisitDate;
    @Element(required=false)
    private String deliVisitStatus;
    @Element(required=false)
    private String deliVisitType;
    @Element(required=false)
    private Float deliMotherWt;
    @Element(required=false)
    private String deliWtUnit;
    @Element(required=false)
    private Integer deliSystolic;
    @Element(required=false)
    private Integer deliDiastolic;
    @Element(required=false)
    private Float deliTemperature;
    @Element(required=false)
    private String deliTempUnit;
    @Element(required=false)
    private Date deliDeliveryDate;
    @Element(required=false)
    private String deliMode;
    @Element(required=false)
    private String deliDeliveryWho;
    @Element(required=false)
    private String deliDeliveryOccur;
    @Element(required=false)
    private String deliHospitalId;
    @Element(required=false)
    private String deliClinicId;
    @Element(required=false)
    private String deliDeliveryOther;
    @Element(required=false)
    private String deliNumBirth;
    @Element(required=false)
    private String deliFetalOutcome1;
    @Element(required=false)
    private String deliCauseDeath1;
    @Element(required=false)
    private String deliSexBaby1;
    @Element(required=false)
    private String deliFetalOutcome2;
    @Element(required=false)
    private String deliCauseDeath2;
    @Element(required=false)
    private String deliSexBaby2;
    @Element(required=false)
    private String deliFetalOutcome3;
    @Element(required=false)
    private String deliCauseDeath3;
    @Element(required=false)
    private String deliSexBaby3;
    @Element(required=false)
    private String deliConsentInfant;
    @Element(required=false)
    private String deliReasonNoconsent;
    @Element(required=false)
    private String deliNoconsentOther;
    @Element(required=false)
    private String deliFeverSymptom;
    @Element(required=false)
    private String deliRash;
    @Element(required=false)
    private String deliItch;
    @Element(required=false)
    private String deliRashFirst;
    @Element(required=false)
    private String deliRashDay;
    @Element(required=false)
    private String deliRashMonth;
    @Element(required=false)
    private String deliRashYear;
    @Element(required=false)
    private Integer deliRashDuration;
    @Element(required=false)
    private String deliRashSpread;
    @Element(required=false)
    private String deliSpreadPart;
    @Element(required=false)
    private String deliFeverExperience;
    @Element(required=false)
    private String deliTempMeasure;
    @Element(required=false)
    private Float deliHighTemp;
    @Element(required=false)
    private String deliHightemUnit;
    @Element(required=false)
    private String deliTempunknown;
    @Element(required=false)
    private String deliFeverDay;
    @Element(required=false)
    private String deliFeverMonth;
    @Element(required=false)
    private String deliFeverYear;
    @Element(required=false)
    private Integer deliFeverDuration;
    @Element(required=false)
    private String deliRedeyes;
    @Element(required=false)
    private String deliRedeyesDay;
    @Element(required=false)
    private String deliRedeyesMonth;
    @Element(required=false)
    private String deliRedeyesYear;
    @Element(required=false)
    private Integer deliRedeyesDuration;
    @Element(required=false)
    private String deliJoint;
    @Element(required=false)
    private String deliJointDay;
    @Element(required=false)
    private String deliJointMonth;
    @Element(required=false)
    private String deliJointYear;
    @Element(required=false)
    private Integer deliJointDuration;
    @Element(required=false)
    private String deliHeadache;
    @Element(required=false)
    private String deliHeadacheDay;
    @Element(required=false)
    private String deliHeadacheMonth;
    @Element(required=false)
    private String deliHeadacheYear;
    @Element(required=false)
    private Integer deliHeadacheDuration;
    @Element(required=false)
    private String deliSymptomOther;
    @Element(required=false)
    private String deliSpecifySymptom;
    @Element(required=false)
    private String deliOtherSymptom;
    @Element(required=false)
    private String deliMedicare;
    @Element(required=false)
    private String deliCareDay;
    @Element(required=false)
    private String deliCareMonth;
    @Element(required=false)
    private String deliCareYear;
    @Element(required=false)
    private String deliCareFacility;
    @Element(required=false)
    private String deliHospitalized;
    @Element(required=false)
    private String deliHospital;
    @Element(required=false)
    private String deliDiagRubella;
    @Element(required=false)
    private String deliDiagDengue;
    @Element(required=false)
    private String deliDiagChikung;
    @Element(required=false)
    private String deliDiagZika;
    @Element(required=false)
    private String deliDiagCytome;
    @Element(required=false)
    private String deliMedicine;
    @Element(required=false)
    private String deliMedcineName;
    @Element(required=false)
    private String deliSymptomDiary;
    @Element(required=false)
    private String deliGuillainbarre;
    @Element(required=false)
    private String deliTingling;
    @Element(required=false)
    private String deliTinglingArm;
    @Element(required=false)
    private String deliTinglingLeg;
    @Element(required=false)
    private String deliTinglingHand;
    @Element(required=false)
    private String deliTinglingFoot;
    @Element(required=false)
    private String deliTinglingFace;
    @Element(required=false)
    private String deliTinglingOther;
    @Element(required=false)
    private Integer deliSensationMin;
    @Element(required=false)
    private Integer deliSensationHr;
    @Element(required=false)
    private Integer deliSenstaionDay;
    @Element(required=false)
    private String deliInjury;
    @Element(required=false)
    private String deliTinglingDay;
    @Element(required=false)
    private String deliTinglingMonth;
    @Element(required=false)
    private String deliTinglingYear;
    @Element(required=false)
    private Integer deliTinglingDuration;
    @Element(required=false)
    private String deliNumbness;
    @Element(required=false)
    private String deliNumbArm;
    @Element(required=false)
    private String deliNumbLeg;
    @Element(required=false)
    private String deliNumbHand;
    @Element(required=false)
    private String deliNumbFoot;
    @Element(required=false)
    private String deliNumbFace;
    @Element(required=false)
    private String deliNumbOther;
    @Element(required=false)
    private String deliNumbDay;
    @Element(required=false)
    private String deliNumbMonth;
    @Element(required=false)
    private String deliNumbYear;
    @Element(required=false)
    private Integer deliNumbDuration;
    @Element(required=false)
    private String deliParalysis;
    @Element(required=false)
    private String deliParaArm;
    @Element(required=false)
    private String deliParaLeg;
    @Element(required=false)
    private String deliParaHand;
    @Element(required=false)
    private String deliParaFoot;
    @Element(required=false)
    private String deliParaFace;
    @Element(required=false)
    private String deliParaOther;
    @Element(required=false)
    private String deliParaDay;
    @Element(required=false)
    private String deliParaMonth;
    @Element(required=false)
    private String deliParaYear;
    @Element(required=false)
    private Integer deliParaDuration;
    @Element(required=false)
    private String deliResultsProvided;
    @Element(required=false)
    private String deliCounseling;
    @Element(required=false)
    private String deliResultsOther;
    @Element(required=false)
    private String deliIdCompleting;
    @Element(required=false)
    private Date deliDateCompleted;
    @Element(required=false)
    private String deliIdReviewer;
    @Element(required=false)
    private Date deliDateReviewed;
    @Element(required=false)
    private String deliIdDataEntry;
    @Element(required=false)
    private Date deliDateEntered;
    
    @Element(required=false)
    private String deliHyperDisease;
    @Element(required=false)
    private String deliPreterm1;
    @Element(required=false)
    private String deliPreterm2;
    @Element(required=false)
    private String deliPreterm3;
    @Element(required=false)
    private String deliDeliverEarly;

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
    private String note1;
    @Element(required=false)
    private String note2;

    @Element(required=false)
    private String question1;
    @Element(required=false)
    private String question2;
    @Element(required=false)
    private String question3;
    @Element(required=false)
    private String question4;

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

    public Date getDeliVisitDate() {
        return deliVisitDate;
    }

    public String getDeliVisitStatus() {
        return deliVisitStatus;
    }

    public String getDeliVisitType() {
        return deliVisitType;
    }

    public Float getDeliMotherWt() {
        return deliMotherWt;
    }

    public String getDeliWtUnit() {
        return deliWtUnit;
    }

    public Integer getDeliSystolic() {
        return deliSystolic;
    }

    public Integer getDeliDiastolic() {
        return deliDiastolic;
    }

    public Float getDeliTemperature() {
        return deliTemperature;
    }

    public String getDeliTempUnit() {
        return deliTempUnit;
    }

    public Date getDeliDeliveryDate() {
        return deliDeliveryDate;
    }

    public String getDeliMode() {
        return deliMode;
    }

    public String getDeliDeliveryWho() {
        return deliDeliveryWho;
    }

    public String getDeliDeliveryOccur() {
        return deliDeliveryOccur;
    }

    public String getDeliHospitalId() {
        return deliHospitalId;
    }

    public String getDeliClinicId() {
        return deliClinicId;
    }

    public String getDeliDeliveryOther() {
        return deliDeliveryOther;
    }

    public String getDeliNumBirth() {
        return deliNumBirth;
    }

    public String getDeliFetalOutcome1() {
        return deliFetalOutcome1;
    }

    public String getDeliCauseDeath1() {
        return deliCauseDeath1;
    }

    public String getDeliSexBaby1() {
        return deliSexBaby1;
    }

    public String getDeliFetalOutcome2() {
        return deliFetalOutcome2;
    }

    public String getDeliCauseDeath2() {
        return deliCauseDeath2;
    }

    public String getDeliSexBaby2() {
        return deliSexBaby2;
    }

    public String getDeliFetalOutcome3() {
        return deliFetalOutcome3;
    }

    public String getDeliCauseDeath3() {
        return deliCauseDeath3;
    }

    public String getDeliSexBaby3() {
        return deliSexBaby3;
    }

    public String getDeliConsentInfant() {
        return deliConsentInfant;
    }

    public String getDeliReasonNoconsent() {
        return deliReasonNoconsent;
    }

    public String getDeliNoconsentOther() {
        return deliNoconsentOther;
    }

    public String getDeliFeverSymptom() {
        return deliFeverSymptom;
    }

    public String getDeliRash() {
        return deliRash;
    }

    public String getDeliItch() {
        return deliItch;
    }

    public String getDeliRashFirst() {
        return deliRashFirst;
    }

    public String getDeliRashDay() {
        return deliRashDay;
    }

    public String getDeliRashMonth() {
        return deliRashMonth;
    }

    public String getDeliRashYear() {
        return deliRashYear;
    }

    public Integer getDeliRashDuration() {
        return deliRashDuration;
    }

    public String getDeliRashSpread() {
        return deliRashSpread;
    }

    public String getDeliSpreadPart() {
        return deliSpreadPart;
    }

    public String getDeliFeverExperience() {
        return deliFeverExperience;
    }

    public String getDeliTempMeasure() {
        return deliTempMeasure;
    }

    public Float getDeliHighTemp() {
        return deliHighTemp;
    }

    public String getDeliHightemUnit() {
        return deliHightemUnit;
    }

    public String getDeliTempunknown() {
        return deliTempunknown;
    }

    public String getDeliFeverDay() {
        return deliFeverDay;
    }

    public String getDeliFeverMonth() {
        return deliFeverMonth;
    }

    public String getDeliFeverYear() {
        return deliFeverYear;
    }

    public Integer getDeliFeverDuration() {
        return deliFeverDuration;
    }

    public String getDeliRedeyes() {
        return deliRedeyes;
    }

    public String getDeliRedeyesDay() {
        return deliRedeyesDay;
    }

    public String getDeliRedeyesMonth() {
        return deliRedeyesMonth;
    }

    public String getDeliRedeyesYear() {
        return deliRedeyesYear;
    }

    public Integer getDeliRedeyesDuration() {
        return deliRedeyesDuration;
    }

    public String getDeliJoint() {
        return deliJoint;
    }

    public String getDeliJointDay() {
        return deliJointDay;
    }

    public String getDeliJointMonth() {
        return deliJointMonth;
    }

    public String getDeliJointYear() {
        return deliJointYear;
    }

    public Integer getDeliJointDuration() {
        return deliJointDuration;
    }

    public String getDeliHeadache() {
        return deliHeadache;
    }

    public String getDeliHeadacheDay() {
        return deliHeadacheDay;
    }

    public String getDeliHeadacheMonth() {
        return deliHeadacheMonth;
    }

    public String getDeliHeadacheYear() {
        return deliHeadacheYear;
    }

    public Integer getDeliHeadacheDuration() {
        return deliHeadacheDuration;
    }

    public String getDeliSymptomOther() {
        return deliSymptomOther;
    }

    public String getDeliSpecifySymptom() {
        return deliSpecifySymptom;
    }

    public String getDeliOtherSymptom() {
        return deliOtherSymptom;
    }

    public String getDeliMedicare() {
        return deliMedicare;
    }

    public String getDeliCareDay() {
        return deliCareDay;
    }

    public String getDeliCareMonth() {
        return deliCareMonth;
    }

    public String getDeliCareYear() {
        return deliCareYear;
    }

    public String getDeliCareFacility() {
        return deliCareFacility;
    }

    public String getDeliHospitalized() {
        return deliHospitalized;
    }

    public String getDeliHospital() {
        return deliHospital;
    }

    public String getDeliDiagRubella() {
        return deliDiagRubella;
    }

    public String getDeliDiagDengue() {
        return deliDiagDengue;
    }

    public String getDeliDiagChikung() {
        return deliDiagChikung;
    }

    public String getDeliDiagZika() {
        return deliDiagZika;
    }

    public String getDeliDiagCytome() {
        return deliDiagCytome;
    }

    public String getDeliMedicine() {
        return deliMedicine;
    }

    public String getDeliMedcineName() {
        return deliMedcineName;
    }

    public String getDeliSymptomDiary() {
        return deliSymptomDiary;
    }

    public String getDeliGuillainbarre() {
        return deliGuillainbarre;
    }

    public String getDeliTingling() {
        return deliTingling;
    }

    public String getDeliTinglingArm() {
        return deliTinglingArm;
    }

    public String getDeliTinglingLeg() {
        return deliTinglingLeg;
    }

    public String getDeliTinglingHand() {
        return deliTinglingHand;
    }

    public String getDeliTinglingFoot() {
        return deliTinglingFoot;
    }

    public String getDeliTinglingFace() {
        return deliTinglingFace;
    }

    public String getDeliTinglingOther() {
        return deliTinglingOther;
    }

    public Integer getDeliSensationMin() {
        return deliSensationMin;
    }

    public Integer getDeliSensationHr() {
        return deliSensationHr;
    }

    public Integer getDeliSenstaionDay() {
        return deliSenstaionDay;
    }

    public String getDeliInjury() {
        return deliInjury;
    }

    public String getDeliTinglingDay() {
        return deliTinglingDay;
    }

    public String getDeliTinglingMonth() {
        return deliTinglingMonth;
    }

    public String getDeliTinglingYear() {
        return deliTinglingYear;
    }

    public Integer getDeliTinglingDuration() {
        return deliTinglingDuration;
    }

    public String getDeliNumbness() {
        return deliNumbness;
    }

    public String getDeliNumbArm() {
        return deliNumbArm;
    }

    public String getDeliNumbLeg() {
        return deliNumbLeg;
    }

    public String getDeliNumbHand() {
        return deliNumbHand;
    }

    public String getDeliNumbFoot() {
        return deliNumbFoot;
    }

    public String getDeliNumbFace() {
        return deliNumbFace;
    }

    public String getDeliNumbOther() {
        return deliNumbOther;
    }

    public String getDeliNumbDay() {
        return deliNumbDay;
    }

    public String getDeliNumbMonth() {
        return deliNumbMonth;
    }

    public String getDeliNumbYear() {
        return deliNumbYear;
    }

    public Integer getDeliNumbDuration() {
        return deliNumbDuration;
    }

    public String getDeliParalysis() {
        return deliParalysis;
    }

    public String getDeliParaArm() {
        return deliParaArm;
    }

    public String getDeliParaLeg() {
        return deliParaLeg;
    }

    public String getDeliParaHand() {
        return deliParaHand;
    }

    public String getDeliParaFoot() {
        return deliParaFoot;
    }

    public String getDeliParaFace() {
        return deliParaFace;
    }

    public String getDeliParaOther() {
        return deliParaOther;
    }

    public String getDeliParaDay() {
        return deliParaDay;
    }

    public String getDeliParaMonth() {
        return deliParaMonth;
    }

    public String getDeliParaYear() {
        return deliParaYear;
    }

    public Integer getDeliParaDuration() {
        return deliParaDuration;
    }

    public String getDeliResultsProvided() {
        return deliResultsProvided;
    }

    public String getDeliCounseling() {
        return deliCounseling;
    }

    public String getDeliResultsOther() {
        return deliResultsOther;
    }

    public String getDeliIdCompleting() {
        return deliIdCompleting;
    }

    public Date getDeliDateCompleted() {
        return deliDateCompleted;
    }

    public String getDeliIdReviewer() {
        return deliIdReviewer;
    }

    public Date getDeliDateReviewed() {
        return deliDateReviewed;
    }

    public String getDeliIdDataEntry() {
        return deliIdDataEntry;
    }

    public Date getDeliDateEntered() {
        return deliDateEntered;
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
    
    public String getDeliPreterm1() {
		return deliPreterm1;
	}

	public String getDeliPreterm2() {
		return deliPreterm2;
	}

	public String getDeliPreterm3() {
		return deliPreterm3;
	}

	public void setDeliPreterm1(String deliPreterm1) {
		this.deliPreterm1 = deliPreterm1;
	}

	public void setDeliPreterm2(String deliPreterm2) {
		this.deliPreterm2 = deliPreterm2;
	}

	public void setDeliPreterm3(String deliPreterm3) {
		this.deliPreterm3 = deliPreterm3;
	}

	public String getDeliHyperDisease() {
		return deliHyperDisease;
	}

	public String getDeliDeliverEarly() {
		return deliDeliverEarly;
	}

	public void setDeliHyperDisease(String deliHyperDisease) {
		this.deliHyperDisease = deliHyperDisease;
	}

	public void setDeliDeliverEarly(String deliDeliverEarly) {
		this.deliDeliverEarly = deliDeliverEarly;
	}
}
