package com.example.loltrivial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MenuPricipal extends AppCompatActivity {
    public EditText nickUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pricipal);
        nickUsuario = findViewById(R.id.CampoUsuario);
        nickUsuario.setText(LogIn.nombreUsuario.getText());
    }
}