package HW4.ex1

import kotlin.math.sqrt

// ⭐️ AT: Modeling results using a sealed hierarchy
sealed interface Roots {
    data class TwoRoots(val x1: Double, val x2: Double) : Roots
    data class OneRoot(val x: Double) : Roots
    data object NoRealRoots : Roots
}

class QuadraticEquation(
    a: Double,
    var b: Double,
    var c: Double
) {
    // Part3: Custom setter with validation
    var a: Double = a
        set(value) {
            require(value != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
            field = value
        }

    // Part1: Block first initialization and validation
    init {
        require(a != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
    }

    // Part1: Secondary constructor for INT-conf
    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    // Part1: Secondary constructor for equation
    constructor(b: Double, c: Double) : this(1.0, b, c)

    // Part2: Computed Property (Custom Getter)
    val discriminant: Double
        get() = b * b - 4 * this.a * c

    // Part2: Basic solve() method using List<Double>
    fun solve(): List<Double> {
        val d = discriminant
        val currentA = a

        return when {
            d > 0.0 -> {
                val sqrtD = sqrt(d)
                val x1 = (-b + sqrtD) / (2 * currentA)
                val x2 = (-b - sqrtD) / (2 * currentA)
                listOf(x1, x2)
            }
            d == 0.0 -> {
                val x = -b / (2 * currentA)
                listOf(x)
            }
            else -> emptyList()
        }
    }

    // ⭐️ The solveWithRoots() method, which returns the sealed interface Roots.
    fun solveWithRoots(): Roots {
        val rootsList = solve()
        return when (rootsList.size) {
            2 -> Roots.TwoRoots(rootsList[0], rootsList[1])
            1 -> Roots.OneRoot(rootsList[0])
            else -> Roots.NoRealRoots
        }
    }

    // Part2: Readable representation of the equation
    override fun toString(): String {
        return "${a}x^2 + (${b})x + (${c}) = 0"
    }
}