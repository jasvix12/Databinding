package com.adso.databinding.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adso.databinding.Usuario



class UsuarioViewModel: ViewModel() {
    private val _usuario = MutableLiveData<Usuario>()
    val usuario: LiveData<Usuario> get() = _usuario

    // Método para actualizar el usuario
    fun actualizarUsuario(nombre: String, edad: Int) {
        val nuevoUsuario = Usuario(nombre, edad.toString())
        _usuario.value = nuevoUsuario
    }
}