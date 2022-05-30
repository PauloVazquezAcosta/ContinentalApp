package com.app.continentalapp.screens.resumeNames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.continentalapp.R;
import com.app.continentalapp.screens.data.Partida;
import com.app.continentalapp.screens.roundsActivity.RoundsActivity;

public class ResumeNamesActivity extends AppCompatActivity {
    private static final String clavePartida = "PARTIDA";
    private RecyclerView recyclerJugadores;
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_names);

        // Recupera a partida do bundle, a creada na pantalla MainActivity
        partida = (Partida) getIntent().getSerializableExtra(clavePartida);

        // Crea o listado de nomes dos xogadores para confirmar quen vai xogar
        recyclerJugadores = findViewById(R.id.recyclerResumenNombresJugadores);
        recyclerJugadores.setLayoutManager(new GridLayoutManager(this, 1));

        ResumeNamesAdapter adapter = new ResumeNamesAdapter(partida);
        recyclerJugadores.setAdapter(adapter);

        View botonJugar = findViewById(R.id.botonJugar);

        // Confirma o nome dos xogadores antes de comezar, ao clickar, envía a partida á seguinte pantalla
        botonJugar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RoundsActivity.class);
                intent.putExtra(clavePartida, partida);
                startActivity(intent);
            }
        });

    }
}