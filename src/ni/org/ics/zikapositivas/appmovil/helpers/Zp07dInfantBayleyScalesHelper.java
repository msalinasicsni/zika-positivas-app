package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.zikapositivas.appmovil.domain.Zp07dInfantBayleyScales;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.utils.Zp07dDBConstants;


import java.util.Date;

/**
 * Created by ics on 22/6/2017.
 */
public class Zp07dInfantBayleyScalesHelper {

    public static ContentValues crearZp07dInfantBayleyScales(Zp07dInfantBayleyScales zp07dInfantBayleyScales){
        ContentValues cv = new ContentValues();
        cv.put(Zp07dDBConstants.recordId, zp07dInfantBayleyScales.getRecordId());
        cv.put(Zp07dDBConstants.redcapEventName, zp07dInfantBayleyScales.getRedcapEventName());
        if (zp07dInfantBayleyScales.getInfantVisitdt()!=null) cv.put(Zp07dDBConstants.infantVisitdt, zp07dInfantBayleyScales.getInfantVisitdt().getTime());
        cv.put(Zp07dDBConstants.infantDone, zp07dInfantBayleyScales.getInfantDone());
        cv.put(Zp07dDBConstants.infantReaNot, zp07dInfantBayleyScales.getInfantReaNot());
        cv.put(Zp07dDBConstants.infantNreaOther, zp07dInfantBayleyScales.getInfantNreaOther());
        if (zp07dInfantBayleyScales.getInfantPerfdt()!=null) cv.put(Zp07dDBConstants.infantPerfdt, zp07dInfantBayleyScales.getInfantPerfdt().getTime());
        cv.put(Zp07dDBConstants.infantEnglish, zp07dInfantBayleyScales.getInfantEnglish());
        cv.put(Zp07dDBConstants.infantPrilanguage, zp07dInfantBayleyScales.getInfantPrilanguage());
        cv.put(Zp07dDBConstants.infantParentlan, zp07dInfantBayleyScales.getInfantParentlan());
        cv.put(Zp07dDBConstants.infantBayenglish, zp07dInfantBayleyScales.getInfantBayenglish());
        cv.put(Zp07dDBConstants.infantMed, zp07dInfantBayleyScales.getInfantMed());
        cv.put(Zp07dDBConstants.infantMedDay, zp07dInfantBayleyScales.getInfantMedDay());
        cv.put(Zp07dDBConstants.infantTypMed, zp07dInfantBayleyScales.getInfantTypMed());
        cv.put(Zp07dDBConstants.infantCoguAttem, zp07dInfantBayleyScales.getInfantCoguAttem());
        cv.put(Zp07dDBConstants.infantCograScore, zp07dInfantBayleyScales.getInfantCograScore());
        cv.put(Zp07dDBConstants.infantCogscScore, zp07dInfantBayleyScales.getInfantCogscScore());
        cv.put(Zp07dDBConstants.infantCogcoScore, zp07dInfantBayleyScales.getInfantCogcoScore());
        cv.put(Zp07dDBConstants.infantCogValid, zp07dInfantBayleyScales.getInfantCogValid());
        cv.put(Zp07dDBConstants.infantReaInvali, zp07dInfantBayleyScales.getInfantReaInvali());
        cv.put(Zp07dDBConstants.infantInvaOther, zp07dInfantBayleyScales.getInfantInvaOther());
        cv.put(Zp07dDBConstants.infantResAtte, zp07dInfantBayleyScales.getInfantResAtte());
        cv.put(Zp07dDBConstants.infantRetoScore, zp07dInfantBayleyScales.getInfantRetoScore());
        cv.put(Zp07dDBConstants.infantRescScore, zp07dInfantBayleyScales.getInfantRescScore());
        cv.put(Zp07dDBConstants.infantExsuAtte, zp07dInfantBayleyScales.getInfantExsuAtte());
        cv.put(Zp07dDBConstants.infantExtoScore, zp07dInfantBayleyScales.getInfantExtoScore());
        cv.put(Zp07dDBConstants.infantExscScore, zp07dInfantBayleyScales.getInfantExscScore());
        cv.put(Zp07dDBConstants.infantSuScore, zp07dInfantBayleyScales.getInfantSuScore());
        cv.put(Zp07dDBConstants.infantSucomScore, zp07dInfantBayleyScales.getInfantSucomScore());
        cv.put(Zp07dDBConstants.infantLangValid, zp07dInfantBayleyScales.getInfantLangValid());
        cv.put(Zp07dDBConstants.infantRelanInvalid, zp07dInfantBayleyScales.getInfantRelanInvalid());
        cv.put(Zp07dDBConstants.infantRelanOther, zp07dInfantBayleyScales.getInfantRelanOther());
        cv.put(Zp07dDBConstants.infantFmsAtte, zp07dInfantBayleyScales.getInfantFmsAtte());
        cv.put(Zp07dDBConstants.infantFmtoScore, zp07dInfantBayleyScales.getInfantFmtoScore());
        cv.put(Zp07dDBConstants.infantFmscScore, zp07dInfantBayleyScales.getInfantFmscScore());
        cv.put(Zp07dDBConstants.infantGmsuattm, zp07dInfantBayleyScales.getInfantGmsuattm());
        cv.put(Zp07dDBConstants.infantGmtoScore, zp07dInfantBayleyScales.getInfantGmtoScore());
        cv.put(Zp07dDBConstants.infantGmscScore, zp07dInfantBayleyScales.getInfantGmscScore());
        cv.put(Zp07dDBConstants.infantMssuScore, zp07dInfantBayleyScales.getInfantMssuScore());
        cv.put(Zp07dDBConstants.infantMscoscore, zp07dInfantBayleyScales.getInfantMscoscore());
        cv.put(Zp07dDBConstants.infantMtValid, zp07dInfantBayleyScales.getInfantMtValid());
        cv.put(Zp07dDBConstants.infantMtInvalid, zp07dInfantBayleyScales.getInfantMtInvalid());
        cv.put(Zp07dDBConstants.infantMtinvOther, zp07dInfantBayleyScales.getInfantMtinvOther());
        cv.put(Zp07dDBConstants.infantSesAtte, zp07dInfantBayleyScales.getInfantSesAtte());
        cv.put(Zp07dDBConstants.infantSetoSore, zp07dInfantBayleyScales.getInfantSetoSore());
        cv.put(Zp07dDBConstants.infantSescScre, zp07dInfantBayleyScales.getInfantSescScre());
        cv.put(Zp07dDBConstants.infantSecoScre, zp07dInfantBayleyScales.getInfantSecoScre());
        cv.put(Zp07dDBConstants.infantSemoValid, zp07dInfantBayleyScales.getInfantSemoValid());
        cv.put(Zp07dDBConstants.infantSemoInvalid, zp07dInfantBayleyScales.getInfantSemoInvalid());
        cv.put(Zp07dDBConstants.infantSemoinvOther, zp07dInfantBayleyScales.getInfantSemoinvOther());
        cv.put(Zp07dDBConstants.infantCog76, zp07dInfantBayleyScales.getInfantCog76());
        cv.put(Zp07dDBConstants.infantCircuEvalu, zp07dInfantBayleyScales.getInfantCircuEvalu());
        cv.put(Zp07dDBConstants.infantExplain, zp07dInfantBayleyScales.getInfantExplain());
        cv.put(Zp07dDBConstants.infantBaidCom, zp07dInfantBayleyScales.getInfantBaidCom());
        if (zp07dInfantBayleyScales.getInfantBadtCom()!=null) cv.put(Zp07dDBConstants.infantBadtCom, zp07dInfantBayleyScales.getInfantBadtCom().getTime());
        cv.put(Zp07dDBConstants.infantBaeyeIdRevi, zp07dInfantBayleyScales.getInfantBaeyeIdRevi());
        if (zp07dInfantBayleyScales.getInfantBadtRevi()!=null) cv.put(Zp07dDBConstants.infantBadtRevi, zp07dInfantBayleyScales.getInfantBadtRevi().getTime());
        cv.put(Zp07dDBConstants.infantBaidEntry, zp07dInfantBayleyScales.getInfantBaidEntry());
        if (zp07dInfantBayleyScales.getInfantBadtEnt()!=null) cv.put(Zp07dDBConstants.infantBadtEnt, zp07dInfantBayleyScales.getInfantBadtEnt().getTime());


        if (zp07dInfantBayleyScales.getRecordDate() != null) cv.put(MainDBConstants.recordDate, zp07dInfantBayleyScales.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, zp07dInfantBayleyScales.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(zp07dInfantBayleyScales.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, zp07dInfantBayleyScales.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, zp07dInfantBayleyScales.getInstancePath());
        cv.put(MainDBConstants.STATUS, zp07dInfantBayleyScales.getEstado());
        cv.put(MainDBConstants.START, zp07dInfantBayleyScales.getStart());
        cv.put(MainDBConstants.END, zp07dInfantBayleyScales.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, zp07dInfantBayleyScales.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, zp07dInfantBayleyScales.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, zp07dInfantBayleyScales.getPhonenumber());
        if (zp07dInfantBayleyScales.getToday() != null) cv.put(MainDBConstants.TODAY, zp07dInfantBayleyScales.getToday().getTime());
        return cv;
    }

    public static Zp07dInfantBayleyScales crearZp07dInfantBayleyScales(Cursor cursorIA){
        Zp07dInfantBayleyScales dInfantBayleySc = new Zp07dInfantBayleyScales();
        dInfantBayleySc.setRecordId(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.recordId)));
        dInfantBayleySc.setRedcapEventName(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.redcapEventName)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantVisitdt))>0) dInfantBayleySc.setInfantVisitdt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantVisitdt))));
        dInfantBayleySc.setInfantDone(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantDone)));
        dInfantBayleySc.setInfantReaNot(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantReaNot)));
        dInfantBayleySc.setInfantNreaOther(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantNreaOther)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantPerfdt))>0) dInfantBayleySc.setInfantPerfdt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantPerfdt))));
        dInfantBayleySc.setInfantEnglish(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantEnglish)));
        dInfantBayleySc.setInfantPrilanguage(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantPrilanguage)));
        dInfantBayleySc.setInfantParentlan(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantParentlan)));
        dInfantBayleySc.setInfantBayenglish(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantBayenglish)));
        dInfantBayleySc.setInfantMed(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantMed)));
        dInfantBayleySc.setInfantMedDay(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantMedDay)));
        dInfantBayleySc.setInfantTypMed(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantTypMed)));
        dInfantBayleySc.setInfantCoguAttem(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantCoguAttem)));
        dInfantBayleySc.setInfantCograScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantCograScore)));
        dInfantBayleySc.setInfantCogscScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantCogscScore)));
        dInfantBayleySc.setInfantCogcoScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantCogcoScore)));
        dInfantBayleySc.setInfantCogValid(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantCogValid)));
        dInfantBayleySc.setInfantReaInvali(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantReaInvali)));
        dInfantBayleySc.setInfantInvaOther(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantInvaOther)));
        dInfantBayleySc.setInfantResAtte(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantResAtte)));
        dInfantBayleySc.setInfantRetoScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantRetoScore)));
        dInfantBayleySc.setInfantRescScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantRescScore)));
        dInfantBayleySc.setInfantExsuAtte(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantExsuAtte)));
        dInfantBayleySc.setInfantExtoScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantExtoScore)));
        dInfantBayleySc.setInfantExscScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantExscScore)));
        dInfantBayleySc.setInfantSuScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSuScore)));
        dInfantBayleySc.setInfantSucomScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSucomScore)));
        dInfantBayleySc.setInfantLangValid(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantLangValid)));
        dInfantBayleySc.setInfantRelanInvalid(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantRelanInvalid)));
        dInfantBayleySc.setInfantRelanOther(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantRelanOther)));
        dInfantBayleySc.setInfantFmsAtte(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantFmsAtte)));
        dInfantBayleySc.setInfantFmtoScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantFmtoScore)));
        dInfantBayleySc.setInfantFmscScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantFmscScore)));
        dInfantBayleySc.setInfantGmsuattm(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantGmsuattm)));
        dInfantBayleySc.setInfantGmtoScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantGmtoScore)));
        dInfantBayleySc.setInfantGmscScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantGmscScore)));
        dInfantBayleySc.setInfantMssuScore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantMssuScore)));
        dInfantBayleySc.setInfantMscoscore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantMscoscore)));
        dInfantBayleySc.setInfantMtValid(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantMtValid)));
        dInfantBayleySc.setInfantMtInvalid(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantMtInvalid)));
        dInfantBayleySc.setInfantMtinvOther(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantMtinvOther)));
        dInfantBayleySc.setInfantSesAtte(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSesAtte)));
        dInfantBayleySc.setInfantSetoSore(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSetoSore)));
        dInfantBayleySc.setInfantSescScre(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSescScre)));
        dInfantBayleySc.setInfantSecoScre(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSecoScre)));
        dInfantBayleySc.setInfantSemoValid(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSemoValid)));
        dInfantBayleySc.setInfantSemoInvalid(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSemoInvalid)));
        dInfantBayleySc.setInfantSemoinvOther(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantSemoinvOther)));
        dInfantBayleySc.setInfantCog76(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantCog76)));
        dInfantBayleySc.setInfantCircuEvalu(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantCircuEvalu)));
        dInfantBayleySc.setInfantExplain(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantExplain)));
        dInfantBayleySc.setInfantBaidCom(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantBaidCom)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantBadtCom))>0) dInfantBayleySc.setInfantBadtCom(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantBadtCom))));
        dInfantBayleySc.setInfantBaeyeIdRevi(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantBaeyeIdRevi)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantBadtRevi))>0) dInfantBayleySc.setInfantBadtRevi(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantBadtRevi))));
        dInfantBayleySc.setInfantBaidEntry(cursorIA.getString(cursorIA.getColumnIndex(Zp07dDBConstants.infantBaidEntry)));
        if (cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantBadtEnt))>0) dInfantBayleySc.setInfantBadtEnt(new Date(cursorIA.getLong(cursorIA.getColumnIndex(Zp07dDBConstants.infantBadtEnt))));


        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))>0) dInfantBayleySc.setRecordDate(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.recordDate))));
        dInfantBayleySc.setRecordUser(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.recordUser)));
        dInfantBayleySc.setPasive(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        dInfantBayleySc.setIdInstancia(cursorIA.getInt(cursorIA.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        dInfantBayleySc.setInstancePath(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.FILE_PATH)));
        dInfantBayleySc.setEstado(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.STATUS)));
        dInfantBayleySc.setStart(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.START)));
        dInfantBayleySc.setEnd(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.END)));
        dInfantBayleySc.setSimserial(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        dInfantBayleySc.setPhonenumber(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        dInfantBayleySc.setDeviceid(cursorIA.getString(cursorIA.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))>0) dInfantBayleySc.setToday(new Date(cursorIA.getLong(cursorIA.getColumnIndex(MainDBConstants.TODAY))));

        return dInfantBayleySc;
    }
}
