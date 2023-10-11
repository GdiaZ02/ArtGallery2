package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtGalleryApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtGalleryApp() {
    ButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val images = listOf(
        R.drawable.atenis,
        R.drawable.crocodile,
        R.drawable.martin,
        R.drawable.garu,
        R.drawable.ahito,
        R.drawable.knucles
    )
    val imageTexts = listOf(
        stringResource(R.string.atenea),
        stringResource(R.string.crocodile),
        stringResource(R.string.martin),
        stringResource(R.string.garu),
        stringResource(R.string.ahito),
        stringResource(R.string.knucles)
    )
    val imageTopic = listOf(
        stringResource(R.string.cab),
        stringResource(R.string.op),
        stringResource(R.string.mm),
        stringResource(R.string.pucca),
        stringResource(R.string.gf),
        stringResource(R.string.sonic)
    )

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(images[result - 1]),
            contentDescription = result.toString(),
            modifier = Modifier.size(400.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = imageTopic[result - 1], fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = imageTexts[result - 1], fontSize = 18.sp)
        }


        Row(
            modifier = Modifier
                .width(400.dp)
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (result > 1) {
                        result--
                    }
                },
                enabled = result > 1
            ) {
                Text(text = "Previous", fontSize = 16.sp)
            }

            Button(
                onClick = {
                    if (result < images.size) {
                        result++
                    }
                },
                enabled = result < images.size
            ) {
                Text(text = "Next", fontSize = 16.sp)
            }
        }
    }
}