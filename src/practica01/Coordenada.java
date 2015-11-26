/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica01;

import java.util.Objects;

/**
 *
 * @author Bernix01 <gebernal@espol.edu.ec>
 */
public class Coordenada {

    public float latitud;
    public float longitud;
    public String nombre;

    public Coordenada() {
        nombre  = "Guayaquil";
        latitud = -2.1951f;
        longitud = -79.88f;
    }

    /**
     * <p>Si no se escribe nada pues no pasa nada. Este es el constructor por
     * defecto.</p>
     */
    public Coordenada(float latitud, float longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Coordenada(float latitud, float longitud, String nombre) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
    }
    /**
     * Retorna la distancia en Km entre esta instancia (this) y c
     * @param c representa la coordenada con la que se calculará la distancia
     * @return 
     */
    public double calcularDistancia ( Coordenada c){
        int R = 6373;// radio de la tierra en Km
        double lat1rad =  Math.toRadians(this.latitud);
        double lat2rad = Math.toRadians(c.latitud);
        double deltaLat = Math.toRadians(c.latitud - this.longitud);
        double deltaLon = Math.toRadians(c.longitud - this.longitud);
        
        double a = Math.sin(deltaLat/2)*Math.sin(deltaLat/2)+
                Math.cos(lat1rad)*Math.cos(lat2rad)*Math.sin(deltaLon/2)*Math.sin(deltaLon/2);
        double x = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        return  R*x;
       
           
    }

    @Override
    public String toString() {
        return nombre+"(" + latitud + ", " + longitud + ')';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Coordenada other = (Coordenada) obj;
        if (Float.floatToIntBits(this.latitud) != Float.floatToIntBits(other.latitud)) {
            return false;
        }
        if (Float.floatToIntBits(this.longitud) != Float.floatToIntBits(other.longitud)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    

    
}
