package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Jugar extends AppCompatActivity {


    // public ArrayList<PreguntaImagen> preguntasImagen;
    public static int preguntaId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentoPregunta preguntaFragmento = new FragmentoPregunta();
        fragmentTransaction.replace(R.id.marcoPregunta, preguntaFragmento).addToBackStack("preguntaTexto");
        fragmentTransaction.commit();


// fragmentNumber = 2;


//
//        preguntasImagen = ListaPreguntasImagen.INSTANCE.getPreguntasImagen();
//
//        enunciado.setText(preguntasImagen.get(0).getPregunta());
//        r1.setText(preguntasImagen.get(0).getOpcion1());
//        r2.setText(preguntasImagen.get(0).getOpcion2());
//        r3.setText(preguntasImagen.get(0).getOpcion3());
//        r4.setText(preguntasImagen.get(0).getOpcion4());


//        enunciado = findViewById(R.id.Enunciado);
//        r1 = findViewById(R.id.respuesta1);
//        r2 = findViewById(R.id.respuesta2);
//        r3 = findViewById(R.id.respuesta3);
//        r4 = findViewById(R.id.respuesta4);
//
//
    }

    public void AvanzarPregunta(View v){
        preguntaId++;
    }
}