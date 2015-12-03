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
public class Cuenta implements Comparable {

    private int numero;
    private LinkedList<Transaccion> transacciones;
    private double saldo;

    public Cuenta(int numero, LinkedList<Transaccion> transacciones) {
        this.numero = numero;
        this.transacciones = transacciones;
        this.saldo = 0;
    }

    @Override
    public String toString() {
        return "\tCuenta{" + "numero=" + numero + ", \ntransacciones=" + transacciones + ", saldo=" + saldo + "}\n";
    }

    @Override
    public int compareTo(Object o) {
        Cuenta e = (Cuenta) o;
        if (e.getNumero() > this.getNumero()) {
            return -1;
        } else if (e.getNumero() < this.getNumero()) {
            return 1;
        }
        return 0;
    }

    public int getNumero() {
        return numero;
    }

    public LinkedList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void agergarTransaccion(Transaccion t) {
        this.transacciones.add(t);
        if(t.getTipo() == Transaccion.CODIGO_DEPOSITO){
            saldo += t.getCantidad();
        }
        if(t.getTipo() == Transaccion.CODIGO_RETIRO)
            saldo -= t.getCantidad();
        Collections.sort(transacciones);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.numero;
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
        final Cuenta other = (Cuenta) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    
}
