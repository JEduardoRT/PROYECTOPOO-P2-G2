package com.jandryespol.modelo;

import java.io.Serializable;

public class CartaJuego implements Serializable{
    private Carta carta;
    private boolean marcada;
    public CartaJuego(Carta c){
        carta = c;
        marcada = false;
    }
    public Carta getCarta(){
        return carta;
    }
    public boolean getMarcada(){
        return marcada;
    }
    public void marcarCarta(){
        marcada = true;
    }
}
