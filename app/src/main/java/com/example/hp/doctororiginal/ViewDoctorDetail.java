package com.example.hp.doctororiginal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hp.doctororiginal.Patient.Doctor;
import com.example.hp.doctororiginal.Patient.Patient;
import com.example.hp.doctororiginal.dbutil.DoctorConstant;
import com.example.hp.doctororiginal.dbutil.DoctorManager;

import java.util.ArrayList;

public class ViewDoctorDetail extends AppCompatActivity {
    DoctorManager medicalManager;
    SQLiteDatabase sqLiteDatabase;
  Doctor cp;
    ArrayList<Doctor> Doctorlist;
    ListView Listdata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor_detail);
        Listdata = findViewById(R.id.Listdata);
       Doctorlist = new ArrayList<>();
        medicalManager = new DoctorManager(this);
        sqLiteDatabase = medicalManager.openDB();

        Cursor c = sqLiteDatabase.query(DoctorConstant.TABLE_NAME, null, null, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            do {
                String name = c.getString(c.getColumnIndex(DoctorConstant.FNAME));
               String Lname = c.getString(c.getColumnIndex(DoctorConstant.LNAME));
                String email = c.getString(c.getColumnIndex(DoctorConstant.EMAIL));

                int pass = c.getInt(c.getColumnIndex(DoctorConstant.PASSWORD));
                int num = c.getInt(c.getColumnIndex(DoctorConstant.NUMBER));

                cp = new Doctor(name, Lname, email, pass, num);
               Doctorlist.add(cp);
            }

            while (c.moveToNext());
        }
        ArrayAdapter<Doctor> ad = new ArrayAdapter<Doctor>(this, android.R.layout.simple_list_item_1, Doctorlist);
        Listdata.setAdapter(ad);
        c.close();



    }

}




