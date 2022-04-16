package com.jiyeon.kotlinproject.kotlinstuudy

sealed class Employee

data class Manager(val name: String, val age: Int, val team: List<String>): Employee()
class SeniorDev(val name: String, val age: Int, val projects: Int): Employee()
object JuniorDev: Employee()