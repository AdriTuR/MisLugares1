package com.example.mislugares1.presentacion;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mislugares1.R;
import com.example.mislugares1.casos_uso.CasosUsoLugar;
import com.example.mislugares1.databinding.VistaLugarBinding;
import com.example.mislugares1.datos.RepositorioLugares;
import com.example.mislugares1.modelo.Lugar;

import java.text.DateFormat;
import java.util.Date;

public class VistaLugarActivity extends AppCompatActivity {
    private RepositorioLugares lugares;
    private CasosUsoLugar usoLugar;
    private int pos;
    private Lugar lugar;
    private VistaLugarBinding binding;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = VistaLugarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        lugares = ((Aplicacion) getApplication()).lugares;
        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos", 0);
        lugar = lugares.elemento(pos);
        usoLugar = new CasosUsoLugar(this, lugares);
        actualizaVistas();
    }
    public void actualizaVistas() {
        binding.nombre.setText(lugar.getNombre());
        binding.tipoLogo.setImageResource(lugar.getTipo().getRecurso());
        binding.tipo.setText(lugar.getTipo().getTexto());
        binding.direccion.setText(lugar.getDireccion());
        binding.telefono.setText(Integer.toString(lugar.getTelefono()));
        binding.url.setText(lugar.getUrl());
        binding.comentario.setText(lugar.getComentario());
        binding.fecha.setText(DateFormat.getDateInstance().format(
                new Date(lugar.getFecha())));
        binding.hora.setText(DateFormat.getTimeInstance().format(
                new Date(lugar.getFecha())));
        binding.valoracion.setRating(lugar.getValoracion());
        binding.valoracion.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override public void onRatingChanged(RatingBar ratingBar,
                                                          float valor, boolean fromUser) {
                        lugar.setValoracion(valor);
                    }
                });

        /*SPINNER*/
       /* ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, TipoLugar.getNombres());
        adaptador.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);
        binding.tipo.setAdapter(adaptador);
        binding.tipo.setSelection(lugar.getTipo().ordinal());*/

    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuracion, menu);
        return true;
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_compartir:
                return true;
            case R.id.accion_llegar:
                return true;
            case R.id.accion_editar:
                return true;
            case R.id.accion_borrar:
                usoLugar.borrar(pos);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

