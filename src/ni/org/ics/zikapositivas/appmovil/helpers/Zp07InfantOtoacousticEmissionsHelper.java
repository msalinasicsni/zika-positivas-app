package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.zikapositivas.appmovil.domain.Zp07InfantOtoacousticEmissions;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.utils.Zp07OtoEDBConstants;

import java.util.Date;

/**
 * Created by ics on 2/2/2018.
 * V1.0
 */
public class Zp07InfantOtoacousticEmissionsHelper {

    public static ContentValues crearZp07InfantOtoacousticEmissions(Zp07InfantOtoacousticEmissions zp07InfantOtoEms){
        ContentValues cv = new ContentValues();
        cv.put(Zp07OtoEDBConstants.recordId, zp07InfantOtoEms.getRecordId());
        cv.put(Zp07OtoEDBConstants.redcapEventName, zp07InfantOtoEms.getRedcapEventName());
        if (zp07InfantOtoEms.getInfantVisitDate()!=null) cv.put(Zp07OtoEDBConstants.infantVisitDate, zp07InfantOtoEms.getInfantVisitDate().getTime());
        cv.put(Zp07OtoEDBConstants.infantStatus, zp07InfantOtoEms.getInfantStatus());
        cv.put(Zp07OtoEDBConstants.infantVisit, zp07InfantOtoEms.getInfantVisit());
        cv.put(Zp07OtoEDBConstants.infantAgeMonths, zp07InfantOtoEms.getInfantAgeMonths());
        cv.put(Zp07OtoEDBConstants.infantOae, zp07InfantOtoEms.getInfantOae());
        cv.put(Zp07OtoEDBConstants.infantOphthType, zp07InfantOtoEms.getInfantOphthType());
        cv.put(Zp07OtoEDBConstants.infantHearingOverall, zp07InfantOtoEms.getInfantHearingOverall());
        cv.put(Zp07OtoEDBConstants.infantRoae, zp07InfantOtoEms.getInfantRoae());
        cv.put(Zp07OtoEDBConstants.infantRaabr, zp07InfantOtoEms.getInfantRaabr());
        cv.put(Zp07OtoEDBConstants.infantLoae, zp07InfantOtoEms.getInfantLoae());
        cv.put(Zp07OtoEDBConstants.infantLaabr, zp07InfantOtoEms.getInfantLaabr());
        cv.put(Zp07OtoEDBConstants.infantComments2, zp07InfantOtoEms.getInfantComments2());
        cv.put(Zp07OtoEDBConstants.infantIdCompleting, zp07InfantOtoEms.getInfantIdCompleting());
        if (zp07InfantOtoEms.getInfantDtComp()!=null) cv.put(Zp07OtoEDBConstants.infantDtComp, zp07InfantOtoEms.getInfantDtComp().getTime());
        cv.put(Zp07OtoEDBConstants.infantIdReviewer, zp07InfantOtoEms.getInfantIdReviewer());
        if (zp07InfantOtoEms.getInfantDtReview()!=null) cv.put(Zp07OtoEDBConstants.infantDtReview, zp07InfantOtoEms.getInfantDtReview().getTime());
        cv.put(Zp07OtoEDBConstants.infantIdDataEntry, zp07InfantOtoEms.getInfantIdDataEntry());
        if (zp07InfantOtoEms.getInfantDtEnter()!=null) cv.put(Zp07OtoEDBConstants.infantDtEnter, zp07InfantOtoEms.getInfantDtEnter().getTime());
        if (zp07InfantOtoEms.getRecordDate() != null) cv.put(MainDBConstants.recordDate, zp07InfantOtoEms.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, zp07InfantOtoEms.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(zp07InfantOtoEms.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, zp07InfantOtoEms.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, zp07InfantOtoEms.getInstancePath());
        cv.put(MainDBConstants.STATUS, zp07InfantOtoEms.getEstado());
        cv.put(MainDBConstants.START, zp07InfantOtoEms.getStart());
        cv.put(MainDBConstants.END, zp07InfantOtoEms.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, zp07InfantOtoEms.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, zp07InfantOtoEms.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, zp07InfantOtoEms.getPhonenumber());
        if (zp07InfantOtoEms.getToday() != null) cv.put(MainDBConstants.TODAY, zp07InfantOtoEms.getToday().getTime());
        return cv;
    }

    public static Zp07InfantOtoacousticEmissions crearZp07InfantOtoacousticEmissions(Cursor cursorIA){
        Zp07InfantOtoacousticEmissions infantOtoE = new Zp07InfantOtoacousticEmissions();
        infantOtoE.setRecordId(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.recordId)));
        infantOtoE.setRedcapEventName(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.redcapEventName)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantVisitDate))>0) infantOtoE.setInfantVisitDate(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantVisitDate))));
        infantOtoE.setInfantStatus(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantStatus)));
        infantOtoE.setInfantVisit(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantVisit)));
        if (cursorIA.getInt(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantAgeMonths))>0) infantOtoE.setInfantAgeMonths(cursorIA.getInt(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantAgeMonths)));
        infantOtoE.setInfantOae(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantOae)));
        infantOtoE.setInfantOphthType(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantOphthType)));
        infantOtoE.setInfantHearingOverall(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantHearingOverall)));
        infantOtoE.setInfantRoae(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantRoae)));
        infantOtoE.setInfantRaabr(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantRaabr)));
        infantOtoE.setInfantLoae(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantLoae)));
        infantOtoE.setInfantLaabr(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantLaabr)));
        infantOtoE.setInfantComments2(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantComments2)));

        infantOtoE.setInfantIdCompleting(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantIdCompleting)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantDtComp))>0) infantOtoE.setInfantDtComp(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantDtComp))));
        infantOtoE.setInfantIdReviewer(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantIdReviewer)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantDtReview))>0) infantOtoE.setInfantDtReview(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantDtReview))));
        infantOtoE.setInfantIdDataEntry(cursorIA.getString(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantIdDataEntry)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantDtEnter))>0) infantOtoE.setInfantDtEnter(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07OtoEDBConstants.infantDtEnter))));

        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))>0) infantOtoE.setRecordDate(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))));
        infantOtoE.setRecordUser(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.recordUser)));
        infantOtoE.setPasive(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        infantOtoE.setIdInstancia(cursorIA.getInt(cursorIA.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        infantOtoE.setInstancePath(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.FILE_PATH)));
        infantOtoE.setEstado(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.STATUS)));
        infantOtoE.setStart(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.START)));
        infantOtoE.setEnd(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.END)));
        infantOtoE.setSimserial(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        infantOtoE.setPhonenumber(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        infantOtoE.setDeviceid(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))>0) infantOtoE.setToday(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))));

        return infantOtoE;
    }

}
