/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Recurso;
import dominio.Sistema;
import dominio.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivanm
 */
public class VentanaPrincipal extends javax.swing.JFrame implements Observer{

    Sistema sis;

    public VentanaPrincipal(Sistema pSistema) {
        initComponents();
        sis = pSistema;
        listarUsuarios();
        timeout.setValue(sis.getTimeout());
    }
    
    private void listarUsuarios(){
        lstUsuarios.setListData(sis.getUsuarios().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUsuarios = new javax.swing.JButton();
        btnRecursos = new javax.swing.JButton();
        btnInstrucciones = new javax.swing.JButton();
        btnCorrer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        abrirSesion = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        timeout = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnRecursos.setText("Recursos");
        btnRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecursosActionPerformed(evt);
            }
        });

        btnInstrucciones.setText("Instrucciones");
        btnInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstruccionesActionPerformed(evt);
            }
        });

        btnCorrer.setText("Correr Sistema");
        btnCorrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrerActionPerformed(evt);
            }
        });

        lstUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstUsuariosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstUsuarios);

        jLabel1.setText("Lista de usuarios");

        abrirSesion.setText("Abrir");
        abrirSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirSesionActionPerformed(evt);
            }
        });

        lblMensaje.setText("Mensaje");
        lblMensaje.setToolTipText("");

        jLabel2.setText("Timeout: ");

        timeout.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        timeout.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timeoutPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)
                        .addGap(0, 490, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMensaje)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abrirSesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnCorrer, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abrirSesion))
                .addGap(36, 36, 36)
                .addComponent(btnCorrer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lblMensaje)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(timeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecursosActionPerformed
        VentanaRecurso vent = VentanaRecurso.getInstancia(sis);
        vent.setMinimumSize(new Dimension(820, 378));
        vent.setVisible(true);
        this.sis.addObserver(vent);
    }//GEN-LAST:event_btnRecursosActionPerformed

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed
        VentanaInstruccion vent = VentanaInstruccion.getInstancia(sis);
        vent.setMinimumSize(new Dimension(820, 378));
        vent.setVisible(true);
        this.sis.addObserver(vent);
    }//GEN-LAST:event_btnInstruccionesActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        VentanaUsuario vent = VentanaUsuario.getInstancia(sis);
        vent.setMinimumSize(new Dimension(820, 378));
        vent.setVisible(true);
        this.sis.addObserver(vent);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrerActionPerformed
         int valorTimeout = (Integer) timeout.getValue();
        sis.log("Timout: " + valorTimeout);
        sis.setTimeout(valorTimeout);

        sis.ejecutar();
    }//GEN-LAST:event_btnCorrerActionPerformed

    private void lstUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstUsuariosMouseReleased
        lstUsuarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_lstUsuariosMouseReleased

    private void abrirSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirSesionActionPerformed
        
        Usuario u = (Usuario) lstUsuarios.getSelectedValue();
        
          if(u != null){
            SesionUsuario vent = SesionUsuario.getInstancia(sis,u);
            vent.setMinimumSize(new Dimension(820, 378));
            vent.setVisible(true);
            this.sis.addObserver(vent);
            vent.toFront();
        }
        else{
            lblMensaje.setText("Por favor selecciones un usuario para correr el sistema");
            lstUsuarios.setForeground(Color.RED);
        }
        
    }//GEN-LAST:event_abrirSesionActionPerformed

    private void timeoutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timeoutPropertyChange
       /* try{
            timeout.commitEdit();
        } catch (ParseException ex) {
            //Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            int valorTimeout = Integer) timeout.getValue()
            sis.log("Timout: " + valorTimeout));
            sis.setTimeout(();
        } */
        
    }//GEN-LAST:event_timeoutPropertyChange

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirSesion;
    private javax.swing.JButton btnCorrer;
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JButton btnRecursos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JList lstUsuarios;
    private javax.swing.JSpinner timeout;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        listarUsuarios();
    }
}
