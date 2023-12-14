package tcc.projeto.padaria.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tcc.projeto.myapplication.R
import tcc.projeto.myapplication.databinding.FragmentHomeBinding
import tcc.projeto.myapplication.databinding.FragmentPedidosBinding
import tcc.projeto.padaria.ui.activity.ConfirmarPedidoActivity
import tcc.projeto.padaria.ui.activity.HomeActivity
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.pedidos
import tcc.projeto.padaria.ui.recyclerview.adapter.ListaPedidosAdapter
import tcc.projeto.padaria.ui.recyclerview.adapter.ListaProdutosAdapter
import tcc.projeto.padaria.ui.recyclerview.adapter.ListaSugestoesAdapter

class PedidosFragment : Fragment() {

    // Declarando adapters e recyclers view para configuração e apresentação da lista
    private lateinit var adapter: ListaSugestoesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapterPedidos: ListaPedidosAdapter
    private lateinit var recyclerViewPedidos: RecyclerView

    // Binding para inflar o layout e declarar seus componentes
    private var _binding: FragmentPedidosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflandoLayout(inflater, container)

        configuraRvListaSugestoes()

        configuraRvListaPedidos()

        configuraTotalPedido()

        configuraBotaoLimparCarrinho()

        configuraBotaoFinalizarCompra()

        return view
    }

    private fun configuraBotaoFinalizarCompra() {
        val botaoFinalizar = binding.finalizar
        botaoFinalizar.setOnClickListener {
            startActivity(Intent(this.context, ConfirmarPedidoActivity::class.java))
        }
    }

    private fun configuraBotaoLimparCarrinho() {
        val botaoLimpar = binding.clear
        botaoLimpar.setOnClickListener {
            HomeActivity.listaCarrinho.clear()
            configuraTotalPedido()
        }
    }

    private fun configuraRvListaPedidos() {
        recyclerViewPedidos = binding.pedidosRv
        adapterPedidos = ListaPedidosAdapter(requireContext(), pedidos)
        val manager1 = LinearLayoutManager(activity)
        recyclerViewPedidos.layoutManager = manager1
        recyclerViewPedidos.adapter = adapterPedidos
    }

    private fun configuraRvListaSugestoes() {
        recyclerView = binding.sugestoesRv
        adapter = ListaSugestoesAdapter(requireContext())
        val manager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    private fun inflandoLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ConstraintLayout {
        _binding = FragmentPedidosBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    fun configuraTotalPedido() {
        val cardviewTotal = binding.cardviewTotal
        if (HomeActivity.listaCarrinho.isNotEmpty()) {
            HomeActivity.totalCompra = 0.0
            cardviewTotal.visibility = View.VISIBLE
            HomeActivity.listaCarrinho.forEach {
                HomeActivity.totalCompra += it.preco
            }
            binding.valor.text = "R$ ${HomeActivity.totalCompra}"
        } else {
            cardviewTotal.visibility = View.GONE
        }
    }

}