package eu.luminis.workshop.smallsteps.api

import eu.luminis.workshop.smallsteps.logic.Email
import eu.luminis.workshop.smallsteps.logic.NewUserCommand
import eu.luminis.workshop.smallsteps.logic.Password
import eu.luminis.workshop.smallsteps.logic.UserService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

// Defines the REST API for user registrations
fun Route.userRoutes(userService: UserService) {
    route("/user") {
        post {
            val request = call.receive<NewUserRequest>()
            userService.registerNewUser(request.toCommand())
            call.respondText("User registered correctly", status = HttpStatusCode.Created)
        }
    }
}


@Serializable
data class NewUserRequest(
    val email: String,
    val password: String,
) {
    fun toCommand() = NewUserCommand(Email(email), Password(password))
}