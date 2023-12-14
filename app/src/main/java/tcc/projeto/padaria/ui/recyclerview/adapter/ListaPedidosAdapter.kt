package tcc.projeto.padaria.ui.recyclerview.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import tcc.projeto.myapplication.R
import tcc.projeto.myapplication.databinding.ItemProdutoBinding
import tcc.projeto.padaria.model.Produto
import tcc.projeto.padaria.ui.activity.HomeActivity

// Classe que configura a apresentação da lista do RecyclerView
class ListaPedidosAdapter(private val context: Context, val produtos: List<Produto>) :
    RecyclerView.Adapter<ListaPedidosAdapter.ViewHolder>() {

    // Variavel declarada para busca de imagens no projeto
    val resources: Resources = context.resources


    // Classe que configura cada item da lista
    inner class ViewHolder(private val binding: ItemProdutoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var produto: Produto

        // Preenche os itens da lista a partir de seus componentes
        fun vincula(produto: Produto) {
            this.produto = produto
            val nome = binding.produtoItemNome
            nome.text = produto.nome
            val preco = binding.produtoItemValor
            preco.text = "R$ ${produto.preco.toString()}"
            val imagem = binding.produtoItemImageview
            val nameImage = produto.imagem
            val resourceId = resources.getIdentifier(nameImage, "drawable", context.packageName)
            imagem.setImageResource(resourceId)
            binding.iconSelecionado.visibility = View.GONE
        }

    }


    // Metodo que configura o layout que será criado cada item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemProdutoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    // Metodo que configura da onde virão as informações para preencher os itens da lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    // Metodo que retorna o tamanho da lista
    override fun getItemCount(): Int {
        return produtos.size
    }


}




