package com.example.loltrivial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Ajustes extends AppCompatActivity {

    private AudioManager audioManager;
    private SeekBar barraVolumen;
    private Switch cambiarModo;
    public ConstraintLayout fondo;
    public static boolean fondoOscuro = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        fondo = findViewById(R.id.fondoLayout);
        barraVolumen = findViewById(R.id.barraVolumen);
        cambiarModo = findViewById(R.id.cambiarModo);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        //Llamadas iniciales
        if(Ajustes.fondoOscuro)
        {
            cambiarModo.setText("Oscuro");
            fondo.setBackgroundResource(R.drawable.fondomenuprincipal);
        }else{
            cambiarModo.setText("Claro");
            fondo.setBackgroundResource(R.drawable.fondomenuprincipalclaro);
        }
        SeekBarFunction();
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogIn.mediaPlayer.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        LogIn.mediaPlayer.start();
    }

    @Override
    public void onBackPressed() {
        SalirMenuPrincipalAlerta(null);
    }

    public void SeekBarFunction(){

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        barraVolumen.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        barraVolumen.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        barraVolumen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void CambiarTema(View v){
        fondoOscuro = !fondoOscuro;
        if(fondoOscuro){
            cambiarModo.setText("Oscuro");
            fondo.setBackgroundResource(R.drawable.fondomenuprincipal);
        }else{
            cambiarModo.setText("Claro");
            fondo.setBackgroundResource(R.drawable.fondomenuprincipalclaro);
        }
    }

    private void IrMenuPrincipal(){
        Intent menuPrincipal = new Intent(this, MenuPricipal.class);
        menuPrincipal.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(menuPrincipal);
        finish();
    }

    public void SalirMenuPrincipalAlerta(View v){
        //Crear el objeto alerta
        AlertDialog.Builder alerta = new AlertDialog.Builder(this); //Creamos una alerta
        alerta.setTitle("¿Quieres salir?")
                .setMessage("Volverás al menú principal")
                .setCancelable(false)
                .setPositiveButton("Sí",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        IrMenuPrincipal();
                    }
                })
                .setNegativeButton("No",  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        //PantallaCompleta();
                    }
                });

        //Crear la caja de alerta
        AlertDialog cajaAlerta  = alerta.create();
        cajaAlerta.show();
    }
}