package com.movie.fridaymovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import com.movie.fridaymovie.ui.FridayMovieApp
import com.movie.fridaymovie.ui.theme.FridayMovieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FridayMovieTheme {
                FridayMovieApp()
            }
        }
    }
}
