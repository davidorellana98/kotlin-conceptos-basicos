package com.example.kotlinconceptos.conceptosBasicos

/*
        ENUM CLASS

    • Si ingresa propiedades en el constructor primario, las constantes enum serán inicializadas
      con la instancia del tipo de dato requerido.
    • Si la enum class define algún miembro, separe las definiciones de constantes de las definiciones
      de miembro con un punto y coma (;), porque establece la separación de otros miembros existentes.
    • Cada constante enum es un objeto y está separada por comas.
    • Es posible declarar propiedades y métodos en el interior de las enum class.
    • Para interpretar los elementos de un enum, podemos usarla con la expresión when.
    • Los enum class pueden implementar interfaces, pero no puede derivar de una clase.
    • Posee propiedades y métodos adicionales como:
        • ordinal = Propiedad que almacena el índice del valor de la constante, la primera constante comienza con el valor cero.
        • name = Esta propiedad almacena el nombre de la constante.
        • values() = Este método devuelve una lista de todas las constantes definidas dentro del enum.
        • valuesOf() = Este método devuelve la constante definida en el enum class. Si la constante no está presente en el enum
          class, lanzara una excepción (IllegalArgumentException).
 */

enum class DiasSemana(val dia: Int) {
    LUNES(1),
    MARTES(2),
    MIERCOLES(3),
    JUEVES(4),
    VIERNES(5),
    SABADO(6),
    DOMINGO(7);
}

enum class Operacion(val signoOperacion: String) {
    SUMA("+"), RESTA("-"),
    MULTIPLICACION("*"), DIVISION("/")
}

class Calcular(
    private val valorUno: Int,
    private val valorDos: Int,
    private val operacion: Operacion
) {
    fun calcularOperacion(): Int = when (operacion) {
        Operacion.SUMA -> valorUno + valorDos
        Operacion.RESTA -> valorUno - valorDos
        Operacion.MULTIPLICACION -> valorUno * valorDos
        Operacion.DIVISION -> valorUno / valorDos
    }
}

fun main() {

    for (dia in DiasSemana.values()) {
        println("Indice: ${dia.ordinal} - Día: ${dia.name}, Posición: ${dia.dia}")
        when(dia) {
            DiasSemana.LUNES -> println("Comienza la semana (${dia.name})")
            DiasSemana.MARTES -> println("Segundo día vamos (${dia.name})")
            DiasSemana.MIERCOLES -> println("Tercer día vamos (${dia.name})")
            DiasSemana.JUEVES -> println("Cuarto día vamos (${dia.name})")
            DiasSemana.VIERNES -> println("Hoy termina mi jornada (${dia.name})")
            DiasSemana.SABADO -> println("Día de pasarla en familia (${dia.name})")
            DiasSemana.DOMINGO -> println("Día de descanso (${dia.name})")
        }
    }

    println("-------------------------------------------------------------------------------")

    val calculo1 = Calcular(10, 10, Operacion.SUMA)
    println("El resultado de la suma es: ${calculo1.calcularOperacion()}") // El resultado de la suma es: 20

    println("-------------------------------------------------------------------------------")

    val calculo2 = Calcular(10, 10, Operacion.RESTA)
    println("El resultado de la resta es: ${calculo2.calcularOperacion()}") // El resultado de la resta es: 0

    println("-------------------------------------------------------------------------------")

    val calculo3 = Calcular(10, 10, Operacion.MULTIPLICACION)
    println("El resultado de la multiplicación es: ${calculo3.calcularOperacion()}") // El resultado de la multiplicación es: 100

    println("-------------------------------------------------------------------------------")

    val calculo4 = Calcular(10, 10, Operacion.DIVISION)
    println("El resultado de la división es: ${calculo4.calcularOperacion()}") // El resultado de la división es: 1
}