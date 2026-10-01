package HW4.ex3

fun main() {
    // Part1. Data transformation pipeline (filter, sortedByDescending, map)
    println("Part1. Data transformation pipeline")
    products
        .filter { it.inStock && it.rating >= 4.7 && it.price < 1000.0 }
        .sortedByDescending { it.rating }
        .map { "Name: ${it.name} | Rating: ${it.rating} | Price: $${it.price}" }
        .forEach { println(it) }

    // Part2. Searching and predicate checks (find, any, all)
    println("\nPart2. Searching and predicate checks")

    // Targeted search for the first laptop priced above 1,200.0
    val expensiveLaptopName = products
        .find { it.category == "Laptops" && it.price > 1200.0 }
        ?.name ?: "Product not found"
    println("The first laptop costing more than \$1,200: $expensiveLaptopName")

    // 'any' check: at least one audio device is more expensive than 300.0.
    val hasExpensiveAudio = products.any { it.category == "Audio" && it.price > 300.0 }
    println("Is there audio equipment costing more than 300?: $hasExpensiveAudio")

    // Check all: all smartphones have a rating above 4.0.
    val allSmartphonesHighRating = products
        .filter { it.category == "Smartphones" }
        .all { it.rating > 4.0 }
    println("Do all smartphones have a rating? > 4.0: $allSmartphonesHighRating")

    // Part3. Splitting and Grouping the Sample (partition, groupBy, maxByOrNull)
    println("\nPart3. Splitting and Grouping the Sample")

    val (available, outOfStock) = products.partition { it.inStock }
    println("Кількість товарів у наявності: ${available.size}")
    println("Кількість товарів не на складі: ${outOfStock.size}")

    // Grouping by category and finding the most expensive item in each
    println("\nThe most expensive item in each category:")
    val productsByCategory: Map<String, List<Product>> = products.groupBy { it.category }

    productsByCategory.forEach { (category, items) ->
        val mostExpensive = items.maxByOrNull { it.price }
        if (mostExpensive != null) {
            println("Categorising $category -> Most valuable: ${mostExpensive.name} ($${mostExpensive.price})")
        }
    }

    // Part4. Calling a Higher-Order Function Using a Trailing Lambda
    println("\nЧастина 4. Виклик власної filterAndTransform")

    // Trailing lambda syntax: the last parameter, `transform`, is moved outside the parentheses { }.
    val promoMessages = products.filterAndTransform(
        predicate = { it.price < 300.0 }
    ) { product ->
        "Акційна ціна на ${product.name}: лише $${product.price}!"
    }

    promoMessages.forEach { println(it) }

    // ⭐️ Additional task: `fold` and the average cost of goods in stock
    println("\n=== ⭐️ AT (fold) ===")

    val inStockProducts = products.filter { it.inStock }

    val totalCost = inStockProducts.fold(0.0) { accumulator, product ->
        accumulator + product.price
    }

    val averagePrice = if (inStockProducts.isNotEmpty()) totalCost / inStockProducts.size else 0.0

    println("Total value of goods in stock: $${totalCost}")
    println("Average price of an in-stock item: $${"%.2f".format(averagePrice)}")
}