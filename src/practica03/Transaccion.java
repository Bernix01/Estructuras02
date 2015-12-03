/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author gbern
 */
public class Transaccion implements Comparable {

    private int tipo;
    private int cantidad;
    private Date fechaTransaccion;
    private int numero;
    public static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
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

    public Transaccion(int tipo, int cantidad, int numero, Date fechaTransaccion) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.numero = numero;
        this.fechaTransaccion = fechaTransaccion;
    }

    @Override
    public String toString() {
        
        
        String fecha = df.format(fechaTransaccion);

        return "\n\t\t\t\tTransaccion{" + "tipo=" + ((tipo == 1) ? " Depósito " : " Retiro ") + ", cantidad=" + cantidad + ", numero=" + numero + ", fecha= " + fecha + "}";
    }

    @Override
    public int compareTo(Object o) {
        Transaccion e = (Transaccion) o;
        if (e.getFechaTransaccion().after(this.getFechaTransaccion())) {
            return -1;
        } else if (e.getFechaTransaccion().before(this.getFechaTransaccion())) {
            return 1;
        }
        return 0;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

}
