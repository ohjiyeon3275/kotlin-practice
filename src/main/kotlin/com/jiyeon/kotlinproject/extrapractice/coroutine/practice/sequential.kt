package com.jiyeon.kotlinproject.extrapractice.coroutine.practice


private fun first() : Long{
    println("1st function started")
    Thread.sleep(1000L)
    println("1st function ended")
    return 1L
}

private fun second(num : Long) : String{
    println("2nd function started")
    Thread.sleep(2000L)
    println("2nd function ended")

    if(num != 1L){
        return "no"
    }

    return "2"
}

private fun third(str: String) : Boolean{
    println("3rd function started")
    Thread.sleep(1500L)
    println("3rd function ended")

    return str === "2"
}

fun main(){
    val startTime = System.currentTimeMillis()

    val firstVal = first()
    val secondVal = second(firstVal)
    println(third(secondVal))

    println(System.currentTimeMillis() - startTime)
}