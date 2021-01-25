package com.jandryespol.loteria;

import static com.jandryespol.loteria.App.main;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import com.jandryespol.loteria.modelo.*;

public class ReporteController implements Initializable {

    @FXML Button btnSalir;
    @FXML GridPane gpReporte;
    public class JuegoReporte {
        private final SimpleStringProperty fecha;
        private SimpleStringProperty duracion;
        private SimpleStringProperty jugador;
        private SimpleStringProperty oponentes;
        private SimpleStringProperty alineacion;
        public JuegoReporte(String fecha,String duracion,String jugador,String oponentes,String alineacion){
            this.fecha = new SimpleStringProperty(fecha);
            this.duracion = new SimpleStringProperty(duracion);
            this.jugador = new SimpleStringProperty(jugador);
            this.oponentes = new SimpleStringProperty(oponentes);
            this.alineacion = new SimpleStringProperty(alineacion);
        }
        public String getFecha(){
            return fecha.get();
        }
        public String getDuracion(){
            return duracion.get();
        }
        public String getJugador(){
            return jugador.get();
        }
        public String getOponentes(){
            return oponentes.get();
        }
        public String getAlineacion(){
            return alineacion.get();
        }
    }
    @FXML
    public void regresarMenu() throws IOException{
        App.setRoot("inicio");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableView<JuegoReporte> tablaReporte = new TableView();
        TableColumn<JuegoReporte, String> colFecha = new TableColumn<>("Fecha");
        colFecha.setCellValueFactory(new PropertyValueFactory<JuegoReporte, String>("fecha"));
        TableColumn<JuegoReporte, String> colDuracion = new TableColumn<>("Duracion");
        colDuracion.setCellValueFactory(new PropertyValueFactory<JuegoReporte, String>("duracion"));
        TableColumn<JuegoReporte, String> colJugador = new TableColumn<>("Jugador");
        colJugador.setCellValueFactory(new PropertyValueFactory<JuegoReporte, String>("jugador"));
        TableColumn<JuegoReporte, String> colOponentes = new TableColumn<>("Cant. de Oponentes");
        colOponentes.setCellValueFactory(new PropertyValueFactory<JuegoReporte, String>("oponentes"));
        TableColumn<JuegoReporte, String> colAlineacion = new TableColumn<>("Alineacion");
        colAlineacion.setCellValueFactory(new PropertyValueFactory<JuegoReporte, String>("alineacion"));
        tablaReporte.getColumns().addAll(colFecha, colDuracion, colJugador,colOponentes,colAlineacion);
        ArrayList<Juego> games = main.getJuegos();
        ObservableList<JuegoReporte> registros = FXCollections.observableArrayList();
        for(Juego juego : games){
            String fecha = juego.getFecha();
            String duracion = Integer.toString(juego.getDuracion());
            String jugador = juego.getJugadores().get(0).getNombre();
            String oponentes = Integer.toString(juego.getConfiguracion().getNumOponentes());
            String alineacion = juego.getNumAlineacion().toString();
            JuegoReporte guardar = new JuegoReporte(fecha,duracion,jugador,oponentes,alineacion);
            registros.add(guardar);
        }
        tablaReporte.setItems(registros);
        gpReporte.add(tablaReporte,0,1);
    }    
}
