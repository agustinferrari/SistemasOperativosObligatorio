package dominio;

import java.util.ArrayList;
import java.util.Arrays;

public class Proceso {

    private String[] instrucciones;
    private int posicion;
    private Usuario usuario;
    private ArrayList<Recurso> recursosActuales;
    private int espacioEnMemoria;

    public Proceso(String instrucciones, Usuario usuario, int espacioNecesario) {
        this.instrucciones = instrucciones.split(" ");
        this.posicion = 0;
        this.usuario = usuario;
        this.espacioEnMemoria = espacioNecesario;
        this.recursosActuales = new ArrayList<Recurso>();
    }

    public boolean termino() {
        return (this.posicion == this.instrucciones.length);
    }

    public int getEspacioEnMemoria() {
        return this.espacioEnMemoria;
    }

    public String getInstruccion() {
        if (!termino()) {
            String r = this.instrucciones[posicion];
            return r;
        }
        return null;
    }

    public String[] getInstrucciones() {
        return instrucciones;
    }

    public int getPosicion() {
        return posicion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void avanzar() {
        this.posicion++;
    }

    public void borrarRecurso(Recurso miRecurso) {
        recursosActuales.remove(miRecurso);
    }

    public void agregarRecurso(Recurso miRecurso) {
        recursosActuales.add(miRecurso);
    }

    public boolean tieneRecurso(Recurso miRecurso) {
        return this.recursosActuales.contains(miRecurso);
    }

    public ArrayList<Recurso> getRecursosActuales() {
        return this.recursosActuales;
    }

    @Override
    public String toString() {
        //return ( "\u001B[35m" + this.getInstrucciones()+  "\u001B[0m" ); //violeta
        return Arrays.toString(this.getInstrucciones());
    }

}
