package br.com.agendaapp.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contato (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val nome: String,

    val sobreNome: String,

    val cell: String,
)