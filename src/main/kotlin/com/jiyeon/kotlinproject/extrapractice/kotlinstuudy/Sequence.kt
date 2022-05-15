package com.jiyeon.kotlinproject.extrapractice.kotlinstuudy


fun main() {

    var newlist = listOf("b", "a", "c", "d").asSequence()
        .map{
            it.plus("p")
        }
        .first{
            it.startsWith("a")
        }

    println(newlist)


}