package HW3

fun countCharOccurrences(input: String): Map<Char, Int> {
    return input.groupingBy { it }.eachCount()
}

fun main() {
    val text = "hello kotlin"
    val charCounts = countCharOccurrences(text)

    charCounts.forEach { (char, count) ->
        val displayChar = if (char == ' ') "' '" else char.toString()
        println("$displayChar -> $count")
    }
}