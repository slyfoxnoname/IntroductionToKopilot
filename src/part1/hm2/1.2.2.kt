package hm2

import java.util.Locale

// Завдання: На вхід подається дійсне число. Вивести його з n знаками після коми.
fun formatDecimal(value: Double, decimals: Int): String {
    require(decimals >= 0) { "Кількість знаків після коми не може бути від'ємною" }
    return String.format(Locale.US, "%.${decimals}f", value)
}

fun main() {
    val inputNumber = 3.1415926535
    val precision = 3

    println(formatDecimal(inputNumber, precision))
}
