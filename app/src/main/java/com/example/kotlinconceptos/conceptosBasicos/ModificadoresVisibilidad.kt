package com.example.kotlinconceptos.conceptosBasicos

/*
        MODIFICADORES DE VISIBILIDAD

    Las clases, objetos, interfaces, constructores y funciones, así como las propiedades y sus setters, pueden tener
    modificadores de visibilidad. Los getters siempre tienen la misma visibilidad que sus propiedades. Las variables, funciones
    y clases locales no pueden tener modificadores de visibilidad.

    • private: Visible dentro del archivo declarado y dentro de su clase contenedora (Incluido todos sus miembros)
    • public: Su implementación esta por defecto, lo que significa que sus declaraciones serán visibles en todas partes.
    • protected: No está disponible para declaraciones de nivel superior. Es visible en la clase contenedora y subclase de la misma.
    • internal: Es visible en todas partes del mismo modulo, es decir un conjunto de archivos kotlin compilados juntos.
*/

/* modificador private */
private fun marathon(kmRecorridos: Double) = "Recorrió $kmRecorridos km" // Es visible en archivo

private class Escuela { private val nombreEstudiante: String = "" }

private class Visibilidad(
    val nombre: String = "VISIBLE"
) { private val esVisible: Boolean = true } // No es visible fuera del archivo y no es poible declararlo afuera de otro metodo.


/* modificador public */
public fun suma(valorUno: Int, valorDos:Int) = valorUno + valorDos // El modificador public es redundante.

const val TERCER_PLANETA = "TIERRA"


/* modificador protected */
open class Libro {
    open var entrada  = 15.5 // Es public, visible en cualquier lugar.
    internal open val ultimaVocal = "u" // Visible en el módulo actual.
    private val bonusEvento = "Cajita de Regalo" // Visible solo en la clase Libro
    protected open var emprendimiento = "Padre Rico, Padre Pobre" // Visible en la clase y subclase
    protected val terror = "Frankenstein" // Visible en la clase y subclase
}

class SubClaseLibro : Libro() {
    override var entrada: Double = 35.5
    override val ultimaVocal: String = "U"
    override var emprendimiento: String = "Metodo Lean Startup"
}

/*
  // No es posible declararlos en niveles superiores
protected val nombre = "Cris"
protected fun declaracionImpuestos() {}
protected class AnimalesDeCasa { private val nombre: String = "Perro" }
*/


/* modificador internal */
internal const val DULCE = "CARAMELO" // Estara visible en el módulo actual
internal class ModificadorInternal {
    internal val a = 'A'
    internal var vocal: String = ""
}
internal fun requesitos() { }

fun main() {

    // modificador private
    println(marathon(5.0)) // Recorrió 5.0 km
    /* Escuela().nombreEstudiante */ // Error: propiedad privada no es posible instanciarla, desde afuera.
    Visibilidad() // Es posible declararlo en el mismo archivo
    /* Visibilidad().esVisible */ // Error: No es posible declararlo, es private
    /* private var coloresDelEcuador: List<String> = emptyList() */ // Error: Es una variable local, no tiene modificadores.

    println("-------------------------------------------------------------------------------")

    // modificador public
    println(suma(5,5)) // 10
    println("Cual es el tercer planeta del sistema solar: $TERCER_PLANETA")
    /* public fun modifiers() {} */ // Error: Es una variable local, no tiene modificadores.

    println("-------------------------------------------------------------------------------")

    // modificador protected
    val libro = Libro()
    println(libro.entrada) // 15.5
    println(libro.ultimaVocal) // u
    /* libro.bonusEvento */ // Error: Es private, no es visible
    /* libro.emprendimiento = "Creativity" */ // Error: Es protected, no es visible

    println("-------------------------------------------------------------------------------")

    val subLibro = SubClaseLibro()
    println(subLibro.entrada) // 35.5
    println(subLibro.ultimaVocal) // U
    /* subLibro.emprendimiento = "Creativity" */ // Error: Es protected, no es visible

    println("-------------------------------------------------------------------------------")

    //modificador internal
    println(DULCE) // CARAMELO
    val modificadorInternal = ModificadorInternal()
    println(modificadorInternal.a) // A
    modificadorInternal.vocal = "B"
    println(modificadorInternal.vocal) // B
}