package tcc.projeto.padaria.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tcc.projeto.myapplication.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    //Binding para inflar o layout
    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}