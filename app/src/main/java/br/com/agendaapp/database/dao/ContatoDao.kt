package br.com.agendaapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.agendaapp.database.models.Contato

@Dao
interface ContatoDao {
    @Query("SELECT * FROM contato ORDER BY nome ASC")
    fun buscarContatos(): List<Contato>

    @Insert
    fun inserir(contato: Contato)
}