package hm4.ex3

import java.util.Locale

fun main() {
    // Частина 1: Конвеєр обробки даних (filter + sortedByDescending + map)
    println("=== Частина 1: Товари в наявності з рейтингом >= 4.7 та ціною < $1000 ===")
    products
        .filter { it.inStock && it.rating >= 4.7 && it.price < 1000.0 }
        .sortedByDescending { it.rating }
        .map { "Товар: ${it.name} | Рейтинг: ${it.rating} | Ціна: $${it.price}" }
        .forEach(::println)

    // Частина 2: Пошук та перевірка предикатів (find, any, all)
    println("\n=== Частина 2: Пошук та перевірка умов (find, any, all) ===")
    val premiumLaptop = products
        .find { it.category == "Laptops" && it.price > 1200.0 }
        ?.name ?: "Не знайдено"
    println("Перший ноутбук дорожче $1200: $premiumLaptop")

    val hasAudioOver300 = products.any { it.category == "Audio" && it.price > 300.0 }
    println("Чи є аудіотехніка дорожча за $300: $hasAudioOver300")

    val allPhonesRatedAbove4 = products
        .filter { it.category == "Smartphones" }
        .all { it.rating > 4.0 }
    println("Чи всі смартфони мають рейтинг вище 4.0: $allPhonesRatedAbove4")

    // Частина 3: Розбиття та групування (partition, groupBy, maxByOrNull)
    println("\n=== Частина 3: Розбиття та групування за категоріями ===")
    val (availableItems, unavailableItems) = products.partition { it.inStock }
    println("У наявності на складі: ${availableItems.size} од.")
    println("Тимчасово відсутні:    ${unavailableItems.size} од.")

    println("\nНайдорожчий товар у кожній категорії:")
    products
        .groupBy { it.category }
        .forEach { (categoryName, categoryProducts) ->
            val topPriced = categoryProducts.maxByOrNull { it.price }
            if (topPriced != null) {
                println("  • $categoryName -> ${topPriced.name} ($${topPriced.price})")
            }
        }

    // Частина 4: Виклик функції вищого порядку з trailing lambda
    println("\n=== Частина 4: Генерація промо-повідомлень через filterAndTransform ===")
    val promoBanners = products.filterAndTransform(
        predicate = { it.price < 300.0 }
    ) { item ->
        "Спеціальна пропозиція на ${item.name}: всього за $${item.price}!"
    }
    promoBanners.forEach(::println)

    // Додаткове завдання: агрегація через fold
    println("\n=== Додаткове завдання: Агрегація вартості наявних товарів через fold ===")
    val totalInStockValue = availableItems.fold(0.0) { acc, product -> acc + product.price }
    val meanInStockPrice = if (availableItems.isNotEmpty()) totalInStockValue / availableItems.size else 0.0

    println("Сумарна вартість товарів у наявності: $${totalInStockValue}")
    println("Середня вартість наявного товару:     $${String.format(Locale.US, "%.2f", meanInStockPrice)}")
}
