package hm6.ex2

data class ActiveUser(val username: String, val isActive: Boolean)

fun getActiveUsernames(users: List<ActiveUser>): List<String> =
    users.mapNotNull { candidate ->
        candidate.takeIf { it.isActive }?.username
    }

fun main() {
    val registeredUsers = listOf(
        ActiveUser("alice123", true),
        ActiveUser("bob_the_builder", false),
        ActiveUser("charlie99", true)
    )

    println(getActiveUsernames(registeredUsers))
}
