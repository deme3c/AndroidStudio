package com.example.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Persona p1 = new Persona("Sofía", "sofia@gmail.com", 612345678);
        Persona p2 = new Persona("Carlos", "carlos@hotmail.com", 623456789);
        Persona p3 = new Persona("Lucía", "lucia@yahoo.com", 634567890);
        Persona p4 = new Persona("Miguel", "miguel@gmail.com", 645678901);
        Persona p5 = new Persona("Valeria", "valeria@hotmail.com", 656789012);
        Persona p6 = new Persona("Daniel", "daniel@gmail.com", 667890123);
        Persona p7 = new Persona("Alejandra", "alejandra@yahoo.com", 678901234);
        Persona p8 = new Persona("Pablo", "pablo@gmail.com", 689012345);
        Persona p9 = new Persona("Raquel", "raquel@hotmail.com", 691234567);
        Persona p10 = new Persona("Fernando", "fernando@yahoo.com", 602345678);
        Persona p11 = new Persona("Irene", "irene@gmail.com", 613456789);
        Persona p12 = new Persona("Oscar", "oscar@hotmail.com", 624567890);

        Button buscarB = findViewById(R.id.buscar);

        buscarB.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
            ArrayList<Persona> personas = new ArrayList<Persona>();
            personas.add(p1);
            personas.add(p2);
            personas.add(p3);
            personas.add(p4);
            personas.add(p5);
            personas.add(p6);
            personas.add(p7);
            personas.add(p8);
            personas.add(p9);
            personas.add(p10);
            personas.add(p11);
            personas.add(p12);
            intent1.putExtra("PERSONAS", personas);
            startActivity(intent1);
        });

    }
}