package tcc.projeto.padaria.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tcc.projeto.myapplication.databinding.FragmentHomeBinding
import tcc.projeto.padaria.ui.activity.ConfirmarPedidoActivity
import tcc.projeto.padaria.ui.activity.HomeActivity
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.listaCarrinho
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.totalCompra
import tcc.projeto.padaria.ui.recyclerview.adapter.ListaProdutosAdapter


class HomeFragment : Fragment() {

    // Declarando adapter e recycler view para configuração e apresentação da lista
    private lateinit var adapter: ListaProdutosAdapter
    private lateinit var recyclerView: RecyclerView

    // Binding para inflar o layout e declarar seus componentes
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflandoLayout(inflater, container)

        configuraRecyclerView()

        configuraTotalPedido()

        configuraCliqueItemLista()

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
            listaCarrinho.clear()
            configuraTotalPedido()
        }
    }

    private fun configuraCliqueItemLista() {
        adapter.quandoClicaNoItem = {
            listaCarrinho.add(it)
            configuraTotalPedido()
        }
    }

    private fun configuraRecyclerView() {
        recyclerView = binding.listaHome
        adapter = ListaProdutosAdapter(requireContext())
        val manager = LinearLayoutManager(activity)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
    }

    private fun inflandoLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ConstraintLayout {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    fun configuraTotalPedido() {
        val cardviewTotal = binding.cardviewTotal
        if (listaCarrinho.isNotEmpty()) {
            totalCompra = 0.0
            cardviewTotal.visibility = View.VISIBLE
            listaCarrinho.forEach {
                totalCompra += it.preco
            }
            binding.valor.text = "R$ $totalCompra"
        } else {
            cardviewTotal.visibility = View.GONE
        }
    }


}