package com.example.bbddfer;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {

    private EditText etID;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        getSupportActionBar().setTitle("Pantalla inicial");

        etID = findViewById(R.id.etID);
        dbHelper = new DatabaseHelper(this);
    }

    public void deleteClient(View view) {
        int id = Integer.parseInt(etID.getText().toString());

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rowsDeleted = db.delete(DatabaseHelper.TABLE_CLIENTES, DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(id)});

        if (rowsDeleted > 0) {
            Toast.makeText(this, "Contacto borrado", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error al borrar contacto", Toast.LENGTH_LONG).show();
        }

        db.close();
    }
}
