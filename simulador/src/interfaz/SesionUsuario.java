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

public class SesionUsuario extends javax.swing.JFrame implements Observer {

    Sistema sis;
    Usuario user;

    public SesionUsuario(Sistema pSistema, Usuario pUsuario) {
        initComponents();
        sis = pSistema;
        user = pUsuario;
        listarProceso();
        listarRecursos();

        this.setTitle("Usuario: " + pUsuario.getNombre());

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

    public static SesionUsuario getInstancia(Sistema pSistema, Usuario pUsuario) {
        if (instancias == null) {
            instancias = new ArrayList<SesionUsuario>();
        }
        for (SesionUsuario s : instancias) {
            if (s.getUser().equals(pUsuario)) {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRecursos = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfEspacioNecesario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuario: //todo");
        setResizable(false);

        jScrollPane1.setViewportView(lstProcesos);

        jLabel2.setText("Agregar Proceso");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel3.setText("Lista Procesos Listos");

        jScrollPane2.setViewportView(lstRecursos);

        jLabel4.setText("Lista Recursos");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sesion");

        jLabel5.setText("Serie de instrucciones");

        jLabel6.setText("Espacio en memoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(tfProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfEspacioNecesario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(tfProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(tfEspacioNecesario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        String nombre = tfProceso.getText();
        int espacioNecesario = PedirNumero(tfEspacioNecesario.getText(), 1, 32);
        if (!faltanDatos(nombre, espacioNecesario)) {
            Proceso p = new Proceso(nombre, user, espacioNecesario);//TODO
            sis.agregarProcesosListos(p);
            lblMensaje.setText("Proceso agregado exitosamente!");
            listarProceso();
            limpiar();
        } else {
            lblMensaje.setText("Error: el codigo del programa no debe ser vacio y el espacio en memoria debe ser menor a 32 KB");
        }
        limpiarMensajes();
    }//GEN-LAST:event_btnAgregarActionPerformed

    //AUX
    private void listarProceso() {
        lstProcesos.setListData(sis.getProcesosListosDelUsuario(user).toArray());
    }

    private void listarRecursos() {
        lstRecursos.setListData(user.getRecursosPermitidos().toArray());
    }

    private void limpiar() {
        tfProceso.setText("");
        tfProceso.setForeground(Color.BLACK);
        tfEspacioNecesario.setForeground(Color.BLACK);
    }

    private boolean faltanDatos(String procesoString, int espacio) {
        boolean ret = false;
        if (procesoString.equals("")) {
            tfProceso.setForeground(Color.RED);
            ret = true;
        }
        if (espacio == -1) {
            tfEspacioNecesario.setForeground(Color.RED);
            ret = true;
        }
        return ret;
    }

    private void limpiarMensajes() {
        lblMensaje.setText("");
        tfEspacioNecesario.setText("");
    }

    public static int PedirNumero(String texto, int min, int max) { //Funcion generica que verifica si el numero ingresado es valido
        int numeroIngresado = -1;
        try {
            numeroIngresado = Integer.parseInt(texto);
            if (numeroIngresado < min || numeroIngresado > max) {
                numeroIngresado = -1;
            }
        } catch (NumberFormatException e) {
        }
        return numeroIngresado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JList lstProcesos;
    private javax.swing.JList lstRecursos;
    private javax.swing.JTextField tfEspacioNecesario;
    private javax.swing.JTextField tfProceso;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        listarProceso();
        listarRecursos();
    }
}
