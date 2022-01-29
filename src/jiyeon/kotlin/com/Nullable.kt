package jiyeon.kotlin.com


fun main(args: Array<String>) {

    val str: String? = "str is not null"


    //in this case below, there is yellow line
    // which alerts this could not be efficient.
    if( str != null ){
        //this also is smart-cast
        str.uppercase()
    }

    val nulldy: String? = null
    //so try this
    println("this is more Kotlinic way : ${nulldy?.toUpperCase()}")


}