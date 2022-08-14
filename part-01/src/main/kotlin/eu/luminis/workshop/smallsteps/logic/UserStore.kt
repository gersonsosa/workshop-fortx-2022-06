package eu.luminis.workshop.smallsteps.logic

import java.util.*

interface UserStore {
    suspend fun insertUser(userCommand: NewUserCommand): UUID
}