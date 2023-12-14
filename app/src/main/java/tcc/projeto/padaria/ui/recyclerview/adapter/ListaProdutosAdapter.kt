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
class ListaProdutosAdapter(private val context: Context,  var quandoClicaNoItem: (produto: Produto) -> Unit = {}) :
    RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    // Lista que representa os produtos
    private val produtos = listOf<Produto>(
        Produto(imagem = "bolo_caseirinho", "Bolo Caseirinho", 19.99),
        Produto(imagem = "bomba", nome = "Bomba de chocolate", preco = 8.00),
        Produto(imagem = "bolo", nome = "Bolo recheado", preco = 9.90),
        Produto(imagem = "paodefrios3", nome = "Pão de frios", preco = 7.90),
        Produto(imagem = "pao_doce", nome = "Pão doce", preco = 12.00),
        Produto(imagem = "fatia_ungra", nome = "Fatia ungra", preco = 5.90),
        Produto(imagem = "bolinhodechuva", nome = "Bolinho de chuva", preco = 7.90),
        Produto(imagem = "carolina", nome = "Carolina", preco = 4.90),
        Produto(imagem = "coxinha", nome = "Coxinha", preco = 8.00),
        Produto(imagem = "sonho", nome = "Sonho", preco = 6.99),
        Produto(imagem = "paofrances", nome = "Pão frânces", preco = 19.90),
        Produto(imagem = "kitfesta", nome = "Kit Festa", preco = 69.90),
        Produto(imagem = "pizza", "Pizza", 29.90),
        Produto(imagem = "combossalgados", nome = "Combos Salgados", preco = 19.90),
        Produto(imagem = "pingado", nome = "Pingado", preco = 4.80),
        Produto(imagem = "achocolatado", nome = "Achocolatado", preco =  4.80)
    )

    // Variavel declarada para busca de imagens no projeto
    val resources: Resources = context.resources

    // Classe que configura cada item da lista
    inner class ViewHolder(private val binding: ItemProdutoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var produto: Produto

        // Declaração do metodo para clique nos item da lista
        init {
            itemView.setOnClickListener {
                if(::produto.isInitialized) {
                    quandoClicaNoItem(produto)
                }
            }
        }

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




