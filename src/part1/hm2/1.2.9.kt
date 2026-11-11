package hm2

import java.math.BigInteger
import java.util.Scanner

// Задача e-olymp #271: Факторіал! (0 <= n <= 3000)
fun computeFactorial(n: Int): BigInteger {
    var factorial = BigInteger.ONE
    for (factor in 2..n) {
        factorial = factorial.multiply(BigInteger.valueOf(factor.toLong()))
    }
    return factorial
}

fun main() {
    val n = Scanner(System.`in`).nextInt()
    println(computeFactorial(n))
}
