package com.jiyeon.kotlinproject.extrapractice.coroutine

fun main() {
    var num = 4
    var isEven = isEven(num)
    println(isEven)
    num = 9
    println(isEven)
}

fun isEven(n: Int):Boolean = ((n%2) == 0 )