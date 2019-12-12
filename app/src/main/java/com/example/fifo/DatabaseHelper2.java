package com.example.fifo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;\

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="transporters.db";
    public static final String TABLE_NAME ="containers";
    public static final String COL_1="ID";
    public static final String COL_2="tid";
    public static final String COL_3 ="consignee_name";
    public static final String COL_4 ="container_number";
    public static final String COL_5 ="container_type";
    public static final String COL_6 ="container_size";
    public static final String COL_7 ="dop";
    public static final String COL_8 ="port_name";
    public static final String COL_9="date_of_delivery";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY KEY AUTOINCREMENT, tid TEXT, consignee_name TEXT,container_number TEXT,container_type TEXT,container_size TEXT,dop TEXT,port_name TEXT,date_of_delivery TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String a, String b,String c,String d,String e,String f,String h){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tid",a);
        contentValues.put("consignee_name",b);
        contentValues.put("container_number",c);
        contentValues.put("container_type",d);
       contentValues.put("container_size",e);
       contentValues.put("dop",f);
       contentValues.put("date_of_delivery",h);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return  res;
    }

    public Cursor alldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from containers",null);
        return cursor;
    }

}
