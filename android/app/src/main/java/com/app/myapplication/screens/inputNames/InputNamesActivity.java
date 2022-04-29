package com.app.myapplication.screens.inputNames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Jugador;
import com.app.myapplication.screens.data.Partida;
import com.app.myapplication.screens.resumeNames.ResumeNamesActivity;

import java.util.ArrayList;

public class InputNamesActivity extends AppCompatActivity {
    private static final String clavePartida = "PARTIDA";
    private TextView textoNumeroJugadores;
    private RecyclerView recyclerJugadores;
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_names);

        partida = (Partida) getIntent().getSerializableExtra(clavePartida);

        textoNumeroJugadores = findViewById(R.id.textoJugadores);
        textoNumeroJugadores.setText(partida.getNumeroJugadores() + " jugadores");

        recyclerJugadores = findViewById(R.id.recyclerInputNombreJugadores);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        InputNamesAdapter adapter = new InputNamesAdapter(partida);
        recyclerJugadores.setAdapter(adapter);

        final View botonConfirmar = findViewById(R.id.botonConfirmar);

        botonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Jugador[] nombresJugadores = adapter.getJugadores();

                partida.setJugadores(nombresJugadores);
                Intent intent = new Intent(getApplicationContext(), ResumeNamesActivity.class);
                intent.putExtra(clavePartida, partida);
                startActivity(intent);
            }
        });


    }
}