package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Juego {
    private String fecha;
    private int duracion;
    private ArrayList<Jugador> jugadores;
    private Jugador ganador;
    private Configuracion configuracion;
    private Mazo mazo;
    private ArrayList<Carta> cartasJugadas;
    private Alineacion alineacion;
    private static final List<Alineacion> VALUES = Collections.unmodifiableList(Arrays.asList(Alineacion.values()));
    
    public Juego(ArrayList<Jugador> jugadores, Configuracion conf){
        Date hoy = new Date();
        fecha = hoy.toString();
        duracion = 0;
        this.jugadores = jugadores;
        ganador = null;
        configuracion = conf;
        mazo = new Mazo();
        mazo.barajar();
        cartasJugadas = new ArrayList();
        Random r = new Random();
        alineacion = VALUES.get(r.nextInt(3));
    }
    public String getFecha(){
        return fecha;
    }
    public int getDuracion(){
        return duracion;
    }
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    public Configuracion getConfiguracion(){
        return configuracion;
    }
    public Alineacion getAlineacion(){
        return alineacion;
    }
    public void verificarJuego(){
        
    }
}
