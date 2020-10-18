package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    //Variables globales
    public static EditText nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreUsuario = findViewById(R.id.CampoNombre);
    }

    public void EntrarMenuPricipal(View v){
        if(nombreUsuario.getText().toString().isEmpty()){
            Toast.makeText(this,"Nombre vacío",Toast.LENGTH_SHORT).show();
            return;
        }else if (nombreUsuario.getText().toString().length() > 12 ){
            Toast.makeText(this,"Nombre demasiado largo",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent menuPrincipal = new Intent(this, MenuPricipal.class); //Arrancar nueva actividad
        startActivity(menuPrincipal);
    }

    public void WebIcon(View v){
        String url;
        if(v.getId() == R.id.Icono){
            url = "https://www.artstation.com/sainny";
        }else{
            url = "https://kakugames.itch.io/";
        }
        Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(web);
    }
}