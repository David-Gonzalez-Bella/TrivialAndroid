package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Jugar extends AppCompatActivity {

    //public ArrayList<Pregunta> preguntas;
    public ArrayList<PreguntaImagen> preguntasImagen;
    public TextView enunciado;
    public RadioButton r1;
    public RadioButton r2;
    public RadioButton r3;
    public RadioButton r4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentoPregunta preguntaFragmento = new FragmentoPregunta();
        fragmentTransaction.replace(R.id.frameLayout, preguntaFragmento).addToBackStack("crow");
        fragmentTransaction.commit();
        //fragmentNumber = 2;


//        enunciado = findViewById(R.id.Enunciado);
//        r1 = findViewById(R.id.respuesta1);
//        r2 = findViewById(R.id.respuesta2);
//        r3 = findViewById(R.id.respuesta3);
//        r4 = findViewById(R.id.respuesta4);
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
//        preguntas = ListaPreguntas.INSTANCE.getPreguntas();
//
//        enunciado.setText(preguntas.get(0).getPregunta());
//        r1.setText(preguntas.get(0).getOpcion1());
//        r2.setText(preguntas.get(0).getOpcion2());
//        r3.setText(preguntas.get(0).getOpcion3());
//        r4.setText(preguntas.get(0).getOpcion4());
    }
}