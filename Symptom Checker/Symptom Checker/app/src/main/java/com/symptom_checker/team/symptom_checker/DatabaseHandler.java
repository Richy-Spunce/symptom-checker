package com.symptom_checker.team.symptom_checker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Richard on 27/04/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "loginInfo.db";

    private static final String TABLE_NAME = "Login_Records";


    private static final String COL_ID = "_id";
    private static final String COL_FIRSTNAME = "firstname";
    private static final String COL_LASTNAME = "lastname";
    private static final String COL_DOB = "dob";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASSWORD = "password";
    private static final String COL_NHSNUMBER = "nhsnumber";

    private static final String COL_USERNAME = "username";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    void addRecord(LoginDetails Record)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_ID, Record.getID());
        values.put(COL_FIRSTNAME, Record.getFirstname());
        values.put(COL_LASTNAME, Record.getLastname());
        values.put(COL_DOB, Record.getDob());
        values.put(COL_EMAIL, Record.getEmail());
        values.put(COL_PASSWORD, Record.getPassword());
        values.put(COL_NHSNUMBER, Record.getNhsNumber());
        values.put(COL_USERNAME, Record.getUsername());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void removeAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<LoginDetails> getAll() {
        List<LoginDetails> list = new ArrayList<LoginDetails>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do {
                LoginDetails Record = new LoginDetails(cursor.getInt(0), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5),
                        cursor.getString(6), cursor.getString(7));

                list.add(Record);
            } while (cursor.moveToNext());
        }
        return list;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE "
                + TABLE_NAME +
                "("+ COL_ID + " INTEGER PRIMARY KEY,"
                + COL_FIRSTNAME + " TEXT,"
                + COL_LASTNAME + " TEXT,"
                + COL_DOB + " TEXT,"
                + COL_EMAIL + " TEXT,"
                + COL_PASSWORD + " TEXT,"
                + COL_NHSNUMBER + " TEXT,"
                + COL_USERNAME + " TEXT" + ")";

        db.execSQL(CREATE_LOGIN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldNum, int newNum) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
