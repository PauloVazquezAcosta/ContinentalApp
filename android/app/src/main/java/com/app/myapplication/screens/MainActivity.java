package com.app.myapplication.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import com.app.myapplication.R;


public class MainActivity extends AppCompatActivity {
    private NumberPicker selectorJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectorJugadores = findViewById(R.id.selectorJugadores);

        selectorJugadores.setMinValue(2);
        selectorJugadores.setMaxValue(4);

    }
}