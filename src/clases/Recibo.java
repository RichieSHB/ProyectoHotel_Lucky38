/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.text.SimpleDateFormat;

/**
 *
 * @author gama5
 */
public class Recibo {
    private Huesped ticket;
    private String contentTicket = "    Hotel Lucky 38 New Vegas\n"
            + "             Strip, New Vegas, Nevada        \n"
            + "    Take Her For a Spin!!!!!!                \n"
            + "    =========================================\n"
            + "    Nombre: {{Nombre}}                       \n"
            + "    Ciudad: {{Ciudad}}                       \n"
            + "    Fecha Entrada: {{Entrada}}               \n"
            + "    Fecha Salida:  {{Salida}}                \n"
            + "    Tipo de Habitacion: {{TipoHab}}          \n"
            + "                Limite: {{Limite}} Huesped   \n"
            + "    Total de Ocupantes: {{Total}}            \n"
            + "    Personas Extra: {{Extra}}                \n"            
            + "    =========================================\n"
            + "    GRACIAS POR SU PREFERENCIA...\n"
            + "                ******::::::::*******"
            + "\n           ";

    public Recibo(Huesped huesped) {
        this.ticket = huesped;
    }
    
    public void llenarTicket(){
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.contentTicket = this.contentTicket.replace("{{Nombre}}", this.ticket.getNombre());
        this.contentTicket = this.contentTicket.replace("{{Ciudad}}", this.ticket.getCiudad());
        this.contentTicket = this.contentTicket.replace("{{Entrada}}", dFormat.format(this.ticket.getEntrada()));
        this.contentTicket = this.contentTicket.replace("{{Salida}}", dFormat.format(this.ticket.getSalida()));
        this.contentTicket = this.contentTicket.replace("{{TipoHab}}", this.ticket.getTipohab());
        this.contentTicket = this.contentTicket.replace("{{Limite}}", String.valueOf(this.ticket.getLimite()));
        this.contentTicket = this.contentTicket.replace("{{Total}}", String.valueOf(this.ticket.getTotalOcupantes()));
        this.contentTicket = this.contentTicket.replace("{{Extra}}", String.valueOf(this.ticket.getPersonasExtra()));        
    }

    public String getContentTicket() {
        return contentTicket;
    }
    
    
}
