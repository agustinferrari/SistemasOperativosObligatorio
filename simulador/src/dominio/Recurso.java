
package dominio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Recurso {

    private String nombre;
    private Boolean estaOcupado;
    private Queue<Proceso> colaDeProcesos;
    private int tiempoOcupado;

    public Recurso(String nombre) {
        this.nombre = nombre;
        this.estaOcupado = false;
        colaDeProcesos = new LinkedList<Proceso>();
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public boolean isLibre() {
        return !this.estaOcupado;
    }
    
    public void ocupar() {
        this.estaOcupado = true;
    }
    
    void desocupar() {
        this.estaOcupado = false;
    }
    
    public boolean avanzarUnTick(){
        if(this.tiempoOcupado > 0){
            this.tiempoOcupado--;
            if(this.tiempoOcupado == 0)
                return true;
        }
        return false;
    }
    
    public void esperar(int tiempo){
        this.tiempoOcupado = tiempo;
    }

    public void agregarProcesoACola(Proceso p){
        this.colaDeProcesos.add(p);
    }
    
    public Proceso proximoProcesoEsperando(){
        return this.colaDeProcesos.poll();
    }
    

    
    @Override
    public String toString(){
        //return ("\u001B[32m" + this.getNombre() + "\u001B[0m" ); // verde
        return (this.getNombre());

    }
    
    @Override
    public boolean equals(Object o) {
        return ((Recurso) o).getNombre().equals(this.nombre);
    }

    
}


