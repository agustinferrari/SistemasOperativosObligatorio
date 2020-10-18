/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Proceso;
import dominio.Sistema;
import dominio.Usuario;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class SesionUsuario extends javax.swing.JFrame implements Observer{

    Sistema sis;
    Usuario user;
    
    public SesionUsuario(Sistema pSistema, Usuario pUsuario) {
        initComponents();
        sis = pSistema;
        user = pUsuario;
        listarProceso();
    }

    public Sistema getSis() {
        return sis;
    }

    public Usuario getUser() {
        return user;
    }
    
    //Patron singleton
    private static List<SesionUsuario> instancias = null;
    private static SesionUsuario instanciaActual = null;
    
    public static SesionUsuario getInstancia(Sistema pSistema, Usuario pUsuario){
        if(instancias == null)
            instancias = new ArrayList<SesionUsuario>();
        for(SesionUsuario s : instancias){
            if(s.getUser().equals(pUsuario)){
                instanciaActual = s;
                return s;
            }
        }
        instanciaActual = new SesionUsuario(pSistema, pUsuario);
        instancias.add(instanciaActual);
        return instanciaActual;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProcesos = new javax.swing.JList();
        tfProceso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario: //todo");

        lblMensaje.setText("Mensaje");

        jScrollPane1.setViewportView(lstProcesos);

        jLabel2.setText("Agregar Proceso");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel3.setText("Lista Procesos Listos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(147, 147, 147)))
                        .addComponent(btnAgregar)
                        .addGap(0, 149, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblMensaje)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGap(55, 55, 55)
                .addComponent(lblMensaje)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiarMensajes();
        String nombre = tfProceso.getText();
        if(!faltanDatos(nombre)){
            Proceso p = new Proceso(nombre, user);
            sis.agregarProcesosListos(p);
            lblMensaje.setText("Proceso agregado exitosamente!");
            listarProceso();
            limpiar();
        }
        else{
            lblMensaje.setText("Error: el codigo del programa no debe ser vacio");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    //AUX
    private void listarProceso(){
        lstProcesos.setListData(sis.getProcesosListos(user).toArray());
    }
    
    private void limpiar(){
        tfProceso.setText("");
        tfProceso.setForeground(Color.BLACK);
    }
    
    private boolean faltanDatos(String procesoString) {
        boolean ret = false;
        if (procesoString.equals("")) {
            tfProceso.setForeground(Color.RED);
            ret = true;
        }
        return ret;
    }
    
     private void limpiarMensajes() {
        lblMensaje.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JList lstProcesos;
    private javax.swing.JTextField tfProceso;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        listarProceso();
    }
}
