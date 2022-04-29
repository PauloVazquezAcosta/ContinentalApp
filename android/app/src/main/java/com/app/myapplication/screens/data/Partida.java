package com.app.myapplication.screens.data;

import java.io.Serializable;

public class Partida implements Serializable {

    private int numeroJugadores;
    private Jugador[] Jugadores;
    private int numeroRondas;
    private String[] textoNumeroRondas;
    private String[] jugadasRondas;


    public Partida(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        Jugadores = new Jugador[numeroJugadores];
        numeroRondas = 10;
        for (int i = 0; i > numeroRondas; i++) {
            textoNumeroRondas[i] = "Ronda " + (i+1);
        }
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public Jugador[] getJugadores() {
        return Jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.Jugadores = jugadores;
    }

    public void setJugador(int position, String nombre) {
        Jugadores[position] = new Jugador(nombre);
    }

    public int getNumeroRondas() {
        return numeroRondas;
    }

    public void setNumeroRondas(int numeroRondas) {
        this.numeroRondas = numeroRondas;
    }

    public String[] getTextoNumeroRondas() {
        return textoNumeroRondas;
    }

    public void setTextoNumeroRondas(String[] textoNumeroRondas) {
        this.textoNumeroRondas = textoNumeroRondas;
    }
}
