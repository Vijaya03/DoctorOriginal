package com.example.hp.doctororiginal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClerkChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clerk_choice2);
    }

    public void PatientDetail(View view) {
        Intent intent=new Intent(ClerkChoice.this,PatientDetails.class);
        startActivity(intent);
    }

    public void ViewPatientDetails(View view) {
        Intent intent=new Intent(ClerkChoice.this,ViewPatientDetail.class);
        startActivity(intent);
    }
}
