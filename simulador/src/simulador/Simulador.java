package simulador;

import dominio.Instruccion;
import dominio.Proceso;
import dominio.Recurso;
import dominio.Sistema;
import dominio.Usuario;
import interfaz.VentanaPrincipal;
import java.awt.Dimension;
import java.io.File;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Simulador {

    public static void main(String[] args) {
        
        cambiarEstiloUIWindows();
        
        //Sistema sistema = new Sistema();
        Sistema sistema = inicializar();
        
        //borrar si existe archivo Log.txt
        borrarArchivoLog();
        sistema.log("Log test sistema");
        /*Usuario u1 = new Usuario("Pepe");
        Usuario u2 = new Usuario("Juan");
        sistema.agregarUsuario(u2);
        sistema.agregarUsuario(u1);*/
        VentanaPrincipal vent = new VentanaPrincipal(sistema);
        vent.setMinimumSize(new Dimension(920, 600));
        vent.setVisible(true);
        sistema.addObserver(vent);
        //sistema.ejecutar();
   
    }

    private static void borrarArchivoLog(){
        try{
         File f = new File("Log.txt");
         f.delete();
        }
        catch(Exception e){
            e.printStackTrace();
        }
       

    }
    public static Sistema inicializar(){
        Recurso r1 = new Recurso("Rec1");
        Recurso r2 = new Recurso("Rec2");
        Recurso r3 = new Recurso("Rec3");

        Instruccion i1 = new Instruccion('1', 5, r1);
        Instruccion i2 = new Instruccion('B', 1, null);
        Instruccion i3 = new Instruccion('4', 7, r1);
        Instruccion i4 = new Instruccion('3', 3, r3);
        Instruccion i5 = new Instruccion('2', 4, r2);
        
        
        Usuario u1 = new Usuario("Pepe");
        Usuario u2 = new Usuario("Juan");
        Usuario admin = new Usuario("admin");
        
        u1.agregarPermiso(r1);
        u2.agregarPermiso(r1);
        u2.agregarPermiso(r2);
        
        admin.agregarPermiso(r1);
        admin.agregarPermiso(r2);
        admin.agregarPermiso(r3);

        

        Proceso p1 = new Proceso("1B441", u1);
        Proceso p2 = new Proceso("B412", u2);
        Proceso p3 = new Proceso("2133", u1);
        
        Sistema sistema = new Sistema();
        
        sistema.agregarUsuario(u1);
        sistema.agregarUsuario(u2);
        sistema.agregarUsuario(admin);
        
        sistema.agregarInstruccion(i1);
        sistema.agregarInstruccion(i2);
        sistema.agregarInstruccion(i3);
        sistema.agregarInstruccion(i4);
        sistema.agregarInstruccion(i5);

        sistema.agregarProcesosListos(p1);
        sistema.agregarProcesosListos(p2);
        sistema.agregarProcesosListos(p3);
     
        sistema.agregarRecurso(r1);
        sistema.agregarRecurso(r2);
        sistema.agregarRecurso(r3);

        return sistema;
    
    }
    
    
     private static void cambiarEstiloUIWindows() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

        }
     }
}
