package com.example.hp.doctororiginal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DoctorChoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_choice);
    }

    public void addClerk(View view) {


            Intent intent=new Intent(this,ClerkRegister.class);
            startActivity(intent);
        }

    public void viewDetails(View view) {

        Intent intent=new Intent(this,ViewPatientDetail.class);
        startActivity(intent);
    }

    public void ViewDoctorDetails(View view) {
        Intent intent=new Intent(this,ViewDoctorDetail.class);
        startActivity(intent);
    }
}
