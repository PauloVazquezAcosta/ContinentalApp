package com.app.continentalapp.screens.data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Clase que representa á partida creada para levar a puntuación
 */
public class Partida implements Serializable {

    private int numeroJugadores;
    private Jugador[] jugadores;
    private int numeroRondas;
    private String[] textoTituloJugadores;
    private String[] jugadasRondas;
    private int rondaActual;

    /**
     * Construtor da clase Partida, recibindo o número de xogadores xa inicializa o resto de parámetros
     *
     * @param numeroJugadores cantidade de xogadores da partida
     */
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

    /**
     * Devolve o número de xogadores da partida
     *
     * @return
     */
    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    /**
     * Devolve o listado de xogadores da partida
     *
     * @return
     */
    public Jugador[] getJugadores() {
        return jugadores;
    }

    /**
     * Recibe o listado de xogadores e asígnao á partida
     *
     * @param jugadores array de obxectos Jugador
     */
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Recibe a posición e o nome e ubica ao xogador nesa posición
     *
     * @param position posición do xogador dentro da partida
     * @param nombre   nome do xogador
     */
    public void setJugador(int position, String nombre) {
        jugadores[position] = new Jugador(nombre, numeroRondas);
    }

    /**
     * Devolve un array co texto indicativo da posición de cada xogador
     *
     * @return
     */
    public String[] getTextoTituloJugadores() {
        return textoTituloJugadores;
    }

    /**
     * Setea o texto indicativo da posición de cada un dos xogadores
     */
    private void setTextoTituloJugadores() {
        for (int i = 0; i < numeroJugadores; i++) {
            int numeroJugador = i + 1;
            textoTituloJugadores[i] = "Jugador/a " + numeroJugador;
        }
    }

    /**
     * Devolve un array co listado de xogadas da partida que se vai xogar
     *
     * @return
     */
    public String[] getJugadasRondas() {
        return jugadasRondas;
    }

    /**
     * Setea o listado de xogadas da partida a xogar
     */
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

    /**
     * Devolve a ronda actual na que se atopa a partida
     *
     * @return
     */
    public int getRondaActual() {
        return rondaActual;
    }

    /**
     * Suma unha ronda á partida para iniciar a seguinte xogada
     */
    public void sumarRonda() {
        rondaActual++;
    }

    /**
     * Devolve o número de rondas totais da partida
     *
     * @return
     */
    public int getNumeroRondas() {
        return numeroRondas;
    }

    /**
     * Devolve un array de xogadores en orde para sinalar ao gañador
     *
     * @return
     */
    public Jugador[] getRanking() {

        // Compara os xogadores pola súa puntuación total e ordea o array en función diso
        Comparator comparadorPuntuacion = Comparator.comparing(Jugador::getPuntuacionTotal);
        Arrays.sort(jugadores, comparadorPuntuacion);
        return jugadores;
    }

}
