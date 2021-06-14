/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

/**
 *
 * @author rajop
 */

import clases.Huesped;
import clases.Recibo;
import controlMySQL.MySqlConn;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class registro2 extends javax.swing.JFrame {

    /**
     * Creates new form registro2
     */
    MySqlConn conn;
    String numH;
    public registro2(MySqlConn conn, String numH)
    {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/IconoLucky38.png")).getImage()); 
        this.conn = conn;
        this.numH = numH;
        initComponents();
    }
    
    public registro2() {
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

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelCiudad = new javax.swing.JLabel();
        jLabelFechaLlegada = new javax.swing.JLabel();
        jLabelFechaSalida = new javax.swing.JLabel();
        jLabelHabitacionTipo = new javax.swing.JLabel();
        jLabelNumeroPiso = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldCiudad = new javax.swing.JTextField();
        jDateChooserFechaLlegada = new com.toedter.calendar.JDateChooser();
        jButtonRegistrar = new javax.swing.JButton();
        jLabelHabitacionNumero = new javax.swing.JLabel();
        jTextFieldHabitacionNumero = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jSpinnerDias = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jSpinnerTotal = new javax.swing.JSpinner();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNombre.setText("NOMBRE DEL HUESPED");

        jLabelTitulo.setFont(new java.awt.Font("MS UI Gothic", 1, 26)); // NOI18N
        jLabelTitulo.setText("R E G I S T R O ");

        jLabelCiudad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelCiudad.setText("CIUDAD DE ORIGEN");

        jLabelFechaLlegada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelFechaLlegada.setText("FECHA DE LLEGADA");

        jLabelFechaSalida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelFechaSalida.setText("FECHA DE SALIDA");

        jLabelHabitacionTipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelHabitacionTipo.setText("TIPO DE HABITACION");

        jLabelNumeroPiso.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNumeroPiso.setText("NUMERO DE PISO");

        jTextFieldNombre.setFont(new java.awt.Font("MS UI Gothic", 0, 12)); // NOI18N
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldCiudad.setFont(new java.awt.Font("MS UI Gothic", 0, 12)); // NOI18N
        jTextFieldCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCiudadActionPerformed(evt);
            }
        });

        jButtonRegistrar.setFont(new java.awt.Font("MS UI Gothic", 1, 12)); // NOI18N
        jButtonRegistrar.setText("REGISTRAR");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jLabelHabitacionNumero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelHabitacionNumero.setText("NUMERO DE HABITACION");

        jTextFieldHabitacionNumero.setEditable(false);
        jTextFieldHabitacionNumero.setFont(new java.awt.Font("MS UI Gothic", 0, 11)); // NOI18N
        jTextFieldHabitacionNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHabitacionNumeroActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        buttonGroup1.add(jCheckBox1);
        jCheckBox1.setText("1 persona extra");

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setText("2 personas extras");

        jSpinnerDias.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("NUMERO DE HUESPEDES");

        jSpinnerTotal.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNumeroPiso)
                            .addComponent(jLabelHabitacionNumero))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldHabitacionNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelHabitacionTipo)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelFechaSalida)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelCiudad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelFechaLlegada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jSpinnerDias, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jSpinnerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jCheckBox2))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonRegistrar)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooserFechaLlegada, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombre)
                                    .addComponent(jTextFieldCiudad))))))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCiudad)
                    .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaLlegada)
                    .addComponent(jDateChooserFechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaSalida)
                    .addComponent(jSpinnerDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHabitacionTipo)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHabitacionNumero)
                            .addComponent(jTextFieldHabitacionNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumeroPiso)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jCheckBox2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jTextFieldHabitacionNumero.setText(numH);
        jTextField1.setText(calcularpiso());
        jTextField2.setText(consultar(numH));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jTextFieldCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCiudadActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        //                String nomhuesped,nomciudad,/*fechallegada, fechasalida, */ tipohab ,numerohab,limhuesped;
        //                int numpiso, numhuesped;
        //                  SimpleDateFormat dFormat = new SimpleDateFormat ("dd-MM-yyyy");
        //                  String date = dFormat.format(jDateChooserFechaLlegada.getDate());
        //                 /* SimpleDateFormat dFormat = new SimpleDateFormat ("dd-MM-yyyy");
        //                  String date = dFormat.format(jDateChooserFechaSalida.getDate());*/
        //                nomhuesped = this.jTextFieldNombre.getText().trim();
        //                nomciudad = this.jTextFieldCiudad.getText();
        //                tipohab = (String) this.jComboBoxHabitacionTipo.getSelectedItem();
        //                numerohab = this.jTextFieldHabitacionNumero.getText();
        //                limhuesped = this.jTextFieldLimiteHuesped.getText();
        //                numpiso = (int) this.jSpinnerNumeroPiso.getValue();
        //                numhuesped = (int) this.jSpinnerNumeroPiso.getValue();
        
        int numHabitacion, numPersonas, numPiso;
        String salida;
        Huesped ingreso;
        Recibo ticket;
        if(this.jTextFieldNombre.getText().isEmpty() || this.jTextFieldCiudad.getText().isEmpty() || this.jTextFieldHabitacionNumero.getText().isEmpty()
                || this.jDateChooserFechaLlegada.getDate() == null )
        {
            JOptionPane.showMessageDialog(this, "Porfavor rellene los campos vacios");
        }
        else
        {
            int costo = 0 ;
            int extras = 0;
            String nombre, ciudad, tipoHabitacion;
            int numHabi = Integer.parseInt(numH);
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            //SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
            //instanseo de variables
            nombre = this.jTextFieldNombre.getText().trim();
            ciudad = this.jTextFieldCiudad.getText().trim();
            if(this.jCheckBox2.isSelected()) extras = 2;
            if(this.jCheckBox1.isSelected()) extras = 1;
            if(this.jCheckBox2.isSelected()) costo += 200;
            if(this.jCheckBox1.isSelected()) costo += 100;
            
            String hab = this.jTextField2.getText().trim();
      
            
            
           // tipoHabitacion = (String) this.jComboBoxHabitacionTipo.getSelectedItem();//getSelectedIndex();
//            numHabitacion = Integer.parseInt(this.jTextFieldHabitacionNumero.getText());
            //            numPiso = (int) this.jSpinnerNumeroPiso.getValue();
            
            Date Fecha = this.jDateChooserFechaLlegada.getDate();
            int dias = (int) this.jSpinnerDias.getValue();
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(Fecha);
            calendar.add(Calendar.DAY_OF_YEAR, dias);
            Fecha = calendar.getTime();
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
            salida = dFormat.format(Fecha);
            
            int huespedes = (int) this.jSpinnerTotal.getValue();
              if (hab.equals("Sencilla")){
              costo += 250;
              costo*= dias;
              System.out.println("Entro habitacion sencilla");
              System.out.println("Precio base por noche: $250\nMonto total de habitacion: $"+ costo);
            }else if (hab.equals("Doble")){
                  costo +=500;
                  costo*= dias;
                  System.out.println("Entro habitacion doble");
                  System.out.println("Precio base por noche: $500\nMonto total de habitacion: $"+ costo);
            }else if(hab.equals("Triple")){
                      costo+=750;
                      costo*= dias;
                      System.out.println("Entro habitacion triple");
                      System.out.println("Precio base por noche: $750\nMonto total de habitacion: $"+ costo);
                  }
            
            ingreso = new Huesped(nombre,ciudad,this.jTextField2.getText(),this.numH,huespedes,extras,this.jDateChooserFechaLlegada.getDate(),Fecha);
            ticket = new Recibo(ingreso);
            ticket.llenarTicket();
            try
            {
                //UPDATE `habitaciones` SET `num_habitacion`='[value-1]',`nombre`='[value-2]',`ciudad`='[value-3]',`fecha_llegada`='[value-4]',`fecha_salida`='[value-5]',`tipo_habitacion`='[value-6]',`num_piso`='[value-7]',`Ocupado`='[value-8]' WHERE 1
                String query = "UPDATE habitaciones SET num_habitacion =" + "'" + numHabi + "', nombre = " + "'" + nombre + "', ciudad =" + "'" + ciudad
                        + "'" + ", fecha_llegada = " + "'" + formato.format(this.jDateChooserFechaLlegada.getDate()) + "'" + ", fecha_salida = " + "'" + formato.format(Fecha) + "'"
                       + ", tipo_habitacion = " + "'" + this.jTextField2.getText().trim() + "'" + ", num_piso = " + "'" + this.jTextField1.getText().trim() + "'" + ", Ocupado = 1" + ", Extras = " + "'" + extras + "'" + ", huespedes = '"+ huespedes + "'" +",ingreso = " +"'"+ costo +"'" + " WHERE num_habitacion = " + "'" + numHabi + "'";
                this.conn.Update(query);
                
                               /*Roy*/ /*String query = "UPDATE habitaciones SET num_habitacion =" + "'" + numHabi + "', nombre = " + "'" + nombre + "', ciudad =" + "'" + ciudad
                        + "'" + ", fecha_llegada = " + "'" + formato.format(this.jDateChooserFechaLlegada.getDate()) + "'" + ", fecha_salida = " + "'" + formato.format(this.jDateChooserFechaSalida.getDate()) + "'"
                       + ", tipo_habitacion = " + "'" + this.jTextField2.getText().trim() + "'" + ", num_piso = " + "'" + this.jTextField1.getText().trim() + "'" + ", Ocupado = 1" + ", Extras = " + "'" + extras + "'" +",ingreso = " +"'"+ costo +"'" + " WHERE num_habitacion = " + "'" + numHabi + "'";
                this.conn.Update(query);*/
                
                //                String query = "INSERT INTO registro(num_habitacion, nombre, ciudad, fecha_llegada, fecha_salida, tipo_habitacion, num_personas, num_piso) VALUES ("
                //                        + "'" + numHabitacion + "','" + nombre + "','" + ciudad + "','" + formato.format(this.jDateChooserFechaLlegada.getDate())
                //                        + "','" + formato.format(this.jDateChooserFechaSalida.getDate()) + "','" + tipoHabitacion + "','" + numPersonas + "','" + numPiso + "')";
                //INSERT INTO `registro`(`num_habitacion`, `nombre`, `ciudad`, `fecha_llegada`, `fecha_salida`, `tipo_habitacion`, `num_personas`, `num_piso`) VALUES (
                    //                String query = "insert into registro (num_habitacion, nombre, ciudad, fecha_llegada, fecha_salida, tipo_habitacion, num_personas, num_piso) VALUES ("
                    //                        + "'" + numHabitacion + "','" + nombre + "','" + ciudad + "','" + formato.format(this.jDateChooserFechaLlegada.getDate())
                    //                        + "','" + formato.format(this.jDateChooserFechaSalida.getDate()) + "','" + tipoHabitacion + "','" + numPersonas + "','" + numPiso + "')";
                    //PreparedStatement pst = conn.conn.prepareStatement(query);
                    // int j = this.conn.Update(query);
                    JOptionPane.showMessageDialog(this, "Informacion subida");//(true, "Informacion subida");
                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(this, "Error al subir archivos");
                    System.out.println(ex);
                }
                JOptionPane.showMessageDialog(this, ticket.getContentTicket());
                this.dispose();
            }

            //numPersonas = this.jSpinnerNumeroPersona

            //        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
            //        //String fecha = dFormat.format(this.jDateChooser1.getDate());
            //
            //        String query = "Insert into pruebafechasjrgp (id, nombre, fecha, totaldias) VALUES ("
            //                + "'" + id + "','" + nombre + "','" + dFormat.format(this.jDateChooser1.getDate()) + "','" + t_dias + "')";

            /*   jTextFieldCiudad;
            jTextFieldHabitacionNumero;
            jTextFieldLimiteHuesped;
            jTextFieldNombre;*/
            //        String query = "Insert into pacientes (nomhuesped, nomciudad, numerohab, limhuesped) VALUES ("
            //                + "'" + nomhuesped + "','" + nomciudad + "','" + numerohab + /*"','" +tipohab "','" +*/ limhuesped + "')";
            //                int j = this.conn.Update(query);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jTextFieldHabitacionNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHabitacionNumeroActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldHabitacionNumeroActionPerformed

    private String calcularpiso()
    {
        int aux;
        aux = Integer.parseInt(numH);
        if(aux <= 15)
        {
            return "1";
        }else
        {
            return "2";
        }
    }
    
    private String consultar(String numH)
    {
        int aux = Integer.parseInt(numH);
        String query = "SELECT * FROM habitaciones where num_habitacion = " + "'" +
                aux + "'";
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
            System.out.println("Error #1.....");
        }
        if(n != 0)
        {
            String aux2 = "";
            System.out.println("n" + n);
            for (int i = 0; i < n; i++) {
                try
                {
                    aux2 = this.conn.rs.getString(6);
                    this.conn.rs.next();
                }
                catch(Exception ex)
                {
                    System.out.println("Errorr #2.....");
                }             
            }
            return aux2;
        }
        return "";
    }
    
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
//            java.util.logging.Logger.getLogger(registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new registro2().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private com.toedter.calendar.JDateChooser jDateChooserFechaLlegada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelFechaLlegada;
    private javax.swing.JLabel jLabelFechaSalida;
    private javax.swing.JLabel jLabelHabitacionNumero;
    private javax.swing.JLabel jLabelHabitacionTipo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumeroPiso;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinnerDias;
    private javax.swing.JSpinner jSpinnerTotal;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldHabitacionNumero;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
