package com.example.kotlinconceptos.conceptosBasicos

/*
        INTERFACE

    - Las interfaces en kotlin pueden contener declaraciones de métodos abstractos, así como implementaciones de métodos.
    - Por definición las interfaces son abstractas y se sobrescriben con el modificador override si sus propiedades o
      métodos no son regulares.
    - Tiene similitud con las abstract class, solo que las interfaces no permiten almacenar estados, es decir no
      permite constructores.
    - Puede contener métodos abstractos y métodos regulares con implementación.
    - Puede contener propiedades abstractas y propiedades regulares, pero sin campos de respaldo.
    - Una clase u objeto puede implementar una o más interfaces. Además, una interface puede derivar de otra interface.
    - Si existen múltiples interfaces que tienen el mismo nombre del método, puede sobrescribirlo en la clase
      correspondiente implementando la siguiente palabra clave para poder llamarlo, super<Tipo de interface> seguido
      del nombre del cual se sobrescribió.
 */

interface Figura {
    fun calcularSuperficie(): Int // Método abstracto
    fun calcularPerimetro(): Int // Método abstracto
    fun tituloResultado() { // Método Regular
        println("El resultado final")
    }
}

class Cuadrado(private val lado: Int): Figura {
    override fun calcularSuperficie() = lado * lado

    override fun calcularPerimetro() = lado * 4
}

class Rectangulo(private val ladoMayor:Int, private val ladoMenor: Int): Figura {
    override fun calcularSuperficie() = ladoMayor * ladoMenor

    override fun calcularPerimetro() = (ladoMayor * 2) + (ladoMenor * 2)
}

interface Explosivo {
    fun explosivo() // Método abstracto
    fun advertencia() { // Método regular
        println("Precaución puede producirse una explosión")
    }
}

interface Extintor {
    fun extintor() // Método abstracto
    fun advertencia() { // Método regular
        println("Extintor vacío!")
    }
}

class Emergencia : Explosivo, Extintor { // Llama a 2 interface
    override fun explosivo() = println("Cuenta regresiva...")

    override fun extintor() = println("Extintor lleno, es ahora!")

    // super<> llama a la interface que se va ejecutar.
    override fun advertencia() {
        super<Explosivo>.advertencia()
        super<Extintor>.advertencia()
    }
}

fun main() {
    val cuadrado = Cuadrado(5)
    cuadrado.tituloResultado() // El resultado final
    println("Perimetro del cuadrado: ${cuadrado.calcularPerimetro()}") // Perimetro del cuadrado: 20
    println("Superficie del cuadrado: ${cuadrado.calcularSuperficie()}") // Superficie del cuadrado: 25

    println("-------------------------------------------------------------------------------")

    val rectangulo = Rectangulo(6, 4)
    rectangulo.tituloResultado() // El resultado final
    println("Perimetro del rectangulo: ${rectangulo.calcularPerimetro()}") // Perimetro del rectangulo: 20
    println("Superficie del rectangulo: ${rectangulo.calcularSuperficie()}") // Superficie del rectangulo: 24

    println("-------------------------------------------------------------------------------")

    val emergencia = Emergencia() // Herencia 2 interface
    emergencia.advertencia() // Se ejecuta el resultado de las 2 funciones
    emergencia.explosivo() // Cuenta regresiva...
    emergencia.extintor() // Extintor lleno, es ahora!
}