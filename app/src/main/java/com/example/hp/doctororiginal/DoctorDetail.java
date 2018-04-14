package com.example.hp.doctororiginal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DoctorDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
    }
    public void DoctorLogin(View view)
    {
        Intent intent=new Intent(DoctorDetail.this,DoctorLogin.class);
        startActivity(intent);
    }
    public void DoctorRegister(View view)
    {
        Intent intent=new Intent(DoctorDetail.this,DoctorRegister.class);
        startActivity(intent);
    }
}
