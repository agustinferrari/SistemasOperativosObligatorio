
package dominio;

import java.util.Random;

/**
 *
 * @author ivanm
 */
public class Instruccion {

    private String nombre;
    private int tiempoEjecucionMax;
    private int tiempoEjecucionMin;

    private Recurso recurso;

    public Instruccion(String nombre, int tiempoEjecucionMin, int tiempoEjecucionMax, Recurso recurso) {
        this.nombre = nombre;
        this.tiempoEjecucionMax = tiempoEjecucionMax;
        this.tiempoEjecucionMin = tiempoEjecucionMin;

        this.recurso = recurso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoEjecucionMax() {
        return tiempoEjecucionMax;
    }

    public void setTiempoEjecucionMax(int tiempoEjecucionMax) {
        this.tiempoEjecucionMax = tiempoEjecucionMax;
    }

    public int getTiempoEjecucionMin() {
        return tiempoEjecucionMin;
    }

    public void setTiempoEjecucionMin(int tiempoEjecucionMin) {
        this.tiempoEjecucionMin = tiempoEjecucionMin;
    }

    public int getTiempoEjecucion() {
        Random rand = new Random();
        int min = tiempoEjecucionMin;
        int max = tiempoEjecucionMax;
        int res = rand.nextInt((max - min) + 1 ) + min;
        return res;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public boolean tieneRecurso() {
        return recurso != null;
    }

    public Recurso pideRecurso() {
        if (this.nombre.charAt(0) == 'P') {
            return this.recurso;
        }
        return null;
    }

    public Recurso devuelveRecurso() {
        if (this.nombre.charAt(0) == 'D') {
            return this.recurso;
        }
        return null;
    }

    @Override
    public String toString() {
        return nombre + ", " + "[" + this.tiempoEjecucionMin + "," + this.tiempoEjecucionMax+ "]t, " + ((recurso != null) ? (recurso.toString()) : "sin recurso asociado");
    }

    /*
    @Override
    public String toString(){
        return ("\u001B[33m" + this.nombre + "\u001B[0m");
    }
     */
}
