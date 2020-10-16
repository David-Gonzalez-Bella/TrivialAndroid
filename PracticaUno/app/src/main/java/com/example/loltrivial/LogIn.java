package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    //Variables globales
    public EditText nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreUsuario = findViewById(R.id.CampoNombre);
    }

    public void EntrarMenuPricipal(View v){
        Intent menuPrincipal = new Intent(this, MenuPricipal.class); //Arrancar nueva actividad
        startActivity(menuPrincipal);
    }

    public void WebIcon(View v){
        String url;
        if(v.getId() == R.id.SainnyLogo){
            url = "https://www.artstation.com/sainny";
        }else{
            url = "https://kakugames.itch.io/";
        }
        Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(web);
    }
}