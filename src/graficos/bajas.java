/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;
import clases.Huesped;
import clases.Recibo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Statement;
import controlMySQL.MySqlConn;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    jTextFieldtipoHabitacion.setText(null);
    jTextFieldNumeroHuespedesbaja.setText(null);
    jTextFieldHuespedesExtrabaja.setText(null);
    jTextFieldFechasalidaBaja.setText(null);
    jTextFieldFechallegadaBaja.setText(null);
    jCheckBoxServicioCuarto.setSelected(false);
    jCheckBoxServicioBar.setSelected(false);
    jCheckBoxServicioTintoreria.setSelected(false);
    jCheckBoxServicioSpa.setSelected(false);        
    jCheckBoxServicioNiñera.setSelected(false);
}

private void generarpdf() throws FileNotFoundException, DocumentException, IOException, SQLException{

        /* 
        Nombre logo
        lema
        ubicacion
        nombre del huesped 
        ciudad de origen
        fecha de ingreso
        fecha de salida
        numero de habitacion con piso 
        tipo de habitacion con limite de huesped 
        total de ocupantes de la habitaicon
        1 persona extra 2 persona extra
        registrado completado
        
        */
        

           
        ResultSet resultados = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement estado = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        int costo = 0, valorfinal= 0;
        int ingreso2 = 0 ; 
        String nombre,ciudad, fecha_llegada, fecha_salida, tipo_habitacion, num_habitacion, num_piso, ingreso, Extras, huespedes,name ;
        huespedes = this.jTextFieldNumeroHuespedesbaja.getText().trim();
        nombre=this.jTextFieldHabitacionBaja.getText().trim();
        fecha_llegada = this.jTextFieldFechallegadaBaja.getText().trim();
        fecha_salida = this.jTextFieldFechasalidaBaja.getText().trim();
        tipo_habitacion = this.jTextFieldtipoHabitacion.getText().trim();
        num_habitacion = this.jTextFieldNumerohabitacion.getText().trim();
        num_piso = this.jTextFieldNumPiso.getText().trim(); 
        ciudad = this.jTextFieldCiudadOrigen.getText().trim();
        ingreso= this.jTextFieldSaldobaja.getText().trim();
        Extras = this.jTextFieldHuespedesExtrabaja.getText().trim();
        
        name= this.jTextFieldGerentebaja.getText().trim();
        if (this.jCheckBoxServicioBar.isSelected()) costo += 150; 
        if (this.jCheckBoxServicioTintoreria.isSelected()) costo +=150;
        if (this.jCheckBoxServicioSpa.isSelected()) costo +=150;
        if (this.jCheckBoxServicioNiñera.isSelected()) costo +=150;  
        if (this.jCheckBoxServicioCuarto.isSelected()) costo +=150;
           
            String query2 = "SELECT * FROM habitaciones  where num_habitacion =  " + "'" + nombre+ "'" +"'"+ ciudad +"'" + "'" + num_habitacion +"'" + "'" + num_piso + "'"+ "'" + tipo_habitacion + "'" +"'" + fecha_llegada +"'"+ "'" + fecha_salida + "'"+ "'" + huespedes + "'"+ "'"+ Extras + "'" +"'"+ ingreso + "'";
        
        try {
            estado = (Statement) this.conn.conn.createStatement();
            resultados = estado.executeQuery(query2);
            while(resultados.next()){

                nombre = resultados.getString("nombre");
                this.jTextFieldNombreHuesped.setText(nombre);
                System.out.println("Entraste al generador del pdf\nEl nombre es: "+ nombre);
                
                tipo_habitacion = resultados.getString("tipo_habitacion");
                this.jTextFieldtipoHabitacion.setText(tipo_habitacion);
                
                num_habitacion = resultados.getString("num_habitacion");
                this.jTextFieldNumerohabitacion.setText(num_habitacion);
                
                
                num_piso = resultados.getString("num_piso");
                this.jTextFieldNumPiso.setText(num_piso);
                
                ciudad = resultados.getString("ciudad");
                this.jTextFieldCiudadOrigen.setText(ciudad);
                
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
                
                Document documentosalida = new Document(); 
        
                FileOutputStream PDF = new FileOutputStream("ticketsalida.pdf");
                PdfWriter.getInstance(documentosalida, PDF) ;
                 documentosalida.open();
                /*542*892 */
                Paragraph nombrehoteldoc = new Paragraph("Lucky 38",FontFactory.getFont("TimesNewRoman", 14,Font.BOLD, BaseColor.BLACK));
                nombrehoteldoc.setAlignment(Element.ALIGN_CENTER);
                 documentosalida.add(nombrehoteldoc);
                 
                Image logodoc = Image.getInstance("src\\imagenes\\IconoLucky38.png");
                logodoc.scaleAbsolute(50f, 50f);
                logodoc.setAbsolutePosition(270,800);
                documentosalida.add(logodoc);
                
                Paragraph lemadoc = new Paragraph("TAKE HER FOR A SPIN! ",FontFactory.getFont("TimesNewRoman", 14,Font.BOLD, BaseColor.BLACK));
                lemadoc.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(lemadoc);

                Paragraph ubidoc = new Paragraph("Las Vegas Strip",FontFactory.getFont("TimesNewRoman", 14,Font.BOLD, BaseColor.BLACK));
                ubidoc.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(ubidoc);
                
                Paragraph nombredoc = new Paragraph("Nombre del Huesped: "+ nombre,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                nombredoc.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(nombredoc);
        
                 Paragraph ciudaddoc = new Paragraph("Ciudad de origen: "+ciudad, FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                 ciudaddoc.setAlignment(Element.ALIGN_CENTER);

                documentosalida.add(ciudaddoc);
                
                Paragraph fechaingresodoc = new Paragraph("Fecha ingreso: "+fecha_llegada, FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                fechaingresodoc.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(fechaingresodoc);
                
                Paragraph fechasalidadoc = new Paragraph("Fecha salida: "+fecha_salida, FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                fechasalidadoc.setAlignment(Element.ALIGN_CENTER);

                documentosalida.add(fechasalidadoc);
                 if (fecha_llegada.contains("-")){         
                     
      
                   
                   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 
                    try{
                        
                    Date d1 = df.parse(fecha_salida);
                    Date d2 = df.parse(fecha_llegada);
                    long diff = d1.getTime() - d2.getTime();
                    long days = diff / (1000 * 60 * 60 * 24);
                        System.out.println("Diferencia de dias: "+ days);
                        
                Paragraph difdiasdoc = new Paragraph("Dias de estancia: "+days, FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                difdiasdoc.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(difdiasdoc);
                    }
                       catch (Exception e){
                }

    } 
                
                
                Paragraph numhabidoc = new Paragraph ("Numero de habitacion: "+num_habitacion,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK) );
                numhabidoc.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(numhabidoc);
                
                Paragraph numpiso = new Paragraph ("Numero de piso: "+num_piso,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK) );
                numpiso.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(numpiso);
                
                Paragraph tipohabi = new Paragraph("Tipo habitacion: "+tipo_habitacion,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                tipohabi.setAlignment(Element.ALIGN_CENTER);
                documentosalida.add(tipohabi);
                
                    if (tipo_habitacion.equals("Sencilla")){
                        
                        int numlimite = 1;
                        int costohab = 250;
                        
                        Paragraph limitehabdoc = new Paragraph("Limite de huespedes: "+numlimite,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                        limitehabdoc.setAlignment(Element.ALIGN_CENTER);
                        documentosalida.add(limitehabdoc);
                        Paragraph habicosto = new Paragraph("Costo de habitacion: "+costohab,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                        habicosto.setAlignment(Element.ALIGN_CENTER);
                        documentosalida.add(habicosto);
                        
            }else if (tipo_habitacion.equals("Doble")){
                
                        int numlimite = 2;
                        int costohab = 500;
                        Paragraph limitehabdoc = new Paragraph("Limite de huespedes: "+numlimite,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                        limitehabdoc.setAlignment(Element.ALIGN_CENTER);
                        documentosalida.add(limitehabdoc);
                        Paragraph habicosto = new Paragraph("Costo de habitacion: "+costohab,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                        habicosto.setAlignment(Element.ALIGN_CENTER);
                        documentosalida.add(habicosto);
                        
            }else if(tipo_habitacion.equals("Triple")){
                        int numlimite = 3;
                        int costohab = 750;

                        Paragraph limitehabdoc = new Paragraph("Limite de huespedes: "+numlimite,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                        limitehabdoc.setAlignment(Element.ALIGN_CENTER);
                        documentosalida.add(limitehabdoc);
                        Paragraph habicosto = new Paragraph("Costo de habitacion: "+costohab,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                        habicosto.setAlignment(Element.ALIGN_CENTER);
                        documentosalida.add(habicosto);
   
            }
                /* AQUI BA JUNTO CON EL TIPO DE HABITACION  CON EL LIMITE DE HUESPED*/
                /*TOTAL DE DIAS EN EL HOTEL EMPIEZA*/
                
                   Paragraph saldowoextra = new Paragraph ("Saldo sin cargos de servicios: "+ ingreso,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                   saldowoextra.setAlignment(Element.ALIGN_CENTER);
                   documentosalida.add(saldowoextra);
                 if (ingreso.contains("0")){
                   
                      
               
                    resultados.getBlob(1);
                    
                    valorfinal = resultados.getInt(11);
                    String saldobaja = String.valueOf(valorfinal);
                    costo+=valorfinal;
                    String saldobajas = String.valueOf(costo);
                    
                    
                    Paragraph saldoextra = new Paragraph ("Saldo con cargos de servicios: "+ costo,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                    saldoextra.setAlignment(Element.ALIGN_CENTER);

                    documentosalida.add(saldoextra);
                    
                }
                 
                 if (this.jCheckBoxServicioBar.isSelected()){
                     
                     Paragraph serviciobarpdf = new Paragraph ("Servicio de Bar seleccionado $150 reflejados en la cuenta final",FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                      serviciobarpdf.setAlignment(Element.ALIGN_CENTER);

                     documentosalida.add(serviciobarpdf);
                     
                     
                 }        
                 
                 
                  if (this.jCheckBoxServicioTintoreria.isSelected()){
                    
                     Paragraph serviciotintoreriapdf = new Paragraph ("Servicio de Tintoreria seleccionado $150 reflejados en la cuenta final",FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                      serviciotintoreriapdf.setAlignment(Element.ALIGN_CENTER);

                     documentosalida.add(serviciotintoreriapdf);
                     
                     
                 }        
                  if (this.jCheckBoxServicioSpa.isSelected()){
                     
                     Paragraph serviciospapdf = new Paragraph ("Servicio de Spa seleccionado $150 reflejados en la cuenta final",FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                     serviciospapdf.setAlignment(Element.ALIGN_CENTER);

                     documentosalida.add(serviciospapdf);
                     
                     
                 }     
                  if (this.jCheckBoxServicioNiñera.isSelected()){
                     
                     Paragraph servicioniñerapdf = new Paragraph ("Servicio de Niñera seleccionado $150 reflejados en la cuenta final",FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                     servicioniñerapdf.setAlignment(Element.ALIGN_CENTER);

                     documentosalida.add(servicioniñerapdf);
                 }   
                  if (this.jCheckBoxServicioCuarto.isSelected()){
                     
                     Paragraph serviciocuartopdf = new Paragraph ("Servicio al Cuarto seleccionado $150 reflejados en la cuenta final",FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                     serviciocuartopdf.setAlignment(Element.ALIGN_CENTER);

                     documentosalida.add(serviciocuartopdf);
                 }  
                  
                          Paragraph huespedeshabi = new Paragraph("Total de huespedes: "+huespedes,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                                   huespedeshabi.setAlignment(Element.ALIGN_CENTER);

                documentosalida.add(huespedeshabi);
                
                Paragraph huespedesextra = new Paragraph("Total de huespedes extra: "+Extras,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK));
                huespedesextra.setAlignment(Element.ALIGN_CENTER);

                documentosalida.add(huespedesextra);
                  
                  Paragraph gerente = new Paragraph ("Gerente en turno: "+name,FontFactory.getFont("TimesNewRoman", 12,Font.BOLD, BaseColor.BLACK) );
                   gerente.setAlignment(Element.ALIGN_CENTER);
   
                  documentosalida.add(gerente);
                /*if (this.jCheckBoxServicioBar.isSelected()) bar = "Servicio de Bar seleccionado";
                
                
                 if (this.jCheckBoxServicioBar.isSelected()) bar = "Servicio de Bar seleccionado";
                 
                 
                 
                 
                if (this.jCheckBoxServicioTintoreria.isSelected()) tintoreria = "Servicio de Tintoreria seleccionado";
                if (this.jCheckBoxServicioSpa.isSelected()) spa = "Servicio de Spa seleccionado";
                if (this.jCheckBoxServicioNiñera.isSelected()) niñera = "Servicio de niñera seleccionado";  
                if (this.jCheckBoxServicioCuarto.isSelected()) cuarto = "Servicio de cuarto seleccionado";
                
                Paragraph saldoextra = new Paragraph (""+ bar);
                documentosalida.add(saldoextra);*/

                /* TOTAL DE DIAS EN EL HOTEL TERMINA*/ 
             
                String username = null;
            
                
                Image firmalagio = Image.getInstance("src\\imagenes\\firmagio.png"); 
                   firmalagio.scaleAbsolute(50f, 50f);
                firmalagio.setAbsolutePosition(270,0);
                documentosalida.add(logodoc);
                
                
             
                 documentosalida.close();
                

       /*
        Nombre logo LISTO
        lema LISTO
        ubicacion LISTO
        fecha del dia PENDIENTE
        nombre del huesped LISTO
        ciudad de origen LISTO SQL 
        fecha de ingreso LISTO
        fecha de salida LISTO
        tipo de habitacion LISTO con limite de huesped LISTO SQL
        numero de habitacion con piso  LISTO SQL
        Costo de habitacion LISTO
        Total de dias en el hospital LISTO
        Total a pagar sin cargos extra PENDIENTE
        Total a pagar con cargos extra PENDIENTE
        Lista de cargos extra PENDIENTE
        total de ocupantes de la habitaicon LISTO
        1 persona extra 2 persona extra LISTO
        registrado completado
        
        */
            
        
            }  
                
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(this, "Error en la base de datos"+ ex);
            
            }
       
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
    
    System.out.println("Entro a upbasedatos datos \nIngresos totales acumulados: "+aux);
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldNumerohabitacion = new javax.swing.JTextField();
        jTextFieldNumPiso = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCiudadOrigen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldGerentebaja = new javax.swing.JTextField();

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
        jLabel3.setText("Numero de Huespedes: ");

        jTextFieldNumeroHuespedesbaja.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel12.setText("Huespedes extra:");

        jTextFieldHuespedesExtrabaja.setEditable(false);

        jTextFieldFechallegadaBaja.setEditable(false);

        jTextFieldFechasalidaBaja.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel13.setText("Numero de Habitacion: ");

        jLabel14.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel14.setText("Numero Piso:");

        jTextFieldNumerohabitacion.setEditable(false);

        jTextFieldNumPiso.setEditable(false);
        jTextFieldNumPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumPisoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel15.setText("Ciudad de Origen:");

        jTextFieldCiudadOrigen.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel16.setText("Gerente en turno: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabelTituloBaja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabeltipoHabitacion)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBoxServicioBar)
                    .addComponent(jTextFieldNumerohabitacion)
                    .addComponent(jTextFieldHabitacionBaja, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jTextFieldNombreHuesped)
                    .addComponent(jCheckBoxServicioTintoreria)
                    .addComponent(jCheckBoxServicioSpa)
                    .addComponent(jTextFieldtipoHabitacion)
                    .addComponent(jCheckBoxServicioCuarto)
                    .addComponent(jTextFieldNumeroHuespedesbaja)
                    .addComponent(jCheckBoxServicioNiñera)
                    .addComponent(jTextFieldCiudadOrigen))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFechallegadaBaja))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFechasalidaBaja)
                                    .addComponent(jTextFieldHuespedesExtrabaja)
                                    .addComponent(jTextFieldNumPiso))))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonBaja)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButtonReciboBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jButtonLimpiar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonBuscar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldSaldobaja, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldGerentebaja, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBaja, jButtonBuscar, jButtonLimpiar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTituloBaja)
                .addGap(12, 12, 12)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldHuespedesExtrabaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jTextFieldCiudadOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextFieldNumPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldSaldobaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabeltipoHabitacion)
                            .addComponent(jTextFieldtipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextFieldNumerohabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextFieldGerentebaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldNumeroHuespedesbaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBoxServicioCuarto)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBoxServicioTintoreria, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxServicioSpa)
                            .addComponent(jButtonLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jCheckBoxServicioNiñera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxServicioBar)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButtonBuscar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBaja)
                            .addComponent(jButtonReciboBaja))))
                .addGap(0, 31, Short.MAX_VALUE))
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
            
               try {
                    this.generarpdf();
                } catch (IOException ex) {
                    Logger.getLogger(bajas.class.getName()).log(Level.SEVERE, null, ex);
                
                } catch (DocumentException ex) {
                Logger.getLogger(bajas.class.getName()).log(Level.SEVERE, null, ex);
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
           String query = "UPDATE  habitaciones SET Ocupado = 0 WHERE num_habitacion = " + "' " + numH + " '";
      
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
         String nombre,ciudad, fecha_llegada, fecha_salida, tipo_habitacion, num_habitacion, num_piso, ingreso, Extras, huespedes,cuenta ;
        huespedes = this.jTextFieldNumeroHuespedesbaja.getText().trim();
        nombre=this.jTextFieldHabitacionBaja.getText().trim();
        fecha_llegada = this.jTextFieldFechallegadaBaja.getText().trim();
        fecha_salida = this.jTextFieldFechasalidaBaja.getText().trim();
        tipo_habitacion = this.jTextFieldtipoHabitacion.getText().trim();
        num_habitacion = this.jTextFieldNumerohabitacion.getText().trim();
        num_piso = this.jTextFieldNumPiso.getText().trim(); 
        ciudad = this.jTextFieldCiudadOrigen.getText().trim();
        ingreso= this.jTextFieldSaldobaja.getText().trim();
        Extras = this.jTextFieldHuespedesExtrabaja.getText().trim();
        cuenta = this.jTextFieldGerentebaja.getText().trim();
        ingreso= this.jTextFieldSaldobaja.getText().trim();
        Extras = this.jTextFieldHuespedesExtrabaja.getText().trim();
        cuenta = this.jTextFieldGerentebaja.getText().trim();

        String query = "SELECT * FROM habitaciones where num_habitacion =  " + "'" + nombre+ "'" + "'"+tipo_habitacion + "'" +"'" + fecha_llegada +"'"+ "'" + fecha_salida + "'"+ "'" + huespedes + "'"+ "'"+ Extras + "'" +"'"+ ingreso + "'";
        
        try {
            estado = (Statement) this.conn.conn.createStatement();
            resultados = estado.executeQuery(query);
            while(resultados.next()){
                
                
                nombre = resultados.getString("nombre");
                this.jTextFieldNombreHuesped.setText(nombre);

                tipo_habitacion = resultados.getString("tipo_habitacion");
                this.jTextFieldtipoHabitacion.setText(tipo_habitacion);
                
                num_habitacion = resultados.getString("num_habitacion");
                this.jTextFieldNumerohabitacion.setText(num_habitacion);
                
                
                num_piso = resultados.getString("num_piso");
                this.jTextFieldNumPiso.setText(num_piso);
                
                ciudad = resultados.getString("ciudad");
                this.jTextFieldCiudadOrigen.setText(ciudad);
                
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
             
                
                 /*String query4 = "SELECT * FROM cuentas = " + "'" + cuenta + "'";
                 System.out.println("Entro al query cuentas generador PDF");*/
        /*try {
               
                estado = (Statement) this.conn.conn.createStatement();
                 resultados = estado.executeQuery(query4);
                while(resultados.next()){
 
         /*resultados.getBlob(1);
          cuenta = resultados.getString(1);*/
          {
                
                /*System.out.println("Resultado tomado de cuenta: "+ cuenta);
             
               
                cuenta = resultados.getString("cuenta");
                this.jTextFieldGerentebaja.setText(cuenta);*/
              
                }
         /*while(resultados.next()){
             
               resultados.getBlob(1);
               
               aux = resultados.getInt(11);
               
         }*/}
     /*}catch(SQLException ex) {
                  JOptionPane.showMessageDialog(this, "Error en la base de datos"+ ex); 
                  System.out.println("Error: "+ex);
     }*/
            
                
                System.out.println("Ingreso de la habitacion antes de servicios: "+ingreso);
            
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

    private void jTextFieldNumPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumPisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumPisoActionPerformed
    

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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField jTextFieldCiudadOrigen;
    private javax.swing.JTextField jTextFieldFechallegadaBaja;
    private javax.swing.JTextField jTextFieldFechasalidaBaja;
    private javax.swing.JTextField jTextFieldGerentebaja;
    private javax.swing.JTextField jTextFieldHabitacionBaja;
    private javax.swing.JTextField jTextFieldHuespedesExtrabaja;
    private javax.swing.JTextField jTextFieldNombreHuesped;
    private javax.swing.JTextField jTextFieldNumPiso;
    private javax.swing.JTextField jTextFieldNumeroHuespedesbaja;
    private javax.swing.JTextField jTextFieldNumerohabitacion;
    private javax.swing.JTextField jTextFieldSaldobaja;
    private javax.swing.JTextField jTextFieldtipoHabitacion;
    // End of variables declaration//GEN-END:variables

 
}