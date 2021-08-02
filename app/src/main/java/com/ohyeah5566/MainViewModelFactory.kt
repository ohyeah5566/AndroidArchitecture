package com.ohyeah5566

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                MainRepository(getPostService())
            ) as T
        } else {
            throw ClassNotFoundException("class not found")
        }
    }
}