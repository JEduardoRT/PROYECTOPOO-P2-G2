package modelo;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Jugador{
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
    public void verificarTablero(ArrayList<Carta> c){
        
    }
}
