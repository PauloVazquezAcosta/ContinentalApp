package com.app.continentalapp.screens.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

import com.app.continentalapp.R;
import com.app.continentalapp.screens.data.Partida;
import com.app.continentalapp.screens.inputNames.InputNamesActivity;


public class MainActivity extends AppCompatActivity {
    private NumberPicker selectorJugadores;
    private int numeroJugadores;
    private static final String clavePartida = "PARTIDA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectorJugadores = findViewById(R.id.selectorJugadores);

        // Valores mínimos e máximos para os xogadores de cada partida
        selectorJugadores.setMinValue(2);
        selectorJugadores.setMaxValue(4);

        // Asigna o valor inicial á variable para que teña eses participantes por defecto
        numeroJugadores = selectorJugadores.getValue();

        // No caso de que o usuario cambie o valor no selector, asignará este valor á variable
        selectorJugadores.setOnValueChangedListener((numberPicker, i, j) -> {
            numeroJugadores = selectorJugadores.getValue();
        });

        final View botonEmpezar = findViewById(R.id.botonEmpezar);

        // Ao facer click no botón, crea a partida co número de xogadores escollido e envíaa á seguinte pantalla
        botonEmpezar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Partida partida = new Partida(numeroJugadores);
                Intent intent = new Intent(getApplicationContext(), InputNamesActivity.class);
                intent.putExtra(clavePartida, partida);
                startActivity(intent);
            }
        });
    }
}