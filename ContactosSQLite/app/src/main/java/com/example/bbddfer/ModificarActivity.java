package com.example.bbddfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.widget.Toast;

public class ModificarActivity extends AppCompatActivity {

    TextView tvId;
    EditText etNombre;
    EditText etMovil;
    EditText etEmail;
    Button hechoBoton;
    private DatabaseHelper dbHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        getSupportActionBar().setTitle("Pantalla inicial");

        tvId = findViewById(R.id.tvId);
        etNombre = findViewById(R.id.tvNombre);
        etMovil = findViewById(R.id.tvMovil);
        etEmail = findViewById(R.id.tvEmail);
        hechoBoton = findViewById(R.id.modificar);
        dbHelper = new DatabaseHelper(this);

        Contacto c = (Contacto) getIntent().getSerializableExtra("contacto");

        int id = c.getId();

        tvId.setText("ID: " + id);
        etNombre.setText(c.getNombre());
        etMovil.setText(c.getMovil());
        etEmail.setText(c.getEmail());

        hechoBoton.setOnClickListener(v -> {

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.COLUMN_NOMBRE, etNombre.getText().toString());
            contentValues.put(DatabaseHelper.COLUMN_MOVIL, etMovil.getText().toString());
            contentValues.put(DatabaseHelper.COLUMN_EMAIL, etEmail.getText().toString());

            // Actualizar el registro con el ID específico
            int idParaModificar = id;
            int filasActualizadas = db.update(DatabaseHelper.TABLE_CLIENTES, contentValues, DatabaseHelper.COLUMN_ID + " = ?", new String[]{String.valueOf(idParaModificar)});

            if(filasActualizadas > 0) {
                Toast.makeText(this, "Contacto modificado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No se ha podido modificar", Toast.LENGTH_LONG).show();
            }

            // Siempre es buena práctica cerrar la base de datos después de usarla
            db.close();


        });

    }
}