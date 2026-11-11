package hm2

import java.util.Scanner

// Перевірка, чи є натуральне число простим
fun isPrimeNumber(value: Long): Boolean {
    if (value < 2L) return false
    if (value == 2L || value == 3L) return true
    if (value % 2L == 0L || value % 3L == 0L) return false

    var divisor = 5L
    while (divisor * divisor <= value) {
        if (value % divisor == 0L || value % (divisor + 2L) == 0L) {
            return false
        }
        divisor += 6L
    }
    return true
}

fun main() {
    val scanner = Scanner(System.`in`)
    val candidate = scanner.nextLong()
    println(if (isPrimeNumber(candidate)) "YES" else "NO")
}
