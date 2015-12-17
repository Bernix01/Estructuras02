/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica07;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gbern
 */
public class UsoMap {

    public static void main(String... args) {
        Map<Integer, String> map;
        map = new HashMap<>();
        map.put(1, "Casillas");
        map.put(15, "Ramos");
        map.put(3, "Pique");
        map.put(5, "Puyol");
        map.put(11, "Capdevila");
        map.put(14, "Xabi Alonso");
        map.put(16, "Busquets");
        map.put(8, "Xavi Hernandez");
        map.put(18, "Pedrito");
        map.put(6, "Iniesta");
        map.put(7, "Villa");
        
        for(Map.Entry e: map.entrySet()){
            System.out.println(" " + e.getKey() +"\t"+ e.getValue() );
        }
        
    }
}
