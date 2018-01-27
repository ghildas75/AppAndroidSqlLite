package com.example.portable.databaserev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Portable on 2017-12-06.
 */

public class UserdbHelper extends SQLiteOpenHelper {
    private final static String DBNAME="db_contact";
    private final static int Version_db=1;
    private static final  String Create_Query=
            "CREATE TABLE "+UserContact.newUserInfo.TABLE__NAME+"("+
                    UserContact.newUserInfo.COL_USER_NAME + " TEXT,"+
                    UserContact.newUserInfo.COL_USER_MOBILE+" TEXT, "+
                    UserContact.newUserInfo.COL_EMAIL+" TEXT " +");";


    public UserdbHelper(Context context) {
        super(context,DBNAME, null, Version_db);
        Log.e("mydb","data base created or open");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Create_Query);
        Log.e("mydb"," TABLE created ");


    }
    public void insertData(String username,String mobile, String email,SQLiteDatabase db){

        ContentValues cn= new ContentValues() ;
        cn.put(UserContact.newUserInfo.COL_USER_NAME,username);
        cn.put(UserContact.newUserInfo.COL_USER_MOBILE,mobile);
        cn.put(UserContact.newUserInfo.COL_EMAIL,email);
        db.insert(UserContact.newUserInfo.TABLE__NAME,null,cn);
        Log.e("mydb"," insert values ");

    }

    public Cursor getDataCursorObject(SQLiteDatabase db){

      Cursor cursor;
      String [] projection={UserContact.newUserInfo.COL_USER_NAME,UserContact.newUserInfo.COL_EMAIL,UserContact.newUserInfo.COL_USER_MOBILE};
      cursor=db.query(UserContact.newUserInfo.TABLE__NAME,projection,null,null,null,null,null);

return cursor;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
