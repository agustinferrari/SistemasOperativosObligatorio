package dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

public class Sistema extends Observable {

    private HashMap<String, Instruccion> instrucciones;
    private Queue<Proceso> procesosListos;
    private Queue<Proceso> procesosBloqueados;
    private List<Recurso> recursos;
    private List<Usuario> usuarios;
    private int timeout;
    private int tiempoDesdeComienzo;

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public HashMap<String, Instruccion> getInstrucciones() {
        return instrucciones;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Proceso> getProcesosListosDelUsuario(Usuario u) {
        List<Proceso> listaProcesosListos = new ArrayList<Proceso>();
        for (Proceso p : procesosListos) {
            if (p.getUsuario().equals(u)) {
                listaProcesosListos.add(p);
            }
        }
        return listaProcesosListos;
    }

    public List<Proceso> getProcesosListos() {
        return (List<Proceso>) this.procesosListos;
    }

    //Constructor
    public Sistema() {
        instrucciones = new HashMap<String, Instruccion>();
        procesosListos = new LinkedList<Proceso>();
        procesosBloqueados = new LinkedList<Proceso>();
        recursos = new ArrayList<Recurso>();
        usuarios = new ArrayList<Usuario>();
        timeout = 10;
        tiempoDesdeComienzo = 0;
    }

    public boolean agregarInstruccion(Instruccion miInstruccion) {
        if (!instrucciones.containsKey(miInstruccion.getNombre())) {
            instrucciones.put(miInstruccion.getNombre(), miInstruccion);
        } else {
            return false;
        }
        return true;
    }

    public void agregarProcesosListos(Proceso miProceso) {
        procesosListos.add(miProceso);
        actualizarVentanas();
    }

    public boolean agregarRecurso(Recurso miRecurso) {
        if (!recursos.contains(miRecurso)) {
            recursos.add(miRecurso);
            Instruccion instruccionPedir = new Instruccion("P" + miRecurso.getNombre(), 0, miRecurso);
            Instruccion instruccionDevolver = new Instruccion("D" + miRecurso.getNombre(), 0, miRecurso);
            agregarInstruccion(instruccionPedir);
            agregarInstruccion(instruccionDevolver);
        } else {
            return false;
        }
        actualizarVentanas();
        return true;
    }

    public boolean agregarUsuario(Usuario miUsuario) {
        if (!usuarios.contains(miUsuario)) {
            usuarios.add(miUsuario);
        } else {
            return false;
        }

        actualizarVentanas();
        return true;
    }

    public void borrarRecurso(Recurso miRecurso) {
        recursos.remove(miRecurso);
        actualizarVentanas();
    }

    public void borrarInstruccion(Instruccion miInstruccion) {
        instrucciones.remove(miInstruccion.getNombre());
        actualizarVentanas();
    }

    public void borrarUsuario(Usuario miUsuario) {
        usuarios.remove(miUsuario);
        for (Proceso p : procesosListos) {
            if (p.getUsuario().equals(miUsuario)) {
                procesosListos.remove(p);
            }
        }
        for (Proceso p : procesosBloqueados) {
            if (p.getUsuario().equals(miUsuario)) {
                procesosBloqueados.remove(p);
            }
        }
        actualizarVentanas();
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getTiempoDesdeComienzo() {
        return tiempoDesdeComienzo;
    }

    public void setTiempoDesdeComienzo(int tiempoDesdeComienzo) {
        this.tiempoDesdeComienzo = tiempoDesdeComienzo;
    }

    // ---------------EJECUTAR --------------
    public void ejecutar(int ticks, boolean hastaFinalizar) {
        int tiempoFinal = this.getTiempoDesdeComienzo() + ticks;
        //log(tiempoFinal + "");
        while (!this.procesosListos.isEmpty() && ((this.tiempoDesdeComienzo < tiempoFinal) || hastaFinalizar)) {
            int t = 0;
            boolean perdioCPU = false;
            Proceso proceso = this.procesosListos.remove();
            //falta poder agregar procesos como quiere Ivan
            while ((t <= this.timeout) && (!proceso.termino() && !perdioCPU)) {
                Instruccion nuevaInst = conseguirSiguienteInstruccion(proceso);
                if (!pideODevuelveRecurso(nuevaInst, proceso)) {
                    if (nuevaInst.tieneRecurso()) {
                        ejecutarProcesoConRecurso(proceso, nuevaInst);
                        perdioCPU = true;
                    } else {//Instruccion puramente de CPU
                        if (t + nuevaInst.getTiempoEjecucion() <= timeout) {
                            log("Se ejecuto la instruccion: " + nuevaInst + " del Proceso " + proceso + " Demoro: " + tiempoToString(nuevaInst.getTiempoEjecucion()));
                            proceso.avanzar();
                            t += nuevaInst.getTiempoEjecucion();
                            avanzarNTicks(nuevaInst.getTiempoEjecucion());
                        } else {
                            log("Salio por TimeOut el proceso: " + proceso + " en la instruccion Nro:" + proceso.getPosicion());
                            avanzarNTicks(timeout - t);
                            t = 0;
                            perdioCPU = true;
                            this.procesosListos.add(proceso);
                        }
                    }
                }
            }
            if (proceso.termino()) {
                log("Termino el proceso: " + proceso);
                this.actualizarVentanas();
            }
        }
        while (!this.procesosBloqueados.isEmpty()) {
            avanzarUnTick();
            ejecutar(tiempoFinal - this.getTiempoDesdeComienzo(), hastaFinalizar);
        }
    }

    private void ejecutarProcesoConRecurso(Proceso proceso, Instruccion instruccion) {
        Recurso recurso = instruccion.getRecurso();
        if (proceso.getUsuario().tienePermiso(recurso)) { //Verificar si esta libre y ver que carajo hacemos si no xd
            if (proceso.tieneRecurso(recurso)) {
                usarRecurso(recurso, instruccion, proceso);
                recurso.esperar(instruccion.getTiempoEjecucion());
                this.procesosBloqueados.add(proceso);
            } else {
                log("El proceso " + Arrays.toString(proceso.getInstrucciones()) + " no tiene permiso para usar " + recurso.getNombre());
            }
        } else {
            log("El usuario " + proceso.getUsuario() + " no tiene permiso para usar " + recurso.getNombre());
            this.actualizarVentanas();
        }
    }

    private void usarRecurso(Recurso r, Instruccion i, Proceso p) {
        log("Se ejecuto el recurso: " + r + " con la instruccion " + i
                + " || Se bloquea el proceso " + p + " por " + tiempoToString(i.getTiempoEjecucion()));
    }

    public void log(String l) {
        System.out.println("# " + l);
        File flog = new File("Log.txt");

        try {
            if (!flog.exists()) {
                flog.createNewFile();
            }
            FileWriter f = new FileWriter(flog, true);
            BufferedWriter bufferedWriter = new BufferedWriter(f);
            bufferedWriter.write("# " + l + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error en el log.");
        }
    }

    private Instruccion conseguirSiguienteInstruccion(Proceso p) {
        String inst = p.getInstruccion();
        return instrucciones.get(inst);
    }

    private void avanzarNTicks(int tiempoAvanzado) {
        for (int i = 0; i < tiempoAvanzado; i++) {
            avanzarUnTick();
        }
    }

    private void avanzarUnTick() {
        for (Recurso r : this.recursos) {
            boolean liberado = r.avanzarUnTick();
            if (liberado) {
                Iterator<Proceso> bloqueados = procesosBloqueados.iterator();
                while (bloqueados.hasNext()) {
                    Proceso p = bloqueados.next();
                    if (ProcesoBloqueadoPor(p, r)) {
                        bloqueados.remove();
                        despertarProceso(p);
                    }
                }
            }
        }
        this.setTiempoDesdeComienzo(tiempoDesdeComienzo + 1);
    }

    public boolean ProcesoBloqueadoPor(Proceso p, Recurso r) {
        Instruccion i = conseguirSiguienteInstruccion(p);
        return i.getRecurso().equals(r);
    }

    private void despertarProceso(Proceso p) {
        // https://stackoverflow.com/questions/1655362/concurrentmodificationexception-despite-using-synchronized
        //procesosBloqueados.remove(p);
        p.avanzar();
        procesosListos.add(p);
        log("Se desperto el proceso " + p);
    }

    public String tiempoToString(int t) {
        return ("\u001B[31m" + t + "t" + "\u001B[0m");
    }

    public void actualizarVentanas() {
        setChanged();
        notifyObservers();
    }

    private boolean pideODevuelveRecurso(Instruccion i, Proceso p) {
        Recurso recursoPedido = i.pideRecurso();
        Recurso recursoDevuelto = i.devuelveRecurso();
        if (recursoPedido != null) {
            log("El proceso " + Arrays.toString(p.getInstrucciones()) + " pide el recurso " + recursoPedido.getNombre());
            if(recursoPedido.isLibre()){
                recursoPedido.ocupar();
                p.agregarRecurso(recursoPedido);
                log("El recurso " + recursoPedido.getNombre() + " es asignado al proceso " + Arrays.toString(p.getInstrucciones()));
            }
            else{
                log("El recurso " + recursoPedido.getNombre() + " estaba bloqueado, se bloque el proceso " + Arrays.toString(p.getInstrucciones()));
                this.procesosBloqueados.add(p);
                recursoPedido.agregarProcesoACola(p);
            }
            p.avanzar();
            return true;
        }
        else if (recursoDevuelto != null){
            log("El proceso " + Arrays.toString(p.getInstrucciones()) + " devuelve el recurso " + recursoDevuelto.getNombre());
            p.borrarRecurso(recursoDevuelto);
            p.avanzar();
            Proceso proximo = recursoDevuelto.proximoProcesoEsperando();
            if(proximo != null){
                log("El recurso " + recursoPedido.getNombre() + " es asignado al proceso " + Arrays.toString(proximo.getInstrucciones()));
                proximo.agregarRecurso(recursoDevuelto);
            }
            else{
                log("El recurso se libera");
                recursoDevuelto.desocupar();
            }
            return true;
        }
        return false;
    }

}
