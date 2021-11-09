package com.example.kotlinconceptos.conceptosBasicos

/*
        DATA CLASS

    • Útil para mantener datos y nos evita boilerplate.
    • El constructor principal debe tener al menos un parámetro y deben marcarse como val o var.
    • Para excluir propiedades, puede declararlas en el interior del cuerpo de la data class.
    • Las data class no pueden ser abstractas, abiertas, selladas o internas. Pero si puede extender
      otras clases e interfaces.
    • El compilador deriva automáticamente las siguientes funciones:
        • equals() = Devuelve true si dos objetos tienen el mismo contenido y funciona de manera similar a "==".
        • hashCode() = Devuelve un valor de código hash para el objeto.
        • componentN() = Permite hacer referencias a las propiedades del constructor, para ser implementados en
          su orden de declaración.
        • toString() = Devuelve un String de todos los parámetros definidos en el constructor principal.
        • copy() = Proporciona una copia del objeto de todos los parámetros definidos en el constructor, para
          poder alterar algunas o todas las propiedades.
 */

data class Libros(
    val nombre: String,
    val categoria: String,
    val precio: Double
) {
    var numeroPublicaciones: Int = 0
}

fun main() {

    val libros = Libros("Harry Potter", "Fantasía", 25.5)
    println(libros.toString()) // Libros(nombre=Harry Potter, categoria=Fantasía, precio=25.5)

    val libroNuevo = libros.copy(nombre = "Narnia", precio = 35.75)
    println(libroNuevo) // Libros(nombre=Narnia, categoria=Fantasía, precio=35.75)

    val hashHarryPotter = libros.hashCode()
    println(hashHarryPotter) // -2136733403
    val hashNarnia = libroNuevo.hashCode()
    println(hashNarnia) // 676881312

    val equalsLibro = hashHarryPotter == hashNarnia
    println(equalsLibro) // false

    val componentLibro = libros.component1()
    println(componentLibro) // Harry Potter

    val (nombre, categoria, precio) = libros
    println("Nombre del libro: $nombre, categoría: $categoria, precio: $precio") // Nombre del libro: Harry Potter, categoría: Fantasía, precio: 25.5

    libros.numeroPublicaciones = 7
    println("${libros.nombre} tiene ${libros.numeroPublicaciones} novelas infantiles") // Harry Potter tiene 7 novelas infantiles
}