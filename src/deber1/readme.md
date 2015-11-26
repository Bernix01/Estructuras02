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

**Nota:** En este deber se harán comparaciones entre objetos de tipo `Coordenada`, es necesario sobreescribir el método `equals(Object o)` en la clase coordenada para poder tener los resultados esperados.

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
----
##Diferencia
Primero definamos la diferencia. Esta función tomará dos conjuntos y retornará un nuevo conjunto con los elementos que, están en el primero conjunto pero no en el segundo. Entonces al conjunto que llamaremos `res` le vamos a agregar aquellos elementos.
```java
    static LinkedList<Coordenada> diferencia(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
	      LinkedList<Coordenada> res = new LinkedList<>();
	      ...
	      return res;
    }
```

Debemos tomar en cuenta los siguientes casos:
* Si el conjunto1 es null, la diferencia nos dará null.
* Si el conjunto1 es vacío, el resultado será vacío (conjunto1).
* Si el conjunto2 es vacío, el resultado será el conjunto1.

entonces

```java
		...
		//Si el conjunto1 es null, la diferencia será null.
		if (conjunto1 == null) {
		          return null;
		      }
		//Si alguno de los dos conjuntos es vacio, la diferencia es el primer conjunto
		if ((conjunto1.isEmpty() && !conjunto2.isEmpty()) || (!conjunto1.isEmpty() && conjunto2.isEmpty())) {
			return (LinkedList<Coordenada>) conjunto1.clone(); //retornamos un nuevo objeto, copia del conjunto1
		}
		...
```

en este punto tendremos dos conjuntos no nullos y no vacíos. Retornaremos una lista que contenga elementos solo de el primer conjunto `conjunto1`. Usando un for-each anidado se puede lograr esto, el for-each externo recorrerá `conjunto1` y el interno recorrerá `conjunto2` por cada elemento de `conjunto1`, si el elemento de `conjunto1` no se encuentra en `conjunto2` lo agregamos a `res` caso contrario, si llegásemos a encontrar una coincidencia, saltamos esa iteración del for-each externo usando `continue;` y finalmente retornamos `res`.

```java
		...
		LinkedList<Coordenada> res = new LinkedList<>();
		      //le agregamos la etiqueta c1 al foreach del conjunto1, esto servirá para poder saltarnos iteraciones si encontramos algún elemento del conjunto1 en el conjunto2
		      c1:
		      for (Coordenada c : conjunto1) {
		          for (Coordenada a : conjunto2) {
		              if (c.equals(a)) {
		                  //intersección encontrada, salta c1!
		                  continue c1;
		              }
		          }
		          res.add(c); //agregar el elemento al resultado
		      }
		      return res;
	}
```

**Nota:** usar `continue;` dentro del for-each interno haría que se salte a la siguiente iteración el for-each interno, en este caso he utilizado una [etiqueta](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/branch.html) para poder aplicar el `continue;` con el for-each externo. Esto también nos permitiría utilizar `break c1;` para romper el for-each externo.

----
##Intersección

La intersección entre conjuntos son todos aquellos elementos comunes entre los conjuntos.

Aquí también tendremos casos especiales en los cuales el resultado es puntual:
*Si alguno de los dos es null, la intersección será null. (la intersección entre un conjunto y la nada, es la nada.)
*Si alguno de los elementos o los dos está(n) vacío, la intersección será vacío.

```java
	static LinkedList<Coordenada> interseccion(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
		if (conjunto1 == null || conjunto2 == null) {
            return null;
        }
        LinkedList<Coordenada> resultado = new LinkedList<>();
        if (conjunto1.isEmpty() || conjunto2.isEmpty()) {
            return resultado; //vacío
           }
        ...
```


En este punto ya tendremos dos conjuntos no nulos y no vacío, buscamos las coincidencias de los elementos y los retornamos en un nuevo conjunto.

```java
		...
		for (Coordenada c : conjunto1) {
		    for (Coordenada a : conjunto2) {
		        if (c.equals(a)) {
		            resultado.add(a); //agregar el elemento al resultado
		            break; //intersección encontrada
		        }
		    }
		}
		return resultado;
	}
```

---
##Unión
La unión de conjuntos son todos los elementos de ambos conjuntos sin repetirse, diríamos a simple vista. Analizando un poco más:

Si tenemos dos conjuntos A y B, sabremos que la unión sería todo lo sombreado:

![Unión de A y B](https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/SetUnion.svg/200px-SetUnion.svg.png)

La cual la podríamos descomponer en:

A. La diferencia de A con B

![Diferencia de A con B](https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/SetDifferenceA.svg/200px-SetDifferenceA.svg.png)

B. La intersección de A con B

![Intersección de A con B](https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/SetIntersection.svg/200px-SetIntersection.svg.png)

C. La diferencia de B con A

![Diferencia de B con A](https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/SetDifferenceB.svg/200px-SetDifferenceB.svg.png)


Entonces, analicemos los casos especiales:
* Si A y B son null, la unión será null.
* Si A y B son vacíos, la unión será vacío.
* Si A o B es null, la unión será el otro conjunto.
* Si A o B es vacío, la unión será el otro conjunto.

```java
	static LinkedList<Coordenada> union(LinkedList<Coordenada> conjunto1, LinkedList<Coordenada> conjunto2) {
		if (conjunto1 == null && conjunto2 == null) {
		    return null;
		}
		if (conjunto1 != null && conjunto2 == null) {
		    return conjunto1;
		}
		if (conjunto1 == null && conjunto2 != null) {
		    return conjunto2;
		}
		if (conjunto1.isEmpty() && conjunto2.isEmpty()) {
		    return new LinkedList<Coordenada>(); //vacío U vacío = vacío
		}
		if (conjunto1.isEmpty() && !conjunto2.isEmpty()) {
		    return conjunto2; // vacío U conjunto2 = conjunto2
		}
		if (!conjunto1.isEmpty() && conjunto2.isEmpty()) {
		    return conjunto1; // conjunto1 U vacío = conjunto1
		}
		...
```

En este punto tendremos dos conjuntos no null y no vacíos. Ahora bien, podemos tener dos situaciones, que los conjuntos sean disjuntos y que no lo sean.

####Conjuntos disjuntos

Si los conjuntos son disjuntos, no tendrán ningún elemento en común por lo tanto podemos simplemente agregar todos los elementos de ambos conjuntos en uno nuevo y esa será nuestra unión. 

```java
        ...
        //si no hay intersección entre los conjuntos, la unión son todos los elementos de ambos conjuntos.
        LinkedList<Coordenada> inter = interseccion(conjunto1, conjunto2);
        if (inter.isEmpty()) {
            for (Coordenada c : conjunto1) {
                resultado.add(c);
            }
            for (Coordenada c : conjunto2) {
                resultado.add(c);
            }
            return resultado;
        }
        ...
```

####Conjuntos no disjuntos

Es en esta situación en la que decimos que la unión de A y B será `(A-B)U(A∩B)U(B-A)`
ya previamente guardamos la referencia a la intersección en la variable `inter` por lo que no quedaría...

```java
        //si existe la intersección entre ambos conjuntos, la unión será INTERSECCION U diferencia(conjunto1,conjunto2) U diferencia(conjunto2,conjunto1)
        resultado = union(inter, diferencia(conjunto1, conjunto2)); //INTERSECCION U diferencia(conjunto1,conjunto2)
        return union(resultado, diferencia(conjunto2, conjunto1)); // (INTERSECCION U diferencia(conjunto1,conjunto2)) U diferencia(conjunto2,conjunto1)
    }
```

---
##Lectura de archivo
El código provisto en una clase del paralelo 3 me lo ha compartido Luis Zúñiga, el cual he comentado para que se pueda entender más.

```java 
    public static LinkedList<Coordenada> cargar(String archivo){
        FileReader fr;
        BufferedReader br;
        String linea;
        String datos[];
        Coordenada co;
        LinkedList<Coordenada> lista = new LinkedList<>();
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            //mientras tengamos líneas que leer...
            while((linea = br.readLine()) != null){
                datos = linea.split(",");//divide el texto en cada ","
                co = new Coordenada(); //una nueva coordenada que tendrá los datos de la línea que esté leyendo el programa
                co.latitud = Float.parseFloat(datos[0]); //la primera sección corresponde a la latitud
                co.longitud = Float.parseFloat(datos[1]); //la segunda sección corresponde a la longitud
                co.nombre = datos[2]; //la tercera sección corresponde al nombre
                lista.add(co); //agregamos a la lista
            }
        }catch(ArrayIndexOutOfBoundsException e){
		    //Manejo de excepción, mostrando un mensaje por consola
            System.out.println("Archivo con mal formato");
        }
        catch (FileNotFoundException ex) {
		    //Manejo de excepción, mostrando un mensaje por consola
            System.out.println("El archivo no existe");
        } catch (IOException ex) {
		    //Manejo de excepción, mostrando un mensaje por consola
            System.out.println("Error de lectura de archivo!!");
        }
        return lista; // retornamos la lista
    }
```

**Nota:** Este método lo he guardado en la clase `Programa`, el archivo `.txt` debe estar en la raíz del proyecto. 

##Imprimir conjunto
---

Esto es solo iterar y usar `System.out.println();` 
Consideramos que si el conjunto es null, solo retornamos, sin hacer nada.

```java
    static void imprimir(LinkedList<Coordenada> conjunto) {
        if (conjunto == null) {
            return;
        }
        for (Coordenada c : conjunto) {
            System.out.println(c);
        }
    }
```


##Escritura de los resultados en `resultados.txt`
---

```java
   /**
     * *
     * guardar guarda los conjuntos que reciba en un archivo.
     *
     * @param nombreArchivo nombre del archivo
     * @param nuevoArchivo guardar en un nuevo archivo o añadir al final (Si
     * existe)
     * @param conjuntos conjuntos a guardar, puede ser uno o varios.
     */
    static void guardar(String nombreArchivo, boolean nuevoArchivo, LinkedList<Coordenada>... conjuntos) {
        String fileName = nombreArchivo;

        try {
            // Assume default encoding.
            FileWriter fileWriter
                    = new FileWriter(fileName, nuevoArchivo);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter
                    = new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            for (LinkedList<Coordenada> conjunto : conjuntos) {
                bufferedWriter.write("----------------------------"); //divisor de conjunto
                bufferedWriter.newLine();
                for (Coordenada c : conjunto) {
                    bufferedWriter.write(c.latitud + ",");
                    bufferedWriter.write(c.longitud + ",");
                    bufferedWriter.write(c.nombre);
                    bufferedWriter.newLine();
                }
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
```

Código encontrado en internet (olvidé de donde) pero gracias al autor :v:



