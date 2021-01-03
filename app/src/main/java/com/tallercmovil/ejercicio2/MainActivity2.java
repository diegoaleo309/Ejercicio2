package com.tallercmovil.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.tallercmovil.ejercicio2.model.Pelicula;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        ArrayList<Pelicula> datos= bundle.getParcelableArrayList("peliculas");


        ListView lv = findViewById(R.id.lv);





        System.out.println(datos.get(0).genero);

        Adaptador adaptador = new  Adaptador(this, datos);

        lv.setAdapter(adaptador);

        lv.setOnItemClickListener((adapterView, view, position, id) -> {
            Toast.makeText(MainActivity2.this, "Se eligio el elemento con id " + id, Toast.LENGTH_SHORT).show();
            //Pelicula p = (Pelicula) adapterView.getAdapter().getItem((int) id);
        });



    }
}

