/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jandryespol.loteria;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author ken
 */
public class PruebaController implements Initializable {


    @FXML
    private ImageView taElegido;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void cargarImagen(ActionEvent event) throws FileNotFoundException {
          FileInputStream input=null;
        input = new FileInputStream(App.path+"1.jpg");
        
        Image imagen = new Image(input, 69,152,false, false);
           taElegido.setImage(imagen);
    }

}
