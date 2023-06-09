package com.example.routes

import com.example.data.Repositorios.usuarioRepo
import com.example.data.modelos.usuarioM
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.usuariosRutas(){
    route("/usuarios"){
        get {
            try {
               val usuario = usuarioRepo.listar()
               call.respond(HttpStatusCode.OK, usuario)
           } catch (cause: Throwable) {
               call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
           }
        }
        put {
            val id = call.parameters["id"]?.toIntOrNull() ?:0
            try {
                val usuario = usuarioRepo.buscar_por_id(id)
                if (usuario != null){
                    call.respond(HttpStatusCode.OK, usuario)
                 }else{
                      call.respond(HttpStatusCode.NotFound, "No se encontro el usuario")
                 }
            } catch (cause: Throwable) {
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }

        }
        get {
            try {
                val usuarios = usuarioRepo.listar()
                if (usuarios != null){
                    call.respond(HttpStatusCode.OK, usuarios)
                 }else{
                      call.respond(HttpStatusCode.NotFound, "No se encontro el usuario")
                 }
            } catch (cause: Throwable) {
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }

        }
        post {
            val usuario = call.receive<usuarioM>()
            try {
                val usuario = usuarioRepo.crear(call.receive())
                call.respond(HttpStatusCode.OK, usuario)
            } catch (cause: Throwable) {
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }
        }
        delete {
            val id = call.parameters["id"]?.toIntOrNull() ?:0
            try {
                val usuario = usuarioRepo.buscar_por_id(id)
                if (usuario != null){
                    call.respond(HttpStatusCode.OK, usuario)
                 }else{
                      call.respond(HttpStatusCode.NotFound, "No se encontro el usuario")
                 }
            } catch (cause: Throwable) {
                call.respond(HttpStatusCode.BadRequest, cause.message ?: "Error desconocido")
            }
        }

    }

}