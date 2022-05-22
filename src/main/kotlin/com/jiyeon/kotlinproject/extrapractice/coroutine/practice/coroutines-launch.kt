package com.jiyeon.kotlinproject.extrapractice.coroutine.practice

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO


private suspend fun first() : Long{
    println("1st function started")
    delay(1000L)
    println("1st function ended")
    return 1L
}

private suspend fun second(job: Job) : String{
    println("2nd function started")
    delay(2000L)
    println("2nd function ended")

    println("${job.children}")
    return "nope"
}

private suspend fun third(job :Job) {
    println("3rd function started")
    delay(1500L)
    println("3rd function ended")
    println("done! ${job.children}}")
}

fun main() = runBlocking {

    val startTime = System.currentTimeMillis()

    val firstVal = launch(IO) {
        first()
    }


    val secondVal1 = launch(IO) {
        second(firstVal)
    }

    third(secondVal1)
    println(System.currentTimeMillis() - startTime)


}



