package hm7.Part1

interface Messenger {
    fun sendMessage(message: String)
    fun receiveMessage(): String
}

class BasicMessenger : Messenger {
    override fun sendMessage(message: String) {
        println("Sending message: $message")
    }

    override fun receiveMessage(): String = "You've got a new message!"
}

class SmartMessenger(private val delegate: BasicMessenger) : Messenger by delegate {
    override fun sendMessage(message: String) {
        println("Sending a smart message: $message")
        delegate.sendMessage("{smart} $message")
    }
}

fun main() {
    val basicMessenger = BasicMessenger()
    val smartMessenger = SmartMessenger(basicMessenger)

    basicMessenger.sendMessage("Hello!")
    println(smartMessenger.receiveMessage())
    smartMessenger.sendMessage("Hello from SmartMessenger!")
}
