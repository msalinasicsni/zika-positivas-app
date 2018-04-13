package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 2/2/2017.
 * V1.0
 */
public class Zp07InfantAssessmentVisitXml {

    @Element(required = false)
    private Date infantVisitDate;
    @Element(required = false)
    private String infantStatus;
    @Element(required = false)
    private Date infantDeathDt;
    @Element(required = false)
    private String infantVisit;
    @Element(required = false)
    private Date infantVisitDate2;
    @Element(required = false)
    private String infantStatus2;
    @Element(required = false)
    private Date infantDeathDt2;
    @Element(required = false)
    private String infantVisit2;
    @Element(required = false)
    private Date infantVisitDate3;
    @Element(required = false)
    private String infantStatus3;
    @Element(required = false)
    private Date infantDeathDt3;
    @Element(required = false)
    private String infantVisit3;
    @Element(required = false)
    private Float infantTemp;
    @Element(required = false)
    private String infantTmpUnit;
    @Element(required = false)
    private Float infantWt;
    @Element(required = false)
    private String infantWtUnit;
    @Element(required = false)
    private Float infantWtPercen;
    @Element(required = false)
    private String infantWtpercenNa;
    @Element(required = false)
    private Float infantLength;
    @Element(required = false)
    private Float infantLengthPercen;
    @Element(required = false)
    private String infantLenpercenNa;
    @Element(required = false)
    private Float infantHeadcircu;
    @Element(required = false)
    private Float infantHeapercen;
    @Element(required = false)
    private String infantHeapercenNa;
    @Element(required = false)
    private String infantHeasize;
    @Element(required = false)
    private String infantApgarNa;
    @Element(required = false)
    private Float infantApgar1min;
    @Element(required = false)
    private Float infantApgar5min;
    @Element(required = false)
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
    private String infantOphthType;
    @Element(required=false)
    private String infantOphthAbno;
    @Element(required=false)
    private String infantOae;
    @Element(required=false)
    private String infantHearingTest;
    @Element(required=false)
    private String infantHearingOverall;
    @Element(required=false)
    private String infantRoae;
    @Element(required=false)
    private String infantRaabr;
    @Element(required=false)
    private String infantLoae;
    @Element(required=false)
    private String infantLaabr;
    @Element(required=false)
    private String infantBreastfeeding;
    @Element(required=false)
    private String infantBreastReason;//multiple
    @Element(required=false)
    private String infantBreastOther;
    @Element(required=false)
    private String infantNeurodeve;
  /*  @Element(required=false)
    private String infantExhibited; //multiple  no utilizado en v2.5 */
    @Element(required=false)
    private String infantAsymType;
    @Element(required=false)
    private String infantOtherMove;
    @Element(required=false)
    private String infantExhibitOther;
    @Element(required=false)
    private String infantMicroce;
    @Element(required=false)
    private String infantDefinition;
    @Element(required=false)
    private String infantFurtherNeuro;
    @Element(required=false)
    private String infantEvaluation;
    @Element(required=false)
    private String infantNeuroAsq;
    @Element(required=false)
    private Float infantAsqCommuni;
    @Element(required=false)
    private Float infantAsqGross;
    @Element(required=false)
    private Float infantAsqFine;
    @Element(required=false)
    private Float infantAsqProblem;
    @Element(required=false)
    private Float infantAsqPersonal;
    @Element(required=false)
    private String infantNeuroBisd;
    @Element(required=false)
    private Float infantCgScore;
    @Element(required=false)
    private String infantCgRisk;
    @Element(required=false)
    private Float infantRpScore;
    @Element(required=false)
    private String infantRpRisk;
    @Element(required=false)
    private Float infantEpScore;
    @Element(required=false)
    private String infantEpRisk;
    @Element(required=false)
    private Float infantFmScore;
    @Element(required=false)
    private String infantFmRisk;
    @Element(required=false)
    private Float infantGmScore;
    @Element(required=false)
    private String infantGmRisk;
    @Element(required=false)
    private String infantNeuroOther;
    @Element(required=false)
    private String infantOtherName;
    @Element(required=false)
    private Float infantOtherScore;
    @Element(required=false)
    private String infantResultScreening;
    @Element(required=false)
    private String infantReferTesting;
    @Element(required=false)
    private String infantFeverSymptom;
    @Element(required=false)
    private String infantRashSymptom;
    @Element(required=false)
    private String infantItch;
    @Element(required=false)
    private String infantRashFirst;
    @Element(required=false)
    private String infantRashDy;
    @Element(required=false)
    private String infantRashMn;
    @Element(required=false)
    private String infantRashYr;
    @Element(required=false)
    private Float infantRashDur;
    @Element(required=false)
    private String infantRashSpread;
    @Element(required=false)
    private String infantSpreadPart;
    @Element(required=false)
    private String infantFeverExperience;
    @Element(required=false)
    private String infantTempMeasure;
    @Element(required=false)
    private Float infantHighTemp;
    @Element(required=false)
    private String infantHightemUnit;
    @Element(required=false)
    private String infantTempunknown;
    @Element(required=false)
    private String infantFeverDy;
    @Element(required=false)
    private String infantFeverMn;
    @Element(required=false)
    private String infantFeverYr;
    @Element(required=false)
    private Float infantFeverDur;
    @Element(required=false)
    private String infantRedeyes;
    @Element(required=false)
    private String infantRedeyesDy;
    @Element(required=false)
    private String infantRedeyesMn;
    @Element(required=false)
    private String infantRedeyesYr;
    @Element(required=false)
    private Float infantRedeyesDur;
    @Element(required=false)
    private String infantJoint;
    @Element(required=false)
    private String infantJointDy;
    @Element(required=false)
    private String infantJointMn;
    @Element(required=false)
    private String infantJointYr;
    @Element(required=false)
    private Float infantJointDur;
    @Element(required=false)
    private String infantHeadache;
    @Element(required=false)
    private String infantHeadacheDy;
    @Element(required=false)
    private String infantHeadacheMn;
    @Element(required=false)
    private String infantHeadacheYr;
    @Element(required=false)
    private Float infantHeadaDur;
    @Element(required=false)
    private String infantSymptomOther;
    @Element(required=false)
    private String infantSpecifySymptom;
    @Element(required=false)
    private String infantOtherSymptom;
    @Element(required=false)
    private String infantMedicare;
    @Element(required=false)
    private String infantCareDy;
    @Element(required=false)
    private String infantCareMn;
    @Element(required=false)
    private String infantCareYr;
    @Element(required=false)
    private String infantCareFacility;
    @Element(required=false)
    private String infantHospitalized;
    @Element(required=false)
    private String infantHospital;
    @Element(required=false)
    private String infantDiagRubella;
    @Element(required=false)
    private String infantDiagDengue;
    @Element(required=false)
    private String infantDiagChikung;
    @Element(required=false)
    private String infantDiagZika;
    @Element(required=false)
    private String infantDiagCytome;
    @Element(required=false)
    private String infantMedicine;
    @Element(required=false)
    private String infantMedName;
    @Element(required=false)
    private String infantSpDiary;
    @Element(required=false)
    private String infantPreResults;
    @Element(required=false)
    private String infantReferr;
    @Element(required=false)
    private String infantOtherLab;
    @Element(required=false)
    private String infantCommentsYn;
    @Element(required=false)
    private String infantComments2;
    @Element(required=false)
    private String infantCommentsYn2;
    @Element(required=false)
    private String infantComments2_2;
    @Element(required=false)
    private String infantCommentsYn3;
    @Element(required=false)
    private String infantComments2_3;
    @Element(required=false)
    private String infantIdCompleting;
    @Element(required=false)
    private Date infantDtComp;
    @Element(required=false)
    private String infantIdReviewer;
    @Element(required=false)
    private Date infantDtReview;
    @Element(required=false)
    private String infantIdDataEntry;
    @Element(required=false)
    private Date infantDtEnter;
    @Element(required=false)
    private String infantIdCompleting2;
    @Element(required=false)
    private Date infantDtComp2;
    @Element(required=false)
    private String infantIdReviewer2;
    @Element(required=false)
    private Date infantDtReview2;
    @Element(required=false)
    private String infantIdDataEntry2;
    @Element(required=false)
    private Date infantDtEnter2;
    @Element(required=false)
    private String infantIdCompleting3;
    @Element(required=false)
    private Date infantDtComp3;
    @Element(required=false)
    private String infantIdReviewer3;
    @Element(required=false)
    private Date infantDtReview3;
    @Element(required=false)
    private String infantIdDataEntry3;
    @Element(required=false)
    private Date infantDtEnter3;
    @Element(required=false)
    private Integer part1;
    @Element(required=false)
    private Integer part2;
    @Element(required=false)
    private Integer part3;
    @Element(required=false)
    private Integer idInstancia2;
    @Element(required=false)
    private Integer idInstancia3;

    //v2.5
    @Element(required=false)
    private Date infantHearDt; //version 2.5
    @Element(required=false)
    private Date infantNeuroDt; //version 2.5
    @Element(required=false)
    private String infantExhibited1; //version 2.5
    @Element(required=false)
    private String infantExhibited2; //version 2.5
    @Element(required=false)
    private String infantExhibited3; //version 2.5
    @Element(required=false)
    private String infantExhibited4; //version 2.5
    @Element(required=false)
    private String infantExhibited5; //version 2.5
    @Element(required=false)
    private String infantExhibited6; //version 2.5
    @Element(required=false)
    private String infantExhibited7; //version 2.5
    @Element(required=false)
    private String infantExhibited8; //version 2.5
    @Element(required=false)
    private String infantExhibited9; //version 2.5
    @Element(required=false)
    private String infantExhibited10; //version 2.5
    @Element(required=false)
    private String infantExhibited11; //version 2.5
    @Element(required=false)
    private String infantExhibited12; //version 2.5
    @Element(required=false)
    private String infantExhibited13; //version 2.5
    @Element(required=false)
    private String infantExhibited14; //version 2.5
    @Element(required=false)
    private Date infantNedeveDt;  //version 2.5
    @Element(required=false)
    private Date infantOpDt; //version 2.5


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

    //v2.5
    @Element(required=false)
    private String group24;


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

    @Element(required=false)
    private Date infantDob;
    @Element(required=false)
    private Integer infantWeeks;
    @Element(required=false)
    private Integer infantDays;
    
    
    @Element(required=false)
    private Integer group23;
    @Element(required=false)
    private Integer noteB;
    @Element(required=false)
    private Integer infantDaysAfterBirth;

    public Date getInfantDob() {
		return infantDob;
	}

	public Integer getInfantWeeks() {
		return infantWeeks;
	}

	public Integer getInfantDays() {
		return infantDays;
	}

	public void setInfantDob(Date infantDob) {
		this.infantDob = infantDob;
	}

	public void setInfantWeeks(Integer infantWeeks) {
		this.infantWeeks = infantWeeks;
	}

	public void setInfantDays(Integer infantDays) {
		this.infantDays = infantDays;
	}
	
    public Date getInfantVisitDate() {
        return infantVisitDate;
    }

    public String getInfantStatus() {
        return infantStatus;
    }

    public Date getInfantDeathDt() {
        return infantDeathDt;
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

    public String getInfantOae() {
        return infantOae;
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

  /*  public String getInfantExhibited() {
        return infantExhibited;
    }*/

    public String getInfantFurtherNeuro() {
        return infantFurtherNeuro;
    }

    public String getInfantIdCompleting() {
        return infantIdCompleting;
    }

    public String getInfantIdReviewer() {
        return infantIdReviewer;
    }

    public String getInfantIdDataEntry() {
        return infantIdDataEntry;
    }

    public String getInfantHeasize() {
        return infantHeasize;
    }

    public String getInfantOphthType() {
        return infantOphthType;
    }

    public String getInfantHearingTest() {
        return infantHearingTest;
    }

    public String getInfantHearingOverall() {
        return infantHearingOverall;
    }

    public String getInfantRoae() {
        return infantRoae;
    }

    public String getInfantRaabr() {
        return infantRaabr;
    }

    public String getInfantLoae() {
        return infantLoae;
    }

    public String getInfantLaabr() {
        return infantLaabr;
    }

    public String getInfantAsymType() {
        return infantAsymType;
    }

    public String getInfantOtherMove() {
        return infantOtherMove;
    }

    public String getInfantExhibitOther() {
        return infantExhibitOther;
    }

    public String getInfantMicroce() {
        return infantMicroce;
    }

    public String getInfantDefinition() {
        return infantDefinition;
    }

    public String getInfantEvaluation() {
        return infantEvaluation;
    }

    public String getInfantNeuroAsq() {
        return infantNeuroAsq;
    }

    public Float getInfantAsqCommuni() {
        return infantAsqCommuni;
    }

    public Float getInfantAsqGross() {
        return infantAsqGross;
    }

    public Float getInfantAsqFine() {
        return infantAsqFine;
    }

    public Float getInfantAsqProblem() {
        return infantAsqProblem;
    }

    public Float getInfantAsqPersonal() {
        return infantAsqPersonal;
    }

    public String getInfantNeuroBisd() {
        return infantNeuroBisd;
    }

    public Float getInfantCgScore() {
        return infantCgScore;
    }

    public String getInfantCgRisk() {
        return infantCgRisk;
    }

    public Float getInfantRpScore() {
        return infantRpScore;
    }

    public String getInfantRpRisk() {
        return infantRpRisk;
    }

    public Float getInfantEpScore() {
        return infantEpScore;
    }

    public String getInfantEpRisk() {
        return infantEpRisk;
    }

    public Float getInfantFmScore() {
        return infantFmScore;
    }

    public String getInfantFmRisk() {
        return infantFmRisk;
    }

    public Float getInfantGmScore() {
        return infantGmScore;
    }

    public String getInfantGmRisk() {
        return infantGmRisk;
    }

    public String getInfantNeuroOther() {
        return infantNeuroOther;
    }

    public String getInfantOtherName() {
        return infantOtherName;
    }

    public Float getInfantOtherScore() {
        return infantOtherScore;
    }

    public String getInfantResultScreening() {
        return infantResultScreening;
    }

    public String getInfantReferTesting() {
        return infantReferTesting;
    }

    public String getInfantFeverSymptom() {
        return infantFeverSymptom;
    }

    public String getInfantRashSymptom() {
        return infantRashSymptom;
    }

    public String getInfantItch() {
        return infantItch;
    }

    public String getInfantRashFirst() {
        return infantRashFirst;
    }

    public String getInfantRashDy() {
        return infantRashDy;
    }

    public String getInfantRashMn() {
        return infantRashMn;
    }

    public String getInfantRashYr() {
        return infantRashYr;
    }

    public Float getInfantRashDur() {
        return infantRashDur;
    }

    public String getInfantRashSpread() {
        return infantRashSpread;
    }

    public String getInfantSpreadPart() {
        return infantSpreadPart;
    }

    public String getInfantFeverExperience() {
        return infantFeverExperience;
    }

    public String getInfantTempMeasure() {
        return infantTempMeasure;
    }

    public Float getInfantHighTemp() {
        return infantHighTemp;
    }

    public String getInfantHightemUnit() {
        return infantHightemUnit;
    }

    public String getInfantTempunknown() {
        return infantTempunknown;
    }

    public String getInfantFeverDy() {
        return infantFeverDy;
    }

    public String getInfantFeverMn() {
        return infantFeverMn;
    }

    public String getInfantFeverYr() {
        return infantFeverYr;
    }

    public Float getInfantFeverDur() {
        return infantFeverDur;
    }

    public String getInfantRedeyes() {
        return infantRedeyes;
    }

    public String getInfantRedeyesDy() {
        return infantRedeyesDy;
    }

    public String getInfantRedeyesMn() {
        return infantRedeyesMn;
    }

    public String getInfantRedeyesYr() {
        return infantRedeyesYr;
    }

    public Float getInfantRedeyesDur() {
        return infantRedeyesDur;
    }

    public String getInfantJoint() {
        return infantJoint;
    }

    public String getInfantJointDy() {
        return infantJointDy;
    }

    public String getInfantJointMn() {
        return infantJointMn;
    }

    public String getInfantJointYr() {
        return infantJointYr;
    }

    public Float getInfantJointDur() {
        return infantJointDur;
    }

    public String getInfantHeadache() {
        return infantHeadache;
    }

    public String getInfantHeadacheDy() {
        return infantHeadacheDy;
    }

    public String getInfantHeadacheMn() {
        return infantHeadacheMn;
    }

    public String getInfantHeadacheYr() {
        return infantHeadacheYr;
    }

    public Float getInfantHeadaDur() {
        return infantHeadaDur;
    }

    public String getInfantSymptomOther() {
        return infantSymptomOther;
    }

    public String getInfantSpecifySymptom() {
        return infantSpecifySymptom;
    }

    public String getInfantOtherSymptom() {
        return infantOtherSymptom;
    }

    public String getInfantMedicare() {
        return infantMedicare;
    }

    public String getInfantCareDy() {
        return infantCareDy;
    }

    public String getInfantCareMn() {
        return infantCareMn;
    }

    public String getInfantCareYr() {
        return infantCareYr;
    }

    public String getInfantCareFacility() {
        return infantCareFacility;
    }

    public String getInfantHospitalized() {
        return infantHospitalized;
    }

    public String getInfantHospital() {
        return infantHospital;
    }

    public String getInfantDiagRubella() {
        return infantDiagRubella;
    }

    public String getInfantDiagDengue() {
        return infantDiagDengue;
    }

    public String getInfantDiagChikung() {
        return infantDiagChikung;
    }

    public String getInfantDiagZika() {
        return infantDiagZika;
    }

    public String getInfantDiagCytome() {
        return infantDiagCytome;
    }

    public String getInfantMedicine() {
        return infantMedicine;
    }

    public String getInfantMedName() {
        return infantMedName;
    }

    public String getInfantSpDiary() {
        return infantSpDiary;
    }

    public String getInfantPreResults() {
        return infantPreResults;
    }

    public String getInfantReferr() {
        return infantReferr;
    }

    public String getInfantOtherLab() {
        return infantOtherLab;
    }

    public String getInfantCommentsYn() {
        return infantCommentsYn;
    }

    public String getInfantComments2() {
        return infantComments2;
    }

    public Date getInfantDtComp() {
        return infantDtComp;
    }

    public Date getInfantDtReview() {
        return infantDtReview;
    }

    public Date getInfantDtEnter() {
        return infantDtEnter;
    }

    public Date getInfantVisitDate2() {
        return infantVisitDate2;
    }

    public String getInfantStatus2() {
        return infantStatus2;
    }

    public Date getInfantDeathDt2() {
        return infantDeathDt2;
    }

    public String getInfantVisit2() {
        return infantVisit2;
    }

    public Date getInfantVisitDate3() {
        return infantVisitDate3;
    }

    public String getInfantStatus3() {
        return infantStatus3;
    }

    public Date getInfantDeathDt3() {
        return infantDeathDt3;
    }

    public String getInfantVisit3() {
        return infantVisit3;
    }

    public String getInfantCommentsYn2() {
        return infantCommentsYn2;
    }

    public String getInfantComments2_2() {
        return infantComments2_2;
    }

    public String getInfantCommentsYn3() {
        return infantCommentsYn3;
    }

    public String getInfantComments2_3() {
        return infantComments2_3;
    }

    public String getInfantIdCompleting2() {
        return infantIdCompleting2;
    }

    public Date getInfantDtComp2() {
        return infantDtComp2;
    }

    public String getInfantIdReviewer2() {
        return infantIdReviewer2;
    }

    public Date getInfantDtReview2() {
        return infantDtReview2;
    }

    public String getInfantIdDataEntry2() {
        return infantIdDataEntry2;
    }

    public Date getInfantDtEnter2() {
        return infantDtEnter2;
    }

    public String getInfantIdCompleting3() {
        return infantIdCompleting3;
    }

    public Date getInfantDtComp3() {
        return infantDtComp3;
    }

    public String getInfantIdReviewer3() {
        return infantIdReviewer3;
    }

    public Date getInfantDtReview3() {
        return infantDtReview3;
    }

    public String getInfantIdDataEntry3() {
        return infantIdDataEntry3;
    }

    public Date getInfantDtEnter3() {
        return infantDtEnter3;
    }

    public Integer getPart1() {
        return part1;
    }

    public Integer getPart2() {
        return part2;
    }

    public Integer getPart3() {
        return part3;
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

    public String getQuestion2() {
        return question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public Integer getIdInstancia2() {
        return idInstancia2;
    }

    public void setIdInstancia2(Integer idInstancia2) {
        this.idInstancia2 = idInstancia2;
    }

    public Integer getIdInstancia3() {
        return idInstancia3;
    }

    public void setIdInstancia3(Integer idInstancia3) {
        this.idInstancia3 = idInstancia3;
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

    public Date getInfantHearDt() {
        return infantHearDt;
    }

    public Date getInfantNeuroDt() {
        return infantNeuroDt;
    }

    public String getInfantExhibited1() {
        return infantExhibited1;
    }

    public String getInfantExhibited2() {
        return infantExhibited2;
    }

    public String getInfantExhibited3() {
        return infantExhibited3;
    }

    public String getInfantExhibited4() {
        return infantExhibited4;
    }

    public String getInfantExhibited5() {
        return infantExhibited5;
    }

    public String getInfantExhibited6() {
        return infantExhibited6;
    }

    public String getInfantExhibited7() {
        return infantExhibited7;
    }

    public String getInfantExhibited8() {
        return infantExhibited8;
    }

    public String getInfantExhibited9() {
        return infantExhibited9;
    }

    public String getInfantExhibited10() {
        return infantExhibited10;
    }

    public String getInfantExhibited11() {
        return infantExhibited11;
    }

    public String getInfantExhibited12() {
        return infantExhibited12;
    }

    public String getInfantExhibited13() {
        return infantExhibited13;
    }

    public String getInfantExhibited14() {
        return infantExhibited14;
    }

    public Date getInfantNedeveDt() {
        return infantNedeveDt;
    }

    public Date getInfantOpDt() {
        return infantOpDt;
    }
}
