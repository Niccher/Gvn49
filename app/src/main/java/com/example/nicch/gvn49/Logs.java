package com.example.nicch.gvn49;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Logs extends AppCompatActivity {
    Button lg;
    TextView forg,Cnew;
    EditText usr,pwd;
    AlertDialog.Builder builder,builde;
    Context cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_logs);

        lg= (Button) findViewById(R.id.btn_lgn);
        forg= (TextView) findViewById(R.id.forgpwd);
        lg= (Button) findViewById(R.id.btn_lgn);
        Cnew= (TextView) findViewById(R.id.NwCret);
        usr= (EditText) findViewById(R.id.edUsr);
        pwd= (EditText) findViewById(R.id.edPwd);

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(Logs.this, Limpio.class));
                /*if (usr.getText().toString().equals("") || pwd.getText().toString().equals("")) {
                    builder = new AlertDialog.Builder(Logs.this);
                    builder.setTitle("Blank Field Detected...");
                    builder.setMessage("Fill All Fields Please....");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                } else {
                    final ProgressDialog progressDialog=new ProgressDialog(Logs.this);
                    progressDialog.setMessage("Performing Credentials Compare...Please wait");

                    final String usern = usr.getText().toString();
                    final String passwd = pwd.getText().toString();

                    progressDialog.show();
                    //startActivity(new Intent(Logs.this, Homie.class));

                    Response.Listener<String> responseListener=new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse=new JSONObject(response);
                                boolean success=jsonResponse.getBoolean("success");
                                if(success){
                                    int uuid=jsonResponse.getInt("Phone");
                                    progressDialog.dismiss();

                                    Intent trv =new Intent(Logs.this, Homie.class);
                                    //trv.putExtra("uuid",uuid);
                                    trv.putExtra("Ritwa",usr.getText().toString());
                                    Logs.this.startActivity(trv);
                                    //Toast.makeText(cnt, uuid+"\nPhone to User", Toast.LENGTH_LONG).show();
                                    //startActivity(new Intent(Logs.this,Homie.class));
                                }
                                else
                                {
                                    progressDialog.dismiss();
                                    builde=new AlertDialog.Builder(Logs.this);
                                    builde.setMessage("Wrong User Credentials");
                                    builde.setNegativeButton("Retry",null);
                                    builde.create();
                                    builde.show();
                                }
                            } catch (JSONException e) {
                                progressDialog.dismiss();
                                //e.printStackTrace();
                                Toast.makeText(Logs.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                Snackbar.make(view,e.getMessage(),Snackbar.LENGTH_LONG).show();
                            }

                        }
                        public void onErrorResponse(VolleyError er) {
                            Toast.makeText(Logs.this, er.getMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            VolleyLog.e("Error Hahaha: ", er.getMessage());
                        }
                    };

                    LoggAcc LogAc = new LoggAcc(usern, passwd, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(Logs.this);
                    queue.add(LogAc);
                }*/
            }
        });

        forg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Logs.this,Forgpwd.class));
            }
        });

        Cnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Logs.this,CretUser2.class));
            }
        });



    }
}
