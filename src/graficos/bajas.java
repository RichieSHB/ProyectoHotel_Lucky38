/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;
import clases.Huesped;
import clases.Recibo;
import com.mysql.jdbc.Statement;
import controlMySQL.MySqlConn;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Ernesto CH
 */
public class bajas extends javax.swing.JPanel {
    PreparedStatement ps; 
    ResultSet rs;
     

    /**
     * Creates new form bajas
     */
MySqlConn conn = new MySqlConn();
    public bajas(MySqlConn conn) {
        
        this.conn = conn;
        
        initComponents();
    }
       public bajas() {
        initComponents();
    }
       
public void limpiar(){
    
    jTextFieldHabitacionBaja.setText(null);
    jTextFieldNombreHuesped.setText(null);
    jTextFieldSaldobaja.setText(null);
    jCheckBoxServicioCuarto.setSelected(false);
    jCheckBoxServicioBar.setSelected(false);
    jCheckBoxServicioTintoreria.setSelected(false);
    jCheckBoxServicioSpa.setSelected(false);        
    jCheckBoxServicioNiñera.setSelected(false);
}

private void sumahuesped (int costo, int numHabi){
    System.out.println("Entro a suma de ingresos por huesped \nValor de 'costo': "+costo);
    System.out.println("Numero de habitacion: "+numHabi);
    ResultSet resultados = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Statement estado = null;
    int numH = numHabi; 
    int dinero=costo;
   try{
         /*"UPDATE habitaciones SET num_habitacion = " + " , ingreso = " + "'"+ costo + "' " +  "WHERE num_habitacion = " + "'" + numHabi + "'";   {*/
           /*  String query = "UPDATE habitaciones SET num_habitacion = " + " ' , ingreso = " + " ' " + costo + "' " +  "WHERE num_habitacion = " + "'" + numHabi + "'";*/

     String query = "UPDATE habitaciones SET ingreso = "+ "'" + costo +"'" + " WHERE num_habitacion = " + "'" + numHabi + " '";
     this.conn.Update(query);
      JOptionPane.showMessageDialog(this, "Informacion subida");//(true, "Informacion subida");
      /*this.conservar(costo, numHabi);*/
     this.sumafinal(costo, numH);
                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Error al subir archivos");
                    System.out.println(ex);
                    
                }
          
               
            }

private void upbasedatos (int aux){
    
    System.out.println("Entro a upbasedatos datos \nValor de 'costo': "+aux);
    ResultSet resultados = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Statement estado = null;
   
    
    
      String query = "UPDATE ingresostotales SET ingresos  =" + "'" + aux + "'" ;  
           try {
               this.conn.Update(query);
                estado = (Statement) this.conn.conn.createStatement();
               /*resultados = estado.executeQuery(query);*/
                
                
         /*while(resultados.next()){
             
               resultados.getBlob(1);
               
               aux = resultados.getInt(11);
               
         }*/
     }catch(SQLException ex) {
                  JOptionPane.showMessageDialog(this, "Error en la base de datos"+ ex); 
                  System.out.println("Error: "+ex);
     }
}


private void sumafinal (int costo, int numhabi){
    System.out.println("Entro a suma de ingresos final del hotel \n Valor de 'costo': "+costo);
 
    ResultSet resultados = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    Statement estado = null;
    int aux = 0;
    
    
   try{
        
        String query = "SELECT sum(ingreso) FROM habitaciones "/*+ "'" + numhabi + "'"*/;  
            estado = (Statement) this.conn.conn.createStatement();
            resultados = estado.executeQuery(query);
           
      while(resultados.next()){
 
          resultados.getBlob(1);
          aux = resultados.getInt(1);
          
          System.out.println("Suma total: "+aux );
          this.upbasedatos(aux);
      }
    }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Error al subir archivos");
                    System.out.println(ex);
                }
}
    private void Habitaciones(int numH, String nummH){
        if(consultar(numH) == true)
        {
            registro2 x = new registro2(conn, nummH);
            x.setLocationRelativeTo(null);
            x.setVisible(true);
          
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Habitacion ocupada");
            //JOptionPane.showInternalMessageDialog(this, "Habitacion ocupada");
        }
    }

    private boolean consultar(int numH)
    {
        String query = "SELECT * FROM habitaciones where num_habitacion = " + "'" + 
                numH + "'";
        this.conn.Consult(query);
        int n = 0;
        try
        {
           this.conn.rs.last();
           n = this.conn.rs.getRow();
           this.conn.rs.first();
        }
        catch(Exception ex)
        {
            System.out.println("Error # 1.....");
        }
        if(n != 0)
        {
            int aux = 0;
            //System.out.println("n" + n);
            
            for (int i = 0; i < n; i++) 
            {
                
                try
                {
                   
                    aux = this.conn.rs.getInt(8);
                    this.conn.rs.next();
                }
                catch(Exception ex)
                {
                   
                }
            }
            
            if(aux == 1)
            {
               
                return false;
            }
        }
        
        return true;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTituloBaja = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldHabitacionBaja = new javax.swing.JTextField();
        jButtonBaja = new javax.swing.JButton();
        jButtonReciboBaja = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombreHuesped = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckBoxServicioCuarto = new javax.swing.JCheckBox();
        jCheckBoxServicioBar = new javax.swing.JCheckBox();
        jCheckBoxServicioTintoreria = new javax.swing.JCheckBox();
        jCheckBoxServicioSpa = new javax.swing.JCheckBox();
        jCheckBoxServicioNiñera = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jLabeltipoHabitacion = new javax.swing.JLabel();
        jTextFieldtipoHabitacion = new javax.swing.JTextField();
        jTextFieldSaldobaja = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNumeroHuespedesbaja = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldHuespedesExtrabaja = new javax.swing.JTextField();
        jTextFieldFechallegadaBaja = new javax.swing.JTextField();
        jTextFieldFechasalidaBaja = new javax.swing.JTextField();

        jLabelTituloBaja.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabelTituloBaja.setText("Menu Bajas");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel2.setText("Numero de Habitación:");

        jTextFieldHabitacionBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHabitacionBajaActionPerformed(evt);
            }
        });
        jTextFieldHabitacionBaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldHabitacionBajaKeyReleased(evt);
            }
        });

        jButtonBaja.setText("Baja del Sistema");
        jButtonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaActionPerformed(evt);
            }
        });

        jButtonReciboBaja.setText("Imprimir Recibo");
        jButtonReciboBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReciboBajaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel1.setText("Huesped: ");

        jTextFieldNombreHuesped.setEditable(false);
        jTextFieldNombreHuesped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreHuespedActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel4.setText("Servicio al Cuarto:");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel5.setText("Servicio de Bar:");

        jLabel6.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel6.setText("Servicio Tintoreria:");

        jLabel7.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel7.setText("Servicio SPA: ");

        jLabel8.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel8.setText("Servicio de niñera:");

        jCheckBoxServicioTintoreria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxServicioTintoreriaActionPerformed(evt);
            }
        });

        jCheckBoxServicioNiñera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxServicioNiñeraActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel9.setText("Fecha de llegada: ");

        jLabel10.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel10.setText("Fecha de salida:");

        jLabel11.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel11.setText("Saldo:");

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabeltipoHabitacion.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabeltipoHabitacion.setText("Tipo de Habitacion:");

        jTextFieldtipoHabitacion.setEditable(false);

        jTextFieldSaldobaja.setEditable(false);
        jTextFieldSaldobaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSaldobajaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel3.setText("Numero de  Huespedes: ");

        jTextFieldNumeroHuespedesbaja.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel12.setText("Huespedes extra:");

        jTextFieldHuespedesExtrabaja.setEditable(false);

        jTextFieldFechallegadaBaja.setEditable(false);

        jTextFieldFechasalidaBaja.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabelTituloBaja)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButtonBaja))
                            .addComponent(jLabeltipoHabitacion))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldHabitacionBaja, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                        .addComponent(jTextFieldNombreHuesped)
                                        .addComponent(jCheckBoxServicioTintoreria)
                                        .addComponent(jCheckBoxServicioSpa)
                                        .addComponent(jTextFieldtipoHabitacion))
                                    .addComponent(jCheckBoxServicioCuarto))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel11)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldHuespedesExtrabaja))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldFechasalidaBaja))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldFechallegadaBaja)))
                                        .addGap(118, 118, 118))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonLimpiar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReciboBaja)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBuscar)
                                    .addComponent(jTextFieldSaldobaja, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumeroHuespedesbaja, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxServicioNiñera)
                                    .addComponent(jCheckBoxServicioBar))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBaja, jButtonBuscar, jButtonLimpiar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelTituloBaja)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldHabitacionBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldFechallegadaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldNombreHuesped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jTextFieldFechasalidaBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeltipoHabitacion)
                            .addComponent(jTextFieldtipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldHuespedesExtrabaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldNumeroHuespedesbaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxServicioCuarto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBoxServicioTintoreria, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxServicioSpa)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTextFieldSaldobaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jCheckBoxServicioNiñera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBaja)
                            .addComponent(jButtonReciboBaja)
                            .addComponent(jButtonLimpiar)
                            .addComponent(jButtonBuscar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxServicioBar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBaja, jButtonBuscar, jButtonLimpiar});

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReciboBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReciboBajaActionPerformed
        // TODO add your handling code here:
        ResultSet resultados = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement estado = null;
        int costo = 0, valorfinal= 0;
        int ingreso = 0 ; 
        String numH = this.jTextFieldHabitacionBaja.getText().trim();
        String hab = this.jTextFieldtipoHabitacion.getText().trim();
        if (this.jCheckBoxServicioBar.isSelected()) costo += 150; 
        if (this.jCheckBoxServicioTintoreria.isSelected()) costo +=150;
        if (this.jCheckBoxServicioSpa.isSelected()) costo +=150;
        if (this.jCheckBoxServicioNiñera.isSelected()) costo +=150;  
        if (this.jCheckBoxServicioCuarto.isSelected()) costo +=150;
          
           String query = "SELECT * FROM habitaciones where num_habitacion = " + "'" +numH+ "'" ;  
           try {

            estado = (Statement) this.conn.conn.createStatement();
            resultados = estado.executeQuery(query);

            while(resultados.next()){
                resultados.getBlob(1);

                

                valorfinal = resultados.getInt(11);
                String saldobaja = String.valueOf(valorfinal);
                costo+=valorfinal;
                String saldobajas = String.valueOf(costo);
                System.out.println("dato que estoy buscando: "+saldobajas);
                saldobajas = resultados.getString("ingreso");
                this.jTextFieldSaldobaja.setText(saldobajas);
            }
        
           }catch(SQLException ex) {
                  JOptionPane.showMessageDialog(this, "Error en la base de datos"+ ex); 
               
           }
           
           
           JOptionPane.showMessageDialog(null,"Cuenta final: "+costo+ "\nTipo de habitacion: "+hab );
           
           
           
           int numHabi = Integer.parseInt(numH);
           this.sumahuesped(costo, numHabi);
           
    }//GEN-LAST:event_jButtonReciboBajaActionPerformed

    private void jTextFieldHabitacionBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHabitacionBajaActionPerformed
        
    }//GEN-LAST:event_jTextFieldHabitacionBajaActionPerformed

    private void jButtonBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaActionPerformed
        // TODO add your handling code here:
       
        System.out.println("Entre");
        String numH = this.jTextFieldHabitacionBaja.getText().trim();
        
        if (numH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Numero de habitacion vacio");
        }
        else{
           String query = "UPDATE  habitaciones SET Ocupado = 0, ingreso = 0 WHERE num_habitacion = " + "' " + numH + " '";
      
     /*UPDATE
  habitaciones
set
  Ocupados = 0
where
  num_habitacion = 5*/
             try {
                 this.conn.Update(query);
                     JOptionPane.showMessageDialog(this, "Informacion subida");//(true, "Informacion subida");
                     limpiar();
                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Error al subir archivos");
                    System.out.println(ex);
                    limpiar();
                }

        }
    }//GEN-LAST:event_jButtonBajaActionPerformed

    private void jTextFieldHabitacionBajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldHabitacionBajaKeyReleased
        // TODO add your handling code here:
            String numH;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("Presionaste enter");
            this.jTextFieldNombreHuesped.setText("");
            numH=this.jTextFieldHabitacionBaja.getText().trim();
            
            String query="select * from habitaciones where num_habitacion = "+"'"+numH+"'";
            
            this.conn.Consult(query);
            try {
                String nombre = this.conn.rs.getString(2);
                this.jTextFieldNombreHuesped.setText(nombre);
            }catch(SQLException ex){
                System.out.println("No existe la habitacion");
            }
        }
    }//GEN-LAST:event_jTextFieldHabitacionBajaKeyReleased

    private void jTextFieldNombreHuespedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreHuespedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreHuespedActionPerformed

    private void jCheckBoxServicioNiñeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxServicioNiñeraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxServicioNiñeraActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
    limpiar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
      
        ResultSet resultados = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement estado = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String nombre, fecha_llegada, fecha_salida, tipo_habitacion, salida, ingreso, Extras, huespedes;
        huespedes = this.jTextFieldNumeroHuespedesbaja.getText().trim();
        nombre=this.jTextFieldHabitacionBaja.getText().trim();
        fecha_llegada = this.jTextFieldFechallegadaBaja.getText().trim();
        fecha_salida = this.jTextFieldFechasalidaBaja.getText().trim();
        tipo_habitacion = this.jTextFieldtipoHabitacion.getText().trim();
        ingreso= this.jTextFieldSaldobaja.getText().trim();
        Extras = this.jTextFieldHuespedesExtrabaja.getText().trim();

        String query = "SELECT * FROM habitaciones where num_habitacion =  " + "'" + nombre+ "'" + "'"+tipo_habitacion + "'" +"'" + fecha_llegada +"'"+ "'" + fecha_salida + "'"+ "'" + huespedes + "'"+ "'"+ Extras + "'" +"'"+ ingreso + "'";
        
        try {
            estado = (Statement) this.conn.conn.createStatement();
            resultados = estado.executeQuery(query);
            while(resultados.next()){

                nombre = resultados.getString("nombre");
                this.jTextFieldNombreHuesped.setText(nombre); 
                
                tipo_habitacion = resultados.getString("tipo_habitacion");
                this.jTextFieldtipoHabitacion.setText(tipo_habitacion);
                
                fecha_llegada = resultados.getString ("fecha_llegada");
                this.jTextFieldFechallegadaBaja.setText(fecha_llegada);
                
                fecha_salida = resultados.getString("fecha_salida");
                this.jTextFieldFechasalidaBaja.setText(fecha_salida);
                
                huespedes = resultados.getString ("huespedes"); 
                this.jTextFieldNumeroHuespedesbaja.setText(huespedes);
                
                Extras = resultados.getString(("extras"));
                this.jTextFieldHuespedesExtrabaja.setText(Extras);
                
                ingreso = resultados.getString("ingreso");
                this.jTextFieldSaldobaja.setText(ingreso);
                
                System.out.println("Ingreso de la habitacion antes de servicios: "+ingreso);
        
                }
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "Error en la base de datos"+ ex); 
                
            
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jCheckBoxServicioTintoreriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxServicioTintoreriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxServicioTintoreriaActionPerformed

    private void jTextFieldSaldobajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSaldobajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSaldobajaActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBaja;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonReciboBaja;
    private javax.swing.JCheckBox jCheckBoxServicioBar;
    private javax.swing.JCheckBox jCheckBoxServicioCuarto;
    private javax.swing.JCheckBox jCheckBoxServicioNiñera;
    private javax.swing.JCheckBox jCheckBoxServicioSpa;
    private javax.swing.JCheckBox jCheckBoxServicioTintoreria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTituloBaja;
    private javax.swing.JLabel jLabeltipoHabitacion;
    private javax.swing.JTextField jTextFieldFechallegadaBaja;
    private javax.swing.JTextField jTextFieldFechasalidaBaja;
    private javax.swing.JTextField jTextFieldHabitacionBaja;
    private javax.swing.JTextField jTextFieldHuespedesExtrabaja;
    private javax.swing.JTextField jTextFieldNombreHuesped;
    private javax.swing.JTextField jTextFieldNumeroHuespedesbaja;
    private javax.swing.JTextField jTextFieldSaldobaja;
    private javax.swing.JTextField jTextFieldtipoHabitacion;
    // End of variables declaration//GEN-END:variables




  

   
}
