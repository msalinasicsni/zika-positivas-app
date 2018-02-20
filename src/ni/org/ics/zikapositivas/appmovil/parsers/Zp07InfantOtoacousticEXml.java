package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by ics on 2/2/2017.
 * V1.0
 */
public class Zp07InfantOtoacousticEXml {

    @Element(required = false)
    private Date infantVisitDate;
    @Element(required = false)
    private String infantStatus;
    @Element(required = false)
    private String infantVisit;
    @Element(required = false)
    private Integer infantAgeMonths;
    @Element(required = false)
    private String infantOae;
    @Element(required=false)
    private String infantOphthType;
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
    private String infantComments2;
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
    private String group1;
    @Element(required=false)
    private String group2;

    @Element(required=false)
    private String note1;

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

    public Integer getInfantAgeMonths() {
        return infantAgeMonths;
    }

    public void setInfantAgeMonths(Integer infantAgeMonths) {
        this.infantAgeMonths = infantAgeMonths;
    }

    public String getInfantOae() {
        return infantOae;
    }

    public void setInfantOae(String infantOae) {
        this.infantOae = infantOae;
    }

    public String getInfantOphthType() {
        return infantOphthType;
    }

    public void setInfantOphthType(String infantOphthType) {
        this.infantOphthType = infantOphthType;
    }

    public String getInfantHearingOverall() {
        return infantHearingOverall;
    }

    public void setInfantHearingOverall(String infantHearingOverall) {
        this.infantHearingOverall = infantHearingOverall;
    }

    public String getInfantRoae() {
        return infantRoae;
    }

    public void setInfantRoae(String infantRoae) {
        this.infantRoae = infantRoae;
    }

    public String getInfantRaabr() {
        return infantRaabr;
    }

    public void setInfantRaabr(String infantRaabr) {
        this.infantRaabr = infantRaabr;
    }

    public String getInfantLoae() {
        return infantLoae;
    }

    public void setInfantLoae(String infantLoae) {
        this.infantLoae = infantLoae;
    }

    public String getInfantLaabr() {
        return infantLaabr;
    }

    public void setInfantLaabr(String infantLaabr) {
        this.infantLaabr = infantLaabr;
    }

    public String getInfantComments2() {
        return infantComments2;
    }

    public void setInfantComments2(String infantComments2) {
        this.infantComments2 = infantComments2;
    }

    public String getInfantIdCompleting() {
        return infantIdCompleting;
    }

    public void setInfantIdCompleting(String infantIdCompleting) {
        this.infantIdCompleting = infantIdCompleting;
    }

    public Date getInfantDtComp() {
        return infantDtComp;
    }

    public void setInfantDtComp(Date infantDtComp) {
        this.infantDtComp = infantDtComp;
    }

    public String getInfantIdReviewer() {
        return infantIdReviewer;
    }

    public void setInfantIdReviewer(String infantIdReviewer) {
        this.infantIdReviewer = infantIdReviewer;
    }

    public Date getInfantDtReview() {
        return infantDtReview;
    }

    public void setInfantDtReview(Date infantDtReview) {
        this.infantDtReview = infantDtReview;
    }

    public String getInfantIdDataEntry() {
        return infantIdDataEntry;
    }

    public void setInfantIdDataEntry(String infantIdDataEntry) {
        this.infantIdDataEntry = infantIdDataEntry;
    }

    public Date getInfantDtEnter() {
        return infantDtEnter;
    }

    public void setInfantDtEnter(Date infantDtEnter) {
        this.infantDtEnter = infantDtEnter;
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
