package com.jandryespol.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Juego implements Serializable{
    private String fecha;
    private int duracion;
    private ArrayList<Jugador> jugadores;
    private transient Jugador ganador;
    private Configuracion configuracion;
    private transient Mazo mazo;
    private transient ArrayList<Carta> cartasJugadas;
    private transient Alineacion alineacion;
    private EnumAlineacion numAlineacion;
    private transient static final List<EnumAlineacion> VALUES = Collections.unmodifiableList(Arrays.asList(EnumAlineacion.values()));
    
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
        numAlineacion = VALUES.get(r.nextInt(3));
        String prefijo = String.valueOf(numAlineacion);//Recuperando la alineacion
        String ruta = prefijo.toLowerCase()+".jpg";//Creando la ruta para la imagen de la alineacion
        alineacion = new Alineacion(numAlineacion, ruta);
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
    public Jugador getGanador(){
        return ganador;
    }
    public void masUnSegundo(){
        duracion++;
    }
    public EnumAlineacion getNumAlineacion(){
        return numAlineacion;
    }
    public Mazo getMazo(){
        return mazo;
    }
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }
    public void setGanador(Jugador winner){
        ganador = winner;
    }
    public ArrayList<Carta> getCartasJugadas(){
        return cartasJugadas;
    }
}
