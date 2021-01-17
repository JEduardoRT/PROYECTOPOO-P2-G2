/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ken
 */
public class Posicion {
    private int fila;
    private int colu;

    public Posicion(int fila, int colu) {
        this.fila = fila;
        this.colu = colu;
    }

    public int getFila() {
        return fila;
    }

    public int getColu() {
        return colu;
    }
}
