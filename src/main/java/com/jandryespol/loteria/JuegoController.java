/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jandryespol.loteria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Jandry
 */
public class JuegoController {

    @FXML
    private ImageView taElegido;
    public void loteria(){
        Alert alert = new Alert(AlertType.INFORMATION, "Has ganado!");
alert.showAndWait();
    }

    @FXML
    public void cargarImagen(ActionEvent e) throws FileNotFoundException{
        FileInputStream input=null;
        input = new FileInputStream(App.path+"x_men.jpg");
        Image imagen = new Image(input, 69,152,false, false);
           taElegido.setImage(imagen);
    }
}
