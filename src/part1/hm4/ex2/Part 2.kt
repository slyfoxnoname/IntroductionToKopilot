package hm4.ex2

// Частина 2: Можливості data class у Kotlin
data class EmployeeData(
    val firstName: String,
    val lastName: String,
    val position: String
) {
    // Поле в тілі класу не бере участі в автогенерованих equals, hashCode, toString та copy
    var bonus: Int = 0
}

fun main() {
    println("=== Частина 2: Можливості data class EmployeeData ===")

    val emp1 = EmployeeData("Андрій", "Мельник", "Backend Developer")
    val emp2 = EmployeeData("Андрій", "Мельник", "Backend Developer")

    println("Вивід emp1: $emp1")
    println("Структурна рівність (emp1 == emp2):  ${emp1 == emp2}")   // true
    println("Референційна рівність (emp1 === emp2): ${emp1 === emp2}") // false

    // Деструктуризація об'єкта
    val (firstName, lastName, role) = emp1
    println("Деструктуризація: ім'я = $firstName, прізвище = $lastName, посада = $role")

    // Копіювання зі зміною посади
    val promotedEmp = emp1.copy(position = "Tech Lead")
    println("Копія після підвищення: $promotedEmp")

    // Перевірка впливу поля bonus, оголошеного поза основним конструктором
    val qaJunior = EmployeeData("Ірина", "Савченко", "QA Engineer").apply { bonus = 1500 }
    val qaSeniorBonus = EmployeeData("Ірина", "Савченко", "QA Engineer").apply { bonus = 4500 }
    println("Порівняння об'єктів з різними бонусами (qaJunior == qaSeniorBonus): ${qaJunior == qaSeniorBonus}") // true
}
