package com.example.hp.doctororiginal;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hp.doctororiginal.Patient.Patient;
import com.example.hp.doctororiginal.dbutil.DoctorConstant;
import com.example.hp.doctororiginal.dbutil.DoctorManager;

import java.util.ArrayList;
import java.util.Calendar;

public class ViewPatientDetail extends AppCompatActivity {
    DoctorManager medicalManager;
    SQLiteDatabase sqLiteDatabase;
    Patient cp;
    ArrayList<Patient> Patientlist;
    ListView Listdata;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient_detail);
        Listdata = findViewById(R.id.Listdata);
        Patientlist = new ArrayList<>();
        medicalManager = new DoctorManager(this);
        sqLiteDatabase = medicalManager.openDB();


        Cursor c = sqLiteDatabase.query(DoctorConstant.TABLE_NAME2, null, null, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            do {
                String name = c.getString(c.getColumnIndex(DoctorConstant.PFNAME));
                int age = c.getInt(c.getColumnIndex(DoctorConstant.PAGE));
                int height = c.getInt(c.getColumnIndex(DoctorConstant.PHEIGHT));
                String pro = c.getString(c.getColumnIndex(DoctorConstant.PPROBLEM));
                String phon = c.getString(c.getColumnIndex(DoctorConstant.PNUMBER));
                int day1 = c.getInt(c.getColumnIndex(DoctorConstant.Appoint));
                int month1 = c.getInt(c.getColumnIndex(DoctorConstant.Appoint1));
                cp = new Patient(name, age, height, pro, phon, day1, month1);
                Patientlist.add(cp);
            }

            while (c.moveToNext());
        }
        ArrayAdapter<Patient> ad = new ArrayAdapter<Patient>(this, android.R.layout.simple_list_item_1, Patientlist);
        Listdata.setAdapter(ad);
        c.close();



        }

    }



