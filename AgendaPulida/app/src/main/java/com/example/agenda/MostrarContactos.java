package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class MostrarContactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contactos);

        ArrayList<Contacto> contactos  = (ArrayList<Contacto>) getIntent().getSerializableExtra("contactos");

        Log.d("VALOR CONTACTOS 0", contactos.get(0).nombre);

        LinearLayout contenedor = findViewById(R.id.contenedor);

        for (int i = 0; i < contactos.size(); i++) {
            Contacto c = contactos.get(i);
            Log.d("VALOR CONTACTOS", c.nombre);
            Button button = new Button(this);
            button.setText(c.nombre);
            button.setTextSize(40);
            button.setOnClickListener(v -> {
                Intent intent1 = new Intent(MostrarContactos.this, MostrarInfoContacto.class);
                intent1.putExtra("contacto", c);
                startActivity(intent1);
            });

            // Agrega el botón al contenedor
            contenedor.addView(button);

        }





    }
}