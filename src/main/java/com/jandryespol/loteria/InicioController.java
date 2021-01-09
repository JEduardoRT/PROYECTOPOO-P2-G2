package com.jandryespol.loteria;

import java.io.IOException;
import javafx.fxml.FXML;

public class InicioController {

    @FXML
    public void iniciarJuego() throws IOException{
        App.setRoot("nombre");
    }
    public void reporte() throws IOException{
        App.setRoot("reporte");
    }
    public void configuracion() throws IOException{
        App.setRoot("configuracion");
    }
}
