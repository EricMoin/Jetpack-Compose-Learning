package com.ericmoin.coincurrency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ericmoin.coincurrency.presentation.Screen
import com.ericmoin.coincurrency.presentation.coin_detail.components.CoinDetailScreen
import com.ericmoin.coincurrency.presentation.coin_list.components.CoinListScreen
import com.ericmoin.coincurrency.presentation.theme.CoincurrencyTheme
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoincurrencyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route){
                        composable(route = Screen.CoinListScreen.route){
                            CoinListScreen(navController = navController)
                        }
                        composable(route = "${Screen.CoinDetailScreen.route}/{coinId}"){
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}