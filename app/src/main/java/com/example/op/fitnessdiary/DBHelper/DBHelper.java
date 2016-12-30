package com.example.op.fitnessdiary.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by OP on 12/30/2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";
    private SQLiteDatabase db;

    // Phiên bản
    private static final int DATABASE_VERSION = 1;

    // name of database
    private static final String DATABASE_NAME = "FitnessDiary";


    // Table : ACCOUNT
    protected static final String TABLE_ACCOUNT = "Account";

    protected static final String COLUMN_ACCOUNT_ID ="id";
    protected static final String COLUMN_ACCOUNT_NICKNAME ="nickname";
    protected static final String COLUMN_ACCOUNT_EMAIL = "email";
    protected static final String COLUMN_ACCOUNT_DOB = "dob";
    protected static final String COLUMN_ACCOUNT_AVATAR = "avatar";
    protected static final String COLUMN_ACCOUNT_RANK = "rank";
    protected static final String COLUMN_ACCOUNT_GENDER = "gender";
    protected static final String COLUMN_ACCOUNT_PASSWORD = "password";
    protected static final String CREATE_TABLE_ACCOUNT =  "CREATE TABLE " + TABLE_ACCOUNT + "("
            + COLUMN_ACCOUNT_ID + " TEXT PRIMARY KEY NOT NULL,"
            + COLUMN_ACCOUNT_NICKNAME + " TEXT NOT NULL,"
            + COLUMN_ACCOUNT_EMAIL + " TEXT NOT NULL,"
            + COLUMN_ACCOUNT_DOB + " TEXT NOT NULL,"
            + COLUMN_ACCOUNT_AVATAR + " TEXT,"
            + COLUMN_ACCOUNT_RANK + " INTEGER,"
            + COLUMN_ACCOUNT_GENDER + " TEXT NOT NULL,"
            + COLUMN_ACCOUNT_PASSWORD + " TEXT" + ")";

    public DBHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE_ACCOUNT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void open() {
        try {
            db = getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void close() {
        if (db != null && db.isOpen()) {
            try {
                db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /************************* method work with database *******************/

    /**
     * get all row of table with sql command then return cursor
     * cursor move to frist to ready for get data
     */
    public Cursor getAll(String sql) {
        open();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        close();
        return cursor;
    }

    /**
     * insert contentvaluse to table
     *
     * @param values value of data want insert
     * @return index row insert
     */
    public long insert(String table, ContentValues values) {
        open();
        long index = db.insert(table, null, values);
        close();
        return index;
    }

    /**
     * update values to table
     *
     * @return index row update
     */
    public boolean update(String table, ContentValues values, String where) {
        open();
        long index = db.update(table, values, where, null);
        close();
        return index > 0;
    }

    /**
     * delete id row of table
     */
    public boolean delete(String table, String where) {
        open();
        long index = db.delete(table, where, null);
        close();
        return index > 0;
    }
    /************************* end of method work with database *******************/
}
