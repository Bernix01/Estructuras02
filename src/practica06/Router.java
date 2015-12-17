/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica06;

import java.util.LinkedList;

/**
 *
 * @author gbern
 */
public class Router {

    private LinkedList<InterfaceRed> interfaces;
    static final int MAX_SALTOS = 10;

    public Router(int nInterfaces) {
        int i;

        for (i = 1; i <= nInterfaces; i++) {
            interfaces.add(new InterfaceRed(null));
        }
    }

    public void setIpInterface(int i, String ip) {
        interfaces.get(i).setIp(ip);
    }

    public void enrutar() {
        Paquete p;
        for (InterfaceRed i : interfaces) {
            while ((p = i.receive()) != null) {
                if (p.getnSaltos() != 3) {
                    i.send(p);
                }
            }
        }
    }
}
