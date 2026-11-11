package hm7.Part2

// 1. Інтерфейси поведінки платіжних методів
interface Refundable {
    fun refund(amount: Double): Boolean
}

interface EReceiptable {
    val receiptEmail: String

    fun sendReceipt() {
        println("  [E-Receipt] Електронну квитанцію надіслано на адресу: $receiptEmail")
    }
}

// 2. Абстрактний базовий клас платіжної транзакції
abstract class PaymentMethod(
    val transactionId: String,
    val amount: Double,
    val currency: String = "UAH"
) {
    init {
        require(amount > 0.0) { "Сума транзакції повинна бути більшою за 0 ($amount)" }
    }

    abstract fun processPayment(): Boolean

    open fun printDetails() {
        println("Транзакція [$transactionId] | Сума до сплати: $amount $currency")
    }
}

// 3. Реалізації конкретних способів оплати
class CreditCardPayment(
    transactionId: String,
    amount: Double,
    currency: String = "UAH",
    val cardNumber: String,
    override val receiptEmail: String
) : PaymentMethod(transactionId, amount, currency), Refundable, EReceiptable {

    private val maskedCard: String
        get() = "**** ${cardNumber.takeLast(4)}"

    override fun processPayment(): Boolean {
        println("  -> Авторизація та списання $amount $currency з картки $maskedCard виконано успішно.")
        return true
    }

    override fun refund(amount: Double): Boolean {
        println("  -> Повернення коштів у розмірі $amount $currency на картку $maskedCard проведено.")
        return true
    }

    override fun printDetails() {
        super.printDetails()
        println("  Спосіб оплати: Банківська картка ($maskedCard)")
    }
}

class CryptoPayment(
    transactionId: String,
    amount: Double,
    currency: String = "UAH",
    val cryptoAddress: String,
    val networkFee: Double
) : PaymentMethod(transactionId, amount, currency), Refundable {

    private val shortWallet: String
        get() = if (cryptoAddress.length > 10) {
            "${cryptoAddress.take(6)}...${cryptoAddress.takeLast(4)}"
        } else {
            cryptoAddress
        }

    override fun processPayment(): Boolean {
        println("  -> Крипто-переказ $amount $currency (комісія мережі: $networkFee $currency) на гаманець $shortWallet підтверджено.")
        return true
    }

    override fun refund(amount: Double): Boolean {
        return if (amount > networkFee) {
            val netRefund = amount - networkFee
            println("  -> Повернення $netRefund $currency на гаманець $shortWallet виконано (утримано комісію $networkFee $currency).")
            true
        } else {
            println("  -> Відмова у поверненні: сума ($amount $currency) не покриває комісію мережі ($networkFee $currency).")
            false
        }
    }

    override fun printDetails() {
        super.printDetails()
        println("  Спосіб оплати: Криптовалютний переказ (гаманець: $shortWallet)")
    }
}

class CashOnDeliveryPayment(
    transactionId: String,
    amount: Double,
    currency: String = "UAH",
    val deliveryAddress: String,
    override val receiptEmail: String
) : PaymentMethod(transactionId, amount, currency), EReceiptable {

    override fun processPayment(): Boolean {
        println("  -> Оформлено післяплату $amount $currency. Оплата при отриманні за адресою: $deliveryAddress.")
        return true
    }

    override fun printDetails() {
        super.printDetails()
        println("  Спосіб оплати: Післяплата при доставці ($deliveryAddress)")
    }

    override fun sendReceipt() {
        println("  [SMS & E-Receipt] Попередній чек післяплати сформовано та відправлено на $receiptEmail")
    }
}

// 4. Масова обробка повернень та демонстрація поліморфізму
fun processMassRefund(items: List<PaymentMethod>, refundPercentage: Double) {
    require(refundPercentage in 0.0..100.0) { "Відсоток повернення має бути в межах 0..100" }
    var refundedTransactions = 0

    for (payment in items) {
        if (payment is Refundable) {
            val amountToRefund = payment.amount * (refundPercentage / 100.0)
            if (payment.refund(amountToRefund)) {
                refundedTransactions++
            }
        }
    }

    println("Підсумок повернень: успішно компенсовано $refundedTransactions із ${items.size} платежів.")
}

fun main() {
    val transactions: List<PaymentMethod> = listOf(
        CreditCardPayment(
            transactionId = "TXN-101",
            amount = 3400.0,
            cardNumber = "5375414100009876",
            receiptEmail = "buyer.card@example.com"
        ),
        CryptoPayment(
            transactionId = "TXN-102",
            amount = 14500.0,
            cryptoAddress = "0x95aD61b0a150d79219dCF64E1E6Cc01f0B64C4cE",
            networkFee = 75.0
        ),
        CashOnDeliveryPayment(
            transactionId = "TXN-103",
            amount = 980.0,
            deliveryAddress = "м. Київ, відділення Нової Пошти №18",
            receiptEmail = "cod.customer@example.com"
        )
    )

    println("==================================================")
    println("          ОБРОБКА ПЛАТІЖНИХ ТРАНЗАКЦІЙ")
    println("==================================================")
    for (tx in transactions) {
        tx.printDetails()
        tx.processPayment()
        if (tx is EReceiptable) {
            tx.sendReceipt()
        }
        println("--------------------------------------------------")
    }

    println("\n==================================================")
    println("        ЧАСТКОВЕ ПОВЕРНЕННЯ КОШТІВ (50%)")
    println("==================================================")
    processMassRefund(transactions, refundPercentage = 50.0)
}
