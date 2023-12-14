package tcc.projeto.padaria.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.delay
import tcc.projeto.myapplication.R
import tcc.projeto.myapplication.databinding.ActivityMainBinding
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    //Binding para inflar layout e declarar seus componentes
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflando o layout
        setContentView(binding.root)

        //Pop-up que aparece na tela
        Toast.makeText(this, "Clique na tela para prosseguir", Toast.LENGTH_LONG).show()


        configuraCliqueProsseguir()
    }

    private fun configuraCliqueProsseguir() {
        binding.layout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}