package br.com.agendaapp.database.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.agendaapp.R
import br.com.agendaapp.database.models.Contato

class ContatoAdapter (private val characters: List<Contato> = listOf()) : RecyclerView.Adapter<ContatoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contatos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]

        holder.addItem(character)
    }

    class ViewHolder (item : View) : RecyclerView.ViewHolder(item) {

        val sobreNome = item.findViewById<TextView>(R.id.sobrenome)
        val name = item.findViewById<TextView>(R.id.name)
        val cell = item.findViewById<TextView>(R.id.cell)
        val imagephone = item.findViewById<ImageView>(R.id.iconPhone)

        fun addItem(contato : Contato) {
            name.text = contato.nome
            sobreNome.text = contato.sobreNome
            cell.text = contato.cell

            imagephone.setOnClickListener{
                val numeroTelefone = contato.cell
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$numeroTelefone")
                }

                itemView.context.startActivity(intent)
            }
        }
    }
}
