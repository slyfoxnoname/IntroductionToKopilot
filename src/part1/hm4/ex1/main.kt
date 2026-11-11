package hm4.ex1

import java.util.Locale
import kotlin.random.Random

fun main() {
    println("=== Частини 1–3: Перевірка конструкторів, властивостей та валідації ===")

    val equationFromInts = QuadraticEquation(1, -7, 12) // x^2 - 7x + 12 = 0 -> корені 4.0, 3.0
    val reducedEquation = QuadraticEquation(-6.0, 9.0)  // x^2 - 6x + 9 = 0  -> корінь 3.0

    println("Рівняння 1: $equationFromInts | D = ${equationFromInts.discriminant} | Корені: ${equationFromInts.solve()}")
    println("Рівняння 2: $reducedEquation | D = ${reducedEquation.discriminant} | Корені: ${reducedEquation.solve()}")

    println("\n--- Зміна коефіцієнтів b та c ---")
    equationFromInts.b = 1.0
    equationFromInts.c = 10.0
    println("Після оновлення (b=1.0, c=10.0): $equationFromInts | D = ${equationFromInts.discriminant} | Корені: ${equationFromInts.solve()}")

    println("\n--- Перевірка захисту коефіцієнта 'a' від нуля ---")
    try {
        equationFromInts.a = 0.0
    } catch (ex: IllegalArgumentException) {
        println("Успішно перехоплено помилку сетера: ${ex.message}")
    }

    println("\n=== Частина 4: Генерація та аналіз 100 випадкових квадратних рівнянь ===")
    val randomEquations = List(100) {
        val nonZeroA = generateSequence { Random.nextInt(-50, 51) }.first { it != 0 }
        val randomB = Random.nextInt(-50, 51)
        val randomC = Random.nextInt(-50, 51)
        QuadraticEquation(nonZeroA, randomB, randomC)
    }

    val twoRootsEquations = randomEquations.filter { it.discriminant > 0.0 }
    println("Відібрано рівнянь із двома дійсними коренями: ${twoRootsEquations.size} зі ${randomEquations.size}\n")

    twoRootsEquations.forEachIndexed { idx, eq ->
        when (val result = eq.solveWithRoots()) {
            is Roots.TwoRoots -> {
                println(
                    String.format(
                        Locale.US,
                        "#%02d | %s | D = %.2f -> x1 = %.3f, x2 = %.3f",
                        idx + 1,
                        eq.toString(),
                        eq.discriminant,
                        result.x1,
                        result.x2
                    )
                )
            }
            is Roots.OneRoot -> {
                println(String.format(Locale.US, "#%02d | %s -> Єдиний корінь: x = %.3f", idx + 1, eq.toString(), result.x))
            }
            is Roots.NoRealRoots -> {
                println("#%02d | %s -> Дійсних коренів немає".format(idx + 1, eq.toString()))
            }
        }
    }
}
