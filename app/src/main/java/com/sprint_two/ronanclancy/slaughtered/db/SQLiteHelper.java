package com.sprint_two.ronanclancy.slaughtered.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sprint_two.ronanclancy.slaughtered.models.Sheep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Handle SQLite
 * <p/>
 * Created by ronanclancy.
 *
 * Please see https://developer.android.com/training/basics/data-storage/databases.html
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "SheepsDb";

    private static final String DATABASE_TABLE_SHEEP = "sheeps";

    private static final String KEY_ID = "id";

    private static final String KEY_NAME = "name";

    private static final String KEY_AGE = "age";

    private static final String KEY_WEIGHT = "weight";

    private static final String KEY_PHOTO_ID = "photoId";

    private static final String KEY_ALIVE = "alive";

    private static final String SHEEP_ALIVE = "0";

    private static final String SHEEP_DEAD = "1";

    private static final String[] COLUMNS = {KEY_ID, KEY_NAME, KEY_AGE, KEY_WEIGHT, KEY_PHOTO_ID};

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SHEEP_TABLE = "CREATE TABLE sheeps ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "age TEXT, " +
                "weight TEXT, " +
                "photoId INTEGER, " +
                "alive INTEGER)";

        db.execSQL(CREATE_SHEEP_TABLE);

        InitiateSheeps.init(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older Sheep table if existed
        db.execSQL("DROP TABLE IF EXISTS sheeps");

        // create fresh sheeps table
        this.onCreate(db);
    }

    /**
     * @return List<Sheep> returns a list of all living sheep
     */
    public List<Sheep> getAllLivingSheeps() {

        List<Sheep> sheeps = new ArrayList<>();

        String query = "SELECT  * FROM " + DATABASE_TABLE_SHEEP + " WHERE " + KEY_ALIVE + " = " + SHEEP_ALIVE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Sheep sheep;
        if (cursor.moveToFirst()) {
            do {
                sheep = Sheep.create(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getInt(5)

                );

                sheeps.add(sheep);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return sheeps;
    }

    /**
     * Method to slaughter a sheep
     * @param sheepId id of the sheep to be slaughtered
     */
    public void slaughterSheep(int sheepId) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIVE, SHEEP_DEAD);
        db.update(DATABASE_TABLE_SHEEP,
                values,
                KEY_ID + " = ?",
                new String[]{String.valueOf(sheepId)});

        db.close();
    }

    /**
     * @param id sheep id
     * @return sheep returns a single sheep object
     */
    public Sheep getSheep(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Sheep sheep=null;

        Cursor cursor =
                db.query(DATABASE_TABLE_SHEEP, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //if we got results get the first one
        if (cursor != null) {
            cursor.moveToFirst();

            sheep = Sheep.create(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getInt(5)
            );

            cursor.close();
        }

        return sheep;
    }

}
