package com.jandryespol.loteria;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import modelo.*;
public class JuegoController{
    //Atributos
    ArrayList<Jugador> jugadores;
    Configuracion conf;
    Alineacion alineacion;
    Juego juego;
    
    @FXML 
    private ImageView comoGanar;
    
    //Metodo para recuperar la configuracion y jugadores
    public void atributos(Juego juego){
        this.jugadores = juego.getJugadores();
        this.conf = juego.getConfiguracion();
        this.alineacion = juego.generarAlineacion();
        this.juego = juego;
    }
    
//ArrayList<Carta> mazo ;
//@FXML private Text conteo;
//
//ArrayList<Carta> mazo_forma ;
//private ArrayList<Posicion> coor ;
//
//@FXML private ImageView taElegido;
//@FXML private GridPane gridP;
//@FXML private GridPane gridOponente;
//@FXML private GridPane comoganar;
//@FXML private GridPane cartaenjuego1;
//@FXML private ImageView imagencarta;
//public void loteria(){
//    int cuentaposicion =0;
//        System.out.println("coordenada Mazo coordenada "+Cambioimagenes.Mazo_coordenada.toString());
//        System.out.println("coordena coor  "+coor.toString() );
//            for (int i = 0; i < Cambioimagenes.Mazo_coordenada.size(); i++) {
//                for (int j = 0; j < coor.size(); j++) {
//                    if((Cambioimagenes.Mazo_coordenada.get(i).getColu()==coor.get(j).getColu())&&Cambioimagenes.Mazo_coordenada.get(i).getFila()==coor.get(j).getFila()){
//                       
//                     cuentaposicion++;
//                  System.out.println("Acientos......."+cuentaposicion);
//                    }
//
//            }
//            }
//           if(cuentaposicion ==4){
//         Alert alert = new Alert(AlertType.INFORMATION, "Has ganado!");
//alert.showAndWait();
//           }
//           else
//               System.out.println("Sigue juegando");
//         System.out.println("Mazo coordenadas"+Cambioimagenes.Mazo_coordenada.toString());
//                     System.out.println("Acientos"+coor.toString());
//}
//
//public JuegoController() {
//    
//    mazo_forma = new ArrayList<Carta>();
//    mazo = new ArrayList<Carta>();
//    mazo.add(new Carta("1","1"));
//    mazo.add(new Carta("2","2"));
//    mazo.add(new Carta("3","3"));
//    mazo.add(new Carta("4","4"));
//    mazo.add(new Carta("5","5"));
//    mazo.add(new Carta("6","6"));
//    mazo.add(new Carta("7","7"));
//    mazo.add(new Carta("8","8"));
//    mazo.add(new Carta("9","9"));
//   mazo.add(new Carta("10","10"));
//   mazo.add(new Carta("11","11"));
//   mazo.add(new Carta("12","12"));
//   mazo.add(new Carta("13","13"));
//   mazo.add(new Carta("14","14"));
//   mazo.add(new Carta("15","15"));
//   mazo.add(new Carta("16","16"));
//   mazo.add(new Carta("17","17"));
//   mazo.add(new Carta("18","18"));
//   mazo.add(new Carta("19","19"));
//   mazo.add(new Carta("20","20"));
//   mazo.add(new Carta("21","21"));
//   mazo.add(new Carta("22","22"));
//   mazo.add(new Carta("23","23"));
//   mazo.add(new Carta("24","24"));
//   mazo.add(new Carta("25","25"));
//   mazo.add(new Carta("26","26"));
//   mazo.add(new Carta("27","27"));
//   mazo.add(new Carta("28","28"));
//   mazo.add(new Carta("29","29"));
//   mazo.add(new Carta("30","30"));
//   mazo.add(new Carta("31","31"));
//   mazo.add(new Carta("32","32"));
//   mazo.add(new Carta("33","33"));
//   mazo.add(new Carta("34","34"));
//   mazo.add(new Carta("35","35"));
//   mazo.add(new Carta("36","36"));
//   mazo.add(new Carta("37","37"));
//   mazo.add(new Carta("38","38"));
//   mazo.add(new Carta("39","39"));
//   mazo.add(new Carta("40","40"));
//   mazo.add(new Carta("41","41"));
//   mazo.add(new Carta("42","42"));
//   mazo.add(new Carta("43","43"));
//   mazo.add(new Carta("44","44"));
//   mazo.add(new Carta("45","45"));
//   mazo.add(new Carta("46","46"));
//   mazo.add(new Carta("47","47"));
//   mazo.add(new Carta("48","48"));
//   mazo.add(new Carta("49","49"));
//   mazo.add(new Carta("50","50"));
//   mazo.add(new Carta("51","51"));
//   mazo.add(new Carta("52","52"));
//   mazo.add(new Carta("53","53"));
//   mazo.add(new Carta("54","54"));
//}
////    public void cargarImagen(ActionEvent e) throws FileNotFoundException{
////        FileInputStream input=null;
////        input = new FileInputStream(App.path+"x_men.jpg");
////        Image imagen = new Image(input, 69,152,false, false);
////           taElegido.setImage(imagen);
////    
////    }
//@FXML
//public void cargarTablero(GridPane G, int ancho,int largo ,int radio) throws FileNotFoundException{
// //Estos archivos debe esta fuera de while
// FileInputStream input=null;
// FileInputStream input2=null;
// input = new FileInputStream(App.imagespath+"pepa"+".jpg");
// Image imagen2 = new Image(input, 67,150,false, false);
// Random numero = new Random();
// ArrayList<Carta> mazo1 = new ArrayList<Carta>();
// int N;
// int i =0;
//
//    while(mazo1.size()<16){
//        StackPane sp = new StackPane();
//         N = (int)(numero.nextInt(53
//         )+1);
//         String numerostring = String.valueOf(N);
//         int fila = i/4;
//         System.out.println("fila"+fila);
//         int columna = i%4;
//         System.out.println("columna"+columna);
////            App.path+mazo.get(N).getNombreImagen()+".jpg"
//         input = new FileInputStream(App.imagespath+numerostring+".jpg");
//         Image imagen = new Image(input, 67,150,false, false);
//           if(!mazo1.contains(mazo.get(N))){
//           mazo1.add(mazo.get(N));
//           i = i+1;
//           }
//                   Rectangle rect = new Rectangle(ancho,largo,new ImagePattern(imagen));
//
//           Circle cir = new Circle(radio,new ImagePattern(imagen2));
//         
//            sp.getChildren().add(rect);
//            G.add(sp, columna, fila);
//
//            rect.setOnMouseClicked(e->{
//                
//              
//                   sp.getChildren().add(cir);
//            });
//        }
//    try {
//        input.close();
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    }
//}
//@FXML
//public void cartaEnjuego(GridPane ta) throws FileNotFoundException{
//   
//    StackPane sp = new StackPane();
//      int N;
//    Random numero = new Random();
//    
//     N = (numero.nextInt(53
//     )+1);
//    FileInputStream input=null;
//   
//        input = new FileInputStream(App.imagespath+mazo.get(N).getNombreImagen()+".jpg");
//        Image imagen = new Image(input, 200,274,false, false);
//        Rectangle rect = new Rectangle(200,274,new ImagePattern(imagen));
////            Circle cir = new Circle(100,new ImagePattern(imagen));
//         
//        sp.getChildren().add(rect);
//                   
//         
//            ta.add(sp, 0, 0);
//    try {
//        input.close();
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    }
//
//}
//@FXML
//public void formaGanar(GridPane G) throws FileNotFoundException, IOException{
//    Random r = new Random();
//    int valorDado = r.nextInt(2)+1;
//    FileInputStream input=null;
//    input = new FileInputStream(App.imagespath+"rojo"+".jpg");
//    Image image = new Image(input, 20,20,false, false);/// La imagen de punto rojo
//    StackPane stck;
//    switch(valorDado){
//        case 1:
//            
//            for(int i=0;i<4;i++){
//                for(int j=0;j<4;j++){
//                    stck = new StackPane();
//                    Circle circle = new Circle(10);
//                    stck.getChildren().add(circle);
//                    G.add(stck,i,j);
//                }
//            }
//            for(int i=1;i<3;i++){
//                for(int j=1;j<3;j++){
//                    stck = new StackPane();
//                    Circle cir = new Circle(10, new ImagePattern(image));
//                    stck.getChildren().add(cir);
//                    G.add(stck,i,j);
//                }
//            }
//            break;
//        case 2:
//            Random numero = new Random();
//        Random fila_colu = new Random();
//        int nu = (int)numero.nextInt(2);
//        int nu2 = (int)fila_colu.nextInt(4);
//        int fila;
//           if (nu==0) {
//             fila = nu2;
//             int i =0;
//             while(i<4){
//             stck = new StackPane();
//
//             System.out.println("fila"+fila);
//             int columna = i%4;
//             System.out.println("columna"+columna);
//             Circle cir = new Circle(10,new ImagePattern(image));
//             stck.getChildren().add(cir);
//             mazo_forma.add(new Carta("default","default",new Posicion(fila,columna)));
//                 System.out.println("TAMAÑO"+mazo_forma.size());
//              G.add(stck, fila, columna);
//             i= i+1;
//             }
//       //      Carta car = new Carta("default","default",new Posicion(0,0));
//       //      for(Carta c : mazo_forma){
//       //          
//       //      mazo_forma.contains(car);
//       //      
//       //      }
//             int ii=0;
//
//             while(ii<16){
//             stck = new StackPane();
//             fila = ii/4;
//             System.out.println("fila"+fila);
//             int columna = ii%4;
//             System.out.println("columna"+columna);
//             Carta car = new Carta("default","default",new Posicion(fila,columna));
//              System.out.println("TAMAÑO aque se pierde"+mazo_forma.size());
//           for(int num =0;num <mazo_forma.size(); num++){
//               System.out.println("num"+num);
//
//             if(mazo_forma.get(num).getPosicion().getFila()!=fila && mazo_forma.get(num).getPosicion().getColu()==columna){
//             Circle cir = new Circle(10);
//             stck.getChildren().add(cir);
//       //      mazo_forma.add(new Carta("default","default",new Posicion(fila,columna)));
//              G.add(stck, fila, columna);
//
//             }
//          }
//           ii= ii+1;
//             }
//       }else{
//
//             int i =0;
//             int columna = nu2;
//             while(i<4){
//             stck = new StackPane();
//             fila = i%4;
//             System.out.println("fila"+fila);
//
//             System.out.println("columna"+columna);
//             Circle cir = new Circle(10,new ImagePattern(image));
//             stck.getChildren().add(cir);
//             mazo_forma.add(new Carta("default","default",new Posicion(fila,columna)));
//                 System.out.println("TAMAÑO"+mazo_forma.size());
//              G.add(stck, fila, columna);
//             i= i+1;
//             }
//             ////////////////////////////////////////////////
//
//             int ii=0;
//
//             while(ii<16){
//
//             StackPane sp = new StackPane();
//             fila = ii/4;
//             System.out.println("fila"+fila);
//             columna = ii%4;
//             System.out.println("columna"+columna);
//             Carta car = new Carta("default","default",new Posicion(fila,columna));
//              System.out.println("TAMAÑO aque se pierde"+mazo_forma.size());
//           for(int num =0;num <mazo_forma.size(); num++){
//               System.out.println("num"+num);
//
//             if(mazo_forma.get(num).getPosicion().getFila()==fila && mazo_forma.get(num).getPosicion().getColu()!=columna){
//             System.out.println("entroree");
//             Circle cir = new Circle(10);
//             sp.getChildren().add(cir);
//       //      mazo_forma.add(new Carta("default","default",new Posicion(fila,columna)));
//              G.add(sp, fila, columna);
//
//             }
//          }
//           ii= ii+1;
//             }
//
//
//           }
//            break;
//        default:
//            System.out.print("Error");
//            break;
//    }
//}
    
    @FXML
    public void initialize(){
        atributos(juego);
            //FileInputStream fis = null;
        
            //String ruta = App.class.getResource(alineacion.getRuta()).getPath();//Recuperando la ruta de la imagen
            //fis = new FileInputStream(alineacion.getRuta());
            //Image img = new Image(fis);
            //comoGanar.setImage(img);//Añadiendo la imagen al ImageView
            //System.out.println(alineacion.getRuta());
        
        
//         JuegoController n = new  JuegoController();
//        Cambioimagenes cam = new Cambioimagenes(imagencarta, App.imagespath);
//        cam.setDaemon(true);
//        cam.start();
//        try {
//            n.cargarTablero(gridP,67,127,20);
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//             System.out.println("Hubo un error");
//
//        }
//        try {
//            n.cargarTablero(gridOponente,50,70,10);
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//            System.out.println("Hubo un error");
//        }
//    
//       
////    try {
////        n.cartaEnjuego(cartaenjuego);
////    } catch (FileNotFoundException ex) {
////        ex.printStackTrace();
////        
////    }
//
//   
//        try {
//            n.formaGanar(comoganar);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//     
//    }
    }
}



