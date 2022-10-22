/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainOrganizer;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jackiesanchez
 */
public class FrmAddTask extends javax.swing.JFrame {
    /**
     * Creates new form Frm
     */
    public FrmAddTask() {
        initComponents();
        setLocationRelativeTo(this);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNombreTarea = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcionTarea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Inicio = new com.toedter.calendar.JDateChooser();
        Fin = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel2.setFont(new java.awt.Font("Geneva", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Tarea:");

        txtNombreTarea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnRegresar.setBackground(new java.awt.Color(153, 153, 153));
        btnRegresar.setFont(new java.awt.Font("Geneva", 1, 18)); // NOI18N
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainOrganizer/Pictures/GOBACK.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(153, 153, 153));
        btnAgregar.setFont(new java.awt.Font("Geneva", 1, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainOrganizer/Pictures/ADD.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Geneva", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGREGAR NUEVA TAREA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Geneva", 1, 14)); // NOI18N
        jLabel3.setText("Descripcion Tarea:");

        txtDescripcionTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionTareaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Geneva", 1, 14)); // NOI18N
        jLabel4.setText("Fecha Inicio");

        jLabel5.setFont(new java.awt.Font("Geneva", 1, 14)); // NOI18N
        jLabel5.setText("Fecha Final");

        jLabel6.setFont(new java.awt.Font("Geneva", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Agregar Vigencia de La Tarea");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreTarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionTarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
       ListedTasks frm = new ListedTasks();
       frm.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    /**
     * Método que agrega un curso a la lista de cursos
     * @param evt 
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try{
         SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
         UUID uuid = UUID.randomUUID();
         ListTasks listadoTareas = GlobalStatus.TransferencialistadoTareas;
         String id = uuid.toString();
         String idLista = GlobalStatus.TransferencialistadoTareas.getIdListadoTareas();
         Date inicio = Inicio.getDate();
         Date fin = Fin.getDate();
         String nombre = txtNombreTarea.getText().trim().replaceAll("\\s*\\|\\s*", " pipe operator ");
         String descripcion = txtDescripcionTarea.getText().trim().replaceAll("\\s*\\|\\s*", " pipe operator ");
         String fechaInicio = "";
         String fechaFinal = "";
        if (inicio != null && fin != null) {
            fechaInicio = fecha.format(Inicio.getCalendar().getTime());
            fechaFinal = fecha.format(Fin.getCalendar().getTime());
        }           
         if (!nombre.equals("") && !descripcion.equals("") && !nombre.isBlank() && !descripcion.isBlank() && !nombre.isEmpty() && !descripcion.isEmpty()) {
            ArrayList<Task> lista = new ArrayList();
            Task tarea = new Task();            
             if (!fechaInicio.equals("") && !fechaFinal.equals("") && !fechaInicio.isBlank() && !fechaFinal.isBlank() && !fechaInicio.isEmpty() && !fechaFinal.isEmpty()) {                
                 Date dt_1 = fecha.parse(fechaInicio);
                 Date dt_2 = fecha.parse(fechaFinal);
                if (dt_1.compareTo(dt_2) > 0) {  
                    JOptionPane.showMessageDialog(null, "La fecha inicio ocurre luego de la fecha final");
                } 
                else if (dt_1.compareTo(dt_2) < 0) {  
                    tarea.setFechaInicio(fechaInicio);
                    tarea.setFechaFinal(fechaFinal); 
                    tarea.setIdLista(idLista);
                    tarea.setId(id);
                    tarea.setNombre(nombre);
                    tarea.setDescripcion(descripcion);
                    tarea.setVigencia(fechaFinal);
                    lista.add(tarea);
                    listadoTareas.aniadirTareasLista(lista);
                    JOptionPane.showMessageDialog(null, "Tarea creada exitosamente!");
                } 
                else if (dt_1.compareTo(dt_2) == 0) {  
                     tarea.setFechaInicio(fechaInicio);
                     tarea.setFechaFinal(fechaFinal);
                     tarea.setIdLista(idLista);
                     tarea.setId(id);
                     tarea.setNombre(nombre);
                     tarea.setDescripcion(descripcion);
                      tarea.setVigencia(fechaFinal);
                     lista.add(tarea);
                     listadoTareas.aniadirTareasLista(lista);
                     JOptionPane.showMessageDialog(null, "Tarea creada exitosamente!");
                } // el método compareTo devuelve el valor 0 si el argumento Fecha es igual a la segunda Fecha;
                else {  
                    System.out.println("¡Pareces ser un viajero del tiempo!");
                }
               
             }else{
                tarea.setIdLista(idLista);
                tarea.setId(id);
                tarea.setNombre(nombre);
                tarea.setDescripcion(descripcion);
                tarea.setFechaInicio("sin datos");
                tarea.setFechaFinal("sin datos");
                tarea.setVigenciaToString("sin datos");
                lista.add(tarea);
                listadoTareas.aniadirTareasLista(lista);
                JOptionPane.showMessageDialog(null, "Tarea creada exitosamente!");
             }                      
            txtNombreTarea.setText("");
            txtDescripcionTarea.setText("");
         }else{
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
         }
        }catch(NumberFormatException | HeadlessException ex){
            JOptionPane.showMessageDialog(null, "Error! " + ex);
            txtNombreTarea.setText("");
            txtDescripcionTarea.setText("");
        } catch (ParseException ex) {
            Logger.getLogger(FrmAddTask.class.getName()).log(Level.SEVERE, null, ex);
        }        
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDescripcionTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionTareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionTareaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Fin;
    private com.toedter.calendar.JDateChooser Inicio;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescripcionTarea;
    private javax.swing.JTextField txtNombreTarea;
    // End of variables declaration//GEN-END:variables
}
