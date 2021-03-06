package interfaz;

import dominio.Sistema;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.io.File;
import utlilidades.Prueba;

public class VentanaPruebas extends javax.swing.JFrame {

    VentanaPrincipal ventanaActual;
    Sistema sistema;

    public VentanaPruebas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPruebaMutuaExcl = new javax.swing.JButton();
        btnPruebaBasica = new javax.swing.JButton();
        btnPruebaDeadlock = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnPruebaVacio = new javax.swing.JButton();
        btnPruebaPermisos = new javax.swing.JButton();
        btnPruebaMemoria = new javax.swing.JButton();
        btnPruebaCompleta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnPruebaMutuaExcl.setText("Prueba Mutua Excl.");
        btnPruebaMutuaExcl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaMutuaExclActionPerformed(evt);
            }
        });

        btnPruebaBasica.setText("Prueba Básica");
        btnPruebaBasica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaBasicaActionPerformed(evt);
            }
        });

        btnPruebaDeadlock.setText("Prueba Deadlock");
        btnPruebaDeadlock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaDeadlockActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SELECCIONE PRUEBA ");

        btnPruebaVacio.setText("Sistema Vacío");
        btnPruebaVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaVacioActionPerformed(evt);
            }
        });

        btnPruebaPermisos.setText("Prueba Permisos");
        btnPruebaPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaPermisosActionPerformed(evt);
            }
        });

        btnPruebaMemoria.setText("Prueba Memoria");
        btnPruebaMemoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaMemoriaActionPerformed(evt);
            }
        });

        btnPruebaCompleta.setText("Prueba Completa");
        btnPruebaCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaCompletaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPruebaBasica, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPruebaPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPruebaMutuaExcl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPruebaMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPruebaCompleta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPruebaVacio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPruebaDeadlock, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPruebaBasica, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPruebaDeadlock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPruebaCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPruebaMutuaExcl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPruebaPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPruebaVacio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPruebaMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPruebaMutuaExclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaMutuaExclActionPerformed
        borrarArchivoLog();
        sistema = Prueba.inicializarMutuaExclusion();
        CargarVentanaPrincipal();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnPruebaMutuaExclActionPerformed

    private void btnPruebaBasicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaBasicaActionPerformed
        borrarArchivoLog();
        sistema = Prueba.inicializarBasica();
        CargarVentanaPrincipal();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnPruebaBasicaActionPerformed

    private void btnPruebaDeadlockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaDeadlockActionPerformed
        borrarArchivoLog();
        sistema = Prueba.inicializarDeadlock();
        CargarVentanaPrincipal();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnPruebaDeadlockActionPerformed

    private void btnPruebaVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaVacioActionPerformed
        borrarArchivoLog();
        sistema = Prueba.inicializarVacio();
        CargarVentanaPrincipal();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnPruebaVacioActionPerformed

    private void btnPruebaPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaPermisosActionPerformed
        borrarArchivoLog();
        sistema = Prueba.inicializarPermisos();
        CargarVentanaPrincipal();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnPruebaPermisosActionPerformed

    private void btnPruebaMemoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaMemoriaActionPerformed
        borrarArchivoLog();
        sistema = Prueba.inicializarMemoria();
        CargarVentanaPrincipal();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnPruebaMemoriaActionPerformed

    private void btnPruebaCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaCompletaActionPerformed
        borrarArchivoLog();
        sistema = Prueba.inicializar();
        CargarVentanaPrincipal();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnPruebaCompletaActionPerformed

    private static void borrarArchivoLog() {
        try {
            File f = new File("Log.txt");
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void CargarVentanaPrincipal() {
        //borrar si existe archivo Log.txt
        ventanaActual = new VentanaPrincipal(sistema);
        ventanaActual.setMinimumSize(new Dimension(1366, 720));
        ventanaActual.setVisible(true);
        sistema.addObserver(ventanaActual);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPruebaBasica;
    private javax.swing.JButton btnPruebaCompleta;
    private javax.swing.JButton btnPruebaDeadlock;
    private javax.swing.JButton btnPruebaMemoria;
    private javax.swing.JButton btnPruebaMutuaExcl;
    private javax.swing.JButton btnPruebaPermisos;
    private javax.swing.JButton btnPruebaVacio;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
