package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView nombre, apellido, sexo, aficiones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        sexo = findViewById(R.id.sexo);
        aficiones = findViewById(R.id.aficiones);



        nombre.setText(getIntent().getStringExtra("NOMBRE"));
        apellido.setText(getIntent().getStringExtra("apellido"));
        sexo.setText(getIntent().getStringExtra("sexo"));
        aficiones.setText(getIntent().getStringExtra("aficiones"));

    }
}