package com.fersa.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtApellidos;
    private TextView txtSexo;
    private TextView txtAficiones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtNombre = findViewById(R.id.textView);
        txtApellidos = findViewById(R.id.textView2);
        txtSexo = findViewById(R.id.textView3);
        txtAficiones = findViewById(R.id.textView7);

        txtNombre.setText(getIntent().getStringExtra("NOMBRE"));
        txtApellidos.setText(getIntent().getStringExtra("APELLIDOS"));
        txtSexo.setText(getIntent().getStringExtra("SEXO"));
        txtAficiones.setText(getIntent().getStringExtra("AFICIONES"));



    }
}