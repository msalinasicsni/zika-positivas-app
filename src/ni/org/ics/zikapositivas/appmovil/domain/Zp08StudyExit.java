package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/11/2016.
 * V1.0
 */

public class Zp08StudyExit extends BaseMetaData{

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String redcapEventName;
    private Date extStudyExitDate;
    private String extSubjClass;
    private String extStudyExitReason;
    private String extNonpregMatrnlDth;
    private String extAcuteHealthSpec;
    private String extHealthCondSpec;
    private String extFatalInjSpec;
    private String extInfDeathTime;
    private String extTestResultsRcvd;
    private String extCounselingRcvd;
    private String extComments;
    private String extIdCompleting;
    private Date extDateCompleted;
    private String extIdReviewer;
    private Date extDateReviewed;
    private String extIdDataEntry;
    private Date extDateEntered;


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

	public Date getExtStudyExitDate() {
        return extStudyExitDate;
    }

    public void setExtStudyExitDate(Date extStudyExitDate) {
        this.extStudyExitDate = extStudyExitDate;
    }

    public String getExtSubjClass() {
        return extSubjClass;
    }

    public void setExtSubjClass(String extSubjClass) {
        this.extSubjClass = extSubjClass;
    }

    public String getExtStudyExitReason() {
        return extStudyExitReason;
    }

    public void setExtStudyExitReason(String extStudyExitReason) {
        this.extStudyExitReason = extStudyExitReason;
    }

    public String getExtNonpregMatrnlDth() {
        return extNonpregMatrnlDth;
    }

    public void setExtNonpregMatrnlDth(String extNonpregMatrnlDth) {
        this.extNonpregMatrnlDth = extNonpregMatrnlDth;
    }

    public String getExtAcuteHealthSpec() {
        return extAcuteHealthSpec;
    }

    public void setExtAcuteHealthSpec(String extAcuteHealthSpec) {
        this.extAcuteHealthSpec = extAcuteHealthSpec;
    }

    public String getExtHealthCondSpec() {
        return extHealthCondSpec;
    }

    public void setExtHealthCondSpec(String extHealthCondSpec) {
        this.extHealthCondSpec = extHealthCondSpec;
    }

    public String getExtFatalInjSpec() {
        return extFatalInjSpec;
    }

    public void setExtFatalInjSpec(String extFatalInjSpec) {
        this.extFatalInjSpec = extFatalInjSpec;
    }

    public String getExtInfDeathTime() {
        return extInfDeathTime;
    }

    public void setExtInfDeathTime(String extInfDeathTime) {
        this.extInfDeathTime = extInfDeathTime;
    }

    public String getExtTestResultsRcvd() {
        return extTestResultsRcvd;
    }

    public void setExtTestResultsRcvd(String extTestResultsRcvd) {
        this.extTestResultsRcvd = extTestResultsRcvd;
    }

    public String getExtCounselingRcvd() {
        return extCounselingRcvd;
    }

    public void setExtCounselingRcvd(String extCounselingRcvd) {
        this.extCounselingRcvd = extCounselingRcvd;
    }

    public String getExtComments() { return extComments; }

    public void setExtComments(String extComments) { this.extComments = extComments; }

    public String getExtIdCompleting() {
        return extIdCompleting;
    }

    public void setExtIdCompleting(String extIdCompleting) {
        this.extIdCompleting = extIdCompleting;
    }

    public Date getExtDateCompleted() {
        return extDateCompleted;
    }

    public void setExtDateCompleted(Date extDateCompleted) {
        this.extDateCompleted = extDateCompleted;
    }

    public String getExtIdReviewer() {
        return extIdReviewer;
    }

    public void setExtIdReviewer(String extIdReviewer) {
        this.extIdReviewer = extIdReviewer;
    }

    public Date getExtDateReviewed() {
        return extDateReviewed;
    }

    public void setExtDateReviewed(Date extDateReviewed) {
        this.extDateReviewed = extDateReviewed;
    }

    public String getExtIdDataEntry() {
        return extIdDataEntry;
    }

    public void setExtIdDataEntry(String extIdDataEntry) {
        this.extIdDataEntry = extIdDataEntry;
    }

    public Date getExtDateEntered() {
        return extDateEntered;
    }

    public void setExtDateEntered(Date extDateEntered) {
        this.extDateEntered = extDateEntered;
    }
}
