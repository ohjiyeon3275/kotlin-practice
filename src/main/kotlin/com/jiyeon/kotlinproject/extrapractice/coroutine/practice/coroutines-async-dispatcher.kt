package com.jiyeon.kotlinproject.extrapractice.coroutine.practice

import kotlinx.coroutines.*


private suspend fun first() : Long{
    println("1st function started")
    delay(1000L)
    println("1st function ended")
    return 1L
}

private suspend fun second(long: Deferred<Long>) : String{
    println("2nd function started")
    delay(2000L)
    println("2nd function ended")

    if(long.await()===1L){
        return "success!"
    }

    return "nope"
}

private suspend fun third(str: Deferred<String>) {
    println("3rd function started")
    delay(1500L)
    println("3rd function ended")
    println("done! ${str.await()}")
}

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()

    val customDispatcher1 = newSingleThreadContext("myDispatcher")
    val firstVal1 = async(customDispatcher1) {
        println(customDispatcher1)
        first()
    }


    val secondVal1 = async(customDispatcher1) {
        second(firstVal1)
    }

    third(secondVal1)


    val customDispatcher2 = newSingleThreadContext("yourDispatcher")
    val firstVal2 = async(customDispatcher2) {
        println(customDispatcher2)
        first()
    }


    val secondVal2 = async(customDispatcher2) {
        second(firstVal2)
    }

    third(secondVal2)


    println(System.currentTimeMillis() - startTime)


}


