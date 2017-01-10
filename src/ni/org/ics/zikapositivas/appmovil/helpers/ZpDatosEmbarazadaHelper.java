package ni.org.ics.zikapositivas.appmovil.helpers;

import java.math.BigDecimal;
import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.domain.ZpDatosEmbarazada;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

import android.content.ContentValues;
import android.database.Cursor;

public class ZpDatosEmbarazadaHelper {
	
	public static ContentValues crearZpDatosEmbarazadaValues(ZpDatosEmbarazada datos){
		ContentValues cv = new ContentValues();
		cv.put(MainDBConstants.recordId, datos.getRecordId());
		cv.put(MainDBConstants.cs, String.valueOf(datos.getCs()));
		cv.put(MainDBConstants.nombre1, String.valueOf(datos.getNombre1()));
		cv.put(MainDBConstants.nombre2, String.valueOf(datos.getNombre2()));
		cv.put(MainDBConstants.apellido1, String.valueOf(datos.getApellido1()));
		cv.put(MainDBConstants.apellido2, String.valueOf(datos.getApellido2()));
		if (datos.getFechaNac() != null) cv.put(MainDBConstants.fechaNac, datos.getFechaNac().getTime());
		cv.put(MainDBConstants.direccion, String.valueOf(datos.getDireccion()));
		if (datos.getLatitud() != null) cv.put(MainDBConstants.latitud, datos.getLatitud().toString());
		if (datos.getLongitud() != null) cv.put(MainDBConstants.longitud, datos.getLongitud().toString());
		if (datos.getRecordDate() != null) cv.put(MainDBConstants.recordDate, datos.getRecordDate().getTime());
		cv.put(MainDBConstants.recordUser, datos.getRecordUser());
		cv.put(MainDBConstants.pasive, String.valueOf(datos.getPasive()));
		cv.put(MainDBConstants.ID_INSTANCIA, datos.getIdInstancia());
		cv.put(MainDBConstants.FILE_PATH, datos.getInstancePath());
		cv.put(MainDBConstants.STATUS, datos.getEstado());
		cv.put(MainDBConstants.START, datos.getStart());
		cv.put(MainDBConstants.END, datos.getEnd());
		cv.put(MainDBConstants.DEVICE_ID, datos.getDeviceid());
		cv.put(MainDBConstants.SIM_SERIAL, datos.getSimserial());
		cv.put(MainDBConstants.PHONE_NUMBER, datos.getPhonenumber());
		if (datos.getToday() != null) cv.put(MainDBConstants.TODAY, datos.getToday().getTime());
		return cv; 
	}	
	
	public static ZpDatosEmbarazada crearZpDatosEmbarazada(Cursor cursorDatos){		
		ZpDatosEmbarazada mDatos = new ZpDatosEmbarazada();
		mDatos.setRecordId(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.recordId)));
		mDatos.setCs(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.cs)));
		mDatos.setNombre1(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.nombre1)));
		mDatos.setNombre2(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.nombre2)));
		mDatos.setApellido1(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.apellido1)));
		mDatos.setApellido2(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.apellido2)));
		if(cursorDatos.getLong(cursorDatos.getColumnIndex(MainDBConstants.fechaNac))>0) mDatos.setFechaNac(new Date(cursorDatos.getLong(cursorDatos.getColumnIndex(MainDBConstants.fechaNac))));
		mDatos.setDireccion(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.direccion)));
		if(cursorDatos.getDouble(cursorDatos.getColumnIndex(MainDBConstants.latitud))!=0) mDatos.setLatitud(BigDecimal.valueOf(cursorDatos.getDouble(cursorDatos.getColumnIndex(MainDBConstants.latitud))));
		if(cursorDatos.getDouble(cursorDatos.getColumnIndex(MainDBConstants.longitud))!=0) mDatos.setLongitud(BigDecimal.valueOf(cursorDatos.getDouble(cursorDatos.getColumnIndex(MainDBConstants.longitud))));
		if(cursorDatos.getLong(cursorDatos.getColumnIndex(MainDBConstants.recordDate))>0) mDatos.setRecordDate(new Date(cursorDatos.getLong(cursorDatos.getColumnIndex(MainDBConstants.recordDate))));
		mDatos.setRecordUser(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.recordUser)));
		mDatos.setPasive(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.pasive)).charAt(0));
		mDatos.setIdInstancia(cursorDatos.getInt(cursorDatos.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
		mDatos.setInstancePath(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.FILE_PATH)));
		mDatos.setEstado(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.STATUS)));
		mDatos.setStart(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.START)));
		mDatos.setEnd(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.END)));
		mDatos.setSimserial(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.SIM_SERIAL)));
		mDatos.setPhonenumber(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
		mDatos.setDeviceid(cursorDatos.getString(cursorDatos.getColumnIndex(MainDBConstants.DEVICE_ID)));
		if(cursorDatos.getLong(cursorDatos.getColumnIndex(MainDBConstants.TODAY))>0) mDatos.setToday(new Date(cursorDatos.getLong(cursorDatos.getColumnIndex(MainDBConstants.TODAY))));
		return mDatos;
	}
}
