package hm4.ex2

fun main() {
    println("=== Частина 3: Перевірка власної реалізації ManualEmployee ===")

    val emp1 = ManualEmployee("Андрій", "Мельник", "Backend Developer")
    val emp2 = ManualEmployee("Андрій", "Мельник", "Backend Developer")

    println("Вивід emp1: $emp1")
    println("Структурна рівність (emp1 == emp2):  ${emp1 == emp2}")   // true
    println("Референційна рівність (emp1 === emp2): ${emp1 === emp2}") // false
    println("Збіг хеш-кодів: ${emp1.hashCode() == emp2.hashCode()}")   // true

    val (firstName, lastName, role) = emp1
    println("Деструктуризація ManualEmployee: $firstName $lastName -> $role")

    val promoted = emp1.copy(position = "Solution Architect")
    println("Результат виклику власного copy(): $promoted")

    val firstWithBonus = ManualEmployee("Ірина", "Савченко", "QA Engineer").apply { bonus = 1000 }
    val secondWithBonus = ManualEmployee("Ірина", "Савченко", "QA Engineer").apply { bonus = 7000 }
    println("Рівність при різних значеннях bonus: ${firstWithBonus == secondWithBonus}") // true
}
