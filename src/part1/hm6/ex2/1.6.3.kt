package hm6.ex2

data class Subscription(val name: String, val isActive: Boolean)

fun getActiveSubscription(subscriptions: List<Subscription>): Subscription? =
    subscriptions.singleOrNull { sub -> sub.isActive }

fun main() {
    val singleActiveList = listOf(
        Subscription("Basic Plan", false),
        Subscription("Premium Plan", true)
    )

    val duplicateActiveList = listOf(
        Subscription("Basic Plan", true),
        Subscription("Premium Plan", true)
    )

    println(getActiveSubscription(singleActiveList))
    println(getActiveSubscription(duplicateActiveList))
}
