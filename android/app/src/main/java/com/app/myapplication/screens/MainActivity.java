package com.app.myapplication.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import com.app.myapplication.R;
import com.app.myapplication.screens.inputNames.InputNamesActivity;


public class MainActivity extends AppCompatActivity {
    private NumberPicker selectorJugadores;
    private int numeroJugadores;
    private static final String claveCaja = "NUMERO_JUGADORES";

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

        final Button botonEmpezar = findViewById(R.id.botonEmpezar);

        botonEmpezar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InputNamesActivity.class);
                Bundle cajaJugadores = new Bundle();
                cajaJugadores.putInt(claveCaja, numeroJugadores);
                intent.putExtras(cajaJugadores);
                startActivity(intent);
            }
        });
    }
}