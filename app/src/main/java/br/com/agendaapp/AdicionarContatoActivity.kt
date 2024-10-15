package br.com.agendaapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import br.com.agendaapp.database.InitDatabase
import br.com.agendaapp.database.models.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdicionarContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_adicionar_contato)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener { finish() }

        val campoNome = findViewById<EditText>(R.id.campoNome)
        val campoSobreNome = findViewById<EditText>(R.id.campoSobrenome)
        val campoCell = findViewById<EditText>(R.id.campoCell)
        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)

        btnAdicionar.setOnClickListener {
            val novoContato = Contato(
                nome = campoNome.text.toString(),
                sobreNome = campoSobreNome.text.toString(),
                cell = campoCell.text.toString(),
            )

            lifecycleScope.launch (Dispatchers.IO){
                val dao = InitDatabase.getDatabase().contatoDao()
                dao.inserir(novoContato)
            }

            Toast.makeText(applicationContext, "Contato salvo!", Toast.LENGTH_SHORT).show()

            campoNome.text.clear()
            campoSobreNome.text.clear()
            campoCell.text.clear()
        }
    }
}