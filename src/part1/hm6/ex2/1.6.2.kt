package HW6.ex2

data class User2(val name: String?)

fun getNotificationPreferences(user: Any, emailEnabled: Boolean, smsEnabled: Boolean): List<String> {
    val validUser = user as? User2 ?: return emptyList()
    val userName = validUser.name ?: "Guest"

    return listOfNotNull(
        "Email Notifications enabled for $userName".takeIf { emailEnabled },
        "SMS Notifications enabled for $userName".takeIf { smsEnabled }
    )
}

fun main() {
    val user1 = User2("Alice")
    val user2 = User2(null)
    val invalidUser = "NotAUser"

    println(getNotificationPreferences(user1, emailEnabled = true, smsEnabled = false))
    println(getNotificationPreferences(user2, emailEnabled = false, smsEnabled = true))
    println(getNotificationPreferences(invalidUser, emailEnabled = true, smsEnabled = true))
}