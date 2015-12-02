/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber2;

import java.util.LinkedList;
import javax.print.attribute.AttributeSet;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author gbern
 */
public class UsoPilas {

    public static void main(String[] args) {
        String expresion = "";
        LinkedList<Variable> variables = new LinkedList<>();

        // Solicitar la expresiòn en in-fixpor teclado
        expresion = JOptionPane.showInputDialog(null, "Ingrese expresión a verificar: ");
        if (Expresion.verificaParentesis(expresion)) {
            System.out.println("La expresion es correcta");
        } else {
            System.out.println("Expresion incorrecta!!");
        }
        expresion = Expresion.InFixToPostFix(expresion);
        System.out.println("Expresion en post-fix: " + expresion);

        // Solicitar la expresiòn en post-fix por teclado
        expresion = "";
        expresion = JOptionPane.showInputDialog(null, "Ingrese expresión en Post-Fix a evaluar: ");
        // solicitar las variables por teclado
        if (expresion == null || expresion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Expresión vacía, cerrando...");
            return;
        }

        variables = Expresion.obtenerVariables(expresion);
        for (Variable var : variables) {
            //http://stackoverflow.com/questions/23398718/converting-joptionpane-input-to-integer
            String errorMessage = "";
            do {
                // Show input dialog with current error message, if any
                String stringInput = JOptionPane.showInputDialog(errorMessage + "Ingresa el valor de "+var.nombre+".");
                try {
                    var.valor = Integer.parseInt(stringInput);
                   errorMessage ="";
                } catch (NumberFormatException e) {
                    // The typed text was not an integer
                    errorMessage = "The text you typed is not a number.\n";
                }
            } while (!errorMessage.isEmpty());
        }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.nombre;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Variable other = (Variable) obj;
        if (this.nombre != other.nombre) {
            return false;
        }
        return true;
    }

}