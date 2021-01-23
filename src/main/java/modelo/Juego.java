package modelo;

import com.jandryespol.loteria.App;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Juego extends Thread implements Serializable{
    private String fecha;
    private int duracion;
    private ArrayList<Jugador> jugadores;
    private Jugador ganador;
    private Configuracion configuracion;
    private Mazo mazo;
    private ArrayList<Carta> cartasJugadas;
    private Alineacion alineacion;
    private EnumAlineacion numAlineacion;
    private transient Rectangle view;
    private static final List<EnumAlineacion> VALUES = Collections.unmodifiableList(Arrays.asList(EnumAlineacion.values()));
    
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
    public void verificarJuego(){
        
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
    public void mostrarCartas(Rectangle view){
        ArrayList<Carta> cartas = mazo.getCartas();
        try{
            for(Carta carta : cartas){
                String ruta = carta.getRutaImagen();
                String path = App.class.getResource(App.imagesPath+ruta).getPath(); 
                FileInputStream input = new FileInputStream(path);
                Image img = new Image(input);
                view.setFill(new ImagePattern(img)); 
                cartasJugadas.add(carta);
                this.sleep(3000);
            }
        }catch(FileNotFoundException | InterruptedException err){
            System.out.println("IOException:" + err.getMessage());
        }
    }
    public void setView(Rectangle view){
        this.view = view;
    }
    @Override
    public void run(){
        mostrarCartas(view);
    }
}
