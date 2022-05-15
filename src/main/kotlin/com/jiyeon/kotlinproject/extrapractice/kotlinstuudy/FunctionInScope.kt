package com.jiyeon.kotlinproject.extrapractice.kotlinstuudy



    private var number: Int? = null


    fun main() {

        val x = number?.let {
            val number2 = it + 2
        }

        val y = number?.let {
            val number2 = it + 2
            number2
        }

        val z = number?.let {
            val number2 = it + 2
            number2
        } ?: 10


        var price = 5000

        var buk = Book("췍췍", 10000)

        var book = Book("책", 20000).apply {
            name = "[할인]"+ name
            discount()
        }
        println(book.name)
        println(book.price)

        book.run{
            println("상품명 ${name}, 가격 ${price}")
        }

        var boo = book.let{
            println("상품명 ${it.name}, 가격 ${it.price}")
        }

        println("boo $boo")

        var applyBook = Book("책", 20000).also {
            it.name = "[할인]"+ it.name
            it.discount()
            println(it.name)
            println(it.price)
        }

        var withBook = Book("myBook", 9999)
        with(withBook) {
            println("~~~")
            println(name)
            println(price)
        }



    }

    private var i = 0

    fun getSquaredI() = (i * i).also{ i++ }





    class Book(var name: String, var price : Int){

        companion object {
            fun getNumber(){
                println("999999")
            }
        }
        fun getName() {
            name = name + ": "
        }
        fun discount(){
            price -= 2000
        }
    }

