package com.jiyeon.kotlinproject.extrapractice.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun runBlockingExecute() {
    runBlocking {
        launch {
            log("runBlocking executed")
        }
    }
}

/**
 *
20:46:48.209:Thread[main,5,main]:>>>>> main
20:46:48.340:Thread[main,5,main]:>>>>> globalScope
20:46:48.361:Thread[DefaultDispatcher-worker-1,5,main]:coroutine started
20:46:48.374:Thread[main,5,main]:global launch started
20:46:48.375:Thread[main,5,main]:>>>>> main ended
 */


fun yieldRunBlocking() {
    runBlocking {
        launch {
            log("1>>")
            yield()
            log("3>>>")
            yield()
            log("5>>>")
        }

        log("after 1st launch run")

        launch {
            log("2")
            delay(1000L)
            log("4")
            delay(1000L)
            log("6")
        }

        log("after 2nd launch run")

    }
}

/**
 *
20:51:47.414:Thread[main,5,main]:>>>>> main
20:51:47.545:Thread[main,5,main]:>>>>> globalScope
20:51:47.566:Thread[DefaultDispatcher-worker-2,5,main]:coroutine started
20:51:47.571:Thread[main,5,main]:after 1st launch run
20:51:47.578:Thread[main,5,main]:after 2nd launch run
20:51:47.578:Thread[main,5,main]:1>>
20:51:47.579:Thread[main,5,main]:2
20:51:47.586:Thread[main,5,main]:3>>>
20:51:47.586:Thread[main,5,main]:5>>>
20:51:48.588:Thread[main,5,main]:4
20:51:49.594:Thread[main,5,main]:6
20:51:49.596:Thread[main,5,main]:>>>>> main ended

 which means :  1. launch -> instantly returned
                2. runBlocking is the last one executed
                3. ...... the order of delay and yield.
 */