/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;


import clases.Fotos;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import clases.Imagenfondo;
import controlMySQL.MySqlConn;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author gama5
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public ArrayList<Fotos> album = new ArrayList<Fotos>();
    private int recorridoAlbum;
    Imagenfondo prueba = new Imagenfondo(1);
    MySqlConn conn;
    
    public Ventana(MySqlConn conn) {
        this.recorridoAlbum = -1;
        this.conn = conn;
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/IconoLucky38.png")).getImage()); 
        this.setContentPane(prueba);
        this.llenarLista();
        initComponents();
    }

    public Ventana() {
        this.recorridoAlbum = -1;
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/IconoLucky38.png")).getImage()); 
        this.setContentPane(prueba);
        initComponents();
    }
    
    public void llenarLista(){
        ResultSet resultados = null;
        Statement estado = null;
        String pie;
        String sql = "SELECT * FROM imagenes";
        try {
            estado = this.conn.conn.createStatement();
            resultados = estado.executeQuery(sql);
            while(resultados.next()){
                Fotos inter = new Fotos();
                inter.setPie(resultados.getString(1));
                inter.setIcono(resultados.getBytes(2));
                this.album.add(inter);
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error en la base de datos");
            //System.out.println(ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basura = new registro();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelPrin = new Imagenfondo(1);
        jPanelIn = new javax.swing.JPanel();
        registro41 = new graficos.Registro4();
        jPanelOut = new javax.swing.JPanel();
        jPanelCon = new javax.swing.JPanel();
        consultasSubMenu1 = new graficos.ConsultasSubMenu();
        jPanelImg = new javax.swing.JPanel();
        jPanelMuestra = new javax.swing.JPanel();
        jLabelImagen = new javax.swing.JLabel();
        jLabelImagenesMuestra = new javax.swing.JLabel();
        jButtonAgregarImg = new javax.swing.JButton();
        jButtonSiguienteImg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Lucky 38");
        setResizable(false);

        jTabbedPane1.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanelPrinLayout = new javax.swing.GroupLayout(jPanelPrin);
        jPanelPrin.setLayout(jPanelPrinLayout);
        jPanelPrinLayout.setHorizontalGroup(
            jPanelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jPanelPrinLayout.setVerticalGroup(
            jPanelPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Principal", jPanelPrin);

        javax.swing.GroupLayout jPanelInLayout = new javax.swing.GroupLayout(jPanelIn);
        jPanelIn.setLayout(jPanelInLayout);
        jPanelInLayout.setHorizontalGroup(
            jPanelInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registro41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(698, Short.MAX_VALUE))
        );
        jPanelInLayout.setVerticalGroup(
            jPanelInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registro41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro", jPanelIn);
        //jPanelIn.add(new registro(conn).setVisible(true));

        javax.swing.GroupLayout jPanelOutLayout = new javax.swing.GroupLayout(jPanelOut);
        jPanelOut.setLayout(jPanelOutLayout);
        jPanelOutLayout.setHorizontalGroup(
            jPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jPanelOutLayout.setVerticalGroup(
            jPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Salida", jPanelOut);

        javax.swing.GroupLayout jPanelConLayout = new javax.swing.GroupLayout(jPanelCon);
        jPanelCon.setLayout(jPanelConLayout);
        jPanelConLayout.setHorizontalGroup(
            jPanelConLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consultasSubMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, Short.MAX_VALUE)
        );
        jPanelConLayout.setVerticalGroup(
            jPanelConLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelConLayout.createSequentialGroup()
                .addComponent(consultasSubMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultas", jPanelCon);

        jPanelMuestra.setBackground(new java.awt.Color(255, 255, 255));

        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sanguinario.png"))); // NOI18N
        jLabelImagen.setText("Placeholder");

        javax.swing.GroupLayout jPanelMuestraLayout = new javax.swing.GroupLayout(jPanelMuestra);
        jPanelMuestra.setLayout(jPanelMuestraLayout);
        jPanelMuestraLayout.setHorizontalGroup(
            jPanelMuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMuestraLayout.setVerticalGroup(
            jPanelMuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        jLabelImagenesMuestra.setText("Imagenes de Muestra");

        jButtonAgregarImg.setText("Agregar Imagen");
        jButtonAgregarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarImgActionPerformed(evt);
            }
        });

        jButtonSiguienteImg.setText("Siguiente");
        jButtonSiguienteImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelImgLayout = new javax.swing.GroupLayout(jPanelImg);
        jPanelImg.setLayout(jPanelImgLayout);
        jPanelImgLayout.setHorizontalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImgLayout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(jLabelImagenesMuestra)
                .addGap(35, 520, Short.MAX_VALUE))
            .addGroup(jPanelImgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMuestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelImgLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonAgregarImg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSiguienteImg)
                .addGap(20, 20, 20))
        );
        jPanelImgLayout.setVerticalGroup(
            jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelImgLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabelImagenesMuestra)
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(jPanelImgLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAgregarImg)
                            .addComponent(jButtonSiguienteImg))
                        .addGap(14, 14, 14))))
        );

        jTabbedPane1.addTab("Imagenes", jPanelImg);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSiguienteImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteImgActionPerformed
        if (this.recorridoAlbum + 1 < this.album.size()) {
            this.recorridoAlbum++;
            try {
                System.out.println("continuacion");
                System.out.println(this.recorridoAlbum);
                String pie = album.get(this.recorridoAlbum).getPie();
                byte[] img = album.get(this.recorridoAlbum).getIcono();
                System.out.println(pie);
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(img);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(1012, 415, 0));
                this.jLabelImagen.setIcon(imgi);
                this.jLabelImagen.setText("");
                this.jLabelImagenesMuestra.setText(pie);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }else{
            this.recorridoAlbum = 0;
            System.out.println("Reinicio");
            try {
                String pie = album.get(this.recorridoAlbum).getPie();
                byte[] img = album.get(this.recorridoAlbum).getIcono();
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(img);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(1012, 415, 0));
                this.jLabelImagen.setIcon(imgi);
                this.jLabelImagen.setText("");
                this.jLabelImagenesMuestra.setText(pie);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_jButtonSiguienteImgActionPerformed

    private void jButtonAgregarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarImgActionPerformed
        AgregarImg e = new AgregarImg(conn);
        e.setLocationRelativeTo(null);
        e.setVisible(true);
        //new AgregarImg(conn).setVisible(true);
        album.clear();
        this.llenarLista();
    }//GEN-LAST:event_jButtonAgregarImgActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Ventana().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private graficos.registro basura;
    private graficos.ConsultasSubMenu consultasSubMenu1;
    private javax.swing.JButton jButtonAgregarImg;
    private javax.swing.JButton jButtonSiguienteImg;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelImagenesMuestra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCon;
    private javax.swing.JPanel jPanelImg;
    private javax.swing.JPanel jPanelIn;
    private javax.swing.JPanel jPanelMuestra;
    private javax.swing.JPanel jPanelOut;
    private javax.swing.JPanel jPanelPrin;
    private javax.swing.JTabbedPane jTabbedPane1;
    private graficos.Registro4 registro41;
    // End of variables declaration//GEN-END:variables
}


