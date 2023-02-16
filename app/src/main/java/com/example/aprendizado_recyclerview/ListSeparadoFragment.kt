package com.example.aprendizado_recyclerview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aprendizado_recyclerview.data.Pedido
import com.example.aprendizado_recyclerview.databinding.FragmentListSeparadoBinding

class ListSeparadoFragment: Fragment(R.layout.fragment_list_separado) {

    private var binding: FragmentListSeparadoBinding? = null
    var listapedidos = mutableListOf<Pedido>()
    var listaPedidoAdapter = ListSeparadoAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        listapedidos.add(Pedido("cuscuz", 2.2))
        listapedidos.add(Pedido("macaxeira", 2.2))
        listapedidos.add(Pedido("arroz", 2.2))
        listapedidos.add(Pedido("feijão", 2.2))
        listapedidos.add(Pedido("pizza", 2.2))
        binding = FragmentListSeparadoBinding.bind(view)
        binding?.rvListSeparado?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvListSeparado?.adapter = listaPedidoAdapter
        listaPedidoAdapter.listaseparadopedido = listapedidos


        listaPedidoAdapter.notifyDataSetChanged()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}