# Deber 1 

>### El enunciado
>
>  1) Crear la unión, intersección y diferencia de conjuntos.
>
>  Su respuesta debe permitir que el siguiente código fuente compile y se pueda ejecutar.
>```java
>  public class Programa {
>
>    public static void main(String[] args){
>      LinkedList<Coordenada> conjunto1 = new LinkedList<>();
>      LinkedList<Coordenada> conjunto2 = new LinkedList<>();
>      LinkedList<Coordenada> union, interseccion, resta;
>
>      Programa.cargarC1(conjunto1);
>      Programa.cargarC2(conjunto2);
>
>      union = Conjunto.union(conjunto1,conjunto2); 
>      interseccion = Conjunto.interseccion(conjunto1,conjunto2); 
>      resta = Conjunto.diferencia(conjunto1,conjunto2);
>
>      Conjunto.imprimir(union);
>      Conjunto.imprimir(interseccion);
>      Conjunto.imprimir(resta);
>    }
>
>    private static void cargarC1(LinkedList<Coordenada> conjunto){
>      conjunto.add(new Coordenada(10, 10, "Ciudad 1"));
>      conjunto.add(new Coordenada(20, 20, "Ciudad 2"));
>      conjunto.add(new Coordenada(30, 30, "Ciudad 3"));
>      conjunto.add(new Coordenada(40, 40, "Ciudad 4"));
>    }
>
>    private static void cargarC2(LinkedList<Coordenada> conjunto){
>      conjunto.add(new Coordenada(50, 50, "Ciudad 5"));
>      conjunto.add(new Coordenada(20, 20, "Ciudad 2"));
>      conjunto.add(new Coordenada(60, 60, "Ciudad 6"));
>      conjunto.add(new Coordenada(40, 40, "Ciudad 4"));
>    }
>  }
>```
>
>  2) Reemplazar los métodos cargarC1 y cargarC2 por lecturas desde archivo.
>
>  3) Guardar las listas resultantes de las operaciones en un archivo llamado "resultados.txt"
>  

