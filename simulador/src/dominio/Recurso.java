
package dominio;


public class Recurso {

    private String nombre;
    private int tiempoOcupado;

    public Recurso(String nombre) {
        this.nombre = nombre;
        this.tiempoOcupado = 0;
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public boolean isLibre() {
        return this.tiempoOcupado == 0;
    }
    
    public boolean avanzarUnTick(){
        if(this.tiempoOcupado > 0){
            this.tiempoOcupado--;
            if(this.tiempoOcupado == 0)
                return true;
        }
        return false;
    }
    
    public void usar(int tiempo){
        this.tiempoOcupado = tiempo;
    }
    
    @Override
    public String toString(){
        return ("\u001B[32m" + this.getNombre() + "\u001B[0m" ); // verde
    }
}


