package com.ifsc.blocodenotassqllite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.ifsc.blocodenotassqllite.Controller.NotaController;
import com.ifsc.blocodenotassqllite.Model.Nota;

public class valoresNota extends AppCompatActivity {

    NotaController notaController;
    EditText edTitulo, edTexto;
    Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores_nota);
        notaController = new NotaController(getApplicationContext());

        edTitulo = findViewById(R.id.edTitulo);
        edTexto = findViewById(R.id.edTexto);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            Integer actionId = bundle.getInt("notaId");
            nota = notaController.recuperaNota(actionId);
        } else {
            nota = new Nota(edTitulo.getText().toString(), edTexto.getText().toString());
        }

    }

    public void salvarNota(View v) {
        Nota notaNova = new Nota(edTitulo.getText().toString(), edTexto.getText().toString());
        if (nota.getId()!=null){
            notaController.atualizaNota(notaNova);
            Toast.makeText(this, "Nota atualizada com sucesso", Toast.LENGTH_SHORT).show();

        }else{
            notaController.cadastrarNota(notaNova);
            Toast.makeText(this, "Nota cadastrada com sucesso", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onResume() {
        super.onResume();
        edTitulo.setText(nota.getTitulo());
        edTexto.setText(nota.getTexto());
    }
}