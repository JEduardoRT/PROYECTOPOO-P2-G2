/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jandryespol.loteria;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Jandry
 */
public class PerdisteController {
    @FXML
    public void volver() throws IOException{
        App.setRoot("Inicio");
    }
}
