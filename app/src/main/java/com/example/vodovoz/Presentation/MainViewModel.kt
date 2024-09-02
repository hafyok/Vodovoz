package com.example.vodovoz.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vodovoz.Network.CategoryRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val categoryRepositoryImpl = CategoryRepositoryImpl()

    init {
        getItems()
    }

    fun getItems(){
        viewModelScope.launch {
            categoryRepositoryImpl.getItems()
        }
    }
}