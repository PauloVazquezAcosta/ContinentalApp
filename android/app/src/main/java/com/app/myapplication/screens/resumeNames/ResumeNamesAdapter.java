package com.app.myapplication.screens.resumeNames;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Jugador;
import com.app.myapplication.screens.data.Partida;

public class ResumeNamesAdapter extends RecyclerView.Adapter<ResumeNamesAdapter.ViewHolderResumeNames> {

    private Partida partida;

    public ResumeNamesAdapter(Partida partida) {
        this.partida = partida;
    }

    @NonNull
    @Override
    public ResumeNamesAdapter.ViewHolderResumeNames onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resume_name_player_cell, null, false);
        return new ResumeNamesAdapter.ViewHolderResumeNames(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeNamesAdapter.ViewHolderResumeNames holder, int position) {
        holder.assignData(partida.getJugadores()[position]);
    }

    @Override
    public int getItemCount() {
        return partida.getNumeroJugadores();
    }

    public class ViewHolderResumeNames extends RecyclerView.ViewHolder {

        TextView nombreJugador;

        public ViewHolderResumeNames(@NonNull View itemView) {
            super(itemView);
            nombreJugador = itemView.findViewById(R.id.nombreJugador);
        }

        public void assignData(Jugador nombreJugador) {
            this.nombreJugador.setText(nombreJugador.getNombre());
        }
    }
}
