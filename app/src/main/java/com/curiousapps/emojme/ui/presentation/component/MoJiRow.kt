package com.curiousapps.emojme.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiousapps.emojme.domain.MoJis

@Composable
fun MoJiRow(
    moJis: MoJis,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(12.dp)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                modifier = modifier.align(Alignment.CenterHorizontally),
                text = moJis.character,
                fontSize = 40.sp,
            )
            Text(
                modifier = modifier.align(Alignment.Start),
                text = moJis.unicodeName,
                fontSize = 24.sp
            )
        }
    }

}

@Preview
@Composable
fun MojiRowPreview(
){
    val moji = MoJis(
        character = "\uD83D\uDE03",
        slug = "",
        codePoint = "",
        group = "smileys-emotion",
        subGroup = "",
        unicodeName = "grinning face with big eyes"
    )
    MoJiRow(
        moJis = moji
    )
}