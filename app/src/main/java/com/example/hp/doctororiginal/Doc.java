package com.example.hp.doctororiginal;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Doc extends AppCompatActivity {
    TextView welcomeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
welcomeScreen=findViewById(R.id.welcomeScreen);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/Craziest Deco Regular.ttf");
        welcomeScreen.setTypeface(typeface);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Doc.this,ButtonChoice.class);
                startActivity(i);
                Doc.this.finish();
            }
        },5000);
    }
}

