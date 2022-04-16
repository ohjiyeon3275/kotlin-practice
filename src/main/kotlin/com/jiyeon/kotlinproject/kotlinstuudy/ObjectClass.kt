package com.jiyeon.kotlinproject.kotlinstuudy


fun main() {

    var visitA = Visitor("A")
    var visitB = Visitor("B")

    visitA.numUp()
    visitA.numUp()

    visitB.numUp()

    println("${visitA.num} ${visitB.num} ${Visitor.totalVisitor}")
    // 2 1 3
}

class Visitor (val where: String){
    companion object {
        var totalVisitor = 0
    }

    var num = 0

    fun numUp(){
        num++
        totalVisitor++
    }

}