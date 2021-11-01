//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//                                         MIS LUGARES                                           //
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

package com.example.mislugares1.presentacion;

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------IMPORTS-----------------------------------------------//

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mislugares1.R;
import com.example.mislugares1.databinding.ActivityMainBinding;
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

        return super.onOptionsItemSelected(item);
    }

//------------------------------------------------------------------//
//-------------------------LanzarAcercaDe---------------------------//

    public void lanzarAcercaDe(View view){
        Intent i = new Intent(this, AcercaDeActivity.class);
        startActivity(i);
    }

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//

}

//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------//
