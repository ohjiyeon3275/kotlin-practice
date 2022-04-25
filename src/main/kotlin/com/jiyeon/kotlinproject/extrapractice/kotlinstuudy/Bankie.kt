package com.jiyeon.kotlinproject.extrapractice.kotlinstuudy

data class Bankie(val id: Long, val name: String)

/**
 *
 * data class의 프로퍼티를 var이 아닌 val로 사용 하면 데이터의 신뢰성을 높일 수 있다.
 * 클래스를 호출 후 데이터를 변경하는 경우에는 .copy()를 사용해서
 * 복사본을 만들어 구현한다.
 */

