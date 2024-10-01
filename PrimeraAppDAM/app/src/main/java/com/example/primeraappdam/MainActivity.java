package com.example.primeraappdam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView tv1 = findViewById(R.id.texto1);
        tv1.setText("Hola España");

        Button bt1 = findViewById(R.id.boton1);
        bt1.setOnClickListener(v -> {tv1.setText("Boton pulsado");});

        EditText et1 = findViewById(R.id.texto1);
        String frase = et1.getText().toString();
        tv1.setText(frase);

    }
}