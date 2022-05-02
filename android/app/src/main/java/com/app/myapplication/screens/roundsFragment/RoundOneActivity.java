package com.app.myapplication.screens.roundOne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Partida;
import com.app.myapplication.screens.inputNames.InputNamesAdapter;

public class RoundOneActivity extends AppCompatActivity {

    private static final String clavePartida = "PARTIDA";
    private Partida partida;
    private TextView textoNumeroRonda;
    private TextView textoJugadaRonda;
    private RecyclerView recyclerJugadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounds);

        partida = (Partida) getIntent().getSerializableExtra(clavePartida);
        textoNumeroRonda = findViewById(R.id.numeroRonda);
        textoNumeroRonda.setText(partida.getTextoNumeroRondas()[0]);

        textoJugadaRonda = findViewById(R.id.jugadaRonda);
        textoJugadaRonda.setText(partida.getJugadasRondas()[0]);

        recyclerJugadores = findViewById(R.id.recyclerRoundOne);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        RoundAdapter adapter = new RoundAdapter(partida);
        recyclerJugadores.setAdapter(adapter);

        View botonJugar = findViewById(R.id.botonSiguiente);

        botonJugar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RoundTwoActivity.class);
                intent.putExtra(clavePartida, partida);
                startActivity(intent);
            }
        });

    }
}