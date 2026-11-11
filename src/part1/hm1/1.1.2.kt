package hm1

fun main() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000L
    val e: Boolean = false
    val f: Char = '\n'

    val values = listOf<Any>(a, b, c, d, e, f)
    values.forEach { println(it) }
}
