/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Instruccion;
import dominio.Recurso;
import dominio.Sistema;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListSelectionModel;

public class VentanaInstruccion extends javax.swing.JFrame implements Observer  {

    Sistema sis;
    
    public VentanaInstruccion(Sistema pSistema) {
        initComponents();
        sis = pSistema;
        listarRecursos();
        listarInstrucciones();
        
    }

    //Patron singleton
    private static VentanaInstruccion instancia = null;

    // si no existe la crea
    public static VentanaInstruccion getInstancia(Sistema pSistema) {
        if (instancia == null)
            instancia = new VentanaInstruccion(pSistema);
        return instancia;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstInstrucciones = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRecursos = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfTiempo = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Instrucciones");
        setResizable(false);

        jLabel1.setText("Nombre");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lstInstrucciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstInstruccionesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstInstrucciones);

        jLabel2.setText("Instrucciones");

        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
        });

        lstRecursos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstRecursos);

        jLabel3.setText("Recursos");

        jLabel4.setText("Tiempo");

        tfTiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTiempoKeyTyped(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        lblMensaje.setText("Mensaje");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Instrucciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensaje)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfTiempo))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnBorrar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jLabel3)
                    .addContainerGap(398, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnBorrar))
                .addGap(69, 69, 69)
                .addComponent(lblMensaje)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(137, 137, 137)
                    .addComponent(jLabel3)
                    .addContainerGap(324, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiarMensajes();
        String nombre = tfNombre.getText();
        int tiempo = PedirNumero(tfTiempo.getText(), 1, 999999);
        Recurso recurso = (Recurso) lstRecursos.getSelectedValue();
        if(!faltanDatos(nombre, tiempo)){
            Instruccion i = new Instruccion(nombre, tiempo, recurso);
            if(sis.agregarInstruccion(i)){
                lblMensaje.setText("Instruccion agregada exitosamente!");
                listarInstrucciones();
                limpiar();
            }
            else{
                lblMensaje.setText("Error: Ya existe una instruccion con el nombre ingresado");
                tfNombre.setForeground(Color.RED);
            }
        }
        else{
            lblMensaje.setText("Error: verifique que los campos no están vacíos y sean validos");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Instruccion i = (Instruccion) lstInstrucciones.getSelectedValue();
        if(i != null){
            sis.borrarInstruccion(i);
            lblMensaje.setText("La instruccion "+ i.toString() + " fue eliminada del sistema exitosamente!" );
            listarInstrucciones();
            limpiar();
        }
        else{
            lstInstrucciones.setForeground(Color.RED);
            lblMensaje.setText("Error: Debe seleccionar la instruccion a eliminar" );
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        tfNombre.setForeground(Color.BLACK);
        tfNombre.setText("");
    }//GEN-LAST:event_tfNombreKeyTyped

    private void tfTiempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTiempoKeyTyped
        tfTiempo.setForeground(Color.BLACK);
    }//GEN-LAST:event_tfTiempoKeyTyped

    private void lstInstruccionesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstInstruccionesMouseReleased
        lstInstrucciones.setForeground(Color.BLACK);
    }//GEN-LAST:event_lstInstruccionesMouseReleased

    //AUX
    private void listarRecursos(){
        this.lstRecursos.setListData(sis.getRecursos().toArray());
    }
    
    private void listarInstrucciones(){
        lstInstrucciones.setListData(sis.getInstrucciones().values().toArray());
    }
    
    private void limpiar(){
        tfNombre.setText("");
        tfTiempo.setText("");
        tfNombre.setForeground(Color.BLACK);
        tfTiempo.setForeground(Color.BLACK);
        lstInstrucciones.setForeground(Color.BLACK);
    }
    
    private boolean faltanDatos(String nombre, int tiempo) {
        boolean ret = false;
        if (nombre.equals("")) {
            tfNombre.setForeground(Color.RED);
            ret = true;
        }
        if (tiempo == -1) {
            tfTiempo.setForeground(Color.RED);
            ret = true;
        }
        return ret;
    }
    
     private void limpiarMensajes() {
        lblMensaje.setText("");
    }
    
     
    public static int PedirNumero(String texto, int min, int max) { //Funcion generica que verifica si el numero ingresado es valido
        int numeroIngresado = -1;
        try {
            numeroIngresado = Integer.parseInt(texto);
            if (numeroIngresado < min || numeroIngresado > max) {
                numeroIngresado = -1;
            } 
        } 
        catch (NumberFormatException e) {}
        return numeroIngresado;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JList lstInstrucciones;
    private javax.swing.JList lstRecursos;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfTiempo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        listarRecursos();
        listarInstrucciones();
    }
}
