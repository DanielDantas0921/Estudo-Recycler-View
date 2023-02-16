package com.example.aprendizado_recyclerview

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendizado_recyclerview.data.Carro
import com.example.aprendizado_recyclerview.databinding.FragmentListBinding
import org.w3c.dom.Text

class ListaFragment : Fragment(R.layout.fragment_list) {

    private lateinit var rv_main: RecyclerView
    private var binding: FragmentListBinding? = null



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListBinding.bind(view)
        val listaCarros = mutableListOf<Carro>()
        listaCarros.add(Carro("feio"))
        listaCarros.add(Carro("pato"))
        listaCarros.add(Carro("cisne"))
        listaCarros.add(Carro("dragão"))
        binding?.mainRv?.adapter = MainAdapter(listaCarros)
        binding?.mainRv?.layoutManager = LinearLayoutManager(requireContext())

        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private inner class MainAdapter(private val listaCarros1: List<Carro>) :
        RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): MainAdapter.MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
            val itemCorrent = listaCarros1[position]
            holder.bind(itemCorrent)
        }

        override fun getItemCount(): Int {
            return listaCarros1.size
        }

        private inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: Carro) {
                val textView: TextView = itemView.findViewById(R.id.main_item_modelo)

                textView.setText(item.modelo)

            }

        }

    }

}