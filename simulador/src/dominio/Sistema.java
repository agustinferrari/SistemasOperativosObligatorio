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
    private Queue<Proceso> procesosSuspendidos;
    private List<Recurso> recursos;
    private List<Usuario> usuarios;
    private Proceso[] memoria;
    private Usuario admin;
    private int timeout;
    private boolean perdioCPU;
    private int numeroLinea;

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

    public List<Proceso> getProcesosBloqueados() {
        return (List<Proceso>) this.procesosBloqueados;
    }

    public List<Proceso> getProcesosSuspendidos() {
        return (List<Proceso>) this.procesosSuspendidos;
    }

    //Constructor
    public Sistema() {
        this.instrucciones = new HashMap<String, Instruccion>();
        this.procesosListos = new LinkedList<Proceso>();
        this.procesosBloqueados = new LinkedList<Proceso>();
        this.procesosSuspendidos = new LinkedList<Proceso>();
        this.recursos = new ArrayList<Recurso>();
        this.usuarios = new ArrayList<Usuario>();
        this.memoria = new Proceso[32];
        this.timeout = 10;
        Usuario admin = new Usuario("admin");
        this.admin = admin;
        this.agregarUsuario(admin);
        this.numeroLinea = 0;
    }

    private boolean guardarEnMemoria(Proceso p) {
        int espacioNecesario = p.getEspacioEnMemoria();

        for (int i = 0; i < this.memoria.length; i++) {
            if (this.memoria[i] == null) {
                int inicioHueco = i;
                int finalHueco = i;
                while (++i < this.memoria.length && this.memoria[i] == null) {
                    finalHueco++;
                }
                if (finalHueco - inicioHueco >= espacioNecesario) {
                    for (int j = 0; j < espacioNecesario; j++) {
                        this.memoria[inicioHueco++] = p;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Proceso[] getMemoria() {
        return this.memoria;
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
        if (guardarEnMemoria(miProceso)) {
            procesosListos.add(miProceso);
        } else {
            procesosSuspendidos.add(miProceso);
            log("El proceso " + Arrays.toString(miProceso.getInstrucciones()) + " se suspende, no hay lugar suficiente para alojarlo en memoria");
        }
        actualizarVentanas();
    }

    public boolean agregarRecurso(Recurso miRecurso) {
        if (!recursos.contains(miRecurso)) {
            recursos.add(miRecurso);
            Instruccion instruccionPedir = new Instruccion("P" + miRecurso.getNombre(), 0, 0, miRecurso);
            Instruccion instruccionDevolver = new Instruccion("D" + miRecurso.getNombre(), 0, 0, miRecurso);
            agregarInstruccion(instruccionPedir);
            agregarInstruccion(instruccionDevolver);
            this.admin.agregarPermiso(miRecurso);
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
        if (miUsuario.equals(this.admin)) {
            return;
        }

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

    // ---------------EJECUTAR --------------
    public void ejecutar(int cantidadCiclos) {
        while (!this.procesosListos.isEmpty() && (cantidadCiclos > 0 || cantidadCiclos == -1)) {
            int t = 0;
            perdioCPU = false;
            Proceso proceso = this.procesosListos.remove();
            this.log("-------------- El Proceso " + proceso + " entro a ejecución -------------- ");
            while (((t <= this.timeout) && (!proceso.termino() && !perdioCPU))) {
                Instruccion nuevaInst = conseguirSiguienteInstruccion(proceso);
                if (!pideODevuelveRecurso(nuevaInst, proceso)) {
                    if (nuevaInst.tieneRecurso()) {
                        ejecutarProcesoConRecurso(proceso, nuevaInst);
                        perdioCPU = true;
                    } else {//Instruccion puramente de CPU
                        if (t + nuevaInst.getTiempoEjecucionMax() <= timeout) {
                            log("Se ejecuto la instruccion: " + nuevaInst + " del Proceso " + proceso + " Demoro: " + tiempoToString(nuevaInst.getTiempoEjecucion()));
                            proceso.avanzar();
                            int tInstruccion = nuevaInst.getTiempoEjecucion();
                            t += tInstruccion;
                            avanzarNTicks(tInstruccion);
                        } else {
                            log("Salio por TimeOut el proceso: " + proceso + " en la instruccion Nro:" + proceso.getPosicion());
                            avanzarNTicks(timeout - t);
                            t = 0;
                            perdioCPU = true;
                            this.procesosListos.add(proceso);
                            this.actualizarVentanas();
                        }
                    }
                }
            }
            if (proceso.termino()) {
                log("Termino el proceso: " + proceso);
                devolverMemoria(proceso);
                devolverTodosLosRecursos(proceso);
                this.actualizarVentanas();
            }
            if (cantidadCiclos > 0) {
                cantidadCiclos--;
            }
        }

        try {
            while (!this.procesosBloqueados.isEmpty() && this.procesosListos.isEmpty() && (cantidadCiclos > 0 || cantidadCiclos == -1)) {
                avanzarUnTick();
                ejecutar(cantidadCiclos);
            }
        } catch (StackOverflowError e) {
            this.log("Deadlock");
            for (Proceso proceso : this.procesosBloqueados) {
                devolverTodosLosRecursos(proceso);
                devolverMemoria(proceso);
            }
            this.procesosBloqueados.removeAll(this.procesosBloqueados);
            this.actualizarVentanas();
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
                devolverMemoria(proceso);
                devolverTodosLosRecursos(proceso);
            }
        } else {
            log("El usuario " + proceso.getUsuario() + " no tiene permiso para usar " + recurso.getNombre() + ", se termina el proceso " + Arrays.toString(proceso.getInstrucciones()));
            devolverMemoria(proceso);
            devolverTodosLosRecursos(proceso);
        }
        this.actualizarVentanas();
    }

    private void usarRecurso(Recurso r, Instruccion i, Proceso p) {
        log("Se utiliza el recurso " + r + " con la instruccion " + i
                + " || Se bloquea el proceso " + p + " por " + tiempoToString(i.getTiempoEjecucion()));
    }

    public void log(String l) {
        System.out.println("# [" + this.numeroLinea + "] " + l);
        this.numeroLinea++;
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
        this.actualizarVentanas();
    }

    public boolean ProcesoBloqueadoPor(Proceso p, Recurso r) {
        Instruccion i = conseguirSiguienteInstruccion(p);
        if (i.pideRecurso() == null && i.devuelveRecurso() == null) {
            return (i.getRecurso() == null) ? false : i.getRecurso().equals(r) && p.tieneRecurso(r);
        }
        return false;
    }

    private void despertarProceso(Proceso p) {
        // https://stackoverflow.com/questions/1655362/concurrentmodificationexception-despite-using-synchronized
        //procesosBloqueados.remove(p);
        p.avanzar();
        procesosListos.add(p);
        log("Se desperto el proceso " + p);
        this.actualizarVentanas();
    }

    public String tiempoToString(int t) {
        return (t + "t");
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
            if (recursoPedido.isLibre()) {
                recursoPedido.ocupar();
                p.agregarRecurso(recursoPedido);
                log("El recurso " + recursoPedido.getNombre() + " es asignado al proceso " + Arrays.toString(p.getInstrucciones()));
            } else {
                log("El recurso " + recursoPedido.getNombre() + " esta ocupado, se bloquea el proceso " + Arrays.toString(p.getInstrucciones()));
                this.procesosBloqueados.add(p);
                recursoPedido.agregarProcesoACola(p);
                this.perdioCPU = true;
            }
            p.avanzar();
            return true;
        } else if (recursoDevuelto != null) {
            log("El proceso " + Arrays.toString(p.getInstrucciones()) + " devuelve el recurso " + recursoDevuelto.getNombre());
            p.borrarRecurso(recursoDevuelto);
            p.avanzar();
            Proceso proximo = recursoDevuelto.proximoProcesoEsperando();
            if (proximo != null) {
                log("El recurso " + recursoDevuelto.getNombre() + " es asignado al proceso " + Arrays.toString(proximo.getInstrucciones()));
                proximo.agregarRecurso(recursoDevuelto);
                this.procesosBloqueados.remove(proximo);
                this.procesosListos.add(proximo);
                log("Se despierta el proceso " + proximo);
            } else {
                log("El recurso se libera");
                recursoDevuelto.desocupar();
            }
            return true;
        }
        return false;
    }

    private void devolverTodosLosRecursos(Proceso p) {
        ArrayList<Recurso> recursosADevolver = p.getRecursosActuales();
        for (Recurso recursoDevuelto : recursosADevolver) {
            log("El proceso " + Arrays.toString(p.getInstrucciones()) + " devuelve el recurso " + recursoDevuelto.getNombre());
            Proceso proximo = recursoDevuelto.proximoProcesoEsperando();
            if (proximo != null && this.procesosBloqueados.contains(proximo)) {
                log("El recurso " + recursoDevuelto.getNombre() + " es asignado al proceso " + Arrays.toString(proximo.getInstrucciones()));
                proximo.agregarRecurso(recursoDevuelto);
                this.procesosBloqueados.remove(proximo);
                this.procesosListos.add(proximo);
                log("Se despierta el proceso " + proximo);

            } else {
                log("El recurso se libera");
                recursoDevuelto.desocupar();
            }
        }
        this.actualizarVentanas();
    }

    @SuppressWarnings("empty-statement")
    private void devolverMemoria(Proceso p) {
        int espacioNecesario = p.getEspacioEnMemoria();
        int i = -1;
        while (this.memoria[++i] == null || !this.memoria[i].equals(p));
        while (espacioNecesario-- != 0) {
            this.memoria[i++] = null;
        }
        log("Se libera " + p.getEspacioEnMemoria() + " KB de memoria");
        for (Proceso pSuspendido : this.procesosSuspendidos) {
            if (guardarEnMemoria(pSuspendido)) {
                this.procesosSuspendidos.remove(pSuspendido);
                this.procesosListos.add(pSuspendido);
                log("El proceso " + Arrays.toString(pSuspendido.getInstrucciones()) + " se resume, alojando " + pSuspendido.getEspacioEnMemoria() + " KB en memoria");
            }
        }
        this.actualizarVentanas();

    }

}
