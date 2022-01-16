data class Person(val name : String,
                    val age : Int? = null)

fun main(args: Array<String>){
    val persons = listOf(Person("젼"),
                        Person("져니", 29))

    val cutest = persons.maxByOrNull { it.age ?: 0 }

    println("the cutest is : $cutest ")

}