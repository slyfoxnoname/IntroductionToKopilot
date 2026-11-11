package hm6.ex3.Part2

import kotlin.random.Random

fun generateRandomArray(size: Int, maxValue: Int): IntArray? {
    if (size <= 0 || maxValue <= 0) return null
    return IntArray(size) { Random.nextInt(0, maxValue + 1) }
}

fun main() {
    generateRandomArray(size = 10, maxValue = 50)
        ?.let { generated ->
            generated.apply {
                for (index in indices) {
                    val value = this[index]
                    this[index] = if (value % 2 != 0) value * 2 else value / 2
                }
            }
        }
        ?.also { updatedArray ->
            println("Модифікований масив: ${updatedArray.contentToString()}")
        }
        ?.run {
            maxOrNull()
        }
        ?.run {
            println("Найбільший елемент масиву: $this")
        }
        ?: println("Помилка вхідних даних: розмір та верхня межа мають бути більшими за 0")
}
