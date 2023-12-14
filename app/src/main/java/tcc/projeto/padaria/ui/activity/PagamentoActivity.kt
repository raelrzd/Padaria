package tcc.projeto.padaria.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tcc.projeto.myapplication.databinding.ActivityPagamentoBinding
import tcc.projeto.padaria.model.Produto
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.listaCarrinho
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.pedidos
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.totalCompra

class PagamentoActivity : AppCompatActivity() {

    // Binding para inflar layout e declarar seus componentes
    private lateinit var binding: ActivityPagamentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflandoLayout()

        inicializandoValorTotal()

        configuraBotaoConfirmar()
    }

    private fun configuraBotaoConfirmar() {
        binding.confirmar.setOnClickListener {
            val intent = Intent(this, AgradecimentoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun inicializandoValorTotal() {
        binding.itens.text = "${listaCarrinho.size} itens  "
        binding.valor.text = "R$ ${totalCompra}"
    }

    private fun inflandoLayout() {
        binding = ActivityPagamentoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}