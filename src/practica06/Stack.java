/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica06;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author gbern
 */
public class Stack<T> {
    private Queue<T> Q1;
    private Queue<T> Q2;
    
    public void push(T t){
        Q1.add(t);
    }
    
    public boolean isEmpty(){
        return Q1.isEmpty();
    }
    
    public T pop()  throws Exception{
        if(Q1.isEmpty())
            throw new Exception("Pila vacía.");
        T t = null;
        while(Q1.size() >1){
            Q2.add(Q1.poll());
        }
            t = Q1.poll();
        while(!Q2.isEmpty())
            Q1.add(Q2.poll());
        return t;
    }

    public Stack() {
        Q1 = new LinkedList<>();
        Q2 = new LinkedList<>();
    }
}
