package com.example.bepis01.laboratoriofragmento;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TituloFragment extends ListFragment {


    OnTituloSelectedListener mCallBlack;

    public TituloFragment() {
        // Required empty public constructor



    }

    @Override
    public void onListItemClick(ListView listView,
                                View view,
                                int position,
                                long id){
        mCallBlack.onTitutloSelected(position);
        getListView().setItemChecked(position, true);

    }



    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            Activity activity=(Activity)context;
            mCallBlack = (OnTituloSelectedListener) activity;
        }catch (ClassCastException e) {
            throw  new ClassCastException(getActivity()
                    .toString() + "debe implementar la interface" +
                    " OnTituloSelectedListener");


        }
    }


        public interface OnTituloSelectedListener{
        public void onTitutloSelected(int position);

    }

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                Contenido.Titulos));
    }

    @Override
    public void onStart(){
        super.onStart();

        if (getFragmentManager().findFragmentById(R.id.fragment_parrafo)
                != null) {

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_titulo, container, false);
    }

}
