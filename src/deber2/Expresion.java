/*
 * To change this license header, choose License Headers in Project Prtmpties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber2;

import static java.lang.Math.pow;
import java.util.LinkedList;

/**
 *
 * @author gbern
 */
class Expresion {

    /**
     * convierte ede InFix a PostFix
     * @param expresion expresión a convertir
     * @return String de la expresión en PostFix
     */
    static String InFixToPostFix(String expresion) {
        if (expresion == null || expresion.isEmpty()) {
            return null;
        }
        String postFix = "";
        LinkedList<Character> charList = toList(expresion);
        LinkedList<Character> pila = new LinkedList<>();
        for (Character c : charList) {
            if (c == '(') {
                pila.push('(');
            } else if (c == ')') {
                Character tmp = pila.peek();
                while (tmp !='(' && !pila.isEmpty()) {
                    postFix += tmp;
                    pila.pop();
                    tmp = pila.peek();
                }
                pila.pop();
            } else if (c == '+' || c == '-') {
                //Si la pila está vacía, recuerda la operación.
                if (pila.isEmpty()) {
                    pila.push(c);
                } else {
                    Character tmp = pila.peek();
                    while (!(pila.isEmpty() || tmp =='(' || tmp == ')')) {
                        pila.pop();
                        postFix += tmp;
                    }
                    pila.push(c);
                }
            } else if (c == '*' || c == '/') {
                if (pila.isEmpty()) {
                    pila.push(c);
                } else {
                    Character tmp = pila.peek();
                    while (!pila.isEmpty() && tmp != '+' && tmp != '-' ) {
                        pila.pop();
                        postFix += tmp;
                    }
                    pila.push(c);
                }
            } else {
                postFix += c;
            }
        }
        //Agrego los operadores restantes a la expresión
        while (!pila.isEmpty()) {
            Character tmp = pila.peek();
            if (tmp != '(') {
                pila.pop();
                postFix += tmp.charValue();
            }
        }
        return postFix;
    }

    /**
     * verifica los paréntesis de una expresión
     * @param expresion expresión a verificar
     * @return true si la expresión tiene los paréntesis correctos.
     */
    static boolean verificaParentesis(String expresion) {
        if (expresion == null || expresion.isEmpty()) {
            return false;
        }
        LinkedList<Character> cpar = new LinkedList<>();
        for (int i = 0 ; i<expresion.length();i++) {
            char c = expresion.charAt(i);
            if (c == '(') {
                cpar.push(c);
            } else if (c == ')') {
                if (cpar.isEmpty()) {
                    return false;
                } else {
                    cpar.pop();
                }
            }
        }
        return cpar.isEmpty();
    }

    /**
     * método auxiliar para transformar la expresión en una lista
     * @param expresion expresión a transformar
     * @return lista de caracteress 
    */
    static LinkedList<Character> toList(String expresion) {
        LinkedList<Character> charList = new LinkedList<>();
        for (int i = 0; i < expresion.length(); i++) {
            char x = expresion.charAt(i);
            charList.add(x);
        }
        return charList;
    }

    /**
     * evalúa una expresión en PostFix
     * @param expresion expresión a evaluar
     * @param variables variables de la expresión
     * @return resultado como String
     */
    static String evaluar(String expresion, LinkedList<Variable> variables) {
        LinkedList<Integer> tmp = new LinkedList<>();
        for (Character c : toList(expresion)) {
            if (Character.isLetter(c)) {
                try {
                    tmp.push(getValor(c, variables));
                    continue;
                } catch (Exception ex) {
                    return "Variable " + c + " no definida.";
                }
            }
            if (c == '+') {
                if (tmp.size() < 2) {
                    return "Expresion mal formada";
                }
                int b = tmp.pop();
                int a = tmp.pop();
                tmp.push(a + b);
                continue;
            }
            if (c == '^') {
                if (tmp.size() < 2) {
                    return "Expresion mal formada";
                }
                int b = tmp.pop();
                int a = tmp.pop();
                tmp.push((int) pow(a, b));
                continue;
            }
            if (c == '-') {
                if (tmp.size() < 2) {
                    return "Expresion mal formada";
                }

                int b = tmp.pop();
                int a = tmp.pop();
                tmp.push(a - b);
                continue;
            }
            if (c == '*') {
                if (tmp.size() < 2) {
                    return "Expresion mal formada";
                }

                int b = tmp.pop();
                int a = tmp.pop();
                tmp.push(a * b);
                continue;
            }
            if (c == '/') {
                if (tmp.size() < 2) {
                    return "Expresion mal formada";
                }

                int b = tmp.pop();
                int a = tmp.pop();
                tmp.push(a / b);
                continue;
            }
        }
        return tmp.size() != 1 ? "Expresión malformada" : tmp.pop() + "";
    }

    /**
     * retorna el valor de una variable dada
     * @param nvar nombre de varialbe
     * @param vars lista de variables
     * @return el valor de la variable buscada por su nombre
     * @throws Exception en caso de que la variable no exista en la lista de variables.
     */
    static int getValor(Character nvar, LinkedList<Variable> vars) throws Exception {
        Variable target = new Variable(nvar, 0);
        for (Variable var : vars) {
            if (var.equals(target)) {
                return var.valor;
            }
        }
        throw new Exception("Variable no existe");
    }
    
    /**
     * devuelve las variables de una expresión
     * @param expresion expresión de la cual se extraen las variables
     * @return lista de variables
     */
    static LinkedList<Variable> obtenerVariables(String expresion) {
        LinkedList<Variable> vars = new LinkedList<>();
        for (Character c : toList(expresion)) {
            Variable foo = new Variable(c,0); //variable temporal que representa el caracter
            if (Character.isLetter(c) && !vars.contains(foo)) {
                vars.add(foo);
            }
            c.equals('c');
        }
        return vars;
    }

}
