package modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
public class Mazo implements Serializable{
    private ArrayList<Carta> cartas;
    public Mazo() {
        this.cartas = new ArrayList();
        for(int i=1;i<55;i++){
            cartas.add(new Carta(Integer.toString(i),Integer.toString(i)+".jpg",i));
        }
    }
    public void barajar(){
        Collections.shuffle(cartas);
    }
    public ArrayList<Carta> getCartas(){
        return cartas;
    }
}
