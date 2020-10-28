package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados extends AppCompatActivity {

    public static MediaPlayer sonidoVictoria_snd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        sonidoVictoria_snd = MediaPlayer.create(this, R.raw.pantalla_resultados);
        TextView textoResultado = findViewById(R.id.textoResultado);
        textoResultado.setText(""+Jugar.acertadas);
        sonidoVictoria_snd.start();
    }

    public void EntrarMenuP(View v){
        finish();
        Intent menuPrincipal = new Intent(this, MenuPricipal.class); //Arrancar nueva actividad
        startActivity(menuPrincipal);
    }
}