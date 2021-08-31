package com.ifsc.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class ListagemDestinosRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DestinoController destinoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_destinos_recycler_view);

        DestinoController destinoController = new DestinoController();

        recyclerView = findViewById(R.id.recylerView);

        //Configuração Recycle View
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Configuração Adapter para recycler View
        DestinoAdapterRecyclerView destinoAdapterRecyclerView =
                new DestinoAdapterRecyclerView(
                        getApplicationContext(),
                        R.layout.template_item_destino,
                        destinoController.DESTINOS
                );

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(),ExibeDestinos.class );
                        intent.putExtra("id",position);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));

        recyclerView.setAdapter(destinoAdapterRecyclerView);

    }
}
