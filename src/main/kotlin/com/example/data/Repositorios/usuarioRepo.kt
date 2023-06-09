package com.example.data.Repositorios

import com.example.data.clase_base_repositorios
import com.example.data.entidades.usuariosDAO
import com.example.data.modelos.usuarioM
import org.jetbrains.exposed.sql.transactions.transaction


object usuarioRepo: clase_base_repositorios<usuarioM, Int>(){
    override fun crear(entity: usuarioM) = transaction {

        entity.id = usuariosDAO.new {
            nombre = entity.nombre
            apellido = entity.apellido
            correo = entity.correo
            contrasena = entity.contrasena
            tipo = entity.tipo
            estado = entity.estado
        }.id.value
        return@transaction entity
    }

    override fun listar(): List<usuarioM> = transaction {
        return@transaction usuariosDAO.all().map { it.toUsuario() }

    }

    override fun eliminar(id: Int): Boolean = transaction {
        return@transaction when (usuariosDAO.findById(id)) {
            null -> false
            else -> {
                usuariosDAO.findById(id)?.delete()
                true
            }
        }
    }

    override fun actualizar(t: usuarioM): usuarioM {
        usuariosDAO.findById(t.id)?.let {
            it.nombre = t.nombre
            it.apellido = t.apellido
            it.correo = t.correo
            it.contrasena = t.contrasena
            it.tipo = t.tipo
            it.estado = t.estado
            return@actualizar t
        } ?: throw Exception("No existe el usuario con id ${t.id}")
    }
    override fun buscar_por_id(id: Int): usuarioM {
        usuariosDAO.findById(id)?.let {
            return@buscar_por_id it.toUsuario()
        } ?: throw Exception("No existe el usuario con id $id")
    }


}