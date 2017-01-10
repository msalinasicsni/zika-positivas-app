package ni.org.ics.zikapositivas.appmovil.helpers;

import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoEmbarazada;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

import android.content.ContentValues;
import android.database.Cursor;

public class ZpEstadoEmbarazadaHelper {
	
	public static ContentValues crearZpEstadoEmbarazadaValues(ZpEstadoEmbarazada estado){
		ContentValues cv = new ContentValues();
		cv.put(MainDBConstants.recordId, estado.getRecordId());
		cv.put(MainDBConstants.ingreso, String.valueOf(estado.getIngreso()));
		cv.put(MainDBConstants.sem2, String.valueOf(estado.getSem2()));
		cv.put(MainDBConstants.sem4, String.valueOf(estado.getSem4()));
		cv.put(MainDBConstants.sem6, String.valueOf(estado.getSem6()));
		cv.put(MainDBConstants.sem8, String.valueOf(estado.getSem8()));
		cv.put(MainDBConstants.sem10, String.valueOf(estado.getSem10()));
		cv.put(MainDBConstants.sem12, String.valueOf(estado.getSem12()));
		cv.put(MainDBConstants.sem14, String.valueOf(estado.getSem14()));
		cv.put(MainDBConstants.sem16, String.valueOf(estado.getSem16()));
		cv.put(MainDBConstants.sem18, String.valueOf(estado.getSem18()));
		cv.put(MainDBConstants.sem20, String.valueOf(estado.getSem20()));
		cv.put(MainDBConstants.sem22, String.valueOf(estado.getSem22()));
		cv.put(MainDBConstants.sem24, String.valueOf(estado.getSem24()));
		cv.put(MainDBConstants.sem26, String.valueOf(estado.getSem26()));
		cv.put(MainDBConstants.sem28, String.valueOf(estado.getSem28()));
		cv.put(MainDBConstants.sem30, String.valueOf(estado.getSem30()));
		cv.put(MainDBConstants.sem32, String.valueOf(estado.getSem32()));
		cv.put(MainDBConstants.sem34, String.valueOf(estado.getSem34()));
		cv.put(MainDBConstants.sem36, String.valueOf(estado.getSem36()));
		cv.put(MainDBConstants.sem38, String.valueOf(estado.getSem38()));
		cv.put(MainDBConstants.sem40, String.valueOf(estado.getSem40()));
		cv.put(MainDBConstants.sem42, String.valueOf(estado.getSem42()));
		cv.put(MainDBConstants.sem44, String.valueOf(estado.getSem44()));
		cv.put(MainDBConstants.parto, String.valueOf(estado.getParto()));
		cv.put(MainDBConstants.posparto, String.valueOf(estado.getPosparto()));
		if (estado.getRecordDate() != null) cv.put(MainDBConstants.recordDate, estado.getRecordDate().getTime());
		cv.put(MainDBConstants.recordUser, estado.getRecordUser());
		cv.put(MainDBConstants.pasive, String.valueOf(estado.getPasive()));
		cv.put(MainDBConstants.ID_INSTANCIA, estado.getIdInstancia());
		cv.put(MainDBConstants.FILE_PATH, estado.getInstancePath());
		cv.put(MainDBConstants.STATUS, estado.getEstado());
		cv.put(MainDBConstants.START, estado.getStart());
		cv.put(MainDBConstants.END, estado.getEnd());
		cv.put(MainDBConstants.DEVICE_ID, estado.getDeviceid());
		cv.put(MainDBConstants.SIM_SERIAL, estado.getSimserial());
		cv.put(MainDBConstants.PHONE_NUMBER, estado.getPhonenumber());
		if (estado.getToday() != null) cv.put(MainDBConstants.TODAY, estado.getToday().getTime());
		return cv; 
	}	
	
	public static ZpEstadoEmbarazada crearZpEstadoEmbarazada(Cursor cursorEstado){		
		ZpEstadoEmbarazada mEstado = new ZpEstadoEmbarazada();
		mEstado.setRecordId(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.recordId)));
		mEstado.setIngreso(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.ingreso)).charAt(0));
		mEstado.setSem2(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem2)).charAt(0));
		mEstado.setSem4(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem4)).charAt(0));
		mEstado.setSem6(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem6)).charAt(0));
		mEstado.setSem8(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem8)).charAt(0));
		mEstado.setSem10(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem10)).charAt(0));
		mEstado.setSem12(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem12)).charAt(0));
		mEstado.setSem14(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem14)).charAt(0));
		mEstado.setSem16(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem16)).charAt(0));
		mEstado.setSem18(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem18)).charAt(0));
		mEstado.setSem20(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem20)).charAt(0));
		mEstado.setSem22(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem22)).charAt(0));
		mEstado.setSem24(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem24)).charAt(0));
		mEstado.setSem26(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem26)).charAt(0));
		mEstado.setSem28(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem28)).charAt(0));
		mEstado.setSem30(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem30)).charAt(0));
		mEstado.setSem32(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem32)).charAt(0));
		mEstado.setSem34(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem34)).charAt(0));
		mEstado.setSem36(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem36)).charAt(0));
		mEstado.setSem38(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem38)).charAt(0));
		mEstado.setSem40(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem40)).charAt(0));
		mEstado.setSem42(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem42)).charAt(0));
		mEstado.setSem44(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.sem44)).charAt(0));
		mEstado.setParto(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.parto)).charAt(0));
		mEstado.setPosparto(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.posparto)).charAt(0));
		if(cursorEstado.getLong(cursorEstado.getColumnIndex(MainDBConstants.recordDate))>0) mEstado.setRecordDate(new Date(cursorEstado.getLong(cursorEstado.getColumnIndex(MainDBConstants.recordDate))));
		mEstado.setRecordUser(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.recordUser)));
		mEstado.setPasive(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.pasive)).charAt(0));
		mEstado.setIdInstancia(cursorEstado.getInt(cursorEstado.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
		mEstado.setInstancePath(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.FILE_PATH)));
		mEstado.setEstado(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.STATUS)));
		mEstado.setStart(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.START)));
		mEstado.setEnd(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.END)));
		mEstado.setSimserial(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.SIM_SERIAL)));
		mEstado.setPhonenumber(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
		mEstado.setDeviceid(cursorEstado.getString(cursorEstado.getColumnIndex(MainDBConstants.DEVICE_ID)));
		if(cursorEstado.getLong(cursorEstado.getColumnIndex(MainDBConstants.TODAY))>0) mEstado.setToday(new Date(cursorEstado.getLong(cursorEstado.getColumnIndex(MainDBConstants.TODAY))));
		return mEstado;
	}
}
