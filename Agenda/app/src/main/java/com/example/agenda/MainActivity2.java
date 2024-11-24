package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<Persona> personas = (ArrayList<Persona>) getIntent().getSerializableExtra("PERSONAS");

        LinearLayout contenedor =findViewById(R.id.scroll);
        for(int i = 0; i<personas.size();i++){

            Button boton = new Button(this);
            boton.setText(personas.get(i).getNombre());
            boton.setTextSize(40);
            int finalI = i;
            boton.setOnClickListener(view -> {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                intent1.putExtra("NOMBRE", personas.get(finalI).getNombre());
                int telefono = personas.get(finalI).getTelefono();
                String telefonoS = ""+telefono;
                intent1.putExtra("TELEFONO", telefonoS);
                intent1.putExtra("CORREO", personas.get(finalI).getCorreo());
                startActivity(intent1);
            });
            contenedor.addView(boton);
        }


    }
}