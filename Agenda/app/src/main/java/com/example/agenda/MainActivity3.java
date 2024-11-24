package com.example.agenda;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        String nombre = getIntent().getStringExtra("NOMBRE");
        String telefono = getIntent().getStringExtra("TELEFONO");
        String correo = getIntent().getStringExtra("CORREO");

        TextView nombreE = findViewById(R.id.nombreT);
        TextView telefonoE = findViewById(R.id.telefonoT);
        TextView correoE = findViewById(R.id.correoT);
        nombreE.setText(nombre);
        telefonoE.setText(telefono);
        correoE.setText(correo);


    }
}