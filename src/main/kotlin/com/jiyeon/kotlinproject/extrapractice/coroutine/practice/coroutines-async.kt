package com.jiyeon.kotlinproject.extrapractice.coroutine.practice

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO


private suspend fun first() : Long{
    println("1st function started")
    println(Thread.currentThread().name)
    delay(1000L)
    println("1st function ended")
    return 1L
}

private suspend fun second(long: Deferred<Long>) : String{
    println("2nd function started")
    println(Thread.currentThread().name)
    delay(2000L)
    println("2nd function ended")

    if(long.await()===1L){
        return "success!"
    }

    return "nope"
}

private suspend fun third(str: Deferred<String>) {
    println("3rd function started")
    println(Thread.currentThread().name)
    delay(1500L)
    println("3rd function ended")
    println("done! ${str.await()}")
}

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()

    val firstVal = async(IO) {
        first()
    }


    val secondVal1 = async(IO) {
        second(firstVal)
    }

    third(secondVal1)
    println(System.currentTimeMillis() - startTime)

}


