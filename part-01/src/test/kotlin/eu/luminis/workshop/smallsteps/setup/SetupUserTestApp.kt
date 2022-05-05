package eu.luminis.workshop.smallsteps.setup

import eu.luminis.workshop.smallsteps.userAppKtorServerModule
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*

internal fun ApplicationTestBuilder.setupUserTestApp(): HttpClient {
    application {
        userAppKtorServerModule()
    }

    return createClient {
        install(ContentNegotiation) {
            json()
        }
    }
}