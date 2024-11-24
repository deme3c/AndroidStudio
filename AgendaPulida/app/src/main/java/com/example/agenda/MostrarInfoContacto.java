package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MostrarInfoContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_info_contacto);

        Contacto c = (Contacto) getIntent().getSerializableExtra("contacto");

        TextView tv_nombre = findViewById(R.id.tv_nombre);
        TextView tv_telefono = findViewById(R.id.tv_telefono);
        TextView tv_email = findViewById(R.id.tv_email);

        tv_nombre.setText("Nombre: " + c.nombre);
        tv_telefono.setText("Móvil: " +c.telefono);
        tv_email.setText("Email: " + c.email);




    }
}