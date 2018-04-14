package com.example.hp.doctororiginal;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.doctororiginal.dbutil.DoctorConstant;
import com.example.hp.doctororiginal.dbutil.DoctorManager;

public class DoctorRegister extends AppCompatActivity {


        EditText firstName,lastName,email,password,contact;
       DoctorManager medicalManager;
        SQLiteDatabase sqLiteDatabase;
//    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_doctor_register);
            firstName=findViewById(R.id.firstName);
            lastName=findViewById(R.id.lastName);
            email=findViewById(R.id.email);
            password=findViewById(R.id.password);
            contact=findViewById(R.id.number);
            medicalManager=new DoctorManager(this);
            sqLiteDatabase=medicalManager.openDB();
        }

        public void register(View view) {
            String fname=firstName.getText().toString();
            String lname=lastName.getText().toString();
            String em=email.getText().toString();
            String pass=password.getText().toString();
            String phn=contact.getText().toString();
            if(fname.isEmpty())
                Toast.makeText(this,"Please Enter First Name",Toast.LENGTH_SHORT).show();
            if(lname.isEmpty())
                Toast.makeText(this,"Please Enter Last Name",Toast.LENGTH_SHORT).show();
            if(pass.isEmpty())
                Toast.makeText(this,"Please Enter Password",Toast.LENGTH_SHORT).show();
            ContentValues cv=new ContentValues();
            cv.put(DoctorConstant.FNAME,fname);
            cv.put(DoctorConstant.LNAME,lname);
            cv.put(DoctorConstant.EMAIL,em);
            cv.put(DoctorConstant.PASSWORD,pass);
            cv.put(DoctorConstant.NUMBER,phn);
            long l=sqLiteDatabase.insert(DoctorConstant.TABLE_NAME,null,cv);
            if( l > 0)
            { Toast.makeText(this,"data inserted",Toast.LENGTH_LONG).show();}
            Intent i=new Intent(this,DoctorLogin.class);
            startActivity(i);
        }}

