package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView textoResultado = findViewById(R.id.textoResultado);
        textoResultado.setText("Preguntas Acertadas: " + Jugar.acertadas);
    }
}