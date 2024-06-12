package com.adso.databinding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.adso.databinging.databinding.ActivityMainBinding
import com.adso.databinging.databinding.ActivityMainBinding.inflate


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val usuarioViewModel: Usuario by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)


        usuario.usuario.observe(this, Observer { usuario ->
            binding.nombreId.text = usuario.nombre
            binding.edadId.text = usuario.edad.toString()
        })

        updateUser()
    }

    fun updateUser() {
        // Actualiza el usuario
        usuarioViewModel.actualizarUsuario("Juan", 25)
    }

}