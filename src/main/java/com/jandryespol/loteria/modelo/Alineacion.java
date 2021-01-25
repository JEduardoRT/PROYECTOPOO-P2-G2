package com.jandryespol.loteria.modelo;

import java.io.Serializable;

public class Alineacion implements Serializable{
    //Atributos
    private EnumAlineacion alineacion;
    private String ruta;
    //Constructor
    public Alineacion(EnumAlineacion alineacion, String ruta) {
        this.alineacion = alineacion;
        this.ruta = ruta;
    }
    //Getters

    public EnumAlineacion getAlineacion() {
        return alineacion;
    }

    public String getRuta() {
        return ruta;
    }
}

