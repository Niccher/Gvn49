package com.example.nicch.gvn49;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profs extends Fragment {

    Button edt;


    public Profs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vwr= inflater.inflate(R.layout.frag_profs, container, false);

        getActivity().setTitle("My Profile");

        edt=vwr.findViewById(R.id.Edites);

        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fmm=getFragmentManager();
                FragmentTransaction fts=fmm.beginTransaction();
                Edites npl=new Edites();
                fts.replace(R.id.Bass,npl);
                fts.addToBackStack(null);
                fts.commit();
            }
        });
        return vwr;
    }

}
