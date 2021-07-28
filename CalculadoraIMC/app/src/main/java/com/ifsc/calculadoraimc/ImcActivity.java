package com.ifsc.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {

    String nome;
    Double peso, altura;
    TextView tvNome, tvPeso, tvAltura, tvImc;
    DecimalFormat dcFormat = new DecimalFormat("##,###,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        nome = bundle.getString("nome");
        peso = bundle.getDouble("peso");
        altura = bundle.getDouble("altura");

        tvNome = findViewById(R.id.tvNome);
        tvPeso = findViewById(R.id.tvPeso);
        tvAltura = findViewById(R.id.tvAltura);
        tvImc = findViewById(R.id.tvImc);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tvNome.setText(nome);
        tvAltura.setText(altura.toString());
        tvPeso.setText(peso.toString());
        tvImc.setText(dcFormat.format(calculaIMC(peso, altura)));

    }

    public Double calculaIMC(Double peso, Double altura) {
        return peso / (altura * altura);
    }
}