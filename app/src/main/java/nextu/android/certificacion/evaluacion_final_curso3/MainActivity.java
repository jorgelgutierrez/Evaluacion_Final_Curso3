package nextu.android.certificacion.evaluacion_final_curso3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListaInstrumentosMusicales.InstrumentoSeleccionado{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.contenedor) != null){
            if(savedInstanceState != null)
                return;
            ListaInstrumentosMusicales fragment = new ListaInstrumentosMusicales();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor,fragment)
                    .commit();
        }
    }

    @Override
    public void instrumentoSeleccionado(int posicion) {
        DetalleInstrumentosMusicales fragment = (DetalleInstrumentosMusicales)getSupportFragmentManager().findFragmentById(R.id.fragment_detalle);
        if(fragment != null){
            fragment.actualizarVista(posicion);
        }else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenedor, DetalleInstrumentosMusicales.getInstance(posicion))
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void agregarFavoritos(View view){
        Toast.makeText(getApplicationContext(),"Instrumento añadido a tus favoritos",Toast.LENGTH_SHORT).show();

    }

    public void reproducirInstrumento(View view){
        Toast.makeText(getApplicationContext(),"Reproduciendo sonido del instrumento",Toast.LENGTH_SHORT).show();
    }
}
