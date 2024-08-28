package com.example.vodovoz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.vodovoz.ui.theme.VodovozTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
