package ni.org.ics.zikapositivas.appmovil.parsers;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/27/2016.
 * V1.0
 */
public class Zp04TrimesterVisitSectionAtoDXml {

    @Element(required=false)
    private Date triDov;
    @Element(required=false)
    private String triVisitTyp;
    @Element(required=false)
    private String triOccChange;
    @Element(required=false)
    private String triPrimJobInd;
    @Element(required=false)
    private String triPrimJobTitle;
    @Element(required=false)
    private String triPrimJobTitleRef;
    @Element(required=false)
    private String triPrimJobDat;
    @Element(required=false)
    private String triPrimJobYear;
    @Element(required=false)
    private String triPrimJobHours;
    @Element(required=false)
    private String triPrimJobHoursRef;
    @Element(required=false)
    private String triPrimJobSetting;
    @Element(required=false)
    private String triPrimJobSetRef;
    @Element(required=false)
    private String triPrimJobSetSpecify;
    @Element(required=false)
    private String triPrevJobInd;
    @Element(required=false)
    private String triPrevJobTitle;
    @Element(required=false)
    private String triPrevJobTitleRef;
    @Element(required=false)
    private String triPrevJobDat;
    @Element(required=false)
    private String triPrevJobYear;
    @Element(required=false)
    private String triPrevJobHours;
    @Element(required=false)
    private String triPrevJobHoursRef;
    @Element(required=false)
    private String triPrevJobSetting;
    @Element(required=false)
    private String triPrevJobSetRef;
    @Element(required=false)
    private String triPrevJobSetSpecify;
    @Element(required=false)
    private String triHusbJobInd;
    @Element(required=false)
    private String triHusbJobTitle;
    @Element(required=false)
    private String triHusbJobTitleRef;
    @Element(required=false)
    private String triHusbJobSet;
    @Element(required=false)
    private String triHusbJobSetRef;
    @Element(required=false)
    private String triHusbJobSetSpecify;
    @Element(required=false)
    private String triHouseSitInd;
    @Element(required=false)
    private String triCity;
    @Element(required=false)
    private String triState;
    @Element(required=false)
    private String triCountry;
    @Element(required=false)
    private String triResidRef;
    @Element(required=false)
    private String triCurrResidDur;
    @Element(required=false)
    private String triCurrResidDurRef;
    @Element(required=false)
    private String triNbhoodTyp;
    @Element(required=false)
    private String triResidTyp;
    @Element(required=false)
    private String triResidTypSpecify;
    @Element(required=false)
    private String triFloorMat;
    @Element(required=false)
    private String triFloorMatSpecify;
    @Element(required=false)
    private String triWallMat;
    @Element(required=false)
    private String triWallMatSpecify;
    @Element(required=false)
    private String triRoofMat;
    @Element(required=false)
    private String triRoofMatSpecify;
    @Element(required=false)
    private String triTrashDispos;
    @Element(required=false)
    private String triTrashDisposSpecify;
    @Element(required=false)
    private Integer triNumTotalRooms;
    @Element(required=false)
    private Integer triNumSleepRooms;
    @Element(required=false)
    private Integer triNumPeople;
    @Element(required=false)
    private String triScreensInd;
    @Element(required=false)
    private String triHouseAmenities;//multiple
    @Element(required=false)
    private String triTransAccess;//multiple
    @Element(required=false)
    private String triPrimWaterSrc;
    @Element(required=false)
    private String triWaterContainInd;
    @Element(required=false)
    private String triWaterContainTyp;
    @Element(required=false)
    private String triWaterConSpecify;
    @Element(required=false)
    private String triWaterTreatHome;
    @Element(required=false)
    private String triWaterTreatFreq;
    @Element(required=false)
    private String triToiletTyp;
    @Element(required=false)
    private String triToiletTypSpecify;
    @Element(required=false)
    private String triOpSewageInd;
    @Element(required=false)
    private String triAnimalsInd;
    @Element(required=false)
    private String triAnimalTyp;//multiple
    @Element(required=false)
    private String triAnimalSpecify;
    @Element(required=false)
    private Integer triNumOtherAnimal;
    @Element(required=false)
    private Integer triNumCattle;
    @Element(required=false)
    private Integer triNumPig;
    @Element(required=false)
    private Integer triNumFowl;
    @Element(required=false)
    private Integer triNumGoatsSheep;
    @Element(required=false)
    private String triDrugUseInd;
    @Element(required=false)
    private String triSmokeInd;
    @Element(required=false)
    private String triSmokeEverInd;
    @Element(required=false)
    private String triSmokeCigPrevInd;
    @Element(required=false)
    private String triYearsSmoked;
    @Element(required=false)
    private String triYearsSmokedRef;
    @Element(required=false)
    private Float triNumCigDay;
    @Element(required=false)
    private String triNumCigRef;
    @Element(required=false)
    private String triLastCig;
    @Element(required=false)
    private String triHouseSmokeInd;
    @Element(required=false)
    private String triNumHrsSmoke;
    @Element(required=false)
    private String triNumHrsSmokeRef;
    @Element(required=false)
    private String triLastDrink;
    @Element(required=false)
    private String triDaysDrink;
    @Element(required=false)
    private String triNumDrinks;
    @Element(required=false)
    private String triMarijuanaInd;
    @Element(required=false)
    private String triOtherDrugsInd;
    @Element(required=false)
    private String triOtherDrugs1;
    @Element(required=false)
    private String triOtherDrugs2;
    @Element(required=false)
    private String triOtherDrugs3;
    @Element(required=false)
    private String triOtherDrugs4;
    @Element(required=false)
    private String triAddtMedicines;
    @Element(required=false)
    private String triAddtDrugsType;
    @Element(required=false)
    private String triAddtOthDrugsType1;
    @Element(required=false)
    private String triAddtOthDrugsBrand1;
    @Element(required=false)
    private String triAddtOthDrugsType2;
    @Element(required=false)
    private String triAddtOthDrugsBrand2;
    @Element(required=false)
    private String triAddtOthDrugsType3;
    @Element(required=false)
    private String triAddtOthDrugsBrand3;
    @Element(required=false)
    private String triAddtOthDrugsType4;
    @Element(required=false)
    private String triAddtOthDrugsBrand4;
    @Element(required=false)
    private String triAddtOthDrugsType5;
    @Element(required=false)
    private String triAddtOthDrugsBrand5;


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
    private String group13;
    @Element(required=false)
    private String group14;
    @Element(required=false)
    private String group15;
    @Element(required=false)
    private String group16;
    @Element(required=false)
    private String group17;
    @Element(required=false)
    private String group18;
    @Element(required=false)
    private String group19;
    @Element(required=false)
    private String group20;
    @Element(required=false)
    private String group21;
    @Element(required=false)
    private String group22;
    @Element(required=false)
    private String group23;

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
    private String question12;
    @Element(required=false)
    private String question13;
    @Element(required=false)
    private String question14;
    @Element(required=false)
    private String question15;
    @Element(required=false)
    private String question16;

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


    public Date getTriDov() {
        return triDov;
    }

    public String getTriVisitTyp() {
        return triVisitTyp;
    }

    public String getTriOccChange() {
        return triOccChange;
    }

    public String getTriPrimJobInd() {
        return triPrimJobInd;
    }

    public String getTriPrimJobTitle() {
        return triPrimJobTitle;
    }

    public String getTriPrimJobTitleRef() {
        return triPrimJobTitleRef;
    }

    public String getTriPrimJobDat() {
        return triPrimJobDat;
    }

    public String getTriPrimJobYear() {
        return triPrimJobYear;
    }

    public String getTriPrimJobHours() {
        return triPrimJobHours;
    }

    public String getTriPrimJobHoursRef() {
        return triPrimJobHoursRef;
    }

    public String getTriPrimJobSetting() {
        return triPrimJobSetting;
    }

    public String getTriPrimJobSetRef() {
        return triPrimJobSetRef;
    }

    public String getTriPrimJobSetSpecify() {
        return triPrimJobSetSpecify;
    }

    public String getTriPrevJobInd() {
        return triPrevJobInd;
    }

    public String getTriPrevJobTitle() {
        return triPrevJobTitle;
    }

    public String getTriPrevJobTitleRef() {
        return triPrevJobTitleRef;
    }

    public String getTriPrevJobDat() {
        return triPrevJobDat;
    }

    public String getTriPrevJobYear() {
        return triPrevJobYear;
    }

    public String getTriPrevJobHours() {
        return triPrevJobHours;
    }

    public String getTriPrevJobHoursRef() {
        return triPrevJobHoursRef;
    }

    public String getTriPrevJobSetting() {
        return triPrevJobSetting;
    }

    public String getTriPrevJobSetRef() {
        return triPrevJobSetRef;
    }

    public String getTriPrevJobSetSpecify() {
        return triPrevJobSetSpecify;
    }

    public String getTriHusbJobInd() {
        return triHusbJobInd;
    }

    public String getTriHusbJobTitle() {
        return triHusbJobTitle;
    }

    public String getTriHusbJobTitleRef() {
        return triHusbJobTitleRef;
    }

    public String getTriHusbJobSet() {
        return triHusbJobSet;
    }

    public String getTriHusbJobSetRef() {
        return triHusbJobSetRef;
    }

    public String getTriHusbJobSetSpecify() {
        return triHusbJobSetSpecify;
    }

    public String getTriHouseSitInd() {
        return triHouseSitInd;
    }

    public String getTriCity() {
        return triCity;
    }

    public String getTriState() {
        return triState;
    }

    public String getTriCountry() {
        return triCountry;
    }

    public String getTriResidRef() {
        return triResidRef;
    }

    public String getTriCurrResidDur() {
        return triCurrResidDur;
    }

    public String getTriCurrResidDurRef() {
        return triCurrResidDurRef;
    }

    public String getTriNbhoodTyp() {
        return triNbhoodTyp;
    }

    public String getTriResidTyp() {
        return triResidTyp;
    }

    public String getTriResidTypSpecify() {
        return triResidTypSpecify;
    }

    public String getTriFloorMat() {
        return triFloorMat;
    }

    public String getTriFloorMatSpecify() {
        return triFloorMatSpecify;
    }

    public String getTriWallMat() {
        return triWallMat;
    }

    public String getTriWallMatSpecify() {
        return triWallMatSpecify;
    }

    public String getTriRoofMat() {
        return triRoofMat;
    }

    public String getTriRoofMatSpecify() {
        return triRoofMatSpecify;
    }

    public String getTriTrashDispos() {
        return triTrashDispos;
    }

    public String getTriTrashDisposSpecify() {
        return triTrashDisposSpecify;
    }

    public Integer getTriNumTotalRooms() {
        return triNumTotalRooms;
    }

    public Integer getTriNumSleepRooms() {
        return triNumSleepRooms;
    }

    public Integer getTriNumPeople() {
        return triNumPeople;
    }

    public String getTriScreensInd() {
        return triScreensInd;
    }

    public String getTriHouseAmenities() {
        return triHouseAmenities;
    }

    public String getTriTransAccess() {
        return triTransAccess;
    }

    public String getTriPrimWaterSrc() {
        return triPrimWaterSrc;
    }

    public String getTriWaterContainInd() {
        return triWaterContainInd;
    }

    public String getTriWaterContainTyp() {
        return triWaterContainTyp;
    }

    public String getTriWaterConSpecify() {
        return triWaterConSpecify;
    }

    public String getTriWaterTreatHome() {
        return triWaterTreatHome;
    }

    public String getTriWaterTreatFreq() {
        return triWaterTreatFreq;
    }

    public String getTriToiletTyp() {
        return triToiletTyp;
    }

    public String getTriToiletTypSpecify() {
        return triToiletTypSpecify;
    }

    public String getTriOpSewageInd() {
        return triOpSewageInd;
    }

    public String getTriAnimalsInd() {
        return triAnimalsInd;
    }

    public String getTriAnimalTyp() {
        return triAnimalTyp;
    }

    public String getTriAnimalSpecify() {
        return triAnimalSpecify;
    }

    public Integer getTriNumOtherAnimal() {
        return triNumOtherAnimal;
    }

    public Integer getTriNumCattle() {
        return triNumCattle;
    }

    public Integer getTriNumPig() {
        return triNumPig;
    }

    public Integer getTriNumFowl() {
        return triNumFowl;
    }

    public Integer getTriNumGoatsSheep() {
        return triNumGoatsSheep;
    }

    public String getTriDrugUseInd() {
        return triDrugUseInd;
    }

    public String getTriSmokeInd() {
        return triSmokeInd;
    }

    public String getTriSmokeEverInd() {
        return triSmokeEverInd;
    }

    public String getTriSmokeCigPrevInd() {
        return triSmokeCigPrevInd;
    }

    public String getTriYearsSmoked() {
        return triYearsSmoked;
    }

    public String getTriYearsSmokedRef() {
        return triYearsSmokedRef;
    }

    public Float getTriNumCigDay() {
        return triNumCigDay;
    }

    public String getTriNumCigRef() {
        return triNumCigRef;
    }

    public String getTriLastCig() {
        return triLastCig;
    }

    public String getTriHouseSmokeInd() {
        return triHouseSmokeInd;
    }

    public String getTriNumHrsSmoke() {
        return triNumHrsSmoke;
    }

    public String getTriNumHrsSmokeRef() {
        return triNumHrsSmokeRef;
    }

    public String getTriLastDrink() {
        return triLastDrink;
    }

    public String getTriDaysDrink() {
        return triDaysDrink;
    }

    public String getTriNumDrinks() {
        return triNumDrinks;
    }

    public String getTriMarijuanaInd() {
        return triMarijuanaInd;
    }

    public String getTriOtherDrugsInd() {
        return triOtherDrugsInd;
    }

    public String getTriOtherDrugs1() {
        return triOtherDrugs1;
    }

    public String getTriOtherDrugs2() {
        return triOtherDrugs2;
    }

    public String getTriOtherDrugs3() {
        return triOtherDrugs3;
    }

    public String getTriOtherDrugs4() {
        return triOtherDrugs4;
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

	public String getTriAddtMedicines() {
		return triAddtMedicines;
	}

	public String getTriAddtDrugsType() {
		return triAddtDrugsType;
	}

	public String getTriAddtOthDrugsType1() {
		return triAddtOthDrugsType1;
	}

	public String getTriAddtOthDrugsBrand1() {
		return triAddtOthDrugsBrand1;
	}

	public String getTriAddtOthDrugsType2() {
		return triAddtOthDrugsType2;
	}

	public String getTriAddtOthDrugsBrand2() {
		return triAddtOthDrugsBrand2;
	}

	public String getTriAddtOthDrugsType3() {
		return triAddtOthDrugsType3;
	}

	public String getTriAddtOthDrugsBrand3() {
		return triAddtOthDrugsBrand3;
	}

	public String getTriAddtOthDrugsType4() {
		return triAddtOthDrugsType4;
	}

	public String getTriAddtOthDrugsBrand4() {
		return triAddtOthDrugsBrand4;
	}

	public String getTriAddtOthDrugsType5() {
		return triAddtOthDrugsType5;
	}

	public String getTriAddtOthDrugsBrand5() {
		return triAddtOthDrugsBrand5;
	}

	public String getGroup1() {
		return group1;
	}

	public String getGroup2() {
		return group2;
	}

	public String getGroup3() {
		return group3;
	}

	public String getGroup4() {
		return group4;
	}

	public String getGroup5() {
		return group5;
	}

	public String getGroup6() {
		return group6;
	}

	public String getGroup7() {
		return group7;
	}

	public String getGroup8() {
		return group8;
	}

	public String getGroup9() {
		return group9;
	}

	public String getGroup10() {
		return group10;
	}

	public String getGroup11() {
		return group11;
	}

	public String getGroup12() {
		return group12;
	}

	public String getGroup13() {
		return group13;
	}

	public String getGroup14() {
		return group14;
	}

	public String getGroup15() {
		return group15;
	}

	public String getGroup16() {
		return group16;
	}

	public String getGroup17() {
		return group17;
	}

	public String getGroup18() {
		return group18;
	}

	public String getGroup19() {
		return group19;
	}

	public String getGroup20() {
		return group20;
	}

	public String getGroup21() {
		return group21;
	}

	public String getGroup22() {
		return group22;
	}

	public String getGroup23() {
		return group23;
	}

	public String getNote1() {
		return note1;
	}

	public String getNote2() {
		return note2;
	}

	public String getQuestion1() {
		return question1;
	}

	public String getQuestion2() {
		return question2;
	}

	public String getQuestion3() {
		return question3;
	}

	public String getQuestion4() {
		return question4;
	}

	public String getQuestion5() {
		return question5;
	}

	public String getQuestion6() {
		return question6;
	}

	public String getQuestion7() {
		return question7;
	}

	public String getQuestion8() {
		return question8;
	}

	public String getQuestion9() {
		return question9;
	}

	public String getQuestion10() {
		return question10;
	}

	public String getQuestion11() {
		return question11;
	}

	public String getQuestion12() {
		return question12;
	}

	public String getQuestion13() {
		return question13;
	}

	public String getQuestion14() {
		return question14;
	}

	public String getQuestion15() {
		return question15;
	}

	public String getQuestion16() {
		return question16;
	}
    
    

}
