package com.ifsc.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

class DestinoAdapterRecyclerView extends RecyclerView.Adapter<DestinoAdapterRecyclerView.MyViewHolder> {
    Context mContext;
    int mResource;
    Destino[] mDataset;

    public DestinoAdapterRecyclerView(Context mContext, int mResource, Destino[] mDataset) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View convertView = layoutInflater.inflate(mResource,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(convertView);
        return myViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Destino destino = mDataset[position];
        NumberFormat nf = new DecimalFormat("#,###.00");

        holder.tvCodigo.setText(Integer.toString(destino.getCodigo()));
        holder.tvNome.setText(destino.getNome());
        holder.tvPreco.setText(nf.format (destino.getPreco()));
        holder.tvPrecoVenda.setText(nf.format (destino.getPreco_venda()));
        holder.imgView.setImageResource(destino.getImagem());
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvCodigo;
        TextView tvNome;
        TextView tvPreco;
        TextView tvPrecoVenda;
        ImageView imgView;

        public MyViewHolder(@NonNull View convertView) {
            super(convertView);
            tvCodigo = (TextView) convertView.findViewById(R.id.tvCodigo);
            tvNome = (TextView) convertView.findViewById(R.id.tvNome);
            tvPreco =  (TextView) convertView.findViewById(R.id.tvPreco);
            tvPrecoVenda =(TextView) convertView.findViewById(R.id.tvPrecoVenda);
            imgView = (ImageView) convertView.findViewById(R.id.imageView);
        }
    }
}