package ex2

data class EmployeeData(
    val firstName: String,
    val lastName: String,
    val position: String
) {
    var bonus: Int = 0
}

fun main() {
    val emp1 = EmployeeData("Дюк", "Побитайло", "Backend Developer")
    val emp2 = EmployeeData("Дюк", "Побитайло", "Backend Developer")

    println("=== Part2: Power of Data Class ===")

    println("emp1: $emp1")
    println("emp1 == emp2  (значення):   ${emp1 == emp2}") // true
    println("emp1 === emp2 (посилання):  ${emp1 === emp2}") // false

    val (name, surname, pos) = emp1
    println("Unpacked: $name $surname, посада: $pos")

    val promoted = emp1.copy(position = "Team Lead")
    println("After .copy(): $promoted")

    val empA = EmployeeData("Тарас", "Петренко", "QA").apply { bonus = 1000 }
    val empB = EmployeeData("Тарас", "Петренко", "QA").apply { bonus = 5000 }
    println("empA == empB with different bonuses: ${empA == empB}") // true
}