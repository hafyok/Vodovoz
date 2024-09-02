package com.example.vodovoz.Network

import android.util.Log
import com.example.vodovoz.Network.Entity.Items
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepositoryImpl(private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO) :
    CategoryRepository {
    val api = RetrofitClient.getInstance().create(VodovozApi::class.java)

    override fun getCategories(items: Items): List<String> {
        val names = items.TOVARY.mapNotNull { it.NAME }
        Log.d("VodovozNames", names.toString())
        return names
    }

    suspend fun getItems(): Items {
        return withContext(coroutineDispatcher) {
            try {
                val response = api.getItems("topglav")
                Log.d("VodovozOk", response.TOVARY.toString())
                response
            } catch (e: Exception) {
                Log.d("VodovozError", e.toString())
                Items() // Возвращаем пустой Items в случае ошибки
            }
        }
    }
}