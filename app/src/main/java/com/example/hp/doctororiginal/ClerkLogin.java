package com.example.hp.doctororiginal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.doctororiginal.dbutil.DoctorConstant;
import com.example.hp.doctororiginal.dbutil.DoctorManager;

public class ClerkLogin extends AppCompatActivity {

    EditText username,password;
   DoctorManager medicalManager;
    SQLiteDatabase sqLiteDatabase;
    String email1,pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clerk_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        medicalManager=new DoctorManager(this);
        sqLiteDatabase=medicalManager.openDB();
    }

    public void signIn(View view) {
        String name=username.getText().toString();
        String pass=password.getText().toString();
        Cursor c=sqLiteDatabase.query(DoctorConstant.TABLE_NAME1,null,null,null,null,null,null);
        if(c!=null && c.moveToFirst()) {
            do {
                email1 = c.getString(c.getColumnIndex(DoctorConstant.CEMAIL));
                pass1 = c.getString(c.getColumnIndex(DoctorConstant.CPASSWORD));
                //Toast.makeText(this, "email=" + email1 + "pass=" + pass1, Toast.LENGTH_SHORT).show();
            }
            while (c.moveToNext());
        }
        if(email1.equals(name) && pass1.equals(pass)) {
            Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ClerkChoice.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Please Enter correct Email and Password",Toast.LENGTH_SHORT).show();
        }
    }
}
