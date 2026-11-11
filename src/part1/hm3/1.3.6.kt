package hm3

// Підрахунок частоти входження кожного символу в рядку
fun countCharOccurrences(input: String): Map<Char, Int> {
    val frequencyMap = linkedMapOf<Char, Int>()
    for (ch in input) {
        frequencyMap[ch] = (frequencyMap[ch] ?: 0) + 1
    }
    return frequencyMap
}

fun main() {
    val phrase = "programming in kotlin"
    val frequencies = countCharOccurrences(phrase)

    println("Частота символів у рядку "$phrase":")
    frequencies.forEach { (symbol, count) ->
        val label = if (symbol == ' ') "'пробіл'" else "'$symbol'"
        println("  $label : $count")
    }
}
