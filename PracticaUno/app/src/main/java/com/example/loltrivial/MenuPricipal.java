package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPricipal extends AppCompatActivity {
    public TextView nickUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pricipal);
        nickUsuario = findViewById(R.id.CampoUsuario);
        nickUsuario.setText(LogIn.nombreUsuario.getText());
        nickUsuario.setPaintFlags(0);
    }

    public void EntrarPartida(View v){

        Intent menuJugar = new Intent(this, Jugar.class); //Arrancar nueva actividad
        startActivity(menuJugar);
    }

    public void EntrarCategoria(View v){

        Intent menuCategoria = new Intent(this, Categoria.class); //Arrancar nueva actividad
        startActivity(menuCategoria);
    }

    public void EntrarAjustes(View v){
        Intent menuAjustes = new Intent(this, Ajustes.class); //Arrancar nueva actividad
        startActivity(menuAjustes);
    }


}