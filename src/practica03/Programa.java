/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import practica01.Coordenada;

/**
 *
 * @author gbern
 */
public class Programa {
    
    public static void main(String... args){
        
        LinkedList<Cliente> bancoA = cargarBanco("historial_bancoA.txt");
        Collections.sort(bancoA);
        System.out.println(bancoA.toString());
    }
    
    public static LinkedList<Cliente> cargarBanco(String hbanco){
        LinkedList<Cliente> clientes = new LinkedList<>();
        FileReader fr;
        BufferedReader br;
        String linea;
        String datos[];
        Cliente c;
        Cuenta cuenta;
        Transaccion t;
        boolean nuevo = true;
        try {
            fr = new FileReader(hbanco);
            br = new BufferedReader(fr);
            //idTransaccion,idCliente,idCuenta,tipoTransaccion,cantidad
            while((linea = br.readLine()) != null){
                datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                int idcliente = Integer.parseInt(datos[1]);
                int idcuenta = Integer.parseInt(datos[2]);
                int tipoTransac = Integer.parseInt(datos[3]);
                int cantidad = Integer.parseInt(datos [4]);
                
                
                    t = new Transaccion(tipoTransac,cantidad,id);
                    cuenta = new Cuenta(idcuenta,new LinkedList<>());
                    c = new Cliente(idcliente,new LinkedList<>());
                   //Si la lista esta vacía, agrego todo como nuevo 
                if(clientes.isEmpty()){
                    cuenta.agergarTransaccion(t);
                    c.agregarCuenta(cuenta);
                    clientes.add(c);
                    continue;
                }
                //Busco si el cliente ya está registrado en el banco
                for(Cliente tmp:clientes){
                    if(tmp.equals(c)){
                        c = tmp;// asigno la coincidencia a c para trabajar con el cliente existente
                        nuevo = false;
                        break;
                    }
                }
                Cuenta posibleC = c.tieneCuenta(cuenta); //intento extraer la cuenta
                
                //no tiene esta cuenta, hay que agregársela.
                if(posibleC == null){
                   cuenta.agergarTransaccion(t); //agregar la transacción
                   c.agregarCuenta(cuenta);
                   clientes.add(c);
                   continue;
                }
                //trabajamos con la cuenta que ya existe
                cuenta = posibleC;
                cuenta.agergarTransaccion(t); //agregar la transaccion
                
                //si el cliente es nuevo, se lo agrega
                if(nuevo){
                    clientes.add(c);
                }
                nuevo = false;//reiniciar la bandera de nuevo cliente
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Archivo con mal formato");
        }
        catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            System.out.println("Error de lectura de archivo!!");
        }
        
        return clientes;
    }
    

}
