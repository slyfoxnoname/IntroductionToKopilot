package hm3

// Завдання з лямбда-виразами: генерація URL-адрес та функція вищого порядку repeatN
fun repeatN(times: Int, block: () -> Unit) {
    for (step in 1..times) {
        block()
    }
}

fun main() {
    val endpoints = listOf("title", "year", "author")
    val baseUrl = "https://example.com/book-info"
    val bookId = 5

    val generatedUrls = endpoints.map { endpoint -> "$baseUrl/$bookId/$endpoint" }
    println("Згенеровані посилання: $generatedUrls")

    println("Виконання repeatN(5):")
    repeatN(5) {
        println("Hello")
    }
}
