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

/**
 *
 * @author ivanm
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    Sistema sis;

    public VentanaPrincipal(Sistema pSistema) {
        initComponents();
        sis = pSistema;
        listarUsuarios();
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
        jButton6 = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lstUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstUsuariosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lstUsuarios);

        jLabel1.setText("Lista de usuarios");

        jButton6.setText("Abrir");

        lblMensaje.setText("Mensaje");
        lblMensaje.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInstrucciones)
                    .addComponent(btnRecursos)
                    .addComponent(btnUsuarios))
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btnCorrer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensaje)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecursos)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(btnInstrucciones)
                .addGap(150, 150, 150)
                .addComponent(btnCorrer)
                .addGap(32, 32, 32)
                .addComponent(lblMensaje)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecursosActionPerformed
        VentanaRecurso vent = VentanaRecurso.getInstancia(sis);
        vent.setMinimumSize(new Dimension(820, 378));
        vent.setVisible(true);
    }//GEN-LAST:event_btnRecursosActionPerformed

    private void btnInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstruccionesActionPerformed
        VentanaInstruccion vent = VentanaInstruccion.getInstancia(sis);
        vent.setMinimumSize(new Dimension(820, 378));
        vent.setVisible(true);
    }//GEN-LAST:event_btnInstruccionesActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        VentanaUsuario vent = VentanaUsuario.getInstancia(sis);
        vent.setMinimumSize(new Dimension(820, 378));
        vent.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrerActionPerformed
        Usuario usuario = (Usuario) lstUsuarios.getSelectedValue();
        if(usuario != null){
            SesionUsuario vent = SesionUsuario.getInstancia(sis, usuario);
            vent.setMinimumSize(new Dimension(820, 378));
            vent.setVisible(true);
            vent.toFront();
        }
        else{
            lblMensaje.setText("Por favor selecciones un usuario para correr el sistema");
            lstUsuarios.setForeground(Color.RED);
        }
    }//GEN-LAST:event_btnCorrerActionPerformed

    private void lstUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstUsuariosMouseReleased
        lstUsuarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_lstUsuariosMouseReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCorrer;
    private javax.swing.JButton btnInstrucciones;
    private javax.swing.JButton btnRecursos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JList lstUsuarios;
    // End of variables declaration//GEN-END:variables
}
