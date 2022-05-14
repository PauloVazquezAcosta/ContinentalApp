package com.app.myapplication.screens.roundsActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Partida;
import com.app.myapplication.screens.main.MainActivity;

public class RoundsActivity extends AppCompatActivity {

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
        textoNumeroRonda.setText("Ronda " + partida.getRondaActual());

        textoJugadaRonda = findViewById(R.id.jugadaRonda);
        textoJugadaRonda.setText(partida.getJugadasRondas()[partida.getRondaActual() - 1]);

        recyclerJugadores = findViewById(R.id.recyclerRounds);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        RoundAdapter adapter = new RoundAdapter(partida);
        recyclerJugadores.setAdapter(adapter);

        View botonJugar = findViewById(R.id.botonSiguiente);

        botonJugar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (partida.getRondaActual() < partida.getNumeroRondas()) {
                    partida.sumarRonda();
                    textoNumeroRonda.setText("Ronda " + partida.getRondaActual());
                    textoJugadaRonda.setText(partida.getJugadasRondas()[partida.getRondaActual() - 1]);
                    recyclerJugadores.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    RoundAdapter adapter = new RoundAdapter(partida);
                    recyclerJugadores.setAdapter(adapter);

                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra(clavePartida, partida);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Saliendo de la partida")
                .setMessage("¿Seguro de que quiere salir de la partida?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}