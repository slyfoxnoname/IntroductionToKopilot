package hm4.ex2

// Частина 1: Стандартний клас без перевизначення методів Any
class Employee(
    val firstName: String,
    val lastName: String,
    val position: String
)

fun main() {
    println("=== Частина 1: Поведінка звичайного класу Employee ===")

    val firstEmployee = Employee("Андрій", "Мельник", "Backend Developer")
    val secondEmployee = Employee("Андрій", "Мельник", "Backend Developer")
    val sameReferenceEmployee = firstEmployee

    println("Рядкове представлення firstEmployee: $firstEmployee")

    println("\nПорівняння firstEmployee та secondEmployee (різні об'єкти з однаковими полями):")
    println("  Референційна рівність (===): ${firstEmployee === secondEmployee}") // false
    println("  Структурна рівність  (==) : ${firstEmployee == secondEmployee}")  // false

    println("\nПорівняння firstEmployee та sameReferenceEmployee (одне й те саме посилання):")
    println("  Референційна рівність (===): ${firstEmployee === sameReferenceEmployee}") // true
    println("  Структурна рівність  (==) : ${firstEmployee == sameReferenceEmployee}")  // true
}
