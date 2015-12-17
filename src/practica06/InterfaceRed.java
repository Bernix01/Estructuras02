/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author gbern
 */
public class InterfaceRed {
    private Queue<Paquete> bIn;
    private Queue<Paquete> bOut;
    private String ip;

    public InterfaceRed(String ip) {
        this.bIn = new LinkedList<>();
        this.bOut = new LinkedList<>();
        this.ip = ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public void send(Paquete p){
        p.nSaltos++;
        bOut.add(p);
    }
    
    public Paquete receive(){
        return bIn.poll();
    }
    
    public String getIpDestino(){
        //asdasd
        return "";
    }
    
    public TipoDispositivo getDispositivoDestino(){
        int op = ThreadLocalRandom.current().nextInt(1,6);
        switch (op){
            case 1: return TipoDispositivo.ROUTER;
            case 2: return TipoDispositivo.IMPRESORA;
            case 3: return TipoDispositivo.PC;
            case 4: return TipoDispositivo.TELEFONO;
            default: return TipoDispositivo.PC;
        }
    }
    
    enum TipoDispositivo{
        PC,
        TELEVISOR,
        IMPRESORA,
        ROUTER, TELEFONO;
        
    }
}
