package com.tallercmovil.ejercicio2.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.tallercmovil.ejercicio2.R;


public class Pelicula implements Parcelable {

    public int id;
    public String titulo;
    public Genero genero;
    public int anio;
    public static Genero[] generos={
            new Genero("Animación", R.drawable.comedia),
            new Genero ("Acción", R.drawable.comedia),
            new Genero ("Acción", R.drawable.comedia),
            new Genero ("Acción", R.drawable.comedia),
            new Genero ("Acción", R.drawable.comedia),
            new Genero ("Acción", R.drawable.comedia),
            new Genero ("Acción", R.drawable.comedia)




    };


    public Pelicula(int id, String titulo, Genero genero, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anio = anio;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public int getAnio() {
        return this.anio;
    }

    protected Pelicula(Parcel in) {
        id = in.readInt();
        titulo = in.readString();
        anio = in.readInt();
        genero = in.readParcelable(Genero.class.getClassLoader());
    }

    public static final Creator<Pelicula> CREATOR = new Creator<Pelicula>() {
        @Override
        public Pelicula createFromParcel(Parcel in) {
            return new Pelicula(in);
        }

        @Override
        public Pelicula[] newArray(int size) {
            return new Pelicula[size];
        }
    };

    @NonNull
    @Override
    public String toString() {

        return this.titulo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(titulo);
        dest.writeInt(anio);
        dest.writeParcelable(genero, flags);

    }
}
