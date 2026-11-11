package hm2

// Задача e-olymp #923: Пора року за номером місяця
fun determineSeason(month: Int): String = when (month) {
    in 3..5 -> "Spring"
    in 6..8 -> "Summer"
    in 9..11 -> "Autumn"
    12, 1, 2 -> "Winter"
    else -> ""
}

fun main() {
    val month = java.util.Scanner(System.`in`).nextInt()
    val season = determineSeason(month)
    if (season.isNotEmpty()) {
        println(season)
    }
}
