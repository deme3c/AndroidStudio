package com.example.bbddfer;

import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Spinner colorSpinner;
    private View rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Pantalla inicial");

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        // Recuperando el número
        int colorInicial = sharedPreferences.getInt("numero_guardado", 0);  // 0 es el valor por defecto si no se encuentra "numero_guardado"
        Log.d("MainActivity", "Recuperando posición: " + colorInicial);
        colorSpinner = findViewById(R.id.colorSpinner);
        rootLayout = findViewById(R.id.rootLayout);

        ArrayAdapter<CharSequence> adapterAlo = ArrayAdapter.createFromResource(this,
                R.array.color_options, R.layout.spinner_item);
        colorSpinner.setAdapter(adapterAlo);

        // Botón para Insertar Cliente
        findViewById(R.id.btnInsertar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        // Botón para Borrar Cliente
        findViewById(R.id.btnBorrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeleteActivity.class));
            }
        });

        // Botón para Buscar Cliente
        findViewById(R.id.btnBuscar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        findViewById(R.id.btnListado).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Log.d("MainActivity", "Seleccionado position 0");
                        switch (colorInicial) {
                            case 0: // Blanco
                                rootLayout.setBackgroundColor(Color.WHITE);
                                break;
                            case 1: // Blanco
                                rootLayout.setBackgroundColor(Color.WHITE);
                                break;
                            case 2: // Azul Claro
                                rootLayout.setBackgroundColor(Color.parseColor("#ADD8E6"));
                                break;
                            case 3: // Verde Claro
                                Log.d("MainActivity", "Seleccionado colorInicial 3");
                                rootLayout.setBackgroundColor(Color.parseColor("#90EE90"));
                                break;
                        }
                        break;
                    case 1: // Blanco
                        rootLayout.setBackgroundColor(Color.WHITE);
                        break;
                    case 2: // Azul Claro
                        rootLayout.setBackgroundColor(Color.parseColor("#ADD8E6"));
                        break;
                    case 3: // Verde Claro
                        rootLayout.setBackgroundColor(Color.parseColor("#90EE90"));
                        break;
                }

                if(position!=0) {
                    // Obteniendo una instancia de SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

                    // Editando las SharedPreferences
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    // Guardando el valor de la posición
                    myEdit.putInt("numero_guardado", position);

                    // Aplicando los cambios
                    myEdit.apply();

                    Log.d("MainActivity", "Guardando posición: " + position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }


}
