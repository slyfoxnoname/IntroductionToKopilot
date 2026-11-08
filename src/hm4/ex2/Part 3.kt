package ex2

fun main() {
    val emp1 = ManualEmployee("Дюк", "Побитайло", "Backend Developer")
    val emp2 = ManualEmployee("Дюк", "Побитайло", "Backend Developer")

    println("Part3: What the compiler hides (ManualEmployee)")

    println("emp1: $emp1")

    println("emp1 == emp2  (Structure of equality): ${emp1 == emp2}")  // true
    println("emp1 === emp2 (equality of links):   ${emp1 === emp2}") // false

    println("emp1.hashCode() == emp2.hashCode(): ${emp1.hashCode() == emp2.hashCode()}") // true

    val (name, surname, pos) = emp1
    println("Deconstruction: $name $surname, посада: $pos")

    val promoted = emp1.copy(position = "Team Lead")
    println("After own .copy(): $promoted")

    val empA = ManualEmployee("Тарас", "Петренко", "QA").apply { bonus = 100 }
    val empB = ManualEmployee("Тарас", "Петренко", "QA").apply { bonus = 900 }
    println("empA == empB with equally bonus: ${empA == empB}") // true
}