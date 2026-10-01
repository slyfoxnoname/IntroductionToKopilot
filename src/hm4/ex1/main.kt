package HW4.ex1

import kotlin.random.Random

fun main() {
    println("First 1-3 Part Validation")

    // 1
    val eqInt = QuadraticEquation(1, -5, 6) // x^2 - 5x + 6 = 0 (solves: 3.0, 2.0)
    val eqReduced = QuadraticEquation(-4.0, 4.0) // 1.0x^2 - 4.0x + 4.0 = 0 (solves: 2.0)

    println("eqInt: $eqInt | D = ${eqInt.discriminant} | Solves: ${eqInt.solve()}")
    println("eqReduced: $eqReduced | D = ${eqReduced.discriminant} | Solves: ${eqReduced.solve()}")

    // 2
    println("\n--- Mutation of b and c ---")
    println("Starting D: ${eqInt.discriminant}")
    eqInt.b = 2.0
    eqInt.c = 5.0
    println("After change b in 2.0 and c to 5.0: D = ${eqInt.discriminant}, Solves: ${eqInt.solve()}")

    // 3
    try {
        eqInt.a = 0.0
    } catch (e: IllegalArgumentException) {
        println("Success cached problem of setter: ${e.message}")
    }

    println("\nPart 4: Generation 100 random examples for validation")

    val equations: List<QuadraticEquation> = List(100) {
        var a = 0
        while (a == 0) {
            a = Random.nextInt(-50, 51)
        }
        val b = Random.nextInt(-50, 51)
        val c = Random.nextInt(-50, 51)
        QuadraticEquation(a, b, c)
    }

    val equationsWithTwoRoots = equations.filter { it.discriminant > 0.0 }

    println("Found ${equationsWithTwoRoots.size} equations with two solves:\n")

    equationsWithTwoRoots.forEachIndexed { index, eq ->
        // ⭐️
        when (val roots = eq.solveWithRoots()) {
            is Roots.TwoRoots -> {
                println(
                    "#%02d: %s | D = %.2f -> x1 = %.3f, x2 = %.3f"
                        .format(index + 1, eq, eq.discriminant, roots.x1, roots.x2)
                )
            }
            is Roots.OneRoot -> println("#%02d: %s -> One solve: x = %.3f".format(index + 1, eq, roots.x))
            is Roots.NoRealRoots -> println("#%02d: %s -> NO SOLVE".format(index + 1, eq))
        }
    }

    println("\nAll Generated: ${equations.size}")
    println("Equalation with two real solves: ${equationsWithTwoRoots.size}")
}