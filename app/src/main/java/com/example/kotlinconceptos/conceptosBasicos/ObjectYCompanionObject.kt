package com.example.kotlinconceptos.conceptosBasicos

/*
        OBJECT Y COMPANION OBJECT

    • object
        - Un object es un tipo de dato con una única instancia estática (Patrón Singleton) y no posee constructores.
        - Los object pueden ser expresiones de objeto o declaraciones de objeto y se utilizan con la palabra clave object.
        - Las declaraciones de objeto no pueden ser locales (es decir, no se pueden anidar directamente dentro de una
          función), pero se pueden anidar en otras declaraciones de objeto o clases no internas.
        - Las declaraciones de objeto se inicializan, cuando se accede a ellas por primera vez y siempre tiene un
          nombre después de la palabra clave.
        - Las expresiones de objeto se ejecutan (e inicializan) inmediatamente, donde se utilizan y no puede enlazar un
          nombre después de colocar la palabra clave, pero si es posible heredar de las clases existentes o implementar interfaces.
        - Las expresiones de objeto crean objetos de clases anónimas, es decir, clases que no se declaran explícitamente con la
          declaración. Tales clases son útiles para un solo uso.

    • companion object
        - Toda clase puede tener un companion object, que es un objeto que es común a todas las instancias de esa clase.
        - En los companion object se le puede asignar un nombre, pero no necesario, ya que viene por defecto el nombre Companion
          y es posible heredar de las clases existentes o implementar interfaces.
        - Los miembros de la clase pueden acceder a los miembros privados del companion object correspondiente.
        - Un companion object se inicializa cuando se carga la clase correspondiente.
 */

// Declaración Object
object CuerpoHumano {
    const val numeroHuesos = 206
    fun print(nombre: String = "Armando"): String {
        return "Hola, mi nombre es $nombre y tengo $numeroHuesos huesos."
    }
}

interface CargoDeEmpleo {
    fun cargoTrabajo(cargoEmpleo: String): String
}

// Implementación companion object
class EmpresaDeCocina {
    companion object : CargoDeEmpleo { // Se puede omitir el nombre del companion object, en cuyo caso se utilizará el nombre: Companion
        private const val NOMBRE_LOCAL = "Restaurante Mariela"
        override fun cargoTrabajo(cargoEmpleo: String): String {
            return "Trabajo en $NOMBRE_LOCAL, Mi cargo en el trabajo es de: $cargoEmpleo."
        }
    }
}

fun main() {

    // Declaración object
    val cuerpoHumano = CuerpoHumano
    println(cuerpoHumano.print()) // Hola, mi nombre es Armando y tengo 206 huesos.

    println("-------------------------------------------------------------------------------")

    val datos = object : CargoDeEmpleo { // Expresión Object
        var nombre: String = "Luis"
        var apellido: String = "Orellana"

        override fun toString(): String {
            return "Mi nombre es: $nombre y mi apellido es: $apellido."
        }

        override fun cargoTrabajo(cargoEmpleo: String): String {
            return "Mi cargo de trabajo actualmente es: $cargoEmpleo."
        }
    }
    println(datos) // Mi nombre es: Luis y mi apellido es: Orellana.
    println(datos.cargoTrabajo("Desarrollador Android")) // Mi cargo de trabajo actualmente es: Desarrollador Android.

    println("-------------------------------------------------------------------------------")

    // companion object
    val empresaDeCocina = EmpresaDeCocina.Companion.cargoTrabajo("Concinero") // Se puede omitir el nombre Companion
    println(empresaDeCocina) // Trabajo en Restaurante Mariela, Mi cargo en el trabajo es de: Concinero.
}