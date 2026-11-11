package hm2

// Задача e-olymp #5054: Чи високосний рік?
// Рік є високосним, якщо він кратний 400, або кратний 4 і при цьому не кратний 100.
fun isLeapYear(year: Int): Boolean =
    (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)

fun main() {
    val input = readlnOrNull()?.trim() ?: return
    val year = input.toInt()
    println(if (isLeapYear(year)) "YES" else "NO")
}
