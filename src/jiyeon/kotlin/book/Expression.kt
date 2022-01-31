package jiyeon.kotlin.book

import java.lang.IllegalArgumentException

interface Expression {
    class Number(val value: Int) :Expression
    class SumNumber(val leftNum: Expression, val rightNum: Expression) : Expression

}

fun eval(e: Expression) : Int {

    /**
     * is는 instanceOf 와 비슷함. 타입검사 typeOf()
     */

    if(e is Expression.Number){
//        val n = e as Expression.Number --> 스마트 캐스팅 기능 덕에 이 부분은 주석처리해도 안해도 작동한다.
        return e.value
    }

    /**
     * e 가 Expression의 SumNumber임을 확인해서 if함수로 들어가면
     * 컴파일러는 자동으로 e를 캐스팅 없이도 해당 객체로 인식한다.
     *  --> 스마트 캐스팅기능 (인텔리제이에서는 배경색도 달라짐)
     */
    if(e is Expression.SumNumber){
        return eval(e.rightNum) + eval(e.leftNum)
    }

    /**
     * 스마트 캐스팅은 그 값이 바뀔 수 없는 경우에만 작동한다 (-- val 변수)
     */

    //(스마트 x) 일반적인(o) 캐스팅은 as를 사용하면 된다.
    val n = e as Expression.Number

    throw IllegalArgumentException("no expression exist")
}

// fun eval함수를 1) return값이 없는 if~else if문, 2) when문 으로도 리팩토링 가능하다.