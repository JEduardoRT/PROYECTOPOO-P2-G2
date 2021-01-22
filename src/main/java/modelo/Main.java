package modelo;

import java.util.ArrayList;

public class Main {
    private ArrayList<Juego> juegos;
    private Configuracion configuracion;
    public Main(){
        juegos = new ArrayList();
        configuracion = new Configuracion(true,1);
    }
    public void iniciarJuego(ArrayList<Jugador> jugadores, Configuracion conf){
        juegos.add(new Juego(jugadores,conf));
    }
    public ArrayList<Juego> getJuegos(){
        return juegos;
    }
    public void setConfiguracion(Configuracion conf){
        configuracion = conf;
    }
    public Configuracion getConfiguracion(){
        return configuracion;
    }
}
