package com.app.continentalapp.screens.resultsActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.continentalapp.R;
import com.app.continentalapp.screens.data.Partida;
import com.app.continentalapp.screens.main.MainActivity;

public class ResultsActivity extends AppCompatActivity {
    private static final String clavePartida = "PARTIDA";
    private RecyclerView recyclerResultados;
    private Partida partida;
    private TextView nombreGanador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        partida = (Partida) getIntent().getSerializableExtra(clavePartida);

        recyclerResultados = findViewById(R.id.recyclerResumenResultados);
        recyclerResultados.setLayoutManager(new GridLayoutManager(this, 1));

        ResultsAdapter adapter = new ResultsAdapter(partida);
        recyclerResultados.setAdapter(adapter);

        nombreGanador = findViewById(R.id.nombreGanador);
        nombreGanador.setText(partida.getRanking()[0].getNombre());

        View botonContinuar = findViewById(R.id.botonSeguir);

        botonContinuar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Volviendo a la pantalla inicial")
                .setMessage("¿Seguro de que quiere salir de la pantalla de resultados?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}