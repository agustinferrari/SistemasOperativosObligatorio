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
   
    public VentanaLog(Sistema pSistema) {
        initComponents();
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
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("LOG");

        textLog.setEditable(false);
        textLog.setColumns(20);
        textLog.setRows(5);
        jScrollPane1.setViewportView(textLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(433, 433, 433))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
//Patron singleton
    private static VentanaLog instancia = null;

    // si no existe la crea
    public static VentanaLog getInstancia(Sistema pSistema) {
        if (instancia == null)
            instancia = new VentanaLog(pSistema);
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
       buff = new BufferedReader(new FileReader("Log.txt"));
       String str;
       while ((str = buff.readLine()) != null) {
       textLog.append(str + "\n");
   }
 } catch (IOException e) {
      sis.log("Aca es donde se cae linea 102 ventanaLog");
  } finally {
    try { in.close(); } catch (Exception ex) {sis.log("Se cae en escribir"); }
    }
}

private void borrar(){
    textLog.removeAll();
}
    @Override
   public void update(Observable o, Object o1) {
      borrar();
      metodoEscribirLog();
      //sis.log("Funciona el update");
    }


}
