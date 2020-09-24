package simulador;

import dominio.Instruccion;
import dominio.Proceso;
import dominio.Recurso;
import dominio.Sistema;
import dominio.Usuario;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Simulador {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Sistema sistema = inicializar();
        sistema.ejecutar();
   
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
        
        u1.agregarPermiso(r1);

        Proceso p1 = new Proceso("1B441", u1);
        Proceso p2 = new Proceso("B412", u2);
        Proceso p3 = new Proceso("2133", u1);
        
        Sistema sistema = new Sistema();
        
        sistema.agregarInstrucciones(i1);
        sistema.agregarInstrucciones(i2);
        sistema.agregarInstrucciones(i3);
        sistema.agregarInstrucciones(i4);
        sistema.agregarInstrucciones(i5);

        sistema.agregarProcesosListos(p1);
        sistema.agregarProcesosListos(p2);
        sistema.agregarProcesosListos(p3);
     
        sistema.agregarRecurso(r1);
        sistema.agregarRecurso(r2);
        sistema.agregarRecurso(r3);

        return sistema;
    
    }
}
