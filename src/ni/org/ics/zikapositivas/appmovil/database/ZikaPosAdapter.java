package ni.org.ics.zikapositivas.appmovil.database;

/**
 * Adaptador de la base de datos Cohorte
 *
 * @author William Aviles
 */

import java.util.ArrayList;
import java.util.List;

import ni.org.ics.zikapositivas.appmovil.domain.*;
import ni.org.ics.zikapositivas.appmovil.domain.users.Authority;
import ni.org.ics.zikapositivas.appmovil.domain.users.UserSistema;
import ni.org.ics.zikapositivas.appmovil.helpers.*;
import ni.org.ics.zikapositivas.appmovil.utils.*;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteQueryBuilder;

public class ZikaPosAdapter {

    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;
    private final Context mContext;
    private final String mPassword;
    private final boolean mFromServer;
    private final boolean mCleanDb;


    public ZikaPosAdapter(Context context, String password, boolean fromServer, boolean cleanDb) {
        mContext = context;
        mPassword = password;
        mFromServer = fromServer;
        mCleanDb = cleanDb;
    }

    private static class DatabaseHelper extends ZikaPosSQLiteOpenHelper {

        DatabaseHelper(Context context, String password, boolean fromServer, boolean cleanDb) {
            super(FileUtils.DATABASE_PATH, MainDBConstants.DATABASE_NAME, MainDBConstants.DATABASE_VERSION, context,
                    password, fromServer, cleanDb);
            createStorage();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(MainDBConstants.CREATE_USER_TABLE);
            db.execSQL(MainDBConstants.CREATE_ROLE_TABLE);
            db.execSQL(MainDBConstants.CREATE_SCREENING_TABLE);
            db.execSQL(MainDBConstants.CREATE_STATUS_PREG_TABLE);
            db.execSQL(MainDBConstants.CREATE_DATA_PREG_TABLE);
            db.execSQL(MainDBConstants.CREATE_DATA_PRESCREEN_TABLE);
            db.execSQL(Zp01DBConstants.CREATE_STUDYENTRY_AD_TABLE);
            db.execSQL(Zp01DBConstants.CREATE_STUDYENTRY_E_TABLE);
            db.execSQL(Zp01DBConstants.CREATE_STUDYENTRY_FK_TABLE);
            db.execSQL(Zp02DBConstants.CREATE_BIOCOLLECTION_TABLE);
            db.execSQL(Zp03DBConstants.CREATE_MONTHLYVISIT_TABLE);
            db.execSQL(Zp04DBConstants.CREATE_TRIMESTERVISIT_AD_TABLE);
            db.execSQL(Zp04DBConstants.CREATE_TRIMESTERVISIT_E_TABLE);
            db.execSQL(Zp04DBConstants.CREATE_TRIMESTERVISIT_FH_TABLE);
            db.execSQL(Zp05DBConstants.CREATE_ULTRASOUNDEXAM_TABLE);
            db.execSQL(Zp06DBConstants.CREATE_DELIVERY6WVISIT_TABLE);
            db.execSQL(Zp08DBConstants.CREATE_STUDYEXIT_TABLE);
            db.execSQL(MainDBConstants.CREATE_DATA_CONSSAL_TABLE);
            db.execSQL(MainDBConstants.CREATE_DATA_CONSREC_TABLE);
            db.execSQL(MainDBConstants.CREATE_DATA_USSAL_TABLE);
            db.execSQL(MainDBConstants.CREATE_DATA_USREC_TABLE);
            db.execSQL(Zp02DBConstants.CREATE_INFANTBIOCOLLECTION_TABLE);
            db.execSQL(Zp07DBConstants.CREATE_INFANTASSESSMENT_TABLE);
            db.execSQL(MainDBConstants.CREATE_INFANTDATA_TABLE);
            db.execSQL(MainDBConstants.CREATE_INFANTSTATUS_TABLE);
            db.execSQL(Zp07aDBConstants.CREATE_AINFANT_OPHTRESULTS_TABLE);
            db.execSQL(Zp07bDBConstants.CREATE_BINFANT_AUDIORESULTS_TABLE);
            db.execSQL(Zp07cDBConstants.CREATE_CINFANT_IMAGESTUDIES_TABLE);
            db.execSQL(Zp07dDBConstants.CREATE_DINFANT_BAYLEYSCALES_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onCreate(db);
            if(oldVersion==0) return;
            if(oldVersion==1){
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtChronicDiseases + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtChronicDiseases1 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtChronicDiseases2 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtChronicDiseases3 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtMedicines + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtDrugsType + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsType1 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsBrand1 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsType2 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsBrand2 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsType3 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsBrand3 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsType4 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsBrand4 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsType5 + " text");
                db.execSQL("ALTER TABLE " + Zp01DBConstants.STUDYENTRY_AD_TABLE + " ADD COLUMN " + Zp01DBConstants.seaAddtOthDrugsBrand5 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtMedicines + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtDrugsType + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsType1 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsBrand1 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsType2 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsBrand2 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsType3 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsBrand3 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsType4 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsBrand4 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsType5 + " text");
                db.execSQL("ALTER TABLE " + Zp03DBConstants.MONTHLYVISIT_TABLE + " ADD COLUMN " + Zp03DBConstants.monAddtOthDrugsBrand5 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtMedicines + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtDrugsType + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsType1 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsBrand1 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsType2 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsBrand2 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsType3 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsBrand3 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsType4 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsBrand4 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsType5 + " text");
                db.execSQL("ALTER TABLE " + Zp04DBConstants.TRIMESTERVISIT_AD_TABLE + " ADD COLUMN " + Zp04DBConstants.triAddtOthDrugsBrand5 + " text");
                db.execSQL("ALTER TABLE " + Zp02DBConstants.BIOCOLLECTION_TABLE + " ADD COLUMN " + Zp02DBConstants.addtAnemiaTest + " text");
                db.execSQL("ALTER TABLE " + Zp02DBConstants.BIOCOLLECTION_TABLE + " ADD COLUMN " + Zp02DBConstants.addtLastAnemiaTest + " date");
                db.execSQL("ALTER TABLE " + Zp02DBConstants.BIOCOLLECTION_TABLE + " ADD COLUMN " + Zp02DBConstants.addtLastAnemiaTestUk + " text");
                db.execSQL("ALTER TABLE " + Zp02DBConstants.BIOCOLLECTION_TABLE + " ADD COLUMN " + Zp02DBConstants.addtAnemiaTestAv + " text");
                db.execSQL("ALTER TABLE " + Zp02DBConstants.BIOCOLLECTION_TABLE + " ADD COLUMN " + Zp02DBConstants.addtHematocrit + " real");
                db.execSQL("ALTER TABLE " + Zp02DBConstants.BIOCOLLECTION_TABLE + " ADD COLUMN " + Zp02DBConstants.addtHemoglobin + " real");
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_USREC_TABLE);
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_USSAL_TABLE);
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_CONSSAL_TABLE);
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_CONSREC_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_USSAL_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_USREC_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_CONSSAL_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_CONSREC_TABLE);

            }
            if(oldVersion==2){
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_USREC_TABLE);
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_USSAL_TABLE);
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_CONSSAL_TABLE);
                db.execSQL("DROP TABLE " + MainDBConstants.DATA_CONSREC_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_USSAL_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_USREC_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_CONSSAL_TABLE);
                db.execSQL(MainDBConstants.CREATE_DATA_CONSREC_TABLE);
            }
            if(oldVersion==3){
				db.execSQL("DROP TABLE " + MainDBConstants.DATA_USREC_TABLE);
				db.execSQL("DROP TABLE " + MainDBConstants.DATA_USSAL_TABLE);
				db.execSQL("DROP TABLE " + MainDBConstants.DATA_CONSSAL_TABLE);
				db.execSQL("DROP TABLE " + MainDBConstants.DATA_CONSREC_TABLE);
	            db.execSQL(MainDBConstants.CREATE_DATA_USSAL_TABLE);
	            db.execSQL(MainDBConstants.CREATE_DATA_USREC_TABLE);
	            db.execSQL(MainDBConstants.CREATE_DATA_CONSSAL_TABLE);
	            db.execSQL(MainDBConstants.CREATE_DATA_CONSREC_TABLE);
	            db.execSQL(Zp02DBConstants.CREATE_INFANTBIOCOLLECTION_TABLE);
	            db.execSQL(Zp07DBConstants.CREATE_INFANTASSESSMENT_TABLE);
	            db.execSQL(MainDBConstants.CREATE_INFANTDATA_TABLE);
	            db.execSQL(MainDBConstants.CREATE_INFANTSTATUS_TABLE);
                db.execSQL(Zp07aDBConstants.CREATE_AINFANT_OPHTRESULTS_TABLE);
                db.execSQL(Zp07bDBConstants.CREATE_BINFANT_AUDIORESULTS_TABLE);
                db.execSQL(Zp07cDBConstants.CREATE_CINFANT_IMAGESTUDIES_TABLE);
                db.execSQL(Zp07dDBConstants.CREATE_DINFANT_BAYLEYSCALES_TABLE);
            }
        }
    }

    public ZikaPosAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mContext,mPassword,mFromServer,mCleanDb);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    /**
     * Crea un cursor desde la base de datos
     *
     * @return cursor
     */
    public Cursor crearCursor(String tabla, String whereString, String projection[], String ordenString) throws SQLException {
        Cursor c = null;
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(tabla);
        c = qb.query(mDb,projection,whereString,null,null,null,ordenString);
        return c;
    }

    public static boolean createStorage() {
        return FileUtils.createFolder(FileUtils.DATABASE_PATH);
    }

    /**
     * Metodos para usuarios en la base de datos
     *
     * @param user
     *            Objeto Usuario que contiene la informacion
     *
     */
    //Crear nuevo usuario en la base de datos
    public void crearUsuario(UserSistema user) {
        ContentValues cv = UserSistemaHelper.crearUserSistemaContentValues(user);
        mDb.insert(MainDBConstants.USER_TABLE, null, cv);
    }
    //Editar usuario existente en la base de datos
    public boolean editarUsuario(UserSistema user) {
        ContentValues cv = UserSistemaHelper.crearUserSistemaContentValues(user);
        return mDb.update(MainDBConstants.USER_TABLE, cv, MainDBConstants.username + "='"
                + user.getUsername()+"'", null) > 0;
    }
    //Limpiar la tabla de usuarios de la base de datos
    public boolean borrarUsuarios() {
        return mDb.delete(MainDBConstants.USER_TABLE, null, null) > 0;
    }
    //Obtener un usuario de la base de datos
    public UserSistema getUsuario(String filtro, String orden) throws SQLException {
        UserSistema mUser = null;
        Cursor cursorUser = crearCursor(MainDBConstants.USER_TABLE, filtro, null, orden);
        if (cursorUser != null && cursorUser.getCount() > 0) {
            cursorUser.moveToFirst();
            mUser=UserSistemaHelper.crearUserSistema(cursorUser);
        }
        if (!cursorUser.isClosed()) cursorUser.close();
        return mUser;
    }
    //Obtener una lista de usuarios de la base de datos
    public List<UserSistema> getUsuarios(String filtro, String orden) throws SQLException {
        List<UserSistema> mUsuarios = new ArrayList<UserSistema>();
        Cursor cursorUsuarios = crearCursor(MainDBConstants.USER_TABLE, filtro, null, orden);
        if (cursorUsuarios != null && cursorUsuarios.getCount() > 0) {
            cursorUsuarios.moveToFirst();
            mUsuarios.clear();
            do{
                UserSistema mUser = null;
                mUser = UserSistemaHelper.crearUserSistema(cursorUsuarios);
                mUsuarios.add(mUser);
            } while (cursorUsuarios.moveToNext());
        }
        if (!cursorUsuarios.isClosed()) cursorUsuarios.close();
        return mUsuarios;
    }

    /**
     * Metodos para roles en la base de datos
     *
     * @param rol
     *            Objeto Authority que contiene la informacion
     *
     */
    //Crear nuevo rol en la base de datos
    public void crearRol(Authority rol) {
        ContentValues cv = UserSistemaHelper.crearRolValues(rol);
        mDb.insert(MainDBConstants.ROLE_TABLE, null, cv);
    }
    //Limpiar la tabla de roles de la base de datos
    public boolean borrarRoles() {
        return mDb.delete(MainDBConstants.ROLE_TABLE, null, null) > 0;
    }
    //Verificar un rol de usuario
    public Boolean buscarRol(String username, String Rol) throws SQLException {
        Cursor c = mDb.query(true, MainDBConstants.ROLE_TABLE, null,
                MainDBConstants.username + "='" + username + "' and " + MainDBConstants.role + "='" + Rol + "'" , null, null, null, null, null);
        boolean result = c != null && c.getCount()>0;
        c.close();
        return result;
    }


    /**
     * Metodos para Zp00Screening en la base de datos
     *
     * @param screening
     *            Objeto Zp00Screening que contiene la informacion
     *
     */
    //Crear nuevo Zp00Screening en la base de datos
    public void crearZp00Screening(Zp00Screening screening) {
        ContentValues cv = Zp00ScreeningHelper.crearZp00ScreeningValues(screening);
        mDb.insert(MainDBConstants.SCREENING_TABLE, null, cv);
    }
    //Editar Zp00Screening existente en la base de datos
    public boolean editarZp00Screening(Zp00Screening screening) {
        ContentValues cv = Zp00ScreeningHelper.crearZp00ScreeningValues(screening);
        return mDb.update(MainDBConstants.SCREENING_TABLE, cv, MainDBConstants.recordId + "='"
                + screening.getRecordId()+"'", null) > 0;
    }
    //Limpiar la tabla de Zp00Screening de la base de datos
    public boolean borrarZp00Screening() {
        return mDb.delete(MainDBConstants.SCREENING_TABLE, null, null) > 0;
    }
    //Actualizar el estado la tabla de Zp00Screening de la base de datos
    public int actualizarEstadoZp00Screening(String filtro, String estado) {
        ContentValues cv = new ContentValues();
        cv.put(MainDBConstants.STATUS, estado);
        int numRegistros = mDb.update(MainDBConstants.SCREENING_TABLE, cv,filtro, null);
        return numRegistros;
    }
    //Obtener un Zp00Screening de la base de datos
    public Zp00Screening getZp00Screening(String filtro, String orden) throws SQLException {
        Zp00Screening mScreening = null;
        Cursor cursorScreening = crearCursor(MainDBConstants.SCREENING_TABLE, filtro, null, orden);
        if (cursorScreening != null && cursorScreening.getCount() > 0) {
            cursorScreening.moveToFirst();
            mScreening=Zp00ScreeningHelper.crearZp00Screening(cursorScreening);
        }
        if (!cursorScreening.isClosed()) cursorScreening.close();
        return mScreening;
    }
    //Obtener una lista de Zp00Screening de la base de datos
    public List<Zp00Screening> getZp00Screenings(String filtro, String orden) throws SQLException {
        List<Zp00Screening> mScreenings = new ArrayList<Zp00Screening>();
        Cursor cursorScreenings = crearCursor(MainDBConstants.SCREENING_TABLE, filtro, null, orden);
        if (cursorScreenings != null && cursorScreenings.getCount() > 0) {
            cursorScreenings.moveToFirst();
            mScreenings.clear();
            do{
                Zp00Screening mScreening = null;
                mScreening = Zp00ScreeningHelper.crearZp00Screening(cursorScreenings);
                mScreenings.add(mScreening);
            } while (cursorScreenings.moveToNext());
        }
        if (!cursorScreenings.isClosed()) cursorScreenings.close();
        return mScreenings;
    }

    /**
     * Metodos para ZpEstadoEmbarazada en la base de datos
     *
     * @param estado
     *            Objeto ZpEstadoEmbarazada que contiene la informacion
     *
     */
    //Crear nuevo ZpEstadoEmbarazada en la base de datos
    public void crearZpEstadoEmbarazada(ZpEstadoEmbarazada estado) {
        ContentValues cv = ZpEstadoEmbarazadaHelper.crearZpEstadoEmbarazadaValues(estado);
        mDb.insert(MainDBConstants.STATUS_PREG_TABLE, null, cv);
    }
    //Editar ZpEstadoEmbarazada existente en la base de datos
    public boolean editarZpEstadoEmbarazada(ZpEstadoEmbarazada estado) {
        ContentValues cv = ZpEstadoEmbarazadaHelper.crearZpEstadoEmbarazadaValues(estado);
        return mDb.update(MainDBConstants.STATUS_PREG_TABLE, cv, MainDBConstants.recordId + "='"
                + estado.getRecordId()+"'", null) > 0;
    }
    //Limpiar la tabla de ZpEstadoEmbarazada de la base de datos
    public boolean borrarZpEstadoEmbarazada() {
        return mDb.delete(MainDBConstants.STATUS_PREG_TABLE, null, null) > 0;
    }
    //Obtener un ZpEstadoEmbarazada de la base de datos
    public ZpEstadoEmbarazada getZpEstadoEmbarazada(String filtro, String orden) throws SQLException {
        ZpEstadoEmbarazada mEstado = null;
        Cursor cursorEstado = crearCursor(MainDBConstants.STATUS_PREG_TABLE, filtro, null, orden);
        if (cursorEstado != null && cursorEstado.getCount() > 0) {
            cursorEstado.moveToFirst();
            mEstado=ZpEstadoEmbarazadaHelper.crearZpEstadoEmbarazada(cursorEstado);
        }
        if (!cursorEstado.isClosed()) cursorEstado.close();
        return mEstado;
    }

    //Obtener una lista de ZpEstadoEmbarazada de la base de datos
    public List<ZpEstadoEmbarazada> getZpEstadoEmbarazadas(String filtro, String orden) throws SQLException {
        List<ZpEstadoEmbarazada> zpEstadoEmbarazadas = new ArrayList<ZpEstadoEmbarazada>();
        Cursor cursorStatus = crearCursor(MainDBConstants.STATUS_PREG_TABLE, filtro, null, orden);
        if (cursorStatus != null && cursorStatus.getCount() > 0) {
            cursorStatus.moveToFirst();
            zpEstadoEmbarazadas.clear();
            do{
                ZpEstadoEmbarazada estadoEmbarazada = null;
                estadoEmbarazada = ZpEstadoEmbarazadaHelper.crearZpEstadoEmbarazada(cursorStatus);
                zpEstadoEmbarazadas.add(estadoEmbarazada);
            } while (cursorStatus.moveToNext());
        }
        if (!cursorStatus.isClosed()) cursorStatus.close();
        return zpEstadoEmbarazadas;
    }


    /**
     * Metodos para ZpDatosEmbarazada en la base de datos
     *
     * @param datos
     *            Objeto ZpDatosEmbarazada que contiene la informacion
     *
     */
    //Crear nuevo ZpDatosEmbarazada en la base de datos
    public void crearZpDatosEmbarazada(ZpDatosEmbarazada datos) {
        ContentValues cv = ZpDatosEmbarazadaHelper.crearZpDatosEmbarazadaValues(datos);
        mDb.insert(MainDBConstants.DATA_PREG_TABLE, null, cv);
    }
    //Editar ZpDatosEmbarazada existente en la base de datos
    public boolean editarZpDatosEmbarazada(ZpDatosEmbarazada datos) {
        ContentValues cv = ZpDatosEmbarazadaHelper.crearZpDatosEmbarazadaValues(datos);
        return mDb.update(MainDBConstants.DATA_PREG_TABLE, cv, MainDBConstants.recordId + "='"
                + datos.getRecordId()+"'", null) > 0;
    }
    //Limpiar la tabla de ZpDatosEmbarazada de la base de datos
    public boolean borrarZpDatosEmbarazada() {
        return mDb.delete(MainDBConstants.DATA_PREG_TABLE, null, null) > 0;
    }
    //Obtener un ZpDatosEmbarazada de la base de datos
    public ZpDatosEmbarazada getZpDatosEmbarazada(String filtro, String orden) throws SQLException {
        ZpDatosEmbarazada mDatos = null;
        Cursor cursorDatos = crearCursor(MainDBConstants.DATA_PREG_TABLE, filtro, null, orden);
        if (cursorDatos != null && cursorDatos.getCount() > 0) {
            cursorDatos.moveToFirst();
            mDatos=ZpDatosEmbarazadaHelper.crearZpDatosEmbarazada(cursorDatos);
        }
        if (!cursorDatos.isClosed()) cursorDatos.close();
        return mDatos;
    }

    //Obtener una lista de ZpDatosEmbarazada de la base de datos
    public List<ZpDatosEmbarazada> getZpDatosEmbarazadas(String filtro, String orden) throws SQLException {
        List<ZpDatosEmbarazada> zpDatosEmbarazadas = new ArrayList<ZpDatosEmbarazada>();
        Cursor cursorStatus = crearCursor(MainDBConstants.DATA_PREG_TABLE, filtro, null, orden);
        if (cursorStatus != null && cursorStatus.getCount() > 0) {
            cursorStatus.moveToFirst();
            zpDatosEmbarazadas.clear();
            do{
                ZpDatosEmbarazada datosEmbarazada = null;
                datosEmbarazada = ZpDatosEmbarazadaHelper.crearZpDatosEmbarazada(cursorStatus);
                zpDatosEmbarazadas.add(datosEmbarazada);
            } while (cursorStatus.moveToNext());
        }
        if (!cursorStatus.isClosed()) cursorStatus.close();
        return zpDatosEmbarazadas;
    }


    /**
     * Metodos para ZpPreScreening en la base de datos
     *
     * @param datos
     *            Objeto ZpPreScreening que contiene la informacion
     *
     */
    //Crear nuevo ZpPreScreening en la base de datos
    public void crearZpPreScreening(ZpPreScreening datos) {
        ContentValues cv = ZpPreScreeningHelper.crearZpPreScreeningValues(datos);
        mDb.insert(MainDBConstants.DATA_PRESCREEN_TABLE, null, cv);
    }
    //Editar ZpPreScreening existente en la base de datos
    public boolean editarZpPreScreening(ZpPreScreening datos) {
        ContentValues cv = ZpPreScreeningHelper.crearZpPreScreeningValues(datos);
        return mDb.update(MainDBConstants.DATA_PRESCREEN_TABLE, cv, MainDBConstants.recId + "='"
                + datos.getRecId()+"'", null) > 0;
    }
    //Limpiar la tabla de ZpPreScreening de la base de datos
    public boolean borrarZpPreScreening() {
        return mDb.delete(MainDBConstants.DATA_PRESCREEN_TABLE, null, null) > 0;
    }
    //Obtener un ZpPreScreening de la base de datos
    public ZpPreScreening getZpPreScreening(String filtro, String orden) throws SQLException {
        ZpPreScreening mDatos = null;
        Cursor cursorDatos = crearCursor(MainDBConstants.DATA_PRESCREEN_TABLE, filtro, null, orden);
        if (cursorDatos != null && cursorDatos.getCount() > 0) {
            cursorDatos.moveToFirst();
            mDatos=ZpPreScreeningHelper.crearZpPreScreening(cursorDatos);
        }
        if (!cursorDatos.isClosed()) cursorDatos.close();
        return mDatos;
    }

    //Obtener last ZpPreScreening de la base de datos
    public Integer getLastZpPreScreening(String cs) throws SQLException {
        Integer lastConsecutive = null;
        Cursor c = null;
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(MainDBConstants.DATA_PRESCREEN_TABLE);
        c = qb.query(mDb,new String [] {"MAX(consecutive)"},"cs='"+cs+"'",null,null,null,null);
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            lastConsecutive=c.getInt(0);
        }
        if (!c.isClosed()) c.close();
        return lastConsecutive;
    }

    //Obtener una lista de ZpPreScreening de la base de datos
    public List<ZpPreScreening> getZpPreScreenings(String filtro, String orden) throws SQLException {
        List<ZpPreScreening> zpPreScreening = new ArrayList<ZpPreScreening>();
        Cursor cursorStatus = crearCursor(MainDBConstants.DATA_PRESCREEN_TABLE, filtro, null, orden);
        if (cursorStatus != null && cursorStatus.getCount() > 0) {
            cursorStatus.moveToFirst();
            zpPreScreening.clear();
            do{
                ZpPreScreening datosPreScreening = null;
                datosPreScreening = ZpPreScreeningHelper.crearZpPreScreening(cursorStatus);
                zpPreScreening.add(datosPreScreening);
            } while (cursorStatus.moveToNext());
        }
        if (!cursorStatus.isClosed()) cursorStatus.close();
        return zpPreScreening;
    }


    /**
     * Metodos para ZpControlConsentimientosSalida en la base de datos
     *
     * @param datos
     *            Objeto ZpControlConsentimientosSalida que contiene la informacion
     *
     */
    //Crear nuevo ZpControlConsentimientosSalida en la base de datos
    public void crearZpControlConsentimientosSalida(ZpControlConsentimientosSalida datos) {
        ContentValues cv = ZpControlConsentimientosSalidaHelper.crearZpControlConsentimientosSalida(datos);
        mDb.insert(MainDBConstants.DATA_CONSSAL_TABLE, null, cv);
    }
    //Editar ZpControlConsentimientosSalida existente en la base de datos
    public boolean editarZpControlConsentimientosSalida(ZpControlConsentimientosSalida datos) {
        ContentValues cv = ZpControlConsentimientosSalidaHelper.crearZpControlConsentimientosSalida(datos);
        return mDb.update(MainDBConstants.DATA_CONSSAL_TABLE, cv, MainDBConstants.codigo + "='" + datos.getCodigo() +"'", null) > 0;
    }
    //Limpiar la tabla de ZpControlConsentimientosSalida de la base de datos
    public boolean borrarZpControlConsentimientosSalida() {
        return mDb.delete(MainDBConstants.DATA_CONSSAL_TABLE, null, null) > 0;
    }
    //Obtener un ZpControlConsentimientosSalida de la base de datos
    public ZpControlConsentimientosSalida getZpControlConsentimientosSalida(String filtro, String orden) throws SQLException {
        ZpControlConsentimientosSalida mDatos = null;
        Cursor cursorDatos = crearCursor(MainDBConstants.DATA_CONSSAL_TABLE, filtro, null, orden);
        if (cursorDatos != null && cursorDatos.getCount() > 0) {
            cursorDatos.moveToFirst();
            mDatos=ZpControlConsentimientosSalidaHelper.crearZpControlConsentimientosSalida(cursorDatos);
        }
        if (!cursorDatos.isClosed()) cursorDatos.close();
        return mDatos;
    }
    //Obtener una lista de ZpControlConsentimientosSalida de la base de datos
    public List<ZpControlConsentimientosSalida> getZpControlConsentimientosSalidas(String filtro, String orden) throws SQLException {
        List<ZpControlConsentimientosSalida> zpControlConsentimientosSalida = new ArrayList<ZpControlConsentimientosSalida>();
        Cursor cursorStatus = crearCursor(MainDBConstants.DATA_CONSSAL_TABLE, filtro, null, orden);
        if (cursorStatus != null && cursorStatus.getCount() > 0) {
            cursorStatus.moveToFirst();
            zpControlConsentimientosSalida.clear();
            do{
                ZpControlConsentimientosSalida datosSalida = null;
                datosSalida = ZpControlConsentimientosSalidaHelper.crearZpControlConsentimientosSalida(cursorStatus);
                zpControlConsentimientosSalida.add(datosSalida);
            } while (cursorStatus.moveToNext());
        }
        if (!cursorStatus.isClosed()) cursorStatus.close();
        return zpControlConsentimientosSalida;
    }

    /**
     * Metodos para ZpControlConsentimientosRecepcion en la base de datos
     *
     * @param datos
     *            Objeto ZpControlConsentimientosRecepcion que contiene la informacion
     *
     */
    //Crear nuevo ZpControlConsentimientosRecepcion en la base de datos
    public void crearZpControlConsentimientosRecepcion(ZpControlConsentimientosRecepcion datos) {
        ContentValues cv = ZpControlConsentimientosRecepcionHelper.crearZpControlConsentimientosRecepcion(datos);
        mDb.insert(MainDBConstants.DATA_CONSREC_TABLE, null, cv);
    }
    //Editar ZpControlConsentimientosRecepcion existente en la base de datos
    public boolean editarZpControlConsentimientosRecepcion(ZpControlConsentimientosRecepcion datos) {
        ContentValues cv = ZpControlConsentimientosRecepcionHelper.crearZpControlConsentimientosRecepcion(datos);
        return mDb.update(MainDBConstants.DATA_CONSREC_TABLE, cv, MainDBConstants.codigo + "='" + datos.getCodigo() +"'", null) > 0;
    }
    //Limpiar la tabla de ZpControlConsentimientosRecepcion de la base de datos
    public boolean borrarZpControlConsentimientosRecepcion() {
        return mDb.delete(MainDBConstants.DATA_CONSREC_TABLE, null, null) > 0;
    }
    //Obtener un ZpControlConsentimientosRecepcion de la base de datos
    public ZpControlConsentimientosRecepcion getZpControlConsentimientosRecepcion(String filtro, String orden) throws SQLException {
        ZpControlConsentimientosRecepcion mDatos = null;
        Cursor cursorDatos = crearCursor(MainDBConstants.DATA_CONSREC_TABLE, filtro, null, orden);
        if (cursorDatos != null && cursorDatos.getCount() > 0) {
            cursorDatos.moveToFirst();
            mDatos=ZpControlConsentimientosRecepcionHelper.crearZpControlConsentimientosRecepcion(cursorDatos);
        }
        if (!cursorDatos.isClosed()) cursorDatos.close();
        return mDatos;
    }
    //Obtener una lista de ZpControlConsentimientosRecepcion de la base de datos
    public List<ZpControlConsentimientosRecepcion> getZpControlConsentimientosRecepciones(String filtro, String orden) throws SQLException {
        List<ZpControlConsentimientosRecepcion> zpControlConsentimientosRecepcion = new ArrayList<ZpControlConsentimientosRecepcion>();
        Cursor cursorStatus = crearCursor(MainDBConstants.DATA_CONSREC_TABLE, filtro, null, orden);
        if (cursorStatus != null && cursorStatus.getCount() > 0) {
            cursorStatus.moveToFirst();
            zpControlConsentimientosRecepcion.clear();
            do{
                ZpControlConsentimientosRecepcion datosRecepcion = null;
                datosRecepcion = ZpControlConsentimientosRecepcionHelper.crearZpControlConsentimientosRecepcion(cursorStatus);
                zpControlConsentimientosRecepcion.add(datosRecepcion);
            } while (cursorStatus.moveToNext());
        }
        if (!cursorStatus.isClosed()) cursorStatus.close();
        return zpControlConsentimientosRecepcion;
    }

    /**
     * Metodos para ZpControlReporteUSSalida en la base de datos
     *
     * @param datos
     *            Objeto ZpControlReporteUSSalida que contiene la informacion
     *
     */
    //Crear nuevo ZpControlReporteUSSalida en la base de datos
    public void crearZpControlReporteUSSalida(ZpControlReporteUSSalida datos) {
        ContentValues cv = ZpControlUSSalidaHelper.crearZpControlReporteUSSalida(datos);
        mDb.insert(MainDBConstants.DATA_USSAL_TABLE, null, cv);
    }
    //Editar ZpControlReporteUSSalida existente en la base de datos
    public boolean editarZpControlReporteUSSalida(ZpControlReporteUSSalida datos) {
        ContentValues cv = ZpControlUSSalidaHelper.crearZpControlReporteUSSalida(datos);
        return mDb.update(MainDBConstants.DATA_USSAL_TABLE, cv, MainDBConstants.codigo + "='" + datos.getCodigo() + "' and " +
                MainDBConstants.fechaDato + "=" + datos.getFechaDato().getTime(), null) > 0;
    }
    //Limpiar la tabla de ZpControlReporteUSSalida de la base de datos
    public boolean borrarZpControlReporteUSSalida() {
        return mDb.delete(MainDBConstants.DATA_USSAL_TABLE, null, null) > 0;
    }
    //Obtener un ZpControlReporteUSSalida de la base de datos
    public ZpControlReporteUSSalida getZpControlReporteUSSalida(String filtro, String orden) throws SQLException {
        ZpControlReporteUSSalida mDatos = null;
        Cursor cursorDatos = crearCursor(MainDBConstants.DATA_USSAL_TABLE, filtro, null, orden);
        if (cursorDatos != null && cursorDatos.getCount() > 0) {
            cursorDatos.moveToFirst();
            mDatos=ZpControlUSSalidaHelper.crearZpControlReporteUSSalida(cursorDatos);
        }
        if (!cursorDatos.isClosed()) cursorDatos.close();
        return mDatos;
    }
    //Obtener una lista de ZpControlReporteUSSalida de la base de datos
    public List<ZpControlReporteUSSalida> getZpControlReporteUSSalidas(String filtro, String orden) throws SQLException {
        List<ZpControlReporteUSSalida> zpControlReporteUSSalida = new ArrayList<ZpControlReporteUSSalida>();
        Cursor cursorStatus = crearCursor(MainDBConstants.DATA_USSAL_TABLE, filtro, null, orden);
        if (cursorStatus != null && cursorStatus.getCount() > 0) {
            cursorStatus.moveToFirst();
            zpControlReporteUSSalida.clear();
            do{
                ZpControlReporteUSSalida datosSalida = null;
                datosSalida = ZpControlUSSalidaHelper.crearZpControlReporteUSSalida(cursorStatus);
                zpControlReporteUSSalida.add(datosSalida);
            } while (cursorStatus.moveToNext());
        }
        if (!cursorStatus.isClosed()) cursorStatus.close();
        return zpControlReporteUSSalida;
    }

    /**
     * Metodos para ZpControlReporteUSRecepcion en la base de datos
     *
     * @param datos
     *            Objeto ZpControlReporteUSRecepcion que contiene la informacion
     *
     */
    //Crear nuevo ZpControlReporteUSRecepcion en la base de datos
    public void crearZpControlReporteUSRecepcion(ZpControlReporteUSRecepcion datos) {
        ContentValues cv = ZpControlUSRecepcionHelper.crearZpControlReporteUSRecepcion(datos);
        mDb.insert(MainDBConstants.DATA_USREC_TABLE, null, cv);
    }
    //Editar ZpControlReporteUSRecepcion existente en la base de datos
    public boolean editarZpControlReporteUSRecepcion(ZpControlReporteUSRecepcion datos) {
        ContentValues cv = ZpControlUSRecepcionHelper.crearZpControlReporteUSRecepcion(datos);
        return mDb.update(MainDBConstants.DATA_USREC_TABLE, cv, MainDBConstants.codigo + "='" + datos.getCodigo() + "' and " +
                MainDBConstants.fechaDato + "=" + datos.getFechaDato().getTime(), null) > 0;
    }
    //Limpiar la tabla de ZpControlReporteUSRecepcion de la base de datos
    public boolean borrarZpControlReporteUSRecepcion() {
        return mDb.delete(MainDBConstants.DATA_USREC_TABLE, null, null) > 0;
    }
    //Obtener un ZpControlReporteUSRecepcion de la base de datos
    public ZpControlReporteUSRecepcion getZpControlReporteUSRecepcion(String filtro, String orden) throws SQLException {
        ZpControlReporteUSRecepcion mDatos = null;
        Cursor cursorDatos = crearCursor(MainDBConstants.DATA_USREC_TABLE, filtro, null, orden);
        if (cursorDatos != null && cursorDatos.getCount() > 0) {
            cursorDatos.moveToFirst();
            mDatos=ZpControlUSRecepcionHelper.crearZpControlReporteUSRecepcion(cursorDatos);
        }
        if (!cursorDatos.isClosed()) cursorDatos.close();
        return mDatos;
    }
    //Obtener una lista de ZpControlReporteUSRecepcion de la base de datos
    public List<ZpControlReporteUSRecepcion> getZpControlReporteUSRecepciones(String filtro, String orden) throws SQLException {
        List<ZpControlReporteUSRecepcion> zpControlReporteUSRecepcion = new ArrayList<ZpControlReporteUSRecepcion>();
        Cursor cursorStatus = crearCursor(MainDBConstants.DATA_USREC_TABLE, filtro, null, orden);
        if (cursorStatus != null && cursorStatus.getCount() > 0) {
            cursorStatus.moveToFirst();
            zpControlReporteUSRecepcion.clear();
            do{
                ZpControlReporteUSRecepcion datosRecepcion = null;
                datosRecepcion = ZpControlUSRecepcionHelper.crearZpControlReporteUSRecepcion(cursorStatus);
                zpControlReporteUSRecepcion.add(datosRecepcion);
            } while (cursorStatus.moveToNext());
        }
        if (!cursorStatus.isClosed()) cursorStatus.close();
        return zpControlReporteUSRecepcion;
    }

    /**
     * Metodos para Zp01StudyEntrySectionAtoD en la base de datos
     *
     */
    //Crear nuevo Zp01StudyEntrySectionAtoD en la base de datos
    public void crearZp01StudyEntrySectionAtoD(Zp01StudyEntrySectionAtoD studyEntrySectionAtoD) {
        ContentValues cv = Zp01StudyEntryHelper.crearZp01StudyEntrySectionAtoDValues(studyEntrySectionAtoD);
        mDb.insert(Zp01DBConstants.STUDYENTRY_AD_TABLE, null, cv);
    }
    //Editar Zp01StudyEntrySectionAtoD existente en la base de datos
    public boolean editarZp01StudyEntrySectionAtoD(Zp01StudyEntrySectionAtoD studyEntrySectionAtoD) {
        ContentValues cv = Zp01StudyEntryHelper.crearZp01StudyEntrySectionAtoDValues(studyEntrySectionAtoD);
        return mDb.update(Zp01DBConstants.STUDYENTRY_AD_TABLE, cv, Zp01DBConstants.recordId + "='"
                + studyEntrySectionAtoD.getRecordId()+ "' and " + Zp01DBConstants.redcapEventName + "='" + studyEntrySectionAtoD.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp01StudyEntrySectionAtoD de la base de datos
    public boolean borrarZp01StudyEntrySectionAtoD() {
        return mDb.delete(Zp01DBConstants.STUDYENTRY_AD_TABLE, null, null) > 0;
    }
    //Obtener un Zp01StudyEntrySectionAtoD de la base de datos
    public Zp01StudyEntrySectionAtoD getZp01StudyEntrySectionAtoD(String filtro, String orden) throws SQLException {
        Zp01StudyEntrySectionAtoD studyEntrySectionAtoD = null;
        Cursor cursorAtoD = crearCursor(Zp01DBConstants.STUDYENTRY_AD_TABLE, filtro, null, orden);
        if (cursorAtoD != null && cursorAtoD.getCount() > 0) {
            cursorAtoD.moveToFirst();
            studyEntrySectionAtoD=Zp01StudyEntryHelper.crearZp01StudyEntrySectionAtoD(cursorAtoD);
        }
        if (!cursorAtoD.isClosed()) cursorAtoD.close();
        return studyEntrySectionAtoD;
    }
    //Obtener una lista de Zp01StudyEntrySectionAtoD de la base de datos
    public List<Zp01StudyEntrySectionAtoD> getZp01StudyEntrySectionAtoDs(String filtro, String orden) throws SQLException {
        List<Zp01StudyEntrySectionAtoD> studyEntrySectionAtoDs = new ArrayList<Zp01StudyEntrySectionAtoD>();
        Cursor cursorAtoD = crearCursor(Zp01DBConstants.STUDYENTRY_AD_TABLE, filtro, null, orden);
        if (cursorAtoD != null && cursorAtoD.getCount() > 0) {
            cursorAtoD.moveToFirst();
            studyEntrySectionAtoDs.clear();
            do{
                Zp01StudyEntrySectionAtoD studyEntrySectionAtoD = null;
                studyEntrySectionAtoD = Zp01StudyEntryHelper.crearZp01StudyEntrySectionAtoD(cursorAtoD);
                studyEntrySectionAtoDs.add(studyEntrySectionAtoD);
            } while (cursorAtoD.moveToNext());
        }
        if (!cursorAtoD.isClosed()) cursorAtoD.close();
        return studyEntrySectionAtoDs;
    }

    /**
     * Metodos para Zp01StudyEntrySectionE en la base de datos
     *
     */
    //Crear nuevo Zp01StudyEntrySectionE en la base de datos
    public void crearZp01StudyEntrySectionE(Zp01StudyEntrySectionE studyEntrySectionE) {
        ContentValues cv = Zp01StudyEntryHelper.crearZp01StudyEntrySectionEValues(studyEntrySectionE);
        mDb.insert(Zp01DBConstants.STUDYENTRY_E_TABLE, null, cv);
    }
    //Editar Zp01StudyEntrySectionE existente en la base de datos
    public boolean editarZp01StudyEntrySectionE(Zp01StudyEntrySectionE studyEntrySectionE) {
        ContentValues cv = Zp01StudyEntryHelper.crearZp01StudyEntrySectionEValues(studyEntrySectionE);
        return mDb.update(Zp01DBConstants.STUDYENTRY_E_TABLE, cv, Zp01DBConstants.recordId + "='"
                + studyEntrySectionE.getRecordId() + "' and " + Zp01DBConstants.redcapEventName + "='" + studyEntrySectionE.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp01StudyEntrySectionE de la base de datos
    public boolean borrarZp01StudyEntrySectionE() {
        return mDb.delete(Zp01DBConstants.STUDYENTRY_E_TABLE, null, null) > 0;
    }
    //Obtener un Zp01StudyEntrySectionE de la base de datos
    public Zp01StudyEntrySectionE getZp01StudyEntrySectionE(String filtro, String orden) throws SQLException {
        Zp01StudyEntrySectionE studyEntrySectionE = null;
        Cursor cursorE = crearCursor(Zp01DBConstants.STUDYENTRY_E_TABLE, filtro, null, orden);
        if (cursorE != null && cursorE.getCount() > 0) {
            cursorE.moveToFirst();
            studyEntrySectionE=Zp01StudyEntryHelper.crearZp01StudyEntrySectionE(cursorE);
        }
        if (!cursorE.isClosed()) cursorE.close();
        return studyEntrySectionE;
    }
    //Obtener una lista de Zp01StudyEntrySectionE de la base de datos
    public List<Zp01StudyEntrySectionE> getZp01StudyEntrySectionEs(String filtro, String orden) throws SQLException {
        List<Zp01StudyEntrySectionE> studyEntrySectionEs = new ArrayList<Zp01StudyEntrySectionE>();
        Cursor cursorE = crearCursor(Zp01DBConstants.STUDYENTRY_E_TABLE, filtro, null, orden);
        if (cursorE != null && cursorE.getCount() > 0) {
            cursorE.moveToFirst();
            studyEntrySectionEs.clear();
            do{
                Zp01StudyEntrySectionE studyEntrySectionE = null;
                studyEntrySectionE = Zp01StudyEntryHelper.crearZp01StudyEntrySectionE(cursorE);
                studyEntrySectionEs.add(studyEntrySectionE);
            } while (cursorE.moveToNext());
        }
        if (!cursorE.isClosed()) cursorE.close();
        return studyEntrySectionEs;
    }

    /**
     * Metodos para Zp01StudyEntrySectionFtoK en la base de datos
     *
     */
    //Crear nuevo Zp01StudyEntrySectionFtoK en la base de datos
    public void crearZp01StudyEntrySectionFtoK(Zp01StudyEntrySectionFtoK studyEntrySectionFtoK) {
        ContentValues cv = Zp01StudyEntryHelper.crearZp01StudyEntrySectionFtoKValues(studyEntrySectionFtoK);
        mDb.insert(Zp01DBConstants.STUDYENTRY_FK_TABLE, null, cv);
    }
    //Editar Zp01StudyEntrySectionFtoK existente en la base de datos
    public boolean editarZp01StudyEntrySectionFtoK(Zp01StudyEntrySectionFtoK studyEntrySectionFtoK) {
        ContentValues cv = Zp01StudyEntryHelper.crearZp01StudyEntrySectionFtoKValues(studyEntrySectionFtoK);
        return mDb.update(Zp01DBConstants.STUDYENTRY_FK_TABLE, cv, Zp01DBConstants.recordId + "='"
                + studyEntrySectionFtoK.getRecordId() + "' and " + Zp01DBConstants.redcapEventName + "='" + studyEntrySectionFtoK.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp01StudyEntrySectionFtoK de la base de datos
    public boolean borrarZp01StudyEntrySectionFtoK() {
        return mDb.delete(Zp01DBConstants.STUDYENTRY_FK_TABLE, null, null) > 0;
    }
    //Obtener un Zp01StudyEntrySectionFtoK de la base de datos
    public Zp01StudyEntrySectionFtoK getZp01StudyEntrySectionFtoK(String filtro, String orden) throws SQLException {
        Zp01StudyEntrySectionFtoK studyEntrySectionFtoK = null;
        Cursor cursorFtoK = crearCursor(Zp01DBConstants.STUDYENTRY_FK_TABLE, filtro, null, orden);
        if (cursorFtoK != null && cursorFtoK.getCount() > 0) {
            cursorFtoK.moveToFirst();
            studyEntrySectionFtoK=Zp01StudyEntryHelper.crearZp01StudyEntrySectionFtoK(cursorFtoK);
        }
        if (!cursorFtoK.isClosed()) cursorFtoK.close();
        return studyEntrySectionFtoK;
    }
    //Obtener una lista de Zp01StudyEntrySectionFtoK de la base de datos
    public List<Zp01StudyEntrySectionFtoK> getZp01StudyEntrySectionFtoKs(String filtro, String orden) throws SQLException {
        List<Zp01StudyEntrySectionFtoK> studyEntrySectionFtoKs = new ArrayList<Zp01StudyEntrySectionFtoK>();
        Cursor cursorFtoK = crearCursor(Zp01DBConstants.STUDYENTRY_FK_TABLE, filtro, null, orden);
        if (cursorFtoK != null && cursorFtoK.getCount() > 0) {
            cursorFtoK.moveToFirst();
            studyEntrySectionFtoKs.clear();
            do{
                Zp01StudyEntrySectionFtoK studyEntrySectionFtoK = null;
                studyEntrySectionFtoK = Zp01StudyEntryHelper.crearZp01StudyEntrySectionFtoK(cursorFtoK);
                studyEntrySectionFtoKs.add(studyEntrySectionFtoK);
            } while (cursorFtoK.moveToNext());
        }
        if (!cursorFtoK.isClosed()) cursorFtoK.close();
        return studyEntrySectionFtoKs;
    }

    /**
     * Metodos para Zp02BiospecimenCollection en la base de datos
     *
     */
    //Crear nuevo Zp02BiospecimenCollection en la base de datos
    public void crearZp02BiospecimenCollection(Zp02BiospecimenCollection biospecimenCollection) {
        ContentValues cv = Zp02BiospecimenCollectionHelper.crearZp02BiospecimenCollection(biospecimenCollection);
        mDb.insert(Zp02DBConstants.BIOCOLLECTION_TABLE, null, cv);
    }
    //Editar Zp02BiospecimenCollection existente en la base de datos
    public boolean editarZp02BiospecimenCollection(Zp02BiospecimenCollection biospecimenCollection) {
        ContentValues cv = Zp02BiospecimenCollectionHelper.crearZp02BiospecimenCollection(biospecimenCollection);
        return mDb.update(Zp02DBConstants.BIOCOLLECTION_TABLE, cv, Zp02DBConstants.recordId + "='"
                + biospecimenCollection.getRecordId() + "' and " + Zp02DBConstants.redcapEventName + "='" + biospecimenCollection.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp02BiospecimenCollection de la base de datos
    public boolean borrarZp02BiospecimenCollection() {
        return mDb.delete(Zp02DBConstants.BIOCOLLECTION_TABLE, null, null) > 0;
    }
    //Obtener un Zp02BiospecimenCollection de la base de datos
    public Zp02BiospecimenCollection getZp02BiospecimenCollection(String filtro, String orden) throws SQLException {
        Zp02BiospecimenCollection biospecimenCollection = null;
        Cursor cursorBC = crearCursor(Zp02DBConstants.BIOCOLLECTION_TABLE, filtro, null, orden);
        if (cursorBC != null && cursorBC.getCount() > 0) {
            cursorBC.moveToFirst();
            biospecimenCollection=Zp02BiospecimenCollectionHelper.crearZp02BiospecimenCollection(cursorBC);
        }
        if (!cursorBC.isClosed()) cursorBC.close();
        return biospecimenCollection;
    }
    //Obtener una lista de Zp02BiospecimenCollection de la base de datos
    public List<Zp02BiospecimenCollection> getZp02BiospecimenCollections(String filtro, String orden) throws SQLException {
        List<Zp02BiospecimenCollection> biospecimenCollections = new ArrayList<Zp02BiospecimenCollection>();
        Cursor cursorBC = crearCursor(Zp02DBConstants.BIOCOLLECTION_TABLE, filtro, null, orden);
        if (cursorBC != null && cursorBC.getCount() > 0) {
            cursorBC.moveToFirst();
            biospecimenCollections.clear();
            do{
                Zp02BiospecimenCollection biospecimenCollection = null;
                biospecimenCollection = Zp02BiospecimenCollectionHelper.crearZp02BiospecimenCollection(cursorBC);
                biospecimenCollections.add(biospecimenCollection);
            } while (cursorBC.moveToNext());
        }
        if (!cursorBC.isClosed()) cursorBC.close();
        return biospecimenCollections;
    }

    /**
     * Metodos para Zp03MonthlyVisit en la base de datos
     *
     */
    //Crear nuevo Zp03MonthlyVisit en la base de datos
    public void crearZp03MonthlyVisit(Zp03MonthlyVisit monthlyVisit) {
        ContentValues cv = Zp03MonthlyVisitHelper.crearZp03MonthlyVisit(monthlyVisit);
        mDb.insert(Zp03DBConstants.MONTHLYVISIT_TABLE, null, cv);
    }
    //Editar Zp03MonthlyVisit existente en la base de datos
    public boolean editarZp03MonthlyVisit(Zp03MonthlyVisit monthlyVisit) {
        ContentValues cv = Zp03MonthlyVisitHelper.crearZp03MonthlyVisit(monthlyVisit);
        return mDb.update(Zp03DBConstants.MONTHLYVISIT_TABLE, cv, Zp03DBConstants.recordId + "='"
                + monthlyVisit.getRecordId() + "' and " + Zp03DBConstants.redcapEventName + "='" + monthlyVisit.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp03MonthlyVisit de la base de datos
    public boolean borrarZp03MonthlyVisit() {
        return mDb.delete(Zp03DBConstants.MONTHLYVISIT_TABLE, null, null) > 0;
    }
    //Obtener un Zp03MonthlyVisit de la base de datos
    public Zp03MonthlyVisit getZp03MonthlyVisit(String filtro, String orden) throws SQLException {
        Zp03MonthlyVisit monthlyVisit = null;
        Cursor cursorMV = crearCursor(Zp03DBConstants.MONTHLYVISIT_TABLE, filtro, null, orden);
        if (cursorMV != null && cursorMV.getCount() > 0) {
            cursorMV.moveToFirst();
            monthlyVisit=Zp03MonthlyVisitHelper.crearZp03MonthlyVisit(cursorMV);
        }
        if (!cursorMV.isClosed()) cursorMV.close();
        return monthlyVisit;
    }
    //Obtener una lista de Zp03MonthlyVisit de la base de datos
    public List<Zp03MonthlyVisit> getZp03MonthlyVisits(String filtro, String orden) throws SQLException {
        List<Zp03MonthlyVisit> monthlyVisits = new ArrayList<Zp03MonthlyVisit>();
        Cursor cursorMV = crearCursor(Zp03DBConstants.MONTHLYVISIT_TABLE, filtro, null, orden);
        if (cursorMV != null && cursorMV.getCount() > 0) {
            cursorMV.moveToFirst();
            monthlyVisits.clear();
            do{
                Zp03MonthlyVisit monthlyVisit = null;
                monthlyVisit = Zp03MonthlyVisitHelper.crearZp03MonthlyVisit(cursorMV);
                monthlyVisits.add(monthlyVisit);
            } while (cursorMV.moveToNext());
        }
        if (!cursorMV.isClosed()) cursorMV.close();
        return monthlyVisits;
    }

    /**
     * Metodos para Zp04TrimesterVisitSectionAtoD en la base de datos
     *
     */
    //Crear nuevo Zp04TrimesterVisitSectionAtoD en la base de datos
    public void crearZp04TrimesterVisitSectionAtoD(Zp04TrimesterVisitSectionAtoD trimesterVisitSectionAtoD) {
        ContentValues cv = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionAtoD(trimesterVisitSectionAtoD);
        mDb.insert(Zp04DBConstants.TRIMESTERVISIT_AD_TABLE, null, cv);
    }
    //Editar Zp04TrimesterVisitSectionAtoD existente en la base de datos
    public boolean editarZp04TrimesterVisitSectionAtoD(Zp04TrimesterVisitSectionAtoD trimesterVisitSectionAtoD) {
        ContentValues cv = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionAtoD(trimesterVisitSectionAtoD);
        return mDb.update(Zp04DBConstants.TRIMESTERVISIT_AD_TABLE, cv, Zp04DBConstants.recordId + "='"
                + trimesterVisitSectionAtoD.getRecordId() + "' and " + Zp04DBConstants.redcapEventName + "='" + trimesterVisitSectionAtoD.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp04TrimesterVisitSectionAtoD de la base de datos
    public boolean borrarZp04TrimesterVisitSectionAtoD() {
        return mDb.delete(Zp04DBConstants.TRIMESTERVISIT_AD_TABLE, null, null) > 0;
    }
    //Obtener un Zp04TrimesterVisitSectionAtoD de la base de datos
    public Zp04TrimesterVisitSectionAtoD getZp04TrimesterVisitSectionAtoD(String filtro, String orden) throws SQLException {
        Zp04TrimesterVisitSectionAtoD trimesterVisitSectionAtoD = null;
        Cursor cursorAD = crearCursor(Zp04DBConstants.TRIMESTERVISIT_AD_TABLE, filtro, null, orden);
        if (cursorAD != null && cursorAD.getCount() > 0) {
            cursorAD.moveToFirst();
            trimesterVisitSectionAtoD=Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionAtoD(cursorAD);
        }
        if (!cursorAD.isClosed()) cursorAD.close();
        return trimesterVisitSectionAtoD;
    }
    //Obtener una lista de Zp04TrimesterVisitSectionAtoD de la base de datos
    public List<Zp04TrimesterVisitSectionAtoD> getZp04TrimesterVisitSectionAtoDs(String filtro, String orden) throws SQLException {
        List<Zp04TrimesterVisitSectionAtoD> trimesterVisitSectionAtoDs = new ArrayList<Zp04TrimesterVisitSectionAtoD>();
        Cursor cursorAD = crearCursor(Zp04DBConstants.TRIMESTERVISIT_AD_TABLE, filtro, null, orden);
        if (cursorAD != null && cursorAD.getCount() > 0) {
            cursorAD.moveToFirst();
            trimesterVisitSectionAtoDs.clear();
            do{
                Zp04TrimesterVisitSectionAtoD trimesterVisitSectionAtoD = null;
                trimesterVisitSectionAtoD = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionAtoD(cursorAD);
                trimesterVisitSectionAtoDs.add(trimesterVisitSectionAtoD);
            } while (cursorAD.moveToNext());
        }
        if (!cursorAD.isClosed()) cursorAD.close();
        return trimesterVisitSectionAtoDs;
    }

    /**
     * Metodos para Zp04TrimesterVisitSectionE en la base de datos
     *
     */
    //Crear nuevo Zp04TrimesterVisitSectionE en la base de datos
    public void crearZp04TrimesterVisitSectionE(Zp04TrimesterVisitSectionE trimesterVisitSectionE) {
        ContentValues cv = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionE(trimesterVisitSectionE);
        mDb.insert(Zp04DBConstants.TRIMESTERVISIT_E_TABLE, null, cv);
    }
    //Editar Zp04TrimesterVisitSectionE existente en la base de datos
    public boolean editarZp04TrimesterVisitSectionE(Zp04TrimesterVisitSectionE trimesterVisitSectionE) {
        ContentValues cv = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionE(trimesterVisitSectionE);
        return mDb.update(Zp04DBConstants.TRIMESTERVISIT_E_TABLE, cv, Zp04DBConstants.recordId + "='"
                + trimesterVisitSectionE.getRecordId() + "' and " + Zp04DBConstants.redcapEventName + "='" + trimesterVisitSectionE.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp04TrimesterVisitSectionE de la base de datos
    public boolean borrarZp04TrimesterVisitSectionE() {
        return mDb.delete(Zp04DBConstants.TRIMESTERVISIT_E_TABLE, null, null) > 0;
    }
    //Obtener un Zp04TrimesterVisitSectionE de la base de datos
    public Zp04TrimesterVisitSectionE getZp04TrimesterVisitSectionE(String filtro, String orden) throws SQLException {
        Zp04TrimesterVisitSectionE trimesterVisitSectionE = null;
        Cursor cursorE = crearCursor(Zp04DBConstants.TRIMESTERVISIT_E_TABLE, filtro, null, orden);
        if (cursorE != null && cursorE.getCount() > 0) {
            cursorE.moveToFirst();
            trimesterVisitSectionE=Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionE(cursorE);
        }
        if (!cursorE.isClosed()) cursorE.close();
        return trimesterVisitSectionE;
    }
    //Obtener una lista de Zp04TrimesterVisitSectionE de la base de datos
    public List<Zp04TrimesterVisitSectionE> getZp04TrimesterVisitSectionEs(String filtro, String orden) throws SQLException {
        List<Zp04TrimesterVisitSectionE> trimesterVisitSectionEs = new ArrayList<Zp04TrimesterVisitSectionE>();
        Cursor cursorE = crearCursor(Zp04DBConstants.TRIMESTERVISIT_E_TABLE, filtro, null, orden);
        if (cursorE != null && cursorE.getCount() > 0) {
            cursorE.moveToFirst();
            trimesterVisitSectionEs.clear();
            do{
                Zp04TrimesterVisitSectionE trimesterVisitSectionE = null;
                trimesterVisitSectionE = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionE(cursorE);
                trimesterVisitSectionEs.add(trimesterVisitSectionE);
            } while (cursorE.moveToNext());
        }
        if (!cursorE.isClosed()) cursorE.close();
        return trimesterVisitSectionEs;
    }

    /**
     * Metodos para Zp04TrimesterVisitSectionFtoH en la base de datos
     *
     */
    //Crear nuevo Zp04TrimesterVisitSectionFtoH en la base de datos
    public void crearZp04TrimesterVisitSectionFtoH(Zp04TrimesterVisitSectionFtoH trimesterVisitSectionFtoH) {
        ContentValues cv = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionFtoH(trimesterVisitSectionFtoH);
        mDb.insert(Zp04DBConstants.TRIMESTERVISIT_FH_TABLE, null, cv);
    }
    //Editar Zp04TrimesterVisitSectionFtoH existente en la base de datos
    public boolean editarZp04TrimesterVisitSectionFtoH(Zp04TrimesterVisitSectionFtoH trimesterVisitSectionFtoH) {
        ContentValues cv = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionFtoH(trimesterVisitSectionFtoH);
        return mDb.update(Zp04DBConstants.TRIMESTERVISIT_FH_TABLE, cv, Zp04DBConstants.recordId + "='"
                + trimesterVisitSectionFtoH.getRecordId() + "' and " + Zp04DBConstants.redcapEventName + "='" + trimesterVisitSectionFtoH.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp04TrimesterVisitSectionFtoH de la base de datos
    public boolean borrarZp04TrimesterVisitSectionFtoH() {
        return mDb.delete(Zp04DBConstants.TRIMESTERVISIT_FH_TABLE, null, null) > 0;
    }
    //Obtener un Zp04TrimesterVisitSectionFtoH de la base de datos
    public Zp04TrimesterVisitSectionFtoH getZp04TrimesterVisitSectionFtoH(String filtro, String orden) throws SQLException {
        Zp04TrimesterVisitSectionFtoH trimesterVisitSectionFtoH = null;
        Cursor cursorFH = crearCursor(Zp04DBConstants.TRIMESTERVISIT_FH_TABLE, filtro, null, orden);
        if (cursorFH != null && cursorFH.getCount() > 0) {
            cursorFH.moveToFirst();
            trimesterVisitSectionFtoH=Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionFtoH(cursorFH);
        }
        if (!cursorFH.isClosed()) cursorFH.close();
        return trimesterVisitSectionFtoH;
    }
    //Obtener una lista de Zp04TrimesterVisitSectionFtoH de la base de datos
    public List<Zp04TrimesterVisitSectionFtoH> getZp04TrimesterVisitSectionFtoHs(String filtro, String orden) throws SQLException {
        List<Zp04TrimesterVisitSectionFtoH> trimesterVisitSectionFtoHs = new ArrayList<Zp04TrimesterVisitSectionFtoH>();
        Cursor cursorFH = crearCursor(Zp04DBConstants.TRIMESTERVISIT_FH_TABLE, filtro, null, orden);
        if (cursorFH != null && cursorFH.getCount() > 0) {
            cursorFH.moveToFirst();
            trimesterVisitSectionFtoHs.clear();
            do{
                Zp04TrimesterVisitSectionFtoH trimesterVisitSectionFtoH = null;
                trimesterVisitSectionFtoH = Zp04TrimesterVisitHelper.crearZp04TrimesterVisitSectionFtoH(cursorFH);
                trimesterVisitSectionFtoHs.add(trimesterVisitSectionFtoH);
            } while (cursorFH.moveToNext());
        }
        if (!cursorFH.isClosed()) cursorFH.close();
        return trimesterVisitSectionFtoHs;
    }

    /**
     * Metodos para Zp05UltrasoundExam en la base de datos
     *
     */
    //Crear nuevo Zp05UltrasoundExam en la base de datos
    public void crearZp05UltrasoundExam(Zp05UltrasoundExam ultrasoundExam) {
        ContentValues cv = Zp05UltrasoundExamHelper.crearZp05UltrasoundExam(ultrasoundExam);
        mDb.insert(Zp05DBConstants.ULTRASOUNDEXAM_TABLE, null, cv);
    }
    //Editar Zp05UltrasoundExam existente en la base de datos
    public boolean editarZp05UltrasoundExam(Zp05UltrasoundExam ultrasoundExam) {
        ContentValues cv = Zp05UltrasoundExamHelper.crearZp05UltrasoundExam(ultrasoundExam);
        return mDb.update(Zp05DBConstants.ULTRASOUNDEXAM_TABLE, cv, Zp05DBConstants.recordId + "='"
                + ultrasoundExam.getRecordId() + "' and " + Zp05DBConstants.redcapEventName + "='" + ultrasoundExam.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp05UltrasoundExam de la base de datos
    public boolean borrarZp05UltrasoundExam() {
        return mDb.delete(Zp05DBConstants.ULTRASOUNDEXAM_TABLE, null, null) > 0;
    }
    //Obtener un Zp05UltrasoundExam de la base de datos
    public Zp05UltrasoundExam getZp05UltrasoundExam(String filtro, String orden) throws SQLException {
        Zp05UltrasoundExam ultrasoundExam = null;
        Cursor cursor = crearCursor(Zp05DBConstants.ULTRASOUNDEXAM_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            ultrasoundExam=Zp05UltrasoundExamHelper.crearZp05UltrasoundExam(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return ultrasoundExam;
    }
    //Obtener una lista de Zp05UltrasoundExam de la base de datos
    public List<Zp05UltrasoundExam> getZp05UltrasoundExams(String filtro, String orden) throws SQLException {
        List<Zp05UltrasoundExam> ultrasoundExams = new ArrayList<Zp05UltrasoundExam>();
        Cursor cursor = crearCursor(Zp05DBConstants.ULTRASOUNDEXAM_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            ultrasoundExams.clear();
            do{
                Zp05UltrasoundExam ultrasoundExam = null;
                ultrasoundExam = Zp05UltrasoundExamHelper.crearZp05UltrasoundExam(cursor);
                ultrasoundExams.add(ultrasoundExam);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return ultrasoundExams;
    }

    /**
     * Metodos para Zp06DeliveryAnd6weekVisit en la base de datos
     *
     */
    //Crear nuevo Zp06DeliveryAnd6weekVisit en la base de datos
    public void crearZp06DeliveryAnd6weekVisit(Zp06DeliveryAnd6weekVisit deliveryAnd6weekVisit) {
        ContentValues cv = Zp06DeliveryAnd6weekVisitHelper.crearZp06DeliveryAnd6weekVisit(deliveryAnd6weekVisit);
        mDb.insert(Zp06DBConstants.DELIVERY6WVISIT_TABLE, null, cv);
    }
    //Editar Zp06DeliveryAnd6weekVisit existente en la base de datos
    public boolean editarZp06DeliveryAnd6weekVisit(Zp06DeliveryAnd6weekVisit deliveryAnd6weekVisit) {
        ContentValues cv = Zp06DeliveryAnd6weekVisitHelper.crearZp06DeliveryAnd6weekVisit(deliveryAnd6weekVisit);
        return mDb.update(Zp06DBConstants.DELIVERY6WVISIT_TABLE, cv, Zp06DBConstants.recordId + "='"
                + deliveryAnd6weekVisit.getRecordId() + "' and " + Zp06DBConstants.redcapEventName + "='" + deliveryAnd6weekVisit.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp06DeliveryAnd6weekVisit de la base de datos
    public boolean borrarZp06DeliveryAnd6weekVisit() {
        return mDb.delete(Zp06DBConstants.DELIVERY6WVISIT_TABLE, null, null) > 0;
    }
    //Obtener un Zp06DeliveryAnd6weekVisit de la base de datos
    public Zp06DeliveryAnd6weekVisit getZp06DeliveryAnd6weekVisit(String filtro, String orden) throws SQLException {
        Zp06DeliveryAnd6weekVisit deliveryAnd6weekVisit = null;
        Cursor cursor = crearCursor(Zp06DBConstants.DELIVERY6WVISIT_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            deliveryAnd6weekVisit=Zp06DeliveryAnd6weekVisitHelper.crearZp06DeliveryAnd6weekVisit(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return deliveryAnd6weekVisit;
    }
    //Obtener una lista de Zp06DeliveryAnd6weekVisit de la base de datos
    public List<Zp06DeliveryAnd6weekVisit> getZp06DeliveryAnd6weekVisits(String filtro, String orden) throws SQLException {
        List<Zp06DeliveryAnd6weekVisit> deliveryAnd6weekVisits = new ArrayList<Zp06DeliveryAnd6weekVisit>();
        Cursor cursor = crearCursor(Zp06DBConstants.DELIVERY6WVISIT_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            deliveryAnd6weekVisits.clear();
            do{
                Zp06DeliveryAnd6weekVisit deliveryAnd6weekVisit = null;
                deliveryAnd6weekVisit = Zp06DeliveryAnd6weekVisitHelper.crearZp06DeliveryAnd6weekVisit(cursor);
                deliveryAnd6weekVisits.add(deliveryAnd6weekVisit);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return deliveryAnd6weekVisits;
    }

    /**
     * Metodos para Zp08StudyExit en la base de datos
     *
     */
    //Crear nuevo Zp08StudyExit en la base de datos
    public void crearZp08StudyExit(Zp08StudyExit studyExit) {
        ContentValues cv = Zp08StudyExitHelper.crearZp08StudyExit(studyExit);
        mDb.insert(Zp08DBConstants.STUDYEXIT_TABLE, null, cv);
    }
    //Editar Zp08StudyExit existente en la base de datos
    public boolean editarZp08StudyExit(Zp08StudyExit studyExit) {
        ContentValues cv = Zp08StudyExitHelper.crearZp08StudyExit(studyExit);
        return mDb.update(Zp08DBConstants.STUDYEXIT_TABLE, cv, Zp08DBConstants.recordId + "='"
                + studyExit.getRecordId() + "' and " + Zp08DBConstants.redcapEventName + "='" + studyExit.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp08StudyExit de la base de datos
    public boolean borrarZp08StudyExit() {
        return mDb.delete(Zp08DBConstants.STUDYEXIT_TABLE, null, null) > 0;
    }
    //Obtener un Zp08StudyExit de la base de datos
    public Zp08StudyExit getZp08StudyExit(String filtro, String orden) throws SQLException {
        Zp08StudyExit studyExit = null;
        Cursor cursor = crearCursor(Zp08DBConstants.STUDYEXIT_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            studyExit=Zp08StudyExitHelper.crearZp08StudyExit(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return studyExit;
    }
    //Obtener una lista de Zp08StudyExit de la base de datos
    public List<Zp08StudyExit> getZp08StudyExits(String filtro, String orden) throws SQLException {
        List<Zp08StudyExit> zp08StudyExits = new ArrayList<Zp08StudyExit>();
        Cursor cursor = crearCursor(Zp08DBConstants.STUDYEXIT_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            zp08StudyExits.clear();
            do{
                Zp08StudyExit studyExit = null;
                studyExit = Zp08StudyExitHelper.crearZp08StudyExit(cursor);
                zp08StudyExits.add(studyExit);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return zp08StudyExits;
    }

    /**
     * Metodos para Zp07InfantAssessmentVisit en la base de datos
     *
     */
    //Crear nuevo Zp07InfantAssessmentVisit en la base de datos
    public void crearZp07InfantAssessmentVisit(Zp07InfantAssessmentVisit infantAssessmentVisit) {
        ContentValues cv = Zp07InfantAssessmentVisitHelper.crearZp07InfantAssessmentVisit(infantAssessmentVisit);
        mDb.insert(Zp07DBConstants.INFANTASSESSMENT_TABLE, null, cv);
    }
    //Editar Zp07InfantAssessmentVisit existente en la base de datos
    public boolean editarZp07InfantAssessmentVisit(Zp07InfantAssessmentVisit infantAssessmentVisit) {
        ContentValues cv = Zp07InfantAssessmentVisitHelper.crearZp07InfantAssessmentVisit(infantAssessmentVisit);
        return mDb.update(Zp07DBConstants.INFANTASSESSMENT_TABLE, cv, Zp07DBConstants.recordId + "='"
                + infantAssessmentVisit.getRecordId() + "' and " + Zp07DBConstants.redcapEventName + "='" + infantAssessmentVisit.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp07InfantAssessmentVisit de la base de datos
    public boolean borrarZp07InfantAssessmentVisit() {
        return mDb.delete(Zp07DBConstants.INFANTASSESSMENT_TABLE, null, null) > 0;
    }
    //Obtener un Zp07InfantAssessmentVisit de la base de datos
    public Zp07InfantAssessmentVisit getZp07InfantAssessmentVisit(String filtro, String orden) throws SQLException {
        Zp07InfantAssessmentVisit infantAssessmentVisit = null;
        Cursor cursor = crearCursor(Zp07DBConstants.INFANTASSESSMENT_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            infantAssessmentVisit=Zp07InfantAssessmentVisitHelper.crearZp07InfantAssessmentVisit(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return infantAssessmentVisit;
    }
    //Obtener una lista de Zp07InfantAssessmentVisit de la base de datos
    public List<Zp07InfantAssessmentVisit> getZp07InfantAssessmentVisits(String filtro, String orden) throws SQLException {
        List<Zp07InfantAssessmentVisit> infantAssessmentVisits = new ArrayList<Zp07InfantAssessmentVisit>();
        Cursor cursor = crearCursor(Zp07DBConstants.INFANTASSESSMENT_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            infantAssessmentVisits.clear();
            do{
                Zp07InfantAssessmentVisit infantAssessmentVisit = null;
                infantAssessmentVisit = Zp07InfantAssessmentVisitHelper.crearZp07InfantAssessmentVisit(cursor);
                infantAssessmentVisits.add(infantAssessmentVisit);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return infantAssessmentVisits;
    }

    /**
     * Metodos para Zp07aInfantOphtResults en la base de datos
     *
     */
    //Crear nuevo Zp07AInfantOphtResults en la base de datos
    public void crearZp07aInfantOphtResults(Zp07aInfantOphtResults aInfantOpthResults) {
        ContentValues cv = Zp07aInfantOphtResultsHelper.crearZp07AInfantOpthResults(aInfantOpthResults);
        mDb.insert(Zp07aDBConstants.AINFANT_OPHTRESULTS_TABLE, null, cv);
    }
    //Editar Zp07AInfantOphtResults existente en la base de datos
    public boolean editarZp07aInfantOphtResults(Zp07aInfantOphtResults aInfantOpthResults) {
        ContentValues cv = Zp07aInfantOphtResultsHelper.crearZp07AInfantOpthResults(aInfantOpthResults);
        return mDb.update(Zp07aDBConstants.AINFANT_OPHTRESULTS_TABLE, cv, Zp07DBConstants.recordId + "='"
                + aInfantOpthResults.getRecordId() + "' and " + Zp07DBConstants.redcapEventName + "='" + aInfantOpthResults.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp07InfantAssessmentVisit de la base de datos
    public boolean borrarZp07aInfantOphtResults() {
        return mDb.delete(Zp07aDBConstants.AINFANT_OPHTRESULTS_TABLE, null, null) > 0;
    }
    //Obtener un Zp07InfantAssessmentVisit de la base de datos
    public Zp07aInfantOphtResults getZp07aInfantOphtResult(String filtro, String orden) throws SQLException {
        Zp07aInfantOphtResults aInfantOpthResults = null;
        Cursor cursor = crearCursor(Zp07aDBConstants.AINFANT_OPHTRESULTS_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            aInfantOpthResults= Zp07aInfantOphtResultsHelper.crearZp07AInfantOphtResults(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return aInfantOpthResults;
    }
    //Obtener una lista de Zp07InfantAssessmentVisit de la base de datos
    public List<Zp07aInfantOphtResults> getZp07aInfantOphtResults(String filtro, String orden) throws SQLException {
        List<Zp07aInfantOphtResults> aInfantOpthResults = new ArrayList<Zp07aInfantOphtResults>();
        Cursor cursor = crearCursor(Zp07aDBConstants.AINFANT_OPHTRESULTS_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            aInfantOpthResults.clear();
            do{
                Zp07aInfantOphtResults aInfantOpthResult = null;
                aInfantOpthResult = Zp07aInfantOphtResultsHelper.crearZp07AInfantOphtResults(cursor);
                aInfantOpthResults.add(aInfantOpthResult);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return aInfantOpthResults;
    }

    /**
     * Metodos para Zp07bInfantAudioResults en la base de datos
     *
     */
    //Crear nuevo Zp07bInfantAudioResults en la base de datos
    public void crearZp07bInfantAudioResults(Zp07bInfantAudioResults bInfantAudioResults) {
        ContentValues cv = Zp07bInfantAudioResultsHelper.crearZp07bInfantAudioResults(bInfantAudioResults);
        mDb.insert(Zp07bDBConstants.BINFANT_AUDIORESULTS_TABLE, null, cv);
    }
    //Editar Zp07bInfantAudioResults existente en la base de datos
    public boolean editarZp07bInfantAudioResults(Zp07bInfantAudioResults bInfantAudioResults) {
        ContentValues cv = Zp07bInfantAudioResultsHelper.crearZp07bInfantAudioResults(bInfantAudioResults);
        return mDb.update(Zp07bDBConstants.BINFANT_AUDIORESULTS_TABLE, cv, Zp07DBConstants.recordId + "='"
                + bInfantAudioResults.getRecordId() + "' and " + Zp07DBConstants.redcapEventName + "='" + bInfantAudioResults.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp07bInfantAudioResults de la base de datos
    public boolean borrarZp07bInfantAudioResults() {
        return mDb.delete(Zp07bDBConstants.BINFANT_AUDIORESULTS_TABLE, null, null) > 0;
    }
    //Obtener un Zp07bInfantAudioResults de la base de datos
    public Zp07bInfantAudioResults getZp07bInfantAudioResult(String filtro, String orden) throws SQLException {
        Zp07bInfantAudioResults bInfantAudioResults = null;
        Cursor cursor = crearCursor(Zp07bDBConstants.BINFANT_AUDIORESULTS_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            bInfantAudioResults= Zp07bInfantAudioResultsHelper.crearZp07bInfantAudioResults(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return bInfantAudioResults;
    }
    //Obtener una lista de Zp07bInfantAudioResults de la base de datos
    public List<Zp07bInfantAudioResults> getZp07bInfantAudioResults(String filtro, String orden) throws SQLException {
        List<Zp07bInfantAudioResults> bInfantAudioResults = new ArrayList<Zp07bInfantAudioResults>();
        Cursor cursor = crearCursor(Zp07bDBConstants.BINFANT_AUDIORESULTS_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            bInfantAudioResults.clear();
            do{
                Zp07bInfantAudioResults bInfantAudioResult = null;
                bInfantAudioResult = Zp07bInfantAudioResultsHelper.crearZp07bInfantAudioResults(cursor);
                bInfantAudioResults.add(bInfantAudioResult);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return bInfantAudioResults;
    }

    /**
     * Metodos para Zp07cInfantImageStudies en la base de datos
     *
     */
    //Crear nuevo Zp07cInfantImageStudies en la base de datos
    public void crearZp07cInfantImageStudies(Zp07cInfantImageStudies cInfantImageStudies) {
        ContentValues cv = Zp07cInfantImageStudiesHelper.crearZp07cInfantImageStudies(cInfantImageStudies);
        mDb.insert(Zp07cDBConstants.CINFANT_IMAGESTUDIES_TABLE, null, cv);
    }
    //Editar Zp07cInfantImageStudies existente en la base de datos
    public boolean editarZp07cInfantImageStudies(Zp07cInfantImageStudies cInfantImageStudies) {
        ContentValues cv = Zp07cInfantImageStudiesHelper.crearZp07cInfantImageStudies(cInfantImageStudies);
        return mDb.update(Zp07cDBConstants.CINFANT_IMAGESTUDIES_TABLE, cv, Zp07DBConstants.recordId + "='"
                + cInfantImageStudies.getRecordId() + "' and " + Zp07DBConstants.redcapEventName + "='" + cInfantImageStudies.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp07cInfantImageStudies de la base de datos
    public boolean borrarZp07cInfantImageStudies() {
        return mDb.delete(Zp07cDBConstants.CINFANT_IMAGESTUDIES_TABLE, null, null) > 0;
    }
    //Obtener un Zp07cInfantImageStudies de la base de datos
    public Zp07cInfantImageStudies getZp07cInfantImageSt(String filtro, String orden) throws SQLException {
        Zp07cInfantImageStudies cInfantImageStudies = null;
        Cursor cursor = crearCursor(Zp07cDBConstants.CINFANT_IMAGESTUDIES_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            cInfantImageStudies= Zp07cInfantImageStudiesHelper.crearZp07cInfantImageStudies(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return cInfantImageStudies;
    }
    //Obtener una lista de Zp07cInfantImageStudies de la base de datos
    public List<Zp07cInfantImageStudies> getZp07cInfantImageStudies(String filtro, String orden) throws SQLException {
        List<Zp07cInfantImageStudies> cInfantImageStudies = new ArrayList<Zp07cInfantImageStudies>();
        Cursor cursor = crearCursor(Zp07cDBConstants.CINFANT_IMAGESTUDIES_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            cInfantImageStudies.clear();
            do{
                Zp07cInfantImageStudies cInfantImageSt = null;
                cInfantImageSt = Zp07cInfantImageStudiesHelper.crearZp07cInfantImageStudies(cursor);
                cInfantImageStudies.add(cInfantImageSt);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return cInfantImageStudies;
    }

    /**
     * Metodos para Zp07dInfantBayleyScales en la base de datos
     *
     */
    //Crear nuevo Zp07dInfantBayleyScales en la base de datos
    public void crearZp07dInfantBayleyScales(Zp07dInfantBayleyScales dInfantBayleyScales) {
        ContentValues cv = Zp07dInfantBayleyScalesHelper.crearZp07dInfantBayleyScales(dInfantBayleyScales);
        mDb.insert(Zp07dDBConstants.DINFANT_BAYLEYSCALES_TABLE, null, cv);
    }
    //Editar Zp07dInfantBayleyScales existente en la base de datos
    public boolean editarZp07dInfantBayleyScales(Zp07dInfantBayleyScales dInfantBayleyScales) {
        ContentValues cv = Zp07dInfantBayleyScalesHelper.crearZp07dInfantBayleyScales(dInfantBayleyScales);
        return mDb.update(Zp07dDBConstants.DINFANT_BAYLEYSCALES_TABLE, cv, Zp07DBConstants.recordId + "='"
                + dInfantBayleyScales.getRecordId() + "' and " + Zp07DBConstants.redcapEventName + "='" + dInfantBayleyScales.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp07dInfantBayleyScales de la base de datos
    public boolean borrarZp07dInfantBayleyScales() {
        return mDb.delete(Zp07dDBConstants.DINFANT_BAYLEYSCALES_TABLE, null, null) > 0;
    }
    //Obtener un Zp07dInfantBayleyScales de la base de datos
    public Zp07dInfantBayleyScales getZp07dInfantBayleySc(String filtro, String orden) throws SQLException {
        Zp07dInfantBayleyScales dInfantBayleyScales = null;
        Cursor cursor = crearCursor(Zp07dDBConstants.DINFANT_BAYLEYSCALES_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            dInfantBayleyScales= Zp07dInfantBayleyScalesHelper.crearZp07dInfantBayleyScales(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return dInfantBayleyScales;
    }
    //Obtener una lista de Zp07dInfantBayleyScales de la base de datos
    public List<Zp07dInfantBayleyScales> getZp07dInfantBayleyScales(String filtro, String orden) throws SQLException {
        List<Zp07dInfantBayleyScales> dInfantBayleyScales = new ArrayList<Zp07dInfantBayleyScales>();
        Cursor cursor = crearCursor(Zp07dDBConstants.DINFANT_BAYLEYSCALES_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            dInfantBayleyScales.clear();
            do{
                Zp07dInfantBayleyScales dInfantBayleySc = null;
                dInfantBayleySc = Zp07dInfantBayleyScalesHelper.crearZp07dInfantBayleyScales(cursor);
                dInfantBayleyScales.add(dInfantBayleySc);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return dInfantBayleyScales;
    }

    /**
     * Metodos para Zp02dInfantBiospecimenCollection en la base de datos
     *
     */
    //Crear nuevo Zp02dInfantBiospecimenCollection en la base de datos
    public void crearZp02dInfantBiospecimenCollection(Zp02dInfantBiospecimenCollection dInfantBiospecimenCollection) {
        ContentValues cv = Zp02BiospecimenCollectionHelper.crearZp02dInfantBiospecimenCollection(dInfantBiospecimenCollection);
        mDb.insert(Zp02DBConstants.INFANT_BIOCOLLECTION_TABLE, null, cv);
    }
    //Editar Zp02dInfantBiospecimenCollection existente en la base de datos
    public boolean editarZp02dInfantBiospecimenCollection(Zp02dInfantBiospecimenCollection dInfantBiospecimenCollection) {
        ContentValues cv = Zp02BiospecimenCollectionHelper.crearZp02dInfantBiospecimenCollection(dInfantBiospecimenCollection);
        return mDb.update(Zp02DBConstants.INFANT_BIOCOLLECTION_TABLE, cv, Zp02DBConstants.recordId + "='"
                + dInfantBiospecimenCollection.getRecordId() + "' and " + Zp02DBConstants.redcapEventName + "='" + dInfantBiospecimenCollection.getRedcapEventName() +"'", null) > 0;
    }
    //Limpiar la tabla de Zp02dInfantBiospecimenCollection de la base de datos
    public boolean borrarZp02dInfantBiospecimenCollection() {
        return mDb.delete(Zp02DBConstants.INFANT_BIOCOLLECTION_TABLE, null, null) > 0;
    }
    //Obtener un Zp02dInfantBiospecimenCollection de la base de datos
    public Zp02dInfantBiospecimenCollection getZp02dInfantBiospecimenCollection(String filtro, String orden) throws SQLException {
        Zp02dInfantBiospecimenCollection dInfantBiospecimenCollection = null;
        Cursor cursor = crearCursor(Zp02DBConstants.INFANT_BIOCOLLECTION_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            dInfantBiospecimenCollection=Zp02BiospecimenCollectionHelper.crearZp02dInfantBiospecimenCollection(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return dInfantBiospecimenCollection;
    }
    //Obtener una lista de Zp02dInfantBiospecimenCollection de la base de datos
    public List<Zp02dInfantBiospecimenCollection> getZp02dInfantBiospecimenCollections(String filtro, String orden) throws SQLException {
        List<Zp02dInfantBiospecimenCollection> dInfantBiospecimenCollections = new ArrayList<Zp02dInfantBiospecimenCollection>();
        Cursor cursor = crearCursor(Zp02DBConstants.INFANT_BIOCOLLECTION_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            dInfantBiospecimenCollections.clear();
            do{
                Zp02dInfantBiospecimenCollection dInfantBiospecimenCollection = null;
                dInfantBiospecimenCollection = Zp02BiospecimenCollectionHelper.crearZp02dInfantBiospecimenCollection(cursor);
                dInfantBiospecimenCollections.add(dInfantBiospecimenCollection);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return dInfantBiospecimenCollections;
    }

    /**
     * Metodos para ZpInfantData en la base de datos
     *
     */
    //Crear nuevo ZpInfantData en la base de datos
    public void crearZpInfantData(ZpInfantData mZpInfantData) {
        ContentValues cv = ZpInfantDataHelper.crearZpInfantData(mZpInfantData);
        mDb.insert(MainDBConstants.INFANTDATA_TABLE, null, cv);
    }
    //Editar ZpInfantData existente en la base de datos
    public boolean editarZpInfantData(ZpInfantData mZpInfantData) {
        ContentValues cv = ZpInfantDataHelper.crearZpInfantData(mZpInfantData);
        return mDb.update(MainDBConstants.INFANTDATA_TABLE, cv, MainDBConstants.recordId + "='"
                + mZpInfantData.getRecordId() +"'", null) > 0;
    }
    //Limpiar la tabla de ZpInfantData de la base de datos
    public boolean borrarZpInfantData() {
        return mDb.delete(MainDBConstants.INFANTDATA_TABLE, null, null) > 0;
    }
    //Obtener un ZpInfantData de la base de datos
    public ZpInfantData getZpInfantData(String filtro, String orden) throws SQLException {
    	ZpInfantData mZpInfantData = null;
        Cursor cursor = crearCursor(MainDBConstants.INFANTDATA_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            mZpInfantData=ZpInfantDataHelper.crearZpInfantData(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return mZpInfantData;
    }
    //Obtener una lista de ZpInfantData de la base de datos
    public List<ZpInfantData> getZpInfantDatas(String filtro, String orden) throws SQLException {
        List<ZpInfantData> mZpInfantDatas = new ArrayList<ZpInfantData>();
        Cursor cursor = crearCursor(MainDBConstants.INFANTDATA_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            mZpInfantDatas.clear();
            do{
            	ZpInfantData mZpInfantData = null;
                mZpInfantData = ZpInfantDataHelper.crearZpInfantData(cursor);
                mZpInfantDatas.add(mZpInfantData);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return mZpInfantDatas;
    }   
    
    /**
     * Metodos para ZpEstadoInfante en la base de datos
     *
     */
    //Crear nuevo ZpEstadoInfante en la base de datos
    public void crearZpEstadoInfante(ZpEstadoInfante mZpEstadoInfante) {
        ContentValues cv = ZpEstadoInfanteHelper.crearZpEstadoInfante(mZpEstadoInfante);
        mDb.insert(MainDBConstants.INFANTSTATUS_TABLE, null, cv);
    }
    //Editar ZpEstadoInfante existente en la base de datos
    public boolean editarZpEstadoInfante(ZpEstadoInfante mZpEstadoInfante) {
        ContentValues cv = ZpEstadoInfanteHelper.crearZpEstadoInfante(mZpEstadoInfante);
        return mDb.update(MainDBConstants.INFANTSTATUS_TABLE, cv, MainDBConstants.recordId + "='"
                + mZpEstadoInfante.getRecordId() +"'", null) > 0;
    }
    //Limpiar la tabla de ZpEstadoInfante de la base de datos
    public boolean borrarZpEstadoInfante() {
        return mDb.delete(MainDBConstants.INFANTSTATUS_TABLE, null, null) > 0;
    }
    //Obtener un ZpEstadoInfante de la base de datos
    public ZpEstadoInfante getZpEstadoInfante(String filtro, String orden) throws SQLException {
    	ZpEstadoInfante mZpEstadoInfante = null;
        Cursor cursor = crearCursor(MainDBConstants.INFANTSTATUS_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            mZpEstadoInfante=ZpEstadoInfanteHelper.crearZpEstadoInfante(cursor);
        }
        if (!cursor.isClosed()) cursor.close();
        return mZpEstadoInfante;
    }
    //Obtener una lista de ZpEstadoInfante de la base de datos
    public List<ZpEstadoInfante> getZpEstadoInfantes(String filtro, String orden) throws SQLException {
        List<ZpEstadoInfante> mZpEstadoInfantes = new ArrayList<ZpEstadoInfante>();
        Cursor cursor = crearCursor(MainDBConstants.INFANTSTATUS_TABLE, filtro, null, orden);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            mZpEstadoInfantes.clear();
            do{
            	ZpEstadoInfante mZpEstadoInfanteData = null;
                mZpEstadoInfanteData = ZpEstadoInfanteHelper.crearZpEstadoInfante(cursor);
                mZpEstadoInfantes.add(mZpEstadoInfanteData);
            } while (cursor.moveToNext());
        }
        if (!cursor.isClosed()) cursor.close();
        return mZpEstadoInfantes;
    }

    public Boolean verificarData() throws SQLException{
        Cursor c = null;
        c = crearCursor(MainDBConstants.SCREENING_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(MainDBConstants.DATA_PREG_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(MainDBConstants.STATUS_PREG_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(MainDBConstants.DATA_PRESCREEN_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp01DBConstants.STUDYENTRY_AD_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp01DBConstants.STUDYENTRY_E_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp01DBConstants.STUDYENTRY_FK_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp02DBConstants.BIOCOLLECTION_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp03DBConstants.MONTHLYVISIT_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp04DBConstants.TRIMESTERVISIT_AD_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp04DBConstants.TRIMESTERVISIT_E_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp04DBConstants.TRIMESTERVISIT_FH_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp05DBConstants.ULTRASOUNDEXAM_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp06DBConstants.DELIVERY6WVISIT_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp08DBConstants.STUDYEXIT_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(MainDBConstants.DATA_CONSSAL_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(MainDBConstants.DATA_CONSREC_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(MainDBConstants.DATA_USSAL_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(MainDBConstants.DATA_USREC_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp07DBConstants.INFANTASSESSMENT_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
        c = crearCursor(Zp02DBConstants.INFANT_BIOCOLLECTION_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
        if (c != null && c.getCount()>0) {c.close();return true;}
		c = crearCursor(MainDBConstants.INFANTDATA_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
		if (c != null && c.getCount()>0) {c.close();return true;}
		c = crearCursor(MainDBConstants.INFANTSTATUS_TABLE, MainDBConstants.STATUS + "='"  + Constants.STATUS_NOT_SUBMITTED+ "'", null, null);
		if (c != null && c.getCount()>0) {c.close();return true;}
		c.close();
        return false;
    }
}
