package eu.luminis.workshop.smallsteps.logic

import eu.luminis.workshop.smallsteps.api.NewUserRequest
import eu.luminis.workshop.smallsteps.persistence.UserDAO

// Understands how users can be registered
class UserService(private val userPersistence: UserDAO) {
    suspend fun registerNewUser(request: NewUserRequest) {
        require(request.email.isNotBlank()) { "Please enter an email address" }
        require(request.password.isNotBlank() && request.password.length >= 8) { "Password must be at least 8 characters long" }

        userPersistence.insertUser(request)
    }
}