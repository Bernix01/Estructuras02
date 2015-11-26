/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import practica01.Coordenada;

/**
 *
 * @author Bernix01 <gbernal096@gmail.com>
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
        System.out.println("");
        
        System.out.println("Ahora por archivos :v");
        System.out.println("Cargando archivo 2");
        conjunto1 = Programa.cargar("Ciudades2.txt");
        System.out.println("Cargando archivo 1");
        conjunto2 = Programa.cargar("Ciudades.txt");
        
        
        union = Conjunto.union(conjunto1, conjunto2);
        interseccion = Conjunto.interseccion(conjunto1, conjunto2);
        resta = Conjunto.diferencia(conjunto1, conjunto2);
        
        System.out.println("Union");
        Conjunto.imprimir(union);
        System.out.println("Interseccion");
        Conjunto.imprimir(interseccion);
        System.out.println("resta");
        Conjunto.imprimir(resta);
        
        Conjunto.guardar("resultados.txt",union,interseccion,resta);
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
    
    public static LinkedList<Coordenada> cargar(String archivo){
        FileReader fr;
        BufferedReader br;
        String linea;
        String datos[];
        Coordenada co;
        LinkedList<Coordenada> lista = new LinkedList<>();
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            while((linea = br.readLine()) != null){
                datos = linea.split(",");
                co = new Coordenada();
                co.latitud = Float.parseFloat(datos[0]);
                co.longitud = Float.parseFloat(datos[1]);
                co.nombre = datos[2];
                lista.add(co);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Archivo con mal formato");
        }
        catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            System.out.println("Error de lectura de archivo!!");
        }
        return lista;
    }
}
