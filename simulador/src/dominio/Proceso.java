package dominio;

public class Proceso {

    private String instrucciones;
    private int posicion;
    private Usuario usuario;


    public Proceso(String instrucciones, Usuario usuario) {
        this.instrucciones = instrucciones;
        this.posicion = 0;
        this.usuario = usuario;
    }

    public boolean termino() {
        return (this.posicion == this.instrucciones.length());
    }

    public Character getInstruccion() {
        if (!termino()) {
            Character r = this.instrucciones.charAt(posicion);
            return r;
        }
        return null;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public int getPosicion() {
        return posicion;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void avanzar (){
        this.posicion++;
    }
    
    @Override
    public String toString(){
        return ( "\u001B[35m" + this.getInstrucciones()+  "\u001B[0m" ); //violeta
    }
    
    

}
