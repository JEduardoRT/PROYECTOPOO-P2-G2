package com.jandryespol.modelo;

import com.jandryespol.loteria.App;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main {
    private ArrayList<Juego> juegos;
    private Configuracion configuracion;
    public Main() throws ClassNotFoundException{
        juegos = new ArrayList();
        configuracion = new Configuracion(true,1);
        try{
            BufferedReader br = new BufferedReader(new FileReader(App.cantJuegosPath));
            String cant;
            int i=0;
            while((cant=br.readLine())!=null){
                i = Integer.parseInt(cant);
            }
            if(i>0){
                for(int j=0;j<i;j++){
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(App.reportePath+"juego"+j+".ser"));
                    Juego e = (Juego)in.readObject();
                    juegos.add(e);
                }
            }
        }catch(IOException | NumberFormatException err){
            System.out.println(err);
        }
    }
    public void iniciarJuego(ArrayList<Jugador> jugadores, Configuracion conf) throws IOException{
        Juego juego = new Juego(jugadores,conf);
        juegos.add(juego);
        FileOutputStream fout=new FileOutputStream(App.reportePath+"juego"+(juegos.size()-1)+".ser");  
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(juego);  
        out.flush();
        String cant=null;
        String var=null;
        try (BufferedReader br = new BufferedReader(new FileReader(App.cantJuegosPath))){
            while((cant=br.readLine())!=null){
                int i = Integer.parseInt(cant);
                i++;
                var = Integer.toString(i);
            }
            if(var==null)
                var="1";
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(App.cantJuegosPath))) {
            bw.write(var);
        }
        FXMLLoader fXMLLoader = new FXMLLoader(App.class.getResource("juego.fxml"));
        Parent root = (Parent) fXMLLoader.load();
        App.changeRoot(root);
    }
    public ArrayList<Juego> getJuegos(){
        return juegos;
    }
    public void setConfiguracion(Configuracion conf){
        configuracion = conf;
    }
    public Configuracion getConfiguracion(){
        return configuracion;
    }
}
