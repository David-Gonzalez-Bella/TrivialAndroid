package com.example.loltrivial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Jugar extends AppCompatActivity {

    public static ArrayList<Pregunta> preguntas;
    public static ArrayList<PreguntaImagen> preguntasImagen;
    public static int preguntaId = -1;
    public static int preguntaImagenId = -1;
    public static int elegida = 0;
    public static int acertadas = 0;
    FragmentoPregunta preguntaFragmento;
    FragmentoPreguntaImagen preguntaImagenFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        preguntas = ListaPreguntas.INSTANCE.getPreguntas();
        preguntasImagen = ListaPreguntasImagen.INSTANCE.getPreguntasImagen();
        preguntaId++;
        CrearFragmentoTexto();
    }

    public void AvanzarPregunta(View v){
        //Determinamos el ultimo fragmento que se añadio a la pila (el fragmento actual)
        int indice = this.getSupportFragmentManager().getBackStackEntryCount() - 1;
        FragmentManager.BackStackEntry fragmentoActual = this.getSupportFragmentManager().getBackStackEntryAt(indice);//(FragmentManager.BackStackEntry) getFragmentManager().getBackStackEntryAt(indice);

        //En funcion del tipo de fragmento, crearemos uno u otro a continuacion
        if(fragmentoActual.getName() ==  "preguntaTexto"){
            if(elegida == 0){
                Toast.makeText(this,"¡Selecciona una opción!",Toast.LENGTH_SHORT).show();
            }else {
                ComprobarCorrecta();
                if(preguntaImagenId < 4){
                    preguntaImagenId++;
                    CrearFragmentoImagen();
                    elegida = 0; //La pregunta elegido al cambiar de pregunta sera, evidentemente, 0
                }
            }
        }
        else{
            if(elegida == 0){
                Toast.makeText(this,"¡Selecciona una imagen!",Toast.LENGTH_SHORT).show();
            }else {
                ComprobarCorrectaImagen();
                if(preguntaId < 4){
                    preguntaId++;
                    CrearFragmentoTexto();
                    elegida = 0; //La pregunta elegido al cambiar de pregunta sera, evidentemente, 0
                }else{
                    Intent menuResultados = new Intent(this, Resultados.class); //Vamos a la pantalla de resultados
                    startActivity(menuResultados);
                }
            }
        }
    }

    private void CrearFragmentoTexto(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        preguntaFragmento = new FragmentoPregunta();
        fragmentTransaction.replace(R.id.marcoPregunta, preguntaFragmento).addToBackStack("preguntaTexto");
        fragmentTransaction.commit();
    }

    private void CrearFragmentoImagen(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        preguntaImagenFragmento = new FragmentoPreguntaImagen();
        fragmentTransaction.replace(R.id.marcoPregunta, preguntaImagenFragmento).addToBackStack("preguntaImagen");
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

    public void ComprobarCorrecta(){
        if(preguntas.get(preguntaId).getCorrecta() == elegida){
            acertadas++;
        }
    }

    public void ComprobarCorrectaImagen(){
        if(preguntasImagen.get(preguntaImagenId).getCorrecta() == elegida){
            acertadas++;
        }
    }
}