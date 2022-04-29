package com.app.myapplication.screens.roundOne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Partida;

public class RoundOneActivity extends AppCompatActivity {

    private static final String clavePartida = "PARTIDA";
    Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounds);

        partida = (Partida) getIntent().getSerializableExtra(clavePartida);
    }
}