package com.example.vodovoz.Presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vodovoz.Network.RetrofitClient
import com.example.vodovoz.Network.VodovozApi
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    init {
        getItems()
    }

    fun getItems(){
        val api = RetrofitClient.getInstance().create(VodovozApi::class.java)
        viewModelScope.launch {
            try {
                val response = api.getItems("topglav")
                Log.d("VodovozOk", response.TOVARY.toString())
            }catch (e: Exception){
                Log.d("VodovozError", e.toString())
            }
        }
    }
}