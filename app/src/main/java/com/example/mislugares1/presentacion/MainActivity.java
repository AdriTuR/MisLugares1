//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//                                         MIS LUGARES                                           //
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

package com.example.mislugares1.presentacion;

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------IMPORTS-----------------------------------------------//

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mislugares1.R;
import com.example.mislugares1.casos_uso.CasosUsoLugar;
import com.example.mislugares1.databinding.ActivityMainBinding;
import com.example.mislugares1.datos.RepositorioLugares;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//                                        MAIN ACTIVITY                                          //
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

public class MainActivity extends AppCompatActivity {

//-----------------------------------------------------------------------------------------------//
//-------------------------------------------ATRIBUTOS-------------------------------------------//

    private ActivityMainBinding binding;
    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//


//-----------------------------------------------------------------------------------------------//
//-------------------------------------------ONCREATE--------------------------------------------//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());


        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //--------------------CASOS USO LUGAR-----------------------//
        lugares = ((Aplicacion) getApplication()).lugares;
        usoLugar = new CasosUsoLugar(this, lugares);
    }

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

//-----------------------------------------------------------------------------------------------//
//-------------------------------------------MÉTODOS---------------------------------------------//

//------------------------------------------------------------------//
//-----------------------OnCreateOptionsMenu------------------------//

@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//------------------------------------------------------------------//
//----------------------OnOptionsItemSelected-----------------------//

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        if (id == R.id.acercaDe) {
            lanzarAcercaDe(null);
            return true;
        }

        if (id == R.id.menu_buscar) {
            lanzarVistaLugar(null);
            return true;
        }





        return super.onOptionsItemSelected(item);
    }

//------------------------------------------------------------------//
//-------------------------LanzarAcercaDe---------------------------//

    public void lanzarAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        startActivity(i);
    }

//------------------------------------------------------------------//
//-------------------------LanzarAcercaDe---------------------------//

    public void lanzarVistaLugar(View view){
        final EditText entrada = new EditText(this);
        entrada.setText("0");
        new AlertDialog.Builder(this)
                .setTitle("Selección de lugar")
                .setMessage("indica su id:")
                .setView(entrada)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        int id = Integer.parseInt(entrada.getText().toString());
                        usoLugar.mostrar(id);
                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }

//------------------------------------------------------------------//
//-------------------------LanzarAcercaDe---------------------------//

    public void lanzarPreferencias(View view){
        Intent i = new Intent(this, PreferenciasActivity.class);
        startActivity(i);
    }

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

}

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
