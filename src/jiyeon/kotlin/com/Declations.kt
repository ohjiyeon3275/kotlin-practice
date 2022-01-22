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

    //arrayListOf
    val names = arrayListOf("aaa", "bbb", "ccc")
    println(names[2])

    // typealias
    val employees: EmployeeSet

    // equality
    val employeeOne = Employee("M", 1)
    val employeeTwo = Employee("J", 2)
    val employeeThree = Employee("J", 2)

    println(employeeOne === employeeTwo) //false
    println(employeeTwo === employeeThree) //false
    println(employeeOne == employeeTwo) //false
    println(employeeTwo == employeeThree) //true

    val employeeFour = employeeTwo
    println(employeeFour === employeeTwo) //true

    println(employeeFour != employeeTwo) //false
    println(employeeFour !== employeeTwo) //false
    println(employeeTwo != employeeThree) //false
    println(employeeTwo !== employeeThree) //true

}

class Employee(var name: String, val id: Int){

    override fun equals(obj: Any?) : Boolean {
        if(obj is Employee){
            return name == obj.name && id == obj.id
        }
        return false
    }
}