package dominio;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    
    private String nombre;
    private List<Recurso> recursosPermitidos;
    
     public Usuario(String nombre) {
        this.nombre = nombre;
        this.recursosPermitidos = new ArrayList<Recurso>();
    }
    
    public Usuario(String nombre, List<Recurso> recursosPermitidos) {
        this.nombre = nombre;
        this.recursosPermitidos = recursosPermitidos;
    }
    
    public boolean tienePermiso(Recurso r){
        return this.recursosPermitidos.contains(r);
    }
    
    public void agregarPermiso(Recurso r){
        this.recursosPermitidos.add(r);
    }
    
    public String getNombre() {
        return nombre;
    }

    public List<Recurso> getRecursosPermitidos() {
        return recursosPermitidos;
    }
    
    @Override
    public String toString(){
        return (this.getNombre()); 

    }
    
    @Override
    public boolean equals(Object o) {
        return ((Usuario) o).getNombre().equals(this.nombre);
    }
}