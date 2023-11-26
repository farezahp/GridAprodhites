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
import androidx.navigation.NavController
import com.example.gridaprodhite.data.DataSource
import com.example.gridaprodhite.model.Makeup
import com.example.gridaprodhite.ui.theme.GridAprodhiteTheme


@Composable
fun HomeScreen(navController: NavController) {
    // Menggunakan LazyVerticalGrid untuk menampilkan item dalam tata letak grid
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Mengatur jumlah kolom dalam grid
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
    ) {
        // Menggunakan items untuk mengisi tata letak grid dengan data dari DataSource.makeups
        items(DataSource.makeups) { makeup ->
            // Menampilkan komponen MakeupCard untuk setiap elemen dalam DataSource.makeups
            MakeupCard(makeup)
        }
    }
}

@Composable
fun MakeupCard(makeup: Makeup) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.45f)  // Mengatur lebar Card menjadi 45% dari lebar layar
            .padding(4.dp)  // Memberikan jarak antara card
    ) {
        Row {
            Image(
                painter = painterResource(id = makeup.image),  // Menampilkan gambar makeup dari resource
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)  // Mengatur lebar gambar
                    .height(100.dp)  // Mengatur tinggi gambar
                    .clip(shape = RoundedCornerShape(8.dp)),  // Memberikan sudut berbentuk lingkaran pada gambar
                contentScale = ContentScale.Crop  // Mengatur cara gambar di-render dalam kotak gambar
            )
            Spacer(modifier = Modifier.width(16.dp))  // Spasi horizontal antara gambar dan teks
            Column {
                Text(
                    text = stringResource(id = makeup.name),  // Menampilkan nama makeup dari resource
                    style = TextStyle(
                        fontSize = 10.sp,  // Mengatur ukuran font
                        fontWeight = FontWeight.Bold,  // Mengatur tebal font
                        color = Color.Black  // Mengatur warna teks
                    ),
                    modifier = Modifier.padding(8.dp)  // Memberikan jarak antara teks dan elemen lainnya
                )
                Spacer(modifier = Modifier.height(1.dp))  // Spasi vertikal kecil antara teks
                Text(
                    text = stringResource(id = makeup.brand),  // Menampilkan merek makeup dari resource
                    style = TextStyle(
                        fontSize = 8.sp,  // Mengatur ukuran font
                        fontWeight = FontWeight.Normal,  // Mengatur tebal font
                        color = Color.Gray  // Mengatur warna teks
                    ),
                    modifier = Modifier.padding(8.dp)  // Memberikan jarak antara teks dan elemen lainnya
                )
            }
        }
    }
}
