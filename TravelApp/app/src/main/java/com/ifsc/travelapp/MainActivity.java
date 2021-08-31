package com.ifsc.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonLV,buttonRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLV=findViewById(R.id.buttonLV);
        buttonRV=findViewById(R.id.buttonRV);

        buttonLV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListagemDestinosListViewActivity.class);
                startActivity(intent);
            }
        });

        buttonRV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListagemDestinosRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

    }
}