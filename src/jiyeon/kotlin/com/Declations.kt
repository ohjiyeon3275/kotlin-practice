package jiyeon.kotlin.com

typealias EmployeeSet = Set<Employee>


fun main(args: Array<String>) {
    //'final' variable in Java == var
    var number = 10 // final int number = 10;
    var intNumber:Int // final int intNumber;
    var intNumberInit:Int = 10 // final int number = 10;

    var shortNumber:Short = 10 //final short shortNumber = 10;
    shortNumber = 30 // var -> mutable

    val cantChangeNumber:Int;
    cantChangeNumber = 20
//    cantChangeNumber = 30 error! val -> immutable

    val employee1 = Employee("Jiyeon", 100)
    employee1.name = "Ji-Yeon"
    // employee1 = Employee("not allowed", 20)
    val employee2: Employee
    val number2 = 900

    if(number < number2){
        employee2 = Employee("??", 111)
    }
    else{
        employee2 = Employee("!!", 222)
    }

    //typealias
    val employees: EmployeeSet

}

class Employee(var name: String, val id: Int){

}