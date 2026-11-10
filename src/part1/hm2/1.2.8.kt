package hm2

import java.util.Scanner

fun isPrime(n: Long): Boolean {
    if (n <= 1) return false
    if (n == 2L) return true
    if (n % 2L == 0L) return false

    var d = 3L
    while (d * d <= n) {
        if (n % d == 0L) return false
        d += 2
    }
    return true
}

fun main() {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextLong()

    if (isPrime(number)) {
        println("YES")
    } else {
        println("NO")
    }
}