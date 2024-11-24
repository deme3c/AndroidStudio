package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos = new ArrayList<>();

    Contacto c1 = new Contacto("Pepessss", "123456789", "peassasaaspe@gmail.com");
    Contacto c2 = new Contacto("Juan", "123456789", "juan@gmail.com");
    Contacto c3 = new Contacto("Maria", "123456789", "maria@gmail.com");
    Contacto c4 = new Contacto("Ana", "123456789", "ana@gmail.com");
    Contacto c5 = new Contacto("Luis", "123456789", "luis@gmail.com");
    Contacto c6 = new Contacto("Pedro", "123456789", "pedro@gmail.com");
    Contacto c7 = new Contacto("Pablo", "123456789", "pablo@gmail.com");
    Contacto c8 = new Contacto("Sara", "123456789", "sara@gmail.com");
    Contacto c9 = new Contacto("Federico", "123456789", "luis@gmail.com");
    Contacto c10 = new Contacto("Fernando", "123456789", "pedro@gmail.com");
    Contacto c11 = new Contacto("Sofía", "123456789", "pablo@gmail.com");
    Contacto c12 = new Contacto("Estela", "123456789", "sara@gmail.com");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos.add(c1);
        contactos.add(c2);
        contactos.add(c3);
        contactos.add(c4);
        contactos.add(c5);
        contactos.add(c6);
        contactos.add(c7);
        contactos.add(c8);
        contactos.add(c9);
        contactos.add(c10);
        contactos.add(c11);
        contactos.add(c12);



        Button b_buscar = findViewById(R.id.b_buscar);
        Button b_anadir = findViewById(R.id.b_anadir);
        Button b_eliminar = findViewById(R.id.b_eliminar);
        Button b_modificar = findViewById(R.id.b_editar);


        b_buscar.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity.this, MostrarContactos.class);
            intent1.putExtra("contactos", contactos);
            startActivity(intent1);

        });

        b_anadir.setOnClickListener(v -> {

        });

        b_eliminar.setOnClickListener(v -> {

        });

        b_modificar.setOnClickListener(v -> {

        });



    }
}