package com.jandryespol.loteria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class ConfiguracionController{
    
    public String cant;
    public String visibilidad;
    @FXML Button btnGuardar;
    @FXML Button btnSalir;
    @FXML Button btnVisibilidad;
    @FXML ComboBox cbCantidad;
    
    @FXML
    public void guardar() throws IOException{
        cant = cbCantidad.getValue() == null ? "1" : cbCantidad.getValue().toString(); //Almacenando la cantidad de oponentes
        visibilidad = btnVisibilidad.getText(); //Almacenando si el enemigo es visible
         try (BufferedWriter bw = new BufferedWriter(new FileWriter(App.confPath))){
            bw.write(cant+"\n");
            bw.flush();
            bw.write(visibilidad);
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }
        App.setRoot("Inicio");
    }
    @FXML
    public void salir() throws  IOException{
        App.setRoot("Inicio");
    }
    @FXML
    public void initialize(){
        cbCantidad.getItems().setAll(Arrays.asList("1", "2"));
        try (BufferedReader br = new BufferedReader(new FileReader(App.confPath))){
            String line;
            while ((line = br.readLine()) != null) {
                if(!line.equals("1") || !line.equals("2"))
                    btnVisibilidad.setText(line);
            }
        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }
    }
    @FXML
    public  void cambiarVisibilidad(){
        if(btnVisibilidad.getText().equals("Visible"))
            btnVisibilidad.setText("No visible");
        else
            btnVisibilidad.setText("Visible");
    }   
}
