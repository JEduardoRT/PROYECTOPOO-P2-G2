package com.jandryespol.loteria;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ConfiguracionController{
    
    @FXML Button btnSalir;
    @FXML Button btnVisibilidad;
    @FXML ComboBox cbCantidad;
    
    @FXML
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
    @FXML
    public  void cambiarVisibilidad(){
        if(btnVisibilidad.getText().equals("Visible")){
            btnVisibilidad.setText("No visible");
            
        }
        else{
            btnVisibilidad.setText("Visible");
}        }
    
}
