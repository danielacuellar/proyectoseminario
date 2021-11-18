package com.example.idiomas;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<Lecciones> {

    Context context;

    public CustomListViewAdapter(Context context, int resourceId,
                                 List<Lecciones> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imgImagen;
        TextView txtNombreLeccion;
        TextView txtPorcentajeLeccion;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Lecciones rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fila_lecciones, null);
            holder = new ViewHolder();
            holder.txtNombreLeccion = (TextView) convertView.findViewById(R.id.txtNombreLeccion);
            holder.txtPorcentajeLeccion = (TextView) convertView.findViewById(R.id.txtPorcentajeLeccion);
            holder.imgImagen = (ImageView) convertView.findViewById(R.id.imgImagen);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.txtNombreLeccion.setText(rowItem.getNombre());
        holder.txtPorcentajeLeccion.setText(rowItem.getContador());
       holder.imgImagen.setImageResource(Integer.parseInt((rowItem.getImagen())));

        return convertView;
    }












}