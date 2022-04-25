package com.jiyeon.kotlinproject.extrapractice.coroutine

import kotlin.concurrent.thread


fun main() { // executed in main thread

    println("${Thread.currentThread().name}")

    thread { // create worker thread
        println("thread start : ${Thread.currentThread().name}")
        Thread.sleep(1000) // just like something is working...
        println("thread end : ${Thread.currentThread().name}")
    }

    println("${Thread.currentThread().name}")



}