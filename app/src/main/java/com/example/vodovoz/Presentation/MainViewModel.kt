package com.example.vodovoz.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vodovoz.Network.CategoryRepositoryImpl
import com.example.vodovoz.Network.Entity.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val categoryRepositoryImpl = CategoryRepositoryImpl()

    // StateFlow для хранения Items
    private val _items = MutableStateFlow(Items())
    val items : StateFlow<Items> = _items

    // StateFlow для хранения категорий
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories

    init {
        getItems()
    }

    fun getItems() {
        viewModelScope.launch {
            _items.value = categoryRepositoryImpl.getItems()
            // После получения Items можно обновить категории
            _categories.value = categoryRepositoryImpl.getCategories(_items.value)
        }
    }
}