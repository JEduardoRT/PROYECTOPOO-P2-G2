/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.jandryespol.loteria.App;
import java.io.File;
import java.io.FileInputStream;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ken
 */
public class Cambioimagenes extends Thread {
     private ImageView imageVwc;
    private String path;
    private String numero;

    public Cambioimagenes(ImageView imageVwc, String path){
        this.imageVwc = imageVwc;
        this.path = path;

    }
    
    /**
     * Cambia la imagen en el contenedor especificado cada 2 segundos 
     */
    @Override
    public void run() {
        while (true) {
                String ruta = path ;
               
                 int N;
    Random numero = new Random();
    
     N = (numero.nextInt(54)+1);
     
    String numeroconvertido = String.valueOf(N);
            System.out.println("lista"+(ruta+numeroconvertido+".jpg"));
                File romper1 = new File(ruta+numeroconvertido+".jpg");
//
                String ruta1 = null;
 
 
 

                try {
                    ruta1 = romper1.toURI().toURL().toString();

                } catch (MalformedURLException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("========="+ruta1);
                Image rota1 = new Image(ruta1, 400, 400, true, true);
                    if(!romper1.exists()) System.out.println("no existe archivoooo");
                
                              imageVwc.setImage(rota1);  
                System.out.println("imagen cambiada a dormir");
                siesta();
                System.out.println("siesta terminada");
        }
     
    }
    
    /**
     *Pausa el hilo durante 2 segundos 
     */
    public void siesta(){
       
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("error en sleep");
        }
        
    }
    
    
}
