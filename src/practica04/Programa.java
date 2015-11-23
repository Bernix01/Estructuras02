/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gbern
 */
public class Programa {
    public static void main(String... args){
        Palabra palabra;
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserte la palabra: \n");
        try {
            String pal = bfr.readLine();
            System.out.println("Palabra: "+pal);
            palabra = new Palabra(pal);
            if(palabra.tieneDiptongo())
                System.out.println("Tiene diptongo!");
        } catch (IOException ex) {
            System.out.println("Error!");
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
