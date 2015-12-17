/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica05;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author gbern
 */
public class Ejercicio {
    public LinkedList<Maleta> removerMaletas(LinkedList<Maleta> aat, String vuelo){
        LinkedList<Maleta> carrito = new LinkedList<>();
        Maleta masPesada = null;
        ListIterator iter = carrito.listIterator();
        carrito = new LinkedList<>();
        while(existenMaletas(aat,vuelo)){
            for(Maleta m:aat){
                if(m.vuelo == vuelo){
                    if(masPesada==null)
                        masPesada = m;
                    else{
                        if(m.compareTo(masPesada) == 1){
                            masPesada = m;
                        }
                    }
                }
            }
            aat.remove(masPesada);
            carrito.push(masPesada);
        }
        return carrito;
    }

    private boolean existenMaletas(LinkedList<Maleta> aat, String vuelo) {
        for(Maleta m: aat){
            if(m.vuelo.equals(vuelo))
                return true;
        }
        return false;
    }
}
