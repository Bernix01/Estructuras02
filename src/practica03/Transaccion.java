/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03;

/**
 *
 * @author gbern
 */
public class Transaccion implements Comparable {

    private int tipo;
    private int cantidad;
    private int numero;
    public static final int CODIGO_DEPOSITO = 1;
    public static final int CODIGO_RETIRO = -1;
    

    public int getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getNumero() {
        return numero;
    }

    public Transaccion(int tipo, int cantidad, int numero) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "\t\tTransaccion{" + "tipo=" + ((tipo == 1) ? " Depósito ":" Retiro ") + ", cantidad=" + cantidad + ", numero=" + numero + "}\n";
    }

    @Override
    public int compareTo(Object o) {
        Transaccion e = (Transaccion) o;
        if (e.getNumero() > this.getNumero()) {
            return -1;
        } else if (e.getNumero() < this.getNumero()) {
            return 1;
        }
        return 0;
    }

}
