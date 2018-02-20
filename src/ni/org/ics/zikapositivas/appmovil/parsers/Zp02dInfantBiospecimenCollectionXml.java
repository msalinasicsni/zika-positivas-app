package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 2/2/2017.
 * V1.0
 */
public class Zp02dInfantBiospecimenCollectionXml {

    @Element(required=false)
    private Date infantDov;
    @Element(required=false)
    private String whomAddtVisit;
    @Element(required=false)
    private String infantAddtVisit;
    @Element(required=false)
    private String infantAddtVisitOther;
    @Element(required=false)
    private String infantMatBldCol;
    @Element(required=false)
    private String infantMatBldRsn;
    @Element(required=false)
    private String infantMatBldSpecify;
    @Element(required=false)
    private String infantMatBldTyp1;
    @Element(required=false)
    private String infantMatBldId1;
    @Element(required=false)
    private Float infantMatBldVol1;
    @Element(required=false)
    private String infantMatBldTyp2;
    @Element(required=false)
    private String infantMatBldId2;
    @Element(required=false)
    private Float infantMatBldVol2;
    @Element(required=false)
    private String infantMatBldTyp3;
    @Element(required=false)
    private String infantMatBldId3;
    @Element(required=false)
    private Float infantMatBldVol3;
    @Element(required=false)
    private String infantMatBldTyp4;
    @Element(required=false)
    private String infantMatBldId4;
    @Element(required=false)
    private Float infantMatBldVol4;
    @Element(required=false)
    private String infantMatBldTyp5;
    @Element(required=false)
    private String infantMatBldId5;
    @Element(required=false)
    private Float infantMatBldVol5;
    @Element(required=false)
    private String infantMatBldTyp6;
    @Element(required=false)
    private String infantMatBldId6;
    @Element(required=false)
    private Float infantMatBldVol6;
    @Element(required=false)
    private String infantMatBldTyp7;
    @Element(required=false)
    private String infantMatBldId7;
    @Element(required=false)
    private Float infantMatBldVol7;
    @Element(required=false)
    private String infantMatBldTyp8;
    @Element(required=false)
    private String infantMatBldId8;
    @Element(required=false)
    private Float infantMatBldVol8;
    @Element(required=false)
    private Float infantMatBldTotVol;
    @Element(required=false)
    private String infantMatBldTime;
    @Element(required=false)
    private String infantMatBldCom;
    @Element(required=false)
    private String infantMatSlvaCol;
    @Element(required=false)
    private String infantMatSlvaRsn;
    @Element(required=false)
    private String infantMatSlvaSpecify;
    @Element(required=false)
    private String infantMatSlvaId;
    @Element(required=false)
    private String infantMatSlvaTime;
    @Element(required=false)
    private String infantMatSlvaCom;
    @Element(required=false)
    private String infantMatVstUrnCol;
    @Element(required=false)
    private String infantMatVstUrnRsn;
    @Element(required=false)
    private String infantMatVstUrnSpecify;
    @Element(required=false)
    private String infantMatVstUrnId;
    @Element(required=false)
    private String infantMatVstUrnTime;
    @Element(required=false)
    private String infantMatVstUrnCom;
    @Element(required=false)
    private String infantPerson1;
    @Element(required=false)
    private Date infantCompleteDate1;
    @Element(required=false)
    private String infantPerson2;
    @Element(required=false)
    private Date infantCompleteDate2;
    @Element(required=false)
    private String infantPerson3;
    @Element(required=false)
    private Date infantCompleteDate3;

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
    private String note1;

    @Element(required=false)
    private String question1;
    @Element(required=false)
    private String question2;
    @Element(required=false)
    private String question3;
    @Element(required=false)
    private String question4;
    @Element(required=false)
    private String question5;
    @Element(required=false)
    private String question6;
    @Element(required=false)
    private String question7;
    @Element(required=false)
    private String question8;
    @Element(required=false)
    private String question9;
    @Element(required=false)
    private String question10;
    @Element(required=false)
    private String question11;

    @Element(required=false)
    private String barcode1;
    @Element(required=false)
    private String barcode2;
    @Element(required=false)
    private String barcode3;
    @Element(required=false)
    private String barcode4;
    @Element(required=false)
    private String barcode5;
    @Element(required=false)
    private String barcode6;
    @Element(required=false)
    private String barcode7;
    @Element(required=false)
    private String barcode8;
    @Element(required=false)
    private String barcode9;
    @Element(required=false)
    private String barcode10;

    @Element(required=false)
    private String text1;
    @Element(required=false)
    private String text2;
    @Element(required=false)
    private String text3;
    @Element(required=false)
    private String text4;
    @Element(required=false)
    private String text5;
    @Element(required=false)
    private String text6;
    @Element(required=false)
    private String text7;
    @Element(required=false)
    private String text8;
    @Element(required=false)
    private String text9;
    @Element(required=false)
    private String text10;

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


    public Date getInfantDov() {
        return infantDov;
    }

    public String getWhomAddtVisit() {
        return whomAddtVisit;
    }

    public String getInfantAddtVisit() {
        return infantAddtVisit;
    }

    public String getInfantAddtVisitOther() {
        return infantAddtVisitOther;
    }

    public String getInfantMatBldCol() {
        return infantMatBldCol;
    }

    public String getInfantMatBldRsn() {
        return infantMatBldRsn;
    }

    public String getInfantMatBldSpecify() {
        return infantMatBldSpecify;
    }

    public String getInfantMatBldTyp1() {
        return infantMatBldTyp1;
    }

    public String getInfantMatBldId1() {
        return infantMatBldId1;
    }

    public String getInfantMatBldTyp2() {
        return infantMatBldTyp2;
    }

    public String getInfantMatBldId2() {
        return infantMatBldId2;
    }

    public String getInfantMatBldTyp3() {
        return infantMatBldTyp3;
    }

    public String getInfantMatBldId3() {
        return infantMatBldId3;
    }

    public String getInfantMatBldTyp4() {
        return infantMatBldTyp4;
    }

    public String getInfantMatBldId4() {
        return infantMatBldId4;
    }

    public String getInfantMatBldTyp5() {
        return infantMatBldTyp5;
    }

    public String getInfantMatBldId5() {
        return infantMatBldId5;
    }

    public String getInfantMatBldTyp6() {
        return infantMatBldTyp6;
    }

    public String getInfantMatBldId6() {
        return infantMatBldId6;
    }

    public String getInfantMatBldTyp7() {
        return infantMatBldTyp7;
    }

    public String getInfantMatBldId7() {
        return infantMatBldId7;
    }

    public String getInfantMatBldTyp8() {
        return infantMatBldTyp8;
    }

    public String getInfantMatBldId8() {
        return infantMatBldId8;
    }

    public String getInfantMatBldTime() {
        return infantMatBldTime;
    }

    public String getInfantMatBldCom() {
        return infantMatBldCom;
    }

    public String getInfantMatSlvaCol() {
        return infantMatSlvaCol;
    }

    public String getInfantMatSlvaRsn() {
        return infantMatSlvaRsn;
    }

    public String getInfantMatSlvaSpecify() {
        return infantMatSlvaSpecify;
    }

    public String getInfantMatSlvaId() {
        return infantMatSlvaId;
    }

    public String getInfantMatSlvaTime() {
        return infantMatSlvaTime;
    }

    public String getInfantMatSlvaCom() {
        return infantMatSlvaCom;
    }

    public String getInfantMatVstUrnCol() {
        return infantMatVstUrnCol;
    }

    public String getInfantMatVstUrnRsn() {
        return infantMatVstUrnRsn;
    }

    public String getInfantMatVstUrnSpecify() {
        return infantMatVstUrnSpecify;
    }

    public String getInfantMatVstUrnId() {
        return infantMatVstUrnId;
    }

    public String getInfantMatVstUrnTime() {
        return infantMatVstUrnTime;
    }

    public String getInfantMatVstUrnCom() {
        return infantMatVstUrnCom;
    }

    public String getInfantPerson1() {
        return infantPerson1;
    }

    public Date getInfantCompleteDate1() {
        return infantCompleteDate1;
    }

    public String getInfantPerson2() {
        return infantPerson2;
    }

    public Date getInfantCompleteDate2() {
        return infantCompleteDate2;
    }

    public String getInfantPerson3() {
        return infantPerson3;
    }

    public Date getInfantCompleteDate3() {
        return infantCompleteDate3;
    }

    public Float getInfantMatBldVol1() {
        return infantMatBldVol1;
    }

    public Float getInfantMatBldVol2() {
        return infantMatBldVol2;
    }

    public Float getInfantMatBldVol3() {
        return infantMatBldVol3;
    }

    public Float getInfantMatBldVol4() {
        return infantMatBldVol4;
    }

    public Float getInfantMatBldVol5() {
        return infantMatBldVol5;
    }

    public Float getInfantMatBldVol6() {
        return infantMatBldVol6;
    }

    public Float getInfantMatBldVol7() {
        return infantMatBldVol7;
    }

    public Float getInfantMatBldVol8() {
        return infantMatBldVol8;
    }

    public Float getInfantMatBldTotVol() {
        return infantMatBldTotVol;
    }

    public String getQuestion1() {
        return question1;
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
