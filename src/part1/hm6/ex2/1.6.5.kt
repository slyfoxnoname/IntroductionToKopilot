package hm6.ex2

fun validateStock(requested: Int?, available: Int?): Int {
    val requestedQty = requested ?: return -1
    val availableQty = available ?: return -1

    return if (requestedQty in 0..availableQty) requestedQty else -1
}

fun main() {
    println(validateStock(5, 10))
    println(validateStock(null, 10))
    println(validateStock(-2, 10))
}
