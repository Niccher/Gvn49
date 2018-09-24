package com.example.nicch.gvn49;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forgpwd extends AppCompatActivity {
    Button nexta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_forgpwd);

        nexta= (Button) findViewById(R.id.btn_proced);

        nexta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Forgpwd.this, PwdReset.class));
            }
        });
    }
}
