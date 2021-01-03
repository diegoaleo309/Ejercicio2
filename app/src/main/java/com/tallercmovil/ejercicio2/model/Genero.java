package com.tallercmovil.ejercicio2.model;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class Genero implements Parcelable {



    public String nombreGenero;
    public int imagen;

    public Genero(String nombreGenero, int imagen) {
        this.nombreGenero = nombreGenero;
        this.imagen = imagen;
    }

    protected Genero(Parcel in) {
        nombreGenero = in.readString();

        imagen = in.readInt();
    }

    public static final Creator<Genero> CREATOR = new Creator<Genero>() {
        @Override
        public Genero createFromParcel(Parcel in) {
            return new Genero(in);
        }

        @Override
        public Genero[] newArray(int size) {
            return new Genero[size];
        }
    };

    @NonNull
    @Override
    public String toString() {

        return this.nombreGenero;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombreGenero);
        dest.writeInt(imagen);
    }
}
