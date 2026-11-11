package hm4.ex1

import kotlin.math.sqrt

// Ієрархія результатів розв'язання квадратного рівняння
sealed interface Roots {
    data class TwoRoots(val x1: Double, val x2: Double) : Roots
    data class OneRoot(val x: Double) : Roots
    data object NoRealRoots : Roots
}

class QuadraticEquation(
    initialA: Double,
    var b: Double,
    var c: Double
) {
    var a: Double = initialA
        set(newValue) {
            require(newValue != 0.0) { "Старший коефіцієнт 'a' не може дорівнювати 0.0" }
            field = newValue
        }

    init {
        require(initialA != 0.0) { "Старший коефіцієнт 'a' не може дорівнювати 0.0" }
    }

    // Вторинний конструктор для цілочисельних коефіцієнтів
    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    // Вторинний конструктор для зведеного квадратного рівняння (a = 1.0)
    constructor(b: Double, c: Double) : this(1.0, b, c)

    // Обчислювана властивість дискримінанта D = b^2 - 4ac
    val discriminant: Double
        get() = (b * b) - (4.0 * a * c)

    // Повертає список дійсних коренів рівняння
    fun solve(): List<Double> {
        val d = discriminant
        return when {
            d > 0.0 -> {
                val rootD = sqrt(d)
                val firstRoot = (-b + rootD) / (2.0 * a)
                val secondRoot = (-b - rootD) / (2.0 * a)
                listOf(firstRoot, secondRoot)
            }
            d == 0.0 -> listOf(-b / (2.0 * a))
            else -> emptyList()
        }
    }

    // Повертає типізований результат через sealed interface Roots
    fun solveWithRoots(): Roots {
        val realRoots = solve()
        return when (realRoots.size) {
            2 -> Roots.TwoRoots(realRoots[0], realRoots[1])
            1 -> Roots.OneRoot(realRoots[0])
            else -> Roots.NoRealRoots
        }
    }

    override fun toString(): String = "${a}x^2 + (${b})x + (${c}) = 0"
}
