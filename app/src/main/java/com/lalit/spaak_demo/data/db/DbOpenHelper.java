

package com.lalit.spaak_demo.data.db;

import android.content.Context;



import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class DbOpenHelper {

//    @Inject
//    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
//        super(context, name);
//    }

    @Inject
    public DbOpenHelper() {
        super();
    }

//
//    @Override
//    public void onUpgrade(Database db, int oldVersion, int newVersion) {
//        super.onUpgrade(db, oldVersion, newVersion);
//        AppLogger.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);
//        switch (oldVersion) {
//            case 1:
//            case 2:
//                //db.execSQL("ALTER TABLE " + UserDao.TABLENAME + " ADD COLUMN "
//                // + UserDao.Properties.Name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
//        }
//    }
}
