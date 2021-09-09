package com.ifsc.blocodenotassqllite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.ifsc.blocodenotassqllite.Controller.NotaController;
import com.ifsc.blocodenotassqllite.Model.Nota;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
    }

    public void cadastrarNota(View v) {
        Intent intent = new Intent(this, valoresNota.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NotaController notaController = new NotaController(this);
        ArrayList<String> dataset = notaController.listaTituloNotas();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dataset);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),Long.toString(parent.getItemIdAtPosition(position) ), Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), valoresNota.class);
                Nota n = notaController.recuperaNota(notaController.listaNotas().get(position).getId());
                i.putExtra("notaId",notaController.listaNotas().get(position).getId());
                startActivity(i);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Confirmar exclusão nota");
                adb.setMessage("Excluir nota?");
                adb.setNegativeButton("Cancelar", null);
                adb.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notaController.excluirNota( notaController.listaNotas().get(position));
                        onResume();
                    }
                });
                adb.show();
                return true;
            }
        });
    }
}