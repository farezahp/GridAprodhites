package com.example.gridaprodhite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridaprodhite.data.DataSource
import com.example.gridaprodhite.model.Makeup
import com.example.gridaprodhite.ui.theme.GridAprodhiteTheme

sealed class Destination(val route: String) {
    object Splash: Destination("splash")
    object Home: Destination("home")
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Mengatur tema GridAprodhiteTheme untuk seluruh tampilan Activity
            GridAprodhiteTheme {
                // Membungkus tampilan dalam Surface dengan latar belakang sesuai tema
                Surface(
                    modifier = Modifier.fillMaxSize(),  // Mengisi seluruh layar dengan tampilan ini
                    color = MaterialTheme.colorScheme.background  // Mengatur warna latar belakang sesuai tema
                ) {
                    // Menampilkan komponen MakeupGrid dalam tampilan Activity
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}


@Composable
fun NavigationAppHost(navController: NavHostController){
    // NavHost adalah tempat menentukan routing antar layar dalam aplikasi
    NavHost(navController = navController, startDestination = Destination.Home.route){
        // Setiap composable berisi tampilan untuk satu destinasi atau layar
        composable(Destination.Home.route){ HomeScreen(navController) }
        composable(Destination.Splash.route){ SplashScreen(navController) }
    }
}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    // Menggunakan tema GridAprodhiteTheme untuk tampilan komposisi ini
    GridAprodhiteTheme {
        // Mengatur tata letak komponen utama dalam Column
        Column(
            modifier = Modifier.fillMaxSize(),  // Mengisi seluruh layar dengan tata letak ini
            verticalArrangement = Arrangement.Center,  // Menengahkan secara vertikal kontennya
            horizontalAlignment = Alignment.CenterHorizontally  // Menengahkan secara horizontal kontennya
        ) {
            // Menampilkan komponen MakeupGrid dalam tata letak ini
            val navController = rememberNavController()
            NavigationAppHost(navController = navController)
        }
    }
}
