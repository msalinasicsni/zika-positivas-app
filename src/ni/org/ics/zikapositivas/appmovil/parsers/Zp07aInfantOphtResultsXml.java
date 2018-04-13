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

    //v2.6
    @Element(required = false)
    private String infantMicrocep;
    @Element(required = false)
    private String infantCongCataract;
    @Element(required = false)
    private String infantGlaucoma;
    @Element(required = false)
    private String infantMyopia;
    @Element(required = false)
    private String infantBlindness;
    @Element(required = false)
    private String infantOtherDisease;
    @Element(required = false)
    private String infantOtherSpecify;
    @Element(required = false)
    private Float infantGestAge;
    @Element(required = false)
    private String infantLight;
    @Element(required = false)
    private String infantFixFollow;
    @Element(required = false)
    private String infantFacialExpression;
    @Element(required = false)
    private String infantSmile;
    @Element(required = false)
    private String infantPtosis;
    @Element(required = false)
    private String infantCataract;
    @Element(required = false)
    private String infantOtherLens;
    @Element(required = false)
    private String infantLenOhterSpec;
    @Element(required = false)
    private String infantNystagmus;
    @Element(required = false)
    private String infantIntraPress;
    @Element(required = false)
    private Integer infantTonoLeft;
    @Element(required = false)
    private Integer infantTonoRight;
    @Element(required = false)
    private String infantFocalSpecify;
    @Element(required = false)
    private String infantAbnoVascu;
    @Element(required = false)
    private String infantFovealLoss;
    @Element(required = false)
    private String infantRetinaColoboma;
    @Element(required = false)
    private String infantAtrophy;
    @Element(required = false)
    private String infantColoboma;
    @Element(required = false)
    private Float infantDiscLeft;
    @Element(required = false)
    private Float infantDiscRight;
    @Element(required = false)
    private String infantHypoplasia;


    @Element(required=false)
    private String group1;
    @Element(required=false)
    private String group2;
    @Element(required=false)
    private String group3;
    @Element(required=false)
    private String group4;

    //v2.6
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
    private String note1;

    //2.6
    @Element(required=false)
    private String note2;


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

    public String getInfantMicrocep() {
        return infantMicrocep;
    }

    public String getInfantCongCataract() {
        return infantCongCataract;
    }

    public String getInfantGlaucoma() {
        return infantGlaucoma;
    }

    public String getInfantMyopia() {
        return infantMyopia;
    }

    public String getInfantBlindness() {
        return infantBlindness;
    }

    public String getInfantOtherDisease() {
        return infantOtherDisease;
    }

    public String getInfantOtherSpecify() {
        return infantOtherSpecify;
    }

    public Float getInfantGestAge() {
        return infantGestAge;
    }

    public String getInfantLight() {
        return infantLight;
    }

    public String getInfantFixFollow() {
        return infantFixFollow;
    }

    public String getInfantFacialExpression() {
        return infantFacialExpression;
    }

    public String getInfantSmile() {
        return infantSmile;
    }

    public String getInfantPtosis() {
        return infantPtosis;
    }

    public String getInfantCataract() {
        return infantCataract;
    }

    public String getInfantOtherLens() {
        return infantOtherLens;
    }

    public String getInfantLenOhterSpec() {
        return infantLenOhterSpec;
    }

    public String getInfantNystagmus() {
        return infantNystagmus;
    }

    public String getInfantIntraPress() {
        return infantIntraPress;
    }

    public Integer getInfantTonoLeft() {
        return infantTonoLeft;
    }

    public Integer getInfantTonoRight() {
        return infantTonoRight;
    }

    public String getInfantFocalSpecify() {
        return infantFocalSpecify;
    }

    public String getInfantAbnoVascu() {
        return infantAbnoVascu;
    }

    public String getInfantFovealLoss() {
        return infantFovealLoss;
    }

    public String getInfantRetinaColoboma() {
        return infantRetinaColoboma;
    }

    public String getInfantAtrophy() {
        return infantAtrophy;
    }

    public String getInfantColoboma() {
        return infantColoboma;
    }

    public Float getInfantDiscLeft() {
        return infantDiscLeft;
    }

    public Float getInfantDiscRight() {
        return infantDiscRight;
    }

    public String getInfantHypoplasia() {
        return infantHypoplasia;
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
