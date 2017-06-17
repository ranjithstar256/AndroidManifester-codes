package kp.ranjith.raguclasscodes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ranjith on 27-04-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, "Details.db", null, 1);  // db name, version number
        sqLiteDatabase=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // query for creating table
        String qury = "create table Persons (Name text , Location text)";
        db.execSQL(qury);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long savedat(String s1, String s2) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("Name",s1);
        contentValues.put("Location",s2); // sqlite db

        long j  = sqLiteDatabase.insert("Persons",null,contentValues);
        return j;
    }
    

    public String getloc(String name) {

        String s;
        Cursor c = sqLiteDatabase.query("Persons",null,"Name=?",new String[]{name},null,null,null);
        // select * from Persons where Name = name

        if(c.getCount()<1) {
            return "not exist";
        }

        c.moveToFirst();

        s = c.getString(c.getColumnIndex("Location"));
        return s;
    }

    public int updateval(String s4, String s5) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("Location",s5);

        return sqLiteDatabase.update("Persons",contentValues,"Name = '"+s4+"'",null);

        //  update table persons set Location='s5' where Name =  s4

    }
}
