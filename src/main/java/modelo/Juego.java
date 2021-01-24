package modelo;

import com.jandryespol.loteria.App;
import com.jandryespol.loteria.JuegoController;
import static com.jandryespol.loteria.App.main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javafx.scene.image.Image;
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
    private transient Contador counter;
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
    public void perdiste(int i){
        this.setGanador(this.getJugadores().get(i)); //Actualiza ganador
        this.setDuracion(JuegoController.c.getJuego().getDuracion()); //Actualiza duracion del juego
        JuegoController.c.setJuego(this); //Termina el contador
        FileOutputStream fout;  
            try {
                fout = new FileOutputStream(App.reportePath+"juego"+(main.getJuegos().size()-1)+".ser");
                ObjectOutputStream out=new ObjectOutputStream(fout);
                out.writeObject(this);  
                out.flush();
                App.setRoot("perdiste");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
    public void verificarJuego(String rutaJugada){
//        FileInputStream input2 = new FileInputStream(App.class.getResource(App.imagesPath+"pepa.jpg").getPath());
//        Image frejol = new Image(input2);
//        Circle cir = new Circle(10,new ImagePattern(frejol));
        
            for(int i = 1; i < jugadores.size(); i++){
                for(int j=0;j<jugadores.get(i).getTablero().getCartas().size();j++){
                    CartaJuego c = jugadores.get(i).getTablero().getCartas().get(j);
                    if(c.getCarta().getRutaImagen().equals(rutaJugada)){
    //                    oponentes.getChildren().get(i).getChildren().get(j);
                        c.marcarCarta();
                        if(jugadores.get(i).verificarTablero(numAlineacion)){
                            this.perdiste(i);
                        }
                    }
                }
                if(jugadores.size()==3){
                    try {
                        this.sleep(500);
                    } catch (InterruptedException ex) {
                        System.out.println("error");
                    }
                }else if(jugadores.size()==2){
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println("error");
                    }
                }
            }
        
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
                this.verificarJuego(ruta);
                this.sleep(2000);
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
