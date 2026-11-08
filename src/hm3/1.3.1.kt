package HW3

fun main() {
    val a = 7
    val b = 4

    println("Множимо $a на $b:")
    println("1. Через repeat:  ${multiplyingUsingRepeat(a, b)}")
    println("2. Через forEach: ${multiplyingUsingForEach(a, b)}")
}

fun multiplyingUsingRepeat(a: Int, b: Int): Int {
    var result = 0
    repeat(b) {
        result += a
    }
    return result
}

fun multiplyingUsingForEach(a: Int, b: Int): Int {
    var result = 0
    (1..b).forEach { _ ->
        result += a
    }
    return result
}