package com.movie.fridaymovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.movie.fridaymovie.ui.FridayMovieMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FridayMovieMain()
        }
    }
}
