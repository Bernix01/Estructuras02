/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02;

import practica01.Coordenada;

/**
 *
 * @author gbern
 */
public class Programa {
    
    public static void main (String[] args){
        Box<Coordenada> bc;
        bc = new Box<>();
        bc.set(new Coordenada());
        System.out.println(bc);
    }
    
}
