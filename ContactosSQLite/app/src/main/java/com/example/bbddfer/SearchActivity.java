package com.example.bbddfer;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private EditText etSearchID;
    private TextView tvId;
    private TextView tvNombre;
    private TextView tvMovil;
    private TextView tvEmail;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        getSupportActionBar().setTitle("Pantalla inicial");

        etSearchID = findViewById(R.id.etSearchID);
        tvId = findViewById(R.id.tvId);
        tvNombre = findViewById(R.id.tvNombre);
        tvMovil = findViewById(R.id.tvMovil);
        tvEmail = findViewById(R.id.tvEmail);

        dbHelper = new DatabaseHelper(this);
    }

    public void searchClient(View view) {
       // int id = Integer.parseInt(etSearchID.getText().toString());
        String nombre = etSearchID.getText().toString();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
   //     Cursor cursor = db.query(DatabaseHelper.TABLE_CLIENTES, null, DatabaseHelper.COLUMN_NOMBRE + "=?", new String[]{String.valueOf(id)}, null, null, null);
        Cursor cursor = db.query(
                DatabaseHelper.TABLE_CLIENTES,
                null,
                DatabaseHelper.COLUMN_NOMBRE + "=?", new String[]{nombre},
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            tvId.setText("ID: " + id);
            Log.d("SearchActivity", "ID: " + id);

            try {
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NOMBRE));
                tvNombre.setText("Nombre: " + name);
            } catch (Exception e) {
                Log.e("SearchActivity", "Error al buscar contacto", e);
            }


            String movil = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_MOVIL));
            tvMovil.setText("Movil: " + movil);

            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));
            tvEmail.setText("Email: " + email);


        } else {
            Toast.makeText(this, "Contacto no encontrado", Toast.LENGTH_LONG).show();
        }

        cursor.close();
        db.close();
    }
}
