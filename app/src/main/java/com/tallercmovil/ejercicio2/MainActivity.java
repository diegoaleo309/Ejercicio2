package com.tallercmovil.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tallercmovil.ejercicio2.model.Genero;
import com.tallercmovil.ejercicio2.model.Pelicula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class MainActivity extends AppCompatActivity  {


    /*
    *
    * FALTA: 1) poner unique id a cada pelicula
    *
    *
    *
    * */



    EditText etNombre, etAnio;
    Intent intent;
    Genero genero;
    Bundle bundle;
    ArrayList<Pelicula> peliculas;
    Spinner spinner;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        peliculas= new ArrayList<>();

        intent = new Intent(this, MainActivity2.class);
        bundle = new Bundle();

        ArrayList<Genero>  lista = new ArrayList<>();

        Collections.addAll(lista, Pelicula.generos);

        etNombre = findViewById(R.id.etNombre);
        etAnio = findViewById(R.id.etAnio);


         ArrayAdapter<Genero> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_list, lista);
         arrayAdapter.setDropDownViewResource( R.layout.spinner_list);
         spinner.setAdapter(arrayAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genero = (Genero)parent.getItemAtPosition(position);

            }
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });



    }

    public void agregarALista(View view) {




        if (validacion()) {

            UUID idOne = UUID.randomUUID();
            UUID idTwo = UUID.randomUUID();
            System.out.println("UUID One: " + idOne);
            System.out.println("UUID Two: " + idTwo);

            Pelicula p = new Pelicula(id++, etNombre.getText().toString(), genero, Integer.parseInt(etAnio.getText().toString()));
            peliculas.add(p);

            etNombre.setText("");
            etAnio.setText("");
            spinner.setSelection(0);

            Toast.makeText(getApplicationContext(), p.titulo + " agregado", Toast.LENGTH_LONG).show();


        }

    }

    public void verListado(View view) {

        if (peliculas.isEmpty()){

            Toast.makeText(getApplicationContext(), "No has agregado ninguna película", Toast.LENGTH_LONG).show();



        }

        else {

            bundle.putParcelableArrayList("peliculas", peliculas);
            intent.putExtras(bundle);


            startActivity(intent);

        }
    }



    public boolean validacion (){
        if (etNombre.getText().toString().equals("")){

            etNombre.setError("Se requiere un nombre");
            return false;

        }

        if (etAnio.getText().toString().equals("")){

            etAnio.setError("Se requiere año");
            return false;

        }

        else if (Integer.parseInt(etAnio.getText().toString() )< 1900 || Integer.parseInt(etAnio.getText().toString() )> 2021 ){

            etAnio.setError("Se requiere año válido");
            return false;


        }








        return true;
    }
}


/*
*
*
*   Ejercicio 2
    Realizar una aplicación con Android Studio que presente un listado dinámico de elementos.
    * Los elementos deberán ser capturados por el usuario en un formulario con validaciones,
    * permitiendo capturar tantos elementos como se deseen.

    El tipo de elementos será definido por ustedes sobre cualquier tema que le interese.

    Ejemplos:

    Automóviles
    Películas
    Videojuegos
    Deportes
    Artistas
    La aplicación deberá implementar una clase para el tipo de elementos, como se ha visto en
    * el taller con la clase Alumno o la clase Anime.

    El desarrollador puede definir la cantidad de detalles a capturar por cada elemento. Ejemplo:

    Para una película:

    ID (no se capturará, pero debe ser parte de cada elemento y diferente para cada uno)
    Título
    Género
    Año
    Calificación
    Por lo menos se deberán capturar 3 detalles (sin incluir el ID) y uno de ellos mediante
     un Spinner con opciones finitas y definidas.

    Ejemplo 1: Para la captura de automóviles, se puede capturar la marca con opciones definidas
    * como: Ford, Volkswagen, Nissan y Toyota.

    Ejemplo 2: Para la captura de películas, se puede capturar el género con opciones definidas como: Comedia, Terror, Drama, Romance y Animación.

    Así también, la aplicación deberá mostrar un botón para que al final se puedan desplegar
    todos los elementos dados de alta en otro Activity mediante un ListView o contenedor similar.

    Para lo anterior, se debe crear también un prototipo de celda personalizado con lo que el desarrollador considere necesario,
    * pero que tenga por lo menos un elemento de imagen (ImageView) que cambie con respecto a lo que el usuario capturó con el Spinner.
    * Ejemplo: para el caso de los automóviles pueden mostrar ahí el logo de la marca o en el caso
    * de las películas alguna imagen referente al género de cada película.

    Finalmente, al dar clic en algún elemento del listado se deberá mandar llamar un mensaje Toast que indique el ID del elemento seleccionado.
    * Ejemplo: “El elemento seleccionado tiene el ID: 2354”.

    Consideraciones adicionales:

    Se calificará que haya validaciones en todos los campos implementados.
    Se debe implementar una clase con las propiedades para el listado de elementos que hayan definido.
    Pueden agregar todos los elementos gráficos que deseen para hacer más llamativa la interfaz.
    El nivel de API mínimo será el 21.
    No deben existir recursos hardcodeados.
    Habrá puntos extra si le agregan persistencia o algún detalle adicional.


    El ejercicio es individual, por lo que tomen en cuenta que si encuentro ejercicios con sospecha
    * de ser copia de otros, los anularé.
    * La entrega se hará al subir toda la carpeta de su proyecto comprimida o al compartir en este
    * espacio la liga de la carpeta comprimida del proyecto
    * para ser descargada a través de un servicio de almacenamiento en la nube o en algún repositorio
    * público como GitHub. La fecha máxima de entrega será el día domingo 10 de enero de 2021 a las 23:59 hrs.

    Consideren por favor que la plataforma bloqueará las entregas después de esa fecha y hora.

    Saludos.
*
*
*
* */