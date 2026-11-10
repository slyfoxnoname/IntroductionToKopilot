package hm2
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val m = scanner.nextInt()

    if (m >= 3 && m <= 5) {
        println("Spring")
    } else if (m >= 6 && m <= 8) {
        println("Summer")
    } else if (m >= 9 && m <= 11) {
        println("Autumn")
    } else if (m == 12 || m == 1 || m == 2) {
        println("Winter")
    }
}