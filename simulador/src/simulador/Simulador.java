/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author ivanm
 */
public class Simulador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String p1 = "ABCCA";
        String p2 = "ABCDAB";
        String p3 = "ABC";
        
        Queue<String> listo = new PriorityQueue<String> ();
        /*listo.add // push
           listo.remove // pop
        listo.isEmpty
        
        */
        
        listo.add(p1);
        listo.add(p2);
        listo.add(p3);
        
        ejecutar(listo);
        

    }

private static void ejecutar(Queue<String> listo){
    int timeout = 10;
    while(!listo.isEmpty()){
        int t = 0;
        String proceso = listo.remove();
        while((t <= timeout) && (proceso.length() > 0)){
            
        }
            
        
    }

}
    
    
private static void log(String l){
    System.out.println(l);
}
    
}
