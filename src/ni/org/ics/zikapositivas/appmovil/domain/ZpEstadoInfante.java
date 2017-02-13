package ni.org.ics.zikapositivas.appmovil.domain;

import java.util.Date;

/**
 * Created by FIRSTICT on 2/10/2017.
 * V1.0
 */
public class ZpEstadoInfante extends BaseMetaData{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String recordId;
    private char nacimiento = '0';
    private char mes3 = '0';
    private char mes6 = '0';
    private char mes12 = '0';
    
    public ZpEstadoInfante(){
    	
    }

    public ZpEstadoInfante(String recordId, char nacimiento, char mes3,
			char mes6, char mes12, Date recordDate, String recordUser, char pasive,
			Integer idInstancia, String instancePath, String estado,
			String start, String end, String deviceid, String simserial,
			String phonenumber, Date today) {
		super(recordDate, recordUser, pasive,
				idInstancia, instancePath, estado,
				start, end, deviceid, simserial,
				phonenumber, today);
		this.recordId = recordId;
		this.nacimiento = nacimiento;
		this.mes3 = mes3;
		this.mes6 = mes6;
		this.mes12 = mes12;
	}

	public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public char getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(char nacimiento) {
        this.nacimiento = nacimiento;
    }

    public char getMes3() {
        return mes3;
    }

    public void setMes3(char mes3) {
        this.mes3 = mes3;
    }

    public char getMes6() {
        return mes6;
    }

    public void setMes6(char mes6) {
        this.mes6 = mes6;
    }

    public char getMes12() {
        return mes12;
    }

    public void setMes12(char mes12) {
        this.mes12 = mes12;
    }

}
