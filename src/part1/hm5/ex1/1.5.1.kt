package hm5.ex1

data class ProductInfo(val priceInDollars: Double?)

class Product {
    fun getProductInfo(): ProductInfo? = ProductInfo(100.0)
}

fun convertToEuros(dollars: Double): Double = dollars * 0.85

// Переписана функція з використанням безпечного виклику та scope-функції let
fun Product.getPriceInEuros(): Double? =
    getProductInfo()?.priceInDollars?.let { usd -> convertToEuros(usd) }

fun main() {
    val item = Product()
    val euroPrice = item.getPriceInEuros()

    if (euroPrice != null) {
        println("Price in Euros: €$euroPrice")
    } else {
        println("Price information is not available.")
    }
}
