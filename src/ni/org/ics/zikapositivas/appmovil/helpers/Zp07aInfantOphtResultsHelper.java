package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.zikapositivas.appmovil.domain.Zp07aInfantOphtResults;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.utils.Zp07aDBConstants;

import java.util.Date;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07aInfantOphtResultsHelper {

    public static ContentValues crearZp07AInfantOpthResults(Zp07aInfantOphtResults zp07AInfantOphtResults){
        ContentValues cv = new ContentValues();
        cv.put(Zp07aDBConstants.recordId, zp07AInfantOphtResults.getRecordId());
        cv.put(Zp07aDBConstants.redcapEventName, zp07AInfantOphtResults.getRedcapEventName());
        if (zp07AInfantOphtResults.getInfantOphthDt()!=null) cv.put(Zp07aDBConstants.infantOphthDt, zp07AInfantOphtResults.getInfantOphthDt().getTime());

        cv.put(Zp07aDBConstants.infantOphType, zp07AInfantOphtResults.getInfantOphType());
        cv.put(Zp07aDBConstants.infantEyeCalci, zp07AInfantOphtResults.getInfantEyeCalci());
        cv.put(Zp07aDBConstants.infantChoriore, zp07AInfantOphtResults.getInfantChoriore());
        cv.put(Zp07aDBConstants.infantFocalPm, zp07AInfantOphtResults.getInfantFocalPm());
        cv.put(Zp07aDBConstants.infantChorioreAtro, zp07AInfantOphtResults.getInfantChorioreAtro());
        cv.put(Zp07aDBConstants.infantMicroph, zp07AInfantOphtResults.getInfantMicroph());
        cv.put(Zp07aDBConstants.infantMicrocornea, zp07AInfantOphtResults.getInfantMicrocornea());
        cv.put(Zp07aDBConstants.infantIrisColobo, zp07AInfantOphtResults.getInfantIrisColobo());
        cv.put(Zp07aDBConstants.infantOpticNerve, zp07AInfantOphtResults.getInfantOpticNerve());
        cv.put(Zp07aDBConstants.infantSubLuxated, zp07AInfantOphtResults.getInfantSubLuxated());
        cv.put(Zp07aDBConstants.infantStrabismus, zp07AInfantOphtResults.getInfantStrabismus());
        cv.put(Zp07aDBConstants.infantEyeOther, zp07AInfantOphtResults.getInfantEyeOther());
        cv.put(Zp07aDBConstants.infantEyeOtherSpecify, zp07AInfantOphtResults.getInfantEyeOtherSpecify());
        cv.put(Zp07aDBConstants.infantReferralOphth, zp07AInfantOphtResults.getInfantReferralOphth());

        cv.put(Zp07aDBConstants.infantEyeFile, zp07AInfantOphtResults.getInfantEyeFile());

        cv.put(Zp07aDBConstants.infantEyeCom, zp07AInfantOphtResults.getInfantEyeCom());
        cv.put(Zp07aDBConstants.infantEyComdetail, zp07AInfantOphtResults.getInfantEyComdetail());
        cv.put(Zp07aDBConstants.infantEyidCom, zp07AInfantOphtResults.getInfantEyidCom());

        if (zp07AInfantOphtResults.getInfantEydtCom() !=null) cv.put(Zp07aDBConstants.infantEydtCom, zp07AInfantOphtResults.getInfantEydtCom().getTime());
        cv.put(Zp07aDBConstants.infantEyidRevi, zp07AInfantOphtResults.getInfantEyidRevi());
        if (zp07AInfantOphtResults.getInfantEydtRevi()!=null) cv.put(Zp07aDBConstants.infantEydtRevi, zp07AInfantOphtResults.getInfantEydtRevi().getTime());
        cv.put(Zp07aDBConstants.infantEyidEntry, zp07AInfantOphtResults.getInfantEyidEntry());
        if (zp07AInfantOphtResults.getInfantEydtEnt()!=null) cv.put(Zp07aDBConstants.infantEydtEnt, zp07AInfantOphtResults.getInfantEydtEnt().getTime());

        if (zp07AInfantOphtResults.getRecordDate() != null) cv.put(MainDBConstants.recordDate, zp07AInfantOphtResults.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, zp07AInfantOphtResults.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(zp07AInfantOphtResults.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, zp07AInfantOphtResults.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, zp07AInfantOphtResults.getInstancePath());
        cv.put(MainDBConstants.STATUS, zp07AInfantOphtResults.getEstado());
        cv.put(MainDBConstants.START, zp07AInfantOphtResults.getStart());
        cv.put(MainDBConstants.END, zp07AInfantOphtResults.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, zp07AInfantOphtResults.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, zp07AInfantOphtResults.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, zp07AInfantOphtResults.getPhonenumber());
        if (zp07AInfantOphtResults.getToday() != null) cv.put(MainDBConstants.TODAY, zp07AInfantOphtResults.getToday().getTime());
        return cv;
    }

    public static Zp07aInfantOphtResults crearZp07AInfantOphtResults(Cursor cursorIA){
        Zp07aInfantOphtResults aInfantOphtResult = new Zp07aInfantOphtResults();
        aInfantOphtResult.setRecordId(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.recordId)));
        aInfantOphtResult.setRedcapEventName(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.redcapEventName)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantOphthDt))>0) aInfantOphtResult.setInfantOphthDt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantOphthDt))));
        aInfantOphtResult.setInfantOphType(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantOphType)));
        aInfantOphtResult.setInfantEyeCalci(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyeCalci)));
        aInfantOphtResult.setInfantChoriore(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantChoriore)));
        aInfantOphtResult.setInfantFocalPm(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantFocalPm)));
        aInfantOphtResult.setInfantChorioreAtro(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantChorioreAtro)));
        aInfantOphtResult.setInfantMicroph(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantMicroph)));
        aInfantOphtResult.setInfantMicrocornea(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantMicrocornea)));
        aInfantOphtResult.setInfantIrisColobo(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantIrisColobo)));
        aInfantOphtResult.setInfantOpticNerve(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantOpticNerve)));
        aInfantOphtResult.setInfantSubLuxated(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantSubLuxated)));
        aInfantOphtResult.setInfantStrabismus(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantStrabismus)));
        aInfantOphtResult.setInfantEyeOther(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyeOther)));
        aInfantOphtResult.setInfantEyeOtherSpecify(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyeOtherSpecify)));
        aInfantOphtResult.setInfantReferralOphth(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantReferralOphth)));

        aInfantOphtResult.setInfantEyeFile(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyeFile)));

        aInfantOphtResult.setInfantEyeCom(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyeCom)));
        aInfantOphtResult.setInfantEyComdetail(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyComdetail)));
        aInfantOphtResult.setInfantEyidCom(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyidCom)));

        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantEydtCom))>0) aInfantOphtResult.setInfantEydtCom(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantEydtCom))));
        aInfantOphtResult.setInfantEyidRevi(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyidRevi)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantEydtRevi))>0) aInfantOphtResult.setInfantEydtRevi(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantEydtRevi))));
        aInfantOphtResult.setInfantEyidEntry(cursorIA.getString(cursorIA.getColumnIndex(Zp07aDBConstants.infantEyidEntry)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantEydtEnt))>0) aInfantOphtResult.setInfantEydtEnt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07aDBConstants.infantEydtEnt))));

        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))>0) aInfantOphtResult.setRecordDate(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))));
        aInfantOphtResult.setRecordUser(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.recordUser)));
        aInfantOphtResult.setPasive(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        aInfantOphtResult.setIdInstancia(cursorIA.getInt(cursorIA.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        aInfantOphtResult.setInstancePath(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.FILE_PATH)));
        aInfantOphtResult.setEstado(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.STATUS)));
        aInfantOphtResult.setStart(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.START)));
        aInfantOphtResult.setEnd(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.END)));
        aInfantOphtResult.setSimserial(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        aInfantOphtResult.setPhonenumber(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        aInfantOphtResult.setDeviceid(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))>0) aInfantOphtResult.setToday(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))));

        return aInfantOphtResult;
    }
}
