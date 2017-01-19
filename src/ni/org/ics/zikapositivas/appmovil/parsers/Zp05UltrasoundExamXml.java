package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/27/2016.
 * V1.0
 */
public class Zp05UltrasoundExamXml {

    @Element(required=false)
    private Date ultDate;
    @Element(required=false)
    private Integer ultGaWeeks;
    @Element(required=false)
    private Integer ultGaDays;
    @Element(required=false)
    private String ultGeDetermined;
    @Element(required=false)
    private String ultReason;
    @Element(required=false)
    private String ultReasonOther;
    @Element(required=false)
    private String ultTime;
    @Element(required=false)
    private String ultNameFacility;
    @Element(required=false)
    private String ultFacilityid;
    @Element(required=false)
    private String ultIdSonographer;
    @Element(required=false)
    private String ultIdNa;
    @Element(required=false)
    private Integer ultFestiGaWeeks1;
    @Element(required=false)
    private Integer ultFestiGaDays1;
    @Element(required=false)
    private Date ultFestiDelivery1;
    @Element(required=false)
    private String ultFirstYesno1;
    @Element(required=false)
    private String ultFabnormal1;
    @Element(required=false)
    private String ultFyesSpecify1; //multiple
    @Element(required=false)
    private String ultFotherFindings1;
    @Element(required=false)
    private String ultFurtherTesting1;
    @Element(required=false)
    private Integer ultFnumFetuses;
    @Element(required=false)
    private String ultFfetusViable1;
    @Element(required=false)
    private String ultFfetalCardia1;
    @Element(required=false)
    private Float ultFfetalHeart1;
    @Element(required=false)
    private Integer ultFcrl1;
    @Element(required=false)
    private String ultFcrlNa1;
    @Element(required=false)
    private String ultFfetusViable2;
    @Element(required=false)
    private String ultFfetalCardia2;
    @Element(required=false)
    private Float ultFfetalHeart2;
    @Element(required=false)
    private Integer ultFcrl2;
    @Element(required=false)
    private String ultFcrlNa2;
    @Element(required=false)
    private String ultFfetusViable3;
    @Element(required=false)
    private String ultFfetalCardia3;
    @Element(required=false)
    private Float ultFfetalHeart3;
    @Element(required=false)
    private Integer ultFcrl3;
    @Element(required=false)
    private String ultFcrlNa3;
    @Element(required=false)
    private String ultSfindings1;
    @Element(required=false)
    private String ultSspecify1;//multiple
    @Element(required=false)
    private String ultSfindingsSpecify1;
    @Element(required=false)
    private String ultFurtherExamination1;
    @Element(required=false)
    private String ultSplacental1;
    @Element(required=false)
    private Integer ultSnumFetuses;
    @Element(required=false)
    private String ultSfetusViable1;
    @Element(required=false)
    private String ultSfetalCardia1;
    @Element(required=false)
    private Float ultSfetalHeart1;
    @Element(required=false)
    private Integer ultSbiparietal1;
    @Element(required=false)
    private Integer ultShead1;
    @Element(required=false)
    private String ultMicroceph1;
    @Element(required=false)
    private String ultSevMicroceph1;
    @Element(required=false)
    private Integer ultSabdominal1;
    @Element(required=false)
    private Integer ultSfemur1;
    @Element(required=false)
    private Integer ultSfetalWt1;
    @Element(required=false)
    private String ultSpresentation1;
    @Element(required=false)
    private String ultSfetusViable2;
    @Element(required=false)
    private String ultSfetalCardia2;
    @Element(required=false)
    private Float ultSfetalHeart2;
    @Element(required=false)
    private Integer ultSbiparietal2;
    @Element(required=false)
    private Integer ultShead2;
    @Element(required=false)
    private String ultMicroceph2;
    @Element(required=false)
    private String ultSevMicroceph2;
    @Element(required=false)
    private Integer ultSabdominal2;
    @Element(required=false)
    private Integer ultSfemur2;
    @Element(required=false)
    private Integer ultSfetalWt2;
    @Element(required=false)
    private String ultSpresentation2;
    @Element(required=false)
    private String ultSfetusViable3;
    @Element(required=false)
    private String ultSfetalCardia3;
    @Element(required=false)
    private Float ultSfetalHeart3;
    @Element(required=false)
    private Integer ultSbiparietal3;
    @Element(required=false)
    private Integer ultShead3;
    @Element(required=false)
    private String ultMicroceph3;
    @Element(required=false)
    private String ultSevMicroceph3;
    @Element(required=false)
    private Integer ultSabdominal3;
    @Element(required=false)
    private Integer ultSfemur3;
    @Element(required=false)
    private Integer ultSfetalWt3;
    @Element(required=false)
    private String ultSpresentation3;
    @Element(required=false)
    private String ultIdCompleting;
    @Element(required=false)
    private Date ultDateCompleted;
    @Element(required=false)
    private String ultIdReviewer;
    @Element(required=false)
    private Date ultDateReviewed;
    @Element(required=false)
    private String ultIdDataEntry;
    @Element(required=false)
    private Date ultDateEntered;

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
    private String note2;
    @Element(required=false)
    private String note3;
    @Element(required=false)
    private String note4;

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

    public Date getUltDate() {
        return ultDate;
    }

    public Integer getUltGaWeeks() {
        return ultGaWeeks;
    }

    public Integer getUltGaDays() {
        return ultGaDays;
    }

    public String getUltGeDetermined() {
        return ultGeDetermined;
    }

    public String getUltReason() {
        return ultReason;
    }

    public String getUltReasonOther() {
        return ultReasonOther;
    }

    public String getUltTime() {
        return ultTime;
    }

    public String getUltNameFacility() {
        return ultNameFacility;
    }

    public String getUltFacilityid() {
        return ultFacilityid;
    }

    public String getUltIdSonographer() {
        return ultIdSonographer;
    }

    public String getUltIdNa() {
        return ultIdNa;
    }

    public Integer getUltFestiGaWeeks1() {
        return ultFestiGaWeeks1;
    }

    public Integer getUltFestiGaDays1() {
        return ultFestiGaDays1;
    }

    public Date getUltFestiDelivery1() {
        return ultFestiDelivery1;
    }

    public String getUltFirstYesno1() {
        return ultFirstYesno1;
    }

    public String getUltFabnormal1() {
        return ultFabnormal1;
    }

    public String getUltFyesSpecify1() {
        return ultFyesSpecify1;
    }

    public String getUltFotherFindings1() {
        return ultFotherFindings1;
    }

    public String getUltFurtherTesting1() {
        return ultFurtherTesting1;
    }

    public Integer getUltFnumFetuses() {
        return ultFnumFetuses;
    }

    public String getUltFfetusViable1() {
        return ultFfetusViable1;
    }

    public String getUltFfetalCardia1() {
        return ultFfetalCardia1;
    }

    public Float getUltFfetalHeart1() {
        return ultFfetalHeart1;
    }

    public Integer getUltFcrl1() {
        return ultFcrl1;
    }

    public String getUltFcrlNa1() {
        return ultFcrlNa1;
    }

    public String getUltFfetusViable2() {
        return ultFfetusViable2;
    }

    public String getUltFfetalCardia2() {
        return ultFfetalCardia2;
    }

    public Float getUltFfetalHeart2() {
        return ultFfetalHeart2;
    }

    public Integer getUltFcrl2() {
        return ultFcrl2;
    }

    public String getUltFcrlNa2() {
        return ultFcrlNa2;
    }

    public String getUltFfetusViable3() {
        return ultFfetusViable3;
    }

    public String getUltFfetalCardia3() {
        return ultFfetalCardia3;
    }

    public Float getUltFfetalHeart3() {
        return ultFfetalHeart3;
    }

    public Integer getUltFcrl3() {
        return ultFcrl3;
    }

    public String getUltFcrlNa3() {
        return ultFcrlNa3;
    }

    public String getUltSfindings1() {
        return ultSfindings1;
    }

    public String getUltSspecify1() {
        return ultSspecify1;
    }

    public String getUltSfindingsSpecify1() {
        return ultSfindingsSpecify1;
    }

    public String getUltFurtherExamination1() {
        return ultFurtherExamination1;
    }

    public String getUltSplacental1() {
        return ultSplacental1;
    }

    public Integer getUltSnumFetuses() {
        return ultSnumFetuses;
    }

    public String getUltSfetusViable1() {
        return ultSfetusViable1;
    }

    public String getUltSfetalCardia1() {
        return ultSfetalCardia1;
    }

    public Float getUltSfetalHeart1() {
        return ultSfetalHeart1;
    }

    public Integer getUltSbiparietal1() {
        return ultSbiparietal1;
    }

    public Integer getUltShead1() {
        return ultShead1;
    }

    public String getUltMicroceph1() {
        return ultMicroceph1;
    }

    public String getUltSevMicroceph1() {
        return ultSevMicroceph1;
    }

    public Integer getUltSabdominal1() {
        return ultSabdominal1;
    }

    public Integer getUltSfemur1() {
        return ultSfemur1;
    }

    public Integer getUltSfetalWt1() {
        return ultSfetalWt1;
    }

    public String getUltSpresentation1() {
        return ultSpresentation1;
    }

    public String getUltSfetusViable2() {
        return ultSfetusViable2;
    }

    public String getUltSfetalCardia2() {
        return ultSfetalCardia2;
    }

    public Float getUltSfetalHeart2() {
        return ultSfetalHeart2;
    }

    public Integer getUltSbiparietal2() {
        return ultSbiparietal2;
    }

    public Integer getUltShead2() {
        return ultShead2;
    }

    public String getUltMicroceph2() {
        return ultMicroceph2;
    }

    public String getUltSevMicroceph2() {
        return ultSevMicroceph2;
    }

    public Integer getUltSabdominal2() {
        return ultSabdominal2;
    }

    public Integer getUltSfemur2() {
        return ultSfemur2;
    }

    public Integer getUltSfetalWt2() {
        return ultSfetalWt2;
    }

    public String getUltSpresentation2() {
        return ultSpresentation2;
    }

    public String getUltSfetusViable3() {
        return ultSfetusViable3;
    }

    public String getUltSfetalCardia3() {
        return ultSfetalCardia3;
    }

    public Float getUltSfetalHeart3() {
        return ultSfetalHeart3;
    }

    public Integer getUltSbiparietal3() {
        return ultSbiparietal3;
    }

    public Integer getUltShead3() {
        return ultShead3;
    }

    public String getUltMicroceph3() {
        return ultMicroceph3;
    }

    public String getUltSevMicroceph3() {
        return ultSevMicroceph3;
    }

    public Integer getUltSabdominal3() {
        return ultSabdominal3;
    }

    public Integer getUltSfemur3() {
        return ultSfemur3;
    }

    public Integer getUltSfetalWt3() {
        return ultSfetalWt3;
    }

    public String getUltSpresentation3() {
        return ultSpresentation3;
    }

    public String getUltIdCompleting() {
        return ultIdCompleting;
    }

    public Date getUltDateCompleted() {
        return ultDateCompleted;
    }

    public String getUltIdReviewer() {
        return ultIdReviewer;
    }

    public Date getUltDateReviewed() {
        return ultDateReviewed;
    }

    public String getUltIdDataEntry() {
        return ultIdDataEntry;
    }

    public Date getUltDateEntered() {
        return ultDateEntered;
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
