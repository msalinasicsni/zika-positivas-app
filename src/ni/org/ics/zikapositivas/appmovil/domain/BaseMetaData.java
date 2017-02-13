package ni.org.ics.zikapositivas.appmovil.domain;

import java.io.Serializable;
import java.util.Date;

public class BaseMetaData implements Serializable 
{  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date recordDate;
	private String recordUser;
	private char pasive = '0';
	//Manejo ODK
	private Integer idInstancia;
	private String instancePath;
	private String estado;
	//Metadata del formulario movil
	private String start;
	private String end;
	private String deviceid;
	private String simserial;
	private String phonenumber;
	private Date today;	
	
	public BaseMetaData() {

	}

	public BaseMetaData(Date recordDate, String recordUser) {
		super();
		this.recordDate = recordDate;
		this.recordUser = recordUser;
	}
	
	
	
	public BaseMetaData(Date recordDate, String recordUser, char pasive,
			Integer idInstancia, String instancePath, String estado,
			String start, String end, String deviceid, String simserial,
			String phonenumber, Date today) {
		super();
		this.recordDate = recordDate;
		this.recordUser = recordUser;
		this.pasive = pasive;
		this.idInstancia = idInstancia;
		this.instancePath = instancePath;
		this.estado = estado;
		this.start = start;
		this.end = end;
		this.deviceid = deviceid;
		this.simserial = simserial;
		this.phonenumber = phonenumber;
		this.today = today;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public String getRecordUser() {
		return recordUser;
	}

	public void setRecordUser(String recordUser) {
		this.recordUser = recordUser;
	}
	
	public char getPasive() {
		return pasive;
	}

	public void setPasive(char pasive) {
		this.pasive = pasive;
	}

	public Integer getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(Integer idInstancia) {
		this.idInstancia = idInstancia;
	}

	public String getInstancePath() {
		return instancePath;
	}

	public void setInstancePath(String instancePath) {
		this.instancePath = instancePath;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

}  
