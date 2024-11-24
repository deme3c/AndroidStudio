package com.example.bbddcontactos;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListadoContactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_contactos);


        DatabaseHelper dpHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dpHelper.getReadableDatabase();

        LinearLayout contenedorContactos = findViewById(R.id.contenedorContactos);

        Cursor cursor = db.query(
                DatabaseHelper.TABLE_CLIENTES,
                null,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            String nombre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE));
            String movil = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MOVIL));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));

            Button botonContacto = new Button(this);
            botonContacto.setText(nombre);
            botonContacto.setTextSize(20);


            botonContacto.setOnClickListener(view -> {
                Intent intent = new Intent(ListadoContactos.this, DetallesContacto.class);
                intent.putExtra("ID", id);
                intent.putExtra("NOMBRE", nombre);
                intent.putExtra("MOVIL", movil);
                intent.putExtra("EMAIL", email);
                startActivity(intent);
            });


            contenedorContactos.addView(botonContacto);
        }

        cursor.close();
        db.close();
    }
}