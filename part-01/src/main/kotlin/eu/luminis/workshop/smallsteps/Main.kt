package eu.luminis.workshop.smallsteps

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

// Runs embedded ktor http server
fun main() {
    embeddedServer(
        Netty,
        port = 8015,
        host = "127.0.0.1",
        module = Application::userAppKtorServerModule
    ).start(wait = true)
}