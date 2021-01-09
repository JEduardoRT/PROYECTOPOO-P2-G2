package com.jandryespol.loteria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ConfiguracionController implements Initializable {
    
    @FXML Button btnSalir;
    @FXML ComboBox cbVisibilidad;
    @FXML ComboBox cbCantidad;
    
    @FXML
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
