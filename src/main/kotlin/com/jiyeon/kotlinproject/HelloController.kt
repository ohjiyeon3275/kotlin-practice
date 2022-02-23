package com.jiyeon.kotlinproject

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/hello")
class HelloController {

    @GetMapping("/jiyeon")
    fun helloJiyeon(): String{
        return "Hello, this is jiyeon :D "
    }

    // also ok
    @GetMapping("/world")
    fun helloWorld(): String = "Hello this is world :D"
}