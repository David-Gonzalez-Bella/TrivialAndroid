package com.example.loltrivial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPricipal extends AppCompatActivity implements View.OnClickListener{
    public TextView nickUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pricipal);
        nickUsuario = findViewById(R.id.CampoUsuario);
        nickUsuario.setText(LogIn.nombreUsuario.getText());
        nickUsuario.setPaintFlags(0);
    }

    public void onClick(View v){

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

    public void SalirAlerta(View v){
        //Crear el objeto alerta
        AlertDialog.Builder alerta = new AlertDialog.Builder(this); //Creamos una alerta
        alerta.setTitle("¿Quieres salir?")
                .setMessage("Volveras a la pantalla inicial")
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