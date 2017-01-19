package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/28/2016.
 * V1.0
 */
public class Zp08StudyExitXml {

    @Element(required=false)
    private Date extStudyExitDate;
    @Element(required=false)
    private String extSubjClass;
    @Element(required=false)
    private String extStudyExitReason;
    @Element(required=false)
    private String extNonpregMatrnlDth;
    @Element(required=false)
    private String extAcuteHealthSpec;
    @Element(required=false)
    private String extHealthCondSpec;
    @Element(required=false)
    private String extFatalInjSpec;
    @Element(required=false)
    private String extInfDeathTime;
    @Element(required=false)
    private String extTestResultsRcvd;
    @Element(required=false)
    private String extCounselingRcvd;
    @Element(required=false)
    private String extComments;
    @Element(required=false)
    private String extIdCompleting;
    @Element(required=false)
    private Date extDateCompleted;
    @Element(required=false)
    private String extIdReviewer;
    @Element(required=false)
    private Date extDateReviewed;
    @Element(required=false)
    private String extIdDataEntry;
    @Element(required=false)
    private Date extDateEntered;

    @Element(required=false)
    private String note1;
    @Element(required=false)
    private String group1;
    @Element(required=false)
    private String group2;

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

    @Attribute(required=false)
    private String version;


    public Date getExtStudyExitDate() {
        return extStudyExitDate;
    }

    public String getExtSubjClass() {
        return extSubjClass;
    }

    public String getExtStudyExitReason() {
        return extStudyExitReason;
    }

    public String getExtNonpregMatrnlDth() {
        return extNonpregMatrnlDth;
    }

    public String getExtAcuteHealthSpec() {
        return extAcuteHealthSpec;
    }

    public String getExtHealthCondSpec() {
        return extHealthCondSpec;
    }

    public String getExtFatalInjSpec() {
        return extFatalInjSpec;
    }

    public String getExtInfDeathTime() {
        return extInfDeathTime;
    }

    public String getExtTestResultsRcvd() {
        return extTestResultsRcvd;
    }

    public String getExtCounselingRcvd() {
        return extCounselingRcvd;
    }

    public String getExtComments() {
        return extComments;
    }

    public String getExtIdCompleting() {
        return extIdCompleting;
    }

    public Date getExtDateCompleted() {
        return extDateCompleted;
    }

    public String getExtIdReviewer() {
        return extIdReviewer;
    }

    public Date getExtDateReviewed() {
        return extDateReviewed;
    }

    public String getExtIdDataEntry() {
        return extIdDataEntry;
    }

    public Date getExtDateEntered() {
        return extDateEntered;
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
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
}
