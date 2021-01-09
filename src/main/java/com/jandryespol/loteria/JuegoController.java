/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jandryespol.loteria;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Jandry
 */
public class JuegoController {
    public void loteria(){
        Alert alert = new Alert(AlertType.INFORMATION, "Has ganado!");
alert.showAndWait();
    }
}
