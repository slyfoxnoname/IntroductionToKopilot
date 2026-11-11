package hm5.ex1

data class User(val id: Int, var email: String)

fun updateEmail(user: User, newEmail: String): User =
    user.apply {
        this.email = newEmail
    }.also { updated ->
        println("Updating email for user with ID: ${updated.id}")
    }

fun main() {
    val account = User(1, "old_email@example.com")
    val modifiedAccount = updateEmail(account, "new_email@example.com")

    println("Updated User: $modifiedAccount")
}
