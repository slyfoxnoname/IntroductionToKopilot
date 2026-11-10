package hm2

import java.math.BigInteger
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    var result = BigInteger.ONE

    for (i in 2..n) {
        result = result.multiply(BigInteger.valueOf(i.toLong()))
    }

    println(result)
}