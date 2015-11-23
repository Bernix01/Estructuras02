/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber1;

import java.io.File;
import java.util.LinkedList;
import practica01.Coordenada;

/**
 *
 * @author gbern
 */
public class Programa {

    public static void main(String[] args) {
        LinkedList<Coordenada> conjunto1 = new LinkedList<>();
        LinkedList<Coordenada> conjunto2 = new LinkedList<>();
        LinkedList<Coordenada> union, interseccion, resta;

        Programa.cargarC1(conjunto1);
        Programa.cargarC2(conjunto2);

        union = Conjunto.union(conjunto1, conjunto2);
        interseccion = Conjunto.interseccion(conjunto1, conjunto2);
        resta = Conjunto.diferencia(conjunto1, conjunto2);
        System.out.println("Union");
        Conjunto.imprimir(union);
        System.out.println("Interseccion");
        Conjunto.imprimir(interseccion);
        System.out.println("resta");
        Conjunto.imprimir(resta);
    }

    private static void cargarC1(LinkedList<Coordenada> conjunto) {
        conjunto.add(new Coordenada(10, 10, "Ciudad 1"));
        conjunto.add(new Coordenada(20, 20, "Ciudad 2"));
        conjunto.add(new Coordenada(30, 30, "Ciudad 3"));
        conjunto.add(new Coordenada(40, 40, "Ciudad 4"));
    }

    private static void cargarC2(LinkedList<Coordenada> conjunto) {
        conjunto.add(new Coordenada(50, 50, "Ciudad 5"));
        conjunto.add(new Coordenada(20, 20, "Ciudad 2"));
        conjunto.add(new Coordenada(60, 60, "Ciudad 6"));
        conjunto.add(new Coordenada(40, 40, "Ciudad 4"));
    }
    
    private static void cargar(File file){
        
    }
}
