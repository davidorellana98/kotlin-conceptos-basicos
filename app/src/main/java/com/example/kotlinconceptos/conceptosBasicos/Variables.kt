package com.example.kotlinconceptos.conceptosBasicos

/*
            VARIABLES

    • var
        - Variable mutable, es decir que su valor se puede reasignar varias veces y se determina en
        tiempo de ejecución.
        - El tipo de dato puede ser opcional, siempre y cuando su valor no sea nulo.
    • val
        - Variable de solo lectura e inmutable. Su valor no puede ser reasignado en un futuro y se
        determina en tiempo de ejecución.
        - El tipo de dato también puede ser opcional, siempre y cuando su valor no sea nulo.
    • const val
        - Es una variable inmutable de solo lectura, que su valor no va a hacer cambiado en un
        futuro. La diferencia con val, es que const val se determina en tiempo de compilación.
        - Debe ser una propiedad de nivel superior es decir global o un miembro de una declaración object o companion object.
        - Una buena práctica en kotlin es definir el nombre de las variables const val en mayúsculas.
        - Siempre se debe inicializar su valor.
 */

// Puedes declarar variables val y var globales, pero no es recomendable.
var variableGlobal: String = """
    | No es recomendable asignar la propiedad var en niveles superiores (globales)
    | Se ejecuta en tiempo de ejecución
""".trimIndent()
val variableGlobal2 = """
    | No es recomendable asignar la propiedad val en niveles superiores (globales)
    | Se ejecuta en tiempo de ejecución
""".trimIndent()

// Variable de nivel global (nivel superior)
const val PI: Double = 3.1416
const val LENGUAJE_OFICIAL: String = "Kotlin"
const val PRIMERA_VOCAL = 'A' // Se puede inferir el tipo de dato (Char)


fun main() {

    // Declaración de const val
    println("El valor de PI es: $PI") // El valor de PI es: 3.1416
    println("El lenguaje oficial de android es: $LENGUAJE_OFICIAL") // El lenguaje oficial de android es: Kotlin
    println("La primera vocal es: $PRIMERA_VOCAL") // La primera vocal es: A

    println("-------------------------------------------------------------------------------")

    // Declaración de val
    val hola: String = "Bienvenidos a conceptos básicos de Kotlin"
    println(hola) // Bienvenidos a conceptos básicos de Kotlin

    val adios = "Nos vemos en el otro artículo" // Se puede inferir el tipo de varibale (String)
    /* adios = "Pronto, nos veremos" */ // Error: val no se puede reasignarse

    val valorNull: Int? = null
    println(valorNull) // null

    /* val nullDeclarado: Long = null */ // Error: No se puede declarar un valor null a un tipo de dato no nullable

    println("-------------------------------------------------------------------------------")

    // Declaración de var
    var tienda: String = "Una libra de arroz, por favor"
    tienda = "Me puede adicionar dos libras de arroz, por favor"
    println(tienda) // Me puede adicionar dos libras de arroz, por favor

    // Tipo de dato Boolean
    var declaracion = true
    println(declaracion) // true

    var valorNull2: Float? = 10F
    println(valorNull2) // 10.0
    valorNull2 = null
    println(valorNull2) // null

    /* var declaracionNull: Boolean = null */ // Error: No se puede declarar un valor null a un tipo de dato no nullable

    println("-------------------------------------------------------------------------------")

    // Declaración de val y var a nivel superior
    println(variableGlobal)
    println(variableGlobal2)
}
