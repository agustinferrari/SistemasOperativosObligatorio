/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Sistema;
import dominio.Usuario;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;
import utlilidades.Prueba;

/**
 *
 * @author agust
 */
public class VentanaPruebas extends javax.swing.JFrame {

    VentanaPrincipal ventanaActual;
    Sistema sistema;

    public VentanaPruebas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrueba1 = new javax.swing.JButton();
        btnPrueba2 = new javax.swing.JButton();
        btnPrueba3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnPrueba4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPrueba1.setText("Prueba 3");
        btnPrueba1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrueba1ActionPerformed(evt);
            }
        });

        btnPrueba2.setText("Prueba 1");
        btnPrueba2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrueba2ActionPerformed(evt);
            }
        });

        btnPrueba3.setText("Prueba 3");
        btnPrueba3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrueba3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SELECCIONE PRUEBA ");

        btnPrueba4.setText("Sistema Vacio");
        btnPrueba4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrueba4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrueba2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrueba4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrueba1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrueba3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrueba1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrueba2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrueba3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPrueba4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrueba1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrueba1ActionPerformed
        sistema = Prueba.inicializar();
        CargarVentanaPrincipal();
    }//GEN-LAST:event_btnPrueba1ActionPerformed

    private void btnPrueba2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrueba2ActionPerformed
        sistema = Prueba.inicializar2();
        CargarVentanaPrincipal();
    }//GEN-LAST:event_btnPrueba2ActionPerformed

    private void btnPrueba3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrueba3ActionPerformed
        sistema = Prueba.inicializarDeadlock();
        CargarVentanaPrincipal();
    }//GEN-LAST:event_btnPrueba3ActionPerformed

    private void btnPrueba4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrueba4ActionPerformed
        sistema = Prueba.inicializarVacio();
        CargarVentanaPrincipal();
    }//GEN-LAST:event_btnPrueba4ActionPerformed

    private static void borrarArchivoLog() {
        try {
            File f = new File("Log.txt");
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void borrarVentanas() {
        for (Usuario u : this.sistema.getUsuarios()) {
            SesionUsuario vent3 = SesionUsuario.getInstancia(sistema, u);
            limpiarVentana(vent3);
        }
        VentanaRecurso vent1 = VentanaRecurso.getInstancia(sistema);
        VentanaUsuario vent2 = VentanaUsuario.getInstancia(sistema);
        VentanaLog vent4 = VentanaLog.getInstancia(sistema);
        VentanaInstruccion vent5 = VentanaInstruccion.getInstancia(sistema);
        limpiarVentana(vent1);
        limpiarVentana(vent2);
        limpiarVentana(vent4);
        limpiarVentana(vent5);
    }

    private void limpiarVentana(JFrame vent) {
        if (vent != null) {
            vent.dispatchEvent(new WindowEvent(vent, WindowEvent.WINDOW_CLOSING));
        }
    }

    private void CargarVentanaPrincipal() {
        //borrar si existe archivo Log.txt
        borrarArchivoLog();
        borrarVentanas();
        limpiarVentana(ventanaActual);
        sistema.log("Log test sistema");
        ventanaActual = new VentanaPrincipal(sistema);
        ventanaActual.setMinimumSize(new Dimension(920, 600));
        ventanaActual.setVisible(true);
        sistema.addObserver(ventanaActual);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrueba1;
    private javax.swing.JButton btnPrueba2;
    private javax.swing.JButton btnPrueba3;
    private javax.swing.JButton btnPrueba4;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
