package com.ifsc.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] dados = new String[] {"Sushi", "Pizza", "Cachorro Quente", "Strogonoff", "Pastel", "Hamburguer"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1, //template XML
                android.R.id.text1, //id a ser preenchido com dados
                dados // dados
        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}