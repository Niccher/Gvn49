package com.example.nicch.gvn49;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Infos extends Fragment {
    Button sdcmt,btyp;
    AlertDialog.Builder bulda,Onyo;
    android.app.AlertDialog.Builder builder;
    EditText CBox;

    public Infos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vrw= inflater.inflate(R.layout.fragment_infos, container, false);
        getActivity().setTitle("Compose A Comment");

        sdcmt=vrw.findViewById(R.id.Sd);
        btyp=vrw.findViewById(R.id.btn_typ);
        CBox=vrw.findViewById(R.id.edComBox);

        Bundle bad=getArguments();
        if (bad !=null){
            String catt=bad.getString("Cates");
            //CBox.setText(catt+"\n");
            btyp.setText(catt);
        }else {
            btyp.setText("Hahha");
        }

        sdcmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CBox.getText().toString().equals("") || CBox.getText().toString().isEmpty()) {
                    builder = new android.app.AlertDialog.Builder(getActivity());
                    builder.setTitle("Blank Field Detected...");
                    builder.setMessage("Write A Comment To Post....");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    android.app.AlertDialog alertdialog = builder.create();
                    alertdialog.show();
                }else {

                    final int phon= 12;
                    final String tim= "Thaa";
                    final String cat=btyp.getText().toString();
                    final String Mess=CBox.getText().toString();
                    final String rep="False";//phon,tim,cat,Mess,rep,Vwd
                    final String Vwd="False";

                    bulda = new AlertDialog.Builder(getActivity());
                    bulda.setTitle("Submit Comment");
                    bulda.setMessage("Your Submitted Comment Will Sent And You Can Edit It Once Sent...");
                    bulda.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();

                            final ProgressDialog progressDialog=new ProgressDialog(getContext());
                            progressDialog.setMessage("Uploading Message... Please wait");

                            progressDialog.show();

                            Response.Listener<String> responseListener=new Response.Listener<String>(){
                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jsonResponse=new JSONObject(response);
                                        boolean success=jsonResponse.getBoolean("success");
                                        if(success){
                                            progressDialog.dismiss();
                                            startActivity(new Intent(getActivity(),Logs.class));
                                            Toast.makeText(getActivity(), "Well Inserted", Toast.LENGTH_SHORT).show();

                                        }
                                        else {
                                            progressDialog.dismiss();
                                            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                                            builder.setMessage("Registration failed");
                                            builder.setNegativeButton("Retry",null);
                                            builder.create();
                                            builder.show();
                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        progressDialog.dismiss();
                                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                }
                                //@Override
                                public void onErrorResponse(VolleyError er) {
                                    Toast.makeText(getActivity(), er.getMessage(), Toast.LENGTH_SHORT).show();
                                    VolleyLog.e("Error Hahaha: ", er.getMessage());
                                }
                            };
                            PostComm RcONN=new PostComm(phon,tim,cat,Mess,rep,Vwd,responseListener);
                            RequestQueue queue= Volley.newRequestQueue(getActivity());
                            queue.add(RcONN);

                            /*FragmentManager fmm=getFragmentManager();
                            FragmentTransaction fts=fmm.beginTransaction();
                            Sents npl=new Sents();
                            fts.replace(R.id.based,npl);
                            fts.addToBackStack(null);
                            fts.commit();*/

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
        return  vrw;
    }

}
