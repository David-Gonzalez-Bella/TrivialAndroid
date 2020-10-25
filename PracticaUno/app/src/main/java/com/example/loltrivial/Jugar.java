package com.example.loltrivial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Jugar extends AppCompatActivity {


    // public ArrayList<PreguntaImagen> preguntasImagen;
    public static int preguntaId=0;
    FragmentoPregunta preguntaFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        CrearFragmentoTexto();


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
        if(!preguntaFragmento.r1.isChecked() && !preguntaFragmento.r2.isChecked() && !preguntaFragmento.r3.isChecked() && !preguntaFragmento.r4.isChecked()){
            Toast.makeText(this,"¡Selecciona una opción!",Toast.LENGTH_SHORT).show();
        }
        else {
            preguntaId++;
            CrearFragmentoTexto();
        }
    }

    private void CrearFragmentoTexto(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        preguntaFragmento = new FragmentoPregunta();
        fragmentTransaction.replace(R.id.marcoPregunta, preguntaFragmento).addToBackStack("preguntaTexto");
        fragmentTransaction.commit();
    }

    public void SalirMenuPrincipalAlerta(View v){
        //Crear el objeto alerta
        AlertDialog.Builder alerta = new AlertDialog.Builder(this); //Creamos una alerta
        alerta.setTitle("¿Quieres volver al menu principal?")
                .setMessage("Perderás el progreso actual")
                .setCancelable(false)
                .setPositiveButton("Si",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        //Crear la caja de alerta
        AlertDialog cajaAlerta  = alerta.create();
        cajaAlerta.show();
    }


}