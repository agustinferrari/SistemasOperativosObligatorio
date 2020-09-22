
package dominio;

/**
 *
 * @author ivanm
 */
public class Intruccion {
    
    private char nombre;
    private int tiempoEjecucion;
    private Recurso recurso;

    public Intruccion(char nombre, int tiempoEjecucion, Recurso recurso) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.recurso = recurso;
    }

    public char getNombre() {
        return nombre;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }


    public Recurso getRecurso() {
        return recurso;
    }

    
}
