package com.jandryespol.modelo;

import java.io.Serializable;

public class Carta implements Serializable{
    String nombre;
    String rutaImagen;
    int numero;

    public Carta(String nombre, String rutaImagen, int num) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        numero = num;
    }
    public String getRutaImagen(){
        return rutaImagen;
    }
}
