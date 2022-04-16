package com.jiyeon.kotlinproject.kotlinstuudy


fun main() {

    val employee: Employee = SeniorDev("seniory",20, 10 )

    val message : String = when(employee) {
        is Manager -> {
            "매니저 !-!"
        }
        is SeniorDev -> {
            "시니어 >_< "
        }
        is JuniorDev -> {
            "주니어 ~_~"
        }
    }

    println(message)

}