package br.com.agendaapp.database

import android.content.Context
import androidx.room.Room
import br.com.agendaapp.database.db.ContatoDb
import br.com.agendaapp.database.models.Contato

object InitDatabase {
    private lateinit var roomDatabase: ContatoDb

    fun init(context: Context) {
        roomDatabase = Room.databaseBuilder(
            context,
            ContatoDb::class.java,
            "contato-db"
        ).build()
    }

    fun getDatabase() = roomDatabase
}