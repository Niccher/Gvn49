package com.example.nicch.gvn49;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Spla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spla);

        Handler hdl=new Handler();
        hdl.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Spla.this,Logs.class));
                finish();
            }
        }, 3500);

    }
}
