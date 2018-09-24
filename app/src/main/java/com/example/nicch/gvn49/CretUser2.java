package com.example.nicch.gvn49;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class CretUser2 extends AppCompatActivity {
    Button nwUSer;
    AlertDialog.Builder bulda;
    android.app.AlertDialog.Builder builder;
    EditText Nm,Usrnm,Eml,Phon,Reg,Pswd,CPswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activ_cretuser2);

        getSupportActionBar().setTitle("Create Account");

        /*if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(Boolean.TRUE);
        }*/

        nwUSer= (Button) findViewById(R.id.NwUsr);

        Nm= (EditText) findViewById(R.id.etNm);
        Usrnm= (EditText) findViewById(R.id.etUsr);
        Eml= (EditText) findViewById(R.id.etEml);
        Phon= (EditText) findViewById(R.id.etPhn);
        Reg= (EditText) findViewById(R.id.etWad);
        Pswd= (EditText) findViewById(R.id.etPwd);
        CPswd= (EditText) findViewById(R.id.etCpwd);

        nwUSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Nm.getText().toString().equals("") || Usrnm.getText().toString().equals("")  || Eml.getText().toString().equals("") || Phon.getText().toString().equals("")  || Reg.getText().toString().equals("") || Pswd.getText().toString().equals("")  || CPswd.getText().toString().equals("") ) {
                    builder = new android.app.AlertDialog.Builder(CretUser2.this);
                    builder.setTitle("Blank Field Detected...");
                    builder.setMessage("Fill All Fields Please....");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    android.app.AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                }else {

                    final String nms=Nm.getText().toString();
                    final int Phn= Integer.parseInt(Phon.getText().toString());
                    final String Re= (Reg.getText().toString());
                    final String eml=Eml.getText().toString();
                    final String Usrn=Usrnm.getText().toString();
                    final String pwdd=Pswd.getText().toString();
                    //final String Cpwdd=cpw.getText().toString();


                    bulda = new AlertDialog.Builder(CretUser2.this);
                    bulda.setTitle("Personal Info");
                    bulda.setMessage("Your Submitted Info Will Not Be Shared With The Public...");
                    bulda.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            final ProgressDialog progressDialog=new ProgressDialog(CretUser2.this);
                            progressDialog.setMessage("Connecting to Servers...Please wait");

                            progressDialog.show();
                            Response.Listener<String> responseListener=new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse=new JSONObject(response);
                                        boolean success=jsonResponse.getBoolean("success");
                                        if(success){
                                            progressDialog.dismiss();
                                            startActivity(new Intent(CretUser2.this,Logs.class));
                                            Toast.makeText(CretUser2.this,"Your Email :"+Eml.getText().toString()+"\nPassword :"+Pswd.getText().toString(),Toast.LENGTH_LONG).show();
                                        }
                                        else {
                                            progressDialog.dismiss();
                                            AlertDialog.Builder builder=new AlertDialog.Builder(CretUser2.this);
                                            builder.setMessage("Registration failed");
                                            builder.setNegativeButton("Retry",null);
                                            builder.create();
                                            builder.show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        progressDialog.dismiss();
                                        Toast.makeText(CretUser2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                                //@Override
                                public void onErrorResponse(VolleyError er) {
                                    Toast.makeText(CretUser2.this, er.getMessage(), Toast.LENGTH_SHORT).show();
                                    VolleyLog.e("Error Hahaha: ", er.getMessage());
                                }
                            };
                            ReggCon RcONN=new ReggCon(nms,Usrn,eml,Phn,Re,pwdd,responseListener);
                            RequestQueue queue= Volley.newRequestQueue(CretUser2.this);
                            queue.add(RcONN);
                            //Toast.makeText(CretUser.this, "New User Account Created", Toast.LENGTH_SHORT).show();
                        }
                    });
                    bulda.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertdialog = bulda.create();
                    alertdialog.show();
                }
            }
        });

    }
}
