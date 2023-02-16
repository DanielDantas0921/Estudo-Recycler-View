package com.example.aprendizado_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendizado_recyclerview.data.Pedido

class ListSeparadoAdapter() : RecyclerView.Adapter<ListSeparadoAdapter.ListSeparadoViewHolder>() {

   var listaseparadopedido: List<Pedido> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSeparadoAdapter.ListSeparadoViewHolder {
        return ListSeparadoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.lists_separado_item, parent , false)
        )


    }

    override fun onBindViewHolder(holder: ListSeparadoAdapter.ListSeparadoViewHolder, position: Int) {
        holder.bind(listaseparadopedido[position])
    }

    override fun getItemCount(): Int {
       return  listaseparadopedido.size
    }


    class ListSeparadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pedidos: Pedido) {

        itemView.findViewById<TextView>(R.id.list_separado_item_nome_pedido).text = pedidos.nome
       itemView.findViewById<TextView>(R.id.list_separado_item_preco_pedido).text = pedidos.preco.toString()

        }


    }


}