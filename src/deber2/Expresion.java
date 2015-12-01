/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deber2;

import java.util.LinkedList;

/**
 *
 * @author gbern
 */
class Expresion {

    static String InFixToPostFix(String expresion) {
        if(expresion == null || expresion.isEmpty())
            return null;
        String postFix = "";
        LinkedList<Character> charList = toList(expresion);
        for(Character c : charList){
            
        }
        return postFix;
    }

    static boolean verificaParentesis(String expresion) {
        if(expresion == null || expresion.isEmpty())
            return false;
        LinkedList<Character> charList = toList(expresion);
        LinkedList<Character> cpar = new LinkedList<>();
        for (Character c : charList) {
            if (c.charValue() == '(') {
                cpar.push(c);
            } else if (c.charValue() == ')') {
                if (cpar.isEmpty()) {
                    return false;
                } else {
                    cpar.pop();
                }
            }
        }
        return charList.isEmpty();
    }

    static LinkedList<Character> toList(String expresion){
        LinkedList<Character> charList = new LinkedList<>();
        for (int i = 0; i < expresion.length(); i++) {
            char x = expresion.charAt(i);
            charList.add(x);
        }
        return charList;
    }

    static String evaluar(String expresion, LinkedList<Variable> variables) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
