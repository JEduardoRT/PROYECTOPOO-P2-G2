package modelo;
public class Configuracion {
    private boolean visibilidad;
    private int numOponentes;
    public Configuracion(boolean visible, int oponentes){
        visibilidad = visible;
        numOponentes = oponentes;
    }
    public boolean getVisibilidad(){
        return visibilidad;
    }
    public void setVisibilidad(boolean visible){
        visibilidad = visible;
    }
    public int getNumOponentes(){
        return numOponentes;
    }
    public void setNumOponentes(int oponentes){
        numOponentes = oponentes;
    }
}
