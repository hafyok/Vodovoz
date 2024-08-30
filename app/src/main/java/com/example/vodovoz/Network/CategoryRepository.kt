package com.example.vodovoz.Network

interface CategoryRepository {
    fun getCategories(): List<String>
}