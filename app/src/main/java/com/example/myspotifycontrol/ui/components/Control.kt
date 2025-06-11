package com.example.myspotifycontrol.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspotifycontrol.R


@Preview
@Composable
fun ControlLayout() {

    val shape = RoundedCornerShape(8.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(
                border = BorderStroke(2.dp, Color.Green),
                shape = shape
            )
            .background(Color.Gray, shape)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 52.dp, end = 52.dp, top = 500.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {},
                shape = shape,
                colors = ButtonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray
                ),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_action_previous),
                    contentDescription = "previous"
                )
            }

            Button(
                onClick = {},
                shape = shape,
                colors = ButtonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray
                ),
                modifier = Modifier.offset(y = (-60).dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_action_play_pause),
                    contentDescription = "Play/Pause"
                )
            }

            Button(
                onClick = {},
                shape = shape,
                colors = ButtonColors(
                    containerColor = Color.Green,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray
                ),
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_action_skip),
                    contentDescription = "next"
                )
            }
        }
    }
}
