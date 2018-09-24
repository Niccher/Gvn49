package com.example.nicch.gvn49;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Edites extends Fragment {
    AlertDialog.Builder bulda;
    Button Cmmt;


    public Edites() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Vwer= inflater.inflate(R.layout.fragm_edites, container, false);
        getActivity().setTitle("Edit Profile");

        Cmmt=Vwer.findViewById(R.id.aply);
        Cmmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bulda = new AlertDialog.Builder(getActivity());
                bulda.setTitle("Proceed With This Action");
                bulda.setMessage("This Action is Irreversible Once Commited...");
                bulda.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(getActivity(), "Profile Updated", Toast.LENGTH_SHORT).show();
                        FragmentManager fmm=getFragmentManager();
                        FragmentTransaction fts=fmm.beginTransaction();
                        Profs npl=new Profs();
                        fts.replace(R.id.Bass,npl);
                        fts.addToBackStack(null);
                        fts.commit();
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
        });
        return Vwer;
    }

}
