package com.example.kotlinconceptos.conceptosBasicos

/*
        GETTERS Y SETTERS

    • En kotlin los getters y setters se generan automáticamente según el tipo de variable que ha implementado (val o var).
    • La variable val, por ser inmutable genera getters.
    • La variable var, por ser mutable genera getters y setters.
    • Se pueden personalizar los getters y setters.
    • const val no puede generar getters personalizados.
    • La palabra reservada field, tiene acceso al valor del campo asignado.
 */

const val GETTERS = "GETTER en tiempo de compilación"

class GettersYSetters {
    // Personalización Getter Y Setter
    var lenguaje: String = "Kotlin"
        get() {
            println("Retorna el valor por defecto: $field")
            return field // Palabra reservada field, tiene acceso al valor del campo asigando.
        }
        set(nuevoValor) {
            println("Retorna el nuevo valor asignado: $nuevoValor")
            field = nuevoValor // Se asigna el nuevo valor
        }

    var miTallaDeZapatos = 40 // Genera automáticamente getter y setter

    var privateSetters: String = "abc"
        private set //

    // Personalización Getter
    val estadoAnimo: String
        get() = "Super Feliz"

    val lenguajeCienciaDatos = "Python" // Solo genera getter
}

class AreaTriangulo(val base: Int, val altura: Int) {
    val area: Int
        get() = (this.base * this.altura) / 2
}

fun main() {

    println(GETTERS) // GETTER en tiempo de compilación

    val gettersYSetters = GettersYSetters()
    gettersYSetters.lenguaje // Retorna el valor por defecto: Kotlin
    gettersYSetters.lenguaje = "JS" // Retorna el nuevo valor asignado: JS

    println(gettersYSetters.miTallaDeZapatos) // 40
    gettersYSetters.miTallaDeZapatos = 41
    println(gettersYSetters.miTallaDeZapatos) // 41

    /* gettersYSetters.privateSetters = "" */ // Error: Setter privado, no puede ser reasignado
    println(gettersYSetters.privateSetters) // abc

    println("-------------------------------------------------------------------------------")

    /* gettersYSetters.estadoAnimo = "Calmado" */ // Error: No puede ser reasigando; val no genera setter
    println(gettersYSetters.estadoAnimo) // Super Feliz

    /* gettersYSetters.lenguajeCienciaDatos = "JS" */ // Error: No puede ser reasigando; val no genera setter
    println(gettersYSetters.lenguajeCienciaDatos) // Python

    println("-------------------------------------------------------------------------------")

    val areaTriangulo = AreaTriangulo(8, 3)
    println(areaTriangulo.area.toDouble()) // 12.0
}