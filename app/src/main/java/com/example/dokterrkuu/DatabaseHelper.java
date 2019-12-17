package com.example.dokterrkuu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "Users";
    public static final String COL_1 = "Username";
    public static final String COL_2 = "Date";
    public static final String COL_3 = "Disease";
    public static final String COL_4 = "docName";
    public static final String COL_5 = "hospital";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (Username TEXT PRIMARY KEY, Date DATE, disease TEXT,docName TEXT, Hospital TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, Date Date,String disease,String docname, String hospital){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, Date.toString());
        contentValues.put(COL_3, disease);
        contentValues.put(COL_4, docname);
        contentValues.put(COL_5, hospital);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

}
