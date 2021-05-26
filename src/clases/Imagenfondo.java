/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author gama5
 */
public class Imagenfondo extends JPanel{
    private Image imagen;
    private String eleccion;

    public Imagenfondo(int e) {
        switch(e){
            case 1: eleccion = "/imagenes/Lucky38Fondo.jpg";
                    break;
            case 2: eleccion = "/imagenes/Lucky38Login.png";
                    break;
            case 3: eleccion = "/imagenes/Lucky38Presentacion.jpg";
                    break;
            case 4: eleccion = "/imagenes/Lucky38FileChooser.jpg";
                    break;
            
            default: eleccion = "/imagenes/Lucky38Presentacion.jpg";
                    
        }
    }

    public Imagenfondo() {
    }
    
    
    
    public void paint(Graphics g){
        imagen = new ImageIcon(getClass().getResource(eleccion)).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
        this.setOpaque(false);
        super.paint(g);
    }
}


