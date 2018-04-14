package com.example.hp.doctororiginal;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.example.hp.doctororiginal.dbutil.DoctorConstant;
import com.example.hp.doctororiginal.dbutil.DoctorManager;

import java.util.Calendar;

/**
 * Created by HP on 13-04-2018.
 */

public class MyService extends Service {
    DoctorManager medicalManager;
    SQLiteDatabase sqLiteDatabase;
    String appoint, appoint1;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        medicalManager = new DoctorManager(this);
        sqLiteDatabase = medicalManager.openDB();
        Toast.makeText(this, "startservice", Toast.LENGTH_LONG).show();

        Calendar cd = Calendar.getInstance();
        int mMonth = cd.get(Calendar.MONTH);
String a=String.valueOf(mMonth+1);

        int mDay = cd.get(Calendar.DAY_OF_MONTH);
        String b=String.valueOf(mDay);
        Cursor c = sqLiteDatabase.query(DoctorConstant.TABLE_NAME2, null, null, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            do {      Toast.makeText(this, a+b, Toast.LENGTH_LONG).show();
                appoint = c.getString(c.getColumnIndex(DoctorConstant.Appoint1));
                appoint1 = c.getString(c.getColumnIndex(DoctorConstant.Appoint));


            } while (c.moveToNext());
        }
        if (a.equals(appoint1) && b.equals(appoint)) {
            Toast.makeText(this, a+b+"hiii", Toast.LENGTH_LONG).show();
        SmsManager sm = SmsManager.getDefault();
        Intent tent = new Intent(this, PatientDetails.class);
        PendingIntent pi = PendingIntent.getActivity(this, 2, tent, PendingIntent.FLAG_ONE_SHOT);
        sm.sendTextMessage(DoctorConstant.DoctorNumber, null, "there is an appointment", pi, null);
        Toast.makeText(this, "message send to doctor", Toast.LENGTH_LONG).show();
    }


        return super.onStartCommand(intent, flags, startId);
    }
}



