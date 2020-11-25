/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utlilidades;

import dominio.Instruccion;
import dominio.Proceso;
import dominio.Recurso;
import dominio.Sistema;
import dominio.Usuario;


public class Prueba {
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

        Instruccion i1 = new Instruccion("A", 5, 7, r1);
        Instruccion i2 = new Instruccion("B", 1, 3, null);
        Instruccion i3 = new Instruccion("C", 7, 10, r1);
        Instruccion i4 = new Instruccion("D", 3, 5, r3);
        Instruccion i5 = new Instruccion("E", 4, 8, r2);

        Usuario u1 = new Usuario("Pepe");
        Usuario u2 = new Usuario("Juan");
        Usuario admin = new Usuario("admin");

        u1.agregarPermiso(r1);
        u2.agregarPermiso(r1);
        u2.agregarPermiso(r2);

        admin.agregarPermiso(r1);
        admin.agregarPermiso(r2);
        admin.agregarPermiso(r3);

        Proceso p1 = new Proceso("PRec1 A B D D A DRec1", u1, 8);
        Proceso p2 = new Proceso("PRec1 B D A DRec1 PRec2 2 DRec2", u2, 6);
        Proceso p3 = new Proceso("PRec2 PRec1 PRec3 C A E E DRec1 DRec2 DRec3", u1, 5);

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

        Instruccion i1 = new Instruccion("A", 5, 8, r1);
        Instruccion i2 = new Instruccion("B", 1, 9, null);
        Instruccion i3 = new Instruccion("C", 7, 14, r1);

        Usuario u1 = new Usuario("Pepe");

        u1.agregarPermiso(r1);

        Proceso p1 = new Proceso("PRec1 A B C C A DRec1", u1, 5);

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

        Instruccion i1 = new Instruccion("A", 5, 8, r1);
        Instruccion i2 = new Instruccion("B", 1, 9, null);
        Instruccion i3 = new Instruccion("C", 7, 14, r2);

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
    
    public static Sistema inicializarVacio() {
        return new Sistema();
    }
}
