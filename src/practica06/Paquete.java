/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica06;

/**
 *
 * @author gbern
 */
public class Paquete {
    private String ipOrigen;
    private String ipDestino;
    private Object data;
    int nSaltos;

    public Paquete(String ipOrigen, String ipDestino, Object data, int nSaltos) {
        this.ipOrigen = ipOrigen;
        this.ipDestino = ipDestino;
        this.data = data;
        this.nSaltos = nSaltos;
    }

    public int getnSaltos() {
        return nSaltos;
    }
    
    
}
