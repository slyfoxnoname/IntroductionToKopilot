package ex2

class ManualEmployee(
    val firstName: String,
    val lastName: String,
    val position: String
) {
    var bonus: Int = 0

    override fun toString(): String {
        return "ManualEmployee(firstName=$firstName, lastName=$lastName, position=$position)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ManualEmployee

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + position.hashCode()
        return result
    }

    operator fun component1(): String = firstName
    operator fun component2(): String = lastName
    operator fun component3(): String = position

    fun copy(
        firstName: String = this.firstName,
        lastName: String = this.lastName,
        position: String = this.position
    ): ManualEmployee {
        return ManualEmployee(firstName, lastName, position)
    }
}