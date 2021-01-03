package com.tallercmovil.ejercicio2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tallercmovil.ejercicio2.model.Pelicula;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    Context context;



    ArrayList<Pelicula> datos;

    private static LayoutInflater inflater = null;


    public Adaptador(Context context, ArrayList<Pelicula> datos) {
        this.context = context;
        this.datos = datos;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return datos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        @SuppressLint({"ViewHolder", "InflateParams"}) final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView tvTitulo = vista.findViewById(R.id.tvTitulo);
        TextView tvGenero = vista.findViewById(R.id.tvGenero);
        TextView tvAnio = vista.findViewById(R.id.tvAnio);
        ImageView imagen = vista.findViewById(R.id.imageView);

        tvTitulo.setText(datos.get(position).getTitulo());
        tvGenero.setText(datos.get(position).getGenero().toString());
        tvAnio.setText(String.valueOf(datos.get(position).getAnio()));
        imagen.setImageResource(datos.get(position).getGenero().imagen);






        return vista;

    }
}
