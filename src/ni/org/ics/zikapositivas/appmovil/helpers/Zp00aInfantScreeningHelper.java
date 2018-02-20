package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.zikapositivas.appmovil.domain.Zp00aInfantScreening;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;


import java.util.Date;

/**
 * Created by ics on 23/1/2018.
 */
public class Zp00aInfantScreeningHelper {

    public static ContentValues crearZp00aInfantScreeningValues(Zp00aInfantScreening screening){
        ContentValues cv = new ContentValues();
        cv.put(MainDBConstants.recordId, screening.getRecordId());
        cv.put(MainDBConstants.pregnantId, screening.getPregnantId());
        cv.put(MainDBConstants.redcapEventName, screening.getRedcapEventName());
        if (screening.getInfVisitDt() != null) cv.put(MainDBConstants.infVisitDt, screening.getInfVisitDt().getTime());
        cv.put(MainDBConstants.infRemain, screening.getInfRemain());
        cv.put(MainDBConstants.infConsent, screening.getInfConsent());
        cv.put(MainDBConstants.infConsenta, screening.getInfConsenta());
        cv.put(MainDBConstants.infConsentb, screening.getInfConsentb());
        cv.put(MainDBConstants.infConsentc, screening.getInfConsentc());
        cv.put(MainDBConstants.infConsentd, screening.getInfConsentd());
        cv.put(MainDBConstants.infInfid, screening.getInfInfid());
        cv.put(MainDBConstants.infReasonno, screening.getInfReasonno());
        cv.put(MainDBConstants.infReasonOther, screening.getInfReasonOther());
        cv.put(MainDBConstants.infIdCompleting, screening.getInfIdCompleting());
        if (screening.getInfDateCompleted() != null) cv.put(MainDBConstants.infDateCompleted, screening.getInfDateCompleted().getTime());
        cv.put(MainDBConstants.infIdReviewer, screening.getInfIdReviewer());
        if (screening.getInfDateReviewed() != null) cv.put(MainDBConstants.infDateReviewed, screening.getInfDateReviewed().getTime());
        cv.put(MainDBConstants.infIdDataEntry, screening.getInfIdDataEntry());
        if (screening.getInfDateEntered() != null) cv.put(MainDBConstants.infDateEntered, screening.getInfDateEntered().getTime());
        if (screening.getRecordDate() != null) cv.put(MainDBConstants.recordDate, screening.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, screening.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(screening.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, screening.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, screening.getInstancePath());
        cv.put(MainDBConstants.STATUS, screening.getEstado());
        cv.put(MainDBConstants.START, screening.getStart());
        cv.put(MainDBConstants.END, screening.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, screening.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, screening.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, screening.getPhonenumber());
        if (screening.getToday() != null) cv.put(MainDBConstants.TODAY, screening.getToday().getTime());
        return cv;
    }

    public static Zp00aInfantScreening crearZp00aInfantScreening(Cursor cursorScreening){
        Zp00aInfantScreening infScreening = new Zp00aInfantScreening();
        infScreening.setRecordId(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.recordId)));
        infScreening.setPregnantId(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.pregnantId)));
        infScreening.setRedcapEventName(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.redcapEventName)));
        if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infVisitDt))>0) infScreening.setInfVisitDt(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infVisitDt))));
        infScreening.setInfRemain(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infRemain)));
        infScreening.setInfConsent(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infConsent)));
        infScreening.setInfConsenta(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infConsenta)));
        infScreening.setInfConsentb(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infConsentb)));
        infScreening.setInfConsentc(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infConsentc)));
        infScreening.setInfConsentd(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infConsentd)));
        infScreening.setInfInfid(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infInfid)));
        infScreening.setInfReasonno(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infReasonno)));
        infScreening.setInfReasonOther(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infReasonOther)));
        infScreening.setInfIdCompleting(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infIdCompleting)));
        if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infDateCompleted))>0) infScreening.setInfDateCompleted(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infDateCompleted))));
        infScreening.setInfIdReviewer(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infIdReviewer)));
        if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infDateReviewed))>0) infScreening.setInfDateReviewed(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infDateReviewed))));
        infScreening.setInfIdDataEntry(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.infIdDataEntry)));
        if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infDateEntered))>0) infScreening.setInfDateEntered(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.infDateEntered))));
        if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.recordDate))>0) infScreening.setRecordDate(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.recordDate))));
        infScreening.setRecordUser(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.recordUser)));
        infScreening.setPasive(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        infScreening.setIdInstancia(cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        infScreening.setInstancePath(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.FILE_PATH)));
        infScreening.setEstado(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.STATUS)));
        infScreening.setStart(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.START)));
        infScreening.setEnd(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.END)));
        infScreening.setSimserial(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        infScreening.setPhonenumber(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        infScreening.setDeviceid(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.TODAY))>0) infScreening.setToday(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.TODAY))));
        return infScreening;
    }
}
