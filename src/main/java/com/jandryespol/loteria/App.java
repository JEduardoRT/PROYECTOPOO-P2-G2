package com.jandryespol.loteria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import modelo.Main;

public class App extends Application {
    public static String imagesPath="images/";
    public static String confPath="archivos/conf.txt";
    public static String reportePath="archivos/reporte.txt";
    private static Scene scene; 
    public static Main main;
    @Override
    public void start(Stage stage) throws IOException {
        main = new Main();
        scene = new Scene(loadFXML("Inicio"), 960, 540);
        stage.setScene(scene);
        stage.show();
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }
    //Metodo para cambiar el contenido de una escena
    public static void changeRoot(Parent rootNode){
        scene.setRoot(rootNode);
    }
}