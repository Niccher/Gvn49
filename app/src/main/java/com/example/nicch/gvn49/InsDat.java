package com.example.nicch.gvn49;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nicch on 3/17/18.
 */

public class InsDat extends SQLiteOpenHelper {

    public static final String dbn="Gvn49.db";
    public static final String dbTab="LoggedUsers";
    public static final String dbCol1="Count";
    public static final String dbCol2="Name";
    public static final String dbCol3="IDNum";
    public static final String dbCol4="Username";
    public static final String dbCol5="Password";
    public static final String dbCol6="Longt";
    public static final String dbCol7="Lats";

    public InsDat(Context context) {
        super(context, dbn, null, 1);
        //SQLiteDatabase sqdb=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE '"+dbTab+"' (Count INT AUTOINCREMENT UNIQUE KEY,Name TEXT,IDNum INT,Username TEXT,Password TEXT,Longt TEXT,Lats TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+dbTab);
        onCreate(sqLiteDatabase);
    }

    public boolean Putta(int cc,String nam,int ides,String usr,String pwd,String lon,String lat){
        SQLiteDatabase sqdbi=this.getWritableDatabase();
        ContentValues cvs=new ContentValues();
        cvs.put(dbCol2,nam);
        cvs.put(dbCol3,ides);
        cvs.put(dbCol4,usr);
        cvs.put(dbCol5,pwd);
        cvs.put(dbCol6,lon);
        cvs.put(dbCol7,lat);
        long outcm = sqdbi.insert(dbTab,null,cvs);

        if (outcm== -1){
            return false;
        }
        else {
            return true;
        }
    }
}
