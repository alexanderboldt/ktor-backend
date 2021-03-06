package com.alex

import com.alex.main.kotlin.feature.Notes
import com.alex.main.kotlin.feature.Root
import com.alex.main.kotlin.utils.MoshiConverter
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.ContentType
import io.ktor.routing.*
import org.slf4j.event.Level

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    // todo: implement an api-key for more security
    // call.request.headers["Api-Key"] = "RcUaL2324juXiR6OW03hX478LXFizFKjCndeunNB"

    install(CallLogging) {
        level = Level.INFO
    }

    install(ContentNegotiation) {
        register(ContentType.Application.Json, MoshiConverter())
    }

    routing(Root.routing())
    routing(Notes.routing())
}