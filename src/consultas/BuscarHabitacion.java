/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import controlMySQL.MySqlConn;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ernesto CH
 */
public class BuscarHabitacion extends javax.swing.JPanel {
    MySqlConn conn = new MySqlConn();
    /**
     * Creates new form BuscarHabitacion
     */
    public BuscarHabitacion() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldHabitacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHuesped = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel1.setText("Buscar por Habitación");

        jLabel2.setText("Habitación:");

        jTextFieldHabitacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldHabitacionKeyPressed(evt);
            }
        });

        jLabel3.setText("Huesped:");

        jTextFieldHuesped.setEditable(false);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jButton1)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
                String buscar,hab,ocupado,nombre;
                int i;
                buscar = this.jTextFieldHabitacion.getText();
                if(buscar.equals("")){
                    try{
                        JOptionPane.showMessageDialog(this.jTextFieldHabitacion,"Llenar casilla vacia");
                    }catch(NumberFormatException ex){
                        
                    }
                }
                String query = "Select * From habitaciones";
                Statement st;
                ResultSet resultados ;
                st = this.conn.conn.createStatement();
                resultados = st.executeQuery(query);
                
                
                        i = Integer.parseInt(buscar);
                        resultados.absolute(i);
                        hab = resultados.getString("num_habitacion");
                        ocupado = resultados.getString("Ocupado");
                        nombre = resultados.getString("nombre");
                        if(buscar.equals(hab)){
                            this.jTextFieldHuesped.setText(nombre);
                        }
                        if(buscar.equals(hab) && ocupado.equals("0")){
                            JOptionPane.showMessageDialog(this.jTextFieldHabitacion, "Habitacion Disponible");
                        }
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this.jTextFieldHabitacion,"Habitacion Inexistente");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldHabitacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHabitacionKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
                String buscar,hab,ocupado,nombre;
                int i;
                buscar = this.jTextFieldHabitacion.getText();
                String query = "Select * From habitaciones";
                Statement st;
                ResultSet resultados ;
                st = this.conn.conn.createStatement();
                resultados = st.executeQuery(query);
                if(buscar.equals("")){
                           JOptionPane.showMessageDialog(this.jTextFieldHabitacion, "Llenar Casilla Vacia");
                }
                        i = Integer.parseInt(buscar);
                        resultados.absolute(i);
                        hab = resultados.getString("num_habitacion");
                        ocupado = resultados.getString("Ocupado");
                        nombre = resultados.getString("nombre");
                        
                        if(buscar.equals(hab)){
                            this.jTextFieldHuesped.setText(nombre);
                        }
                        if(buscar.equals(hab) && ocupado.equals("0")){
                            JOptionPane.showMessageDialog(this.jTextFieldHabitacion, "Habitacion Disponible");
                        }
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this.jTextFieldHabitacion,"Habitacion Inexistente");
            }
       
        }
    }//GEN-LAST:event_jTextFieldHabitacionKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldHabitacion;
    private javax.swing.JTextField jTextFieldHuesped;
    // End of variables declaration//GEN-END:variables
}
