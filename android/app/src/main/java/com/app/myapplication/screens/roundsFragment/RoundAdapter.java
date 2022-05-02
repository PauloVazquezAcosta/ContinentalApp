package com.app.myapplication.screens.roundOne;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myapplication.R;
import com.app.myapplication.screens.data.Partida;
import com.app.myapplication.screens.resumeNames.ResumeNamesAdapter;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class RoundAdapter extends RecyclerView.Adapter<RoundAdapter.ViewHolderRound> {

    private Partida partida;

    public RoundAdapter(Partida partida) {
        this.partida = partida;
    }

    @NonNull
    @Override
    public ViewHolderRound onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.round_cell, null, false);
        return new RoundAdapter.ViewHolderRound(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRound holder, int position) {
        holder.assignData(partida);
    }

    @Override
    public int getItemCount() {
        return partida.getNumeroJugadores();
    }

    public class ViewHolderRound extends RecyclerView.ViewHolder {

        private TextView nombreJugador;
        private TextInputEditText puntuacionRonda;
        private TextView puntuacionTotal;

        public ViewHolderRound(@NonNull View itemView) {
            super(itemView);
            nombreJugador = itemView.findViewById(R.id.nombreJugadorPartida);
            puntuacionRonda = itemView.findViewById(R.id.puntuacionJugadorInput);
            puntuacionTotal = itemView.findViewById(R.id.contadorPuntuacion);
        }
        public void assignData(Partida partida) {
            nombreJugador.setText(partida.getJugadores()[getAdapterPosition()].getNombre());
            puntuacionTotal.setText(Integer.toString(partida.getJugadores()[getAdapterPosition()].getPuntuacionTotal()));
            puntuacionRonda.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    try {
                        partida.getJugadores()[getAdapterPosition()].setPuntuacionRonda(Integer.parseInt(charSequence.toString()), getAdapterPosition());
                    }catch (NumberFormatException nfe) {
                        partida.getJugadores()[getAdapterPosition()].setPuntuacionRonda(0, getAdapterPosition());
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }
}
