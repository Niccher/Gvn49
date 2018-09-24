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
public class OldPost extends Fragment {

    private RecyclerView rcVw;
    private  RecyclerView.Adapter RcVwAd;

    private List<Listem> listITs;


    public OldPost() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.frag_oldpost, container, false);
        View rutv= inflater.inflate(R.layout.frag_oldpost, container, false);

        rcVw =rutv.findViewById(R.id.MyDropa);
        rcVw.setHasFixedSize(true);
        rcVw.setLayoutManager(new LinearLayoutManager(getContext()));

        listITs=new ArrayList<>();

        for (int i=0;i<=20;i++){
            Listem lit=new Listem(
                    "Element Count "+ (i+1),
                    "Label Next ",
                    "Hahah","One","Two","Three"
            );

            listITs.add(lit);
        }

        RcVwAd =new AdptaOld(listITs,getContext());

        rcVw.setAdapter(RcVwAd);

        return rutv;
    }

}
