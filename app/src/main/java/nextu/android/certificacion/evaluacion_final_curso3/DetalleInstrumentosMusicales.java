package nextu.android.certificacion.evaluacion_final_curso3;

import android.support.v4.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Macbook on 17/11/16.
 */

public class DetalleInstrumentosMusicales extends Fragment{

    private static final String key_position = "posicion";

    String titulo_fragment = "Instrumentos Musicales";

    private int posicionActual = -1;

    public static DetalleInstrumentosMusicales getInstance(int posicion){
        DetalleInstrumentosMusicales fragment = new DetalleInstrumentosMusicales();

        Bundle argumentos = new Bundle();
        argumentos.putInt(key_position,posicion);

        fragment.setArguments(argumentos);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(savedInstanceState != null){
            posicionActual = savedInstanceState.getInt(key_position);
        }

        return inflater.inflate(R.layout.detalle_instrumento, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle argumentos = getArguments();
        if(argumentos != null){

            actualizarVista(argumentos.getInt(key_position));

        }else if(posicionActual != -1){

            actualizarVista(posicionActual);

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(key_position,posicionActual);
    }

    public void actualizarVista(int posicion){

        String [] titulos = getResources().getStringArray(R.array.titulos_instrumentos_musicales);
        String [] descripciones = getResources().getStringArray(R.array.descripciones);

        getActivity().setTitle(titulos[posicion]);
        ((TextView) getActivity().findViewById(R.id.txt_descripcion)).setText(descripciones[posicion]);

        Drawable imagen1 = null;
        Drawable imagen2 = null;

        switch (posicion){
            case 0:
                imagen1 = ContextCompat.getDrawable(getActivity(),R.drawable.cuerda1);
                imagen2 = ContextCompat.getDrawable(getActivity(),R.drawable.cuerda2);
                break;
            case 1:
                imagen1 = ContextCompat.getDrawable(getActivity(),R.drawable.percusion1);
                imagen2 = ContextCompat.getDrawable(getActivity(),R.drawable.percusion2);
                break;
            case 2:
                imagen1 = ContextCompat.getDrawable(getActivity(),R.drawable.viento1);
                imagen2 = ContextCompat.getDrawable(getActivity(),R.drawable.viento2);
                break;
            case 3:
                imagen1 = ContextCompat.getDrawable(getActivity(),R.drawable.electrico1);
                imagen2 = ContextCompat.getDrawable(getActivity(),R.drawable.electrico2);
                break;
        }

        ((ImageView) getActivity().findViewById(R.id.image1)).setImageDrawable(imagen1);
        ((ImageView) getActivity().findViewById(R.id.image2)).setImageDrawable(imagen2);

    }

}
