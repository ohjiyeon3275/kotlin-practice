package jiyeon.kotlin.book

class Collection {

    /**
     * 코틀린에서 컬렉션(Set, List, Map 등)은 자바의 그것들과 동일하다.
     * 다만, 추가된 기능이 몇가지 있다
     */
}


@JvmOverloads
fun main() {

    var list = listOf(1, 2, 3)
    println(list) //[1, 2, 3] -- toString기능 자동 지원


    /**
     * 자바의 collection 기능들을 가져 올 수 있는데 이때
     * 오버로딩한 함수들을 전부 가져오게 하는 어노테이션을 사용 할 수 있다. @JvmOverloads - 메인함수에 달아둠
     * ex) listIterator 함수는
     *     1) - ListIterator<E> listIterator();
     *     2) - ListIterator<E> listIterator(int index);
     *     둘다 자동 으로 가져옴
     */

    println(list.listIterator(1));
    println(list.listIterator(2))
}