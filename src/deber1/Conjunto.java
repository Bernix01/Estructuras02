/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import practica01.Coordenada;

/**
 *
 * @author Bernix01 <gbernal096@gmail.com>
 */
public class Conjunto {

    /**
     * union realiza la unión entre dos conjuntos
     *
     * @param conjunto1
     * @param conjunto2
     * @return un nuevo conjunto con los elementos de ambos conjuntos, sin
     * repetirse
     */
    static LinkedList<Coordenada> union(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
        if (conjunto1 == null && conjunto2 == null) {
            return null;
        }
        if (conjunto1 != null && conjunto2 == null) {
            return conjunto1;
        }
        if (conjunto1 == null && conjunto2 != null) {
            return conjunto2;
        }
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

    /**
     * intersección, realiza la intersección entre dos conjuntos
     *
     * @param conjunto1
     * @param conjunto2
     * @return un nuevo conjunto con los elementos de la intersección entre
     * ambos conjuntos
     */
    static LinkedList<Coordenada> interseccion(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
        if (conjunto1 == null || conjunto2 == null) {
            return null;
        }
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

    /**
     * diferencia resta dos conjuntos
     *
     * @param conjunto1 primer conjunto de la resta
     * @param conjunto2 segundo conjunto de la resta
     * @return un nuevo conjunto con elementos de la diferencia de los dos
     * conjuntos
     */
    static LinkedList<Coordenada> diferencia(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
        if (conjunto1 == null) {
            return null;
        }
        LinkedList<Coordenada> res = new LinkedList<>();
        if (conjunto2 == null || (conjunto1.isEmpty() && !conjunto2.isEmpty()) || (!conjunto1.isEmpty() && conjunto2.isEmpty())) //Si alguno de los dos conjuntos es vacio, la diferencia es el primer conjunto
        {
            return (LinkedList<Coordenada>) conjunto1.clone(); //retornamos un nuevo objeto, copia del conjunto1
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

    /**
     * imprimir imprime los elementos de un conjunto
     *
     * @param conjunto conjunto a imprimir
     */
    static void imprimir(LinkedList<Coordenada> conjunto) {
        if (conjunto == null) {
            return;
        }
        for (Coordenada c : conjunto) {
            System.out.println(c);
        }
    }

    /**
     * *
     * guardar guarda los conjuntos que reciba en un nuevo archivo
     *
     * @param nombreArchivo nombre del archivo
     * @param conjuntos conjuntos a guardar, puede ser uno o varios
     */
    static void guardar(String nombreArchivo, LinkedList<Coordenada>... conjuntos) {
        guardar(nombreArchivo, false, conjuntos);
    }

    /**
     * *
     * guardar guarda los conjuntos que reciba en un archivo.
     *
     * @param nombreArchivo nombre del archivo
     * @param nuevoArchivo guardar en un nuevo archivo o añadir al final (Si
     * existe)
     * @param conjuntos conjuntos a guardar, puede ser uno o varios.
     */
    static void guardar(String nombreArchivo, boolean nuevoArchivo, LinkedList<Coordenada>... conjuntos) {
        String fileName = nombreArchivo;

        try {
            // Assume default encoding.
            FileWriter fileWriter
                    = new FileWriter(fileName, nuevoArchivo);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            for (LinkedList<Coordenada> conjunto : conjuntos) {
                bufferedWriter.write("----------------------------");
                bufferedWriter.newLine();
                for (Coordenada c : conjunto) {
                    bufferedWriter.write(c.latitud + ",");
                    bufferedWriter.write(c.longitud + ",");
                    bufferedWriter.write(c.nombre);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        } finally {

        }
    }
}