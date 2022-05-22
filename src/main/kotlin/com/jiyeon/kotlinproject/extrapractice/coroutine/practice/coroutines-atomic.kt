package com.jiyeon.kotlinproject.extrapractice.coroutine.practice

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.util.concurrent.atomic.AtomicInteger


private suspend fun first() : Long{
    println("1st function started $")
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

    val counter = AtomicInteger()

    fun asyncIncrement(by: Int) = async {
        for (i in 0 until by) {
            counter.incrementAndGet()
        }
    }


    val firstVal = async(IO) {
        first()
    }


    val secondVal1 = async(IO) {
        second(firstVal)
    }

    third(secondVal1)
    println(System.currentTimeMillis() - startTime)


}


