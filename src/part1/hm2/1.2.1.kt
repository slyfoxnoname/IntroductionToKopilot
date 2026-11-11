package hm2

import kotlin.math.PI
import kotlin.random.Random

// 1. Обчислення загальної кількості елементів у двох списках
fun taskListCount() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    val totalCount = greenNumbers.size + redNumbers.size
    println(totalCount)
}

// 2. Перевірка підтримки протоколу у множині
fun taskSetProtocolCheck() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = SUPPORTED.contains(requested.uppercase())
    println("Support for $requested: $isSupported")
}

// 3. Відображення числа у текстовий запис через словник (Map)
fun taskNumberSpelling() {
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    val n = 2
    println("$n is spelled as '${number2word[n]}'")
}

// 4. Гра в кубики за допомогою умовного виразу if
fun taskDiceRoll() {
    val firstResult = Random.nextInt(1, 7)
    val secondResult = Random.nextInt(1, 7)
    val outcome = if (firstResult == secondResult) "You win :)" else "You lose :("
    println(outcome)
}

// 5. Обробка натискання кнопок геймпада через вираз when
fun taskGamepadAction() {
    val button = "A"
    val action = when (button) {
        "A" -> "Yes"
        "B" -> "No"
        "X" -> "Menu"
        "Y" -> "Nothing"
        else -> "There is no such button"
    }
    println(action)
}

// 6. Підрахунок шматочків піци за допомогою циклу do-while / while
fun taskPizzaCounter() {
    var pizzaSlices = 0
    do {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    } while (pizzaSlices < 7)
    pizzaSlices++
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

// 7. Класична задача FizzBuzz для діапазону від 1 до 100
fun taskFizzBuzz() {
    for (number in 1..100) {
        val output = when {
            number % 15 == 0 -> "fizzbuzz"
            number % 3 == 0 -> "fizz"
            number % 5 == 0 -> "buzz"
            else -> number.toString()
        }
        println(output)
    }
}

// 8. Відбір слів, що починаються з літери 'l'
fun taskFilterWordsByPrefix() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    words.filter { it.startsWith('l') }.forEach { println(it) }
}

// 9. Обчислення площі кола (звичайна функція з блоковим тілом)
fun circleAreaBlock(radius: Int): Double {
    return PI * radius * radius
}

fun taskCircleAreaBlock() {
    println(circleAreaBlock(2))
}

// 10. Обчислення площі кола (однорядкова функція-вираз)
fun circleAreaSingleExpr(radius: Int): Double = PI * radius.toDouble() * radius.toDouble()

fun taskCircleAreaSingleExpr() {
    println(circleAreaSingleExpr(2))
}

// 11. Переведення часового інтервалу в секунди з параметрами за замовчуванням
fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0): Int =
    hours * 3600 + minutes * 60 + seconds

fun taskIntervalInSeconds() {
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(minutes = 1, seconds = 25))
    println(intervalInSeconds(hours = 2))
    println(intervalInSeconds(minutes = 10))
    println(intervalInSeconds(hours = 1, seconds = 1))
}

fun main() {
    taskListCount()
    taskSetProtocolCheck()
    taskNumberSpelling()
    taskDiceRoll()
    taskGamepadAction()
    taskPizzaCounter()
    taskFizzBuzz()
    taskFilterWordsByPrefix()
    taskCircleAreaBlock()
    taskCircleAreaSingleExpr()
    taskIntervalInSeconds()
}
