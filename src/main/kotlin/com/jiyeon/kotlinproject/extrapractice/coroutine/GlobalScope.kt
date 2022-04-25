package com.jiyeon.kotlinproject.extrapractice.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

fun now() = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.MILLIS)

fun log(msg:String) = println("${now()}:${Thread.currentThread()}:${msg}")

fun globalScope(){
    GlobalScope.launch {
        log("coroutine started")
    }
}

fun main() {
    log(">>>>> main")
    globalScope()
    log(">>>>> globalScope ")
//    Thread.sleep(5000L)
//    runBlockingExecute()
    yieldRunBlocking()
    log(">>>>> main ended")

    /**
     * log>>
    20:35:14.570:Thread[main,5,main]:>>>>> main
    20:35:14.715:Thread[main,5,main]:>>>>> globalScope
    20:35:14.735:Thread[DefaultDispatcher-worker-1,5,main]:coroutine started
    20:35:19.722:Thread[main,5,main]:>>>>> main ended
     *
     * things to be aware
     *
     * 1. coroutine thread is different from main thread
     * 2. if main() ended before coroutine executed, the coroutine one is never run
     *    because main() is on 'Synchronized'
     *  2-1. to prevent 2 happens, added Thread.sleep(5000L) or runBlocking
     *  2-2. or use Asynchronized : CoroutineScope
     */
}