//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//                                         MIS LUGARES                                           //
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

package com.example.mislugares1.casos_uso;

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------IMPORTS-----------------------------------------------//

import android.app.Activity;
import android.content.Intent;

import com.example.mislugares1.datos.RepositorioLugares;
import com.example.mislugares1.presentacion.VistaLugarActivity;

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//                                      CASOS USO LUGAR                                          //
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

public class CasosUsoLugar {

//-----------------------------------------------------------------------------------------------//
//-------------------------------------------ATRIBUTOS-------------------------------------------//

    private Activity actividad;
    private RepositorioLugares lugares;

//-----------------------------------------------------------------------------------------------//
//-------------------------------------------MÉTODOS---------------------------------------------//

    public CasosUsoLugar(Activity actividad, RepositorioLugares lugares) {
        this.actividad = actividad;
        this.lugares = lugares;
    }

    // OPERACIONES BÁSICAS
    public void mostrar(int pos) {
        Intent i = new Intent(actividad, VistaLugarActivity.class);
        i.putExtra("pos", pos);
        actividad.startActivity(i);
    }

    public void borrar(int id) {
        lugares.borrar(id);
        actividad.finish();
    }
}