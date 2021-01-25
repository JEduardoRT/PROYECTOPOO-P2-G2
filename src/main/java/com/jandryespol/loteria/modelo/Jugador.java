package com.jandryespol.loteria.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable{
    private String nombre;
    private Tablero tablero;
    public Jugador(String n, Tablero t){
        nombre = n;
        tablero = t;
    }
    public String getNombre(){
        return nombre;
    }
    public Tablero getTablero(){
        return tablero;
    }
    public boolean verificarTablero(EnumAlineacion al){
        ArrayList<CartaJuego> tablero = this.getTablero().getCartas();
        boolean valor=true;
        switch(al){
            case FILA:
                for(int i=0;i<tablero.size();i++){
                    if(i%4==0 & tablero.get(i).getMarcada()){
                        for(int j=1;j<4;j++){
                            if(!(tablero.get(i+j).getMarcada()))
                                valor = false;
                        }
                        if(valor)
                            return valor;
                    }
                }
                return false;
            case COLUMNA:
                for(int i=0;i<4;i++){
                    if(tablero.get(i).getMarcada()){
                        for(int j=4;j<13;j+=4){
                            if(!(tablero.get(i+j).getMarcada()))
                                valor = false;
                        }
                        if(valor)
                            return valor;
                    }
                }
                return false;
            case ESQUINA:
                for(int i=0;i<tablero.size();i++){
                    if((i==0 | i == 2 | i==8 | i ==10)&tablero.get(i).getMarcada()){
                        valor = true;
                        if(!(tablero.get(i+1).getMarcada()))
                                valor = false;
                        if(!(tablero.get(i+4).getMarcada()))
                                valor = false;
                        if(!(tablero.get(i+5).getMarcada()))
                                valor = false;
                        if(valor)
                            return valor;
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
