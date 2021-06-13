/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author gama5
 */
public class Huesped {
    private String nombre,ciudad,tipohab,numHab;
    private int piso,limite,totalOcupantes = 0,personasExtra;
    private Date Entrada,Salida;

    public Huesped(String nombre, String ciudad, String tipohab, String numHab, int limite, int personasExtra, Date Entrada, Date Salida) {
        int numH = Integer.parseInt(numHab);
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipohab = tipohab;
        this.numHab = numHab;
        this.limite = limite;
        this.personasExtra = personasExtra;
        this.Entrada = Entrada;
        this.Salida = Salida;
        if (numH < 16) {
            this.piso = 1;
        }else{
            this.piso = 2;
        }
        this.totalOcupantes += limite;
        if (personasExtra > 0) {
            this.totalOcupantes += personasExtra;
        }
    }

    public Date getEntrada() {
        return Entrada;
    }

    public void setEntrada(Date Entrada) {
        this.Entrada = Entrada;
    }

    public Date getSalida() {
        return Salida;
    }

    public void setSalida(Date Salida) {
        this.Salida = Salida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipohab() {
        return tipohab;
    }

    public void setTipohab(String tipohab) {
        this.tipohab = tipohab;
    }

    public String getNumHab() {
        return numHab;
    }

    public void setNumHab(String numHab) {
        this.numHab = numHab;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getTotalOcupantes() {
        return totalOcupantes;
    }

    public void setTotalOcupantes(int totalOcupantes) {
        this.totalOcupantes = totalOcupantes;
    }

    public int getPersonasExtra() {
        return personasExtra;
    }

    public void setPersonasExtra(int personasExtra) {
        this.personasExtra = personasExtra;
    }
    
    
}
