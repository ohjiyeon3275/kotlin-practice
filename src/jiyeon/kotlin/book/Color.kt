package jiyeon.kotlin.book

enum class Color (var r: Int, var g: Int, var b:Int){
    RED(255, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255); //<- here is the only use of ; in kotlin

    fun rgbSum() = r+g+b

    /**
     *  getTextValue() 함수를 여기다 쓰면 작동하지 않는다.
     *  혹은 불러올때 Color.RED.getTextValue(Color.RED)로 해야하는데
     *  전자의 RED는 아무 enum으로 사용해도 상관없다.
     */

}
