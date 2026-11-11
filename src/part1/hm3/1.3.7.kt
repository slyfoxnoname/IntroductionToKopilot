package hm3

import java.util.Locale

fun main() {
    val serverLogs = listOf(
        "2026-10-12 INFO: Сервер успішно запущено на порту 8080",
        "2026-10-12 ERROR: Не вдалося підключитися до бази даних",
        "2026-10-12 WARN: Використання оперативної пам'яті перевищило 80%",
        "2026-10-12 INFO: Користувач admin виконав вхід у систему",
        "2026-10-12 ERROR: Тайм-аут запиту до зовнішнього платіжного шлюзу",
        "2026-10-12 INFO: Резервне копіювання завершено"
    )

    val infoCount = serverLogs.count { "INFO:" in it }
    val warnCount = serverLogs.count { "WARN:" in it }
    val errorLogs = serverLogs.filter { "ERROR:" in it }
    val errorCount = errorLogs.size

    val totalCount = serverLogs.size
    val errorRate = if (totalCount > 0) (errorCount.toDouble() / totalCount) * 100.0 else 0.0
    val formattedRate = String.format(Locale.US, "%.2f", errorRate)

    val errorSection = if (errorLogs.isEmpty()) {
        "Помилок не зафіксовано."
    } else {
        errorLogs.joinToString(separator = "\n") { "  * $it" }
    }

    val summaryReport = """
        ==================================================
        ЗВІТ АНАЛІЗУ СИСТЕМНИХ ЛОГІВ
        ==================================================
        Усього оброблено записів : $totalCount
        Повідомлень [INFO]       : $infoCount
        Попереджень [WARN]       : $warnCount
        Помилок     [ERROR]      : $errorCount
        Частка помилок           : $formattedRate%
        --------------------------------------------------
        Деталізація критичних помилок:
        $errorSection
        ==================================================
    """.trimIndent()

    println(summaryReport)
}
