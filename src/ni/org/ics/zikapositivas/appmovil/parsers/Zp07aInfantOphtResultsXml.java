package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07aInfantOphtResultsXml {

    @Element(required = false)
    private Date infantOphthDt;
    @Element(required = false)
    private String infantOphType;
    @Element(required = false)
    private String infantEyeCalci;
    @Element(required = false)
    private String infantChoriore;
    @Element(required = false)
    private String infantFocalPm;
    @Element(required = false)
    private String infantChorioreAtro;
    @Element(required = false)
    private String infantMicroph;
    @Element(required = false)
    private String infantMicrocornea;
    @Element(required = false)
    private String infantIrisColobo;
    @Element(required = false)
    private String infantOpticNerve;
    @Element(required = false)
    private String infantSubLuxated;
    @Element(required = false)
    private String infantStrabismus;
    @Element(required = false)
    private String infantEyeOther;
    @Element(required = false)
    private String infantEyeOtherSpecify;
    @Element(required = false)
    private String infantReferralOphth;

    @Element(required = false)
    private String infantEyeFile;

    @Element(required = false)
    private String infantEyeCom;
    @Element(required = false)
    private String infantEyComdetail;
    @Element(required = false)
    private String infantEyidCom;
    @Element(required = false)
    private Date infantEydtCom;
    @Element(required = false)
    private String infantEyidRevi;
    @Element(required = false)
    private Date infantEydtRevi;
    @Element(required = false)
    private String infantEyidEntry;
    @Element(required = false)
    private Date infantEydtEnt;


    @Element(required=false)
    private String group1;
    @Element(required=false)
    private String group2;
    @Element(required=false)
    private String group3;
    @Element(required=false)
    private String group4;

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


    public Date getInfantOphthDt() {
        return infantOphthDt;
    }

    public String getInfantOphType() {
        return infantOphType;
    }

    public String getInfantEyeCalci() {
        return infantEyeCalci;
    }

    public String getInfantChoriore() {
        return infantChoriore;
    }

    public String getInfantFocalPm() {
        return infantFocalPm;
    }

    public String getInfantChorioreAtro() {
        return infantChorioreAtro;
    }

    public String getInfantMicroph() {
        return infantMicroph;
    }

    public String getInfantMicrocornea() {
        return infantMicrocornea;
    }

    public String getInfantIrisColobo() {
        return infantIrisColobo;
    }

    public String getInfantOpticNerve() {
        return infantOpticNerve;
    }

    public String getInfantSubLuxated() {
        return infantSubLuxated;
    }

    public String getInfantStrabismus() {
        return infantStrabismus;
    }

    public String getInfantEyeOther() {
        return infantEyeOther;
    }

    public String getInfantEyeOtherSpecify() {
        return infantEyeOtherSpecify;
    }

    public String getInfantReferralOphth() {
        return infantReferralOphth;
    }

    public String getInfantEyeFile() {
        return infantEyeFile;
    }

    public String getInfantEyeCom() {
        return infantEyeCom;
    }

    public String getInfantEyComdetail() {
        return infantEyComdetail;
    }

    public String getInfantEyidCom() {
        return infantEyidCom;
    }

    public Date getInfantEydtCom() {
        return infantEydtCom;
    }

    public String getInfantEyidRevi() {
        return infantEyidRevi;
    }

    public Date getInfantEydtRevi() {
        return infantEydtRevi;
    }

    public String getInfantEyidEntry() {
        return infantEyidEntry;
    }

    public Date getInfantEydtEnt() {
        return infantEydtEnt;
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
