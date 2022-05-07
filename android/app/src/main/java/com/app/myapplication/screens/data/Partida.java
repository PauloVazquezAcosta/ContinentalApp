package com.app.myapplication.screens.data;

import java.io.Serializable;

public class Partida implements Serializable {

    private int numeroJugadores;
    private Jugador[] Jugadores;
    private int numeroRondas;
    private String[] textoTituloJugadores;
    private String[] textoNumeroRondas;
    private String[] jugadasRondas;


    public Partida(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        Jugadores = new Jugador[numeroJugadores];
        numeroRondas = 10;
        textoTituloJugadores = new String[numeroJugadores];
        setTextoTituloJugadores();
        textoNumeroRondas = new String[numeroRondas];
        setTextoNumeroRondas();
        jugadasRondas = new String[numeroRondas];
        setJugadasRondas();
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
        Jugadores[position] = new Jugador(nombre, numeroRondas);
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

    private void setTextoNumeroRondas() {
        for (int i = 0; i < numeroRondas; i++) {
            textoNumeroRondas[i] = "Ronda " + (i + 1);
        }
    }

    public String[] getTextoTituloJugadores() {
        return textoTituloJugadores;
    }

    private void setTextoTituloJugadores() {
        for (int i = 0; i < numeroJugadores; i++) {
            int numeroJugador = i + 1;
            textoTituloJugadores[i] = "Jugador/a " + numeroJugador;
        }
    }

    public String[] getJugadasRondas() {
        return jugadasRondas;
    }

    private void setJugadasRondas() {
        jugadasRondas[0] = "Un trío - 4 cartas";
        jugadasRondas[1] = "Una escalera - 5 cartas";
        jugadasRondas[2] = "Dos tríos - 7 cartas";
        jugadasRondas[3] = "Un trío y una escalera - 8 cartas";
        jugadasRondas[4] = "Dos escaleras - 9 cartas";
        jugadasRondas[5] = "Tres tríos - 10 cartas";
        jugadasRondas[6] = "Dos tríos y una escalera - 11 cartas";
        jugadasRondas[7] = "Un trío y dos escaleras - 12 cartas";
        jugadasRondas[8] = "Tres escaleras - 13 cartas";
        jugadasRondas[9] = "Cuatro tríos - 13 cartas";

    }
}
