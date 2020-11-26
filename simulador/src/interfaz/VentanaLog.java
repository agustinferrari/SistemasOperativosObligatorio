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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.in;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class VentanaLog extends javax.swing.JFrame implements Observer{

   private Sistema sis;
   
    public VentanaLog(Sistema miSistema) {
        initComponents();
        sis = miSistema;
        sis.addObserver(this);
        metodoEscribirLog();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLog = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOG");

        textLog.setEditable(false);
        textLog.setColumns(20);
        textLog.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textLog.setRows(5);
        jScrollPane1.setViewportView(textLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(404, 404, 404))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        borrar();
    }//GEN-LAST:event_formWindowClosing

    
//Patron singleton
    private static VentanaLog instancia = null;

    // si no existe la crea
    public static VentanaLog getInstancia(Sistema pSistema) {
        if (instancia == null){
            instancia = new VentanaLog(pSistema);
        }
        return instancia;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea textLog;
    // End of variables declaration//GEN-END:variables

private void metodoEscribirLog (){
  BufferedReader buff = null;
  try {
       borrar();
       buff = new BufferedReader(new FileReader("Log.txt"));
       String str;
       while ((str = buff.readLine()) != null) {
       textLog.append(str + "\n");
   }
 } catch (IOException e) {
//      sis.log("Aca es donde se cae linea 102 ventanaLog");
  } finally {
    try { in.close(); } catch (Exception ex) {sis.log("Se cae en escribir"); }
    }
}

private  void borrar(){
    textLog.selectAll();
    textLog.replaceSelection("");
}
    @Override
   public void update(Observable o, Object o1) {
      borrar();
      metodoEscribirLog();
    }

}
