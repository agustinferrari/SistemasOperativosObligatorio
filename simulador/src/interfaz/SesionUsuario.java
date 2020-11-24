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
        getContentPane().setLayout(null);

        lblMensaje.setText("Mensaje");
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(370, 390, 48, 16);

        jScrollPane1.setViewportView(lstProcesos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 50, 164, 224);
        getContentPane().add(tfProceso);
        tfProceso.setBounds(40, 330, 153, 24);

        jLabel2.setText("Agregar Proceso");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 290, 97, 16);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(210, 390, 89, 32);

        jLabel3.setText("Lista Procesos Listos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 30, 124, 16);

        jScrollPane2.setViewportView(lstRecursos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(230, 50, 184, 221);

        jLabel4.setText("Lista Recursos");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 30, 86, 16);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Sesion");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 10, 40, 17);

        jLabel5.setText("Nombre");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 310, 45, 16);

        jLabel6.setText("Espacio en memoria");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 360, 116, 16);
        getContentPane().add(tfEspacioNecesario);
        tfEspacioNecesario.setBounds(40, 390, 153, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiarMensajes();
        String nombre = tfProceso.getText();
        int espacioNecesario = PedirNumero(tfEspacioNecesario.getText(), 1, 32);
        if (!faltanDatos(nombre, espacioNecesario)) {
            Proceso p = new Proceso(nombre, user, espacioNecesario);//TODO
            sis.agregarProcesosListos(p);
            lblMensaje.setText("Proceso agregado exitosamente!");
            listarProceso();
            limpiar();
        } else {
            lblMensaje.setText("Error: el codigo del programa no debe ser vacio");
        }
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
