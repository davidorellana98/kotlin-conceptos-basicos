package com.example.kotlinconceptos.conceptosBasicos

/*
        TYPE ALIAS

    - Proporcionan nombres alternativos para los tipos existentes. Si el nombre del tipo es demasiado largo,
      puede introducir un nombre más corto diferente y usar el nuevo en su lugar.
    - Los typealias se declaran desde el nivel superior.
    - Los typealias no introducen nuevos tipos. Son equivalentes a los tipos subyacentes correspondientes.
 */

typealias Direccion = Pair<Double, Double>
typealias Usuario = Triple<String, String, Int>
typealias Resultado = (Int, Int) -> Int
typealias ListaDeFrutas = List<String>
typealias Numericos = Int
typealias Latitud = Double
typealias Longitud = Double


fun usuario(primero: String, segundo: String, tercero: Numericos): Usuario {
    return Triple(primero, segundo, tercero)
}

fun listaDeFrutas(listaDeFrutas: ListaDeFrutas) {
    for (fruta in listaDeFrutas) {
        println(fruta)
    }
}

fun mapaDireccion(latitud: Latitud, longitud: Longitud) : Direccion {
    return Pair(latitud, longitud)
}

fun main() {

    val usuario = usuario("Fred", "Gaus", 10)
    println(usuario.first) // Fred
    println(usuario.second) // Gaus
    println(usuario.third) // 10

    println("-------------------------------------------------------------------------------")

    listaDeFrutas(listOf("manzana", "pera", "uva", "banana", "mango"))

    println("-------------------------------------------------------------------------------")

    val mapaDireccion = mapaDireccion(10450.25, 12466.174)
    println("Latitud: ${mapaDireccion.first}, Longitud: ${mapaDireccion.second}") // Latitud: 10450.25, Longitud: 12466.174

    println("-------------------------------------------------------------------------------")

    val suma: Resultado = { x: Numericos, y: Numericos ->
        x + y
    }
    println("La suma es: ${suma(578,125)}") // La suma es: 703
}