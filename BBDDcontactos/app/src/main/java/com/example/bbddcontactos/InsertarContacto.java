package com.example.bbddcontactos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InsertarContacto extends AppCompatActivity {

    private DatabaseHelper dpHelper;
    private EditText nombreET, telefonoET, correoET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_contacto);

         dpHelper = new DatabaseHelper(this);

        nombreET = findViewById(R.id.editTextText);
        telefonoET = findViewById(R.id.editTextText2);
        correoET = findViewById(R.id.editTextText3);

        Button buttonGuardar = findViewById(R.id.button5);

        buttonGuardar.setOnClickListener(view -> {
            String nombre = nombreET.getText().toString();
            String telefono = telefonoET.getText().toString();
            String correo = correoET.getText().toString();

            SQLiteDatabase db = dpHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(DatabaseHelper.COLUMN_NOMBRE, nombre);
            values.put(DatabaseHelper.COLUMN_MOVIL, telefono);
            values.put(DatabaseHelper.COLUMN_EMAIL, correo);

            long result = db.insert(DatabaseHelper.TABLE_CLIENTES, null, values);

        });

    }
}