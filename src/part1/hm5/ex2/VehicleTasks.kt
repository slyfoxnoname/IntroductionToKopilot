package hm5.ex2

data class Vehicle(
    var brand: String = "",
    var model: String = "",
    var year: Int = 0,
    var licensePlate: String = ""
)

fun main() {
    // Частина 1: Ініціалізація об'єкта через apply та логування через also
    val vehicle = Vehicle().apply {
        brand = "Toyota"
        model = "Camry"
        year = 2023
        licensePlate = "АА7788КІ"
    }.also { initializedVehicle ->
        println("Зареєстровано транспортний засіб: $initializedVehicle")
    }

    println()

    // Частина 2: Форматований вивід характеристик за допомогою with
    with(vehicle) {
        println("Картка транспортного засобу:")
        println("  Марка          : $brand")
        println("  Модель         : $model")
        println("  Рік випуску    : $year")
        println("  Номерний знак  : $licensePlate")
    }
}
