package com.example.data.modelos

import kotlinx.serialization.Serializable

@Serializable
data class usuarioM(
    var id: Int,
    val nombre: String,
    val apellido: String,
    val correo: String,
    val contrasena: String,
    val tipo: String,
    val estado: String
)
