package hm6.ex3.Part1

data class Address(
    val street: String,
    val city: String?,
    val postalCode: String?
)

data class Client(
    val id: Int,
    val name: String,
    val email: String?,
    val address: Address?,
    val extraData: Any?
)

val clientsDatabase: List<Client> = listOf(
    Client(
        id = 1,
        name = "Оксана",
        email = "oksana.koval@example.com",
        address = Address("вул. Володимирська, 40", "Київ", "01001"),
        extraData = "Постійний VIP-клієнт"
    ),
    Client(
        id = 2,
        name = "Артем",
        email = null,
        address = Address("пр-т Свободи, 12", "Львів", null),
        extraData = 1024
    ),
    Client(
        id = 3,
        name = "Софія",
        email = "sofia@example.org",
        address = null,
        extraData = null
    ),
    Client(
        id = 4,
        name = "Василь",
        email = null,
        address = Address("вул. Дерибасівська, 8", null, null),
        extraData = " Доставка тільки у вихідні"
    )
)

// Завдання 1: Формування етикетки доставки з безпечними викликами (?.) та оператором Елвіса (?:)
fun getShippingLabel(client: Client): String {
    val addr = client.address ?: return "Самовивіз: клієнт ${client.name} не вказав адресу доставки"
    val cityText = addr.city ?: "Місто не вказано"
    val zipText = addr.postalCode ?: "Індекс невідомий"
    return "${addr.street}, $cityText, $zipText"
}

// Завдання 2: Безпечне приведення типів (as?) для читання текстової примітки
fun printClientNote(client: Client) {
    val textNote = (client.extraData as? String)?.trim() ?: "Додаткові примітки відсутні"
    println("Клієнт ${client.name} (ID=${client.id}) -> Примітка: $textNote")
}

// Завдання 4: Отримання email або генерація винятку через оператор Елвіса
fun getClientEmailOrThrow(client: Client): String =
    client.email ?: throw IllegalArgumentException("У клієнта ${client.name} (ID=${client.id}) не заповнено email!")

// Завдання 5: Примусове розіменування (!!) поштового індексу
fun forceGetPostalCode(client: Client): String =
    client.address!!.postalCode!!

fun main() {
    println("=== Завдання 1: Етикетки для відправлення ===")
    clientsDatabase.forEach { client ->
        println("  • ${client.name}: ${getShippingLabel(client)}")
    }

    println("\n=== Завдання 2: Примітки про клієнтів ===")
    clientsDatabase.forEach(::printClientNote)

    println("\n=== Завдання 3: Відбір валідних email-адрес ===")
    val validEmails: List<String> = clientsDatabase.mapNotNull { it.email }
    val shortestEmailLen = validEmails.minOfOrNull { it.length }
    println("Список адрес для розсилки: $validEmails")
    println("Мінімальна довжина email:  $shortestEmailLen символів")

    println("\n=== Завдання 4: Перевірка обов'язкової наявності email ===")
    try {
        val email = getClientEmailOrThrow(clientsDatabase[1])
        println("Отримано email: $email")
    } catch (ex: IllegalArgumentException) {
        println("Перехоплено помилку валідації: ${ex.message}")
    }

    println("\n=== Завдання 5: Демонстрація оператора !! ===")
    println("Індекс першого клієнта (${clientsDatabase[0].name}): ${forceGetPostalCode(clientsDatabase[0])}")
    try {
        println("Спроба отримати індекс другого клієнта (${clientsDatabase[1].name}):")
        println(forceGetPostalCode(clientsDatabase[1]))
    } catch (ex: NullPointerException) {
        println("Перехоплено очікуваний NullPointerException під час виклику !!")
    }
}
