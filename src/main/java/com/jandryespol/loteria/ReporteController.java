package com.jandryespol.loteria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class ReporteController implements Initializable {

    @FXML Button btnSalir;
    @FXML TableView tablaReporte;
    
    @FXML
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
