package hm3

// Власна реалізація функції фільтрації колекції рядків за предикатом
fun stringFilter(strings: Collection<String>, predicate: (String) -> Boolean): List<String> {
    return buildList {
        for (item in strings) {
            if (predicate(item)) {
                add(item)
            }
        }
    }
}

fun main() {
    val cities = listOf("Київ", "Львів", "Кам'янець-Подільський", "Одеса", "Кропивницький", "Харків")

    val kCities = stringFilter(cities) { city -> city.startsWith("К") }
    println("Усі міста: $cities")
    println("Міста на літеру 'К': $kCities")
}
