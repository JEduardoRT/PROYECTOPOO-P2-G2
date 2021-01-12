package modelo;

public class Carta {
    String nombre;
    String nombreImagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public Carta(String nombre, String nombreImagen) {
        this.nombre = nombre;
        this.nombreImagen = nombreImagen;
    }
    
}
