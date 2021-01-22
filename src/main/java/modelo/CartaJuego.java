package modelo;

public class CartaJuego {
    private Carta carta;
    private boolean marcada;
    public CartaJuego(Carta c){
        carta = c;
        marcada = false;
    }
    public Carta getCarta(){
        return carta;
    }
    public void marcarCarta(){
        marcada = true;
    }
}
