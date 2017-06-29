package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.zikapositivas.appmovil.domain.Zp07cInfantImageStudies;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.utils.Zp07cDBConstants;

import java.util.Date;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07cInfantImageStudiesHelper {

    public static ContentValues crearZp07cInfantImageStudies(Zp07cInfantImageStudies zp07cInfantImageStudies){
        ContentValues cv = new ContentValues();
        cv.put(Zp07cDBConstants.recordId, zp07cInfantImageStudies.getRecordId());
        cv.put(Zp07cDBConstants.redcapEventName, zp07cInfantImageStudies.getRedcapEventName());
        if (zp07cInfantImageStudies.getInfantImageDt()!=null) cv.put(Zp07cDBConstants.infantImageDt, zp07cInfantImageStudies.getInfantImageDt().getTime());
        cv.put(Zp07cDBConstants.infantHeadAltra, zp07cInfantImageStudies.getInfantHeadAltra());
        cv.put(Zp07cDBConstants.infantUltraObtained, zp07cInfantImageStudies.getInfantUltraObtained());
        if (zp07cInfantImageStudies.getInfantUltraDt()!=null) cv.put(Zp07cDBConstants.infantUltraDt, zp07cInfantImageStudies.getInfantUltraDt().getTime());
        cv.put(Zp07cDBConstants.infantResultsSpecify, zp07cInfantImageStudies.getInfantResultsSpecify());
        cv.put(Zp07cDBConstants.infantUltraOther, zp07cInfantImageStudies.getInfantUltraOther());
        cv.put(Zp07cDBConstants.infantUltraFile, zp07cInfantImageStudies.getInfantUltraFile());
        cv.put(Zp07cDBConstants.infantHeadCt, zp07cInfantImageStudies.getInfantHeadCt());
        cv.put(Zp07cDBConstants.infantCtObtained, zp07cInfantImageStudies.getInfantCtObtained());
        if (zp07cInfantImageStudies.getInfantCtDt()!=null) cv.put(Zp07cDBConstants.infantCtDt, zp07cInfantImageStudies.getInfantCtDt().getTime());
        cv.put(Zp07cDBConstants.infantCtspecify, zp07cInfantImageStudies.getInfantCtspecify());
        cv.put(Zp07cDBConstants.infantCtotherSpecify, zp07cInfantImageStudies.getInfantCtotherSpecify());
        cv.put(Zp07cDBConstants.infantCtFile, zp07cInfantImageStudies.getInfantCtFile());
        cv.put(Zp07cDBConstants.infantCerebrospinal, zp07cInfantImageStudies.getInfantCerebrospinal());
        cv.put(Zp07cDBConstants.infantCerebroStored, zp07cInfantImageStudies.getInfantCerebroStored());
        if (zp07cInfantImageStudies.getInfantCerebroDt()!=null) cv.put(Zp07cDBConstants.infantCerebroDt, zp07cInfantImageStudies.getInfantCerebroDt().getTime());
        cv.put(Zp07cDBConstants.infantCerebroAmount, zp07cInfantImageStudies.getInfantCerebroAmount());
        cv.put(Zp07cDBConstants.infantResultsCerebro, zp07cInfantImageStudies.getInfantResultsCerebro());
        cv.put(Zp07cDBConstants.infantCerebroSpecify, zp07cInfantImageStudies.getInfantCerebroSpecify());
        cv.put(Zp07cDBConstants.infantMri, zp07cInfantImageStudies.getInfantMri());
        cv.put(Zp07cDBConstants.infantMriObtained, zp07cInfantImageStudies.getInfantMriObtained());
        if (zp07cInfantImageStudies.getInfantMriDt()!=null) cv.put(Zp07cDBConstants.infantMriDt, zp07cInfantImageStudies.getInfantMriDt().getTime());
        cv.put(Zp07cDBConstants.infantMriSpecify, zp07cInfantImageStudies.getInfantMriSpecify());
        cv.put(Zp07cDBConstants.infantMriotherSpecify, zp07cInfantImageStudies.getInfantMriotherSpecify());
        cv.put(Zp07cDBConstants.infantMriFile, zp07cInfantImageStudies.getInfantMriFile());
        cv.put(Zp07cDBConstants.infantIgcom, zp07cInfantImageStudies.getInfantIgcom());
        cv.put(Zp07cDBConstants.infantIgcomDetail, zp07cInfantImageStudies.getInfantIgcomDetail());
        cv.put(Zp07cDBConstants.infantIgidCom, zp07cInfantImageStudies.getInfantIgidCom());
        if (zp07cInfantImageStudies.getInfantIgdtCom()!=null) cv.put(Zp07cDBConstants.infantIgdtCom, zp07cInfantImageStudies.getInfantIgdtCom().getTime());
        cv.put(Zp07cDBConstants.infantIgeyeIdRevi, zp07cInfantImageStudies.getInfantIgeyeIdRevi());
        if (zp07cInfantImageStudies.getInfantIgdtRevi()!=null) cv.put(Zp07cDBConstants.infantIgdtRevi, zp07cInfantImageStudies.getInfantIgdtRevi().getTime());
        cv.put(Zp07cDBConstants.infantIgidEntry, zp07cInfantImageStudies.getInfantIgidEntry());
        if (zp07cInfantImageStudies.getInfantIgdateEnt()!=null) cv.put(Zp07cDBConstants.infantIgdateEnt, zp07cInfantImageStudies.getInfantIgdateEnt().getTime());


        if (zp07cInfantImageStudies.getRecordDate() != null) cv.put(MainDBConstants.recordDate, zp07cInfantImageStudies.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, zp07cInfantImageStudies.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(zp07cInfantImageStudies.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, zp07cInfantImageStudies.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, zp07cInfantImageStudies.getInstancePath());
        cv.put(MainDBConstants.STATUS, zp07cInfantImageStudies.getEstado());
        cv.put(MainDBConstants.START, zp07cInfantImageStudies.getStart());
        cv.put(MainDBConstants.END, zp07cInfantImageStudies.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, zp07cInfantImageStudies.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, zp07cInfantImageStudies.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, zp07cInfantImageStudies.getPhonenumber());
        if (zp07cInfantImageStudies.getToday() != null) cv.put(MainDBConstants.TODAY, zp07cInfantImageStudies.getToday().getTime());
        return cv;
    }

    public static Zp07cInfantImageStudies crearZp07cInfantImageStudies(Cursor cursorIA){
        Zp07cInfantImageStudies cInfantImageSt = new Zp07cInfantImageStudies();
        cInfantImageSt.setRecordId(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.recordId)));
        cInfantImageSt.setRedcapEventName(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.redcapEventName)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantImageDt))>0) cInfantImageSt.setInfantImageDt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantImageDt))));
        cInfantImageSt.setInfantHeadAltra(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantHeadAltra)));
        cInfantImageSt.setInfantUltraObtained(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantUltraObtained)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantUltraDt))>0) cInfantImageSt.setInfantUltraDt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantUltraDt))));
        cInfantImageSt.setInfantResultsSpecify(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantResultsSpecify)));
        cInfantImageSt.setInfantUltraOther(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantUltraOther)));
        cInfantImageSt.setInfantUltraFile(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantUltraFile)));
        cInfantImageSt.setInfantHeadCt(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantHeadCt)));
        cInfantImageSt.setInfantCtObtained(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantCtObtained)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantCtDt))>0) cInfantImageSt.setInfantCtDt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantCtDt))));
        cInfantImageSt.setInfantCtspecify(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantCtspecify)));
        cInfantImageSt.setInfantCtotherSpecify(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantCtotherSpecify)));
        cInfantImageSt.setInfantCtFile(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantCtFile)));
        cInfantImageSt.setInfantCerebrospinal(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantCerebrospinal)));
        cInfantImageSt.setInfantCerebroStored(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantCerebroStored)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantCerebroDt))>0) cInfantImageSt.setInfantCerebroDt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantCerebroDt))));
        if (cursorIA.getFloat(cursorIA.getColumnIndex(Zp07cDBConstants.infantCerebroAmount))>0) cInfantImageSt.setInfantCerebroAmount(cursorIA.getFloat(cursorIA.getColumnIndex(Zp07cDBConstants.infantCerebroAmount)));
        cInfantImageSt.setInfantResultsCerebro(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantResultsCerebro)));
        cInfantImageSt.setInfantCerebroSpecify(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantCerebroSpecify)));
        cInfantImageSt.setInfantMri(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantMri)));
        cInfantImageSt.setInfantMriObtained(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantMriObtained)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantMriDt))>0) cInfantImageSt.setInfantMriDt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantMriDt))));
        cInfantImageSt.setInfantMriSpecify(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantMriSpecify)));
        cInfantImageSt.setInfantMriotherSpecify(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantMriotherSpecify)));
        cInfantImageSt.setInfantMriFile(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantMriFile)));
        cInfantImageSt.setInfantIgcom(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgcom)));
        cInfantImageSt.setInfantIgcomDetail(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgcomDetail)));
        cInfantImageSt.setInfantIgidCom(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgidCom)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgdtCom))>0) cInfantImageSt.setInfantIgdtCom(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgdtCom))));
        cInfantImageSt.setInfantIgeyeIdRevi(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgeyeIdRevi)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgdtRevi))>0) cInfantImageSt.setInfantIgdtRevi(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgdtRevi))));
        cInfantImageSt.setInfantIgidEntry(cursorIA.getString(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgidEntry)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgdateEnt))>0) cInfantImageSt.setInfantIgdateEnt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07cDBConstants.infantIgdateEnt))));


        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))>0) cInfantImageSt.setRecordDate(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))));
        cInfantImageSt.setRecordUser(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.recordUser)));
        cInfantImageSt.setPasive(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        cInfantImageSt.setIdInstancia(cursorIA.getInt(cursorIA.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        cInfantImageSt.setInstancePath(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.FILE_PATH)));
        cInfantImageSt.setEstado(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.STATUS)));
        cInfantImageSt.setStart(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.START)));
        cInfantImageSt.setEnd(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.END)));
        cInfantImageSt.setSimserial(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        cInfantImageSt.setPhonenumber(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        cInfantImageSt.setDeviceid(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))>0) cInfantImageSt.setToday(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))));

        return cInfantImageSt;
    }
}
