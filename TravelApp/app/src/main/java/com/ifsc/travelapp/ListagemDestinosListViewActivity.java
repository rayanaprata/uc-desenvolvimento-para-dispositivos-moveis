package com.ifsc.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListagemDestinosListViewActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_destino_list_view);
        listView = findViewById(R.id.listView);
        DestinoController destinoController = new DestinoController();

        DestinoAdapterListView destinoAdapterListView = new DestinoAdapterListView(
                getApplicationContext(),
                R.layout.template_item_destino,
                destinoController.DESTINOS
        );

        listView.setAdapter(destinoAdapterListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ExibeDestinos.class );
                intent.putExtra("id",i);
                startActivity(intent);
            }
        });

    }
}
