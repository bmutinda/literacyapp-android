package org.literacyapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;
import org.literacyapp.contentprovider.dao.DaoMaster;

public class CustomDaoMaster extends DaoMaster {

    public CustomDaoMaster(SQLiteDatabase db) {
        super(db);
        Log.i(getClass().getName(), "CustomDaoMaster");
    }

    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name) {
            super(context, name);
        }

        public DevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            Log.i(getClass().getName(), "Upgrading schema from version " + oldVersion + " to " + newVersion);

            if (oldVersion < 2000000) {
                dropAllTables(db, true);
                onCreate(db);
            }

//            if (oldVersion < ???) {
//                // Add new tables and/or columns automatically (include only the DAO classes that have been modified)
//                DbMigrationHelper.migrate(db,
//                        AudioDao.class
//                );
//            }

            // If tables and/or columns have been renamed, add custom script.
//            db.execSQL("...");
        }
    }
}
