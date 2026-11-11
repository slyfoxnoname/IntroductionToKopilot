package hm3

import kotlin.random.Random

fun main() {
    // 1. Генеруємо масив зі 100 випадкових цілих чисел у діапазоні [-100..100]
    val randomNumbers = Array(100) { Random.nextInt(-100, 101) }

    // 2. Застосовуємо ланцюжок функціональних перетворень
    val transformedNumbers = randomNumbers
        .filter { it > 0 && it % 5 == 0 }
        .map { it * it }
        .sortedDescending()

    // 3. Виводимо екстремуми отриманої колекції
    if (transformedNumbers.isNotEmpty()) {
        println("Максимальний елемент: ${transformedNumbers.first()}")
        println("Мінімальний елемент:  ${transformedNumbers.last()}")
    } else {
        println("Не знайдено жодного додатного числа, кратного 5.")
    }

    // 4. Перетворюємо числа на список рядків та об'єднуємо їх через пробіл
    val textElements: List<String> = transformedNumbers.map(Int::toString)
    val joinedLine = textElements.joinToString(separator = " ")
    println("Результуючий рядок: $joinedLine")
}
