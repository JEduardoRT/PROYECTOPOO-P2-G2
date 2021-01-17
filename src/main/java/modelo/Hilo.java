package modelo;

import com.jandryespol.loteria.App;
import com.jandryespol.loteria.JuegoController;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import modelo.Carta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Hilo extends Thread {
    private int count = 0;
    private Text text;
    private ArrayList<Carta> carta;
   

    public Hilo(Text text) {
        this.text = text;//recibe el nodo a modificar
        carta = new ArrayList<Carta>();
       
       
    }



  

   

    private void incrementCount() {
        count++;
        text.setText(Integer.toString(count));//actualiza la cuenta
    }
public void valorDelacondicio(ArrayList<Carta> carta){
this.carta = carta;


}
    @Override
    public void run()  {
         while (true) {
    
                try {
                    Hilo.sleep(1000);//duerme 1 segundo
             
                } catch (InterruptedException ex) {
                }
     
          
incrementCount();
           

            
        }
    }}

