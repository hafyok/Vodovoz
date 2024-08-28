package com.example.vodovoz.Network

import com.example.vodovoz.Network.Entity.Items
import retrofit2.http.GET
import retrofit2.http.Query

interface VodovozApi {
    @GET("super_top.php")
    suspend fun getItems(
        @Query("action") tovary: String,
    ): Items
}