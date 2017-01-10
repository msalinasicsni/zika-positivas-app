package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.zikapositivas.appmovil.domain.Zp08StudyExit;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.utils.Zp08DBConstants;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/25/2016.
 * V1.0
 */
public class Zp08StudyExitHelper {

    public static ContentValues crearZp08StudyExit(Zp08StudyExit studyExit){
        ContentValues cv = new ContentValues();

        cv.put(Zp08DBConstants.recordId, studyExit.getRecordId());
        cv.put(Zp08DBConstants.redcapEventName, studyExit.getRedcapEventName());
        if (studyExit.getExtStudyExitDate()!=null) cv.put(Zp08DBConstants.extStudyExitDate, studyExit.getExtStudyExitDate().getTime());
        cv.put(Zp08DBConstants.extSubjClass, studyExit.getExtSubjClass());
        cv.put(Zp08DBConstants.extStudyExitReason, studyExit.getExtStudyExitReason());
        cv.put(Zp08DBConstants.extNonpregMatrnlDth, studyExit.getExtNonpregMatrnlDth());
        cv.put(Zp08DBConstants.extAcuteHealthSpec, studyExit.getExtAcuteHealthSpec());
        cv.put(Zp08DBConstants.extHealthCondSpec, studyExit.getExtHealthCondSpec());
        cv.put(Zp08DBConstants.extFatalInjSpec, studyExit.getExtFatalInjSpec());
        cv.put(Zp08DBConstants.extInfDeathTime, studyExit.getExtInfDeathTime());
        cv.put(Zp08DBConstants.extTestResultsRcvd, studyExit.getExtTestResultsRcvd());
        cv.put(Zp08DBConstants.extCounselingRcvd, studyExit.getExtCounselingRcvd());
        cv.put(Zp08DBConstants.extComments, studyExit.getExtComments());
        cv.put(Zp08DBConstants.extIdCompleting, studyExit.getExtIdCompleting());
        if (studyExit.getExtDateCompleted()!=null) cv.put(Zp08DBConstants.extDateCompleted, studyExit.getExtDateCompleted().getTime());
        cv.put(Zp08DBConstants.extIdReviewer, studyExit.getExtIdReviewer());
        if (studyExit.getExtDateReviewed()!=null) cv.put(Zp08DBConstants.extDateReviewed, studyExit.getExtDateReviewed().getTime());
        cv.put(Zp08DBConstants.extIdDataEntry, studyExit.getExtIdDataEntry());
        if (studyExit.getExtDateEntered()!=null) cv.put(Zp08DBConstants.extDateEntered, studyExit.getExtDateEntered().getTime());

        if (studyExit.getRecordDate() != null) cv.put(MainDBConstants.recordDate, studyExit.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, studyExit.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(studyExit.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, studyExit.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, studyExit.getInstancePath());
        cv.put(MainDBConstants.STATUS, studyExit.getEstado());
        cv.put(MainDBConstants.START, studyExit.getStart());
        cv.put(MainDBConstants.END, studyExit.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, studyExit.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, studyExit.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, studyExit.getPhonenumber());
        if (studyExit.getToday() != null) cv.put(MainDBConstants.TODAY, studyExit.getToday().getTime());

        return cv;
    }

    public static Zp08StudyExit crearZp08StudyExit(Cursor cursor){
        Zp08StudyExit studyExit = new Zp08StudyExit();

        studyExit.setRecordId(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.recordId)));
        studyExit.setRedcapEventName(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.redcapEventName)));
        if (cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extStudyExitDate))>0) studyExit.setExtStudyExitDate(new Date(cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extStudyExitDate))));
        studyExit.setExtSubjClass(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extSubjClass)));
        studyExit.setExtStudyExitReason(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extStudyExitReason)));
        studyExit.setExtNonpregMatrnlDth(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extNonpregMatrnlDth)));
        studyExit.setExtAcuteHealthSpec(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extAcuteHealthSpec)));
        studyExit.setExtHealthCondSpec(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extHealthCondSpec)));
        studyExit.setExtFatalInjSpec(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extFatalInjSpec)));
        studyExit.setExtInfDeathTime(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extInfDeathTime)));
        studyExit.setExtTestResultsRcvd(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extTestResultsRcvd)));
        studyExit.setExtCounselingRcvd(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extCounselingRcvd)));
        studyExit.setExtComments(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extComments)));
        studyExit.setExtIdCompleting(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extIdCompleting)));
        if (cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extDateCompleted))>0) studyExit.setExtDateCompleted(new Date(cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extDateCompleted))));
        studyExit.setExtIdReviewer(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extIdReviewer)));
        if (cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extDateReviewed))>0) studyExit.setExtDateReviewed(new Date(cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extDateReviewed))));
        studyExit.setExtIdDataEntry(cursor.getString(cursor.getColumnIndex(Zp08DBConstants.extIdDataEntry)));
        if (cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extDateEntered))>0) studyExit.setExtDateEntered(new Date(cursor.getLong(cursor.getColumnIndex(Zp08DBConstants.extDateEntered))));

        if(cursor.getLong(cursor.getColumnIndex(MainDBConstants.recordDate))>0) studyExit.setRecordDate(new Date(cursor.getLong(cursor.getColumnIndex(MainDBConstants.recordDate))));
        studyExit.setRecordUser(cursor.getString(cursor.getColumnIndex(MainDBConstants.recordUser)));
        studyExit.setPasive(cursor.getString(cursor.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        studyExit.setIdInstancia(cursor.getInt(cursor.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        studyExit.setInstancePath(cursor.getString(cursor.getColumnIndex(MainDBConstants.FILE_PATH)));
        studyExit.setEstado(cursor.getString(cursor.getColumnIndex(MainDBConstants.STATUS)));
        studyExit.setStart(cursor.getString(cursor.getColumnIndex(MainDBConstants.START)));
        studyExit.setEnd(cursor.getString(cursor.getColumnIndex(MainDBConstants.END)));
        studyExit.setSimserial(cursor.getString(cursor.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        studyExit.setPhonenumber(cursor.getString(cursor.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        studyExit.setDeviceid(cursor.getString(cursor.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursor.getLong(cursor.getColumnIndex(MainDBConstants.TODAY))>0) studyExit.setToday(new Date(cursor.getLong(cursor.getColumnIndex(MainDBConstants.TODAY))));

        return studyExit;
    }
}
