package com.example.data

abstract class clase_base_repositorios <T,ID>{
    abstract fun listar(): List<T>?
    abstract fun crear(t: T): T
    abstract fun actualizar(t: T): T
    abstract fun eliminar(id: ID): Boolean
    abstract fun buscar_por_id(id: ID): T
}