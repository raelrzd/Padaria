package tcc.projeto.padaria.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import tcc.projeto.myapplication.R
import tcc.projeto.myapplication.databinding.ActivityConfirmarPedidoBinding
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.listaCarrinho
import tcc.projeto.padaria.ui.activity.HomeActivity.Companion.totalCompra

class ConfirmarPedidoActivity : AppCompatActivity() {

    // Binding para inflar layout e declarar componentes do mesmo
    private lateinit var binding: ActivityConfirmarPedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflandoLayout()

        inicializaValoresTotalCompra()

        configuraOpcaoEntrega()

        configuraOpcaoRetirada()

        configuraBotaoConfirmar()
    }

    private fun configuraBotaoConfirmar() {
        val botaoConfirmar = binding.confirmar
        botaoConfirmar.setOnClickListener {
            if (binding.viewEntrega.visibility == View.VISIBLE) {
                totalCompra += 2
            }
            startActivity(Intent(this, PagamentoActivity::class.java))
        }
    }

    private fun configuraOpcaoRetirada() {
        val opcaoRetirada = binding.retirada
        opcaoRetirada.setOnClickListener {
            binding.viewRetirada.visibility = View.VISIBLE
            binding.constraintRetirar.visibility = View.VISIBLE
            binding.viewEntrega.visibility = View.GONE
            binding.constraintEntrega.visibility = View.GONE
            binding.valor.text = "R$ ${totalCompra}"
        }
    }

    private fun configuraOpcaoEntrega() {
        val opcaoEntrega = binding.entrega
        opcaoEntrega.setOnClickListener {
            binding.viewEntrega.visibility = View.VISIBLE
            binding.constraintEntrega.visibility = View.VISIBLE
            binding.viewRetirada.visibility = View.GONE
            binding.constraintRetirar.visibility = View.GONE
            binding.valor.text = "R$ ${totalCompra + 2}"
        }
    }

    private fun inicializaValoresTotalCompra() {
        binding.itens.text = "${listaCarrinho.size} itens  "
        binding.valor.text = "R$ ${totalCompra + 2}"
    }

    private fun inflandoLayout() {
        binding = ActivityConfirmarPedidoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}