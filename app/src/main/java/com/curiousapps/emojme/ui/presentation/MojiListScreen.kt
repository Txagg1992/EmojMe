package com.curiousapps.emojme.ui.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.curiousapps.emojme.domain.MoJis
import com.curiousapps.emojme.ui.presentation.MoJiListViewModel.MoJiScreenState
import com.curiousapps.emojme.ui.presentation.component.MoJiDialog
import com.curiousapps.emojme.ui.presentation.component.MoJiRow

@Composable
fun MoJiListScreen(
    viewModel: MoJiListViewModel = hiltViewModel(),
) {

    val context = LocalContext.current
    val state by viewModel.state.collectAsState(initial = MoJiScreenState())
    val moji = state.mojiList
    var showDialog by remember { mutableStateOf(false)}
    GradientBackground()

    if (state.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = Color.Magenta,
                strokeCap = StrokeCap.Round
            )
        }
    } else {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(top = 32.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                val itemCount = moji.size
                items(itemCount) { index ->
                    MoJiRow(
                        moJis = moji[index],
                        modifier = Modifier
                            .clickable {
                                showDialog = true
                                Toast.makeText(context, moji[index].character, Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                    if (showDialog) {
                            MoJiDialog(
                                moJis = moji[index],
                                onDismiss = { showDialog = false },
                            )

                    }


                }
            }
        }

    }// HireMe!@#21

}

@Preview
@Composable
fun MoJiRowPreview() {
    val moji = MoJis(
        character = "\uD83D\uDE03",
        slug = "grinning-face-with-big-eyes",
        codePoint = "1F603",
        group = "smileys-emotion",
        subGroup = "face-smiling",
        unicodeName = "grinning face with big eyes"
    )
    MoJiRow(moJis = moji)
}

@Composable
fun GradientBackground() {
    val gradient = Brush.linearGradient(
        0.0f to Color.Cyan,
        500.0f to Color.Yellow,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient).fillMaxSize())
}