package com.curiousapps.emojme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.emojme.ui.presentation.MoJiListScreen
import com.curiousapps.emojme.ui.presentation.MoJiListViewModel
import com.curiousapps.emojme.ui.presentation.MoJiListViewModel.MoJiScreenState
import com.curiousapps.emojme.ui.theme.EmojMeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmojMeTheme {
                val viewModel = hiltViewModel<MoJiListViewModel>()
                val state by viewModel.state.collectAsState(initial = MoJiScreenState())
                MoJiListScreen(
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EmojMeTheme {
        Greeting("Android")
    }
}