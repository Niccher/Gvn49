package com.example.nicch.gvn49;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by nicch on 4/2/18.
 */

public class Adpta extends RecyclerView.Adapter<Adpta.ViewHolder> {

    private List<List4> lisIts;
    private Context cnt;

    public Adpta(List<List4> lisIts, Context cnt) {
        this.lisIts = lisIts;
        this.cnt = cnt;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vw= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.repita,parent,false);
        return new ViewHolder(vw);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final List4 lit=lisIts.get(position);
        holder.PsDt.setText(lit.getAA());
        holder.PsCat.setText(lit.getBB());
        holder.PsMsgHed.setText(lit.getCC());
        holder.PsMsgVw.setText(lit.getDD());
    }

    @Override
    public int getItemCount() {
        return lisIts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView PsDt,PsCat,PsMsgHed,PsMsgVw;

        public RelativeLayout RelYt;

        public ViewHolder(View itemView) {
            super(itemView);

            PsDt=itemView.findViewById(R.id.txDate);
            PsCat=itemView.findViewById(R.id.txCat);
            PsMsgHed=itemView.findViewById(R.id.edMesg);

            PsMsgHed.setEnabled(Boolean.FALSE);

            PsMsgVw=itemView.findViewById(R.id.etVw);

            RelYt=(RelativeLayout) itemView.findViewById(R.id.RepBod);
        }
    }
}
