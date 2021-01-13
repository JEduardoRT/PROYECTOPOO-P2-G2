package modelo;

public class Carta {
    String codigo;
    String nombreImagen;

    public Carta(String codigo, String nombreImagen) {
        this.codigo = codigo;
        this.nombreImagen = nombreImagen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    @Override
    public String toString() {
        return "Carta{" + "codigo=" + codigo + ", nombreImagen=" + nombreImagen + '}';
    }

   
}
