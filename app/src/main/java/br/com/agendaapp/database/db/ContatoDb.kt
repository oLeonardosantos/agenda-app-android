package br.com.agendaapp.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.agendaapp.database.dao.ContatoDao
import br.com.agendaapp.database.models.Contato

@Database(
    entities = [Contato::class],
    version = 1
)
abstract class ContatoDb : RoomDatabase() {
    abstract fun contatoDao(): ContatoDao
}