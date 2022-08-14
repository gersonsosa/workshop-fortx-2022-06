package eu.luminis.workshop.smallsteps.persistence

import eu.luminis.workshop.smallsteps.api.NewUserRequest
import eu.luminis.workshop.smallsteps.logic.NewUserCommand
import eu.luminis.workshop.smallsteps.logic.UserStore
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import java.util.*

// Understands how to perform user operations against the database
class UserDAO : UserStore {
    override suspend fun insertUser(newUserCommand: NewUserCommand): UUID {
        return nonBlockingTransaction {
            val createdUser = User.new {
                this.email = newUserCommand.email.value
                this.password = newUserCommand.password.value
            }

            createdUser.id.value
        }
    }
}

// Defines table schema using kotlin exposed DSL
object Users : UUIDTable() {
    val email = varchar("email", 100).uniqueIndex()
    val password = varchar("password", 100)
}

// Exposes typical table operations using kotlin exposed
class User(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<User>(Users)

    var email by Users.email
    var password by Users.password
}