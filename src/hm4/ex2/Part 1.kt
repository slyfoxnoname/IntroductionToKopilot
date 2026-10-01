package HW4.ex2

class Employee(
    val firstName: String,
    val lastName: String,
    val position: String
)

fun main() {
    println("Part1: Problem of the STD")

    val emp1 = Employee("Polis", "Lopen", "Backend Developer")
    val emp2 = Employee("Polis", "Lopen", "Backend Developer")
    val emp3 = emp1

    println("emp1: $emp1")

    println("Comparing of emp1 and emp2")
    println("emp1 === emp2 (by the linking): ${emp1 === emp2}") // false
    println("emp1 == emp2 (by the value): ${emp1 == emp2}") // false

    println("Comparing of emp1 and emp3")
    println("emp1 === emp3 (by the linking): ${emp1 === emp3}") // true
    println("emp1 == emp3 (by the value): ${emp1 == emp3}") // true

}