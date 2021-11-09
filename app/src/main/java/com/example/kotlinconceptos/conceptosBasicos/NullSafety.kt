package com.example.kotlinconceptos.conceptosBasicos

/*
        NULL SAFETY (Seguridad nula)

    • En kotlin los objetos por defecto no aceptan valores nulos, para poder asignar
      un valor nulo tendremos que indicar que ese objeto realmente pueda ser nulo.
    • Operador Safe Call (?): En los sistemas de tipos, para poder hacer una llamada segura
      en valores nulos colocar el siguiente operador llamado Safe Call (?).
    • Operador Elvis (?:): Sirve para hacer una comprobación, si una condición no coincide la
      otra se ejecutará.
    • Operador Double Bang (!!): Con este operador se evita la necesidad de chequear nulos, si
      está completamente seguro de que el valor de la variable nunca será nula.
    • let: Para realizar una determinada operación solo para valores no nulos, puede utilizar el
      operador de llamada segura junto con let.
    • Existen funciones que ayudan a comprobar si hay valores nulos como:
      filterNotNull(), isNullOrBlank(), isNullOrEmpty(), maxOrNull(), randomOrNull() y muchas más.
 */

fun main() {
    var a: String = "kotlin"
    /* a = null */ // Error de compilación
    // Si la variable no es nula, se puede omitir el operador Safe Call (llamada segura)
    println(a?.length) // 6

    val b: String? = null
    println(b?.length) // null

    val c = b?.length ?: -1
    println(c) // -1

    //val d = b!!.length
    //println(d) // Error: NullPointerException

    var e: Float? = 10.5F
    e = null
    println(e) // null

    val f = if (e != null) 7.5F else 0F
    println(f) // 0.0

    println("-------------------------------------------------------------------------------")

    val nullList: List<Int?> = listOf(1, 2, null, 4)
    println(nullList.filterNotNull()) // [1,2,4]
    println(nullList.elementAtOrNull(10)) // null

    println("-------------------------------------------------------------------------------")

    val nullNumber: List<Int?> = listOf(null, 1, 2, null, 3, 4, 5)
    println(nullNumber.firstOrNull()) // null
    println(nullNumber.lastOrNull()) // 5
    println(nullNumber.randomOrNull()) // Resultados al azar

    println("-------------------------------------------------------------------------------")

    val letList: List<String?> = listOf("java", null, "kotlin")
    for (list in letList) {
        list?.let { // Con el operador Safe Call, ignora los valores nulos.
            print("$it ") // java kotlin
        }
    }
}