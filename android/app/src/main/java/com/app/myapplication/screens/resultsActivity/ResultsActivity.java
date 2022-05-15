package com.app.myapplication.screens.resultsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Partida;
import com.app.myapplication.screens.resumeNames.ResumeNamesAdapter;
import com.app.myapplication.screens.roundsActivity.RoundsActivity;

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
            }
        });

    }
}