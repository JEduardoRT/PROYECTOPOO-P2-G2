package modelo;
import java.util.ArrayList;
import java.util.Collections;

public class Tablero {
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
}
