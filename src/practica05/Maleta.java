/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica05;

/**
 *
 * @author gbern
 */
public class Maleta implements Comparable<Maleta>{
    public String codigo;
    public String propietario;
    public float peso;
    public String vuelo;

    @Override
    public int compareTo(Maleta o) {
       if(this.peso > o.peso)
           return 1;
       if(this.peso == o.peso)
           return 0;
       return -1;
    }


}
