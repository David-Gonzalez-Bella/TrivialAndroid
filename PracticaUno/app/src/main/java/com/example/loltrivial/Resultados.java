package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView textoResultado = findViewById(R.id.textoResultado);
        textoResultado.setText(""+Jugar.acertadas);
    }

    public void EntrarMenuP(View v){
        Intent menuPrincipal = new Intent(this, MenuPricipal.class); //Arrancar nueva actividad
        startActivity(menuPrincipal);
    }
}