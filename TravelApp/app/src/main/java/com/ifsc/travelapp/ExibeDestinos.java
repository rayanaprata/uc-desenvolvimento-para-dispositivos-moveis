package com.ifsc.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.os.Bundle;

public class ExibeDestinos extends AppCompatActivity {
    TextView textViewCodigo,textViewNome,textViewPreco;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_destino);

        int id=getIntent().getExtras().getInt("id");

        textViewCodigo=findViewById(R.id.textViewCodigo);
        textViewNome=findViewById(R.id.textViewNome);
        textViewPreco=findViewById(R.id.textViewPreco);
        imageView=findViewById(R.id.imageView);

        DestinoController destinoController = new DestinoController();
        DecimalFormat decimalFormat =  new DecimalFormat("#,###.00");

        textViewCodigo.setText(Integer.toString(destinoController.DESTINOS[id].getCodigo()));
        textViewNome.setText(destinoController.DESTINOS[id].getNome());
        textViewPreco.setText(decimalFormat.format(destinoController.DESTINOS[id].getPreco()) );
        imageView.setImageResource(destinoController.DESTINOS[id].getImagem());
    }
}
