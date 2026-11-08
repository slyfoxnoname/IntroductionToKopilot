package hm2
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextLong()
    val b = scanner.nextLong()

    var product = 0L

    for (i in 1..b) {
        product += a
    }

    println(product)
}