package hm2
import kotlin.random.Random
import kotlin.math.PI

fun HW_1_2_1() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)

    println(greenNumbers.count() + redNumbers.count())
}

fun HW_1_2_2() {
    val SUPPORTED = setOf("HTTP", "HTTPS", "FTP")
    val requested = "smtp"
    val isSupported = requested.uppercase() in SUPPORTED
    println("Support for $requested: $isSupported")
}

fun HW_1_2_3() {
    val number2word = mapOf(1 to "one", 2 to "two", 3 to "three")
    val n = 2
    println("$n is spelled as '${number2word[n]}'")
}

fun HW_1_2_4() {
    val firstResult = Random.nextInt(6)
    val secondResult = Random.nextInt(6)

    if (firstResult == secondResult) {
        println("You win :)")
    } else {
        println("You lose :(")
    }
}

fun HW_1_2_5() {
    val button = "A"

    println(
        when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            "Y" -> "Nothing"
            else -> "There is no such button"
        }
    )
}

fun HW_1_2_6() {
    var pizzaSlices = 0
    while (pizzaSlices < 7) {
        pizzaSlices++
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    pizzaSlices++
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

fun HW_1_2_7() {
    for (i in 1..100) {
        when {
            i % 15 == 0 -> println("fizzbuzz")
            i % 3 == 0 -> println("fizz")
            i % 5 == 0 -> println("buzz")
            else -> println(i)
        }
    }
}

fun HW_1_2_8() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for (word in words) {
        if (word.startsWith("l")) {
            println(word)
        }
    }
}

fun circleArea_HW_1_2_9(radius: Int): Double {
    return PI * radius * radius
}

fun HW_1_2_9() {
    println(circleArea_HW_1_2_9(2))
}

fun circleArea_HW_1_2_10(radius: Int): Double = PI * radius * radius

fun HW_1_2_10() {
    println(circleArea_HW_1_2_10(2))
}

fun intervalInSeconds(hours: Int = 0, minutes: Int = 0, seconds: Int = 0) =
    ((hours * 60) + minutes) * 60 + seconds

fun HW_1_2_11() {
    println(intervalInSeconds(1, 20, 15))
    println(intervalInSeconds(minutes = 1, seconds = 25))
    println(intervalInSeconds(hours = 2))
    println(intervalInSeconds(minutes = 10))
    println(intervalInSeconds(hours = 1, seconds = 1))
}

fun main(args: Array<String>) {
    HW_1_2_1()
    HW_1_2_2()
    HW_1_2_3()
    HW_1_2_4()
    HW_1_2_5()
    HW_1_2_6()
    HW_1_2_7()
    HW_1_2_8()
    HW_1_2_9()
    HW_1_2_10()
    HW_1_2_11()
}