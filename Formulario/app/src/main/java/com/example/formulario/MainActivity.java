package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText nombreO, surnameEditText;
    RadioGroup sexoRadioGroup;
    RadioButton hombreRadioButton, mujerRadioButton;
    CheckBox lecturaCheckBox, deporteCheckBox, cervezaCheckBox, cineCheckBox;
    ImageButton botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombreO = findViewById(R.id.name);
        surnameEditText = findViewById(R.id.surname);
        sexoRadioGroup = findViewById(R.id.radioGroupSex);
        hombreRadioButton = findViewById(R.id.radioButton);
        mujerRadioButton = findViewById(R.id.radioButton2);

        lecturaCheckBox = findViewById(R.id.lectura);
        deporteCheckBox = findViewById(R.id.deporte);
        cervezaCheckBox = findViewById(R.id.cerveza);
        cineCheckBox = findViewById(R.id.cine);

        botonEnviar = findViewById(R.id.botonEnviar);



        botonEnviar.setOnClickListener(v -> {

            String nombreS = nombreO.getText().toString();
            String apellido = surnameEditText.getText().toString();
            String sexo = sexoRadioGroup.getCheckedRadioButtonId() == R.id.radioButton ? "Hombre" : "Mujer";
            boolean lectura = lecturaCheckBox.isChecked();
            boolean deporte = deporteCheckBox.isChecked();
            boolean cerveza = cervezaCheckBox.isChecked();
            boolean cine = cineCheckBox.isChecked();


            StringBuilder aficiones = new StringBuilder();
            mensajeCheckBox(aficiones);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("NOMBRE", nombreS);
            intent.putExtra("apellido", apellido);
            intent.putExtra("sexo", sexo);
            intent.putExtra("aficiones", aficiones.toString());

            startActivity(intent);
        });




    }

    public void mensajeCheckBox(StringBuilder aficiones) {

        ArrayList<String> seleccionadas = new ArrayList<>();

        if(lecturaCheckBox.isChecked()){
            seleccionadas.add("lectura");
        }
        if(deporteCheckBox.isChecked()){
            seleccionadas.add("deporte");
        }
        if(cervezaCheckBox.isChecked()){
            seleccionadas.add("beber cerveza");
        }
        if(cineCheckBox.isChecked()){
            seleccionadas.add("cine");
        }

        if (lecturaCheckBox.isChecked()) {
            aficiones.append("La ");
        }
        else {
            aficiones.append("El ");
        }

        int size = seleccionadas.size();
        for (int i = 0; i < size; i++) {
            aficiones.append(seleccionadas.get(i));
            if (i < size - 2) {
                aficiones.append(", ");
            } else if (i == size - 2) {
                aficiones.append(" y el ");
            }
        }

    }
}