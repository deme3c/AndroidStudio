package com.example.bbddfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MostrarContactoActivity extends AppCompatActivity {

    TextView tvId;
    TextView tvNombre;
    TextView tvMovil;
    TextView tvEmail;
    Button elBoton;
    Button modBoton;

    private DatabaseHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contacto);

        getSupportActionBar().setTitle("Pantalla inicial");

        tvId = findViewById(R.id.tvId);
        tvNombre = findViewById(R.id.tvNombre);
        tvMovil = findViewById(R.id.tvMovil);
        tvEmail = findViewById(R.id.tvEmail);
        elBoton = findViewById(R.id.eliminar);
        modBoton = findViewById(R.id.modificar);
        dbHelper = new DatabaseHelper(this);


        Contacto c = (Contacto) getIntent().getSerializableExtra("contacto");

        int id = c.getId();

        tvId.setText("ID: " + id);
        tvNombre.setText("Nombre: " + c.getNombre());
        tvMovil.setText("Móvil: " + c.getMovil());
        tvEmail.setText("Email: " + c.getEmail());


        elBoton.setOnClickListener(v -> {

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            int rowsDeleted = db.delete(DatabaseHelper.TABLE_CLIENTES, DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(id)});

            if (rowsDeleted > 0) {
                Toast.makeText(this, "Contacto borrado", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Error al borrar contacto", Toast.LENGTH_LONG).show();
            }

            Intent  intent = new Intent(this, ListActivity.class);
            startActivity(intent);

        });

        modBoton.setOnClickListener(v -> {

            Intent  intent = new Intent(this, ModificarActivity.class);
            intent.putExtra("contacto", c);
            startActivity(intent);

        });

    }
}