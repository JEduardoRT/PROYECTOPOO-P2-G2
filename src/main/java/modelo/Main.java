package modelo;

import com.jandryespol.loteria.App;
import com.jandryespol.loteria.JuegoController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.CRC32;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main {
    private ArrayList<Juego> juegos;
    private Configuracion configuracion;
    public Main(){
        juegos = new ArrayList();
        configuracion = new Configuracion(true,1);
    }
    public void iniciarJuego(ArrayList<Jugador> jugadores, Configuracion conf) throws IOException{
        Juego juego = new Juego(jugadores,conf);
        juegos.add(juego);
        
        FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("juego.fxml"));
        Parent root = (Parent) fXMLLoader.load();
        
        JuegoController jc = fXMLLoader.getController();
        
        jc.atributos(juego);
        
        App.changeRoot(root);
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
