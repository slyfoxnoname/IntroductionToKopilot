package hm3

// Множення двох чисел через вбудовані функції repeat та forEach
fun multiplyWithRepeat(multiplicand: Int, multiplier: Int): Int {
    var sum = 0
    repeat(multiplier) {
        sum += multiplicand
    }
    return sum
}

fun multiplyWithForEach(multiplicand: Int, multiplier: Int): Int {
    var sum = 0
    (1..multiplier).forEach { _ ->
        sum += multiplicand
    }
    return sum
}

fun main() {
    val x = 9
    val y = 6

    println("Обчислення добутку чисел $x та $y:")
    println(" -> Варіант з repeat:  ${multiplyWithRepeat(x, y)}")
    println(" -> Варіант з forEach: ${multiplyWithForEach(x, y)}")
}
