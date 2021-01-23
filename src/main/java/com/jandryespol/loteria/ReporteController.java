package com.jandryespol.loteria;

import static com.jandryespol.loteria.App.main;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import modelo.*;

public class ReporteController implements Initializable {

    @FXML Button btnSalir;
    @FXML GridPane gpReporte;
    
    @FXML
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableView<ArrayList<String>> tablaReporte = new TableView();
        ArrayList<Juego> games = main.getJuegos();
        ObservableList<ArrayList<String>> campos = FXCollections.observableArrayList();
        TableColumn<ArrayList<String>, String> colFecha = new TableColumn<>("Fecha");
        TableColumn<ArrayList<String>, String> colDuracion = new TableColumn<>("Duracion");
        TableColumn<ArrayList<String>, String> colJugador = new TableColumn<>("Jugador");
        TableColumn<ArrayList<String>, String> colOponentes = new TableColumn<>("Cant. de Oponentes");
        TableColumn<ArrayList<String>, String> colAlineacion = new TableColumn<>("Alineacion");
        tablaReporte.getColumns().addAll(colFecha, colDuracion, colJugador,colOponentes,colAlineacion);
        for(Juego juego : games){
            ArrayList<Jugador> players = juego.getJugadores();
            Configuracion conf = juego.getConfiguracion();
            ArrayList<String> datos = new ArrayList();
            datos.add(juego.getFecha());
            datos.add(Integer.toString(juego.getDuracion()));
            datos.add(players.get(0).getNombre());
            datos.add(Integer.toString(conf.getNumOponentes()));
            datos.add(juego.getAlineacion().toString());
            tablaReporte.getItems().add(datos);
        }
        gpReporte.add(tablaReporte,0,1);
    }    
}
