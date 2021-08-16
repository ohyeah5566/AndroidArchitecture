package com.ohyeah5566

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ohyeah5566.api.getPostService
import com.ohyeah5566.data.MainRepository
import com.ohyeah5566.db.PostDatabase

class MainViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            val postDao = PostDatabase.getInstance(context).transactionDao()
            return MainViewModel(
                MainRepository(getPostService(), postDao)
            ) as T
        } else {
            throw ClassNotFoundException("class not found")
        }
    }
}