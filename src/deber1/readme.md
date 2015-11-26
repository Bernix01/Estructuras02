# Deber 1 
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

Analizando el código fuente provisto, se observan tres clases:
+ `Programa` que ya está definida.
+ `Coordenada` que fue definida en una [prácitca anterior](https://github.com/Bernix01/Estructuras02/tree/master/src/practica01).
+ `Conjunto` que tendremos que definir. 

Los conjuntos son representados por `LinkedLists` y poseen elementos del tipo `Coordenada`
```java
    ...
    LinkedList<Coordenada> conjunto1 = new LinkedList<>();
    LinkedList<Coordenada> conjunto2 = new LinkedList<>();
    LinkedList<Coordenada> union, interseccion, resta;
    ...
```

Se les agregan elementos por medio del llamado a las función estáticas `cargarC1` y `cargarC2` respectivamente
```java
    ...
    Programa.cargarC1(conjunto1);
    Programa.cargarC2(conjunto2);
    ...
```


Para posteriormente realizar las operaciones de unión, intersección y diferencia entre los conjuntos e imprimir los resultados
```java
    ...
    union = Conjunto.union(conjunto1,conjunto2); 
    interseccion = Conjunto.interseccion(conjunto1,conjunto2); 
    resta = Conjunto.diferencia(conjunto1,conjunto2);

    Conjunto.imprimir(union);
    Conjunto.imprimir(interseccion);
    Conjunto.imprimir(resta);
	...
```

Iniciamos creando nuestra clase *Conjunto* y le agregamos los métodos estáticos `union`, `interseccion`, `diferencia` e `imprimir`
```java
public class Conjunto {
		
	static LinkedList<Coordenada> union(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
    }
	
	static LinkedList<Coordenada> interseccion(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
    }

    static LinkedList<Coordenada> diferencia(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
    }

    static void imprimir(LinkedList<Coordenada> conjunto) {
    }

}
```
Primero definamos la diferencia. Esta función tomará dos conjuntos y retornará un nuevo conjunto con los elementos que, están en el primero conjunto pero no en el segundo. Entonces al conjunto que llamaremos `res` le vamos a agregar aquellos elementos.
```java
    static LinkedList<Coordenada> diferencia(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
        LinkedList<Coordenada> res = new LinkedList<>();
        //aquí le agregaremos los elementos a res.
        return res;
    }
```

Debemos tomar en cuenta los siguientes casos:
* Si el conjunto1 es vacío, el resultado será vacío (conjunto1).
* Si el conjunto2 es vacío, el resultado será el conjunto1.

entonces

```java
		...
		//Si alguno de los dos conjuntos es vacio, la diferencia es el primer conjunto
		if ((conjunto1.isEmpty() && !conjunto2.isEmpty()) || (!conjunto1.isEmpty() && conjunto2.isEmpty())) {
			return (LinkedList<Coordenada>) conjunto1.clone(); //retornamos un nuevo objeto, copia del conjunto1
		}
		...
```

