package com.example.hp.doctororiginal;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.example.hp.doctororiginal.dbutil.DoctorConstant;
import com.example.hp.doctororiginal.dbutil.DoctorManager;

import java.util.Calendar;

public class Message extends AppCompatActivity {
    DoctorManager medicalManager;
    SQLiteDatabase sqLiteDatabase;
    Calendar c = Calendar.getInstance();

    int pMonth = c.get(Calendar.MONTH);
    int pDay = c.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        medicalManager = new DoctorManager(this);
        sqLiteDatabase = medicalManager.openDB();



    }

    public void sendmessage(View view) {
        SmsManager sm=SmsManager.getDefault();
        Intent intent=new Intent(this,Telephony.Sms.class);
        PendingIntent pi=PendingIntent.getActivity(this,2,intent,PendingIntent.FLAG_ONE_SHOT);
        sm.sendTextMessage(DoctorConstant.NUMBER,null,"there is an appointment",pi,null);
        Toast.makeText(this,"message send",Toast.LENGTH_LONG).show();
    }
}
