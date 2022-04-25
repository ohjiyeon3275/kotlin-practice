package com.jiyeon.kotlinproject.extrapractice.kotlinstuudy

fun main(){

    data class PersonData(val name: String, val age:Int)

    val personData1 = PersonData("ji", 25)

    println(personData1.component1()) // ji -- component 순서로 호출가능
    println(personData1.component2()) // 25

    println(personData1.name) //ji



    val personData2 = PersonData("oh", 30)
    val(name, age) = personData2 // ? 구조분해할당?

    println(name) // oh
    println(age) // 30

}