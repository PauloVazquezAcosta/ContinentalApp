package com.app.continentalapp.screens.roundsActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.continentalapp.R;
import com.app.continentalapp.screens.data.Partida;
import com.app.continentalapp.screens.main.MainActivity;
import com.app.continentalapp.screens.resultsActivity.ResultsActivity;

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

        // Recupera a partida do bundle, a creada na pantalla MainActivity
        partida = (Partida) getIntent().getSerializableExtra(clavePartida);
        textoNumeroRonda = findViewById(R.id.numeroRonda);

        // Mostra o número da ronda actual, busca no obxecto da partida creada a ronda na que se atopa
        textoNumeroRonda.setText("Ronda " + partida.getRondaActual());

        textoJugadaRonda = findViewById(R.id.jugadaRonda);
        // Mostra a xogada a realizar na ronda actual, busca no obxecto da partida creada a ronda na que se atopa
        textoJugadaRonda.setText(partida.getJugadasRondas()[partida.getRondaActual() - 1]);

        // Crea o listado de campos para encher a puntuación de cada xogador en cada ronda e ver a puntuación total de cada un
        recyclerJugadores = findViewById(R.id.recyclerRounds);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RoundAdapter adapter = new RoundAdapter(partida);
        recyclerJugadores.setAdapter(adapter);

        View botonJugar = findViewById(R.id.botonSiguiente);

        /*
         Ao confirmar a puntuación engadida vai á seguinte pantalla e só sae da partida cando se acaban o número de rondas estipuladas
         Pinta cada unha das rondas aproveitando a mesma pantalla
         */
        botonJugar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // En caso de que a ronda actual sexa menor ás totais, repite o bucle
                if (partida.getRondaActual() < partida.getNumeroRondas()) {

                    // Cada vez que se avanza unha ronda, súmaa á partida creada
                    partida.sumarRonda();

                    // Mostra a ronda actual, tanto o número como a xogada a realizar
                    textoNumeroRonda.setText("Ronda " + partida.getRondaActual());
                    textoJugadaRonda.setText(partida.getJugadasRondas()[partida.getRondaActual() - 1]);

                    // Volve mostrar o listado pero cos datos actualizados
                    recyclerJugadores.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    RoundAdapter adapter = new RoundAdapter(partida);
                    recyclerJugadores.setAdapter(adapter);

                    // No caso de chegar á última ronda e facer click, cambia o texto do botón
                    if (partida.getRondaActual() == partida.getNumeroRondas()) {
                        TextView textoFinalizar = findViewById(R.id.textoSiguiente);
                        textoFinalizar.setText("Finalizar");
                    }
                }else {
                    // Cando se remata a partida vai mostrar os resultados finais
                    Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                    intent.putExtra(clavePartida, partida);
                    startActivity(intent);
                }
            }
        });

    }

    // No caso de pulsar o botón para ir á pantalla anterior, a app preguntará confirmación pero non deixará volver, irá á pantalla inicial
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
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

}