package com.jandryespol.loteria;

import java.io.IOException;
import javafx.fxml.FXML;

public class NombreController {
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
    public void ok() throws IOException, InterruptedException{
        App.setRoot("alineacion");
        Thread.sleep(2000);
        App.setRoot("juego");
    }
}