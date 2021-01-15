package com.jandryespol.loteria;

import java.io.IOException;

public class NombreController {
    public void regresarMenu() throws IOException{
        App.setRoot("fxml/inicio");
    }
    public void ok() throws IOException, InterruptedException{
        App.setRoot("fxml/alineacion");
        Thread.sleep(2000);
        App.setRoot("fxml/juego");
    }
}