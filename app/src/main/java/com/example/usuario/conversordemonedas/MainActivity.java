package com.example.usuario.conversordemonedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText edtEuros, edtDolares;
    private RadioButton rbtnDaE, rbtnEaD;
    private Button btnConvertir;

    private double cambioDolaresAEuros = 0.846345902;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEuros = (EditText)findViewById(R.id.edtEuros);
        edtDolares = (EditText)findViewById(R.id.edtDolares);
        rbtnDaE = (RadioButton)findViewById(R.id.rbtnDaE);
        rbtnEaD = (RadioButton)findViewById(R.id.rbtnEaD);
        btnConvertir = (Button)findViewById(R.id.btnConvertir);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rbtnDaE.isChecked() && esUnDouble(edtDolares.getText().toString())) {
                    edtEuros.setText(convertirAEuros(edtDolares.getText().toString()));
                }
                else if(rbtnEaD.isChecked() && esUnDouble(edtEuros.getText().toString())) {
                    edtDolares.setText(convertirADolares(edtEuros.getText().toString()));
                }
            }
        });
    }

    public String convertirADolares(String cantidad) {
        double valor = Double.parseDouble(cantidad) / cambioDolaresAEuros;
        return String.format("%.2f", valor);
    }

    public String convertirAEuros(String cantidad) {
        double valor = Double.parseDouble(cantidad) * cambioDolaresAEuros;
        return String.format("%.2f", valor);
    }

    public boolean esUnDouble(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
