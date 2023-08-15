package com.metamask.dapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.metamask.dapp.ui.theme.MetaMaskAndroidDappTheme
import dagger.hilt.android.AndroidEntryPoint
import io.metamask.androidsdk.EthereumViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val screenViewModel: ScreensViewModel by viewModels()
    private val ethereumViewModel: EthereumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MetaMaskAndroidDappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Setup(ethereumViewModel, screenViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MetaMaskAndroidDappTheme {
        Greeting("Android")
    }
}