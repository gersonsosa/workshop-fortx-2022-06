package eu.luminis.workshop.smallsteps.logic

// Understands how users can be registered
class UserService(private val userPersistence: UserStore) {
    suspend fun registerNewUser(request: NewUserCommand) {
        userPersistence.insertUser(request)
    }
}

data class Email(val value: String) {
    init {
        require(value.isNotBlank()) { "Please enter an email address" }
    }
}

data class Password(val value: String) {
    init {
        require(value.isNotBlank() && value.length >= 8) { "Password must be at least 8 characters long" }
    }
}

data class NewUserCommand(
    val email: Email,
    val password: Password,
)
