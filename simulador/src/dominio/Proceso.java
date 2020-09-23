package dominio;

public class Proceso {

    private String instrucciones;
    private int posicion;

    public Proceso(String instrucciones) {
        this.instrucciones = instrucciones;
        this.posicion = 0;
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
    
    public void avanzar (){
        this.posicion++;
    }
    
    

}
