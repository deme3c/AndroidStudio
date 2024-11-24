package com.example.bbddcontactos;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(android.R.id.content);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pantalla inicial");
        }

        Button botonInsertar = findViewById(R.id.button);
        Button botonListar = findViewById(R.id.button4);


        botonInsertar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, InsertarContacto.class);
            startActivity(intent);
        });


        botonListar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ListadoContactos.class);
            startActivity(intent);
        });




        Spinner colorSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterAlo = ArrayAdapter.createFromResource(this, R.array.color_options, android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapterAlo);


        SharedPreferences sharedPreferences = getSharedPreferences("preferencias", MODE_PRIVATE);
        int colorInicial = sharedPreferences.getInt("numero_guardado", 0);

        setInitialColor(colorInicial);
        colorSpinner.setSelection(colorInicial);

        SharedPreferences.Editor editor = sharedPreferences.edit();


        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        rootView.setBackgroundColor(Color.WHITE);
                        editor.putInt("numero_guardado", 0);

                        break;
                    case 1: // Blanco
                        rootView.setBackgroundColor(Color.WHITE);
                        editor.putInt("numero_guardado", 1);

                        break;
                    case 2: // Azul Claro
                        rootView.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        editor.putInt("numero_guardado", 2);

                        break;
                    case 3: // Verde Claro
                        rootView.setBackgroundColor(getResources().getColor(R.color.verdeClaro));
                        editor.putInt("numero_guardado", 3);

                        break;
                }

                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No hace nada
            }
        });





    }


    private void setInitialColor(int colorInicial) {
        switch (colorInicial) {
            case 0:
                rootView.setBackgroundColor(Color.WHITE);
                break;
            case 1:
                rootView.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                rootView.setBackgroundColor(getResources().getColor(R.color.azulClaro));
                break;
            case 3:
                rootView.setBackgroundColor(getResources().getColor(R.color.verdeClaro));
                break;
        }
    }
}

