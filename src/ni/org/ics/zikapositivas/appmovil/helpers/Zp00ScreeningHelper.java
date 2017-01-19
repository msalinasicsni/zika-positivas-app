package ni.org.ics.zikapositivas.appmovil.helpers;

import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.domain.Zp00Screening;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;

import android.content.ContentValues;
import android.database.Cursor;

public class Zp00ScreeningHelper {
	
	public static ContentValues crearZp00ScreeningValues(Zp00Screening screening){
		ContentValues cv = new ContentValues();
		cv.put(MainDBConstants.recordId, screening.getRecordId());
		cv.put(MainDBConstants.preScreenId, screening.getPreScreenId());
		cv.put(MainDBConstants.redcapEventName, screening.getRedcapEventName());
		if (screening.getScrVisitDate() != null) cv.put(MainDBConstants.scrVisitDate, screening.getScrVisitDate().getTime());
		cv.put(MainDBConstants.scrVerbalConsent, screening.getScrVerbalConsent());
		cv.put(MainDBConstants.scrRemain, screening.getScrRemain());
		cv.put(MainDBConstants.scrAge, screening.getScrAge());
		cv.put(MainDBConstants.scrAge15, screening.getScrAge15());
		cv.put(MainDBConstants.scrPregnant, screening.getScrPregnant());
		cv.put(MainDBConstants.scrPreWeeks, screening.getScrPreWeeks());
		cv.put(MainDBConstants.scrPreDays, screening.getScrPreDays());
		cv.put(MainDBConstants.scrPregant13, screening.getScrPregant13());
		cv.put(MainDBConstants.scrZikaOther, screening.getScrZikaOther());
		cv.put(MainDBConstants.scrMeetCriteria, screening.getScrMeetCriteria());
		cv.put(MainDBConstants.scrConsentObta, screening.getScrConsentObta());
		cv.put(MainDBConstants.scrObDobDay, screening.getScrObDobDay());
		cv.put(MainDBConstants.scrObDobMon, screening.getScrObDobMon());
		cv.put(MainDBConstants.scrObDobYear, screening.getScrObDobYear());
        cv.put(MainDBConstants.scrObAge, screening.getScrObAge());
		cv.put(MainDBConstants.scrObAssent, screening.getScrObAssent());
		cv.put(MainDBConstants.scrConsentA, screening.getScrConsentA());
		cv.put(MainDBConstants.scrConsentB, screening.getScrConsentB());
		cv.put(MainDBConstants.scrConsentC, screening.getScrConsentC());
		cv.put(MainDBConstants.scrConsentD, screening.getScrConsentD());
		cv.put(MainDBConstants.scrConsentE, screening.getScrConsentE());
		cv.put(MainDBConstants.scrConsentF, screening.getScrConsentF());
		cv.put(MainDBConstants.scrPreviousZikaPos, screening.getScrPreviousZikaPos());
		cv.put(MainDBConstants.scrPreviousStudyId, screening.getScrPreviousStudyId());
		cv.put(MainDBConstants.scrPreStudyNa, screening.getScrPreStudyNa());
		cv.put(MainDBConstants.scrReasonNot, screening.getScrReasonNot());
		cv.put(MainDBConstants.scrReasonOther, screening.getScrReasonOther());
		cv.put(MainDBConstants.scrIdCompleting, screening.getScrIdCompleting());
		if (screening.getScrDateCompleted() != null) cv.put(MainDBConstants.scrDateCompleted, screening.getScrDateCompleted().getTime());
		cv.put(MainDBConstants.scrIdReviewer, screening.getScrIdReviewer());
		if (screening.getScrDateReviewed() != null) cv.put(MainDBConstants.scrDateReviewed, screening.getScrDateReviewed().getTime());
		cv.put(MainDBConstants.scrIdDataEntry, screening.getScrIdDataEntry());
		if (screening.getScrDateEntered() != null) cv.put(MainDBConstants.scrDateEntered, screening.getScrDateEntered().getTime());
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
	
	public static Zp00Screening crearZp00Screening(Cursor cursorScreening){		
		Zp00Screening mScreening = new Zp00Screening();
		mScreening.setRecordId(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.recordId)));
		mScreening.setPreScreenId(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.preScreenId)));
		mScreening.setRedcapEventName(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.redcapEventName)));
		if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrVisitDate))>0) mScreening.setScrVisitDate(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrVisitDate))));
		mScreening.setScrVerbalConsent(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrVerbalConsent)));
		mScreening.setScrRemain(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrRemain)));
		if (cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrAge))>0) mScreening.setScrAge(cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrAge)));
		mScreening.setScrAge15(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrAge15)));
		mScreening.setScrPregnant(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrPregnant)));
		if (cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrPreWeeks))>0) mScreening.setScrPreWeeks(cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrPreWeeks)));
		mScreening.setScrPreDays(cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrPreDays))); //permite 0
		mScreening.setScrPregant13(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrPregant13)));
		mScreening.setScrZikaOther(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrZikaOther)));
		mScreening.setScrMeetCriteria(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrMeetCriteria)));
		mScreening.setScrConsentObta(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrConsentObta)));
		mScreening.setScrObDobDay(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrObDobDay)));
		mScreening.setScrObDobMon(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrObDobMon)));
		mScreening.setScrObDobYear(cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrObDobYear)));
		if (cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrObAge))>0) mScreening.setScrObAge(cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.scrObAge)));
		mScreening.setScrObAssent(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrObAssent)));
		mScreening.setScrConsentA(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrConsentA)));
		mScreening.setScrConsentB(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrConsentB)));
		mScreening.setScrConsentC(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrConsentC)));
		mScreening.setScrConsentD(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrConsentD)));
		mScreening.setScrConsentE(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrConsentE)));
		mScreening.setScrConsentF(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrConsentF)));
		mScreening.setScrPreviousZikaPos(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrPreviousZikaPos)));
		mScreening.setScrPreviousStudyId(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrPreviousStudyId)));
		mScreening.setScrPreStudyNa(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrPreStudyNa)));
		mScreening.setScrReasonNot(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrReasonNot)));
		mScreening.setScrReasonOther(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrReasonOther)));
		mScreening.setScrIdCompleting(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrIdCompleting)));
		if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrDateCompleted))>0) mScreening.setScrDateCompleted(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrDateCompleted))));
		mScreening.setScrIdReviewer(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrIdReviewer)));
		if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrDateReviewed))>0) mScreening.setScrDateReviewed(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrDateReviewed))));
		mScreening.setScrIdDataEntry(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.scrIdDataEntry)));
		if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrDateEntered))>0) mScreening.setScrDateEntered(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.scrDateEntered))));
		if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.recordDate))>0) mScreening.setRecordDate(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.recordDate))));
		mScreening.setRecordUser(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.recordUser)));
		mScreening.setPasive(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.pasive)).charAt(0));
		mScreening.setIdInstancia(cursorScreening.getInt(cursorScreening.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
		mScreening.setInstancePath(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.FILE_PATH)));
		mScreening.setEstado(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.STATUS)));
		mScreening.setStart(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.START)));
		mScreening.setEnd(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.END)));
		mScreening.setSimserial(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.SIM_SERIAL)));
		mScreening.setPhonenumber(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
		mScreening.setDeviceid(cursorScreening.getString(cursorScreening.getColumnIndex(MainDBConstants.DEVICE_ID)));
		if(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.TODAY))>0) mScreening.setToday(new Date(cursorScreening.getLong(cursorScreening.getColumnIndex(MainDBConstants.TODAY))));
		return mScreening;
	}
}
