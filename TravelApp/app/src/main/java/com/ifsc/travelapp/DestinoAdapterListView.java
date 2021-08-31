package com.ifsc.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.zip.Inflater;

public class DestinoAdapterListView extends ArrayAdapter<Destino> {

    Context mContext;
    int mResource;

    public DestinoAdapterListView(@NonNull Context context, int resource, @NonNull Destino[] objects) {
        super(context, resource,  objects);
        mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);

        TextView tvCodigo = (TextView) convertView.findViewById(R.id.tvCodigo);
        TextView tvNome = (TextView) convertView.findViewById(R.id.tvNome);
        TextView tvPreco =  (TextView) convertView.findViewById(R.id.tvPreco);
        TextView tvPrecoVenda =(TextView) convertView.findViewById(R.id.tvPrecoVenda);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.imageView);

        Destino destino = getItem(position);

        NumberFormat nf = new DecimalFormat("#,###.00");

        tvCodigo.setText(Integer.toString(destino.getCodigo()));
        tvNome.setText(destino.getNome());
        tvPreco.setText(nf.format (destino.getPreco()));
        tvPrecoVenda.setText(nf.format (destino.getPreco_venda()));
        imgView.setImageResource(destino.getImagem());

        return convertView;
    }
}