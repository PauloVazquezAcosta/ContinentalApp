package com.app.continentalapp.screens.data;

import java.io.Serializable;

/** Clase que representa a cada un dos xogadores da partida creada
 *
 */
public class Jugador implements Serializable {
    private String nombre;
    private int[] puntuacion;

    /** Construtor da clase Jugador
     *
     * @param nombre nome do xogador
     * @param numeroRondas número de rondas para inicializar a súa puntuación
     */
    public Jugador(String nombre, int numeroRondas) {
        this.nombre = nombre;
        puntuacion = new int[numeroRondas];
    }

    /** Devolve o nome dun xogador específico
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /** Recibe unha puntuación e a posición da ronda e setea a súa puntuación
     *
     * @param puntuacion
     * @param position
     */
    public void setPuntuacionRonda(int puntuacion, int position) {
        this.puntuacion[position] = puntuacion;
    }

    /** Devolve a puntuación total do xogador
     *
     * @return
     */
    public int getPuntuacionTotal(){
        int puntuacionTotal = 0;
        for (int i = 0; i < puntuacion.length; i++) {
            puntuacionTotal += puntuacion[i];
        }
        return puntuacionTotal;
    }
}
