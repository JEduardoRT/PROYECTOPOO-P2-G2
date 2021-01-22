package modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Tablero tablero;
    public Jugador(String n, Tablero t){
        nombre = n;
        tablero = t;
    }
    public String getNombre(){
        return nombre;
    }
    public void verificarTablero(ArrayList<Carta> c){
        tablero.llenarTablero(c);
    }
}
