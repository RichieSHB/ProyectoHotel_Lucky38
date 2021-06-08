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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ernesto CH
 */
public class BuscarNombre extends javax.swing.JPanel {
    MySqlConn conn = new MySqlConn();
    /**
     * Creates new form BuscarNombre
     */
    public BuscarNombre() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldHabitacion = new javax.swing.JTextField();
        jTextFieldPiso = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel1.setText("Buscar por nombre Huesped");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Habitacion:");

        jLabel4.setText("Piso:");

        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyPressed(evt);
            }
        });

        jTextFieldHabitacion.setEditable(false);

        jTextFieldPiso.setEditable(false);
        jTextFieldPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPisoActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldPiso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                        .addComponent(jTextFieldHabitacion, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(160, 160, 160))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(263, 263, 263))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(148, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPisoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String buscar,nombre = null,hab,piso;
            String correcto = null;
            buscar = this.jTextFieldNombre.getText();
            String query = "Select * From habitaciones";
            Statement st;
            ResultSet resultados ;
            st = this.conn.conn.createStatement();
            resultados = st.executeQuery(query);
            while(resultados.next()){
                nombre = resultados.getString("nombre");
                hab = resultados.getString("num_habitacion");
                piso = resultados.getString("num_piso");
                if(buscar.equals(nombre)){
                    this.jTextFieldHabitacion.setText(hab);
                    this.jTextFieldPiso.setText(piso);
                    correcto = nombre;
                }
            }
            if(!buscar.equals(correcto)){
                JOptionPane.showMessageDialog(this.jTextFieldNombre,"Huesped No Registrado");
                this.jTextFieldHabitacion.setText("");
                this.jTextFieldPiso.setText("");
            }
            if(buscar.equals("")){
                this.jTextFieldHabitacion.setText("");
                this.jTextFieldPiso.setText("");
                JOptionPane.showMessageDialog(this.jTextFieldNombre,"Llenar casilla vacia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
            String buscar,nombre,hab,piso;
            String correcto = null;
            buscar = this.jTextFieldNombre.getText();
            String query = "Select * From habitaciones";
            Statement st;
            ResultSet resultados ;
            st = this.conn.conn.createStatement();
            resultados = st.executeQuery(query);
            while(resultados.next()){
                nombre = resultados.getString("nombre");
                hab = resultados.getString("num_habitacion");
                piso = resultados.getString("num_piso");
                if(buscar.equals(nombre)){
                    this.jTextFieldHabitacion.setText(hab);
                    this.jTextFieldPiso.setText(piso);
                    correcto = nombre;
                }
            }
            if(!buscar.equals(correcto)){
                JOptionPane.showMessageDialog(this.jTextFieldNombre,"Huesped No Registrado");
                this.jTextFieldHabitacion.setText("");
                this.jTextFieldPiso.setText("");
            }
            if(buscar.equals("")){
                this.jTextFieldHabitacion.setText("");
                this.jTextFieldPiso.setText("");
                JOptionPane.showMessageDialog(this.jTextFieldNombre,"Llenar casilla vacia");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jTextFieldNombreKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldHabitacion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPiso;
    // End of variables declaration//GEN-END:variables
}