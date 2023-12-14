package tcc.projeto.padaria.ui.activity

import android.content.Intent
import android.graphics.Paint.UNDERLINE_TEXT_FLAG
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tcc.projeto.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    //Binding para inflar layout e declarar seus componentes
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflando layout
        setContentView(binding.root)


        configuraBotaoCadastrar()

        configuraBotaoEntrar()
    }

    private fun configuraBotaoEntrar() {
        binding.entrar.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun configuraBotaoCadastrar() {
        val cadastreSe = binding.cadastreSe
        cadastreSe.setPaintFlags(UNDERLINE_TEXT_FLAG)
        cadastreSe.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}