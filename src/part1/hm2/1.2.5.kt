package hm2

// Задача e-olymp #8613: Умовний оператор - 5
// y = 3x^3 + 4x^2 + 5x + 6, якщо x >= 13
// y = 3x^3 - 2x^2 - 3x - 4, якщо x < 13
fun evaluatePolynomial(x: Long): Long {
    val x2 = x * x
    val x3 = x2 * x
    return if (x >= 13L) {
        3L * x3 + 4L * x2 + 5L * x + 6L
    } else {
        3L * x3 - 2L * x2 - 3L * x - 4L
    }
}

fun main() {
    val token = java.util.Scanner(System.`in`).nextLong()
    println(evaluatePolynomial(token))
}
