package hm2

import java.util.Scanner

// Задача e-olymp #8923: Число навпаки 3
fun reverseNaturalNumber(rawNumber: String): String {
    val reversedDigits = rawNumber.trim().reversed().dropWhile { it == '0' }
    return reversedDigits.ifEmpty { "0" }
}

fun main() {
    val input = Scanner(System.`in`).next()
    println(reverseNaturalNumber(input))
}
