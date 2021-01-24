package com.jandryespol.loteria;
import static com.jandryespol.loteria.App.main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import modelo.*;
public class JuegoController{
    Juego actualGame;
    Contador c;
    @FXML 
    private ImageView comoGanar;
    @FXML
    GridPane gridPlayer;
    @FXML
    HBox oponentes;
    @FXML
    Rectangle cartaJugando;
    @FXML
    public void initialize() throws FileNotFoundException{
        ArrayList<Juego> games = App.main.getJuegos();
        System.out.println(games);
        actualGame = games.get(games.size()-1);
        c = new Contador(actualGame);
        c.setDaemon(true);
        c.start();
        FileInputStream input=null;
        String path = App.class.getResource(App.imagesPath+actualGame.getAlineacion().getRuta()).getPath();   
        input = new FileInputStream(path);
        Image imagen = new Image(input,132,197,true,false);
        comoGanar.setImage(imagen);
        ArrayList<Jugador> players = actualGame.getJugadores();
        for(int i=0;i<players.size();i++){
            players.get(i).getTablero().llenarTablero(actualGame.getMazo().getCartas());
        }
        GridPane gp;
        llenarGridPaneP(gridPlayer,players.get(0).getTablero().getCartas(),76,107,15);
        if(actualGame.getConfiguracion().getVisibilidad()){
            if(actualGame.getJugadores().size()==2){
                gp = new GridPane();
                llenarGridPaneM(gp,players.get(1).getTablero().getCartas(),36,51,10);
                oponentes.getChildren().add(gp);
            }else{
                gp = new GridPane();
                llenarGridPaneM(gp,players.get(1).getTablero().getCartas(),36,51,10);
                oponentes.getChildren().add(gp);
                gp = new GridPane();
                llenarGridPaneM(gp,players.get(2).getTablero().getCartas(),36,51,10 );
                oponentes.getChildren().add(gp);
            }
        }else{
            if(actualGame.getJugadores().size()==2){
                gp = new GridPane();
                llenarGridPaneV(gp,36,51,10);
                oponentes.getChildren().add(gp);
            }else{
                gp = new GridPane();
                llenarGridPaneV(gp,36,51,10);
                oponentes.getChildren().add(gp);
                gp = new GridPane();
                llenarGridPaneV(gp,36,51,10 );
                oponentes.getChildren().add(gp);
            }
        }
        actualGame.setView(cartaJugando);
        actualGame.setDaemon(true);
        actualGame.start();
    }
    public void llenarGridPaneV(GridPane gp, int ancho, int largo, int radio) throws FileNotFoundException{
        FileInputStream input;
        Image imagen;
        int col;
        int fil;
        for(int i=0;i<16;i++){
            StackPane sp = new StackPane();
            String path = App.class.getResource(App.imagesPath+"back.png").getPath();  
            input = new FileInputStream(path);
            imagen = new Image(input);
            Rectangle rect = new Rectangle(ancho,largo,new ImagePattern(imagen));
            col = i%4;
            fil = i/4;
            sp.getChildren().add(rect);
            gp.add(sp, col, fil);
        }
    }
    public void llenarGridPaneM(GridPane gp, ArrayList<CartaJuego> cartas, int ancho, int largo, int radio) throws FileNotFoundException{
        FileInputStream input;
        Image imagen;
        int col;
        int fil;
        for(int i=0;i<16;i++){
            StackPane sp = new StackPane();
            String carta = cartas.get(i).getCarta().getRutaImagen();
            String path = App.class.getResource(App.imagesPath+carta).getPath();  
            input = new FileInputStream(path);
            imagen = new Image(input);
            Rectangle rect = new Rectangle(ancho,largo,new ImagePattern(imagen));
            col = i%4;
            fil = i/4;
            sp.getChildren().add(rect);
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
            input2 = new FileInputStream(App.class.getResource(App.imagesPath+"pepa.jpg").getPath());
            FileInputStream input3 = new FileInputStream(App.class.getResource(App.imagesPath+"equis.png").getPath());
            imagen = new Image(input);
            frejol = new Image(input2);
            Image malaCarta = new Image(input3);
            Rectangle rect = new Rectangle(ancho,largo,new ImagePattern(imagen));
            col = i%4;
            fil = i/4;
            sp.getChildren().add(rect);
            Circle cir = new Circle(radio,new ImagePattern(frejol));
            rect.setOnMouseClicked(e->{
                ArrayList<Carta> cartasJugadas = actualGame.getCartasJugadas();
                ArrayList<CartaJuego> cJ = actualGame.getJugadores().get(0).getTablero().getCartas();
                if(carta.equals(cartasJugadas.get(cartasJugadas.size()-1).getRutaImagen())){
                    sp.getChildren().add(cir);
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
                Alert alert = new Alert(AlertType.INFORMATION, "Has ganado!");
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



