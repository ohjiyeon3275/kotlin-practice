package com.jiyeon.kotlinproject.extrapractice.kotlinstuudy

fun main() {
    val declaration = Declaration()
    println(declaration.getName()) // not init yet

    declaration.setName("now initialized")
    println(declaration.getName()) //now initialized
}

class Declaration {
    lateinit var myName: String

    fun setName(name: String) {
        myName = name
    }

    fun getName() = if (::myName.isInitialized) myName else "not init yet"
}