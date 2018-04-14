package com.example.hp.doctororiginal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.doctororiginal.dbutil.DoctorConstant;
import com.example.hp.doctororiginal.dbutil.DoctorManager;

public class ClerkRegister extends AppCompatActivity {
    TextView heading;
    EditText cfirstName, clastName, cemail, cpassword, cnumber;
    DoctorManager medicalManager;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clerk_register);
        heading = findViewById(R.id.heading);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/Fonty.ttf");
        heading.setTypeface(typeface);
        cfirstName = findViewById(R.id.cfirstName);
        clastName = findViewById(R.id.clastName);
        cemail = findViewById(R.id.cemail);
        cnumber = findViewById(R.id.cnumber);
        cpassword = findViewById(R.id.cpassword);
        medicalManager = new DoctorManager(this);
        sqLiteDatabase = medicalManager.openDB();
    }

    public void clerkRegister(View view) {
        String fname = cfirstName.getText().toString();
        String lname = clastName.getText().toString();
        String em = cemail.getText().toString();
        String pass = cpassword.getText().toString();
        String phn = cnumber.getText().toString();
        if (fname.isEmpty())
            Toast.makeText(this, "Please Enter First Name", Toast.LENGTH_SHORT).show();
        if (lname.isEmpty())
            Toast.makeText(this, "Please Enter Last Name", Toast.LENGTH_SHORT).show();
        if (pass.isEmpty())
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show();
        ContentValues cv = new ContentValues();
        cv.put(DoctorConstant.CFNAME, fname);
        cv.put(DoctorConstant.CLNAME, lname);
        cv.put(DoctorConstant.CEMAIL, em);
        cv.put(DoctorConstant.CPASSWORD, pass);
        cv.put(DoctorConstant.CNUMBER, phn);
        long l = sqLiteDatabase.insert(DoctorConstant.TABLE_NAME1, null, cv);
        if (l > 0) {
            Toast.makeText(this, "data inserted", Toast.LENGTH_LONG).show();
        }
//        Intent i=new Intent(this,MainActivity.class);
//        startActivity(i);
    }






}
