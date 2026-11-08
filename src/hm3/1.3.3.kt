package HW3

import kotlin.random.Random

fun main() {
    val originalArray = Array(100) { Random.nextInt(-100, 101) }

    // Послідовні перетворення
    val processed = originalArray
        .filter { it > 0 }             // лише додатні числа
        .filter { it % 5 == 0 }        // діляться на 5
        .map { it * it }               // Підносимо до квадрату
        .sortedDescending()            // Сортуємо

    if (processed.isNotEmpty()) {
        println("Найбільше число: ${processed.first()}")
        println("Найменше число: ${processed.last()}")
    } else {
        println("Колекція після фільтрації порожня.")
    }

    val stringList: List<String> = processed.map { it.toString() }

    val resultString = stringList.joinToString(separator = " ")
    println("Результатний рядок: $resultString")
}