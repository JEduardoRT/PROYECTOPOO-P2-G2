package modelo;

import java.util.ArrayList;

public class Mazo {
    ArrayList<Carta> mazo ;

    public Mazo() {
        this.mazo = new ArrayList<Carta>();;
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }
    
    
    public void cargaMazo(){
    mazo.add(new Carta("1","1"));
    mazo.add(new Carta("2","2"));
    mazo.add(new Carta("3","3"));
    mazo.add(new Carta("4","4"));
    mazo.add(new Carta("5","5"));
    mazo.add(new Carta("6","6"));
    mazo.add(new Carta("7","7"));
    mazo.add(new Carta("8","8"));
    mazo.add(new Carta("9","9"));
//    mazo.add(new Carta("10","10"));
//    mazo.add(new Carta("11","11"));
//    mazo.add(new Carta("12","12"));
    }
}
