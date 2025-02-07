package com.curiousapps.emojme.ui.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.curiousapps.emojme.domain.MoJis

@Composable
fun MoJiDialog(
    moJis: MoJis,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = moJis.character,
                    fontSize = 100.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Unicode Name: ${moJis.unicodeName}",
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = "Emoji Group: ${moJis.group}",
                    fontSize = 24.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

        }
    }
}

@Preview
@Composable
fun DialogPreview() {
    val moji = MoJis(
        character = "\uD83D\uDE03",
        slug = "",
        codePoint = "",
        group = "smileys-emotion",
        subGroup = "",
        unicodeName = "grinning face with big eyes"
    )

    MoJiDialog(moJis = moji, onDismiss = {})
}