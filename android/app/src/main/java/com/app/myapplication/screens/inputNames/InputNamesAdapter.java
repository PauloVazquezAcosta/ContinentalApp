package com.app.myapplication.screens.inputNames;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Jugador;
import com.app.myapplication.screens.data.Partida;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class InputNamesAdapter extends RecyclerView.Adapter<InputNamesAdapter.ViewHolderInputNames> {

    private Partida partida;

    public InputNamesAdapter(Partida partida) {
        this.partida = partida;
    }

    @NonNull
    @Override
    public ViewHolderInputNames onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.input_name_player_cell, null, false);
        return new ViewHolderInputNames(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderInputNames holder, int position) {
        holder.assignData(partida.getTextoTituloJugadores()[position]);
    }

    @Override
    public int getItemCount() {
        return partida.getNumeroJugadores();
    }

    public Jugador[] getJugadores() { return partida.getJugadores(); }

    public class ViewHolderInputNames extends RecyclerView.ViewHolder {

        private TextView numeroJugador;
        private TextInputEditText nombreJugador;

        public ViewHolderInputNames(@NonNull View itemView) {
            super(itemView);
            numeroJugador = itemView.findViewById(R.id.numeroJugador);
            nombreJugador = itemView.findViewById(R.id.nombreJugadorInput);

            nombreJugador.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    partida.setJugador(getAdapterPosition(), charSequence.toString());
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });

        }

        public void assignData(String jugador) {
            this.numeroJugador.setText(jugador);
        }
    }
}
