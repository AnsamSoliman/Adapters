package com.example.ansam.adapters;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ansam on 11/14/2016.
 */

public class dbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "USERDB.db";
    public static final String USERS_TABLE_NAME = "users";
    public static final String USERS_COLUMN_ID = "_id";
    public static final String USERS_COLUMN_NAME = "name";
    public static final String USERS_COLUMN_TOWN = "town";



    public dbHelper(Context context) {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("create table users "+"( _id integer primary key autoincrement,name text,town text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);

    }
    public boolean insertUser(String name,String town){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("town",town);
        db.insert("users",null,contentValues);
        return true;
    }
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from users",null);
        return res;
    }
}
