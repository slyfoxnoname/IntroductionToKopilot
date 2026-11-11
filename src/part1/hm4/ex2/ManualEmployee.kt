package hm4.ex2

// Ручна реалізація всіх методів, які компілятор генерує для data class
class ManualEmployee(
    val firstName: String,
    val lastName: String,
    val position: String
) {
    var bonus: Int = 0

    override fun toString(): String =
        "ManualEmployee(firstName=$firstName, lastName=$lastName, position=$position)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ManualEmployee) return false

        return firstName == other.firstName &&
            lastName == other.lastName &&
            position == other.position
    }

    override fun hashCode(): Int {
        var hash = firstName.hashCode()
        hash = 31 * hash + lastName.hashCode()
        hash = 31 * hash + position.hashCode()
        return hash
    }

    operator fun component1(): String = firstName
    operator fun component2(): String = lastName
    operator fun component3(): String = position

    fun copy(
        firstName: String = this.firstName,
        lastName: String = this.lastName,
        position: String = this.position
    ): ManualEmployee = ManualEmployee(firstName, lastName, position)
}
