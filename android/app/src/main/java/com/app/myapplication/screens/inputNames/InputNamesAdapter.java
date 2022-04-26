package com.app.myapplication.screens.inputNames;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myapplication.R;

import java.util.ArrayList;

public class InputNamesAdapter extends RecyclerView.Adapter<InputNamesAdapter.ViewHolderNames> {

    ArrayList<String> arrayJugadores;

    public InputNamesAdapter(ArrayList<String> arrayJugadores) {
        this.arrayJugadores = arrayJugadores;
    }

    @NonNull
    @Override
    public ViewHolderNames onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.input_name_player_cell, null, false);
        return new ViewHolderNames(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNames holder, int position) {
        holder.assignData(arrayJugadores.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayJugadores.size();
    }

    public class ViewHolderNames extends RecyclerView.ViewHolder {

        TextView numeroJugador;

        public ViewHolderNames(@NonNull View itemView) {
            super(itemView);
            numeroJugador = itemView.findViewById(R.id.numeroJugador);
        }

        public void assignData(String numeroJugador) {
            this.numeroJugador.setText(numeroJugador);
        }
    }
}
