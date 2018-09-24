package com.example.nicch.gvn49;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sents extends Fragment {

    private RecyclerView rcVw;
    private  RecyclerView.Adapter RcVwAd;

    private List<List4> listITs;


    public Sents() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Vwr= inflater.inflate(R.layout.frag_sent, container, false);

        getActivity().setTitle("Sent Comments");

        rcVw =(RecyclerView) Vwr.findViewById(R.id.MyDropa);
        rcVw.setHasFixedSize(true);
        rcVw.setLayoutManager(new LinearLayoutManager(getContext()));

        listITs=new ArrayList<>();

        for (int i=0;i<=20;i++){
            List4 lit=new List4(
                    "Date () "+ (i+1),
                    "Category ()",
                    "Message Header Here ()","True"
            );

            listITs.add(lit);
            RcVwAd =new Adpta(listITs,getContext());
            rcVw.setAdapter(RcVwAd);
        }

        rcVw.setAdapter(RcVwAd);
        RcVwAd =new Adpta(listITs,getContext());

        return Vwr;
    }

}
