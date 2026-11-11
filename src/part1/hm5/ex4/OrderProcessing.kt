package hm5.ex4

data class OrderItem(
    val name: String,
    val price: Double,
    val quantity: Int
)

class Order(val id: String) {
    var customerName: String = ""
    var deliveryAddress: String = ""
    var discountPercent: Int = 0
    val items: MutableList<OrderItem> = mutableListOf()

    fun addItem(item: OrderItem) {
        items.add(item)
    }
}

fun main() {
    // Завдання 1: Конфігурація замовлення через apply та аудит через also
    val currentOrder = Order("ORD-2026-105").apply {
        customerName = "Максим Бондаренко"
        deliveryAddress = "пр-т Науки, 14, Харків"
        discountPercent = 15

        addItem(OrderItem("Механічна клавіатура", 3200.0, 1))
        addItem(OrderItem("Бездротова миша", 1500.0, 1))
        addItem(OrderItem("Кабель USB-C", 350.0, 2))
    }.also { configuredOrder ->
        println("[AUDIT] Замовлення ${configuredOrder.id} сформовано. Позицій у кошику: ${configuredOrder.items.size}")
    }

    // Завдання 2: Розрахунок підсумкової вартості з урахуванням знижки через run
    val totalToPay: Double = currentOrder.run {
        val grossAmount = items.sumOf { item -> item.price * item.quantity }
        val discountFactor = (100 - discountPercent) / 100.0
        grossAmount * discountFactor
    }
    println("Сума до сплати зі знижкою: $totalToPay грн")

    // Завдання 3: Формування платіжного ідентифікатора (у копійках) через let
    val transactionCode: String = totalToPay.let { finalUah ->
        val kopiykas = (finalUah * 100).toLong()
        "PAY_${currentOrder.id}_SUM_${kopiykas}_KOP"
    }
    println("Платіжний токен: $transactionCode")

    // Завдання 4: Друк клієнтського чека за допомогою with
    with(currentOrder) {
        println("==========================================")
        println("ФІСКАЛЬНИЙ ЧЕК ЗАМОВЛЕННЯ #$id")
        println("Покупець        : $customerName")
        println("Адреса доставки : $deliveryAddress")
        println("------------------------------------------")
        println("Перелік товарів:")
        items.forEachIndexed { index, item ->
            val lineTotal = item.price * item.quantity
            println("  ${index + 1}. ${item.name} (${item.quantity} шт. x ${item.price} грн) = $lineTotal грн")
        }
        println("------------------------------------------")
        println("Персональна знижка : $discountPercent%")
        println("ДО СПЛАТИ          : $totalToPay грн")
        println("==========================================")
    }
}
