package com.example.bepis01.laboratoriofragmento;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ParrafoFragment extends Fragment {

    final static String ARG_POSITION= "position";
    int mCurrentPosition = -1;



    public void updateParrafoView (int position){
        TextView parrafo = (TextView) getActivity().findViewById(R.id.txt_parrafo);
        parrafo.setText(Contenido.Parrafos[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle args = getArguments();
        if(args != null){
            updateParrafoView(args.getInt(ARG_POSITION));
        }else if (mCurrentPosition != -1){
            updateParrafoView(mCurrentPosition);
        }
    }


    // metodo que se debe utilizar cuando se va destruir un coponente, se almacena y se recupera en el onstart

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_POSITION,mCurrentPosition);
    }



    @Override
    public View onCreateView(LayoutInflater layoutInflater,
                             ViewGroup viewGroup,
                             Bundle savedInstanceState){

        return layoutInflater.inflate(R.layout.fragment_parrafo,
                viewGroup, false);


    }
}
