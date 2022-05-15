package com.jiyeon.kotlinproject.extrapractice.kotlinstuudy


fun main(){

    var list = listOf("1", 2, 3.0, "four")

    list.filter{ it == "1" }


    fun reformat(
        divideByCamelHumps: Boolean,
        str: String = "!!",
        normalizeCase: Boolean = true,
        upperCaseFirstLetter: Boolean = true,
        wordSeparator: Char = ' ',
    ) { /*...*/ }

    println(reformat(true)) // 이건 됨

    fun varargsFunc(vararg x: Array<Int>){
        println(x[0][1])
        println(x[1][2])
    }

    fun normalFunc(x: Array<Int>) {
        println(x[0])
    }

    val xList = listOf(1, 11, 2)
    val xArray = arrayOf(1, 2, 3)
    val zArray = arrayOf(4, 5, 6)

    varargsFunc(xArray, zArray)
    normalFunc(xArray)



}
