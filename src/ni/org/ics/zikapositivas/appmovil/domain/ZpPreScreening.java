package ni.org.ics.zikapositivas.appmovil.domain;

/**
 * Created by FIRSTICT on 10/6/2016.
 * V1.0
 */
public class ZpPreScreening extends BaseMetaData{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recId;
	private String compId;
	private String cs;
	private Integer consecutive;
	private String verbalConsent;
	
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getCs() {
		return cs;
	}
	public void setCs(String cs) {
		this.cs = cs;
	}
	public Integer getConsecutive() {
		return consecutive;
	}
	public void setConsecutive(Integer consecutive) {
		this.consecutive = consecutive;
	}
	public String getVerbalConsent() {
		return verbalConsent;
	}
	public void setVerbalConsent(String verbalConsent) {
		this.verbalConsent = verbalConsent;
	}
	
}
