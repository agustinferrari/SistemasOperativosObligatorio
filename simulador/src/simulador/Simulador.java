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
//        Sistema sistema = inicializar();
        Sistema sistema = inicializarDeadlock();

        //borrar si existe archivo Log.txt
        borrarArchivoLog();
        sistema.log("Log test sistema");
        VentanaPrincipal vent = new VentanaPrincipal(sistema);
        vent.setMinimumSize(new Dimension(920, 600));
        vent.setVisible(true);
        sistema.addObserver(vent);

    }

    private static void borrarArchivoLog() {
        try {
            File f = new File("Log.txt");
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Sistema inicializar() {
        Recurso r1 = new Recurso("Rec1");
        Instruccion ir1p = new Instruccion("PRec1", 0, 0, r1);
        Instruccion ir1d = new Instruccion("DRec1", 0, 0, r1);
        Recurso r2 = new Recurso("Rec2");
        Instruccion ir2p = new Instruccion("PRec2", 0, 0, r2);
        Instruccion ir2d = new Instruccion("DRec2", 0, 0, r2);
        Recurso r3 = new Recurso("Rec3");
        Instruccion ir3p = new Instruccion("PRec3", 0, 0, r3);
        Instruccion ir3d = new Instruccion("DRec3", 0, 0, r3);

        Instruccion i1 = new Instruccion("1", 5, 7, r1);
        Instruccion i2 = new Instruccion("B", 1, 3, null);
        Instruccion i3 = new Instruccion("4", 7, 10, r1);
        Instruccion i4 = new Instruccion("3", 3, 5, r3);
        Instruccion i5 = new Instruccion("2", 4, 8, r2);

        Usuario u1 = new Usuario("Pepe");
        Usuario u2 = new Usuario("Juan");
        Usuario admin = new Usuario("admin");

        u1.agregarPermiso(r1);
        u2.agregarPermiso(r1);
        u2.agregarPermiso(r2);

        admin.agregarPermiso(r1);
        admin.agregarPermiso(r2);
        admin.agregarPermiso(r3);

        Proceso p1 = new Proceso("PRec1 1 B 4 4 1 DRec1", u1, 8);
        Proceso p2 = new Proceso("PRec1 B 4 1 DRec1 PRec2 2 DRec2", u2, 6);
        Proceso p3 = new Proceso("PRec2 PRec1 PRec3 2 1 3 3 DRec1 DRec2 DRec3", u1, 5);

        Sistema sistema = new Sistema();

        sistema.agregarUsuario(u1);
        sistema.agregarUsuario(u2);
        sistema.agregarUsuario(admin);

        sistema.agregarInstruccion(i1);
        sistema.agregarInstruccion(i2);
        sistema.agregarInstruccion(i3);
        sistema.agregarInstruccion(i4);
        sistema.agregarInstruccion(i5);
        sistema.agregarInstruccion(ir1p);
        sistema.agregarInstruccion(ir1d);
        sistema.agregarInstruccion(ir2p);
        sistema.agregarInstruccion(ir2d);
        sistema.agregarInstruccion(ir3p);
        sistema.agregarInstruccion(ir3d);

        sistema.agregarProcesosListos(p1);
        sistema.agregarProcesosListos(p2);
        sistema.agregarProcesosListos(p3);

        sistema.agregarRecurso(r1);
        sistema.agregarRecurso(r2);
        sistema.agregarRecurso(r3);

        return sistema;

    }

    public static Sistema inicializar2() {
        Recurso r1 = new Recurso("Rec1");
        Instruccion ir1p = new Instruccion("PRec1", 0, 0, r1);
        Instruccion ir1d = new Instruccion("DRec1", 0, 0, r1);

        Instruccion i1 = new Instruccion("1", 5, 8, r1);
        Instruccion i2 = new Instruccion("B", 1, 9, null);
        Instruccion i3 = new Instruccion("4", 7, 14, r1);

        Usuario u1 = new Usuario("Pepe");

        u1.agregarPermiso(r1);

        Proceso p1 = new Proceso("PRec1 1 B 4 4 1 DRec1", u1, 5);

        Sistema sistema = new Sistema();

        sistema.agregarUsuario(u1);

        sistema.agregarInstruccion(i1);
        sistema.agregarInstruccion(i2);
        sistema.agregarInstruccion(i3);
        sistema.agregarInstruccion(ir1p);
        sistema.agregarInstruccion(ir1d);

        sistema.agregarProcesosListos(p1);

        sistema.agregarRecurso(r1);

        return sistema;

    }

    public static Sistema inicializarDeadlock() {
        Recurso r1 = new Recurso("Rec1");
        Instruccion ir1p = new Instruccion("PRec1", 0, 0, r1);
        Instruccion ir1d = new Instruccion("DRec1", 0, 0, r1);

        Recurso r2 = new Recurso("Rec2");
        Instruccion ir2p = new Instruccion("PRec2", 0, 0, r2);
        Instruccion ir2d = new Instruccion("DRec2", 0, 0, r2);

        Instruccion i1 = new Instruccion("1", 5, 8, r1);
        Instruccion i2 = new Instruccion("B", 1, 9, null);
        Instruccion i3 = new Instruccion("4", 7, 14, r2);

        Usuario u1 = new Usuario("Alice");
        Usuario u2 = new Usuario("Bob");

        u1.agregarPermiso(r1);
        u1.agregarPermiso(r2);
        u2.agregarPermiso(r1);
        u2.agregarPermiso(r2);

        Proceso p1 = new Proceso("PRec1 B B B B B PRec2 B B B B", u1, 15);
        Proceso p2 = new Proceso("PRec2 B B B B B PRec1 B B B B", u2, 15);

        Sistema sistema = new Sistema();

        sistema.agregarUsuario(u1);
        sistema.agregarUsuario(u2);

        sistema.agregarInstruccion(i1);
        sistema.agregarInstruccion(i2);
        sistema.agregarInstruccion(i3);
        sistema.agregarInstruccion(ir1p);
        sistema.agregarInstruccion(ir1d);
        sistema.agregarInstruccion(ir2p);
        sistema.agregarInstruccion(ir2d);

        sistema.agregarProcesosListos(p1);
        sistema.agregarProcesosListos(p2);
        sistema.agregarRecurso(r1);
        sistema.agregarRecurso(r2);
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
