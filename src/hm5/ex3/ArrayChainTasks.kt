package HW5.ex3

import kotlin.random.Random

// 1. Input data and auxiliary structures
data class ArraySummary(
    val maxElement: Int,
    val elementsOverLimit: Int,
    val totalSum: Int
)

fun generateRandomArray(size: Int, maxValue: Int): IntArray {
    require(size > 0 && maxValue > 0) { "Розмір та максимальне значення мають бути більшими за нуль" }
    return IntArray(size) { Random.nextInt(1, maxValue + 1) }
}

// 2. Step-by-step workflow scenario
fun main() {
    generateRandomArray(size = 8, maxValue = 40)
        // Step 1 (also)
        .also { println("Початковий масив: ${it.contentToString()}") }
        // Step 2 (apply)
        .apply {
            for (i in indices) {
                this[i] = if (this[i] % 2 != 0) this[i] * 2 else this[i] / 2
            }
        }
        // Step 3 (also)
        .also { println("Модифікований масив: ${it.contentToString()}") }
        // Step 4 (run)
        .run {
            ArraySummary(
                maxElement = reduce { max, x -> maxOf(max, x) },
                elementsOverLimit = count { it > 20 },
                totalSum = sum()
            )
        }
        // Step 5 (let)
        .let {
            """
            ----------------------------------------
            ЗВІТ ОБРОБКИ МАСИВУ:
             • Найбільше значення: ${it.maxElement}
             • Кількість елементів > 20: ${it.elementsOverLimit}
             • Сумарне значення: ${it.totalSum}
            ----------------------------------------
            """.trimIndent()
        }
        // Step 6 (also)
        .also { println(it) }
}