package tcc.projeto.padaria.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import tcc.projeto.myapplication.R
import tcc.projeto.myapplication.databinding.ActivityHomeBinding
import tcc.projeto.padaria.model.Produto

class HomeActivity : AppCompatActivity() {

    //Variaveis globais para utilização em outras classes
    companion object {
        val listaCarrinho = mutableListOf<Produto>()
        var totalCompra = 0.0
        val pedidos = mutableListOf<Produto>()
    }

    // Declaração das variaveis da barra de navegação
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    // Declaração Binding
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inflandoLayout()

        initNavigation()

    }

    private fun inflandoLayout() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun initNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }
}