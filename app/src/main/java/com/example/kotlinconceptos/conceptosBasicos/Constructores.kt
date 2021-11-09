package com.example.kotlinconceptos.conceptosBasicos

/*
        CONSTRUCTORES

    • Constructor Primario o Principal
        - Forma parte del encabezado de la clase y va tras el nombre de la clase y los tipos de parámetros son opcionales.
        - Si el constructor principal no tiene anotaciones ni modificadores de visibilidad, se puede omitir la palabra
          clave constructor, caso contrario se debe ingresar.
        - Las variables val o var en el constructor primario, crea propiedades automáticas que permite ser referenciadas,
          en un futuro por medio de su tipo de nombre.
        - Bloque init es un inicializador adicional que se llama después del constructor principal, para poder contener
          código y además puede tener uno o varios init.

    • Constructor Secundario
        - Puede declararse un constructor secundario, con la palabra clave constructor, en el interior de la clase.
        - El cuerpo del constructor secundario se llama después del bloque init.
        - Si la clase tiene un constructor primario, cada constructor secundario debe delegar en el constructor primario,
          ya sea directa o indirectamente a través de otro constructor secundario. La delegación a otro constructor de la
          misma clase se realiza utilizando la palabra clave: this
        - En los parámetros del constructor secundario, no está permitido ingresar variables val y var.
 */

// Constructor Primario
class Datos internal constructor(_nombre: String = "Jorge", _apellido: String) {
    val nombre = _nombre.uppercase()
    val apellido: String = _apellido.uppercase()
    private var edad: Int = 25

    // Bloque init
    init {
        print("Los datos son los siguientes: ") // 1 Ejecutarse
    }

    // Constructor secundario
    constructor(nombre: String, apellido: String, edad: Int) : this(nombre, apellido) {
        this.edad = edad
    }

    init {
        print("La edad es: ${edad.inc()}, ") // 2 Ejecutarse
    }
}

fun main() {
    val datos = Datos("Luis", "Orellana")
    // 3 Ejecutarse
    println("Nombre: ${datos.nombre} y Apellido: ${datos.apellido}") // Los datos son los siguientes: La edad es: 26, Nombre: LUIS y Apellido: ORELLANA
}