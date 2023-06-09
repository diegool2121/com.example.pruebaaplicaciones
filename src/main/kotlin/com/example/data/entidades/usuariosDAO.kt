package com.example.data.entidades

import com.example.data.modelos.usuarioM
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object usuario: IntIdTable("Usuario"){
    val nombre = varchar("nombre", 50)
    val apellido = varchar("apellido", 50)
    val correo = varchar("correo", 50)
    val contrasena = varchar("contrasena", 50)
    val tipo = varchar("tipo", 50)
    val estado = varchar("estado", 50)
}

class usuariosDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<usuariosDAO>(usuario)
    var nombre by usuario.nombre
    var apellido by usuario.apellido
    var correo by usuario.correo
    var contrasena by usuario.contrasena
    var tipo by usuario.tipo
    var estado by usuario.estado

    fun toUsuario() = usuarioM(
        id.value,
        nombre,
        apellido,
        correo,
        contrasena,
        tipo,
        estado
    )
}

