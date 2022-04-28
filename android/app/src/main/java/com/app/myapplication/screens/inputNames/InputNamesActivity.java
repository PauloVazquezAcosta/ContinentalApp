package com.app.myapplication.screens.inputNames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.myapplication.R;

import java.util.ArrayList;

public class InputNamesActivity extends AppCompatActivity {
    private int numeroJugadores;
    private static final String claveCaja = "NUMERO_JUGADORES";
    private TextView textoNumeroJugadores;

    private RecyclerView recyclerJugadores;
    private ArrayList<String> arrayJugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_names);

        Bundle cajaJugadores = getIntent().getExtras();
        numeroJugadores = cajaJugadores.getInt(claveCaja , 0);
        textoNumeroJugadores = findViewById(R.id.textoJugadores);
        textoNumeroJugadores.setText(numeroJugadores + " jugadores");

        recyclerJugadores = findViewById(R.id.recyclerNombreJugadores);
        recyclerJugadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        arrayJugadores = new ArrayList<String>();

        for (int i = 0; i < numeroJugadores; i++) {
            int numJugador = i + 1;
            arrayJugadores.add("Jugador/a " + numJugador);
        }

        InputNamesAdapter adapter = new InputNamesAdapter(arrayJugadores);
        recyclerJugadores.setAdapter(adapter);

        final Button botonConfirmar = findViewById(R.id.botonConfirmar);

        botonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] nombresJugadores = adapter.getNombresJugadores();
                for (int i = 0; i < nombresJugadores.length; i++) {
                    Toast.makeText(getApplicationContext(),nombresJugadores[i], Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}