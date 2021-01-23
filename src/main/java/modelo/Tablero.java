package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Tablero implements Serializable{
    private ArrayList<CartaJuego> cartas;
    public Tablero(){
        cartas = new ArrayList();
    }
    public void llenarTablero(ArrayList<Carta> array){
        if(array.size()>=16){
            Collections.shuffle(array);
            for(int i=0;i<16;i++)
                cartas.add(new CartaJuego(array.get(i)));
        }
    }
    public ArrayList<CartaJuego> getCartas(){
        return cartas;
    }
}
