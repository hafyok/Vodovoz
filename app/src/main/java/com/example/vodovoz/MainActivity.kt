package com.example.vodovoz

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.vodovoz.Network.RetrofitClient
import com.example.vodovoz.Network.VodovozApi
import com.example.vodovoz.ui.theme.VodovozTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = RetrofitClient.getInstance().create(VodovozApi::class.java)
        GlobalScope.launch {
            try {
                val response = api.getItems("topglav")
                Log.d("VodovozOk", response.TOVARY.toString())
            }catch (e: Exception){
                Log.d("VodovozError", e.toString())
            }
        }
        enableEdgeToEdge()
        setContent {
            VodovozTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val categories = listOf("Вода", "Кулеры", "Выбор покупателей")
                    val prices = listOf(640, 360, 2140)
                    MainScreen(categories, prices, Modifier.padding(innerPadding))
                }
            }
        }
    }
}
