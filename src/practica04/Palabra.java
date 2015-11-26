/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica04;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author gbern
 */
public class Palabra {

    private final LinkedList<Character> palabra;

    public Palabra(String palabra) {
        this.palabra = new LinkedList();
        for (char c : palabra.toCharArray()) {
            this.palabra.add(c);
        }
    }

    public boolean tieneDiptongo() {
        Iterator<Character> iterator = palabra.iterator();
        Character p = new Character(' ');
        while (iterator.hasNext()) {
            Character b = iterator.next();
            if (esDiptongo(p, b)) {
                return true;
            }
            p = b;
        }
        return false;
    }

    public boolean esDiptongo(Character l1, Character l2) {

        return (esVocalAbierta(l1) && esVocalCerrada(l2)) || (esVocalCerrada(l1) && esVocalAbierta(l2)) || (esVocalCerrada(l1) && esVocalCerrada(l2));
    }

    public boolean esVocalAbierta(Character c) {

        return c == 'a' || c == 'e' || c == '0' || c == 'A' || c == 'E' || c == 'O';
    }

    public boolean esVocalCerrada(Character c) {

        return c == 'i' || c == 'u' || c == 'I' || c == 'U';
    }

    public boolean esPalindroma() {
        int c = this.palabra.size();
        ListIterator<Character> iteradorA = this.palabra.listIterator();
        ListIterator<Character> iteradorB = this.palabra.listIterator(c);
        int h = (int) c / 2;
        int i = 0;
            while (iteradorA.hasNext() && iteradorB.hasPrevious() && i < h) {
            Character a = iteradorA.next();
            Character b = iteradorB.previous();
            
            if(a!=b)
                return false;
            i++;     
        }
            System.out.println(i+"");
        return true;
    }

    public LinkedList<Character> getPalabra() {
        return palabra;
    }

    public static boolean esPalindrom(LinkedList<Character> c){
        Iterator<Character> i1;
        Iterator<Character> i2;
        Character c1;
        Character c2;
        
        i1=c.iterator();
        i2=c.descendingIterator();
        
        while(i1.hasNext()){
            c1=i1.next();
            c2=i2.next();
            if (c1!=c2)
                return false;
        }
        return true;
        }
                
        
    

}
