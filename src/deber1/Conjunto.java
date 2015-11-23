/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber1;

import java.util.LinkedList;
import practica01.Coordenada;

/**
 *
 * @author gbern
 */
public class Conjunto {

    static LinkedList<Coordenada> union(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {

        if (conjunto1.isEmpty() && conjunto2.isEmpty()) {
            return new LinkedList<Coordenada>(); //vacío U vacío = vacío
        }
        if (conjunto1.isEmpty() && !conjunto2.isEmpty()) {
            return conjunto2; // vacío U conjunto2 = conjunto2
        }
        if (!conjunto1.isEmpty() && conjunto2.isEmpty()) {
            return conjunto1; // conjunto1 U vacío = conjunto1
        }
        LinkedList<Coordenada> resultado = new LinkedList<>();

        //si no hay intersección entre los conjuntos, la unión son todos los elementos de ambos conjuntos.
        LinkedList<Coordenada> inter = interseccion(conjunto1, conjunto2);
        if (inter.isEmpty()) {
            for (Coordenada c : conjunto1) {
                resultado.add(c);
            }
            for (Coordenada c : conjunto2) {
                resultado.add(c);
            }
            return resultado;
        }

        //si existe la intersección entre ambos conjuntos, la unión será INTERSECCION U diferencia(conjunto1,conjunto2) U diferencia(conjunto2,conjunto1)
        resultado = union(inter, diferencia(conjunto1, conjunto2)); //INTERSECCION U diferencia(conjunto1,conjunto2)
        return union(resultado, diferencia(conjunto2, conjunto1)); // (INTERSECCION U diferencia(conjunto1,conjunto2)) U diferencia(conjunto2,conjunto1)
    }

    static LinkedList<Coordenada> interseccion(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
        LinkedList<Coordenada> resultado = new LinkedList<>();
        if (conjunto1.isEmpty() && conjunto2.isEmpty()) {
            return resultado; //vacío intereseccion vacío = vacío
        }
        if (conjunto1.isEmpty() && !conjunto2.isEmpty()) {
            return resultado; // vacío interseccion conjunto2 = vacio
        }
        if (!conjunto1.isEmpty() && conjunto2.isEmpty()) {
            return resultado; // conjunto1 interseccion vacío = vacio
        }
        for (Coordenada c : conjunto1) {
            for (Coordenada a : conjunto2) {
                if (c.equals(a)) {
                    resultado.add(a); //agregar el elemento al resultado
                    break; //intersección encontrada
                }
            }
        }
        return resultado;
    }

    static LinkedList<Coordenada> diferencia(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
        LinkedList<Coordenada> res = new LinkedList<>();
        if ((conjunto1.isEmpty() && !conjunto2.isEmpty()) || (!conjunto1.isEmpty() && conjunto2.isEmpty())) //Si alguno de los dos conjuntos es vacio, la diferencia es el primer conjunto
        {
            return conjunto1;
        }
        boolean encontrado = false;
        //le agregamos la etiqueta c1 al foreach del conjunto1, esto servirá para poder saltarnos iteraciones si encontramos algún elemento del conjunto1 en el conjunto2
        c1:
        for (Coordenada c : conjunto1) {
            for (Coordenada a : conjunto2) {
                if (c.equals(a)) {
                    //intersección encontrada, salta c1!
                    continue c1;
                }
            }
            res.add(c); //agregar el elemento al resultado
        }
        return res;
    }

    static void imprimir(LinkedList<Coordenada> conjunto) {
        for (Coordenada c : conjunto) {
            System.out.println(c);
        }
    }

}
