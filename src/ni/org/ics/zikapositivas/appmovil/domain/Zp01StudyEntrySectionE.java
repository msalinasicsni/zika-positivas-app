package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/7/2016.
 * V1.0
 */

public class Zp01StudyEntrySectionE extends BaseMetaData {

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String redcapEventName;
    private String seaDiseases; //multiple
    private String seaOtherSpecify;
    private String seaHepatitis;
    private Date seaHepatitisDate1;
    private Date seaHepatitisDate2;
    private Date seaHepatitisDate3;
    private String seaMeasles;
    private Date seaMeaslesDate1;
    private Date seaMeaslesDate2;
    private Date seaMeaslesDate3;
    private String seaChickenpox;
    private Date seaChickenpoxDate1;
    private Date seaChickenpoxDate2;
    private Date seaChickenpoxDate3;
    private String seaInfluenza;
    private Date seaInfluenzaDate1;
    private Date seaInfluenzaDate2;
    private Date seaInfluenzaDate3;
    private String seaYellow;
    private Date seaYellowDate1;
    private Date seaYellowDate2;
    private Date seaYellowDate3;
    private String seaDengue;
    private Date seaDengueDate1;
    private Date seaDengueDate2;
    private Date seaDengueDate3;
    private String seaVacOther;
    private String seaVacotherSpecify;
    private Date seaOtherDate1;
    private Date seaOtherDate2;
    private Date seaOtherDate3;
    private String seaRubella;
    private Date seaRubellaDate1;
    private Date seaRubellaDate2;
    private Date seaRubellaDate3;
    private String seaRubellaDoc;
    private String seaCmv;
    private Date seaCmvDate1;
    private Date seaCmvDate2;
    private Date seaCmvDate3;
    private String seaCmvDoc;
    private String seaHerpes;
    private Date seaHerpesDate1;
    private Date seaHerpesDate2;
    private Date seaHerpesDate3;
    private String seaHerpesDoc;
    private String seaParvovirus;
    private Date seaParvovirusDate1;
    private Date seaParvovirusDate2;
    private Date seaParvovirusDate3;
    private String seaParvovirusDoc;
    private String seaToxoplasmosis;
    private Date seaToxoplasmosisDate1;
    private Date seaToxoplasmosisDate2;
    private Date seaToxoplasmosisDate3;
    private String seaToxoplasmosisDoc;
    private String seaSyphillis;
    private Date seaSyphillisDate1;
    private Date seaSyphillisDate2;
    private Date seaSyphillisDate3;
    private String seaSyphillisDoc;
    private String seaHiv;
    private Date seaHivDate1;
    private Date seaHivDate2;
    private Date seaHivDate3;
    private String seaHivDoc;
    private String seaZika;
    private Date seaZikaDate1;
    private Date seaZikaDate2;
    private Date seaZikaDate3;
    private String seaZikaDoc;
    private String seaChikung;
    private Date seaChikungDate1;
    private Date seaChikungDate2;
    private Date seaChikungDate3;
    private String seaChikungDoc;
    private String seaInfluInfect;
    private Date seaInflueInfectDate1;
    private Date seaInfluInfectDate2;
    private Date seaInfluInfectDate3;
    private String seaInfluInfectDoc;
    private String seaDengueInfect;
    private Date seaDengueInfectDate1;
    private Date seaDengueInfectDate2;
    private Date seaDengueInfectDate3;
    private String seaDengueInfectDoc;
    private String seaFeverSymptom;
    private String seaRash;
    private String seaItch;
    private String seaRashFirst;//multiple
    private String seaRashDay;
    private String seaRashMonth;
    private String seaRashYear;
    private Integer seaRashDuration;
    private String seaRashSpread;
    private String seaSpreadPart;//multiple
    private String seaFeverExperience;
    private String seaTempMeasure;
    private Float seaHighTemp;
    private String seaHightemUnit;
    private String seaTempunknown;
    private String seaFeverDay;
    private String seaFeverMonth;
    private String seaFeverYear;
    private Integer seaFeverDuration;
    private String seaRedeyes;
    private String seaRedeyesDay;
    private String seaRedeyesMonth;
    private String seaRedeyesYear;
    private Integer seaRedeyesDuration;
    private String seaOccurSame;
    private String seaSameSymptom;//multiple
    private String seaJoint;
    private String seaJointDay;
    private String seaJointMonth;
    private String seaJointYear;
    private Integer seaJointDuration;
    private String seaHeadache;
    private String seaHeadacheDay;
    private String seaHeadacheMonth;
    private String seaHeadacheYear;
    private Integer seaHeadacheDuration;
    private String seaSymptomOther;
    private String seaSpecifySymptom;//multiple
    private String seaOtherSymptom;
    private String seaMedicare;
    private String seaCareDay;
    private String seaCareMonth;
    private String seaCareYear;
    private String seaCareFacility;
    private String seaHospitalized;
    private String seaHospital;
    private String seaDiagRubella;
    private String seaDiagDengue;
    private String seaDiagChikung;
    private String seaDiagZika;
    private String seaDiagCytome;
    private String seaMedicine;
    private String seaMedcineName;
    private String seaGuillainbarre;
    private String seaTingling;
    private String seaTinglingArm;//multiple
    private String seaTinglingLeg;//multiple
    private String seaTinglingHand;//multiple
    private String seaTinglingFoot;//multiple
    private String seaTinglingFace;//multiple
    private String seaTinglingOther;//multiple
    private String seaSensationMin;
    private String seaSensationHr;
    private String seaSenstaionDay;
    private String seaInjury;
    private String seaTinglingDay;
    private String seaTinglingMonth;
    private String seaTinglingYear;
    private Integer seaTinglingDuration;
    private String seaNumbness;
    private String seaNumbArm;//multiple
    private String seaNumbLeg;//multiple
    private String seaNumbHand;//multiple
    private String seaNumbFoot;//multiple
    private String seaNumbFace;//multiple
    private String seaNumbOther;
    private String seaNumbDay;
    private String seaNumbMonth;
    private String seaNumbYear;
    private Integer seaNumbDuration;
    private String seaParalysis;
    private String seaParaArm;//multiple
    private String seaParaLeg;//multiple
    private String seaParaHand;//multiple
    private String seaParaFoot;//multiple
    private String seaParaFace;//multiple
    private String seaParaOther;
    private String seaParaDay;
    private String seaParaMonth;
    private String seaParaYear;
    private Integer seaParaDuration;


    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getRedcapEventName() {
		return redcapEventName;
	}

	public void setRedcapEventName(String redcapEventName) {
		this.redcapEventName = redcapEventName;
	}

	public String getSeaDiseases() {
        return seaDiseases;
    }

    public void setSeaDiseases(String seaDiseases) {
        this.seaDiseases = seaDiseases;
    }

    public String getSeaOtherSpecify() {
        return seaOtherSpecify;
    }

    public void setSeaOtherSpecify(String seaOtherSpecify) {
        this.seaOtherSpecify = seaOtherSpecify;
    }

    public String getSeaHepatitis() {
        return seaHepatitis;
    }

    public void setSeaHepatitis(String seaHepatitis) {
        this.seaHepatitis = seaHepatitis;
    }

    public Date getSeaHepatitisDate1() {
        return seaHepatitisDate1;
    }

    public void setSeaHepatitisDate1(Date seaHepatitisDate1) {
        this.seaHepatitisDate1 = seaHepatitisDate1;
    }

    public Date getSeaHepatitisDate2() {
        return seaHepatitisDate2;
    }

    public void setSeaHepatitisDate2(Date seaHepatitisDate2) {
        this.seaHepatitisDate2 = seaHepatitisDate2;
    }

    public Date getSeaHepatitisDate3() {
        return seaHepatitisDate3;
    }

    public void setSeaHepatitisDate3(Date seaHepatitisDate3) {
        this.seaHepatitisDate3 = seaHepatitisDate3;
    }

    public String getSeaMeasles() {
        return seaMeasles;
    }

    public void setSeaMeasles(String seaMeasles) {
        this.seaMeasles = seaMeasles;
    }

    public Date getSeaMeaslesDate1() {
        return seaMeaslesDate1;
    }

    public void setSeaMeaslesDate1(Date seaMeaslesDate1) {
        this.seaMeaslesDate1 = seaMeaslesDate1;
    }

    public Date getSeaMeaslesDate2() {
        return seaMeaslesDate2;
    }

    public void setSeaMeaslesDate2(Date seaMeaslesDate2) {
        this.seaMeaslesDate2 = seaMeaslesDate2;
    }

    public Date getSeaMeaslesDate3() {
        return seaMeaslesDate3;
    }

    public void setSeaMeaslesDate3(Date seaMeaslesDate3) {
        this.seaMeaslesDate3 = seaMeaslesDate3;
    }

    public String getSeaChickenpox() {
        return seaChickenpox;
    }

    public void setSeaChickenpox(String seaChickenpox) {
        this.seaChickenpox = seaChickenpox;
    }

    public Date getSeaChickenpoxDate1() {
        return seaChickenpoxDate1;
    }

    public void setSeaChickenpoxDate1(Date seaChickenpoxDate1) {
        this.seaChickenpoxDate1 = seaChickenpoxDate1;
    }

    public Date getSeaChickenpoxDate2() {
        return seaChickenpoxDate2;
    }

    public void setSeaChickenpoxDate2(Date seaChickenpoxDate2) {
        this.seaChickenpoxDate2 = seaChickenpoxDate2;
    }

    public Date getSeaChickenpoxDate3() {
        return seaChickenpoxDate3;
    }

    public void setSeaChickenpoxDate3(Date seaChickenpoxDate3) {
        this.seaChickenpoxDate3 = seaChickenpoxDate3;
    }

    public String getSeaInfluenza() {
        return seaInfluenza;
    }

    public void setSeaInfluenza(String seaInfluenza) {
        this.seaInfluenza = seaInfluenza;
    }

    public Date getSeaInfluenzaDate1() {
        return seaInfluenzaDate1;
    }

    public void setSeaInfluenzaDate1(Date seaInfluenzaDate1) {
        this.seaInfluenzaDate1 = seaInfluenzaDate1;
    }

    public Date getSeaInfluenzaDate2() {
        return seaInfluenzaDate2;
    }

    public void setSeaInfluenzaDate2(Date seaInfluenzaDate2) {
        this.seaInfluenzaDate2 = seaInfluenzaDate2;
    }

    public Date getSeaInfluenzaDate3() {
        return seaInfluenzaDate3;
    }

    public void setSeaInfluenzaDate3(Date seaInfluenzaDate3) {
        this.seaInfluenzaDate3 = seaInfluenzaDate3;
    }

    public String getSeaYellow() {
        return seaYellow;
    }

    public void setSeaYellow(String seaYellow) {
        this.seaYellow = seaYellow;
    }

    public Date getSeaYellowDate1() {
        return seaYellowDate1;
    }

    public void setSeaYellowDate1(Date seaYellowDate1) {
        this.seaYellowDate1 = seaYellowDate1;
    }

    public Date getSeaYellowDate2() {
        return seaYellowDate2;
    }

    public void setSeaYellowDate2(Date seaYellowDate2) {
        this.seaYellowDate2 = seaYellowDate2;
    }

    public Date getSeaYellowDate3() {
        return seaYellowDate3;
    }

    public void setSeaYellowDate3(Date seaYellowDate3) {
        this.seaYellowDate3 = seaYellowDate3;
    }

    public String getSeaDengue() {
        return seaDengue;
    }

    public void setSeaDengue(String seaDengue) {
        this.seaDengue = seaDengue;
    }

    public Date getSeaDengueDate1() {
        return seaDengueDate1;
    }

    public void setSeaDengueDate1(Date seaDengueDate1) {
        this.seaDengueDate1 = seaDengueDate1;
    }

    public Date getSeaDengueDate2() {
        return seaDengueDate2;
    }

    public void setSeaDengueDate2(Date seaDengueDate2) {
        this.seaDengueDate2 = seaDengueDate2;
    }

    public Date getSeaDengueDate3() {
        return seaDengueDate3;
    }

    public void setSeaDengueDate3(Date seaDengueDate3) {
        this.seaDengueDate3 = seaDengueDate3;
    }

    public String getSeaVacOther() {
        return seaVacOther;
    }

    public void setSeaVacOther(String seaVacOther) {
        this.seaVacOther = seaVacOther;
    }

    public String getSeaVacotherSpecify() {
        return seaVacotherSpecify;
    }

    public void setSeaVacotherSpecify(String seaVacotherSpecify) {
        this.seaVacotherSpecify = seaVacotherSpecify;
    }

    public Date getSeaOtherDate1() {
        return seaOtherDate1;
    }

    public void setSeaOtherDate1(Date seaOtherDate1) {
        this.seaOtherDate1 = seaOtherDate1;
    }

    public Date getSeaOtherDate2() {
        return seaOtherDate2;
    }

    public void setSeaOtherDate2(Date seaOtherDate2) {
        this.seaOtherDate2 = seaOtherDate2;
    }

    public Date getSeaOtherDate3() {
        return seaOtherDate3;
    }

    public void setSeaOtherDate3(Date seaOtherDate3) {
        this.seaOtherDate3 = seaOtherDate3;
    }

    public String getSeaRubella() {
        return seaRubella;
    }

    public void setSeaRubella(String seaRubella) {
        this.seaRubella = seaRubella;
    }

    public Date getSeaRubellaDate1() {
        return seaRubellaDate1;
    }

    public void setSeaRubellaDate1(Date seaRubellaDate1) {
        this.seaRubellaDate1 = seaRubellaDate1;
    }

    public Date getSeaRubellaDate2() {
        return seaRubellaDate2;
    }

    public void setSeaRubellaDate2(Date seaRubellaDate2) {
        this.seaRubellaDate2 = seaRubellaDate2;
    }

    public Date getSeaRubellaDate3() {
        return seaRubellaDate3;
    }

    public void setSeaRubellaDate3(Date seaRubellaDate3) {
        this.seaRubellaDate3 = seaRubellaDate3;
    }

    public String getSeaRubellaDoc() {
        return seaRubellaDoc;
    }

    public void setSeaRubellaDoc(String seaRubellaDoc) {
        this.seaRubellaDoc = seaRubellaDoc;
    }

    public String getSeaCmv() {
        return seaCmv;
    }

    public void setSeaCmv(String seaCmv) {
        this.seaCmv = seaCmv;
    }

    public Date getSeaCmvDate1() {
        return seaCmvDate1;
    }

    public void setSeaCmvDate1(Date seaCmvDate1) {
        this.seaCmvDate1 = seaCmvDate1;
    }

    public Date getSeaCmvDate2() {
        return seaCmvDate2;
    }

    public void setSeaCmvDate2(Date seaCmvDate2) {
        this.seaCmvDate2 = seaCmvDate2;
    }

    public Date getSeaCmvDate3() {
        return seaCmvDate3;
    }

    public void setSeaCmvDate3(Date seaCmvDate3) {
        this.seaCmvDate3 = seaCmvDate3;
    }

    public String getSeaCmvDoc() {
        return seaCmvDoc;
    }

    public void setSeaCmvDoc(String seaCmvDoc) {
        this.seaCmvDoc = seaCmvDoc;
    }

    public String getSeaHerpes() {
        return seaHerpes;
    }

    public void setSeaHerpes(String seaHerpes) {
        this.seaHerpes = seaHerpes;
    }

    public Date getSeaHerpesDate1() {
        return seaHerpesDate1;
    }

    public void setSeaHerpesDate1(Date seaHerpesDate1) {
        this.seaHerpesDate1 = seaHerpesDate1;
    }

    public Date getSeaHerpesDate2() {
        return seaHerpesDate2;
    }

    public void setSeaHerpesDate2(Date seaHerpesDate2) {
        this.seaHerpesDate2 = seaHerpesDate2;
    }

    public Date getSeaHerpesDate3() {
        return seaHerpesDate3;
    }

    public void setSeaHerpesDate3(Date seaHerpesDate3) {
        this.seaHerpesDate3 = seaHerpesDate3;
    }

    public String getSeaHerpesDoc() {
        return seaHerpesDoc;
    }

    public void setSeaHerpesDoc(String seaHerpesDoc) {
        this.seaHerpesDoc = seaHerpesDoc;
    }

    public String getSeaParvovirus() {
        return seaParvovirus;
    }

    public void setSeaParvovirus(String seaParvovirus) {
        this.seaParvovirus = seaParvovirus;
    }

    public Date getSeaParvovirusDate1() {
        return seaParvovirusDate1;
    }

    public void setSeaParvovirusDate1(Date seaParvovirusDate1) {
        this.seaParvovirusDate1 = seaParvovirusDate1;
    }

    public Date getSeaParvovirusDate2() {
        return seaParvovirusDate2;
    }

    public void setSeaParvovirusDate2(Date seaParvovirusDate2) {
        this.seaParvovirusDate2 = seaParvovirusDate2;
    }

    public Date getSeaParvovirusDate3() {
        return seaParvovirusDate3;
    }

    public void setSeaParvovirusDate3(Date seaParvovirusDate3) {
        this.seaParvovirusDate3 = seaParvovirusDate3;
    }

    public String getSeaParvovirusDoc() {
        return seaParvovirusDoc;
    }

    public void setSeaParvovirusDoc(String seaParvovirusDoc) {
        this.seaParvovirusDoc = seaParvovirusDoc;
    }

    public String getSeaToxoplasmosis() {
        return seaToxoplasmosis;
    }

    public void setSeaToxoplasmosis(String seaToxoplasmosis) {
        this.seaToxoplasmosis = seaToxoplasmosis;
    }

    public Date getSeaToxoplasmosisDate1() {
        return seaToxoplasmosisDate1;
    }

    public void setSeaToxoplasmosisDate1(Date seaToxoplasmosisDate1) {
        this.seaToxoplasmosisDate1 = seaToxoplasmosisDate1;
    }

    public Date getSeaToxoplasmosisDate2() {
        return seaToxoplasmosisDate2;
    }

    public void setSeaToxoplasmosisDate2(Date seaToxoplasmosisDate2) {
        this.seaToxoplasmosisDate2 = seaToxoplasmosisDate2;
    }

    public Date getSeaToxoplasmosisDate3() {
        return seaToxoplasmosisDate3;
    }

    public void setSeaToxoplasmosisDate3(Date seaToxoplasmosisDate3) {
        this.seaToxoplasmosisDate3 = seaToxoplasmosisDate3;
    }

    public String getSeaToxoplasmosisDoc() {
        return seaToxoplasmosisDoc;
    }

    public void setSeaToxoplasmosisDoc(String seaToxoplasmosisDoc) {
        this.seaToxoplasmosisDoc = seaToxoplasmosisDoc;
    }

    public String getSeaSyphillis() {
        return seaSyphillis;
    }

    public void setSeaSyphillis(String seaSyphillis) {
        this.seaSyphillis = seaSyphillis;
    }

    public Date getSeaSyphillisDate1() {
        return seaSyphillisDate1;
    }

    public void setSeaSyphillisDate1(Date seaSyphillisDate1) {
        this.seaSyphillisDate1 = seaSyphillisDate1;
    }

    public Date getSeaSyphillisDate2() {
        return seaSyphillisDate2;
    }

    public void setSeaSyphillisDate2(Date seaSyphillisDate2) {
        this.seaSyphillisDate2 = seaSyphillisDate2;
    }

    public Date getSeaSyphillisDate3() {
        return seaSyphillisDate3;
    }

    public void setSeaSyphillisDate3(Date seaSyphillisDate3) {
        this.seaSyphillisDate3 = seaSyphillisDate3;
    }

    public String getSeaSyphillisDoc() {
        return seaSyphillisDoc;
    }

    public void setSeaSyphillisDoc(String seaSyphillisDoc) {
        this.seaSyphillisDoc = seaSyphillisDoc;
    }

    public String getSeaHiv() {
        return seaHiv;
    }

    public void setSeaHiv(String seaHiv) {
        this.seaHiv = seaHiv;
    }

    public Date getSeaHivDate1() {
        return seaHivDate1;
    }

    public void setSeaHivDate1(Date seaHivDate1) {
        this.seaHivDate1 = seaHivDate1;
    }

    public Date getSeaHivDate2() {
        return seaHivDate2;
    }

    public void setSeaHivDate2(Date seaHivDate2) {
        this.seaHivDate2 = seaHivDate2;
    }

    public Date getSeaHivDate3() {
        return seaHivDate3;
    }

    public void setSeaHivDate3(Date seaHivDate3) {
        this.seaHivDate3 = seaHivDate3;
    }

    public String getSeaHivDoc() {
        return seaHivDoc;
    }

    public void setSeaHivDoc(String seaHivDoc) {
        this.seaHivDoc = seaHivDoc;
    }

    public String getSeaZika() {
        return seaZika;
    }

    public void setSeaZika(String seaZika) {
        this.seaZika = seaZika;
    }

    public Date getSeaZikaDate1() {
        return seaZikaDate1;
    }

    public void setSeaZikaDate1(Date seaZikaDate1) {
        this.seaZikaDate1 = seaZikaDate1;
    }

    public Date getSeaZikaDate2() {
        return seaZikaDate2;
    }

    public void setSeaZikaDate2(Date seaZikaDate2) {
        this.seaZikaDate2 = seaZikaDate2;
    }

    public Date getSeaZikaDate3() {
        return seaZikaDate3;
    }

    public void setSeaZikaDate3(Date seaZikaDate3) {
        this.seaZikaDate3 = seaZikaDate3;
    }

    public String getSeaZikaDoc() {
        return seaZikaDoc;
    }

    public void setSeaZikaDoc(String seaZikaDoc) {
        this.seaZikaDoc = seaZikaDoc;
    }

    public String getSeaChikung() {
        return seaChikung;
    }

    public void setSeaChikung(String seaChikung) {
        this.seaChikung = seaChikung;
    }

    public Date getSeaChikungDate1() {
        return seaChikungDate1;
    }

    public void setSeaChikungDate1(Date seaChikungDate1) {
        this.seaChikungDate1 = seaChikungDate1;
    }

    public Date getSeaChikungDate2() {
        return seaChikungDate2;
    }

    public void setSeaChikungDate2(Date seaChikungDate2) {
        this.seaChikungDate2 = seaChikungDate2;
    }

    public Date getSeaChikungDate3() {
        return seaChikungDate3;
    }

    public void setSeaChikungDate3(Date seaChikungDate3) {
        this.seaChikungDate3 = seaChikungDate3;
    }

    public String getSeaChikungDoc() {
        return seaChikungDoc;
    }

    public void setSeaChikungDoc(String seaChikungDoc) {
        this.seaChikungDoc = seaChikungDoc;
    }

    public String getSeaInfluInfect() {
        return seaInfluInfect;
    }

    public void setSeaInfluInfect(String seaInfluInfect) {
        this.seaInfluInfect = seaInfluInfect;
    }

    public Date getSeaInflueInfectDate1() {
        return seaInflueInfectDate1;
    }

    public void setSeaInflueInfectDate1(Date seaInflueInfectDate1) {
        this.seaInflueInfectDate1 = seaInflueInfectDate1;
    }

    public Date getSeaInfluInfectDate2() {
        return seaInfluInfectDate2;
    }

    public void setSeaInfluInfectDate2(Date seaInfluInfectDate2) {
        this.seaInfluInfectDate2 = seaInfluInfectDate2;
    }

    public Date getSeaInfluInfectDate3() {
        return seaInfluInfectDate3;
    }

    public void setSeaInfluInfectDate3(Date seaInfluInfectDate3) {
        this.seaInfluInfectDate3 = seaInfluInfectDate3;
    }

    public String getSeaInfluInfectDoc() {
        return seaInfluInfectDoc;
    }

    public void setSeaInfluInfectDoc(String seaInfluInfectDoc) {
        this.seaInfluInfectDoc = seaInfluInfectDoc;
    }

    public String getSeaDengueInfect() {
        return seaDengueInfect;
    }

    public void setSeaDengueInfect(String seaDengueInfect) {
        this.seaDengueInfect = seaDengueInfect;
    }

    public Date getSeaDengueInfectDate1() {
        return seaDengueInfectDate1;
    }

    public void setSeaDengueInfectDate1(Date seaDengueInfectDate1) {
        this.seaDengueInfectDate1 = seaDengueInfectDate1;
    }

    public Date getSeaDengueInfectDate2() {
        return seaDengueInfectDate2;
    }

    public void setSeaDengueInfectDate2(Date seaDengueInfectDate2) {
        this.seaDengueInfectDate2 = seaDengueInfectDate2;
    }

    public Date getSeaDengueInfectDate3() {
        return seaDengueInfectDate3;
    }

    public void setSeaDengueInfectDate3(Date seaDengueInfectDate3) {
        this.seaDengueInfectDate3 = seaDengueInfectDate3;
    }

    public String getSeaDengueInfectDoc() {
        return seaDengueInfectDoc;
    }

    public void setSeaDengueInfectDoc(String seaDengueInfectDoc) {
        this.seaDengueInfectDoc = seaDengueInfectDoc;
    }

    public String getSeaFeverSymptom() {
        return seaFeverSymptom;
    }

    public void setSeaFeverSymptom(String seaFeverSymptom) {
        this.seaFeverSymptom = seaFeverSymptom;
    }

    public String getSeaRash() {
        return seaRash;
    }

    public void setSeaRash(String seaRash) {
        this.seaRash = seaRash;
    }

    public String getSeaItch() {
        return seaItch;
    }

    public void setSeaItch(String seaItch) {
        this.seaItch = seaItch;
    }

    public String getSeaRashFirst() {
        return seaRashFirst;
    }

    public void setSeaRashFirst(String seaRashFirst) {
        this.seaRashFirst = seaRashFirst;
    }

    public String getSeaRashDay() {
        return seaRashDay;
    }

    public void setSeaRashDay(String seaRashDay) {
        this.seaRashDay = seaRashDay;
    }

    public String getSeaRashMonth() {
        return seaRashMonth;
    }

    public void setSeaRashMonth(String seaRashMonth) {
        this.seaRashMonth = seaRashMonth;
    }

    public String getSeaRashYear() {
        return seaRashYear;
    }

    public void setSeaRashYear(String seaRashYear) {
        this.seaRashYear = seaRashYear;
    }

    public Integer getSeaRashDuration() {
        return seaRashDuration;
    }

    public void setSeaRashDuration(Integer seaRashDuration) {
        this.seaRashDuration = seaRashDuration;
    }

    public String getSeaRashSpread() {
        return seaRashSpread;
    }

    public void setSeaRashSpread(String seaRashSpread) {
        this.seaRashSpread = seaRashSpread;
    }

    public String getSeaSpreadPart() {
        return seaSpreadPart;
    }

    public void setSeaSpreadPart(String seaSpreadPart) {
        this.seaSpreadPart = seaSpreadPart;
    }

    public String getSeaFeverExperience() {
        return seaFeverExperience;
    }

    public void setSeaFeverExperience(String seaFeverExperience) {
        this.seaFeverExperience = seaFeverExperience;
    }

    public String getSeaTempMeasure() {
        return seaTempMeasure;
    }

    public void setSeaTempMeasure(String seaTempMeasure) {
        this.seaTempMeasure = seaTempMeasure;
    }

    public Float getSeaHighTemp() {
        return seaHighTemp;
    }

    public void setSeaHighTemp(Float seaHighTemp) {
        this.seaHighTemp = seaHighTemp;
    }

    public String getSeaHightemUnit() {
        return seaHightemUnit;
    }

    public void setSeaHightemUnit(String seaHightemUnit) {
        this.seaHightemUnit = seaHightemUnit;
    }

    public String getSeaTempunknown() {
        return seaTempunknown;
    }

    public void setSeaTempunknown(String seaTempunknown) {
        this.seaTempunknown = seaTempunknown;
    }

    public String getSeaFeverDay() {
        return seaFeverDay;
    }

    public void setSeaFeverDay(String seaFeverDay) {
        this.seaFeverDay = seaFeverDay;
    }

    public String getSeaFeverMonth() {
        return seaFeverMonth;
    }

    public void setSeaFeverMonth(String seaFeverMonth) {
        this.seaFeverMonth = seaFeverMonth;
    }

    public String getSeaFeverYear() {
        return seaFeverYear;
    }

    public void setSeaFeverYear(String seaFeverYear) {
        this.seaFeverYear = seaFeverYear;
    }

    public Integer getSeaFeverDuration() {
        return seaFeverDuration;
    }

    public void setSeaFeverDuration(Integer seaFeverDuration) {
        this.seaFeverDuration = seaFeverDuration;
    }

    public String getSeaRedeyes() {
        return seaRedeyes;
    }

    public void setSeaRedeyes(String seaRedeyes) {
        this.seaRedeyes = seaRedeyes;
    }

    public String getSeaRedeyesDay() {
        return seaRedeyesDay;
    }

    public void setSeaRedeyesDay(String seaRedeyesDay) {
        this.seaRedeyesDay = seaRedeyesDay;
    }

    public String getSeaRedeyesMonth() {
        return seaRedeyesMonth;
    }

    public void setSeaRedeyesMonth(String seaRedeyesMonth) {
        this.seaRedeyesMonth = seaRedeyesMonth;
    }

    public String getSeaRedeyesYear() {
        return seaRedeyesYear;
    }

    public void setSeaRedeyesYear(String seaRedeyesYear) {
        this.seaRedeyesYear = seaRedeyesYear;
    }

    public Integer getSeaRedeyesDuration() {
        return seaRedeyesDuration;
    }

    public void setSeaRedeyesDuration(Integer seaRedeyesDuration) {
        this.seaRedeyesDuration = seaRedeyesDuration;
    }

    public String getSeaOccurSame() {
        return seaOccurSame;
    }

    public void setSeaOccurSame(String seaOccurSame) {
        this.seaOccurSame = seaOccurSame;
    }

    public String getSeaSameSymptom() {
        return seaSameSymptom;
    }

    public void setSeaSameSymptom(String seaSameSymptom) {
        this.seaSameSymptom = seaSameSymptom;
    }

    public String getSeaJoint() {
        return seaJoint;
    }

    public void setSeaJoint(String seaJoint) {
        this.seaJoint = seaJoint;
    }

    public String getSeaJointDay() {
        return seaJointDay;
    }

    public void setSeaJointDay(String seaJointDay) {
        this.seaJointDay = seaJointDay;
    }

    public String getSeaJointMonth() {
        return seaJointMonth;
    }

    public void setSeaJointMonth(String seaJointMonth) {
        this.seaJointMonth = seaJointMonth;
    }

    public String getSeaJointYear() {
        return seaJointYear;
    }

    public void setSeaJointYear(String seaJointYear) {
        this.seaJointYear = seaJointYear;
    }

    public Integer getSeaJointDuration() {
        return seaJointDuration;
    }

    public void setSeaJointDuration(Integer seaJointDuration) {
        this.seaJointDuration = seaJointDuration;
    }

    public String getSeaHeadache() {
        return seaHeadache;
    }

    public void setSeaHeadache(String seaHeadache) {
        this.seaHeadache = seaHeadache;
    }

    public String getSeaHeadacheDay() {
        return seaHeadacheDay;
    }

    public void setSeaHeadacheDay(String seaHeadacheDay) {
        this.seaHeadacheDay = seaHeadacheDay;
    }

    public String getSeaHeadacheMonth() {
        return seaHeadacheMonth;
    }

    public void setSeaHeadacheMonth(String seaHeadacheMonth) {
        this.seaHeadacheMonth = seaHeadacheMonth;
    }

    public String getSeaHeadacheYear() {
        return seaHeadacheYear;
    }

    public void setSeaHeadacheYear(String seaHeadacheYear) {
        this.seaHeadacheYear = seaHeadacheYear;
    }

    public Integer getSeaHeadacheDuration() {
        return seaHeadacheDuration;
    }

    public void setSeaHeadacheDuration(Integer seaHeadacheDuration) {
        this.seaHeadacheDuration = seaHeadacheDuration;
    }

    public String getSeaSymptomOther() {
        return seaSymptomOther;
    }

    public void setSeaSymptomOther(String seaSymptomOther) {
        this.seaSymptomOther = seaSymptomOther;
    }

    public String getSeaSpecifySymptom() {
        return seaSpecifySymptom;
    }

    public void setSeaSpecifySymptom(String seaSpecifySymptom) {
        this.seaSpecifySymptom = seaSpecifySymptom;
    }

    public String getSeaOtherSymptom() {
        return seaOtherSymptom;
    }

    public void setSeaOtherSymptom(String seaOtherSymptom) {
        this.seaOtherSymptom = seaOtherSymptom;
    }

    public String getSeaMedicare() {
        return seaMedicare;
    }

    public void setSeaMedicare(String seaMedicare) {
        this.seaMedicare = seaMedicare;
    }

    public String getSeaCareDay() {
        return seaCareDay;
    }

    public void setSeaCareDay(String seaCareDay) {
        this.seaCareDay = seaCareDay;
    }

    public String getSeaCareMonth() {
        return seaCareMonth;
    }

    public void setSeaCareMonth(String seaCareMonth) {
        this.seaCareMonth = seaCareMonth;
    }

    public String getSeaCareYear() {
        return seaCareYear;
    }

    public void setSeaCareYear(String seaCareYear) {
        this.seaCareYear = seaCareYear;
    }

    public String getSeaCareFacility() {
        return seaCareFacility;
    }

    public void setSeaCareFacility(String seaCareFacility) {
        this.seaCareFacility = seaCareFacility;
    }

    public String getSeaHospitalized() {
        return seaHospitalized;
    }

    public void setSeaHospitalized(String seaHospitalized) {
        this.seaHospitalized = seaHospitalized;
    }

    public String getSeaHospital() {
        return seaHospital;
    }

    public void setSeaHospital(String seaHospital) {
        this.seaHospital = seaHospital;
    }

    public String getSeaDiagRubella() {
        return seaDiagRubella;
    }

    public void setSeaDiagRubella(String seaDiagRubella) {
        this.seaDiagRubella = seaDiagRubella;
    }

    public String getSeaDiagDengue() {
        return seaDiagDengue;
    }

    public void setSeaDiagDengue(String seaDiagDengue) {
        this.seaDiagDengue = seaDiagDengue;
    }

    public String getSeaDiagChikung() {
        return seaDiagChikung;
    }

    public void setSeaDiagChikung(String seaDiagChikung) {
        this.seaDiagChikung = seaDiagChikung;
    }

    public String getSeaDiagZika() {
        return seaDiagZika;
    }

    public void setSeaDiagZika(String seaDiagZika) {
        this.seaDiagZika = seaDiagZika;
    }

    public String getSeaDiagCytome() {
        return seaDiagCytome;
    }

    public void setSeaDiagCytome(String seaDiagCytome) {
        this.seaDiagCytome = seaDiagCytome;
    }

    public String getSeaMedicine() {
        return seaMedicine;
    }

    public void setSeaMedicine(String seaMedicine) {
        this.seaMedicine = seaMedicine;
    }

    public String getSeaMedcineName() {
        return seaMedcineName;
    }

    public void setSeaMedcineName(String seaMedcineName) {
        this.seaMedcineName = seaMedcineName;
    }

    public String getSeaGuillainbarre() {
        return seaGuillainbarre;
    }

    public void setSeaGuillainbarre(String seaGuillainbarre) {
        this.seaGuillainbarre = seaGuillainbarre;
    }

    public String getSeaTingling() {
        return seaTingling;
    }

    public void setSeaTingling(String seaTingling) {
        this.seaTingling = seaTingling;
    }

    public String getSeaTinglingArm() {
        return seaTinglingArm;
    }

    public void setSeaTinglingArm(String seaTinglingArm) {
        this.seaTinglingArm = seaTinglingArm;
    }

    public String getSeaTinglingLeg() {
        return seaTinglingLeg;
    }

    public void setSeaTinglingLeg(String seaTinglingLeg) {
        this.seaTinglingLeg = seaTinglingLeg;
    }

    public String getSeaTinglingHand() {
        return seaTinglingHand;
    }

    public void setSeaTinglingHand(String seaTinglingHand) {
        this.seaTinglingHand = seaTinglingHand;
    }

    public String getSeaTinglingFoot() {
        return seaTinglingFoot;
    }

    public void setSeaTinglingFoot(String seaTinglingFoot) {
        this.seaTinglingFoot = seaTinglingFoot;
    }

    public String getSeaTinglingFace() {
        return seaTinglingFace;
    }

    public void setSeaTinglingFace(String seaTinglingFace) {
        this.seaTinglingFace = seaTinglingFace;
    }

    public String getSeaTinglingOther() {
        return seaTinglingOther;
    }

    public void setSeaTinglingOther(String seaTinglingOther) {
        this.seaTinglingOther = seaTinglingOther;
    }

    public String getSeaSensationMin() {
        return seaSensationMin;
    }

    public void setSeaSensationMin(String seaSensationMin) {
        this.seaSensationMin = seaSensationMin;
    }

    public String getSeaSensationHr() {
        return seaSensationHr;
    }

    public void setSeaSensationHr(String seaSensationHr) {
        this.seaSensationHr = seaSensationHr;
    }

    public String getSeaSenstaionDay() {
        return seaSenstaionDay;
    }

    public void setSeaSenstaionDay(String seaSenstaionDay) {
        this.seaSenstaionDay = seaSenstaionDay;
    }

    public String getSeaInjury() {
        return seaInjury;
    }

    public void setSeaInjury(String seaInjury) {
        this.seaInjury = seaInjury;
    }

    public String getSeaTinglingDay() {
        return seaTinglingDay;
    }

    public void setSeaTinglingDay(String seaTinglingDay) {
        this.seaTinglingDay = seaTinglingDay;
    }

    public String getSeaTinglingMonth() {
        return seaTinglingMonth;
    }

    public void setSeaTinglingMonth(String seaTinglingMonth) {
        this.seaTinglingMonth = seaTinglingMonth;
    }

    public String getSeaTinglingYear() {
        return seaTinglingYear;
    }

    public void setSeaTinglingYear(String seaTinglingYear) {
        this.seaTinglingYear = seaTinglingYear;
    }

    public Integer getSeaTinglingDuration() {
        return seaTinglingDuration;
    }

    public void setSeaTinglingDuration(Integer seaTinglingDuration) {
        this.seaTinglingDuration = seaTinglingDuration;
    }

    public String getSeaNumbness() {
        return seaNumbness;
    }

    public void setSeaNumbness(String seaNumbness) {
        this.seaNumbness = seaNumbness;
    }

    public String getSeaNumbArm() {
        return seaNumbArm;
    }

    public void setSeaNumbArm(String seaNumbArm) {
        this.seaNumbArm = seaNumbArm;
    }

    public String getSeaNumbLeg() {
        return seaNumbLeg;
    }

    public void setSeaNumbLeg(String seaNumbLeg) {
        this.seaNumbLeg = seaNumbLeg;
    }

    public String getSeaNumbHand() {
        return seaNumbHand;
    }

    public void setSeaNumbHand(String seaNumbHand) {
        this.seaNumbHand = seaNumbHand;
    }

    public String getSeaNumbFoot() {
        return seaNumbFoot;
    }

    public void setSeaNumbFoot(String seaNumbFoot) {
        this.seaNumbFoot = seaNumbFoot;
    }

    public String getSeaNumbFace() {
        return seaNumbFace;
    }

    public void setSeaNumbFace(String seaNumbFace) {
        this.seaNumbFace = seaNumbFace;
    }

    public String getSeaNumbOther() {
        return seaNumbOther;
    }

    public void setSeaNumbOther(String seaNumbOther) {
        this.seaNumbOther = seaNumbOther;
    }

    public String getSeaNumbDay() {
        return seaNumbDay;
    }

    public void setSeaNumbDay(String seaNumbDay) {
        this.seaNumbDay = seaNumbDay;
    }

    public String getSeaNumbMonth() {
        return seaNumbMonth;
    }

    public void setSeaNumbMonth(String seaNumbMonth) {
        this.seaNumbMonth = seaNumbMonth;
    }

    public String getSeaNumbYear() {
        return seaNumbYear;
    }

    public void setSeaNumbYear(String seaNumbYear) {
        this.seaNumbYear = seaNumbYear;
    }

    public Integer getSeaNumbDuration() {
        return seaNumbDuration;
    }

    public void setSeaNumbDuration(Integer seaNumbDuration) {
        this.seaNumbDuration = seaNumbDuration;
    }

    public String getSeaParalysis() {
        return seaParalysis;
    }

    public void setSeaParalysis(String seaParalysis) {
        this.seaParalysis = seaParalysis;
    }

    public String getSeaParaArm() {
        return seaParaArm;
    }

    public void setSeaParaArm(String seaParaArm) {
        this.seaParaArm = seaParaArm;
    }

    public String getSeaParaLeg() {
        return seaParaLeg;
    }

    public void setSeaParaLeg(String seaParaLeg) {
        this.seaParaLeg = seaParaLeg;
    }

    public String getSeaParaHand() {
        return seaParaHand;
    }

    public void setSeaParaHand(String seaParaHand) {
        this.seaParaHand = seaParaHand;
    }

    public String getSeaParaFoot() {
        return seaParaFoot;
    }

    public void setSeaParaFoot(String seaParaFoot) {
        this.seaParaFoot = seaParaFoot;
    }

    public String getSeaParaFace() {
        return seaParaFace;
    }

    public void setSeaParaFace(String seaParaFace) {
        this.seaParaFace = seaParaFace;
    }

    public String getSeaParaOther() {
        return seaParaOther;
    }

    public void setSeaParaOther(String seaParaOther) {
        this.seaParaOther = seaParaOther;
    }

    public String getSeaParaDay() {
        return seaParaDay;
    }

    public void setSeaParaDay(String seaParaDay) {
        this.seaParaDay = seaParaDay;
    }

    public String getSeaParaMonth() {
        return seaParaMonth;
    }

    public void setSeaParaMonth(String seaParaMonth) {
        this.seaParaMonth = seaParaMonth;
    }

    public String getSeaParaYear() {
        return seaParaYear;
    }

    public void setSeaParaYear(String seaParaYear) {
        this.seaParaYear = seaParaYear;
    }

    public Integer getSeaParaDuration() {
        return seaParaDuration;
    }

    public void setSeaParaDuration(Integer seaParaDuration) {
        this.seaParaDuration = seaParaDuration;
    }

    }
