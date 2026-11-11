package hm2

import java.util.Scanner
import kotlin.math.abs

// Добуток двох цілих чисел без використання оператора множення
fun multiplyByAddition(a: Long, b: Long): Long {
    if (a == 0L || b == 0L) return 0L
    val negativeResult = (a < 0) xor (b < 0)
    val absA = abs(a)
    val absB = abs(b)

    var accumulator = 0L
    for (step in 1L..absB) {
        accumulator += absA
    }
    return if (negativeResult) -accumulator else accumulator
}

fun main() {
    val scanner = Scanner(System.`in`)
    val first = scanner.nextLong()
    val second = scanner.nextLong()
    println(multiplyByAddition(first, second))
}
