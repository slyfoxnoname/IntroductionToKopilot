package HW3

import java.util.Locale

fun main() {
    val rawLogs = listOf(
        "2026-09-01 INFO: User logged in",
        "2026-09-01 ERROR: 500 Internal Server Error",
        "2026-09-01 WARN: High memory usage",
        "2026-09-01 ERROR: 404 Not Found",
        "2026-09-01 INFO: Payment processed"
    )

    var infoCount = 0
    var warnCount = 0
    var errorCount = 0
    val errorMessages = mutableListOf<String>()

    for (log in rawLogs) {
        when {
            log.contains("INFO:") -> infoCount++
            log.contains("WARN:") -> warnCount++
            log.contains("ERROR:") -> {
                errorCount++
                errorMessages.add(log)
            }
        }
    }

    val totalLogs = rawLogs.size
    val errorPercentage = if (totalLogs > 0) (errorCount.toDouble() / totalLogs) * 100 else 0.0
    val formattedErrorRate = String.format(Locale.US, "%.2f", errorPercentage)

    val report = """
        Загальна кількість логів : $totalLogs
        /                                              \
        Кількість [INFO]         : $infoCount
        Кількість [WARN]         : $warnCount
        Кількість [ERROR]        : $errorCount
        Відсоток помилок         : $formattedErrorRate%
        \                                              /
        Список виявлених помилок:
        ${if (errorMessages.isEmpty()) "Помилок не виявлено." else errorMessages.joinToString("\n") { " - $it" }}
    """.trimIndent()

    println(report)
}