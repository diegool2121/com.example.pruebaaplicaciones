package com.example.data
import com.example.data.entidades.usuario
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object conexion_bd {
    fun init(){
        val url = "jdbc:postgresql://localhost:5432/db_Apli"
        val username = "postgres"
        val password = "Qazwsxedc1"
        val driver = "org.postgresql.Driver"

        try {
         Database.connect(url, driver, username, password)
            println("conexion establecida")
            transaction {
                //create table with schema
                SchemaUtils.create(usuario)
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }
}