package hm3

// Функція вищого порядку для підрахунку кількості рядків, що задовольняють предикат
fun countMatches(strings: Collection<String>, predicate: (String) -> Boolean): Int {
    var matchedCount = 0
    for (element in strings) {
        if (predicate(element)) {
            matchedCount++
        }
    }
    return matchedCount
}

fun main() {
    val sampleWords = listOf("kotlin", "version2", " release2026", "clean", "lab3", "test99")

    val withDigitsCount = countMatches(sampleWords) { word ->
        word.any { ch -> ch.isDigit() }
    }
    val longWordsCount = countMatches(sampleWords) { word ->
        word.trim().length >= 6
    }

    println("Вхідний список: $sampleWords")
    println("Кількість рядків, що містять цифри: $withDigitsCount")
    println("Кількість рядків довжиною від 6 символів: $longWordsCount")
}
