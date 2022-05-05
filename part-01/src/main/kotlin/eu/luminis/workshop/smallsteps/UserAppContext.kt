package eu.luminis.workshop.smallsteps

import eu.luminis.workshop.smallsteps.logic.UserService
import eu.luminis.workshop.smallsteps.persistence.DatabaseFactory
import eu.luminis.workshop.smallsteps.persistence.UserDAO

// Understands how to wire up the various components in the system
internal class UserAppContext {
    init {
        DatabaseFactory.connectAndMigrate()
    }

    private val userDAO = UserDAO()

    val userService = UserService(userDAO)
}