/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utlilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class GeneradorColor {
    private static String[] mColors = {
            "#006400", 
            "#00008b",  
            "#ff0000", 
            "#ffff00", 
            "#deb887", 
            "#00ff00", 
            "#00ffff", 
            "#ff00ff",  
            "#6495ed"
    };
    
    public static ArrayList<String> colores;
    
    
    public static java.awt.Color  getColorRandom() {
        if(colores == null){
            colores = new ArrayList<String>();
            Collections.addAll(colores, mColors);
        }
        if(colores.isEmpty())
            Collections.addAll(colores, mColors);
        Random randomGenerator = new Random(); 
        int randomNumber = randomGenerator.nextInt(colores.size());

        String colorActual = colores.get(randomNumber);
        java.awt.Color aux = java.awt.Color.decode(colorActual);
        colores.remove(randomNumber);
        java.awt.Color colorMenorAlpha = new java.awt.Color(aux.getRed(), aux.getBlue(), aux.getGreen(), 90);
        return colorMenorAlpha;
    }
}
