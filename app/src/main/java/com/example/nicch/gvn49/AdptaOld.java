package com.example.nicch.gvn49;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nicch on 2/19/18.
 */

public class AdptaOld extends RecyclerView.Adapter<AdptaOld.ViewHolder> {

    private List<Listem> lisIts;
    private Context cnt;

    public AdptaOld(List<Listem> lisIts, Context cnt) {
        this.lisIts = lisIts;
        this.cnt = cnt;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vw= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.panolold,parent,false);
        return new ViewHolder(vw);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Listem lit=lisIts.get(position);
        holder.Ttl.setText("Contract Title - "+lit.getAA());
        holder.Pown.setText("Contract ID - "+lit.getBB());
        holder.Pstat.setText(lit.getDD()+" Kshs");
        holder.Ptyp.setText("Contract Duration (Wks)- "+lit.getCC());
        holder.Pdur.setText(lit.getEE());
    }

    @Override
    public int getItemCount() {
        return lisIts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Ttl,Pown,Pdur,Ptyp,Pstat,Pinp,Paut,Pobj;

        public RelativeLayout RelYt;

        public ViewHolder(View itemView) {
            super(itemView);

            Ttl=itemView.findViewById(R.id.PrTt);
            Pown=itemView.findViewById(R.id.PrOwn);
            Pdur=itemView.findViewById(R.id.PrObj);

            Ptyp=itemView.findViewById(R.id.PrDurTy);

            Pstat=itemView.findViewById(R.id.PrStat);
            Pinp=itemView.findViewById(R.id.PrExp);

            RelYt=(RelativeLayout) itemView.findViewById(R.id.belg);
        }
    }
}

