package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by ics on 20/6/2017.
 */
public class Zp07cInfantImageStudiesXml {

    @Element(required = false)
    private Date infantImageDt;
    @Element(required = false)
    private String infantHeadAltra;
    @Element(required = false)
    private String infantUltraObtained;
    @Element(required = false)
    private Date infantUltraDt;
    @Element(required = false)
    private String infantResultsSpecify;
    @Element(required = false)
    private String infantUltraOther;
    @Element(required = false)
    private String infantUltraFile;
    @Element(required = false)
    private String infantHeadCt;
    @Element(required = false)
    private String infantCtObtained;
    @Element(required = false)
    private Date infantCtDt;
    @Element(required = false)
    private String infantCtspecify;
    @Element(required = false)
    private String infantCtotherSpecify;
    @Element(required = false)
    private String infantCtFile;
    @Element(required = false)
    private String infantCerebrospinal;
    @Element(required = false)
    private String infantCerebroStored;
    @Element(required = false)
    private Date infantCerebroDt;
    @Element(required = false)
    private Float infantCerebroAmount;
    @Element(required = false)
    private String infantResultsCerebro;
    @Element(required = false)
    private String infantCerebroSpecify;
    @Element(required = false)
    private String infantMri;
    @Element(required = false)
    private String infantMriObtained;
    @Element(required = false)
    private Date infantMriDt;
    @Element(required = false)
    private String infantMriSpecify;
    @Element(required = false)
    private String infantMriotherSpecify;
    @Element(required = false)
    private String infantMriFile;
    @Element(required = false)
    private String infantIgcom;
    @Element(required = false)
    private String infantIgcomDetail;
    @Element(required = false)
    private String infantIgidCom;
    @Element(required = false)
    private Date infantIgdtCom;
    @Element(required = false)
    private String infantIgeyeIdRevi;
    @Element(required = false)
    private Date infantIgdtRevi;
    @Element(required = false)
    private String infantIgidEntry;
    @Element(required = false)
    private Date infantIgdateEnt;

    @Element(required = false)
    private String group1;
    @Element(required = false)
    private String group2;
    @Element(required = false)
    private String group3;

    @Element(required = false)
    private String note1;

    @Attribute
    private String id;
    @Attribute(required = false)
    private String version;
    @Element(required = false)
    private Meta meta;

    @Element(required = false)
    private String start;
    @Element(required = false)
    private String end;
    @Element(required = false)
    private String deviceid;
    @Element(required = false)
    private String simserial;
    @Element(required = false)
    private String phonenumber;
    @Element(required = false)
    private String imei;
    @Element(required = false)
    private Date today;

    public Date getInfantImageDt() {
        return infantImageDt;
    }

    public String getInfantHeadAltra() {
        return infantHeadAltra;
    }

    public String getInfantUltraObtained() {
        return infantUltraObtained;
    }

    public Date getInfantUltraDt() {
        return infantUltraDt;
    }

    public String getInfantResultsSpecify() {
        return infantResultsSpecify;
    }

    public String getInfantUltraOther() {
        return infantUltraOther;
    }

    public String getInfantUltraFile() {
        return infantUltraFile;
    }

    public String getInfantHeadCt() {
        return infantHeadCt;
    }

    public String getInfantCtObtained() {
        return infantCtObtained;
    }

    public Date getInfantCtDt() {
        return infantCtDt;
    }

    public String getInfantCtspecify() {
        return infantCtspecify;
    }

    public String getInfantCtotherSpecify() {
        return infantCtotherSpecify;
    }

    public String getInfantCtFile() {
        return infantCtFile;
    }

    public String getInfantCerebrospinal() {
        return infantCerebrospinal;
    }

    public String getInfantCerebroStored() {
        return infantCerebroStored;
    }

    public Date getInfantCerebroDt() {
        return infantCerebroDt;
    }

    public Float getInfantCerebroAmount() {
        return infantCerebroAmount;
    }

    public String getInfantResultsCerebro() {
        return infantResultsCerebro;
    }

    public String getInfantCerebroSpecify() {
        return infantCerebroSpecify;
    }

    public String getInfantMri() {
        return infantMri;
    }

    public String getInfantMriObtained() {
        return infantMriObtained;
    }

    public Date getInfantMriDt() {
        return infantMriDt;
    }

    public String getInfantMriSpecify() {
        return infantMriSpecify;
    }

    public String getInfantMriotherSpecify() {
        return infantMriotherSpecify;
    }

    public String getInfantMriFile() {
        return infantMriFile;
    }

    public String getInfantIgcom() {
        return infantIgcom;
    }

    public String getInfantIgcomDetail() {
        return infantIgcomDetail;
    }

    public String getInfantIgidCom() {
        return infantIgidCom;
    }

    public Date getInfantIgdtCom() {
        return infantIgdtCom;
    }

    public String getInfantIgeyeIdRevi() {
        return infantIgeyeIdRevi;
    }

    public Date getInfantIgdtRevi() {
        return infantIgdtRevi;
    }

    public String getInfantIgidEntry() {
        return infantIgidEntry;
    }

    public Date getInfantIgdateEnt() {
        return infantIgdateEnt;
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
