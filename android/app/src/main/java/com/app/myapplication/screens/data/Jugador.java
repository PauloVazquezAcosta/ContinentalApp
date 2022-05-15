package com.app.myapplication.screens.data;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private int[] puntuacion;

    public Jugador(String nombre, int numeroRondas) {
        this.nombre = nombre;
        puntuacion = new int[numeroRondas];
    }

    public String getNombre() {
        return nombre;
    }

    public void setPuntuacionRonda(int puntuacion, int position) {
        this.puntuacion[position] = puntuacion;
    }

    public int getPuntuacionTotal(){
        int puntuacionTotal = 0;
        for (int i = 0; i < puntuacion.length; i++) {
            puntuacionTotal += puntuacion[i];
        }
        return puntuacionTotal;
    }
}
