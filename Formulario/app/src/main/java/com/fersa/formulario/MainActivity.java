package com.fersa.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText nombreO;
    EditText apellidosO;
    RadioButton hombreO;
    RadioButton mujerO;
    CheckBox lecturaO;
    CheckBox deporteO;
    CheckBox beberCervezaO;
    CheckBox cineO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreO= findViewById(R.id.etNombre);
        apellidosO = findViewById(R.id.etApellidos);
        hombreO = findViewById(R.id.rbHombre);
        mujerO = findViewById(R.id.rbMujer);
        lecturaO = findViewById(R.id.cbLectura);
        deporteO = findViewById(R.id.cbDeporte);
        beberCervezaO = findViewById(R.id.cbCerveza);
        cineO = findViewById(R.id.cbCine);

        beberCervezaO.setChecked(true);

        final Button botEnviar = findViewById(R.id.btnMandarInfo);
        botEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                String nombreS= nombreO.getText().toString();
                String apellidosS= apellidosO.getText().toString();

                String sexoS="";
                if (hombreO.isChecked()) sexoS="HOMBRE";
                else sexoS = "MUJER";


                String [] arrayAficiones = new String[4];
                int cont=0;
                if (lecturaO.isChecked()) {
                    arrayAficiones[cont]="La lectura";
                    cont++;
                }
                if (deporteO.isChecked()) {
                    arrayAficiones[cont]="el deporte";
                    cont++;
                }
                if (beberCervezaO.isChecked()){
                    arrayAficiones[cont]="beber cerveza";
                    cont++;
                }
                if (cineO.isChecked()){
                    arrayAficiones[cont]= "el cine";
                    cont++;
                }

                String aficiones="";
                for( int i=0; i<cont; i++){

                    aficiones += arrayAficiones[i];
                    if (i<(cont-2)) aficiones+= ", ";
                    else if(i==cont-2) aficiones += " y ";
                }

                aficiones = aficiones.substring(0,1).toUpperCase()+ aficiones.substring(1);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("NOMBRE", nombreS);
                intent.putExtra("APELLIDOS", apellidosS);
                intent.putExtra("SEXO", sexoS);
                intent.putExtra("AFICIONES", aficiones);



                startActivity(intent);

            }
        });


    }


}