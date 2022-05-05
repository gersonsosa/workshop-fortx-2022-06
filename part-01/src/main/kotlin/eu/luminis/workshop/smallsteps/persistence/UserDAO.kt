package eu.luminis.workshop.smallsteps.persistence

import eu.luminis.workshop.smallsteps.api.NewUserRequest
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import java.util.*

// Understands how to perform user operations against the database
class UserDAO {
    suspend fun insertUser(request: NewUserRequest): UUID {
        return nonBlockingTransaction {
            val createdUser = User.new {
                this.email = request.email
                this.password = request.password
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