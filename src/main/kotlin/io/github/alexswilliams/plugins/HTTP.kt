package io.github.alexswilliams.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*

fun Application.configureHTTP() {
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowMethod(HttpMethod.Put)
        allowMethod(HttpMethod.Get)
        allowHeader(HttpHeaders.ContentType)
        anyHost()
        this.allowNonSimpleContentTypes = true
        this.allowSameOrigin = true
        this.allowOrigins { true }
    }
}
