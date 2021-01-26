package com.jandryespol.loteria;
import static com.jandryespol.loteria.App.main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import com.jandryespol.modelo.*;
public class JuegoController{
    static ImagePattern frejolImg;
    static ImagePattern matchImg;
    static Hilo hilo;
    Juego actualGame;
    static ArrayList<Rectangle> machine1;
    static ArrayList<Rectangle> machine2;
    public static Contador c;
    @FXML 
    private ImageView comoGanar;
    @FXML
    GridPane gridPlayer;
    @FXML
    HBox oponentes;
    @FXML
    Rectangle cartaJugando;
    public class Hilo extends Thread{
        public void perdiste(int i){
            actualGame.setGanador(actualGame.getJugadores().get(i)); //Actualiza ganador
            actualGame.setDuracion(c.getJuego().getDuracion()); //Actualiza duracion del juego
            JuegoController.c.setJuego(actualGame); //Termina el contador
            FileOutputStream fout;  
            try {
                fout = new FileOutputStream(App.reportePath+"juego"+(main.getJuegos().size()-1)+".ser");
                ObjectOutputStream out=new ObjectOutputStream(fout);
                out.writeObject(actualGame);  
                out.flush();
                App.setRoot("perdiste");
                this.stop();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        public void verificarMaquina(String rutaJugada){
            for(int i = 1; i < actualGame.getJugadores().size(); i++){
                for(int j=0;j<actualGame.getJugadores().get(i).getTablero().getCartas().size();j++){
                    CartaJuego c = actualGame.getJugadores().get(i).getTablero().getCartas().get(j);
                    if(c.getCarta().getRutaImagen().equals(rutaJugada)){
                        switch(i){
                            case 1:
                                if(actualGame.getConfiguracion().getVisibilidad())
                                    machine1.get(j).setFill(frejolImg);
                                else
                                    machine1.get(j).setFill(matchImg);
                                break;
                            case 2:
                                if(actualGame.getConfiguracion().getVisibilidad())
                                    machine2.get(j).setFill(frejolImg);
                                else
                                    machine2.get(j).setFill(matchImg);
                                break;
                            default:
                                break;
                        }
                        c.marcarCarta();
                        if(actualGame.getJugadores().get(i).verificarTablero(actualGame.getNumAlineacion())){
                            this.perdiste(i);
                        }
                    }
                }
                if(actualGame.getJugadores().size()==3){
                    try {
                        this.sleep(500);
                    } catch (InterruptedException ex) {
                        System.out.println("error");
                    }
                }else if(actualGame.getJugadores().size()==2){
                    try {
                        this.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println("error");
                    }
                }
            } 
        }
        public void mostrarCartas(Rectangle view){
            ArrayList<Carta> cartas = actualGame.getMazo().getCartas();
            try{
                while(actualGame.getGanador()==null){
                    for(Carta carta : cartas){
                        String ruta = carta.getRutaImagen();
                        String path = App.class.getResource(App.imagesPath+ruta).getPath(); 
                        FileInputStream input = new FileInputStream(path);
                        Image img = new Image(input);
                        view.setFill(new ImagePattern(img)); 
                        actualGame.getCartasJugadas().add(carta);
                        this.sleep(1000);
                        this.verificarMaquina(ruta);
                        this.sleep(1000);
                    }
                }
            }catch(FileNotFoundException | InterruptedException err){
                System.out.println("IOException:" + err.getMessage());
            }
        }
        @Override
        public void run(){
            mostrarCartas(cartaJugando);
        }
    }
    @FXML
    public void initialize() throws FileNotFoundException, IOException{
        machine1 = new ArrayList();
        machine2 = new ArrayList();
        FileInputStream input2 = new FileInputStream(App.class.getResource(App.imagesPath+"pepa.png").getPath());
        Image frejol = new Image(input2);
        frejolImg = new ImagePattern(frejol);
        FileInputStream matchInput = new FileInputStream(App.class.getResource(App.imagesPath+"match.png").getPath());
        Image match = new Image(matchInput);
        matchImg = new ImagePattern(match);
        ArrayList<Juego> games = App.main.getJuegos();
        actualGame = games.get(games.size()-1);
        c = new Contador(actualGame);
        c.setDaemon(true);
        c.start();
        FileInputStream input;
        String path = App.class.getResource(App.imagesPath+actualGame.getAlineacion().getRuta()).getPath();   
        input = new FileInputStream(path);
        Image imagen = new Image(input,132,197,true,false);
        comoGanar.setImage(imagen);
        ArrayList<Jugador> players = actualGame.getJugadores();
        for(int i=0;i<players.size();i++){
            players.get(i).getTablero().llenarTablero(actualGame.getMazo().getCartas());
        }
        llenarGridPaneP(gridPlayer,players.get(0).getTablero().getCartas(),76,107,20);
        GridPane gp;
        if(actualGame.getConfiguracion().getVisibilidad()){
            if(actualGame.getJugadores().size()==2){
                gp = new GridPane();
                llenarGridPaneM(gp,players.get(1).getTablero().getCartas(),36,51,machine1);
                oponentes.getChildren().add(gp);
            }else{
                gp = new GridPane();
                llenarGridPaneM(gp,players.get(1).getTablero().getCartas(),36,51,machine1);
                oponentes.getChildren().add(gp);
                gp = new GridPane();
                llenarGridPaneM(gp,players.get(2).getTablero().getCartas(),36,51,machine2);
                oponentes.getChildren().add(gp);
            }
        }else{
            if(actualGame.getJugadores().size()==2){
                gp = new GridPane();
                llenarGridPaneV(gp,36,51,machine1);
                oponentes.getChildren().add(gp);
            }else{
                gp = new GridPane();
                llenarGridPaneV(gp,36,51,machine1);
                oponentes.getChildren().add(gp);
                gp = new GridPane();
                llenarGridPaneV(gp,36,51,machine2);
                oponentes.getChildren().add(gp);
            }
        }
        hilo = new Hilo();
        hilo.setDaemon(true);
        hilo.start();
    }
    public void llenarGridPaneV(GridPane gp, int ancho, int largo, ArrayList<Rectangle> machine) throws FileNotFoundException{
        FileInputStream input;
        Image imagen;
        FileInputStream vacioInput;
        Image vacio;
        int col;
        int fil;
        for(int i=0;i<16;i++){
            StackPane sp = new StackPane();
            String path = App.class.getResource(App.imagesPath+"back.png").getPath();  
            input = new FileInputStream(path);
            imagen = new Image(input);
            Rectangle rect = new Rectangle(ancho,largo,new ImagePattern(imagen));
            String vacioPath = App.class.getResource(App.imagesPath+"vacio.png").getPath();  
            vacioInput = new FileInputStream(vacioPath);
            vacio = new Image(vacioInput);
            Rectangle rect2 = new Rectangle(ancho,largo,new ImagePattern(vacio));
            col = i%4;
            fil = i/4;
            sp.getChildren().add(rect);
            sp.getChildren().add(rect2);
            machine.add(rect2);
            gp.add(sp, col, fil);
        }
    }
    public void llenarGridPaneM(GridPane gp, ArrayList<CartaJuego> cartas, int ancho, int largo, ArrayList<Rectangle> machine) throws FileNotFoundException{
        FileInputStream input;
        Image imagen;
        FileInputStream vacioInput;
        Image vacio;
        int col;
        int fil;
        for(int i=0;i<16;i++){
            StackPane sp = new StackPane();
            String carta = cartas.get(i).getCarta().getRutaImagen();
            String path = App.class.getResource(App.imagesPath+carta).getPath();  
            input = new FileInputStream(path);
            imagen = new Image(input);
            Rectangle rect = new Rectangle(ancho,largo,new ImagePattern(imagen));
            String vacioPath = App.class.getResource(App.imagesPath+"vacio.png").getPath();  
            vacioInput = new FileInputStream(vacioPath);
            vacio = new Image(vacioInput);
            Rectangle rect2 = new Rectangle(ancho,ancho,new ImagePattern(vacio));
            col = i%4;
            fil = i/4;
            sp.getChildren().add(rect);
            sp.getChildren().add(rect2);
            machine.add(rect2);
            gp.add(sp, col, fil);
        }
    }
    public void llenarGridPaneP(GridPane gp, ArrayList<CartaJuego> cartas,int ancho, int largo, int radio) throws FileNotFoundException{
        FileInputStream input;
        FileInputStream input2;
        Image imagen;
        Image frejol;
        int col;
        int fil;
        for(int i=0;i<16;i++){
            StackPane sp = new StackPane();
            String carta = cartas.get(i).getCarta().getRutaImagen();
            String path = App.class.getResource(App.imagesPath+carta).getPath();  
            input = new FileInputStream(path);
            input2 = new FileInputStream(App.class.getResource(App.imagesPath+"pepa.png").getPath());
            FileInputStream input3 = new FileInputStream(App.class.getResource(App.imagesPath+"equis.png").getPath());
            imagen = new Image(input);
            frejol = new Image(input2);
            Image malaCarta = new Image(input3);
            Rectangle rect = new Rectangle(ancho,largo,new ImagePattern(imagen));
            col = i%4;
            fil = i/4;
            sp.getChildren().add(rect);
            Circle cirP = new Circle(radio,new ImagePattern(frejol));
            rect.setOnMouseClicked(e->{
                ArrayList<Carta> cartasJugadas = actualGame.getCartasJugadas();
                ArrayList<CartaJuego> cJ = actualGame.getJugadores().get(0).getTablero().getCartas();
                if(carta.equals(cartasJugadas.get(cartasJugadas.size()-1).getRutaImagen())){
                    sp.getChildren().add(cirP);
                    String ruta;
                    for(CartaJuego ca : cJ){
                        ruta = ca.getCarta().getRutaImagen();
                        if(ruta.equals(carta))
                            ca.marcarCarta();
                    }
                }else{
                    MalaCarta mc = new MalaCarta(rect, malaCarta);
                    mc.start();
                }
            });
            gp.add(sp, col, fil);
        }
    }
    @FXML
    public void loteria(){
        if(actualGame.getJugadores().get(0).verificarTablero(actualGame.getNumAlineacion())){ //Verifica que se cumpla la alineacion
            actualGame.setGanador(actualGame.getJugadores().get(0)); //Actualiza ganador
            actualGame.setDuracion(c.getJuego().getDuracion()); //Actualiza duracion del juego
            c.setJuego(actualGame); //Termina el contador
            FileOutputStream fout;  
            try {
                fout = new FileOutputStream(App.reportePath+"juego"+(main.getJuegos().size()-1)+".ser");
                ObjectOutputStream out=new ObjectOutputStream(fout);
                out.writeObject(actualGame);  
                out.flush();
                hilo.stop();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Loteria");
                alert.setHeaderText("Fin del juego");
                alert.setContentText("Has ganado!");
                alert.showAndWait();
                App.setRoot("Inicio");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else
            System.out.println("Sigue jugando");
    }
}