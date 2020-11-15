
package dominio;

/**
 *
 * @author ivanm
 */
public class Instruccion {
    
    private String nombre;
    private int tiempoEjecucion;
    private Recurso recurso;

    public Instruccion(String nombre, int tiempoEjecucion, Recurso recurso) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.recurso = recurso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public Recurso getRecurso() {
        return recurso;
    }
    
    public boolean tieneRecurso(){
        return recurso != null;
    }
    
    public Recurso pideRecurso(){
        if(this.nombre.charAt(0)=='P'){
            return this.recurso;
        }
        return null;
    }
    
    public Recurso devuelveRecurso(){
        if(this.nombre.charAt(0)=='D'){
            return this.recurso;
        }
        return null;
    }
    
    @Override
    public String toString(){
        return nombre + ", "+ tiempoEjecucion +"t, " + ((recurso!=null)?(recurso.toString()):" sin recurso asociado");
    }
    
    /*
    @Override
    public String toString(){
        return ("\u001B[33m" + this.nombre + "\u001B[0m");
    }
    */
    
}
