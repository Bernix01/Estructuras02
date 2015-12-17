/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica01.Coordenada;

/**
 *
 * @author gbern
 */
public class Programa {
    
    public static void main(String... args){
        seed("historial_bancoA.txt");
        LinkedList<Cliente> bancoA = cargarBanco("historial_bancoA.txt");
        Collections.sort(bancoA);
        System.out.println(bancoA.toString());
    }
    
    /**
     * carga el historial del banco
     * @param hbanco nombre del archivo con el historial de transacciones del banco
     * @return lista de clientes con sus cuentas y transacciones
     */
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
                int idtransaccion = Integer.parseInt(datos[0]);
                int idcliente = Integer.parseInt(datos[1]);
                int idcuenta = Integer.parseInt(datos[2]);
                int tipoTransac = Integer.parseInt(datos[3]);
                int cantidad = Integer.parseInt(datos [4]);
                Date fechaTransac = Transaccion.df.parse(datos[5]);
                
                
                    t = new Transaccion(tipoTransac,cantidad,idtransaccion,fechaTransac);
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
                   if(nuevo){
                    clientes.add(c);
                    nuevo = true;
                    continue;
                   }
                   continue;
                }
                //trabajamos con la cuenta que ya existe
                cuenta = posibleC;
                cuenta.agergarTransaccion(t); //agregar la transaccion
                
                //si el cliente es nuevo, se lo agrega
                if(nuevo){
                    clientes.add(c);
                }
                nuevo = true;//reiniciar la bandera de nuevo cliente
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Archivo con mal formato");
        }
        catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
            System.out.println("Error de lectura de archivo!!");
        } catch (ParseException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }
    
    public static void seed(String nombredeBanco){
        String fileName = nombredeBanco;

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            final Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR,2014);
            for(int i = 0; i<200;i++){
                cal.set(Calendar.DAY_OF_YEAR, ThreadLocalRandom.current().nextInt(cal.getActualMaximum(Calendar.DAY_OF_YEAR)) + 1);
                //idTransaccion,idCliente,idCuenta,tipoTransaccion,cantidad
                    bufferedWriter.write(ThreadLocalRandom.current().nextInt(1, 5) + ",");
                    bufferedWriter.write(ThreadLocalRandom.current().nextInt(1, 5) + ",");
                    bufferedWriter.write(ThreadLocalRandom.current().nextInt(1, 5) + ",");
                    bufferedWriter.write(((ThreadLocalRandom.current().nextInt(0, 1) == 0 )? -1 : 1) + ",");
                    bufferedWriter.write(ThreadLocalRandom.current().nextInt(1, 5000)+",");
                    bufferedWriter.write(Transaccion.df.format(cal.getTime()));
                    bufferedWriter.newLine();
                
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '"
                    + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        } finally {

        }
    }

}
