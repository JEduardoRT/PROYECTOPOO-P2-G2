/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jandryespol.loteria.modelo;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Jandry
 */
public class MalaCarta extends Thread{
    private Rectangle rect;
    private Image image;
    public void malaCarta(Rectangle rect,Image image){
        try {
            Paint carta = rect.getFill();
            rect.setFill(new ImagePattern(image));
            this.sleep(500);
            rect.setFill(carta);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public MalaCarta(Rectangle rect,Image image){
        this.rect = rect;
        this.image = image;
    }
    @Override
    public void run(){
        malaCarta(rect,image);
    }
}
