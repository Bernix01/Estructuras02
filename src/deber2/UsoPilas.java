/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber2;

import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author gbern
 */
public class UsoPilas {

    public static void main(String[] args) {
        String expresion = "";
        LinkedList<Variable> variables = new LinkedList<>();

        // Solicitar la expresiòn en in-fixpor teclado
        JOptionPane.showInputDialog("Ingrese expresión a evaluar: ", expresion);
        if (Expresion.verificaParentesis(expresion)) {
            System.out.println("La expresion es correcta");
        } else {
            System.out.println("Expresion incorrecta!!");
        }
        expresion = Expresion.InFixToPostFix(expresion);
        System.out.println("Expresion en post-fix: " + expresion);

               // Solicitar la expresiòn en post-fix por teclado
        // solicitar las variables por teclado
        System.out.println("El resultado es: " + Expresion.evaluar(expresion, variables));
    }
}

class Variable {

    public char nombre;
    public int valor;

    public Variable(char nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
}
