package io.github.alexswilliams.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.cio.*
import io.ktor.util.logging.*
import io.ktor.utils.io.*
import java.io.File
import java.nio.file.Files
import java.nio.file.attribute.FileAttribute
import java.nio.file.attribute.PosixFilePermission
import kotlin.io.path.Path

const val root = "/mnt/steam/uploads/"

fun Application.configureRouting() {
    routing {
        this.put(Regex("/.+")) {
            val filePath = Path(root, call.request.path())
            val file = filePath.toFile()
            file.parentFile.mkdirs()
            val written = call.receiveChannel()
                .copyAndClose(file.writeChannel())
            println("Write $written to $filePath")
            call.respond(HttpStatusCode.Created, "Created $filePath\n")
        }
        get("/") {
            call.respondText("Running\n")
        }
    }
}
