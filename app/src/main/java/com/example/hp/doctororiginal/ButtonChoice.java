package com.example.hp.doctororiginal;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class ButtonChoice extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_choice);

    }
    public void DoctorDetail(View view) {
        Intent intent = new Intent(ButtonChoice.this, DoctorLogin.class);
        startActivity(intent);
    }


    public void ClerkLogin(View view) {
        Intent intent = new Intent(ButtonChoice.this, ClerkLogin.class);
        startActivity(intent);
    }

    @Nullable

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

