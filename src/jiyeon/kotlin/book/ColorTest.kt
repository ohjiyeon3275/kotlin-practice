package jiyeon.kotlin.book

import java.lang.Exception

// import jiyeon.kotlin.book.Color.*

fun getTextValue(color: Color) =
    when(color) {
        Color.RED -> "Red text"
        Color.BLUE -> "Blue text"
        else -> "else text"
    }

fun getMultiValue(color: Color) =
    when(color){
        Color.RED, Color.YELLOW -> "Warm colors, just like me"
        Color.GREEN -> "my fav color"
        Color.BLUE -> "blue color";
    }

/**
 * import를 하면 당연히 Color.RED -> RED로 가능
 */

//fun getValueShorter(color: Color) =
//    when(color){
//        RED, YELLOW -> "shorter warm color";
//        else -> "else color"
//    }

/**
 * 아래와 같은 getSetOfValue함수를 사용하면 set 인스턴스를 생성해서
 * 불필요한 가비지객체가 늘어난다.
 * 따라서 조금 길어지더라도 && || 를 사용한 조건문으로 when 문을 사용하는게 낫다.
 */

fun getSetOfValue(c1: Color, c2: Color)=
    when (setOf(c1, c2)){
        setOf(Color.RED, Color.YELLOW) -> "setOf color value"
        setOf(Color.GREEN) -> "this is green"
        else -> throw Exception("other colors")
    }

fun main() {
    println(getTextValue(Color.RED))
    println(getMultiValue(Color.YELLOW))
//    println(getValueShorter(Color.RED))
    println(getSetOfValue(Color.RED, Color.YELLOW)) //setOf color value
    println(getSetOfValue(Color.GREEN, Color.YELLOW)) //throw exception
}
