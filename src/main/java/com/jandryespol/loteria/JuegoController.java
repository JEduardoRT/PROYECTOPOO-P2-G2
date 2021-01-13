/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jandryespol.loteria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import modelo.Carta;
import modelo.Mazo;

/**
 *
 * @author Jandry
 */
public class JuegoController {
ArrayList<Carta> mazo ;
    @FXML
    private ImageView taElegido;
     @FXML GridPane gridP;
    public void loteria(){
        Alert alert = new Alert(AlertType.INFORMATION, "Has ganado!");
alert.showAndWait();
    }
public JuegoController() {
    mazo = new ArrayList<Carta>();
 mazo.add(new Carta("1","1"));
    mazo.add(new Carta("2","2"));
    mazo.add(new Carta("3","3"));
    mazo.add(new Carta("4","4"));
    mazo.add(new Carta("5","5"));
    mazo.add(new Carta("6","6"));
    mazo.add(new Carta("7","7"));
    mazo.add(new Carta("8","8"));
    
    mazo.add(new Carta("9","9"));
     mazo.add(new Carta("10","10"));
      mazo.add(new Carta("11","11"));
       mazo.add(new Carta("12","12"));
}
    @FXML
    public void cargarImagen(ActionEvent e) throws FileNotFoundException{
        FileInputStream input=null;
        input = new FileInputStream(App.path+"x_men.jpg");
        Image imagen = new Image(input, 69,152,false, false);
           taElegido.setImage(imagen);
    
    }
     @FXML
    private void initialize() throws FileNotFoundException  {
//   Rectangle rect = new Rectangle(100,153);
  
        FileInputStream input=null;
       
        
        for (int i=0;i<mazo.size();i++){
            StackPane sp = new StackPane();


            int fila = i/4;
            int columna = i%4;
            input = new FileInputStream(App.path+mazo.get(i).getNombreImagen()+".jpg");
         Image imagen = new Image(input, 69,152,false, false);
//        input = new FileInputStream(App.path+"1");
//        Image imagen = new Image(input, 69,152,false, false);
//           taElegido.setImage(imagen

            Label lb = new Label(mazo.get(i).getNombreImagen()
            );
            sp.getChildren().add(new Circle(30,new ImagePattern(imagen    )));
            
            gridP.add(sp, columna, fila);
//            new Circle(15,
//new ImagePattern(new Image(input+"1")))
                    
            lb.setOnMouseClicked(e->{
                   Label lbx = new Label("X");
                   sp.getChildren().add(lbx);
            });
        }
    }
}
