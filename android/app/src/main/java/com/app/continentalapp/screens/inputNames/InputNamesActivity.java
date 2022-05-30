package com.app.continentalapp.screens.inputNames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.continentalapp.R;
import com.app.continentalapp.screens.data.Jugador;
import com.app.continentalapp.screens.data.Partida;
import com.app.continentalapp.screens.resumeNames.ResumeNamesActivity;

public class InputNamesActivity extends AppCompatActivity {
    private static final String clavePartida = "PARTIDA";
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_names);

        // Recupera a partida do bundle, a creada na pantalla MainActivity
        partida = (Partida) getIntent().getSerializableExtra(clavePartida);

        TextView textoNumeroJugadores = findViewById(R.id.textoJugadores);

        // Na pantalla indica o número de xogadores escollidos na pantalla anterior
        textoNumeroJugadores.setText(partida.getNumeroJugadores() + " jugadores");

        // Crea o listado de campos de texto para encher os nomes dos xogadores
        RecyclerView recyclerJugadores = findViewById(R.id.recyclerInputNombreJugadores);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        InputNamesAdapter adapter = new InputNamesAdapter(partida);
        recyclerJugadores.setAdapter(adapter);

        final View botonConfirmar = findViewById(R.id.botonConfirmar);

        // Ao confirmar os nomes dos usuarios, colle os datos do adapter e asóciaos á partida, despois envíaa á seguinte pantalla
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