package tcc.projeto.padaria.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tcc.projeto.myapplication.databinding.ActivityAgradecimentoBinding
import tcc.projeto.padaria.model.Produto
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.listaCarrinho
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.pedidos
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.totalCompra

class AgradecimentoActivity : AppCompatActivity() {

    // Binding é um recurso utilizado para inflar o layout da activity, e declarar seus elementos (views) na classe
    private lateinit var binding: ActivityAgradecimentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflandoLayout()

        configuraCliqueCompraFinalizada()

    }

    private fun configuraCliqueCompraFinalizada() {
        binding.constraintAgradecimento.setOnClickListener {
            adicionaItensEmPedidos()
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            listaCarrinho.clear()
            totalCompra = 0.0
            startActivity(intent)
        }
    }

    private fun adicionaItensEmPedidos() {
        pedidos.add(
            Produto(
                listaCarrinho[0].imagem,
                "Compra de ${listaCarrinho.size} itens",
                totalCompra
            )
        )
    }

    private fun inflandoLayout() {
        binding = ActivityAgradecimentoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}