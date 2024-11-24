package com.example.bbddfer;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;

public class InsertActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etMovil;
    private EditText etEmail;


    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        getSupportActionBar().setTitle("Pantalla inicial");

        etNombre = findViewById(R.id.etNombre);
        etMovil = findViewById(R.id.etMovil);
        etEmail = findViewById(R.id.etEmail);

        dbHelper = new DatabaseHelper(this);
    }

    public void insertClient(View view) {

        String nombre = etNombre.getText().toString();
        String movil = etMovil.getText().toString();
        String email = etEmail.getText().toString();


        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NOMBRE, nombre);
        values.put(DatabaseHelper.COLUMN_MOVIL, movil );
        values.put(DatabaseHelper.COLUMN_EMAIL, email);

        try {
            long result = db.insert(DatabaseHelper.TABLE_CLIENTES, null, values);
            if (result != -1) {
                Toast.makeText(this, "Contacto añadido", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Error al añadir contacto", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.e("InsertActivity", "Error al insertar cliente", e);
        }


        db.close();
    }
}
