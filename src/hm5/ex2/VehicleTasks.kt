package HW5.ex2

data class Vehicle(
    var brand: String = "",
    var model: String = "",
    var year: Int = 0,
    var licensePlate: String = ""
)

fun main() {
    val car = Vehicle().apply {
        brand = "Honda"
        model = "Civic"
        year = 2020
        licensePlate = "КА3344ВІ"
    }.also {
        println("Створено новий транспортний засіб: $it")
    }

    println()

    // Part2: Formated output (with)
    with(car) {
        // Context object 'this'
        println("Марка = $brand")
        println("Модель = $model")
        println("Рік випуску: $year")
        println("Номерний знак: $licensePlate")
    }
}