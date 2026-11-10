package hm2

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.next()

    val reversed = n.reversed().trimStart('0')

    println(if (reversed.isEmpty()) "0" else reversed)
}