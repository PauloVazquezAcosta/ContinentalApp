package com.app.continentalapp.screens.resultsActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.continentalapp.R;
import com.app.continentalapp.screens.data.Jugador;
import com.app.continentalapp.screens.data.Partida;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolderResults>{
    private Partida partida;

    public ResultsAdapter(Partida partida) {
        this.partida = partida;
    }

    @NonNull
    @Override
    public ResultsAdapter.ViewHolderResults onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.results_cell, null, false);
        return new ResultsAdapter.ViewHolderResults(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsAdapter.ViewHolderResults holder, int position) {
        holder.assignData(partida.getRanking()[position]);
    }

    @Override
    public int getItemCount() {
        return partida.getNumeroJugadores();
    }

    public class ViewHolderResults extends RecyclerView.ViewHolder {

        TextView nombreJugadorResultados;
        TextView puntuacionTotalJugadorResultados;

        public ViewHolderResults(@NonNull View itemView) {
            super(itemView);
            nombreJugadorResultados = itemView.findViewById(R.id.nombreJugadorResultados);
            puntuacionTotalJugadorResultados = itemView.findViewById(R.id.puntuacionTotalJugadorResultados);
        }

        public void assignData(Jugador jugador) {
            this.nombreJugadorResultados.setText(jugador.getNombre());
            this.puntuacionTotalJugadorResultados.setText(Integer.toString(jugador.getPuntuacionTotal()));

        }
    }
}
