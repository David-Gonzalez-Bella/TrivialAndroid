package com.example.loltrivial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Jugar extends AppCompatActivity {

    public static ArrayList<Pregunta> preguntas;
    public static ArrayList<PreguntaImagen> preguntasImagen;
    public static ArrayList<PreguntaHibrida> preguntasMixtas;
    public static int preguntaId;
    public static int preguntaImagenId;
    public static int preguntaMixtaId;
    public static int elegida;
    public static int acertadas;
    public int preguntaActual;
    public int totalPreguntas;
    public boolean cuentaAtrasActiva;
    public TextView contadorPreguntas;
    public static MediaPlayer elegirRespuesta_snd;
    FragmentoPregunta preguntaFragmento;
    FragmentoPreguntaImagen preguntaImagenFragmento;
    FragmentoPreguntaMixta preguntaMixtaFragmento;

    public ProgressBar barraTiempo;
    public CountDownTimer cuentaAtras;
    public int tiempoTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        //Encontrar la referencia al control correspondiente
        contadorPreguntas = findViewById(R.id.contadorPreguntas);
        barraTiempo = findViewById(R.id.tiempo);

        //Inicializar
        preguntas = ListaPreguntas.INSTANCE.getPreguntas();
        preguntasImagen = ListaPreguntasImagen.INSTANCE.getPreguntasImagen();
        preguntasMixtas = ListaPreguntasHibridas.INSTANCE.getPreguntasHibridas();
        preguntaId= 0;
        preguntaImagenId = -1;
        preguntaMixtaId = -1;
        elegida = 0;
        acertadas = 0;
        preguntaActual = 1;
        elegirRespuesta_snd = MediaPlayer.create(this, R.raw.elegir_respuesta);
        totalPreguntas = preguntas.size() + preguntasImagen.size() + preguntasMixtas.size();
        contadorPreguntas.setText(preguntaActual + "/" + totalPreguntas);

        //Llamadas a metodos iniciales
        CrearBarraTiempo();
        CrearFragmentoTexto();
    }

    @Override
    public void onBackPressed() {
        SalirMenuPrincipalAlerta(null);
    }

    public void AvanzarPregunta(View v){
        //Determinamos el ultimo fragmento que se añadio a la pila (el fragmento actual)
        int indice = this.getSupportFragmentManager().getBackStackEntryCount() - 1;
        FragmentManager.BackStackEntry fragmentoActual = this.getSupportFragmentManager().getBackStackEntryAt(indice);

        //En funcion del tipo de fragmento, crearemos uno u otro a continuacion
        switch (fragmentoActual.getName()){
            case "preguntaTexto":
                if(v!= null && elegida == 0){
                    Toast.makeText(this,"¡Selecciona una opción!",Toast.LENGTH_SHORT).show();
                }else {
                    ComprobarCorrecta();
                    if(preguntaImagenId < 4){
                        preguntaImagenId++;
                        if(cuentaAtrasActiva){ cuentaAtras.cancel(); }
                        CrearFragmentoImagen();
                        CrearBarraTiempo();
                        contadorPreguntas.setText(++preguntaActual  + "/" + totalPreguntas);
                        elegida = 0; //La pregunta elegido al cambiar de pregunta sera, evidentemente, 0
                    }
                }
                break;
            case "preguntaImagen":
                if(v!= null && elegida == 0){
                    Toast.makeText(this,"¡Selecciona una imagen!",Toast.LENGTH_SHORT).show();
                }else {
                    ComprobarCorrectaImagen();
                    if(preguntaMixtaId < 4){
                        preguntaMixtaId++;
                        if(cuentaAtrasActiva){ cuentaAtras.cancel(); }
                        CrearFragmentoHibrido();
                        CrearBarraTiempo();
                        contadorPreguntas.setText(++preguntaActual  + "/" + totalPreguntas);
                        elegida = 0; //La pregunta elegido al cambiar de pregunta sera, evidentemente, 0
                    }
                }
                break;
            case "preguntaMixta":
                if(v!= null && elegida == 0){
                    Toast.makeText(this,"¡Selecciona una opción!",Toast.LENGTH_SHORT).show();
                }else {
                    ComprobarCorrectaHibrida();
                    if(preguntaId < 4){
                        preguntaId++;
                        if(cuentaAtrasActiva){ cuentaAtras.cancel(); }
                        CrearFragmentoTexto();
                        CrearBarraTiempo();
                        contadorPreguntas.setText(++preguntaActual  + "/" + totalPreguntas);
                        elegida = 0; //La pregunta elegido al cambiar de pregunta sera, evidentemente, 0
                    }else{
                        finish();
                        Intent menuResultados = new Intent(this, Resultados.class); //Vamos a la pantalla de resultados
                        startActivity(menuResultados);
                    }
                }
                break;
        }

//        if(fragmentoActual.getName() ==  "preguntaTexto"){
//            if(v!= null && elegida == 0){
//                Toast.makeText(this,"¡Selecciona una opción!",Toast.LENGTH_SHORT).show();
//            }else {
//                ComprobarCorrecta();
//                if(preguntaImagenId < 4){
//                    preguntaImagenId++;
//                    if(cuentaAtrasActiva){ cuentaAtras.cancel(); }
//                    CrearFragmentoImagen();
//                    CrearBarraTiempo();
//                    contadorPreguntas.setText(++preguntaActual  + "/" + totalPreguntas);
//                    elegida = 0; //La pregunta elegido al cambiar de pregunta sera, evidentemente, 0
//                }
//            }
//        }
//        else{
//            if(v!= null && elegida == 0){
//                Toast.makeText(this,"¡Selecciona una imagen!",Toast.LENGTH_SHORT).show();
//            }else {
//                ComprobarCorrectaImagen();
//                if(preguntaId < 4){
//                    preguntaId++;
//                    if(cuentaAtrasActiva){ cuentaAtras.cancel(); }
//                    CrearFragmentoTexto();
//                    CrearBarraTiempo();
//                    contadorPreguntas.setText(++preguntaActual  + "/" + totalPreguntas);
//                    elegida = 0; //La pregunta elegido al cambiar de pregunta sera, evidentemente, 0
//                }else{
//                    finish();
//                    Intent menuResultados = new Intent(this, Resultados.class); //Vamos a la pantalla de resultados
//                    startActivity(menuResultados);
//                }
//            }
//        }
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

    private void CrearFragmentoHibrido(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        preguntaMixtaFragmento = new FragmentoPreguntaMixta();
        fragmentTransaction.replace(R.id.marcoPregunta, preguntaMixtaFragmento).addToBackStack("preguntaMixta");
        fragmentTransaction.commit();
    }

    private void IrMenuPrincipal(){
        if(cuentaAtrasActiva){ cuentaAtras.cancel(); }
        finish();
        Intent menuPrincipal = new Intent(this, MenuPricipal.class);
        startActivity(menuPrincipal);
    }
    public void SalirMenuPrincipalAlerta(View v){
        //Crear el objeto alerta
        AlertDialog.Builder alerta = new AlertDialog.Builder(this); //Creamos una alerta
        alerta.setTitle("¿Quieres salir?")
                .setMessage("Perderás el progreso actual")
                .setCancelable(false)
                .setPositiveButton("Si",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        IrMenuPrincipal();
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

    public void ComprobarCorrectaHibrida(){
        if(preguntasMixtas.get(preguntaMixtaId).getCorrecta() == elegida){
            acertadas++;
        }
    }

    public void CrearBarraTiempo() {
        tiempoTotal = 100;
        barraTiempo.setProgress(tiempoTotal);
        cuentaAtras = new CountDownTimer(15000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished <= 14000) {
                    tiempoTotal -= 6.66667;
                    barraTiempo.setProgress(tiempoTotal);
                }
            }

            @Override
            public void onFinish() {
                barraTiempo.setProgress(0);
                cuentaAtrasActiva = false;
                AlertaFinDeTiempo();
            }
        };
        cuentaAtras.start();
        cuentaAtrasActiva = true;
    }

    public void AlertaFinDeTiempo(){
        //Crear el objeto alerta
        AlertDialog.Builder alerta = new AlertDialog.Builder(this); //Creamos una alerta
        alerta.setTitle("¡Se acabó el tiempo!")
                //.setMessage("")
                .setCancelable(false)
                .setPositiveButton("Ir a la siguiente pregunta",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AvanzarPregunta(null);
                    }
                });

        //Crear la caja de alerta
        AlertDialog cajaAlerta  = alerta.create();
        cajaAlerta.show();
    }
}