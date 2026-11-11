package hm2

import kotlin.math.hypot

// Перевантаження функцій для обчислення модуля цілого, дійсного та комплексного числа
data class Complex(val real: Double, val imaginary: Double)

fun myAbs(number: Int): Int = if (number < 0) -number else number

fun myAbs(number: Double): Double = if (number < 0.0) -number else number

fun myAbs(complex: Complex): Double = hypot(complex.real, complex.imaginary)

fun main() {
    val integerSample = -128
    val doubleSample = -9.81
    val complexSample = Complex(5.0, -12.0)

    println("Модуль цілого числа ($integerSample): ${myAbs(integerSample)}")
    println("Модуль дійсного числа ($doubleSample): ${myAbs(doubleSample)}")
    println("Модуль комплексного числа ($complexSample): ${myAbs(complexSample)}")
}
