/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica02;

/**
 *
 * @author gbern
 */
public class Box<T> {
    private T t;
    
    public void set(T t){
        this.t = t;
    }
    public T get(){
        return t;
    }

    @Override
    public String toString() {
        return "Box{" + "t=" + t +'}';
    }
}
