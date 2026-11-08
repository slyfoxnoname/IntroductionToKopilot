package HW6.ex2

data class User4(val username: String, val isActive: Boolean)

fun getActiveUsernames(users: List<User4>): List<String> {
    return users.mapNotNull { user -> user.takeIf { it.isActive }?.username }
}

fun main() {
    val allUsers = listOf(
        User4("alice123", true),
        User4("bob_the_builder", false),
        User4("charlie99", true)
    )

    println(getActiveUsernames(allUsers))    // [alice123, charlie99]
}