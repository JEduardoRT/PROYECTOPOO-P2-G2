package com.jandryespol.loteria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import modelo.Carta;

public class InicioController {
ArrayList<Carta> mazo ;

    @FXML
    private Button botondesalida;
    @FXML
    private Button newGameBtn;
    
    @FXML
    public void iniciarJuego() throws IOException{
        App.setRoot("nombre");
    }
    @FXML
    public void reporte() throws IOException{
        App.setRoot("reporte");
    }
    @FXML
    public void configuracion() throws IOException{
        App.setRoot("configuracion");
    }
     @FXML
    public void salirPrograma(ActionEvent e){
    
            
     System.exit(0);
    }
   
}
