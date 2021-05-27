/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.ImageIcon;

/**
 *
 * @author gama5
 */
public class Fotos {
    private String pie;
    private byte[] icono;

    public Fotos(String pie, byte[] icono) {
        this.pie = pie;
        this.icono = icono;
    }

    public Fotos() {
    }

    
    
    public String getPie() {
        return pie;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }

    public byte[] getIcono() {
        return icono;
    }

    public void setIcono(byte[] icono) {
        this.icono = icono;
    }
    
    
}
