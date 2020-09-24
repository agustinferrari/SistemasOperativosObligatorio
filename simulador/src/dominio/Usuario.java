/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
}
