/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Recurso;
import dominio.Sistema;
import java.awt.Color;

/**
 *
 * @author ivanm
 */
public class VentanaRecurso extends javax.swing.JFrame {

    Sistema sis;
    
    public VentanaRecurso(Sistema pSistema) {
        initComponents();
        sis = pSistema;
        listarRecursos();
    }
    
    //Patron singleton
    private static VentanaRecurso instancia = null;

    // si no existe la crea
    public static VentanaRecurso getInstancia(Sistema pSistema) {
        if (instancia == null)
            instancia = new VentanaRecurso(pSistema);
        return instancia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBorrarRecurso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRecursos = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBorrarRecurso.setText("Borrar Recurso");
        btnBorrarRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarRecursoActionPerformed(evt);
            }
        });

        lstRecursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstRecursosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstRecursos);

        jLabel1.setText("Nombre");

        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
        });

        jLabel2.setText("Lista Recursos");

        btnAgregar.setText("Agregar Recurso");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblMensaje.setText("Mensaje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(695, Short.MAX_VALUE)
                .addComponent(lblMensaje)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(btnBorrarRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btnBorrarRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblMensaje)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiarMensajes();
        String nombre = tfNombre.getText();
        if(!faltanDatos(nombre)){
            Recurso r = new Recurso(nombre);
            if(sis.agregarRecurso(r)){
                lblMensaje.setText("Recurso agregado exitosamente!");
                listarRecursos();
                limpiar();
            }
            else{
                lblMensaje.setText("Error: Ya existe un recurso con el nombre ingresado");
                tfNombre.setForeground(Color.RED);
            }
        }
        else{
            lblMensaje.setText("Error: el nombre del recurso no debe ser vacio");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        tfNombre.setForeground(Color.BLACK);
    }//GEN-LAST:event_tfNombreKeyTyped

    private void btnBorrarRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarRecursoActionPerformed
        Recurso r = (Recurso) lstRecursos.getSelectedValue();
        if(r != null){
            sis.borrarRecurso(r);
            lblMensaje.setText("El recurso "+ r.toString() + " fue eliminado del sistema exitosamente!" );
            listarRecursos();
            limpiar();
        }
        else{
            lstRecursos.setForeground(Color.RED);
            lblMensaje.setText("Error: Debe seleccionar el recurso a eliminar" );
        }
    }//GEN-LAST:event_btnBorrarRecursoActionPerformed

    private void lstRecursosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstRecursosMouseReleased
        lstRecursos.setForeground(Color.BLACK);
    }//GEN-LAST:event_lstRecursosMouseReleased

    //AUX
    private void listarRecursos(){
        lstRecursos.setListData(sis.getRecursos().toArray());
    }
    
    private void limpiar(){
        tfNombre.setText("");
        tfNombre.setForeground(Color.BLACK);
    }
    
    private boolean faltanDatos(String nombre) {
        boolean ret = false;
        if (nombre.equals("")) {
            tfNombre.setForeground(Color.RED);
            ret = true;
        }
        return ret;
    }
    
     private void limpiarMensajes() {
        lblMensaje.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrarRecurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JList lstRecursos;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
