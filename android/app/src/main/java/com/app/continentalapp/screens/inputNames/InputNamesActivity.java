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
    private boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_names);

        partida = (Partida) getIntent().getSerializableExtra(clavePartida);

        TextView textoNumeroJugadores = findViewById(R.id.textoJugadores);
        textoNumeroJugadores.setText(partida.getNumeroJugadores() + " jugadores");

        RecyclerView recyclerJugadores = findViewById(R.id.recyclerInputNombreJugadores);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        InputNamesAdapter adapter = new InputNamesAdapter(partida);
        recyclerJugadores.setAdapter(adapter);

        final View botonConfirmar = findViewById(R.id.botonConfirmar);

        botonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isAllFieldsChecked = CheckAllFields();

                Jugador[] nombresJugadores = adapter.getJugadores();
                partida.setJugadores(nombresJugadores);
                Intent intent = new Intent(getApplicationContext(), ResumeNamesActivity.class);
                intent.putExtra(clavePartida, partida);
                startActivity(intent);
            }
        });

    }
    private boolean CheckAllFields() {
        return false;
    }
}