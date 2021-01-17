package com.jandryespol.loteria;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NombreController {

    @FXML
    private TextField field;
     @FXML
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
     @FXML
    public void ok() throws IOException, InterruptedException{
        App.setRoot("juego");
//        Thread.sleep(2000);
//        App.setRoot("juego");
    }
}