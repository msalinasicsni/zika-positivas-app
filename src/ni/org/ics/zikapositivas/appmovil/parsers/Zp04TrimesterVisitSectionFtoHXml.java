package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/28/2016.
 * V1.0
 */
public class Zp04TrimesterVisitSectionFtoHXml {

    @Element(required=false)
    private String triBugNuisInd;
    @Element(required=false)
    private String triPestStorHomeInd;
    @Element(required=false)
    private String triPestAppHomeInd;
    @Element(required=false)
    private String triPestAppDay;
    @Element(required=false)
    private String triPestAppMonth;
    @Element(required=false)
    private String triPestAppYear;
    @Element(required=false)
    private String triPestAppName;
    @Element(required=false)
    private String triHomeTrtdInsctInd;
    @Element(required=false)
    private String triHomeTrtdLoc;
    @Element(required=false)
    private String triHomeTrtdEntity;
    @Element(required=false)
    private String triHomeTrtdNames;
    @Element(required=false)
    private String triTrtmntAppDay;
    @Element(required=false)
    private String triTrtmntAppMonth;
    @Element(required=false)
    private String triTrtmntAppYear;
    @Element(required=false)
    private String triLwnTrtmntAppInd;
    @Element(required=false)
    private String triLwnTrtmntAppDay;
    @Element(required=false)
    private String triLwnTrtmntAppMonth;
    @Element(required=false)
    private String triLwnTrtmntAppYear;
    @Element(required=false)
    private String triLwnTrtmntAppName;
    @Element(required=false)
    private String triMosqRepInd;
    @Element(required=false)
    private String triMosqRepTyp;
    @Element(required=false)
    private String triMosqRepNameSpray;
    @Element(required=false)
    private String triMosqRepDkSpray;
    @Element(required=false)
    private String triMosqRepNameLotion;
    @Element(required=false)
    private String triMosqRepDkLotion;
    @Element(required=false)
    private String triMosqRepNameSpiral;
    @Element(required=false)
    private String triMosqRepDkSpiral;
    @Element(required=false)
    private String triMosqRepNamePlugin;
    @Element(required=false)
    private String triMosqRepDkPlugin;
    @Element(required=false)
    private String triMosqRepNameOther;
    @Element(required=false)
    private String triMosqRepDkOther;
    @Element(required=false)
    private Date triNextVisitDat;
    @Element(required=false)
    private String triNextVisitTime;
    @Element(required=false)
    private String triCompId;
    @Element(required=false)
    private Date triCompDat;
    @Element(required=false)
    private String triRevId;
    @Element(required=false)
    private Date triRevDat;
    @Element(required=false)
    private String triEntId;
    @Element(required=false)
    private Date triEntDat;

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
    private String note1;
    @Element(required=false)
    private String note2;

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
    @Element(required=false)
    private String version;


    public String getTriBugNuisInd() {
        return triBugNuisInd;
    }

    public String getTriPestStorHomeInd() {
        return triPestStorHomeInd;
    }

    public String getTriPestAppHomeInd() {
        return triPestAppHomeInd;
    }

    public String getTriPestAppDay() {
        return triPestAppDay;
    }

    public String getTriPestAppMonth() {
        return triPestAppMonth;
    }

    public String getTriPestAppYear() {
        return triPestAppYear;
    }

    public String getTriPestAppName() {
        return triPestAppName;
    }

    public String getTriHomeTrtdInsctInd() {
        return triHomeTrtdInsctInd;
    }

    public String getTriHomeTrtdLoc() {
        return triHomeTrtdLoc;
    }

    public String getTriHomeTrtdEntity() {
        return triHomeTrtdEntity;
    }

    public String getTriHomeTrtdNames() {
        return triHomeTrtdNames;
    }

    public String getTriTrtmntAppDay() {
        return triTrtmntAppDay;
    }

    public String getTriTrtmntAppMonth() {
        return triTrtmntAppMonth;
    }

    public String getTriTrtmntAppYear() {
        return triTrtmntAppYear;
    }

    public String getTriLwnTrtmntAppInd() {
        return triLwnTrtmntAppInd;
    }

    public String getTriLwnTrtmntAppDay() {
        return triLwnTrtmntAppDay;
    }

    public String getTriLwnTrtmntAppMonth() {
        return triLwnTrtmntAppMonth;
    }

    public String getTriLwnTrtmntAppYear() {
        return triLwnTrtmntAppYear;
    }

    public String getTriLwnTrtmntAppName() {
        return triLwnTrtmntAppName;
    }

    public String getTriMosqRepInd() {
        return triMosqRepInd;
    }

    public String getTriMosqRepTyp() {
        return triMosqRepTyp;
    }

    public String getTriMosqRepNameSpray() {
        return triMosqRepNameSpray;
    }

    public String getTriMosqRepDkSpray() {
        return triMosqRepDkSpray;
    }

    public String getTriMosqRepNameLotion() {
        return triMosqRepNameLotion;
    }

    public String getTriMosqRepDkLotion() {
        return triMosqRepDkLotion;
    }

    public String getTriMosqRepNameSpiral() {
        return triMosqRepNameSpiral;
    }

    public String getTriMosqRepDkSpiral() {
        return triMosqRepDkSpiral;
    }

    public String getTriMosqRepNamePlugin() {
        return triMosqRepNamePlugin;
    }

    public String getTriMosqRepDkPlugin() {
        return triMosqRepDkPlugin;
    }

    public String getTriMosqRepNameOther() {
        return triMosqRepNameOther;
    }

    public String getTriMosqRepDkOther() {
        return triMosqRepDkOther;
    }

    public Date getTriNextVisitDat() {
        return triNextVisitDat;
    }

    public String getTriNextVisitTime() {
        return triNextVisitTime;
    }

    public String getTriCompId() {
        return triCompId;
    }

    public Date getTriCompDat() {
        return triCompDat;
    }

    public String getTriRevId() {
        return triRevId;
    }

    public Date getTriRevDat() {
        return triRevDat;
    }

    public String getTriEntId() {
        return triEntId;
    }

    public Date getTriEntDat() {
        return triEntDat;
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
}
