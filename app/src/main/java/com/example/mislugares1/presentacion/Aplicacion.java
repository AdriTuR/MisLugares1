package com.example.mislugares1.presentacion;

import android.app.Application;

import com.example.mislugares1.LugaresLista;
import com.example.mislugares1.RepositorioLugares;

public class Aplicacion extends Application {

    public RepositorioLugares lugares = new LugaresLista();

    @Override public void onCreate() {
        super.onCreate();
    }
}
