package HW3

fun main() {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = actions.map { action -> "$prefix/$id/$action" }
    println("Вивід в лямбда EX1 $urls")
    println("Тут вивід EX2")
    repeatN(5) {
        println("Hello")
    }
}

fun repeatN(n: Int, action: () -> Unit) {
    for (i in 1..n) {
        action()
    }
}