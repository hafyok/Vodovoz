package com.example.vodovoz.Network

import com.example.vodovoz.Network.Entity.Items

interface CategoryRepository {
    fun getCategories(items: Items): List<String>
}