package com.example.hp.doctororiginal;

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

public class DoctorLogin extends AppCompatActivity {

    EditText username,password;
    SharedPreferences sp;
    SharedPreferences.Editor se;
    DoctorManager medicalManager;
    SQLiteDatabase sqLiteDatabase;
    String email1,pass1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        sp=getSharedPreferences("info",MODE_PRIVATE);
        se=sp.edit();
        medicalManager=new DoctorManager(this);
        sqLiteDatabase=medicalManager.openDB();
    }
    public void signIn(View view) {
        String name = username.getText().toString();
        String pass = password.getText().toString();
        se.putString("name", name);
        se.putString("pass", pass);
        se.commit();
        String nm = sp.getString("name", null);
        String ps = sp.getString("pass", null);
//        Cursor c = sqLiteDatabase.query(DoctorConstant.TABLE_NAME, null, null, null, null, null, null);
//        if (c != null && c.moveToFirst()) {
//            do {
//                email1 = c.getString(c.getColumnIndex(DoctorConstant.EMAIL));
//                pass1 = c.getString(c.getColumnIndex(DoctorConstant.PASSWORD));
//                //Toast.makeText(this, "email=" + email1 + "pass=" + pass1, Toast.LENGTH_SHORT).show();
//            }
//            while (c.moveToNext());
//        }
        if (nm.equals("vijayamaurya@gmail.com") &&ps.equals("123")) {
            Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, DoctorChoice.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please Enter correct Email and Password", Toast.LENGTH_SHORT).show();
        }
    }}