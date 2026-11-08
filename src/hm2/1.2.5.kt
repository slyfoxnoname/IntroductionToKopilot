package hm2
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val x = scanner.nextLong()

    val y = if (x >= 13) {
        3 * x * x * x + 4 * x * x + 5 * x + 6
    } else {
        3 * x * x * x - 2 * x * x - 3 * x - 4
    }

    println(y)
}