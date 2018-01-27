package com.example.portable.databaserev;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Context context=this;
private UserdbHelper userdbHelper;
private SQLiteDatabase db;


    private EditText input_user;
    private EditText input_mobile;
    private EditText input_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         input_user=(EditText) findViewById(R.id.id_user);
         input_mobile=(EditText) findViewById(R.id.id_mobile);
         input_email=(EditText) findViewById(R.id.id_email);
    }

    public void addContact(View view) {
      String str_user=input_user.getText().toString();
      String str_mob=input_mobile.getText().toString();
      String str_email=input_email.getText().toString();
      userdbHelper= new UserdbHelper(context);
      db=userdbHelper.getWritableDatabase();
      userdbHelper.insertData(str_user,str_mob,str_email,db);
        Toast.makeText(this,"ok everthing",Toast.LENGTH_LONG).show();
        userdbHelper.close();
    }

    public void readContact(View view) {

        Intent intent= new Intent(this,DataListActivity.class);
        startActivity(intent);
    }
}
