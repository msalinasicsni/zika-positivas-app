package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.domain.ZpEstadoInfante;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

/**
 * Created by FIRSTICT on 2/8/2017.
 * V1.0
 */
public class ZpEstadoInfanteHelper {

    public static ContentValues crearZpEstadoInfante(ZpEstadoInfante mZpEstadoInfante){
        ContentValues cv = new ContentValues();

        cv.put(MainDBConstants.recordId, mZpEstadoInfante.getRecordId());
        cv.put(MainDBConstants.nacimiento, String.valueOf(mZpEstadoInfante.getNacimiento()));
        cv.put(MainDBConstants.mes3, String.valueOf(mZpEstadoInfante.getMes3()));
        cv.put(MainDBConstants.mes6, String.valueOf(mZpEstadoInfante.getMes6()));
        cv.put(MainDBConstants.mes12, String.valueOf(mZpEstadoInfante.getMes12()));       

        if (mZpEstadoInfante.getRecordDate() != null) cv.put(MainDBConstants.recordDate, mZpEstadoInfante.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, mZpEstadoInfante.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(mZpEstadoInfante.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, mZpEstadoInfante.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, mZpEstadoInfante.getInstancePath());
        cv.put(MainDBConstants.STATUS, mZpEstadoInfante.getEstado());
        cv.put(MainDBConstants.START, mZpEstadoInfante.getStart());
        cv.put(MainDBConstants.END, mZpEstadoInfante.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, mZpEstadoInfante.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, mZpEstadoInfante.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, mZpEstadoInfante.getPhonenumber());
        if (mZpEstadoInfante.getToday() != null) cv.put(MainDBConstants.TODAY, mZpEstadoInfante.getToday().getTime());

        return cv;

    }

    public static ZpEstadoInfante crearZpEstadoInfante(Cursor cursor){

    	ZpEstadoInfante mZpEstadoInfante = new ZpEstadoInfante();
        mZpEstadoInfante.setRecordId(cursor.getString(cursor.getColumnIndex(MainDBConstants.recordId)));
        
        mZpEstadoInfante.setNacimiento(cursor.getString(cursor.getColumnIndex(MainDBConstants.nacimiento)).charAt(0));
        mZpEstadoInfante.setMes3(cursor.getString(cursor.getColumnIndex(MainDBConstants.mes3)).charAt(0));
        mZpEstadoInfante.setMes6(cursor.getString(cursor.getColumnIndex(MainDBConstants.mes6)).charAt(0));
        mZpEstadoInfante.setMes12(cursor.getString(cursor.getColumnIndex(MainDBConstants.mes12)).charAt(0));

        if(cursor.getLong(cursor.getColumnIndex(MainDBConstants.recordDate))>0) mZpEstadoInfante.setRecordDate(new Date(cursor.getLong(cursor.getColumnIndex(MainDBConstants.recordDate))));
        mZpEstadoInfante.setRecordUser(cursor.getString(cursor.getColumnIndex(MainDBConstants.recordUser)));
        mZpEstadoInfante.setPasive(cursor.getString(cursor.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        mZpEstadoInfante.setIdInstancia(cursor.getInt(cursor.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        mZpEstadoInfante.setInstancePath(cursor.getString(cursor.getColumnIndex(MainDBConstants.FILE_PATH)));
        mZpEstadoInfante.setEstado(cursor.getString(cursor.getColumnIndex(MainDBConstants.STATUS)));
        mZpEstadoInfante.setStart(cursor.getString(cursor.getColumnIndex(MainDBConstants.START)));
        mZpEstadoInfante.setEnd(cursor.getString(cursor.getColumnIndex(MainDBConstants.END)));
        mZpEstadoInfante.setSimserial(cursor.getString(cursor.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        mZpEstadoInfante.setPhonenumber(cursor.getString(cursor.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        mZpEstadoInfante.setDeviceid(cursor.getString(cursor.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursor.getLong(cursor.getColumnIndex(MainDBConstants.TODAY))>0) mZpEstadoInfante.setToday(new Date(cursor.getLong(cursor.getColumnIndex(MainDBConstants.TODAY))));

        return mZpEstadoInfante;
    }
}
