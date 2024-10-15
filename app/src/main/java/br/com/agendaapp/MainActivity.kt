package br.com.agendaapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.agendaapp.database.InitDatabase
import br.com.agendaapp.database.adapter.ContatoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var rvContato: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        rvContato = findViewById<RecyclerView>(R.id.rvContatos)

        rvContato.layoutManager = LinearLayoutManager(this@MainActivity)

        val botaoAdd = findViewById<FloatingActionButton>(R.id.botaoAdd)

        botaoAdd.setOnClickListener{
            val intent = Intent(this, AdicionarContatoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch(Dispatchers.IO) {
            val dao = InitDatabase.getDatabase().contatoDao()
            val listaDeContatos = dao.buscarContatos()

            withContext(Dispatchers.Main) {
                rvContato.adapter = ContatoAdapter(listaDeContatos)
            }
        }
    }
}