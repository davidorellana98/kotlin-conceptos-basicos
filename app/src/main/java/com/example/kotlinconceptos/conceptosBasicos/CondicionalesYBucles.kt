package com.example.kotlinconceptos.conceptosBasicos

/*
        CONDICIONALES Y BUCLES

    • Condicional if
        - En kotlin if es una expresión, es decir devuelve un valor.
        - if nos permite ejecutar un bloque de código. Si la condición es verdadera, ejecutará lo
          implementado en if y si no se cumple ejecuta otra condición o concluirá su proceso.
        - Si if se usa como expresión para devolver su valor o asignarlo a una variable, la utilización else es obligatoria.
    • Condicional when
        - when define una expresión condicional con varias ramas.
        - when se puede utilizar como declaración o como expresión, y si es una expresión la rama else es obligatoria.
        - El operador in sirve para verificar si un valor está dentro del rango o en una colección.
        - El operador is permite comprobar si una variable es de un tipo asignado.
    • Bucle for
        - Es utilizado para iterar cualquier cosa que proporcione un iterador.
        - Utiliza el operador in para recorrer los datos estructurados.
        - Los datos estructurados pueden ser array, rangos, listas, string, etc.
    • Bucle while y do-while
        - while comprueba la condición y si cumple ejecuta el cuerpo y a continuación vuelve a la comprobación de condición. Este
          bucle repetirá su cuerpo mientras la condición sea true o alguna expresión de salto sea evaluada.
        - do-while ejecuta el cuerpo y a continuación comprueba el estado. Si está satisfecho el bucle se repite. Por lo
          tanto, el cuerpo se ejecuta al menos una vez, independientemente de la condición.
 */

fun main() {

    // Condicional if
    val mayorDeEdad = (1..100).random() // Número al azar del 1 al 100
    if (mayorDeEdad >= 18) println("Es mayor de edad con $mayorDeEdad") // Se ejecutará si esta en el rango de 18 al 100.
    val mayorOMenor = if (mayorDeEdad >= 18) "Persona mayor" else "Persona menor con $mayorDeEdad"
    println(mayorOMenor)// Ejecutará cualquiera de las 2 condiciones.
    if (mayorDeEdad >= 41) {
        println("Tiene ganas de descansar")
    } else if (mayorDeEdad in 18..40){
        println("Tiene ganas de trabajar")
    } else {
        println("Tiene ganas de jugar")
    }

    println("-------------------------------------------------------------------------------")

    // Condicional when
    print("Ingrese un número del 1 al 10: ")
    val azar: Any? = readLine()?.toIntOrNull() // Me permite ingresar un valor en consola.
    when (azar) { // Declaración when
        in 1..3 -> println("El número esta en el rango 1 al 3")
        4,5,6 -> println("El número ingresado esta en los intervalos de 4, 5 y 6")
        is String? -> println("Solo esta permitido ingresar números enteros")
        in 7..10 -> println("El número esta en el rango 7 al 10")
        !in 1..10 -> println("Número fuera del rango")
    }

    println("-------------------------------------------------------------------------------")

    // Bucle for
    for (i: Int in 1 until  5) print(i) // 1,2,3,4
    println()
    for (abecedario in 'a'..'e') {
        print(abecedario) // a,b,c,d,e
    }
    println()
    val nombres = listOf("Armando", "David", "Cely", "Martha")
    for (nombre in nombres.indices) { // Devuelve el índice de cada elemento
        if (nombre % 2 == 0) // Solo índices pares
            println(nombres[nombre]) // Armando[0], Cely[2]
    }

    val lenguajes = arrayOf("kotlin", "js", "c++")
    for ((indice, valor) in lenguajes.withIndex()) { // Devuelve el índice y su valor
        println("El indice es: $indice y su valor es: $valor")
    }

    println("-------------------------------------------------------------------------------")

    // Bucle while y do-while

    var suma = 0
    var valor = 1
    // Bucle while
    while (valor <= 5) {
        suma += valor++
    }
    println("Suma total: $suma") // Suma total: 15

    var diaLaboral: Int = 1
    while(diaLaboral < 6) {
        if  (diaLaboral == 1) {
            println("$diaLaboral dia trabajando")
        } else {
            println("$diaLaboral dias trabajando")
        }
        diaLaboral++ // Actualizamos la condición
    }

    // Bucle do-while
    do {
        println("¿Cuál es la capital del Ecuador?")
        println("a. Quito")
        println("b. La Paz")
        println("c. Lima")
        println("Por favor ingresar: a, b o c")
        print("Respuesta: ")
        val opciones = readLine()!! // Ingresa valor en consola.
        val comprobación = opciones != "a"
        if (comprobación) {
            println("Es incorrecto, vuelve a intentarlo! :(")
        } else {
            println("Es correcto, felicitaciones! :)")
        }
    } while (comprobación) // Ejecuta el cuerpo y hace la comprobación. Si es incorrecto se repite el bucle, caso contrario, termina su proceso.
}