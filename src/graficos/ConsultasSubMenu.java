/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ernesto CH
 */
public class ConsultasSubMenu extends javax.swing.JPanel {

    /**
     * Creates new form ConsultasSubMenu
     */
    public ConsultasSubMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelGaleria = new javax.swing.JPanel();
        jPanelIngresos = new javax.swing.JPanel();
        jPanelGrafica = new javax.swing.JPanel();
        grafica1 = new consultas.Grafica();
        jPanelTipoHabitacion = new javax.swing.JPanel();
        totalHabitaciones1 = new consultas.TotalHabitaciones();
        jPanelDisponibilidad = new javax.swing.JPanel();
        consultaGrafica3 = new consultas.ConsultaGrafica();
        jPanelCostos = new javax.swing.JPanel();
        costos1 = new consultas.Costos();
        jPanelBuscarHuesped = new javax.swing.JPanel();
        buscarNombre1 = new consultas.BuscarNombre();
        jPanelBuscarHabitacion = new javax.swing.JPanel();
        buscarHabitacion1 = new consultas.BuscarHabitacion();
        jPanelPisos = new javax.swing.JPanel();
        disponibilidadPisos1 = new consultas.DisponibilidadPisos();
        jPanelListaHuesped = new javax.swing.JPanel();
        listaHuespedes1 = new consultas.ListaHuespedes();
        jPanelFechayHora = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanelGaleriaLayout = new javax.swing.GroupLayout(jPanelGaleria);
        jPanelGaleria.setLayout(jPanelGaleriaLayout);
        jPanelGaleriaLayout.setHorizontalGroup(
            jPanelGaleriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanelGaleriaLayout.setVerticalGroup(
            jPanelGaleriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Galeria", jPanelGaleria);

        javax.swing.GroupLayout jPanelIngresosLayout = new javax.swing.GroupLayout(jPanelIngresos);
        jPanelIngresos.setLayout(jPanelIngresosLayout);
        jPanelIngresosLayout.setHorizontalGroup(
            jPanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanelIngresosLayout.setVerticalGroup(
            jPanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Ingresos", jPanelIngresos);

        javax.swing.GroupLayout jPanelGraficaLayout = new javax.swing.GroupLayout(jPanelGrafica);
        jPanelGrafica.setLayout(jPanelGraficaLayout);
        jPanelGraficaLayout.setHorizontalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGraficaLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(grafica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(528, Short.MAX_VALUE))
        );
        jPanelGraficaLayout.setVerticalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGraficaLayout.createSequentialGroup()
                .addComponent(grafica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Grafica Ocupacion ", jPanelGrafica);

        javax.swing.GroupLayout jPanelTipoHabitacionLayout = new javax.swing.GroupLayout(jPanelTipoHabitacion);
        jPanelTipoHabitacion.setLayout(jPanelTipoHabitacionLayout);
        jPanelTipoHabitacionLayout.setHorizontalGroup(
            jPanelTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoHabitacionLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(totalHabitaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(576, Short.MAX_VALUE))
        );
        jPanelTipoHabitacionLayout.setVerticalGroup(
            jPanelTipoHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTipoHabitacionLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(totalHabitaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tipo de Habitacion", jPanelTipoHabitacion);

        javax.swing.GroupLayout jPanelDisponibilidadLayout = new javax.swing.GroupLayout(jPanelDisponibilidad);
        jPanelDisponibilidad.setLayout(jPanelDisponibilidadLayout);
        jPanelDisponibilidadLayout.setHorizontalGroup(
            jPanelDisponibilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisponibilidadLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(consultaGrafica3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanelDisponibilidadLayout.setVerticalGroup(
            jPanelDisponibilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisponibilidadLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(consultaGrafica3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Disponibilidad", jPanelDisponibilidad);

        javax.swing.GroupLayout jPanelCostosLayout = new javax.swing.GroupLayout(jPanelCostos);
        jPanelCostos.setLayout(jPanelCostosLayout);
        jPanelCostosLayout.setHorizontalGroup(
            jPanelCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCostosLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(costos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(498, Short.MAX_VALUE))
        );
        jPanelCostosLayout.setVerticalGroup(
            jPanelCostosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCostosLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(costos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Costos", jPanelCostos);

        javax.swing.GroupLayout jPanelBuscarHuespedLayout = new javax.swing.GroupLayout(jPanelBuscarHuesped);
        jPanelBuscarHuesped.setLayout(jPanelBuscarHuespedLayout);
        jPanelBuscarHuespedLayout.setHorizontalGroup(
            jPanelBuscarHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarHuespedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(583, Short.MAX_VALUE))
        );
        jPanelBuscarHuespedLayout.setVerticalGroup(
            jPanelBuscarHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarHuespedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar Huesped", jPanelBuscarHuesped);

        javax.swing.GroupLayout jPanelBuscarHabitacionLayout = new javax.swing.GroupLayout(jPanelBuscarHabitacion);
        jPanelBuscarHabitacion.setLayout(jPanelBuscarHabitacionLayout);
        jPanelBuscarHabitacionLayout.setHorizontalGroup(
            jPanelBuscarHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarHabitacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarHabitacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBuscarHabitacionLayout.setVerticalGroup(
            jPanelBuscarHabitacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarHabitacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscarHabitacion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar Habitación", jPanelBuscarHabitacion);

        javax.swing.GroupLayout jPanelPisosLayout = new javax.swing.GroupLayout(jPanelPisos);
        jPanelPisos.setLayout(jPanelPisosLayout);
        jPanelPisosLayout.setHorizontalGroup(
            jPanelPisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPisosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(disponibilidadPisos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPisosLayout.setVerticalGroup(
            jPanelPisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPisosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(disponibilidadPisos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pisos", jPanelPisos);

        javax.swing.GroupLayout jPanelListaHuespedLayout = new javax.swing.GroupLayout(jPanelListaHuesped);
        jPanelListaHuesped.setLayout(jPanelListaHuespedLayout);
        jPanelListaHuespedLayout.setHorizontalGroup(
            jPanelListaHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaHuespedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaHuespedes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(623, Short.MAX_VALUE))
        );
        jPanelListaHuespedLayout.setVerticalGroup(
            jPanelListaHuespedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListaHuespedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaHuespedes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lista de Huespedes", jPanelListaHuesped);

        jPanelFechayHora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelFechayHoraMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanelFechayHoraLayout = new javax.swing.GroupLayout(jPanelFechayHora);
        jPanelFechayHora.setLayout(jPanelFechayHoraLayout);
        jPanelFechayHoraLayout.setHorizontalGroup(
            jPanelFechayHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1208, Short.MAX_VALUE)
        );
        jPanelFechayHoraLayout.setVerticalGroup(
            jPanelFechayHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Fecha y Hora", jPanelFechayHora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelFechayHoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelFechayHoraMouseEntered
        int op = JOptionPane.showConfirmDialog(this.jPanelFechayHora,"Desea consultar la fecha y hora del sistema?....");
        if(op == 0){
            java.util.Date fecha = new Date();
            String dia = String.valueOf(fecha);
            JOptionPane.showMessageDialog(jPanelFechayHora,dia,"Fecha y Hora Actual del Sistema",1);
            System.out.println("Selecciono si");
        }else if(op == 1){
            System.out.println("Selecciono no");
        }else{
            System.out.println("Secelcciono cancelar");
        }
    }//GEN-LAST:event_jPanelFechayHoraMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private consultas.BuscarHabitacion buscarHabitacion1;
    private consultas.BuscarNombre buscarNombre1;
    private consultas.ConsultaGrafica consultaGrafica3;
    private consultas.Costos costos1;
    private consultas.DisponibilidadPisos disponibilidadPisos1;
    private consultas.Grafica grafica1;
    private javax.swing.JPanel jPanelBuscarHabitacion;
    private javax.swing.JPanel jPanelBuscarHuesped;
    private javax.swing.JPanel jPanelCostos;
    private javax.swing.JPanel jPanelDisponibilidad;
    private javax.swing.JPanel jPanelFechayHora;
    private javax.swing.JPanel jPanelGaleria;
    private javax.swing.JPanel jPanelGrafica;
    private javax.swing.JPanel jPanelIngresos;
    private javax.swing.JPanel jPanelListaHuesped;
    private javax.swing.JPanel jPanelPisos;
    private javax.swing.JPanel jPanelTipoHabitacion;
    private javax.swing.JTabbedPane jTabbedPane1;
    private consultas.ListaHuespedes listaHuespedes1;
    private consultas.TotalHabitaciones totalHabitaciones1;
    // End of variables declaration//GEN-END:variables
}
