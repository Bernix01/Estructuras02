/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author gbern
 */
public class Cliente implements Comparable {

    private int id;
    private LinkedList<Cuenta> cuentas;

    public Cliente(int id, LinkedList<Cuenta> cuentas) {
        this.id = id;
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", \ncuentas=" + cuentas.toString() + "}\n";
    }

    public int getId() {
        return id;
    }

    public LinkedList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta c) {
        this.cuentas.add(c);
        Collections.sort(cuentas);
    }

    public Cuenta tieneCuenta(Cuenta c) {
        for (Cuenta tmp : this.cuentas) {
            if (tmp.equals(c)) {
                return tmp;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
        Cliente e = (Cliente) o;
        if (e.getId() > this.getId()) {
            return -1;
        } else if (e.getId() < this.getId()) {
            return 1;
        }
        return 0;
    }

}
