package hm6.ex2

data class User(val name: String?)

fun getNotificationPreferences(user: Any, emailEnabled: Boolean, smsEnabled: Boolean): List<String> {
    val verifiedUser = user as? User ?: return emptyList()
    val displayName = verifiedUser.name ?: "Guest"

    return listOfNotNull(
        "Email Notifications enabled for $displayName".takeIf { emailEnabled },
        "SMS Notifications enabled for $displayName".takeIf { smsEnabled }
    )
}

fun main() {
    val namedUser = User("Alice")
    val anonymousUser = User(null)
    val nonUserObject = "NotAUser"

    println(getNotificationPreferences(namedUser, emailEnabled = true, smsEnabled = false))
    println(getNotificationPreferences(anonymousUser, emailEnabled = false, smsEnabled = true))
    println(getNotificationPreferences(nonUserObject, emailEnabled = true, smsEnabled = true))
}
