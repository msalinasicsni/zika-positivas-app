package ni.org.ics.zikapositivas.appmovil.helpers;

import android.content.ContentValues;
import android.database.Cursor;
import ni.org.ics.zikapositivas.appmovil.domain.Zp05UltrasoundExam;
import ni.org.ics.zikapositivas.appmovil.utils.MainDBConstants;
import ni.org.ics.zikapositivas.appmovil.utils.Zp05DBConstants;

import java.util.Date;

/**
 * Created by FIRSTICT on 10/25/2016.
 * V1.0
 */
public class Zp05UltrasoundExamHelper {

    public static ContentValues crearZp05UltrasoundExam(Zp05UltrasoundExam ultrasoundExam){
        ContentValues cv = new ContentValues();

        cv.put(Zp05DBConstants.recordId, ultrasoundExam.getRecordId());
        cv.put(Zp05DBConstants.redcapEventName, ultrasoundExam.getRedcapEventName());
        if (ultrasoundExam.getUltDate()!=null) cv.put(Zp05DBConstants.ultDate, ultrasoundExam.getUltDate().getTime());
        cv.put(Zp05DBConstants.ultGaWeeks, ultrasoundExam.getUltGaWeeks());
        cv.put(Zp05DBConstants.ultGaDays, ultrasoundExam.getUltGaDays());
        cv.put(Zp05DBConstants.ultGeDetermined, ultrasoundExam.getUltGeDetermined());
        cv.put(Zp05DBConstants.ultReason, ultrasoundExam.getUltReason());
        cv.put(Zp05DBConstants.ultReasonOther, ultrasoundExam.getUltReasonOther());
        cv.put(Zp05DBConstants.ultTime, ultrasoundExam.getUltTime());
        cv.put(Zp05DBConstants.ultNameFacility, ultrasoundExam.getUltNameFacility());
        cv.put(Zp05DBConstants.ultFacilityid, ultrasoundExam.getUltFacilityid());
        cv.put(Zp05DBConstants.ultIdSonographer, ultrasoundExam.getUltIdSonographer());
        cv.put(Zp05DBConstants.ultIdNa, ultrasoundExam.getUltIdNa());
        cv.put(Zp05DBConstants.ultFestiGaWeeks1, ultrasoundExam.getUltFestiGaWeeks1());
        cv.put(Zp05DBConstants.ultFestiGaDays1, ultrasoundExam.getUltFestiGaDays1());
        if (ultrasoundExam.getUltFestiDelivery1()!=null) cv.put(Zp05DBConstants.ultFestiDelivery1, ultrasoundExam.getUltFestiDelivery1().getTime());
        cv.put(Zp05DBConstants.ultFirstYesno1, ultrasoundExam.getUltFirstYesno1());
        cv.put(Zp05DBConstants.ultFabnormal1, ultrasoundExam.getUltFabnormal1());
        cv.put(Zp05DBConstants.ultFyesSpecify1, ultrasoundExam.getUltFyesSpecify1()); //multiple
        cv.put(Zp05DBConstants.ultFotherFindings1, ultrasoundExam.getUltFotherFindings1());
        cv.put(Zp05DBConstants.ultFurtherTesting1, ultrasoundExam.getUltFurtherTesting1());
        cv.put(Zp05DBConstants.ultFnumFetuses, ultrasoundExam.getUltFnumFetuses());
        cv.put(Zp05DBConstants.ultFfetusViable1, ultrasoundExam.getUltFfetusViable1());
        cv.put(Zp05DBConstants.ultFfetalCardia1, ultrasoundExam.getUltFfetalCardia1());
        cv.put(Zp05DBConstants.ultFfetalHeart1, ultrasoundExam.getUltFfetalHeart1());
        cv.put(Zp05DBConstants.ultFcrl1, ultrasoundExam.getUltFcrl1());
        cv.put(Zp05DBConstants.ultFcrlNa1, ultrasoundExam.getUltFcrlNa1());
        cv.put(Zp05DBConstants.ultFfetusViable2, ultrasoundExam.getUltFfetusViable2());
        cv.put(Zp05DBConstants.ultFfetalCardia2, ultrasoundExam.getUltFfetalCardia2());
        cv.put(Zp05DBConstants.ultFfetalHeart2, ultrasoundExam.getUltFfetalHeart2());
        cv.put(Zp05DBConstants.ultFcrl2, ultrasoundExam.getUltFcrl2());
        cv.put(Zp05DBConstants.ultFcrlNa2, ultrasoundExam.getUltFcrlNa2());
        cv.put(Zp05DBConstants.ultFfetusViable3, ultrasoundExam.getUltFfetusViable3());
        cv.put(Zp05DBConstants.ultFfetalCardia3, ultrasoundExam.getUltFfetalCardia3());
        cv.put(Zp05DBConstants.ultFfetalHeart3, ultrasoundExam.getUltFfetalHeart3());
        cv.put(Zp05DBConstants.ultFcrl3, ultrasoundExam.getUltFcrl3());
        cv.put(Zp05DBConstants.ultFcrlNa3, ultrasoundExam.getUltFcrlNa3());
        cv.put(Zp05DBConstants.ultSfindings1, ultrasoundExam.getUltSfindings1());
        cv.put(Zp05DBConstants.ultSspecify1, ultrasoundExam.getUltSspecify1());//multiple
        cv.put(Zp05DBConstants.ultSfindingsSpecify1, ultrasoundExam.getUltSfindingsSpecify1());
        cv.put(Zp05DBConstants.ultFurtherExamination1, ultrasoundExam.getUltFurtherExamination1());
        cv.put(Zp05DBConstants.ultSplacental1, ultrasoundExam.getUltSplacental1());
        cv.put(Zp05DBConstants.ultSnumFetuses, ultrasoundExam.getUltSnumFetuses());
        cv.put(Zp05DBConstants.ultSfetusViable1, ultrasoundExam.getUltSfetusViable1());
        cv.put(Zp05DBConstants.ultSfetalCardia1, ultrasoundExam.getUltSfetalCardia1());
        cv.put(Zp05DBConstants.ultSfetalHeart1, ultrasoundExam.getUltSfetalHeart1());
        cv.put(Zp05DBConstants.ultSbiparietal1, ultrasoundExam.getUltSbiparietal1());
        cv.put(Zp05DBConstants.ultShead1, ultrasoundExam.getUltShead1());
        cv.put(Zp05DBConstants.ultMicroceph1, ultrasoundExam.getUltMicroceph1());
        cv.put(Zp05DBConstants.ultSevMicroceph1, ultrasoundExam.getUltSevMicroceph1());
        cv.put(Zp05DBConstants.ultSabdominal1, ultrasoundExam.getUltSabdominal1());
        cv.put(Zp05DBConstants.ultSfemur1, ultrasoundExam.getUltSfemur1());
        cv.put(Zp05DBConstants.ultSfetalWt1, ultrasoundExam.getUltSfetalWt1());
        cv.put(Zp05DBConstants.ultSpresentation1, ultrasoundExam.getUltSpresentation1());
        cv.put(Zp05DBConstants.ultSfetusViable2, ultrasoundExam.getUltSfetusViable2());
        cv.put(Zp05DBConstants.ultSfetalCardia2, ultrasoundExam.getUltSfetalCardia2());
        cv.put(Zp05DBConstants.ultSfetalHeart2, ultrasoundExam.getUltSfetalHeart2());
        cv.put(Zp05DBConstants.ultSbiparietal2, ultrasoundExam.getUltSbiparietal2());
        cv.put(Zp05DBConstants.ultShead2, ultrasoundExam.getUltShead2());
        cv.put(Zp05DBConstants.ultMicroceph2, ultrasoundExam.getUltMicroceph2());
        cv.put(Zp05DBConstants.ultSevMicroceph2, ultrasoundExam.getUltSevMicroceph2());
        cv.put(Zp05DBConstants.ultSabdominal2, ultrasoundExam.getUltSabdominal2());
        cv.put(Zp05DBConstants.ultSfemur2, ultrasoundExam.getUltSfemur2());
        cv.put(Zp05DBConstants.ultSfetalWt2, ultrasoundExam.getUltSfetalWt2());
        cv.put(Zp05DBConstants.ultSpresentation2, ultrasoundExam.getUltSpresentation2());
        cv.put(Zp05DBConstants.ultSfetusViable3, ultrasoundExam.getUltSfetusViable3());
        cv.put(Zp05DBConstants.ultSfetalCardia3, ultrasoundExam.getUltSfetalCardia3());
        cv.put(Zp05DBConstants.ultSfetalHeart3, ultrasoundExam.getUltSfetalHeart3());
        cv.put(Zp05DBConstants.ultSbiparietal3, ultrasoundExam.getUltSbiparietal3());
        cv.put(Zp05DBConstants.ultShead3, ultrasoundExam.getUltShead3());
        cv.put(Zp05DBConstants.ultMicroceph3, ultrasoundExam.getUltMicroceph3());
        cv.put(Zp05DBConstants.ultSevMicroceph3, ultrasoundExam.getUltSevMicroceph3());
        cv.put(Zp05DBConstants.ultSabdominal3, ultrasoundExam.getUltSabdominal3());
        cv.put(Zp05DBConstants.ultSfemur3, ultrasoundExam.getUltSfemur3());
        cv.put(Zp05DBConstants.ultSfetalWt3, ultrasoundExam.getUltSfetalWt3());
        cv.put(Zp05DBConstants.ultSpresentation3, ultrasoundExam.getUltSpresentation3());
        cv.put(Zp05DBConstants.ultIdCompleting, ultrasoundExam.getUltIdCompleting());
        if (ultrasoundExam.getUltDateCompleted()!=null) cv.put(Zp05DBConstants.ultDateCompleted, ultrasoundExam.getUltDateCompleted().getTime());
        cv.put(Zp05DBConstants.ultIdReviewer, ultrasoundExam.getUltIdReviewer());
        if (ultrasoundExam.getUltDateReviewed()!=null) cv.put(Zp05DBConstants.ultDateReviewed, ultrasoundExam.getUltDateReviewed().getTime());
        cv.put(Zp05DBConstants.ultIdDataEntry, ultrasoundExam.getUltIdDataEntry());
        if (ultrasoundExam.getUltDateEntered()!=null) cv.put(Zp05DBConstants.ultDateEntered, ultrasoundExam.getUltDateEntered().getTime());

        if (ultrasoundExam.getRecordDate() != null) cv.put(MainDBConstants.recordDate, ultrasoundExam.getRecordDate().getTime());
        cv.put(MainDBConstants.recordUser, ultrasoundExam.getRecordUser());
        cv.put(MainDBConstants.pasive, String.valueOf(ultrasoundExam.getPasive()));
        cv.put(MainDBConstants.ID_INSTANCIA, ultrasoundExam.getIdInstancia());
        cv.put(MainDBConstants.FILE_PATH, ultrasoundExam.getInstancePath());
        cv.put(MainDBConstants.STATUS, ultrasoundExam.getEstado());
        cv.put(MainDBConstants.START, ultrasoundExam.getStart());
        cv.put(MainDBConstants.END, ultrasoundExam.getEnd());
        cv.put(MainDBConstants.DEVICE_ID, ultrasoundExam.getDeviceid());
        cv.put(MainDBConstants.SIM_SERIAL, ultrasoundExam.getSimserial());
        cv.put(MainDBConstants.PHONE_NUMBER, ultrasoundExam.getPhonenumber());
        if (ultrasoundExam.getToday() != null) cv.put(MainDBConstants.TODAY, ultrasoundExam.getToday().getTime());

        return cv;
    }

    public static Zp05UltrasoundExam crearZp05UltrasoundExam(Cursor cursor){
        Zp05UltrasoundExam ultrasoundExam = new Zp05UltrasoundExam();

        ultrasoundExam.setRecordId(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.recordId)));
        ultrasoundExam.setRedcapEventName(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.redcapEventName)));
        if (cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDate))>0) ultrasoundExam.setUltDate(new Date(cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDate))));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultGaWeeks))>0) ultrasoundExam.setUltGaWeeks(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultGaWeeks)));
        ultrasoundExam.setUltGaDays(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultGaDays))); //permite 0
        ultrasoundExam.setUltGeDetermined(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultGeDetermined)));
        ultrasoundExam.setUltReason(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultReason)));
        ultrasoundExam.setUltReasonOther(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultReasonOther)));
        ultrasoundExam.setUltTime(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultTime)));
        ultrasoundExam.setUltNameFacility(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultNameFacility)));
        ultrasoundExam.setUltFacilityid(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFacilityid)));
        ultrasoundExam.setUltIdSonographer(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultIdSonographer)));
        ultrasoundExam.setUltIdNa(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultIdNa)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFestiGaWeeks1))>0) ultrasoundExam.setUltFestiGaWeeks1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFestiGaWeeks1)));
        ultrasoundExam.setUltFestiGaDays1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFestiGaDays1))); //permite 0
        if (cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultFestiDelivery1))>0) ultrasoundExam.setUltFestiDelivery1(new Date(cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultFestiDelivery1))));
        ultrasoundExam.setUltFirstYesno1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFirstYesno1)));
        ultrasoundExam.setUltFabnormal1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFabnormal1)));
        ultrasoundExam.setUltFyesSpecify1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFyesSpecify1))); //multiple
        ultrasoundExam.setUltFotherFindings1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFotherFindings1)));
        ultrasoundExam.setUltFurtherTesting1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFurtherTesting1)));
        ultrasoundExam.setUltFnumFetuses(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFnumFetuses))); //permite 0
        ultrasoundExam.setUltFfetusViable1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFfetusViable1)));
        ultrasoundExam.setUltFfetalCardia1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFfetalCardia1)));
        if (cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultFfetalHeart1))>0) ultrasoundExam.setUltFfetalHeart1(cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultFfetalHeart1)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFcrl1))>0) ultrasoundExam.setUltFcrl1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFcrl1)));
        ultrasoundExam.setUltFcrlNa1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFcrlNa1)));
        ultrasoundExam.setUltFfetusViable2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFfetusViable2)));
        ultrasoundExam.setUltFfetalCardia2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFfetalCardia2)));
        if (cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultFfetalHeart2))>0) ultrasoundExam.setUltFfetalHeart2(cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultFfetalHeart2)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFcrl2))>0) ultrasoundExam.setUltFcrl2(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFcrl2)));
        ultrasoundExam.setUltFcrlNa2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFcrlNa2)));
        ultrasoundExam.setUltFfetusViable3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFfetusViable3)));
        ultrasoundExam.setUltFfetalCardia3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFfetalCardia3)));
        if (cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultFfetalHeart3))>0) ultrasoundExam.setUltFfetalHeart3(cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultFfetalHeart3)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFcrl3))> 0)ultrasoundExam.setUltFcrl3(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultFcrl3)));
        ultrasoundExam.setUltFcrlNa3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFcrlNa3)));
        ultrasoundExam.setUltSfindings1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfindings1)));
        ultrasoundExam.setUltSspecify1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSspecify1)));//multiple
        ultrasoundExam.setUltSfindingsSpecify1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfindingsSpecify1)));
        ultrasoundExam.setUltFurtherExamination1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultFurtherExamination1)));
        ultrasoundExam.setUltSplacental1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSplacental1)));
        if(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSnumFetuses))>0)  ultrasoundExam.setUltSnumFetuses(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSnumFetuses)));
        ultrasoundExam.setUltSfetusViable1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfetusViable1)));
        ultrasoundExam.setUltSfetalCardia1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfetalCardia1)));
        if (cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultSfetalHeart1))>0) ultrasoundExam.setUltSfetalHeart1(cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultSfetalHeart1)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSbiparietal1))>0) ultrasoundExam.setUltSbiparietal1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSbiparietal1)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultShead1))>0) ultrasoundExam.setUltShead1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultShead1)));
        ultrasoundExam.setUltMicroceph1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultMicroceph1)));
        ultrasoundExam.setUltSevMicroceph1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSevMicroceph1)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSabdominal1))>0) ultrasoundExam.setUltSabdominal1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSabdominal1)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfemur1))>0) ultrasoundExam.setUltSfemur1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfemur1)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfetalWt1))>0) ultrasoundExam.setUltSfetalWt1(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfetalWt1)));
        ultrasoundExam.setUltSpresentation1(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSpresentation1)));
        ultrasoundExam.setUltSfetusViable2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfetusViable2)));
        ultrasoundExam.setUltSfetalCardia2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfetalCardia2)));
        if (cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultSfetalHeart2))>0) ultrasoundExam.setUltSfetalHeart2(cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultSfetalHeart2)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSbiparietal2))>0) ultrasoundExam.setUltSbiparietal2(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSbiparietal2)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultShead2))>0) ultrasoundExam.setUltShead2(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultShead2)));
        ultrasoundExam.setUltMicroceph2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultMicroceph2)));
        ultrasoundExam.setUltSevMicroceph2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSevMicroceph2)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSabdominal2))>0) ultrasoundExam.setUltSabdominal2(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSabdominal2)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfemur2))>0) ultrasoundExam.setUltSfemur2(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfemur2)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfetalWt2))>0) ultrasoundExam.setUltSfetalWt2(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfetalWt2)));
        ultrasoundExam.setUltSpresentation2(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSpresentation2)));
        ultrasoundExam.setUltSfetusViable3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfetusViable3)));
        ultrasoundExam.setUltSfetalCardia3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSfetalCardia3)));
        if (cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultSfetalHeart3))>0) ultrasoundExam.setUltSfetalHeart3(cursor.getFloat(cursor.getColumnIndex(Zp05DBConstants.ultSfetalHeart3)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSbiparietal3))>0) ultrasoundExam.setUltSbiparietal3(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSbiparietal3)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultShead3))>0) ultrasoundExam.setUltShead3(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultShead3)));
        ultrasoundExam.setUltMicroceph3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultMicroceph3)));
        ultrasoundExam.setUltSevMicroceph3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSevMicroceph3)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSabdominal3))>0) ultrasoundExam.setUltSabdominal3(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSabdominal3)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfemur3))>0) ultrasoundExam.setUltSfemur3(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfemur3)));
        if (cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfetalWt3))>0) ultrasoundExam.setUltSfetalWt3(cursor.getInt(cursor.getColumnIndex(Zp05DBConstants.ultSfetalWt3)));
        ultrasoundExam.setUltSpresentation3(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultSpresentation3)));
        ultrasoundExam.setUltIdCompleting(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultIdCompleting)));
        if (cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDateCompleted))>0) ultrasoundExam.setUltDateCompleted(new Date(cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDateCompleted))));
        ultrasoundExam.setUltIdReviewer(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultIdReviewer)));
        if (cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDateReviewed))>0) ultrasoundExam.setUltDateReviewed(new Date(cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDateReviewed))));
        ultrasoundExam.setUltIdDataEntry(cursor.getString(cursor.getColumnIndex(Zp05DBConstants.ultIdDataEntry)));
        if (cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDateEntered))>0) ultrasoundExam.setUltDateEntered(new Date(cursor.getLong(cursor.getColumnIndex(Zp05DBConstants.ultDateEntered))));

        if(cursor.getLong(cursor.getColumnIndex(MainDBConstants.recordDate))>0) ultrasoundExam.setRecordDate(new Date(cursor.getLong(cursor.getColumnIndex(MainDBConstants.recordDate))));
        ultrasoundExam.setRecordUser(cursor.getString(cursor.getColumnIndex(MainDBConstants.recordUser)));
        ultrasoundExam.setPasive(cursor.getString(cursor.getColumnIndex(MainDBConstants.pasive)).charAt(0));
        ultrasoundExam.setIdInstancia(cursor.getInt(cursor.getColumnIndex(MainDBConstants.ID_INSTANCIA)));
        ultrasoundExam.setInstancePath(cursor.getString(cursor.getColumnIndex(MainDBConstants.FILE_PATH)));
        ultrasoundExam.setEstado(cursor.getString(cursor.getColumnIndex(MainDBConstants.STATUS)));
        ultrasoundExam.setStart(cursor.getString(cursor.getColumnIndex(MainDBConstants.START)));
        ultrasoundExam.setEnd(cursor.getString(cursor.getColumnIndex(MainDBConstants.END)));
        ultrasoundExam.setSimserial(cursor.getString(cursor.getColumnIndex(MainDBConstants.SIM_SERIAL)));
        ultrasoundExam.setPhonenumber(cursor.getString(cursor.getColumnIndex(MainDBConstants.PHONE_NUMBER)));
        ultrasoundExam.setDeviceid(cursor.getString(cursor.getColumnIndex(MainDBConstants.DEVICE_ID)));
        if(cursor.getLong(cursor.getColumnIndex(MainDBConstants.TODAY))>0) ultrasoundExam.setToday(new Date(cursor.getLong(cursor.getColumnIndex(MainDBConstants.TODAY))));

        return ultrasoundExam;
    }
}
