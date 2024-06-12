package com.adso.databinding.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adso.databinding.Data.UserRepository


class UserViewModelFactory(private val repository: UserRepository)
    :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsuarioViewModel::class.java)){
            return UsuarioViewModel() as T
        }

        throw IllegalArgumentException("Clase View Model Desconocida")
    }


}