package HW3

fun countMatches(strings: Collection<String>, predicate: (String) -> Boolean): Int {
    var count = 0
    for (str in strings) {
        if (predicate(str)) {
            count++
        }
    }
    return count
}

fun main() {
    val items = listOf("kotlin", "task2", "hw2026", "none", "number7")

    val countWithDigits = countMatches(items) { str ->
        str.any { char -> char.isDigit() }
    }

    println("Кількість рядків з цифрами: $countWithDigits") // 3
}