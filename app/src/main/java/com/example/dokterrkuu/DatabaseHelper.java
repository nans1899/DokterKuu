package com.example.dokterrkuu;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.sql.Date;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "Users";
    public static final String COL_1 = "Username";
    public static final String COL_2 = "Date";
    public static final String COL_3 = "Disease";
    public static final String COL_4 = "docName";
    public static final String COL_5 = "hospital";
    public static final String COL_6 = "notes";

    Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{

            db.execSQL("create table Users (Username VARCHAR(255) PRIMARY KEY, Date DATE, disease VARCHAR(255),docName VARCHAR(255), Hospital TEXT, Notes TEXT)");
            Toast.makeText(context, "Table Created Successfuly", Toast.LENGTH_SHORT).show();

        }catch(Exception e){
            Toast.makeText(context, "Failed Creating The Table Error :"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, Date Date,String disease,String docname, String hospital, String notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, Date.toString());
        contentValues.put(COL_3, disease);
        contentValues.put(COL_4, docname);
        contentValues.put(COL_5, hospital);
        contentValues.put(COL_6, notes);
        long result = db.insert(""+TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }

    }

}
