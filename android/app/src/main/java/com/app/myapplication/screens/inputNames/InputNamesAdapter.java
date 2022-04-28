package com.app.myapplication.screens.inputNames;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class InputNamesAdapter extends RecyclerView.Adapter<InputNamesAdapter.ViewHolderNames> {

    ArrayList<String> arrayJugadores;
    String[] nombresJugadores;

    public InputNamesAdapter(ArrayList<String> arrayJugadores) {
        this.arrayJugadores = arrayJugadores;
        nombresJugadores = new String[arrayJugadores.size()];
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

    public String[] getNombresJugadores() { return nombresJugadores; }

    public class ViewHolderNames extends RecyclerView.ViewHolder {

        TextInputEditText nombreJugador;
        TextView numeroJugador;

        public ViewHolderNames(@NonNull View itemView) {
            super(itemView);
            numeroJugador = itemView.findViewById(R.id.numeroJugador);
            nombreJugador = itemView.findViewById(R.id.nombreJugadorInput);
            nombreJugador.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    nombresJugadores[getAdapterPosition()] = charSequence.toString();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }

        public void assignData(String numeroJugador) {
            this.numeroJugador.setText(numeroJugador);
        }
    }
}
