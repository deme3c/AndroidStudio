package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //creo un string de la clase StringBuilder ya que para el historial de operaciones me facilita la vida. Me ha gustado esta clase Fernando
    private StringBuilder historialOperaciones = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView logo = findViewById(R.id.img_logo);
        EditText op1 = findViewById(R.id.operando1);
        EditText op2 = findViewById(R.id.operando2);
        TextView r = findViewById(R.id.resultado);
        TextView historial = findViewById(R.id.historial); // Nuevo historial
        ImageButton suma = findViewById(R.id.img_suma);
        ImageButton rest = findViewById(R.id.img_resta);
        ImageButton multi = findViewById(R.id.img_multiplicacion);
        ImageButton division = findViewById(R.id.img_division);
        ImageButton borrar = findViewById(R.id.img_borrar); // Botón de borrar

        suma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realizarOperacion(op1, op2, r, historial, "+");
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realizarOperacion(op1, op2, r, historial, "/");
            }
        });
        

        rest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realizarOperacion(op1, op2, r, historial, "-");
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                realizarOperacion(op1, op2, r, historial,"*");
            }
        });


        // Configuro el evento para el botón de borrar, que limpia los campos de texto, el resultado y el historial.
        borrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                op1.setText("");
                op2.setText("");
                r.setText("Resultado");
                historial.setText("Historial de operaciones:");
                historialOperaciones.setLength(0); // Limpio el historial
            }
        });
    }
    // este método realiza la operación solicitada según el operador (+, -, *, /).
    // toma los valores de los EditText, verifica que sean números, realiza la operación y actualiza el resultado y el historial.
    private void realizarOperacion(EditText op1, EditText op2, TextView resultado, TextView historial, String operador) {
        String valor1 = op1.getText().toString();
        String valor2 = op2.getText().toString();

        if (esNumero(valor1) && esNumero(valor2)) {
            double num1 = Double.parseDouble(valor1);
            double num2 = Double.parseDouble(valor2);
            double res = 0;
            switch (operador) {
                case "+":
                    res = num1 + num2;
                    break;
                case "-":
                    res = num1 - num2;
                    break;
                case "*":
                    res = num1 * num2;
                    break;
                case "/":
                    res = num1 / num2;
                    break;
            }
            resultado.setText(String.valueOf(res));
            // Actualizo el historial añadiendo al string con el metodo .append cada cosa, luego lo con .toString lo haces string normal
            historialOperaciones.append(num1).append(" ").append(operador).append(" ").append(num2)
                    .append(" = ").append(res).append("\n");
            historial.setText(historialOperaciones.toString());
        } else {
            resultado.setText("Introduce ambos números");
        }
    }

    //compruebo que el parametro metido sea un double
    public boolean esNumero(String t) {
        try {
            Double.parseDouble(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}