package dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Sistema {

    private HashMap<Character, Instruccion> instrucciones;
    private Queue<Proceso> procesosListos;
    private List< Recurso> recursos;

    //Constructor
    public Sistema() {
        this.instrucciones = new HashMap<Character, Instruccion>();
        this.procesosListos = new LinkedList<Proceso>();
        this.recursos = new ArrayList<Recurso>();

    }

    public void agregarInstrucciones(Instruccion miInstruccion) {
        this.instrucciones.put(miInstruccion.getNombre(), miInstruccion);
    }

    public void agregarProcesosListos(Proceso miProceso) {
        this.procesosListos.add(miProceso);
    }

    public void agregarRecurso(Recurso miRecurso) {
        this.recursos.add(miRecurso);
    }

    public void ejecutar() {
        int timeout = 10;
        while (!this.procesosListos.isEmpty()) {
            int t = 0;
            boolean excedioT = false;
            Proceso proceso = this.procesosListos.remove();
            //falta poder agregar procesos como quiere Ivan
            while ((t <= timeout) && (!proceso.termino() && !excedioT)) {
                Character inst = proceso.getInstruccion();
                Instruccion nuevaInst = this.instrucciones.get(inst);
                if (nuevaInst.getTiempoEjecucion() + t <= timeout) {
                    log("Se ejecuto la instruccion: " + nuevaInst.getNombre() + " del Proceso " + proceso.getInstrucciones() + " Demoro: " + nuevaInst.getTiempoEjecucion());
                    proceso.avanzar();
                    t += nuevaInst.getTiempoEjecucion();
                } else {
                    log("Salio por TimeOut el proceso: " + proceso.getInstrucciones() + " en la instruccion Nro:" + proceso.getPosicion());
                    t = 0;
                    excedioT = true;
                    this.procesosListos.add(proceso);
                }
            }
            if (proceso.termino()) {
                log("Termino el proceso: " + proceso.getInstrucciones());
            }
        }
    }

    private void log(String l) {
        System.out.println("# " + l);
    }
}
