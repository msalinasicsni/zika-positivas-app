package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by ics on 23/1/2018.
 */
public class Zp00aInfantScreeningXml {

    @Element(required=true)
    private Date infVisitDt;
    @Element(required=true)
    private String infRemain;
    @Element(required=true)
    private String infConsent;
    @Element(required=false)
    private String infConsenta;
    @Element(required=false)
    private String infConsentb;
    @Element(required=false)
    private String infConsentc;
    @Element(required=false)
    private String infConsentd;
    @Element(required=false)
    private String infInfid;
    @Element(required=false)
    private String infReasonno;
    @Element(required=false)
    private String infReasonOther;

    @Element(required=false)
    private String note1;
    @Element(required=false)
    private String group1;
    @Element(required=false)
    private String group2;
    @Element(required=false)
    private String group3;
    @Element(required=false)
    private String group4;

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
    @Attribute(required = false)
    private String version;

    public Date getInfVisitDt() {
        return infVisitDt;
    }

    public String getInfRemain() {
        return infRemain;
    }

    public String getInfConsent() {
        return infConsent;
    }

    public String getInfConsenta() {
        return infConsenta;
    }

    public String getInfConsentb() {
        return infConsentb;
    }

    public String getInfConsentc() {
        return infConsentc;
    }

    public String getInfConsentd() {
        return infConsentd;
    }

    public String getInfInfid() {
        return infInfid;
    }

    public String getInfReasonno() {
        return infReasonno;
    }

    public String getInfReasonOther() {
        return infReasonOther;
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
