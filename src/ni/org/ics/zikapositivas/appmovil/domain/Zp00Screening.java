package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/6/2016.
 * V1.0
 */
public class Zp00Screening extends BaseMetaData{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recordId;
	private String preScreenId;
	private String redcapEventName;
    private Date scrVisitDate;
    private String scrRemain;
    private Integer scrAge;
    private String scrAge15;
    private String scrPregnant;
    private Integer scrPreWeeks;
    private Integer scrPreDays;
    private String scrPregant13;
    private String scrZikaOther;
    private String scrMeetCriteria;
    private String scrConsentObta;
    private String scrObDobDay;
    private String scrObDobMon;
    private Integer scrObDobYear;
    private Integer scrObAge;
    private String scrObAssent;
    private String scrConsentA;
    private String scrConsentB;
    private String scrConsentC;
    private String scrConsentD;
    private String scrConsentE;
    private String scrConsentF;
    private String scrPreviousZikaPos;
    private String scrPreviousStudyId;
    private String scrPreStudyNa;
    private String scrReasonNot;
    private String scrReasonOther;
    private String scrIdCompleting;
    private Date scrDateCompleted;
    private String scrIdReviewer;
    private Date scrDateReviewed;
    private String scrIdDataEntry;
    private Date scrDateEntered;
    
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

	public String getPreScreenId() {
		return preScreenId;
	}

	public void setPreScreenId(String preScreenId) {
		this.preScreenId = preScreenId;
	}

	public Date getScrVisitDate() {
        return scrVisitDate;
    }

    public void setScrVisitDate(Date scrVisitDate) {
        this.scrVisitDate = scrVisitDate;
    }

    public String getScrRemain() {
        return scrRemain;
    }

    public void setScrRemain(String scrRemain) {
        this.scrRemain = scrRemain;
    }

    public Integer getScrAge() {
        return scrAge;
    }

    public void setScrAge(Integer scrAge) {
        this.scrAge = scrAge;
    }

    public String getScrAge15() {
        return scrAge15;
    }

    public void setScrAge15(String scrAge15) {
        this.scrAge15 = scrAge15;
    }

    public String getScrPregnant() {
        return scrPregnant;
    }

    public void setScrPregnant(String scrPregnant) {
        this.scrPregnant = scrPregnant;
    }

    public Integer getScrPreWeeks() {
        return scrPreWeeks;
    }

    public void setScrPreWeeks(Integer scrPreWeeks) {
        this.scrPreWeeks = scrPreWeeks;
    }

    public Integer getScrPreDays() {
        return scrPreDays;
    }

    public void setScrPreDays(Integer scrPreDays) {
        this.scrPreDays = scrPreDays;
    }

    public String getScrPregant13() {
        return scrPregant13;
    }

    public void setScrPregant13(String scrPregant13) {
        this.scrPregant13 = scrPregant13;
    }

    public String getScrZikaOther() {
        return scrZikaOther;
    }

    public void setScrZikaOther(String scrZikaOther) {
        this.scrZikaOther = scrZikaOther;
    }

    public String getScrMeetCriteria() {
        return scrMeetCriteria;
    }

    public void setScrMeetCriteria(String scrMeetCriteria) {
        this.scrMeetCriteria = scrMeetCriteria;
    }

    public String getScrConsentObta() {
        return scrConsentObta;
    }

    public void setScrConsentObta(String scrConsentObta) {
        this.scrConsentObta = scrConsentObta;
    }

    public String getScrObDobDay() {
        return scrObDobDay;
    }

    public void setScrObDobDay(String scrObDobDay) {
        this.scrObDobDay = scrObDobDay;
    }

    public String getScrObDobMon() {
        return scrObDobMon;
    }

    public void setScrObDobMon(String scrObDobMon) {
        this.scrObDobMon = scrObDobMon;
    }

    public Integer getScrObDobYear() {
        return scrObDobYear;
    }

    public void setScrObDobYear(Integer scrObDobYear) {
        this.scrObDobYear = scrObDobYear;
    }

    public Integer getScrObAge() {
        return scrObAge;
    }

    public void setScrObAge(Integer scrObAge) {
        this.scrObAge = scrObAge;
    }

    public String getScrObAssent() {
        return scrObAssent;
    }

    public void setScrObAssent(String scrObAssent) {
        this.scrObAssent = scrObAssent;
    }

    public String getScrConsentA() {
        return scrConsentA;
    }

    public void setScrConsentA(String scrConsentA) {
        this.scrConsentA = scrConsentA;
    }

    public String getScrConsentB() {
        return scrConsentB;
    }

    public void setScrConsentB(String scrConsentB) {
        this.scrConsentB = scrConsentB;
    }

    public String getScrConsentC() {
        return scrConsentC;
    }

    public void setScrConsentC(String scrConsentC) {
        this.scrConsentC = scrConsentC;
    }

    public String getScrConsentD() {
        return scrConsentD;
    }

    public void setScrConsentD(String scrConsentD) {
        this.scrConsentD = scrConsentD;
    }

    public String getScrConsentE() {
        return scrConsentE;
    }

    public void setScrConsentE(String scrConsentE) {
        this.scrConsentE = scrConsentE;
    }

    public String getScrConsentF() {
        return scrConsentF;
    }

    public void setScrConsentF(String scrConsentF) {
        this.scrConsentF = scrConsentF;
    }

    public String getScrPreviousZikaPos() {
        return scrPreviousZikaPos;
    }

    public void setScrPreviousZikaPos(String scrPreviousZikaPos) {
        this.scrPreviousZikaPos = scrPreviousZikaPos;
    }

    public String getScrPreviousStudyId() {
        return scrPreviousStudyId;
    }

    public void setScrPreviousStudyId(String scrPreviousStudyId) {
        this.scrPreviousStudyId = scrPreviousStudyId;
    }

    public String getScrPreStudyNa() {
        return scrPreStudyNa;
    }

    public void setScrPreStudyNa(String scrPreStudyNa) {
        this.scrPreStudyNa = scrPreStudyNa;
    }

    public String getScrReasonNot() {
        return scrReasonNot;
    }

    public void setScrReasonNot(String scrReasonNot) {
        this.scrReasonNot = scrReasonNot;
    }

    public String getScrReasonOther() {
        return scrReasonOther;
    }

    public void setScrReasonOther(String scrReasonOther) {
        this.scrReasonOther = scrReasonOther;
    }

    public String getScrIdCompleting() {
        return scrIdCompleting;
    }

    public void setScrIdCompleting(String scrIdCompleting) {
        this.scrIdCompleting = scrIdCompleting;
    }

    public Date getScrDateCompleted() {
        return scrDateCompleted;
    }

    public void setScrDateCompleted(Date scrDateCompleted) {
        this.scrDateCompleted = scrDateCompleted;
    }

    public String getScrIdReviewer() {
        return scrIdReviewer;
    }

    public void setScrIdReviewer(String scrIdReviewer) {
        this.scrIdReviewer = scrIdReviewer;
    }

    public Date getScrDateReviewed() {
        return scrDateReviewed;
    }

    public void setScrDateReviewed(Date scrDateReviewed) {
        this.scrDateReviewed = scrDateReviewed;
    }

    public String getScrIdDataEntry() {
        return scrIdDataEntry;
    }

    public void setScrIdDataEntry(String scrIdDataEntry) {
        this.scrIdDataEntry = scrIdDataEntry;
    }

    public Date getScrDateEntered() {
        return scrDateEntered;
    }

    public void setScrDateEntered(Date scrDateEntered) {
        this.scrDateEntered = scrDateEntered;
    }
}
