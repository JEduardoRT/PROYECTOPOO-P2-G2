package com.jandryespol.loteria;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class InicioController {
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
