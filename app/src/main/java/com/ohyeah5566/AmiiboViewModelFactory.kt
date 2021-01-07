package com.ohyeah5566

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AmiiboViewModelFactory(private val repository: AmiiboRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AmiiboRepository::class.java)
            .newInstance(repository)
    }
}