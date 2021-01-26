/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jandryespol.modelo;

/**
 *
 * @author Jandry
 */
public class Contador extends Thread{
    Juego juego;
    public Contador(Juego j){
        juego = j;
    }
    public void setJuego(Juego j){
        juego = j;
    }
    public Juego getJuego(){
        return juego;
    }
    public void run(){
        while(juego.getGanador()==null){
            try {
                this.sleep(1000);
                juego.masUnSegundo();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
