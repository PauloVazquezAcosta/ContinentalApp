package com.app.myapplication.screens;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;
import com.app.myapplication.R;


public class MainActivity extends AppCompatActivity {
    private NumberPicker selectorJugadores;
    private int numeroJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectorJugadores = findViewById(R.id.selectorJugadores);

        selectorJugadores.setMinValue(2);
        selectorJugadores.setMaxValue(4);

        selectorJugadores.setOnValueChangedListener((numberPicker, i, j) -> {
            numeroJugadores = selectorJugadores.getValue();
        });

        final Button botonEmpezar = findViewById(R.id.botonEmpezar);

        botonEmpezar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Jugadores: " + numeroJugadores,Toast.LENGTH_LONG).show();
            }
        });
    }
}