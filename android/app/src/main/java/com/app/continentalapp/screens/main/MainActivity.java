package com.app.continentalapp.screens.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        selectorJugadores.setMinValue(2);
        selectorJugadores.setMaxValue(4);

        numeroJugadores = selectorJugadores.getValue();

        selectorJugadores.setOnValueChangedListener((numberPicker, i, j) -> {
            numeroJugadores = selectorJugadores.getValue();
        });

        final View botonEmpezar = findViewById(R.id.botonEmpezar);

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