package ni.org.ics.zikapositivas.appmovil.database;

import java.io.File;

import net.sqlcipher.database.SQLiteDatabase;
import ni.org.ics.zikapositivas.appmovil.R;
import android.content.Context;

public abstract class ZikaPosSQLiteOpenHelper {
    private final String mPath;
    private final String mName;
    private final int mNewVersion;
    private final Context mContext;
	private final String mPassword;
	private final boolean mFromServer;
	private final boolean mCleanDb;

    private SQLiteDatabase mDatabase = null;
    private boolean mIsInitializing = false;

    public ZikaPosSQLiteOpenHelper(String path, String name, int version, Context context,
    		String password, boolean fromServer, boolean cleanDb) {
        if (version < 1)
            throw new IllegalArgumentException("Version must be >= 1, was " + version);

        mPath = path;
        mName = name;
        mNewVersion = version;
        mContext = context;
        mPassword = password;
        mFromServer = fromServer;
        mCleanDb = cleanDb;
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        if (mDatabase != null && mDatabase.isOpen() && !mDatabase.isReadOnly()) {
            return mDatabase; // The database is already open for business
        }
        if (mIsInitializing) {
            throw new IllegalStateException("getWritableDatabase called recursively");
        }
        boolean success = false;
        SQLiteDatabase db = null;
        try {
        	SQLiteDatabase.loadLibs(mContext);
            mIsInitializing = true;
            File databaseFile = new File(mPath + "/" + mName);
            if (databaseFile.exists()&& mCleanDb && mFromServer) {
            	databaseFile.delete();
            }
            
            
            if (!databaseFile.exists()&& !mFromServer) {
            	throw new IllegalStateException(mContext.getString(R.string.errordb));
            }
            else {
            	db = SQLiteDatabase.openOrCreateDatabase(databaseFile, mPassword, null);
            }

            int version = db.getVersion();
            if (version != mNewVersion) {
                db.beginTransaction();
                try {
                    if (version == 0) {
                        onCreate(db);
                    } else {
                        onUpgrade(db, version, mNewVersion);
                    }
                    db.setVersion(mNewVersion);
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
            }

            onOpen(db);
            success = true;
            return db;
        } finally {
            mIsInitializing = false;
            if (success) {
                if (mDatabase != null) {
                    try {
                        mDatabase.close();
                    } catch (Exception e) {
                    }
                    // mDatabase.unlock();
                }
                mDatabase = db;
            } else {
                // if (mDatabase != null) mDatabase.unlock();
                if (db != null)
                    db.close();
            }
        }
    }


    /**
     * Close any open database object.
     */
    public synchronized void close() {
        if (mIsInitializing)
            throw new IllegalStateException("Closed during initialization");

        if (mDatabase != null && mDatabase.isOpen()) {
            mDatabase.close();
            mDatabase = null;
        }
    }


    /**
     * Called when the database is created for the first time. This is where the creation of tables
     * and the initial population of the tables should happen.
     * 
     * @param db The database.
     */
    public abstract void onCreate(SQLiteDatabase db);


    /**
     * Called when the database needs to be upgraded. The implementation should use this method to
     * drop tables, add tables, or do anything else it needs to upgrade to the new schema version.
     * <p>
     * The SQLite ALTER TABLE documentation can be found <a
     * href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns you can use
     * ALTER TABLE to insert them into a live table. If you rename or remove columns you can use
     * ALTER TABLE to rename the old table, then create the new table and then populate the new
     * table with the contents of the old table.
     * 
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);


    /**
     * Called when the database has been opened. Override method should check
     * {@link SQLiteDatabase#isReadOnly} before updating the database.
     * 
     * @param db The database.
     */
    public void onOpen(SQLiteDatabase db) {
    }
}
