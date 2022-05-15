package com.app.myapplication.screens.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

public class Partida implements Serializable {

    private int numeroJugadores;
    private Jugador[] jugadores;
    private int numeroRondas;
    private String[] textoTituloJugadores;
    private String[] jugadasRondas;
    private int rondaActual;

    public Partida(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        jugadores = new Jugador[numeroJugadores];
        numeroRondas = 10;
        textoTituloJugadores = new String[numeroJugadores];
        setTextoTituloJugadores();
        jugadasRondas = new String[numeroRondas];
        setJugadasRondas();
        rondaActual = 1;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public void setJugador(int position, String nombre) {
        jugadores[position] = new Jugador(nombre, numeroRondas);
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

    public int getRondaActual() {
        return rondaActual;
    }

    public void sumarRonda() {
        rondaActual++;
    }

    public int getNumeroRondas() {
        return numeroRondas;
    }

    public Jugador[] getRanking() {

        Comparator comparadorPuntuacion = Comparator.comparing(Jugador::getPuntuacionTotal);
        Arrays.sort(jugadores, comparadorPuntuacion);
        return jugadores;
    }

}
