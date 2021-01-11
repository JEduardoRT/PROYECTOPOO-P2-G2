package com.jandryespol.loteria;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {

    @FXML
    private Button botondesalida;
    
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
