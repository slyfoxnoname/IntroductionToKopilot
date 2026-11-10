package hm2

import kotlin.math.hypot

data class Complex(val re: Double, val im: Double)

fun myAbs(value: Int): Int = if (value < 0) -value else value

fun myAbs(value: Double): Double = if (value < 0.0) -value else value

// hypot(x, y) обчислює sqrt(x^2 + y^2) без проміжного переповнення
fun myAbs(value: Complex): Double = hypot(value.re, value.im)

fun main() {
    val intVal = -42
    val doubleVal = -3.1415
    val complexVal = Complex(3.0, 4.0)

    println("Int abs: ${myAbs(intVal)}")             // 42
    println("Double abs: ${myAbs(doubleVal)}")       // 3.1415
    println("Complex abs: ${myAbs(complexVal)}")     // 5.0
}