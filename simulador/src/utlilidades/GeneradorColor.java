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
            "#e6194B", 
            "#3cb44b", 
            "#ffe119", 
            "#4363d8", 
            "#f58231", 
            "#911eb4", 
            "#42d4f4", 
            "#bfef45", 
            "#fabed4",  
            "#9A6324", 
            "#fffac8", 
            "#800000", 
            "#aaffc3", 
            "#808000", 
            "#000075", 
            "#a9a9a9"
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
