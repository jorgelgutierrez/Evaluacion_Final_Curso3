package nextu.android.certificacion.evaluacion_final_curso3;

import android.support.v4.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class ListaInstrumentosMusicales extends ListFragment{

    private InstrumentoSeleccionado implementacion;

    public interface InstrumentoSeleccionado{
        void instrumentoSeleccionado(int posicion);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            implementacion = (InstrumentoSeleccionado) context;

        }catch(ClassCastException ex){
            throw  new ClassCastException(context.toString()
                    + "Falta la implementacion");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String [] lista_instrumentos_musicales = getResources().getStringArray(R.array.lista_instrumentos_musicales);

        setListAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, lista_instrumentos_musicales));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        implementacion.instrumentoSeleccionado(position);
        getListView().setItemChecked(position, true);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Instrumentos Musicales");
    }
}
