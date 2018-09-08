package com.example.acer.classdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;



/**
 * Created by ACER on 08-09-2018.
 */

public class MyDbHandler extends SQLiteOpenHelper{
    Context context;
    SQLiteDatabase db;

    MyDbHandler(Context context){
        super(context, "studentdb", null, 1);
        this.context = context;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table student(rno integer primary key, name text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public String viewRecord(){
        StringBuffer sb = new StringBuffer();
        Cursor c = db.query("student", null, null, null, null, null, null);

        if(c.getCount() > 0){
            c.moveToFirst();
            do {
                String rno = c.getString(c.getColumnIndex("rno"));
                String name = c.getString(c.getColumnIndex("name"));
                sb.append("Rno"+rno+"name"+name);

            }while (c.moveToNext());
        }
        return sb.toString();
    }

    public void addRecord(int rno, String name){
        ContentValues cv = new ContentValues();
        cv.put("rno", rno);

        cv.put("name", name);

        long rid = db.insert("student", null, cv);
        if (rid < 0){
            Toast.makeText(context, "issue", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "record added", Toast.LENGTH_SHORT).show();

        }
    }
}
