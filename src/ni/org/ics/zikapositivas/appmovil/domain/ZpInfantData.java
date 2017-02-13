package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 2/7/2017.
 * V1.0
 */
public class ZpInfantData extends BaseMetaData {

    private static final long serialVersionUID = 1L;
    private String recordId;
    private String pregnantId;
    private Date infantBirthDate;
    private String infantMode;
    private String infantDeliveryWho;
    private String infantDeliveryOccur;
    private String infantHospitalId;
    private String infantClinicId;
    private String infantDeliveryOther;
    private String infantNumBirth;
    private String infantFetalOutcome;
    private String infantCauseDeath;
    private String infantSexBaby;
    private String infantConsentInfant;
    private String infantReasonNoconsent;
    private String infantNoconsentOther;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getPregnantId() {
        return pregnantId;
    }

    public void setPregnantId(String pregnantId) {
        this.pregnantId = pregnantId;
    }

    public Date getInfantBirthDate() {
        return infantBirthDate;
    }

    public void setInfantBirthDate(Date infantBirthDate) {
        this.infantBirthDate = infantBirthDate;
    }

    public String getInfantMode() {
        return infantMode;
    }

    public void setInfantMode(String infantMode) {
        this.infantMode = infantMode;
    }

    public String getInfantDeliveryWho() {
        return infantDeliveryWho;
    }

    public void setInfantDeliveryWho(String infantDeliveryWho) {
        this.infantDeliveryWho = infantDeliveryWho;
    }

    public String getInfantDeliveryOccur() {
        return infantDeliveryOccur;
    }

    public void setInfantDeliveryOccur(String infantDeliveryOccur) {
        this.infantDeliveryOccur = infantDeliveryOccur;
    }

    public String getInfantHospitalId() {
        return infantHospitalId;
    }

    public void setInfantHospitalId(String infantHospitalId) {
        this.infantHospitalId = infantHospitalId;
    }

    public String getInfantClinicId() {
        return infantClinicId;
    }

    public void setInfantClinicId(String infantClinicId) {
        this.infantClinicId = infantClinicId;
    }

    public String getInfantDeliveryOther() {
        return infantDeliveryOther;
    }

    public void setInfantDeliveryOther(String infantDeliveryOther) {
        this.infantDeliveryOther = infantDeliveryOther;
    }

    public String getInfantNumBirth() {
        return infantNumBirth;
    }

    public void setInfantNumBirth(String infantNumBirth) {
        this.infantNumBirth = infantNumBirth;
    }

    public String getInfantFetalOutcome() {
        return infantFetalOutcome;
    }

    public void setInfantFetalOutcome(String infantFetalOutcome) {
        this.infantFetalOutcome = infantFetalOutcome;
    }

    public String getInfantCauseDeath() {
        return infantCauseDeath;
    }

    public void setInfantCauseDeath(String infantCauseDeath) {
        this.infantCauseDeath = infantCauseDeath;
    }

    public String getInfantSexBaby() {
        return infantSexBaby;
    }

    public void setInfantSexBaby(String infantSexBaby) {
        this.infantSexBaby = infantSexBaby;
    }

	public String getInfantConsentInfant() {
		return infantConsentInfant;
	}

	public void setInfantConsentInfant(String infantConsentInfant) {
		this.infantConsentInfant = infantConsentInfant;
	}

	public String getInfantReasonNoconsent() {
		return infantReasonNoconsent;
	}

	public void setInfantReasonNoconsent(String infantReasonNoconsent) {
		this.infantReasonNoconsent = infantReasonNoconsent;
	}

	public String getInfantNoconsentOther() {
		return infantNoconsentOther;
	}

	public void setInfantNoconsentOther(String infantNoconsentOther) {
		this.infantNoconsentOther = infantNoconsentOther;
	}

    
}
