package eu.luminis.workshop.smallsteps

import eu.luminis.workshop.smallsteps.api.NewUserRequest
import eu.luminis.workshop.smallsteps.setup.setupUserTestApp
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class UserAppTest {
    @Test
    fun `should fail when missing contentType`() = testApplication {
        val client = setupUserTestApp()

        client.post("/user").apply {
            assertEquals(HttpStatusCode.UnsupportedMediaType, status)
        }
    }

    @Test
    fun `should create user`() = testApplication {
        val client = setupUserTestApp()

        client.post("/user") {
            contentType(ContentType.Application.Json)
            setBody(
                NewUserRequest(
                    email = "harry@example.com",
                    password = "mysecret"
                )
            )
        }.apply {
            assertEquals(HttpStatusCode.Created, status)
        }
    }

    @Test
    fun `should fail for illegal password`() = testApplication {
        val client = setupUserTestApp()

        client.post("/user") {
            contentType(ContentType.Application.Json)
            setBody(
                NewUserRequest(
                    email = "harry@example.com",
                    password = "secret"
                )
            )
        }.apply {
            assertEquals(HttpStatusCode.BadRequest, status)
            assertEquals("Password must be at least 8 characters long", bodyAsText())
        }
    }
}
