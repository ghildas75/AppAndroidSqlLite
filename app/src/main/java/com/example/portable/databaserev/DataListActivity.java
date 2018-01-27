package com.example.portable.databaserev;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {
private ListView lv;
SQLiteDatabase db;
UserdbHelper userdbHelper;
    private Cursor cursor;
    private ListDataAdapter listClassAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
     lv=(ListView) findViewById(R.id.id_list);
     userdbHelper= new UserdbHelper(getApplicationContext());
     db=userdbHelper.getReadableDatabase();
      cursor=userdbHelper.getDataCursorObject(db);
      listClassAdapter= new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
      lv.setAdapter(listClassAdapter);


      if(cursor.moveToFirst()){

          do{
           String name, mob,email;
           name=cursor.getString(0);
           mob=cursor.getString(1);
           email=cursor.getString(2);
         DataProvider dataProvider= new DataProvider(name,mob,email);
         listClassAdapter.add(dataProvider);
          }while(cursor.moveToNext());
      }

    }
}
