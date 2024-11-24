package com.example.bbddfer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.content.Intent;


public class ListActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    private LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setTitle("Pantalla inicial");

        dbHelper = new DatabaseHelper(this);

        contenedor = findViewById(R.id.llLista);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                DatabaseHelper.TABLE_CLIENTES,
                null,
                null,
                null,
                null,
                null,
                null);

        while(cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            String nombre = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE));
            String movil = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MOVIL));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));

            Button buttonItem = new Button(this);


            buttonItem.setText(nombre);
            buttonItem.setTextSize(28);
            Log.d("ListActivity", "Nombre: " + nombre);
            buttonItem.setPadding(0, 10, 0, 10);

            buttonItem.setOnClickListener(v -> {
                Log.d("ListActivity", "Click en " + nombre);
                Contacto c = new Contacto(id, nombre, movil, email);
                Intent intent = new Intent(ListActivity.this, MostrarContactoActivity.class);
                intent.putExtra("contacto", c);
                startActivity(intent);

            });

            contenedor.addView(buttonItem);
        }

        cursor.close();


    }
}