package com.example.nicch.gvn49;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Catego extends Fragment {
    Button nxt;
    RadioGroup rg;
    String Cats;


    public Catego() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vrw= inflater.inflate(R.layout.frag_catego, container, false);

        getActivity().setTitle("Select Category");

        nxt= vrw.findViewById(R.id.ProcidCat);

        rg=vrw.findViewById(R.id.Ciothe);
        //rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){});

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radSec:
                        Cats="Security";
                        break;
                    case R.id.radAgric:
                        Cats="Agriculture";
                        break;
                    case R.id.radDev:
                        Cats="Development";
                        break;
                    case R.id.radRep:
                        Cats="Report";
                        break;
                    case R.id.radComm:
                        Cats="Comment";
                        break;
                    case R.id.radAnon:
                        Cats="Anonymous";
                        break;
                }
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fmm=getFragmentManager();
                FragmentTransaction fts=fmm.beginTransaction();
                Infos npl=new Infos();

                Bundle bud=new Bundle();
                bud.putString("Cates",Cats);
                npl.setArguments(bud);

                fts.replace(R.id.Bass,npl);
                fts.addToBackStack(null);
                fts.commit();
            }
        });
        return vrw;
    }

}
