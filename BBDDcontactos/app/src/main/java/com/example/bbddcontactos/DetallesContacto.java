package com.example.bbddcontactos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetallesContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_contacto);

        int id = getIntent().getIntExtra("ID", -1);
        String nombre = getIntent().getStringExtra("NOMBRE");
        String movil = getIntent().getStringExtra("MOVIL");
        String email = getIntent().getStringExtra("EMAIL");


        TextView nombreView = findViewById(R.id.textView3);
        TextView movilView = findViewById(R.id.textView4);
        TextView emailView = findViewById(R.id.textView5);

        nombreView.setText(nombre);
        movilView.setText(movil);
        emailView.setText(email);


        Button eliminarBtn = findViewById(R.id.button7);
        eliminarBtn.setOnClickListener(view -> {
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();


            int rowsDeleted = db.delete(DatabaseHelper.TABLE_CLIENTES,
                    DatabaseHelper.COLUMN_ID + "=?",
                    new String[]{String.valueOf(id)});

            db.close();

            if (rowsDeleted > 0) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}