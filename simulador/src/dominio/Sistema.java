package dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Sistema {

    private HashMap<Character, Instruccion> instrucciones;
    private Queue<Proceso> procesosListos;
    private Queue<Proceso> procesosBloqueados;
    private List<Recurso> recursos;

    //Constructor
    public Sistema() {
        this.instrucciones = new HashMap<Character, Instruccion>();
        this.procesosListos = new LinkedList<Proceso>();
        this.procesosBloqueados = new LinkedList<Proceso>();
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
            boolean perdioCPU = false;
            Proceso proceso = this.procesosListos.remove();
            //falta poder agregar procesos como quiere Ivan
            while ((t <= timeout) && (!proceso.termino() && !perdioCPU)) {
                Instruccion nuevaInst = conseguirSiguienteInstruccion(proceso);
                if(nuevaInst.tieneRecurso()){
                    ejecutarProcesoConRecurso(proceso, nuevaInst);
                    perdioCPU = true;
                }
                else{//Instruccion puramente de CPU
                    if (nuevaInst.getTiempoEjecucion() + t <= timeout) {
                        log("Se ejecuto la instruccion: " + nuevaInst.getNombre() + " del Proceso " + proceso.getInstrucciones() + " Demoro: " + nuevaInst.getTiempoEjecucion());
                        proceso.avanzar();
                        t += nuevaInst.getTiempoEjecucion();
                        avanzarNTicks(nuevaInst.getTiempoEjecucion());
                    } else {
                        log("Salio por TimeOut el proceso: " + proceso.getInstrucciones() + " en la instruccion Nro:" + proceso.getPosicion());
                        avanzarNTicks(timeout - t);
                        t = 0;
                        perdioCPU = true;
                        this.procesosListos.add(proceso);
                    }
                }
            }
            if (proceso.termino()) {
                log("Termino el proceso: " + proceso.getInstrucciones());
            }
        }
        while (!this.procesosBloqueados.isEmpty()){
            avanzarUnTick();
            ejecutar();
        }
        
    }
    
    private void ejecutarProcesoConRecurso(Proceso proceso, Instruccion instruccion){
        Recurso recurso = instruccion.getRecurso();
        if(proceso.getUsuario().tienePermiso(recurso)){ //Verificar si esta libre y ver que carajo hacemos si no xd
            usarRecurso(recurso, instruccion, proceso);
            this.procesosBloqueados.add(proceso);
            recurso.usar(instruccion.getTiempoEjecucion());
        }
        else{
            log("El usuario " + proceso.getUsuario().getNombre() + " no tiene permiso para correr " + instruccion.getNombre());
        }
    }
    
    private void usarRecurso(Recurso r, Instruccion i, Proceso p){
        log("Se ejecuto el recurso: " + r.getNombre() + " con la instruccion " + i.getNombre() + 
                " || Se bloquea el proceso " + p.getInstrucciones() + " por "+ i.getTiempoEjecucion() + " t");
    }

    private void log(String l) {
        System.out.println("# " + l);
    }
    
    private Instruccion conseguirSiguienteInstruccion(Proceso p){
        Character inst = p.getInstruccion();
        return this.instrucciones.get(inst);
    }
    
    private void avanzarNTicks(int tiempoAvanzado){
        for(int i = 0; i<tiempoAvanzado; i++){
            avanzarUnTick();
        }
    }
    
    private void avanzarUnTick(){
        for(Recurso r : this.recursos){
            boolean liberado = r.avanzarUnTick();
            if(liberado){
                for(Proceso p : this.procesosBloqueados){
                    if(ProcesoBloqueadoPor(p, r))
                        despertarProceso(p);
                }
            }
        }
    }
    
    public boolean ProcesoBloqueadoPor(Proceso p,Recurso r){
        Instruccion i = conseguirSiguienteInstruccion(p);
        return i.getRecurso().equals(r);
    }
    
    
    private void despertarProceso(Proceso p){
        this.procesosBloqueados.remove(p);
        p.avanzar();
        this.procesosListos.add(p);
        log("Se desperto el proceso " + p.getInstrucciones());
    }
}
