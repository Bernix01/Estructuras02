/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica06;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bernix01 <gberna096@gmail.com>
 */
public class Programa {
    public static void main(String... args){
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(8);
        s.push(10);
        s.push(15);
        s.push(20);
        
        while(!s.isEmpty()){
            try {
                System.out.println(s.pop()+"");
            } catch (Exception ex) {
                Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
