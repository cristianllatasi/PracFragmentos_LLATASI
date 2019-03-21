package com.example.bepis01.laboratoriofragmento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
implements  TituloFragment.OnTituloSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null){

            //preguntas si es que viene de un estado anterior
            if(savedInstanceState == null){

                TituloFragment tituloFragment = new TituloFragment();
                tituloFragment.setArguments(getIntent().getExtras());

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container,tituloFragment)
                        .addToBackStack(null)
                        .commit();

            }



        }



    }

    @Override
    public void onTitutloSelected(int position) {
        ParrafoFragment parrafoFragment =
                (ParrafoFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_parrafo);
        if (parrafoFragment != null) {
            parrafoFragment.updateParrafoView(position);
        }else{
            ParrafoFragment nuevoFragmento = new ParrafoFragment();

            Bundle args = new Bundle();
            args.putInt(ParrafoFragment.ARG_POSITION,position);
            nuevoFragmento.setArguments(args);


            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,nuevoFragmento)
                    .addToBackStack(null)
                    .commit();

        }
    }
}
