/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica01;

/**
 *
 * @author Bernix01 <gebernal@espol.edu.ec>
 */
public class Programa {

    public static void main(String[] args) {
        Coordenada c1 = null, c2 = null;
        c1 = new Coordenada();
        c2 = new Coordenada(19.4482179f, -99.1540035f,"Le Patat, México"); //Le Patat, México
        
        c1=c2;
        c1.latitud = 10;
        
        /*System.out.println("Guayaquil:");
        System.out.println(c1.latitud);
        System.out.println(c1.longitud);
        System.out.println();
        System.out.println("Le Patat, México");
        System.out.println(c2.latitud);
        System.out.println(c2.longitud);*/
        System.out.println(1+12+"hola");
        System.out.println(c1);
        System.out.println(c2);
    }
}
