package com.sprint_two.ronanclancy.slaughtered.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sprint_two.ronanclancy.slaughtered.models.Sheep;

import java.util.LinkedList;
import java.util.List;

/**
 * Handle SQLite
 * <p/>
 * Created by ronanclancy.
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
     * @return List<Sheep> returns a list of all sheep
     */
    public List<Sheep> getAllSheeps() {

        List<Sheep> sheeps = new LinkedList<>();

        String query = "SELECT  * FROM " + DATABASE_TABLE_SHEEP;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Sheep sheep;
        if (cursor.moveToFirst()) {
            do {
                sheep = new Sheep();
                sheep.setId(Integer.parseInt(cursor.getString(0)));
                sheep.setName(cursor.getString(1));
                sheep.setAge(cursor.getString(2));
                sheep.setWeight(cursor.getString(3));
                sheep.setPhotoId(cursor.getInt(4));
                sheep.setAlive(cursor.getInt(5));

                sheeps.add(sheep);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return sheeps;
    }

    /**
     * NEEDS REFACTOR!
     *
     * @param sheep sheep object to be updated
     * @return int
     */
    public int updateSheepDead(Sheep sheep) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ALIVE, sheep.getAlive());

        int inserted = db.update(DATABASE_TABLE_SHEEP,
                values,
                KEY_ID + " = ?",
                new String[]{String.valueOf(sheep.getId())});
        db.close();

        return inserted;
    }

    /**
     * @param id sheep id
     * @return sheep returns a single sheep object
     */
    public Sheep getSheep(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Sheep sheep = new Sheep();

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

            sheep.setId(Integer.parseInt(cursor.getString(0)));
            sheep.setId(Integer.parseInt(cursor.getString(0)));
            sheep.setName(cursor.getString(1));
            sheep.setAge(cursor.getString(2));
            sheep.setWeight(cursor.getString(3));
            sheep.setPhotoId(cursor.getInt(4));
            cursor.close();
        }

        return sheep;
    }

}