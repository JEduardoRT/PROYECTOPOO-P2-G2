package modelo;

import java.util.Objects;

public class Carta {
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
//    @Override
//    public boolean equals(Object obj) {
//        
//    }
}
