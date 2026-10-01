package HW6.ex3.Part2

import kotlin.random.Random

fun generateRandomArray(size: Int, maxValue: Int): IntArray? {
    if (size <= 0 || maxValue <= 0) return null

    return IntArray(size) { Random.nextInt(0, maxValue + 1) }
}

fun main() {
    generateRandomArray(size = 10, maxValue = 50)
        ?.let { array ->
            array.apply {
                for (i in indices) {
                    this[i] = if (this[i] % 2 != 0) this[i] * 2 else this[i] / 2
                }
            }
        }
        ?.also {
            println("Модифікований масив: ${it.contentToString()}")
        }
        ?.run {
            maxOrNull()
        }
        ?.run {
            println("Максимальне значення масиву: $this")
        } ?: println("Помилка вхідних даних")
}