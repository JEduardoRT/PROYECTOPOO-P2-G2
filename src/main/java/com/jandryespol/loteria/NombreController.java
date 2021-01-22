package com.jandryespol.loteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.*;

public class NombreController {
    
    ArrayList<Jugador> players;
    Configuracion conf;

    @FXML
    private TextField field;
     @FXML
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
     @FXML
    public void ok() throws IOException, InterruptedException{
        String nombre = field.getText();
        players = new ArrayList();
        players.add(new Jugador(nombre,new Tablero()));
        
        BufferedReader br = new BufferedReader(new FileReader(App.confPath));
            String op = br.readLine();
            String visibilidad = br.readLine();
            boolean vb=true;
            if(visibilidad.equals("Visible"))
                vb = true;
            else
                vb= false;
            conf = new Configuracion(vb,Integer.parseInt(op));
            if(op.equals("1"))
                players.add(new Jugador("maquina1",new Tablero()));
            else{
                players.add(new Jugador("maquina1",new Tablero()));
                players.add(new Jugador("maquina2",new Tablero()));
            }
            App.main.iniciarJuego(players,conf);
//        } catch(IOException err){
//            System.out.println("IOException:" + err.getMessage());
//        }
        
    }
}