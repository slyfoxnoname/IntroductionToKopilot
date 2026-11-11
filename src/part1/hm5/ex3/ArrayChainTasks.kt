package hm5.ex3

import kotlin.random.Random

data class ArraySummary(
    val maxElement: Int,
    val elementsOverLimit: Int,
    val totalSum: Int
)

fun generateRandomArray(size: Int, maxValue: Int): IntArray {
    require(size > 0 && maxValue > 0) { "Розмір масиву та верхня межа мають бути додатними числами" }
    return IntArray(size) { Random.nextInt(1, maxValue + 1) }
}

fun main() {
    generateRandomArray(size = 8, maxValue = 40)
        // Крок 1 (also): виводимо згенерований масив
        .also { arr -> println("Згенерований масив:   ${arr.contentToString()}") }
        // Крок 2 (apply): непарні елементи подвоюємо, парні ділимо навпіл
        .apply {
            for (idx in indices) {
                val current = this[idx]
                this[idx] = if (current % 2 != 0) current * 2 else current / 2
            }
        }
        // Крок 3 (also): виводимо масив після модифікації
        .also { arr -> println("Після перетворення:   ${arr.contentToString()}") }
        // Крок 4 (run): обчислюємо підсумкову статистику масиву
        .run {
            ArraySummary(
                maxElement = maxOrNull() ?: 0,
                elementsOverLimit = count { it > 20 },
                totalSum = sum()
            )
        }
        // Крок 5 (let): формуємо текстовий звіт
        .let { stats ->
            """
            ========================================
            ПІДСУМКОВИЙ ЗВІТ ПО МАСИВУ:
             * Максимальний елемент     : ${stats.maxElement}
             * Кількість чисел > 20     : ${stats.elementsOverLimit}
             * Загальна сума елементів  : ${stats.totalSum}
            ========================================
            """.trimIndent()
        }
        // Крок 6 (also): друкуємо фінальний звіт
        .also(::println)
}
