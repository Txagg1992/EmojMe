package com.curiousapps.emojme.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.curiousapps.emojme.domain.MoJis

@Composable
fun MoJiRow(
    moJis: MoJis,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        //horizontalAlignment = Alignment.CenterHorizontally

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
        Divider(
            modifier = Modifier
                .padding(start = 40.dp,
                    end = 40.dp,)
                .padding(8.dp),
            color = Color.Black,
            thickness = 3.dp
        )
    }
}