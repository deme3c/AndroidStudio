package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.img_logo);
        EditText op1 = findViewById(R.id.operando1);
        EditText op2 = findViewById(R.id.operando2);
        TextView r = findViewById(R.id.resultado);
        ImageButton suma = findViewById(R.id.img_suma);
        ImageButton rest = findViewById(R.id.img_resta);
        ImageButton multi = findViewById(R.id.img_multiplicacion);
        ImageButton division = findViewById(R.id.img_division);

        suma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                suma.
            }
        });


    }
}