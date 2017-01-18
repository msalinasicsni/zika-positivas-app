package ni.org.ics.zikapositivas.appmovil.parsers;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * Created by FIRSTICT on 10/6/2016.
 * V1.0
 */

public class Zp00ScreeningXml {

    /**
	 * 
	 */
	@Element(required=true)
    private Date scrVisitDate;
	@Element(required=true)
    private String scrRemain;
	@Element(required=false)
    private Integer scrAge;
	@Element(required=false)
    private String scrAge15;
	@Element(required=false)
    private String scrPregnant;
	@Element(required=false)
    private Integer scrPreWeeks;
	@Element(required=false)
    private Integer scrPreDays;
	@Element(required=false)
    private String scrPregant13;
	@Element(required=false)
    private String scrZikaOther;
	@Element(required=false)
    private String scrMeetCriteria;
	@Element(required=false)
    private String scrConsentObta;
	@Element(required=false)
    private String scrObDobDay;
	@Element(required=false)
    private String scrObDobMon;
	@Element(required=false)
    private Integer scrObDobYear;
	@Element(required=false)
    private Integer scrObAge;
	@Element(required=false)
    private String scrObAssent;
	@Element(required=false)
    private String scrConsentA;
	@Element(required=false)
    private String scrConsentB;
	@Element(required=false)
    private String scrConsentC;
	@Element(required=false)
    private String scrConsentD;
	@Element(required=false)
    private String scrConsentE;
	@Element(required=false)
    private String scrConsentF;
	@Element(required=false)
    private String scrPreviousZikaPos;
	@Element(required=false)
    private String scrPreviousStudyId;
	@Element(required=false)
    private String scrPreStudyNa;
	@Element(required=false)
    private String scrReasonNot;
	@Element(required=false)
    private String scrReasonOther;
	
	
	
	@Element(required=false)
    private String note1;
	@Element(required=false)
	private String note2;
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
    private String question1;
	@Element(required=false)
    private String question2;
	@Element(required=false)
    private String question3;
	@Element(required=false)
	private String question4;



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
	
	
	//Getters
	public Date getScrVisitDate() {
		return scrVisitDate;
	}
	public String getScrRemain() {
		return scrRemain;
	}
	public Integer getScrAge() {
		return scrAge;
	}
	public String getScrAge15() {
		return scrAge15;
	}
	public String getScrPregnant() {
		return scrPregnant;
	}
	public Integer getScrPreWeeks() {
		return scrPreWeeks;
	}
	public Integer getScrPreDays() {
		return scrPreDays;
	}
	public String getScrPregant13() {
		return scrPregant13;
	}
	public String getScrZikaOther() {
		return scrZikaOther;
	}
	public String getScrMeetCriteria() {
		return scrMeetCriteria;
	}
	public String getScrConsentObta() {
		return scrConsentObta;
	}
	public String getScrObDobDay() {
		return scrObDobDay;
	}
	public String getScrObDobMon() {
		return scrObDobMon;
	}
	public Integer getScrObDobYear() {
		return scrObDobYear;
	}
	public Integer getScrObAge() {
		return scrObAge;
	}
	public String getScrObAssent() {
		return scrObAssent;
	}
	public String getScrConsentA() {
		return scrConsentA;
	}
	public String getScrConsentB() {
		return scrConsentB;
	}
	public String getScrConsentC() {
		return scrConsentC;
	}
	public String getScrConsentD() {
		return scrConsentD;
	}
	public String getScrConsentE() {
		return scrConsentE;
	}
	public String getScrConsentF() {
		return scrConsentF;
	}
	public String getScrPreviousZikaPos() {
		return scrPreviousZikaPos;
	}
	public String getScrPreviousStudyId() {
		return scrPreviousStudyId;
	}
	public String getScrPreStudyNa() {
		return scrPreStudyNa;
	}
	public String getScrReasonNot() {
		return scrReasonNot;
	}
	public String getScrReasonOther() {
		return scrReasonOther;
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
