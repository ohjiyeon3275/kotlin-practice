package jiyeon.kotlin.book

import jiyeon.kotlin.book.Expression.*

class ExpressionTest {

}

fun main() {
    println(eval(SumNumber(Number(2), SumNumber(Number(3), Number(5)))))
}