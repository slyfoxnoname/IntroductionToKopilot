package HW3

fun stringFilter(strings: Collection<String>, predicate: (String) -> Boolean): List<String> {
    val result = mutableListOf<String>()
    for (item in strings) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun main() {
    val words = listOf("Apple", "Banana", "Avocado", "Cherry", "Apricot")

    val startsWithA = stringFilter(words) { it.startsWith("A") }
    println("Слова на літеру 'A': $startsWithA")
}