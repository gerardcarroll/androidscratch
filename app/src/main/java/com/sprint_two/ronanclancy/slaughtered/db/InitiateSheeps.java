package com.sprint_two.ronanclancy.slaughtered.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * SheepDB seed data
 * <p/>
 * Created by ronanclancy.
 */
public class InitiateSheeps {

    private static final String DATABASE_TABLE_SHEEP = "sheeps";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String KEY_AGE = "age";

    private static final String KEY_WEIGHT = "weight";

    private static final String KEY_PHOTO_ID = "photoId";

    private static final String KEY_ALIVE = "alive";

    public static void init(SQLiteDatabase db) {

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(1,'Sally', '1 Years', '75 KG', 2130837585, 0)");

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(2,'Bessie', '2 Years', '79 KG', 2130837586, 0)");

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(3,'Lilly', '2 Years', '98 KG', 2130837587, 0)");

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(4,'Jimmy', '1 Years', '75 KG', 2130837588, 0)");

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(5,'Frank', '3 Years', '120 KG', 2130837589, 0)");

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(6,'Daisy', '2 Years', '164 KG', 2130837590, 0)");

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(7,'John', '3 Years', '143 KG', 2130837591, 0)");

        db.execSQL("insert into " + DATABASE_TABLE_SHEEP + "(" + KEY_ID + ","
                + KEY_NAME + ", "
                + KEY_AGE + ","
                + KEY_WEIGHT + ", "
                + KEY_PHOTO_ID + ", "
                + KEY_ALIVE + ") "
                + "values(8,'Crazy Horse', 'UnKnown', '151 KG', 2130837592, 0)");
    }
}
